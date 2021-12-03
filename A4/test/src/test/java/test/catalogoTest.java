package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class catalogoTest {

	private WebDriver driver;
	
	By producto= By.linkText("Faded Short Sleeve T-shirts");
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/driverChrome/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	//TC-014
	//Test que comprueba el funcionamiento del catalogo
	@Test
	public void catalogo() throws InterruptedException {
		WebElement women=driver.findElement(By.linkText("Women"));
		women.click();
		WebElement size=driver.findElement(By.name("layered_id_attribute_group_1"));
		size.click();//Marcar la casilla S
		Thread.sleep(5000);
		WebElement check=driver.findElement(By.xpath(".//*[@src='http://automationpractice.com/img/loader.gif']"));
		if(check.isDisplayed()) {
			System.out.println("Casilla de filtro size si funciona, Ok");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Casilla filtro size no funciona, no muestra productos");
			Assert.assertTrue(false);

		}
		
		size.click(); //Desmarcar la casilla S
		Thread.sleep(3000);
		WebElement color=driver.findElement(By.name("layered_id_attribute_group_13"));
		color.click(); //Se filtra por color Beige
		Thread.sleep(3000);
		if(driver.findElement(producto).isDisplayed()) {
			System.out.println("Casilla filtro color si muestra el producto, Ok");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Casilla filtro size no funciona, no muestra productos");
			Assert.assertTrue(false);

		}
		WebElement style=driver.findElement(By.name("layered_id_feature_11"));
		style.click();//Marcar la casilla Casual en styles
		Thread.sleep(3000);
		WebElement check2=driver.findElement(By.xpath(".//*[@src='http://automationpractice.com/img/loader.gif']"));
		if(check2.isDisplayed()) {
			System.out.println("Casilla de filtro style si funciona, Ok");
			Assert.assertTrue(true);

		}
		else {
			System.out.println("Casilla filtro size no funciona, no muestra productos");
			Assert.assertTrue(false);


		}
		style.click();//Desmarcar la casilla Casual en styles
		Thread.sleep(3000);
		WebElement manufacturacion=driver.findElement(By.name("layered_manufacturer_1"));
		manufacturacion.click();//Marcar la casilla Fashion manufacturer en Manofacturer
		Thread.sleep(3000);
		WebElement check3=driver.findElement(By.xpath(".//*[@src='http://automationpractice.com/img/loader.gif']"));
		if(check3.isDisplayed()) {
			System.out.println("Casilla de filtro manufacturacion si funciona, Ok");
			Assert.assertTrue(true);

		}
		else {
			System.out.println("Casilla filtro size no funciona, no muestra productos");
			Assert.assertTrue(false);

		}
		manufacturacion.click();//Desmarcar la casilla Fashion manufacturer en Manofacturer
		Thread.sleep(3000);
	}
	
	@After
	public void setout() {
		driver.quit();
		}
}
