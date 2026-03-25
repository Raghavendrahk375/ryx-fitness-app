package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class GymTest {
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
	    driver = new ChromeDriver();
	    driver.get("http://localhost:5173");
	}

	@Test
	public void testSelectMonthlyPlan() {
		driver.findElement(By.cssSelector("[data-testid='monthly-plan-btn']")).click();
		WebElement selectedText = driver.findElement(By.cssSelector("[data-testid='selected-plan-text']"));
		assertEquals("Selected: Monthly Plan", selectedText.getText());
		System.out.println("Selected: Monthly Plan");
	}
	
	@Test
	public void testSelectQuarterlyPlan() {
		driver.findElement(By.cssSelector("[data-testid='quarterly-plan-btn']")).click();		
		WebElement selectedText = driver.findElement(By.cssSelector("[data-testid='selected-plan-text']"));
		assertEquals("Selected: Quarterly Plan", selectedText.getText());
		System.out.println("Selected: Quarterly Plan");
	}
	
	@AfterMethod
	public void tearDown() {
	    driver.quit();
	}
}
