package testcase;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Week5day2.ReadExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass
	{
		@Test(dataProvider="getData")
		public void Createmethod(String company, String Fname, String Lname, String PhNo) {
	
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Hari");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("99");
		driver.findElement(By.name("submitButton")).click();
		
}
		
		}







