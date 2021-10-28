package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class crear_cuenta {
	private WebDriver driver;
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/driverChrome/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	//TC-015
	@Test
	public void crear_cuenta() throws InterruptedException {
		WebElement login=driver.findElement(By.linkText("Sign in"));
		login.click();
		WebElement create_email=driver.findElement(By.name("email_create"));
		create_email.sendKeys("email_prueba@gmail.com");
		WebElement boton_create=driver.findElement(By.id("SubmitCreate"));
		boton_create.click();
		Thread.sleep(10000);
		WebElement first_name=driver.findElement(By.cssSelector("input[name='customer_firstname']"));
		first_name.sendKeys("Benjamin");
	    WebElement lastname=driver.findElement(By.cssSelector("input[name='customer_lastname']"));
	    lastname.sendKeys("Cruz");
	    WebElement passwd=driver.findElement(By.cssSelector("input[name='passwd']"));
	    passwd.sendKeys("pass123");
	    WebElement company=driver.findElement(By.cssSelector("input[name='company']"));
	    company.sendKeys("Entel");
	    WebElement address1=driver.findElement(By.cssSelector("input[name='address1']"));
	    address1.sendKeys("Calle falsa 123");
	    WebElement address2=driver.findElement(By.cssSelector("input[name='address2']"));
	    address2.sendKeys("Departamento 501");
	    WebElement city=driver.findElement(By.cssSelector("input[name='city']"));
	    city.sendKeys("Santiago 501");
	    WebElement postcode=driver.findElement(By.cssSelector("input[name='postcode']"));
	    postcode.sendKeys("00000");
	    WebElement phone=driver.findElement(By.cssSelector("input[name='phone']"));
	    phone.sendKeys("+5631951578");
	    Select Country = new Select (driver.findElement(By.id("id_state")));
	    Country.selectByVisibleText("Alaska");
	    WebElement other=driver.findElement(By.name("other"));
	    other.sendKeys("Comprador serio");
	    WebElement register=driver.findElement(By.id("submitAccount"));
	    register.click();
	    
		}
	
	@After
	public void setout() {
		WebElement sing_out=driver.findElement(By.linkText("Sign out"));
		sing_out.click();
		driver.quit();
		}

}
