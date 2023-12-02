import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.IAssert;

import dev.failsafe.internal.util.Assert;

public class SelIntroduction {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait w =new WebDriverWait(driver,5);
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver_win32/chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		WebElement searchBox = driver.findElement(By.cssSelector("input[type='search']"));
		searchBox.sendKeys("ca");
		List<WebElement> veggies = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0; i<veggies.size(); i++) {
			
			String[] name=veggies.get(i).getText().split("-");
			String formattedname=name[0].trim();
			System.out.println(formattedname);
			if(formattedname.equalsIgnoreCase("Carrot")) {
				
				//select no. of vegetables
				List<WebElement> incrementForVeggies = driver.findElements(By.cssSelector("a.increment"));
				incrementForVeggies.get(i).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				//add vegetables to cart
				List<WebElement> addTocart = driver.findElements(By.xpath("//button[contains(text(),'ADD TO CART')]"));
				addTocart.get(i).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
				w.until(ExpectedConditions.textToBePresentInElementValue(By.className("cart-info"),"112"));
			}
		}
		
		//check out
		//String cartInfo = driver.findElement(By.xpath("//div[@class='cart-info']")).getText();
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
		
		
		
		//driver.quit();
	}

}
