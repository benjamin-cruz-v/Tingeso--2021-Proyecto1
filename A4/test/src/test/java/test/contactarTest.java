package test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class contactarTest {
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
	
	//TC - 013 Enviar un mensaje valido a contacto
	 @Test
	public void contactar() throws InterruptedException {
		WebElement contact=driver.findElement(By.linkText("Contact us"));
		contact.click();
		Thread.sleep(3000);
		Select id_contact = new Select (driver.findElement(By.id("id_contact")));
		id_contact.selectByVisibleText("Customer service");
		Thread.sleep(2000);
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("benjamin.yokese5026@gmail.com");
		Thread.sleep(2000);
		WebElement id_order=driver.findElement(By.id("id_order"));
		Thread.sleep(2000);
		id_order.sendKeys("benjamin.yokese5026@gmail.com");
		WebElement message=driver.findElement(By.id("message"));
		message.sendKeys("Queja por producto no entregado......");
		WebElement submitMessage=driver.findElement(By.id("submitMessage"));
		submitMessage.click();
	    Thread.sleep(3000);

		WebDriverWait wait=new WebDriverWait(driver,100);
		WebElement contacto_exisitoso=driver.findElement(By.id("center_column"));
		wait.until(ExpectedConditions.visibilityOf(contacto_exisitoso));
		if(driver.findElement(contacto).isDisplayed()) {
	    	System.out.println("El mensaje se ha enviado, Ok");
	    	Assert.assertTrue(true);

		}
		else {
			Assert.assertTrue(false);
		}
			
	}
	 
	//TC - 021 Enviar un mensaje vacio a contacto
	@Test
	public void contactar_fail()  throws InterruptedException {
		WebElement contact=driver.findElement(By.linkText("Contact us"));
		contact.click();
		Thread.sleep(3000);
		Select id_contact = new Select (driver.findElement(By.id("id_contact")));
		id_contact.selectByVisibleText("Customer service");
		Thread.sleep(2000);
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("benjamin.yokese5026@gmail.com");
		WebElement id_order=driver.findElement(By.id("id_order"));
		Thread.sleep(2000);
		id_order.sendKeys("benjamin.yokese5026@gmail.com");
		WebElement submitMessage=driver.findElement(By.id("submitMessage")); //Aqui se envia el mensaje pero no se le envia la key con el mensaje.
		submitMessage.click();
		Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(driver,100);
		WebElement contacto_exisitoso=driver.findElement(By.id("center_column"));
		wait.until(ExpectedConditions.visibilityOf(contacto_exisitoso));
		if(driver.findElement(contacto_fail).isDisplayed()) {
	    	System.out.println("La prueba muestra el mensaje de error al usuario, Ok");
	    	Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	 
	@After
	public void setout() {
		driver.quit();
	}

}
