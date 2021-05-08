package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "\\D:\\JAR\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	}

	@Test()
	public void selectElement() {
		driver.findElement(By.xpath("//span[@class='hm-icon-label']")).click();
		driver.findElement(By.xpath("//div[text()='Fire TV']")).click();
		driver.findElement(By.xpath("//a[text()='Fire TV Stick 4K']")).click();
		Boolean b = driver.findElement(By.xpath("//span[@id='productTitle']")).isDisplayed();
		System.out.println("Selected main menu display status is " + b);

	}

	@AfterMethod
	public void tearDown() {
		System.out.println("close");
		driver.quit();
	}

}
