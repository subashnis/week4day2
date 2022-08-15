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
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Customer_Service_Options_Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Setup the chromedriver
		WebDriverManager.chromedriver().setup();

		//Launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		Shadow dom=new Shadow(driver);

		//Open Leaftaps
		driver.get("https://login.salesforce.com/");

		//Maximise the browser
		driver.manage().window().maximize();

		//implicitwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// 2. Login with username as "ramkumar.ramaiah@testleaf.com " and password as "Password$123"
		
		// Enter the username as " ramkumar.ramaiah@testleaf.com "
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		
		// Enter the password as " Password$123 "
		driver.findElement(By.id("password")).sendKeys("Password$123");		
		
		
		//	3. Click on Learn More link in Mobile Publisher
		// click on the login button
		driver.findElement(By.id("Login")).click();
		
		// click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("(//span[@dir='ltr'])[2]")).click();		
		
		
//			4. Navigate to the Salesforce Customer Service
		// Switch to the next window using Windowhandles
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> handles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(handles.get(1));
		
		// click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[@onclick='goAhead()']")).click();			
		
		// click on Products using Shadow class and Mousehover on Service
		WebElement shadowElement = dom.findElementByXPath("//span[text()='Products']");
		shadowElement.click();
	
		WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	// Mouse over on Service
	WebElement shadowElement2 = dom.findElementByXPath("//span[text()='Service']");
	waiting.until(ExpectedConditions.elementToBeClickable(shadowElement2));
	
	// Actions
	Actions builder = new Actions(driver);
	builder.moveToElement(shadowElement2).perform();

			
	// Click on Customer Services
	WebElement shadowElement3 = dom.findElementByXPath("//a[text()='Customer Service']");
	builder.click(shadowElement3).perform();
	
	
	// Get the names Of Services Available
	List<WebElement> services = driver.findElements(By.xpath("//ul[@class='page-list page-list-level-2']/li"));
	for (int i = 0; i < services.size(); i++) {
		System.out.println(services.get(i).getText());
	}
	
	// Verify the Title
	String title = driver.getTitle();	
	System.out.println(title);
		
	}

}
