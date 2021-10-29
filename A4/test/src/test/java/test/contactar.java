package test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class contactar {
	private WebDriver driver;
	By contacto= By.xpath(".//*[@class='alert alert-success']");
	By contacto_fail= By.xpath(".//*[@class='alert alert-danger']");

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/driverChrome/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
	
	 @Test
	public void contactar() {
		WebElement contact=driver.findElement(By.linkText("Contact us"));
		contact.click();
		Select id_contact = new Select (driver.findElement(By.id("id_contact")));
		id_contact.selectByVisibleText("Customer service");
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("benjamin.yokese5026@gmail.com");
		WebElement id_order=driver.findElement(By.id("id_order"));
		id_order.sendKeys("benjamin.yokese5026@gmail.com");
		WebElement message=driver.findElement(By.id("message"));
		message.sendKeys("Queja por producto no entregado......");
		WebElement submitMessage=driver.findElement(By.id("submitMessage"));
		submitMessage.click();
			
		WebDriverWait wait=new WebDriverWait(driver,100);
		WebElement contacto_exisitoso=driver.findElement(By.id("center_column"));
		wait.until(ExpectedConditions.visibilityOf(contacto_exisitoso));
		if(driver.findElement(contacto).isDisplayed()) {
	    	System.out.println("El mensaje se ha enviado, Ok");

		}
			
	}
	 
	@Test
	public void contactar_fail() {
		WebElement contact=driver.findElement(By.linkText("Contact us"));
		contact.click();
		Select id_contact = new Select (driver.findElement(By.id("id_contact")));
		id_contact.selectByVisibleText("Customer service");
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("benjamin.yokese5026@gmail.com");
		WebElement id_order=driver.findElement(By.id("id_order"));
		id_order.sendKeys("benjamin.yokese5026@gmail.com");
		WebElement submitMessage=driver.findElement(By.id("submitMessage"));
		submitMessage.click();
		WebDriverWait wait=new WebDriverWait(driver,100);
		WebElement contacto_exisitoso=driver.findElement(By.id("center_column"));
		wait.until(ExpectedConditions.visibilityOf(contacto_exisitoso));
		if(driver.findElement(contacto_fail).isDisplayed()) {
	    	System.out.println("La prueba muestra el mensaje de error al usuario, Ok");

		}
	}
	 
	@After
	public void setout() {
		driver.quit();
	}

}
