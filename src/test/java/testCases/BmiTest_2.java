package testCases;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/* in this version, the test gets the browser parameter from
 * the testng.xml file */ 
public class BmiTest_2 {
	DesiredCapabilities dCap = null;
	
	//take input parameter from testng.xml suite definition
	@Parameters({"browser"})
	//could also pass multiple params as @Parameters({"x","y"})
	@Test
	public void EnterCalorieDetails(String Browser) throws IOException, InterruptedException{
		if (Browser.equals("chrome")){
			dCap = DesiredCapabilities.chrome();	
			//	cap.setPlatform(Platform.WIN10);
			//  cap.setVersion("");
		}else if(Browser.equals("firefox")){
			dCap = DesiredCapabilities.firefox();
		}
		//use RemoteWebDriver with selenium-server-standalone
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dCap);
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("BMI")).click();
		WebElement bmiElement = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[5]/div[1]/font[1]/b[1]"));
		String bmiRange = bmiElement.getText();
		System.out.println("bmi value = " + bmiRange);
		Assert.assertEquals(bmiRange,"Normal");
		Thread.sleep(2000);
		driver.quit();	
	}
}
