package test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class compararTest {

	private WebDriver driver;
	By add_comparar=By.linkText("Add to Compare");
	By add_comparar2=By.linkText("Add to Compare");
	By columna_comparar=By.id("center_column");


	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/driverChrome/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
	// TC-024
	// Test que verificar funcionalidad de comparar
	@Test
	public void comparar() throws InterruptedException {
		WebElement women=driver.findElement(By.linkText("Women"));
		women.click();
		List<WebElement> links = driver.findElements(By.xpath(".//*[@class='product_list grid row']/li"));
		WebElement ropa=links.get(0);
		WebElement ropa2=links.get(1);
		Thread.sleep(5000);
		Actions actionProvider = new Actions(driver);
	    actionProvider.moveToElement(ropa).build().perform();
	    if(driver.findElement(add_comparar).isDisplayed()) {
	    	System.out.println("Test muestra opcion de comparar de producto 1,Ok");
	    	driver.findElement(add_comparar).click();
	    	Assert.assertTrue(true);
	    }
	    else {
	    	System.out.println("Test No muestra opcion de comparar de producto 1");
	    	Assert.assertTrue(false);
	    }
	    
	    Thread.sleep(2000);
		Actions actionProvider2 = new Actions(driver);
		actionProvider2.moveToElement(ropa2).build().perform();
		if(driver.findElement(add_comparar2).isDisplayed()) {
	    	System.out.println("Test muestra opcion de comparar de producto 2,Ok");
	    	driver.findElement(add_comparar2).click();
	    	Assert.assertTrue(true);
	    }
	    else {
	    	System.out.println("Test No muestra opcion de comparar de producto 2");
	    	Assert.assertTrue(false);
	    }

		WebElement butom=driver.findElement(By.xpath(".//*[@class='btn btn-default button button-medium "
				+ "bt_compare bt_compare']"));
        butom.click();
        Thread.sleep(5000);
        if(driver.findElement(columna_comparar).isDisplayed()) {
	    	System.out.println("Test muetra a los productos en comparacion,Ok");
	    	Assert.assertTrue(true);
	    }
	    else {
	    	System.out.println("Test No muestra la comparacion");
	    	Assert.assertTrue(false);
	    }
	}
	
	@After
	public void setout() {
		driver.quit();
		}	

}
