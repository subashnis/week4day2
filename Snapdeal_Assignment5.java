package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Snapdeal_Assignment5 {

	private static final boolean True = false;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
//		
//		1. Launch https://www.snapdeal.com/
		
		WebDriverManager.chromedriver().setup();

		//Launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		Shadow dom=new Shadow(driver);

		//Open Snapdeal
		driver.get("https://www.snapdeal.com/");

		//Maximise the browser
		driver.manage().window().maximize();

		//implicitwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Explicit wait
		//Explicit wait
		WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(30));
		
//			2. Go to Mens Fashion
		driver.findElement(By.xpath("(//span[contains(text(),'Men')])[1]")).click();
		
//			3. Go to Sports Shoes
		
		driver.findElement(By.xpath("(//span[contains(text(),'Sports Shoes')])[1]")).click();
		
//			4. Get the count of the sports shoes
		List<WebElement> shoes = driver.findElements(By.xpath("//p[@class='product-title']"));
		int NoOfShoes = shoes.size();
		System.out.println("Count of shoes " + NoOfShoes);
			
//			5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
//			6. Sort by Low to High
		WebElement findElement1 = driver.findElement(By.xpath("//span[text()='Sort by:']"));
		waiting.until(ExpectedConditions.elementToBeClickable(findElement1));
		findElement1.click();
		
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
		
//			7. Check if the items displayed are sorted correctly
		WebElement findElement = driver.findElement(By.xpath("//div[contains(text(),'Price Low To High')]"));
		boolean exists = findElement.isDisplayed();
		if (exists == True) {
			System.out.println("Low to High");
		}
		
//			8.Select the price range (900-1200)
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900");
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(@class, 'price-go-arrow btn')]")).click();
		
//			9.Filter with color Navy 
		//driver.findElement(By.xpath("//div[@data-filtername = 'Color_s']//div//i")).click();
//		WebElement findElement3 = driver.findElement(By.xpath("(//i[@class = 'sd-icon sd-icon-plus'])[1]"));
//		Actions actionScroll = new Actions(driver);
//		actionScroll.scrollToElement(findElement3).perform();
//		waiting.until(ExpectedConditions.elementToBeClickable(findElement3)).click();
		
//		WebElement findElement2 = driver.findElement(By.xpath("//button[@data-filtername = 'Color_s']"));
//		Actions actionScroll = new Actions(driver);
//		actionScroll.scrollToElement(findElement2).perform();
//		waiting.until(ExpectedConditions.elementToBeClickable(findElement2)).click();
//		Thread.sleep(2000);
//		WebElement findElement4 = driver.findElement(By.xpath("//label[@for='Color_s-Navy']/span"));
//		Actions actionScroll1 = new Actions(driver);
//		actionScroll1.scrollToElement(findElement4).perform();		
//		waiting.until(ExpectedConditions.elementToBeClickable(findElement4)).click();
//		WebElement findElement2 = driver.findElement(By.xpath("//button[@data-filtername = 'Color_s']"));
//		Actions actionScroll = new Actions(driver);
//		actionScroll.scrollToElement(findElement2).perform();
//		waiting.until(ExpectedConditions.elementToBeClickable(findElement2)).click();
//		Thread.sleep(2000);
//		
//		Thread.sleep(2000);
//		WebElement findElement2 = driver.findElement(By.xpath("//button[@data-filtername = 'Color_s']"));
//		Actions actionScroll = new Actions(driver);
//		actionScroll.scrollToElement(findElement2).perform();
//		waiting.until(ExpectedConditions.elementToBeClickable(findElement2)).click();
		Thread.sleep(2000);
		
		WebElement navy=driver.findElement(By.xpath("//input[@id='Color_s-Navy']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", navy);
				
//			10 verify the all applied filters 
		List<WebElement> filterItem = driver.findElements(By.xpath("//div[@class='navFiltersPill']"));
		List<WebElement> filterName = driver.findElements(By.xpath("//div[@class='navFiltersPill']/a"));
		for (int i = 0; i < filterItem.size(); i++) {
			System.out.println(filterItem.get(i).getText());
			System.out.println(filterName.get(i).getText());
			
		}
		
		Thread.sleep(2000);
		
//			11. Mouse Hover on first resulting Training shoes
		WebElement findElement2 = driver.findElement(By.xpath("(//img[contains(@class,'product-image')])[1]"));
		Actions hover = new Actions(driver);
		hover.moveToElement(findElement2).perform();
		
		Thread.sleep(2000);		
		
//			12. click QuickView button
		driver.findElement(By.xpath("(//div[contains(@class,'quick-view')])[1]")).click();
		
//			13. Print the cost and the discount percentage
		WebElement Price = driver.findElement(By.xpath("(//div[contains(@class,'product-price')])[1]/span"));
		WebElement discPercent = driver.findElement(By.xpath("(//div[contains(@class,'product-price')])[1]/span[2]"));
		System.out.println("Price Rs. "+Price.getText());
		System.out.println("Discount percentage "+discPercent.getText());
		
		//			14. Take the snapshot of the shoes.
		// for taking the screenshot
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("Suba/snapdeal.png");
		FileUtils.copyFile(source, dest);
		
		
//			15. Close the current window
		driver.close();
		
//			16. Close the main window
		driver.quit();


	}

}
