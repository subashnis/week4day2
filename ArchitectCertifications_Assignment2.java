package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
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

public class ArchitectCertifications_Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//	1. Launch Salesforce application https://login.salesforce.com/
		
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
		
//			5. Click Resources and mouse hover on Learning On Trailhead
		// focus to next window
		Set<String> windowHandles2 = driver.getWindowHandles();
		
		List<String> listWindows = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(listWindows.get(1));
		
		WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
				
		// click on Resources using Shadow class
		WebElement shadowElement = dom.findElementByXPath("//span[text()='Resources']");
		shadowElement.click();
		
		// Mouse over on Learning On Trailhead
		//WebElement shadowElement1 = dom.findElementByXPath("//span[text()='Resources']");
		WebElement shadowElement2 = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		waiting.until(ExpectedConditions.elementToBeClickable(shadowElement2));
		
		// Actions
		Actions builder = new Actions(driver);
		builder.moveToElement(shadowElement2).perform();
		//builder.click(shadowElement2).perform();
		
//			6. Click on Salesforce Certifications
		WebElement shadowElement3 = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		builder.click(shadowElement3).perform();
		
//			7. Choose Your Role as Salesforce Architect
		driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
		
//			8. Get the Text(Summary) of Salesforce Architect 
		String textSalesForce = driver.findElement(By.xpath("//h1[text()='Salesforce Architect']/following::div[1]")).getText();
		System.out.println("Salesforce summary is " + textSalesForce);
			
	//  9. Get the List of Salesforce Architect Certifications Available
		List<WebElement> certificationsList = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		System.out.println("The salesforce certifications are ");
		for (int i = 0; i < certificationsList.size(); i++) {
			System.out.println(certificationsList.get(i).getText());
		}
		
		// 10. Click on Application Architect
		driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
		
		// 11. Get the List of Certifications available
		List<WebElement> certificationsList1 = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		System.out.println("The Application Architect certifications are ");
		for (int i = 0; i < certificationsList1.size(); i++) {
			System.out.println(certificationsList1.get(i).getText());
		}
		

	}

}
