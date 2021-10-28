package test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class comprar {
private WebDriver driver;
	
	@Before
	public void setUp() {
		System.out.println("Inicio de test de Comprar:");
		System.setProperty("webdriver.chrome.driver","./src/test/resources/driverChrome/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		WebElement sig_in=driver.findElement(By.linkText("Sign in"));
		sig_in.click();
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("benjamin.yokese5026@gmail.com");
		WebElement password=driver.findElement(By.id("passwd"));
		password.sendKeys("pass123");
		WebElement login=driver.findElement(By.name("SubmitLogin"));
		login.click();
	}
	
	//TC-023
	//Test realizar una compra en la pagina web
	@Test
	public void comprar()  throws InterruptedException {
		WebElement women=driver.findElement(By.linkText("Women"));
		women.click();
		WebElement producto=driver.findElement(By.linkText("Blouse"));
		producto.click();
		WebElement data=driver.findElement(By.xpath(".//*[@class='page-product-box']"));
		if(data.isDisplayed()) {
			System.out.println("Se ha seleccionado un producto");
		}
		else {
			System.out.println("No se ha seleccionado un producto");

		}
		WebElement add_car=driver.findElement(By.name("Submit"));
		add_car.click();
		Thread.sleep(7000);
		WebElement checkout=driver.findElement(By.xpath(".//*[@class='btn btn-default button button-medium']"));
		checkout.click();
		WebElement checkout2=driver.findElement(By.linkText("Proceed to checkout"));
		checkout2.click();
		WebElement checkoutAddress=driver.findElement(By.name("processAddress"));
		checkoutAddress.click();
		WebElement terminos=driver.findElement(By.id("cgv"));
		terminos.click();
		WebElement processCarrier=driver.findElement(By.name("processCarrier"));
		processCarrier.click();
		WebElement pay=driver.findElement(By.xpath(".//*[@class='bankwire']"));
		pay.click();
		Thread.sleep(2000);
		WebElement comfirmar=driver.findElement(By.xpath(".//*[@class='button btn btn-default button-medium']"));
		comfirmar.click();
		WebElement compra_realizada=driver.findElement(By.xpath(".//*[@class='box']"));
		if(compra_realizada.isDisplayed()) {
			System.out.println("Se confirma la compra del producto");

		}
		else {
			System.out.println("Compra No realizada");

		}
		
	}
	
	@After
	public void setout() {
		WebElement sing_out=driver.findElement(By.linkText("Sign out"));
		sing_out.click();
		driver.quit();
		}
}
