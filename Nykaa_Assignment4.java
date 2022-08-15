package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Nykaa_Assignment4 {

	public static void main(String[] args) throws InterruptedException {

		
		// TODO Auto-generated method stub

//		1) Go to https://www.nykaa.com/
		//Setup the chromedriver
				WebDriverManager.chromedriver().setup();

				//Launch the browser
				ChromeDriver driver = new ChromeDriver();
				
				Shadow dom=new Shadow(driver);

				//Open Leaftaps
				driver.get("https://www.nykaa.com/");

				//Maximise the browser
				driver.manage().window().maximize();

				//implicitwait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//Explicit wait
				WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(30));
		
//			2) Mouseover on Brands and Search L'Oreal Paris
				WebElement element1 = driver.findElement(By.xpath("//a[text()='brands']"));
								
				// Actions
				Actions builder = new Actions(driver);
				builder.moveToElement(element1).perform();
					
//			3) Click L'Oreal Paris
				// WebElement findElement1 = driver.findElement(By.xpath("//a[text()='L'Oreal Paris']"));
				WebElement findElement1 = driver.findElement(By.xpath("//a[contains(text(),'Paris')]"));
				waiting.until(ExpectedConditions.elementToBeClickable(findElement1));
				findElement1.click();
				
//			4) Check the title contains L'Oreal Paris(Hint-GetTitle)
				String title = driver.getTitle();
				System.out.println(title);
								
//			5) Click sort By and select customer top rated
				driver.findElement(By.xpath("//span[@class='sort-name']")).click();
				WebElement findElementTopRated = driver.findElement(By.xpath("//span[text()='customer top rated']"));
				waiting.until(ExpectedConditions.elementToBeClickable(findElementTopRated));
				findElementTopRated.click();
				
				Thread.sleep(2000);
				
//			6) Click Category and click Hair->Click haircare->Shampoo
				WebElement findElementCategory = driver.findElement(By.xpath("//span[text()='Category']"));
				waiting.until(ExpectedConditions.elementToBeClickable(findElementCategory));
				//waiting.until(null)
				findElementCategory.click();
				
				WebElement findElementHair = driver.findElement(By.xpath("//span[text()='Hair']"));
				waiting.until(ExpectedConditions.elementToBeClickable(findElementHair));
				findElementHair.click();
				
				WebElement findElementHairCare = driver.findElement(By.xpath("//span[text()='Hair Care']"));
				waiting.until(ExpectedConditions.elementToBeClickable(findElementHairCare));
				findElementHairCare.click();
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[text()='Shampoo']/following::div[1]")).click();
				
//			7) Click->Concern->Color Protection
				WebElement findElement18 = driver.findElement(By.xpath("//span[text()='Concern']"));
				waiting.until(ExpectedConditions.elementToBeClickable(findElement18));
				findElement18.click();
				driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
				
//			8)check whether the Filter is applied with Shampoo
				String text = driver.findElement(By.xpath("//span[text()='Filters Applied']/following::span[1]")).getText();
				if (text.contains("Shampoo")) {
					System.out.println("Shampoo is in filters applied");
				}
				
				Thread.sleep(2000);
				
//			9) Click on L'Oreal Paris Colour Protect Shampoo
				WebElement findElement4 = driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect Shampoo')]"));
				waiting.until(ExpectedConditions.elementToBeClickable(findElement4));
				findElement4.click();
				
//			10) Go to the new window and select size as 175ml
				// Switch to the next window using Windowhandles
				Set<String> windowHandles = driver.getWindowHandles();			
				List<String> handles = new ArrayList<String>(windowHandles);
				driver.switchTo().window(handles.get(1));
				
				WebElement findElement5 = driver.findElement(By.xpath("//select[@title='SIZE']"));
				findElement5.click();
				Thread.sleep(2000);
				Select se4 = new Select(driver.findElement(By.xpath("//select[@title='SIZE']")));
				se4.selectByVisibleText("175ml");
												
//			11) Print the MRP of the product
				WebElement findElement6 = driver.findElement(By.xpath("//span[text()='MRP:']/following::span"));
				System.out.println(findElement6.getText());
				
				Thread.sleep(2000);
				
//			12) Click on ADD to BAG
				driver.findElement(By.xpath("//span[@class='btn-text']")).click();
							
//			13) Go to Shopping Bag 
				driver.findElement(By.xpath("//span[@class='cart-count']")).click();
									
				Thread.sleep(2000);
//			14) Print the Grand Total amount
				// switch to shopping bag frame
				driver.switchTo().frame(0);						
				// WebElement findElementTotal = driver.findElement(By.xpath("//p[text()='You Pay']/following::p[1]"));
				WebElement findElementTotal = driver.findElement(By.xpath("(//span[text()='Grand Total']/following::div)[1]"));
						
				waiting.until(ExpectedConditions.visibilityOf(findElementTotal));
				String grandTotalPrevious = findElementTotal.getText();
				
				System.out.println("Grand Total " + grandTotalPrevious);
				
//			15) Click Proceed
				driver.findElement(By.xpath("//span[text()='Proceed']")).click();
						
//			16) Click on Continue as Guest
				driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
							
//			17) Check if this grand total is the same in step 14
				String grandTotal = driver.findElement(By.xpath("(//div[text()='Grand Total']/following::div)[1]/span")).getText();
				System.out.println(grandTotal);
				if (grandTotalPrevious.contains(grandTotal)) {
					System.out.println("Grand Total same");
				}
						
//			18) Close all windows
				driver.quit();		

	}

}
