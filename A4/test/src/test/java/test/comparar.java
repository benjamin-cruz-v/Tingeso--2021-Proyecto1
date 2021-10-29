package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class comparar {

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
	public void comparar()  throws InterruptedException {
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
	    }
	    else {
	    	System.out.println("Test No muestra opcion de comparar de producto 1");
	    }
	    driver.findElement(add_comparar).click();
	    
		Actions actionProvider2 = new Actions(driver);
		actionProvider2.moveToElement(ropa2).build().perform();
		if(driver.findElement(add_comparar2).isDisplayed()) {
	    	System.out.println("Test muestra opcion de comparar de producto 2,Ok");
	    }
	    else {
	    	System.out.println("Test No muestra opcion de comparar de producto 2");
	    }
	    driver.findElement(add_comparar2).click();

		WebElement butom=driver.findElement(By.xpath(".//*[@class='btn btn-default button button-medium "
				+ "bt_compare bt_compare']"));
        butom.click();
        
        if(driver.findElement(columna_comparar).isDisplayed()) {
	    	System.out.println("Test muetra a los productos en comparacion,Ok");
	    }
	    else {
	    	System.out.println("Test No muestra la comparacion");
	    }
	}
	
	@After
	public void setout() {
		driver.quit();
		}	

}
