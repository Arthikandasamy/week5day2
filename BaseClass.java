package testcase;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Week5day2.ReadExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
  public ChromeDriver driver;
  public String excelFileName;
  @DataProvider()
	public String[][] getData() throws IOException
	{
		/*
		 * String[][] data = new String[2][4]; data[0][0]= "Testleaf"; data[0][1]=
		 * "Hari"; data[0][2]= "R"; data[0][3]= "99";
		 * 
		 * data[1][0]= "Testleaf"; data[1][1]= "Sheriba"; data[1][2]= "T"; data[1][3]=
		 * "98"; return data;
		 */
	// return ReadExcel.readData(excelFileName);
		return ReadExcel.readData(excelFileName);
		
	}
  @Parameters({"url", "username", "password"})
  @BeforeMethod
  public void Precondition(String url, String password, String username) {
	  	WebDriverManager.chromedriver().setup() ;
	  	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();	  
  }

  @AfterMethod
  public void Postcondition() {
	  driver.close();
  }

}
