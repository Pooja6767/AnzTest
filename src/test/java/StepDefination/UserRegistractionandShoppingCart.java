package StepDefination;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class UserRegistractionandShoppingCart {

	 static WebDriver driver;
	 static String elementValue;
	 static String productName;
	 static String password;

@Given("I am on the website homepage")
public void i_am_on_the_website_homepage() {
    // Write code here that turns the phrase above into concrete actions
	try {  
	System.setProperty("webdriver.chrome.driver", "Documents/chromedriver.exe");

      // Initialize the WebDriver
       driver = new ChromeDriver();

    
          // Navigate to the website
          driver.get("https://automationteststore.com/");
          Thread.sleep(2000);
          driver.manage().window().maximize();
			Thread.sleep(3000);
			
			System.out.println("Step 1: Website launched successfully and landed to website home page");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

@When("I click on Sign in on the landing page and Register button")
public void i_click_on_on_the_landing_page() {
	try {
	   WebElement signInButton = driver.findElement(By.xpath("//*[@id='customer_menu_top']/li/a"));
       signInButton.click();
       Thread.sleep(3000);
       WebElement RegisterBtn = driver.findElement(By.xpath("//*[@id='accountFrm']/fieldset/button"));
       RegisterBtn.click();
       System.out.println("Step 2: Clicked on Sign in and Register button");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

@When("I create an account with a random email address and personal information")
public void i_create_an_account_with_a_random_email_address() {
    // Write code here that turns the phrase above into concrete actions
	  // Generate a random email address for registration
	 try {
		 Thread.sleep(2000);
		
    String email = "testuser" + System.currentTimeMillis() + "@example.com";
    String fname= getRandomString(5);
    String lname=getRandomString(5);
    String adr1="random lane";
    elementValue = fname;
    // Enter email address and click "Create an Account"
    WebElement frtname = driver.findElement(By.xpath("//*[@id='AccountFrm_firstname']"));
   
	
    frtname.sendKeys(fname);
    WebElement lstname = driver.findElement(By.xpath("//*[@id='AccountFrm_lastname']"));
    lstname.sendKeys(lname);
    WebElement emailInput = driver.findElement(By.xpath("//*[@id='AccountFrm_email']"));
    emailInput.sendKeys(email);
    WebElement Adrln1 = driver.findElement(By.xpath("//*[@id='AccountFrm_address_1']"));
    Adrln1.sendKeys(adr1);
    WebElement city = driver.findElement(By.xpath("  //*[@id='AccountFrm_city']"));
    city.sendKeys("Grangetown");
    
   WebElement state=driver.findElement(By.xpath("//*[@id='AccountFrm_zone_id']")); 
    Select selectBox = new Select(state);
	Thread.sleep(1000);
	selectBox.selectByVisibleText("Cardiff");
	Thread.sleep(1000);
	 WebElement zipcode=driver.findElement(By.xpath("//*[@id='AccountFrm_postcode']")); 
	 zipcode.sendKeys("TS6");
	 
	 WebElement loginNm=driver.findElement(By.xpath("//*[@id='AccountFrm_loginname']")); 
	 loginNm.sendKeys(getRandomString(8));
	 
	 
	 WebElement logpass=driver.findElement(By.xpath("//*[@id='AccountFrm_password']")); 
	 logpass.sendKeys();
	 
	 WebElement Confirmpass=driver.findElement(By.xpath("//*[@id='AccountFrm_confirm']")); 
	 Confirmpass.sendKeys("556715");
	  
	 WebElement privCheck=driver.findElement(By.xpath("//*[@id='AccountFrm_agree']")); 
	 privCheck.click();
	
	 
	 System.out.println("Step 3: User able to create account with Random email and details");
	 } 
    catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}



@When("I click on the Continue button")
public void i_click_on_the_button() {
	 WebElement ctnBtn=driver.findElement(By.xpath("//*[@id='AccountFrm']/div[5]/div/div/button")); 
	 ctnBtn.click();

	 System.out.println("Step 4: User able to click on continue button");
}

@Then("I should see my correct name and surname displayed on the landing screen")
public void i_should_see_my_correct_name_and_surname_displayed_on_the_landing_screen() {
	 WebElement usrnm=driver.findElement(By.xpath("//*[@id='customer_menu_top']/li/a/div")); 
	 String output=usrnm.getText();
	 String Final=output.substring(13);
	 Assert.assertEquals(Final, elementValue);
	 System.out.println("Step 5: User able to validate correct name on the landing page");
}

@When("I add a product to the cart")
public void i_add_a_product_to_the_cart() throws InterruptedException {
	WebElement prodtype=driver.findElement(By.xpath("//*[@id='categorymenu']/nav/ul/li[7]/a")); 
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((10)));// added because of selenium 4.4
		if ((prodtype != null)) {
			Actions act = new Actions(driver);
			wait.until(ExpectedConditions.visibilityOf(prodtype));
			act.moveToElement(prodtype).perform();
		}
		 WebElement subType=driver.findElement(By.xpath("//*[@id='categorymenu']/nav/ul/li[7]/div/ul[1]/li[1]/a")); 
		 subType.click();
		Thread.sleep(3000);
		 WebElement chkbtn=driver.findElement(By.xpath("//*[@id='maincontainer']/div/div/div/div/div[2]/div[2]/div[1]/div/a")); 
		 wait.until(ExpectedConditions.visibilityOf(chkbtn));
		 chkbtn.click();
		 
		 WebElement prodname=driver.findElement(By.xpath("//*[@id='product_details']/div/div[2]/div/div/h1/span")); 
		 productName=prodname.getText();
		 System.out.println("Step 6: User able to add product to cart");
		
}

@When("I proceed to the checkout page")
public void i_proceed_to_the_checkout_page() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((6)));
	 WebElement chkbtn1=driver.findElement(By.xpath("//*[@id='product']/fieldset/div[5]/ul/li/a")); 
	 wait.until(ExpectedConditions.visibilityOf(chkbtn1));
	 chkbtn1.click();
	 System.out.println("Step 7: User proceeds to checkout page");
	
}

@When("I continue until the payment page")
public void i_continue_until_the_payment_page() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((6)));
	 WebElement checkout=driver.findElement(By.xpath("//*[@id='cart_checkout1']")); 
	 wait.until(ExpectedConditions.visibilityOf(checkout));
	 checkout.click();
	 System.out.println("Step 8: User is able to proceed till the checkout page");
}


@Then("I should see that the product details are correct on the payments page")
public void i_should_see_that_the_product_details_are_correct_on_the_payments_page() throws InterruptedException {
	
	WebElement prodExp=driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div[1]/div/div[2]/table[3]/tbody/tr/td[2]/a")); 
	 String prodEx=prodExp.getText();
	 Assert.assertEquals(productName, prodEx);
	 Thread.sleep(5000);
	 driver.quit();
	 System.out.println("Step 9: User able to verify product details on payments page");
}

public static String getRandomString(int length) {
	String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";
	StringBuilder sb = new StringBuilder(length);
	for (int i = 0; i < length; i++) {
		int index = (int) (AlphaNumericString.length() * Math.random());
		sb.append(AlphaNumericString.charAt(index));
	}
	return sb.toString();
}

}
