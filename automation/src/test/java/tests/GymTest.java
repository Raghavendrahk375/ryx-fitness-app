package tests;
import base.BaseTest;
import pages.PlansPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class GymTest extends BaseTest {

	@Test
	public void testSelectMonthlyPlan() {
		PlansPage plansPage = new PlansPage(driver);

		plansPage.clickMonthlyPlan();

		String text = plansPage.getSelectedPlanText();

		Assert.assertEquals(text, "Selected: Monthly Plan");
	}
	
	@Test
	public void testSelectQuarterlyPlan() {
		PlansPage plansPage = new PlansPage(driver);

		plansPage.clickQuarterlyPlan();

		String text = plansPage.getSelectedPlanText();

		Assert.assertEquals(text, "Selected: Quarterly Plan");
	}
	
	@Test
	public void testSelectYearlyPlan() {
		PlansPage plansPage = new PlansPage(driver);

		plansPage.clickYearlyPlan();

		String text = plansPage.getSelectedPlanText();

		Assert.assertEquals(text, "Selected: Yearly Plan");
	}
	
	
	@Test
	public void testPlansVisibility() {
	    PlansPage plansPage = new PlansPage(driver);

	    Assert.assertTrue(plansPage.isMonthlyPlanVisible());
	    Assert.assertTrue(plansPage.isQuarterlyPlanVisible());
	    Assert.assertTrue(plansPage.isYearlyPlanVisible());
	}
	
	@Test
	public void testProceedWithoutSelection() {
	    PlansPage plansPage = new PlansPage(driver);

	    Assert.assertFalse(plansPage.isProceedButtonPresent());
	}
	
}
