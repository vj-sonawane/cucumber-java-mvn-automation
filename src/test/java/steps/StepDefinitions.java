package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StepDefinitions {

    public static WebDriver driver;

    public static ChromeOptions options;

    @Given("User is at the SauceDemo LogIn page")
    public void navigateToLoginPage() {
        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome.exe");
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @When("User enter the login credentials as {string} and {string}")
    public void loginCredentials(String userName, String password) {
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(password);
    }

    @And("Click on the Log in button")
    public void clickOnTheLogInButton() {
        driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
    }

    @Then("Successful LogIn message should display")
    public void successful_log_in_message_should_display() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()=\"Swag Labs\"]")).click();
    }

    @Given("User is on the Inventory page")
    public void user_is_on_the_inventory_page() {
        String exp = "Swag Labs";
        String act = driver.findElement(By.xpath("//div[text()=\"Swag Labs\"]")).getText();
        System.out.println("Expected Heading: "+exp);
        System.out.println("Actual Heading: " + act);
        Assert.assertEquals(exp,act);
    }

    protected String product = new StringBuilder()
            .append("//button[@name=\"")
            .append("<<Replacement>>")
            .append("\"]").toString();

    public void addProducts(String productName) throws InterruptedException {
        String path = product.replace("<<Replacement>>",productName);
        System.out.println("Dynamic xpath :" + path);
        driver.findElement(By.xpath(path)).click();
    }

    @When("User add two products to cart {string} and {string}")
    public void user_add_two_products_to_cart_and(String product1, String product2) throws InterruptedException {
        addProducts(product1);
        addProducts(product2);
    }
    @When("Click on the bucket symbol at the right corner")
    public void click_on_the_bucket_symbol_at_the_right_corner() {
        driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
    }
    @Then("Click on checkout to navigate to checkout page")
    public void click_on_checkout_to_navigate_to_checkout_page() {
        driver.findElement(By.xpath("//button[@id=\"checkout\"]")).click();
    }

    @Given("User is on the checkout page")
    public void user_is_on_the_checkout_page() {
        String exp = "Checkout: Your Information";
        String act = driver.findElement(By.xpath("//span[text()=\"Checkout: Your Information\"]")).getText();
        System.out.println("Expected Text: "+exp);
        System.out.println("Actual Text: " + act);
        Assert.assertEquals(exp,act);
    }
    @When("User enter details {string} {string} and {string} click on Continue button")
    public void user_enter_details_and_click_on_continue_button(String firstName, String Lastname, String pinCode) {
        driver.findElement(By.xpath("//input[@id=\"first-name\"]")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id=\"last-name\"]")).sendKeys(Lastname);
        driver.findElement(By.xpath("//input[@id=\"postal-code\"]")).sendKeys(pinCode);
        driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
    }
    @When("User check the bill details and Finish the transaction")
    public void user_check_the_bill_details_and_finish_the_transaction() {
        driver.findElement(By.xpath("//button[@name=\"finish\"]")).click();
    }
    @Then("User see Thank You message for order completion")
    public void user_see_thank_you_message_for_order_completion() {
        String exp = "Thank you for your order!";
        String act = driver.findElement(By.xpath("//h2[text()=\"Thank you for your order!\"]")).getText();
        System.out.println("Expected Message: "+exp);
        System.out.println("Actual Message: " + act);
        Assert.assertEquals(exp,act);
    }

}
