package automationAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Abhibus {

	public static void main(String[] args) throws InterruptedException {
		 ChromeDriver driver=new ChromeDriver();
	      driver.get("https://www.abhibus.com/");
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	      driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Chennai");
	      driver.findElement(By.xpath("//div[text()='Chennai']")).click();
	      driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Bangalore");
	      driver.findElement(By.xpath("//div[text()='Bangalore']")).click();
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//button[text()='Tomorrow']")).click();
	      driver.findElement(By.xpath("//a[text()='Search']")).click();
	      Thread.sleep(2000);
	      WebElement element = driver.findElement(By.xpath("//h5[@class='title']"));
	      String bus = element.getText();
	      System.out.println(bus);
	      driver.findElement(By.xpath("//span[text()='Sleeper']")).click();
	      WebElement element1 = driver.findElement(By.xpath("//div[@class='text-grey']"));
	      String seats = element1.getText();
	      System.out.println(seats);
	      Thread.sleep(1000);
	      driver.findElement(By.xpath("//button[text()='Show Seats']")).click();
	      Thread.sleep(1000);
	      driver.findElement(By.xpath("//span[text()='2UC']")).click();
	      driver.findElement(By.xpath("(//input[@class='primary  '])[2]")).click();
	      driver.findElement(By.xpath("(//input[@class='primary  '])[3]")).click();
	      WebElement price = driver.findElement(By.xpath("//div[@class='seat-fare col auto']"));
	      String Fare = price.getText();
	      System.out.println("Price :"+Fare);
	      WebElement selectedSeat = driver.findElement(By.xpath("//div[@class='selected-seat col auto']/div/div"));
	      String No = selectedSeat.getText();
	      System.out.println("Selected seat no :"+No);
	      Thread.sleep(500);
	      String title =driver.getTitle();
	      if(title.contains("Chennai to Bangalore")) {
	    	  System.out.println(title);
	      }
	      driver.close();
	}

}
