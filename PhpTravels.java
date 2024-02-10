package task22;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhpTravels {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();  //launch the browser
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));    //give webdriver wait to load the page
		
		driver.get("https://phptravels.com/demo/");   //load the url
		
		driver.manage().window().maximize();   //maximize the window
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));    //give a implicit wait
		
		driver.findElement(By.xpath("//input[@class='first_name form-control']")).sendKeys("Ram");     //send values to firstname
		
		
		driver.findElement(By.xpath("//input[@class='last_name form-control']")).sendKeys("Ravi");   //send values to laste name
	
		
		driver.findElement(By.xpath("//input[@class='business_name form-control']")).sendKeys("Automobile");    //send values to bussines name
		
		
		driver.findElement(By.xpath("//input[@class='email form-control']")).sendKeys("Ram003@gmail.com");    //send the values to email
		
		//Doing operations for result
		
		String num1 = driver.findElement(By.id("numb1")).getText();             //get the num1 value
		
		String num2 = driver.findElement(By.id("numb2")).getText();  //get the num2 value
							
		int number1 =Integer.parseInt(num1);    //convert string to int
		
		int number2 =Integer.parseInt(num2); 
		
		int result = number1 + number2;            //add the number
		
		String sum  = Integer.toString(result);       //convert integer to string
		
		driver.findElement(By.id("number")).sendKeys(sum);    //send the result value
					
		WebElement click = driver.findElement(By.id("demo"));     //click the submit button
		click.click();
		
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));     //use Webdriverwait the element click  but it throw timeoutexception so i comment it
	//    wait.until(ExpectedConditions.elementToBeClickable(click));
		
		
	String text = driver.findElement(By.xpath(" //h2[contains(text(),'Instant demo request form')]")).getText();      //get text for verification purpose
	
	if(text.contains("Instant")) {                                   //do the validation
		System.out.println("Form submitted Successfully:"    +text);
	} else {
		System.out.println("Form not submitted");
	}
															//to take the Screenchot
	TakesScreenshot ts = (TakesScreenshot) driver;
	Thread.sleep(3000);
	File source =ts.getScreenshotAs(OutputType.FILE);
	
	File destination =new File("C:\\Users\\MOORTHI\\eclipse-workspace\\Exceloperations\\Screenshot\\phptravels.png");    //give file destination
	
	FileUtils.copyFile(source, destination);
	
		
	driver.close();    //close the tab
		
		
			
		
		

	}

}
