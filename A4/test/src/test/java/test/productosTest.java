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
import org.openqa.selenium.support.ui.Select;


public class productosTest {
	private WebDriver driver;
	By info_producto= By.xpath(".//*[@class='page-product-heading']");
	By car_producto= By.id("cart_summary");

	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/driverChrome/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
		
	@Test
	public void ver_productos()  throws InterruptedException {
		WebElement women=driver.findElement(By.linkText("Women"));
		women.click();
		Thread.sleep(3000);
		List<WebElement> links = driver.findElements(By.xpath(".//*[@class='product_list grid row']/li"));
		int size_link=links.size();
		WebElement[] ropa=new WebElement[size_link] ;
		for(int i=1;i<size_link;i++) {
			ropa[i]=links.get(i);

		}
		Thread.sleep(3000);
		int numero = (int) (Math.random() * size_link);
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(ropa[numero]).build().perform();
		WebElement add_comparar2=ropa[numero].findElement(By.linkText("More"));
		add_comparar2.click();
		Thread.sleep(3000);
		if(driver.findElement(info_producto).isDisplayed()) {
		    System.out.println("Se muestra informacion del producto, Ok");

		}	
	}
	
	
	@Test
	public void agregar_carro() throws InterruptedException {
		WebElement women=driver.findElement(By.linkText("Women"));
		women.click();
		Thread.sleep(3000);
		List<WebElement> links = driver.findElements(By.xpath(".//*[@class='product_list grid row']/li"));
		int size_link=links.size();
		WebElement[] ropa=new WebElement[size_link] ;
		for(int i=1;i<size_link;i++) {
			ropa[i]=links.get(i);

		}
		Thread.sleep(3000);
		int numero = (int) (Math.random() * size_link);
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(ropa[numero]).build().perform();
		WebElement add=ropa[numero].findElement(By.linkText("Add to cart"));
		add.click();
		Thread.sleep(3000);
		WebElement continuar_compra= driver.findElement(By.xpath(".//*[@title='Continue shopping']"));
		continuar_compra.click();
		Thread.sleep(3000);
		WebElement car=driver.findElement(By.xpath(".//*[@title='View my shopping cart']"));
		car.click();
		Thread.sleep(3000);
		if(driver.findElement(car_producto).isDisplayed()) {
		    System.out.println("Producto se agrego al car, Ok");

		}
		else {
		    System.out.println("Producto No se agrego al car");

		}
		
	}

	@After
	public void tearDown() {
		//driver.quit();
	}
	
	
	
	/**
	@Test
	public void busqueda() {
		WebElement search=driver.findElement(By.name("search_query"));
		search.sendKeys("t-shirts");
		WebElement buscar=driver.findElement(By.name("submit_search"));
		buscar.click();
		WebDriverWait wait=new WebDriverWait(driver,100);
		WebElement busqueda=driver.findElement(By.id("center_column"));
		wait.until(ExpectedConditions.visibilityOf(busqueda));
		}
	
	@Test
	public void busqueda_con_error() {
		//driver.get("http://automationpractice.com/index.php");
		WebElement search=driver.findElement(By.name("search_query"));
		search.sendKeys("zapato");
		WebElement buscar=driver.findElement(By.name("submit_search"));
		buscar.click();
		WebDriverWait wait=new WebDriverWait(driver,100);
		WebElement busqueda_con_error=driver.findElement(By.className("heading-counter"));
		wait.until(ExpectedConditions.visibilityOf(busqueda_con_error));
		}
**/
	
}
