package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class crearCuentaTest {
	private WebDriver driver;
	String email="email_prueba4@gmail.com";
	String name="Benjamin";
	String lastnameS="Cruz";
	String nombre=name + " " + lastnameS;
	By login_name= By.linkText(nombre);
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/driverChrome/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		System.out.println(nombre);

	}
	//TC-015
	@Test
	public void crear_cuenta() throws InterruptedException {
		WebElement login=driver.findElement(By.linkText("Sign in"));
		login.click();
		Thread.sleep(3000);
		WebElement create_email=driver.findElement(By.name("email_create"));
		create_email.sendKeys(email);
		Thread.sleep(2000);
		WebElement boton_create=driver.findElement(By.id("SubmitCreate"));
		boton_create.click();
		Thread.sleep(10000);
		WebElement first_name=driver.findElement(By.cssSelector("input[name='customer_firstname']"));
		first_name.sendKeys(name);
		Thread.sleep(2000);
	    WebElement lastname=driver.findElement(By.cssSelector("input[name='customer_lastname']"));
	    lastname.sendKeys(lastnameS);
		Thread.sleep(2000);
	    WebElement passwd=driver.findElement(By.cssSelector("input[name='passwd']"));
	    passwd.sendKeys("pass123");
		Thread.sleep(2000);
	    WebElement company=driver.findElement(By.cssSelector("input[name='company']"));
	    company.sendKeys("Entel");
		Thread.sleep(2000);
	    WebElement address1=driver.findElement(By.cssSelector("input[name='address1']"));
	    address1.sendKeys("Calle falsa 123");
		Thread.sleep(2000);
	    WebElement address2=driver.findElement(By.cssSelector("input[name='address2']"));
	    address2.sendKeys("Departamento 501");
		Thread.sleep(2000);
	    WebElement city=driver.findElement(By.cssSelector("input[name='city']"));
	    city.sendKeys("Santiago 501");
		Thread.sleep(2000);
	    WebElement postcode=driver.findElement(By.cssSelector("input[name='postcode']"));
	    postcode.sendKeys("00000");
		Thread.sleep(2000);
	    WebElement phone=driver.findElement(By.cssSelector("input[name='phone']"));
	    phone.sendKeys("+5631951578");
		Thread.sleep(2000);
	    Select Country = new Select (driver.findElement(By.id("id_state")));
	    Country.selectByVisibleText("Alaska");
		Thread.sleep(2000);
	    WebElement other=driver.findElement(By.name("other"));
	    other.sendKeys("Comprador serio");
		Thread.sleep(2000);
	    WebElement register=driver.findElement(By.id("submitAccount"));
	    register.click();
	    Thread.sleep(2000);
	    if(driver.findElement(login_name).isDisplayed()) {
			System.out.println("Crear Cuenta ok");
	    }
	    
	    
		}
	
	@After
	public void setout() {
		WebElement sing_out=driver.findElement(By.linkText("Sign out"));
		sing_out.click();
		driver.quit();
		}

}
