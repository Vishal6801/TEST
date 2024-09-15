package automationAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesForceDelete {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("vinothkumar@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SeleniumChallenge@24");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.findElement(By.xpath("//div[@class ='slds-r2']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
		driver.findElement(By.xpath("//p[text() ='Sales']")).click();
		WebElement clickLead = driver.findElement(By.xpath("//span[text() ='Opportunities']"));
		driver.executeScript("arguments[0].click()", clickLead);
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Salesforce Automation by Vishal");
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']//a[@role='button']"));
		driver.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		WebElement delete = driver.findElement(By.xpath("//a[@title='Delete']/div"));
		driver.executeScript("arguments[0].click();", delete);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		Thread.sleep(1000);
		WebElement OpportunityFound = driver.findElement(By.xpath("//a[text()='Salesforce Automation by Vishal']"));
        String text = OpportunityFound.getText();
		if(text.equals("Salesforce Automation by Vishal")) {
			System.out.println("Opportunity is Found");
		}
		else {
			System.out.println("Opportunity is deleted");
		}
	
	}

}
