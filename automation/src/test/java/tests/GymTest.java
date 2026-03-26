package tests;
import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.PlansPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;

public class GymTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(GymTest.class);

//	@Test
//	public void testSelectMonthlyPlan() {
//		PlansPage plansPage = new PlansPage(driver);
//
//		plansPage.clickMonthlyPlan();
//
//		String text = plansPage.getSelectedPlanText();
//
//		Assert.assertEquals(text, "Selected: Monthly Plan");
//	}
//	
//	@Test
//	public void testSelectQuarterlyPlan() {
//		PlansPage plansPage = new PlansPage(driver);
//
//		plansPage.clickQuarterlyPlan();
//
//		String text = plansPage.getSelectedPlanText();
//
//		Assert.assertEquals(text, "Selected: Quarterly Plan");
//	}
//	
//	@Test
//	public void testSelectYearlyPlan() {
//		PlansPage plansPage = new PlansPage(driver);
//
//		plansPage.clickYearlyPlan();
//
//		String text = plansPage.getSelectedPlanText();
//
//		Assert.assertEquals(text, "Selected: Yearly Plan");
//	}
	
	
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
	
	@DataProvider(name = "planData")
	public Object[][] getPlanData() {
	    return new Object[][] {
	        {"monthly", "Selected: Monthly Plan"},
	        {"quarterly", "Selected: Quarterly Plan"},
	        {"yearly", "Selected: Yearly Plan"}
	    };
	}
	
	@Test(dataProvider = "planData")
	public void testPlanSelection(String planType, String expectedText) {
	    PlansPage plansPage = new PlansPage(driver);
	    logger.info("Selecting plan: " + planType);
	    plansPage.selectPlan(planType);
	    logger.info("Validating selected plan...");

	    String actualText = plansPage.getSelectedPlanText();
	    Assert.assertEquals(actualText, expectedText, "Plan selection failed!");
	    logger.info("Test passed for: " + planType);
	}
}
