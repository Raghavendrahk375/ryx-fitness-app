package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlansPage {

    WebDriver driver;

    public PlansPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By monthlyPlanBtn = By.cssSelector("[data-testid='monthly-plan-btn']");
    By quarterlyPlanBtn = By.cssSelector("[data-testid='quarterly-plan-btn']");
    By yearlyPlanBtn = By.cssSelector("[data-testid='yearly-plan-btn']");
    By selectedPlanText = By.cssSelector("[data-testid='selected-plan-text']");

    // Actions
    public void clickMonthlyPlan() {
        driver.findElement(monthlyPlanBtn).click();
    }

    public void clickQuarterlyPlan() {
        driver.findElement(quarterlyPlanBtn).click();
    }
    
    public void clickYearlyPlan() {
        driver.findElement(yearlyPlanBtn).click();
    }

    public String getSelectedPlanText() {
        return driver.findElement(selectedPlanText).getText();
    }
    
    public boolean isMonthlyPlanVisible() {
        return driver.findElement(monthlyPlanBtn).isDisplayed();
          
    }
    
    public boolean isQuarterlyPlanVisible() {
        return driver.findElement(quarterlyPlanBtn).isDisplayed();
    }
    
    public boolean isYearlyPlanVisible() {
        return driver.findElement(By.cssSelector("[data-testid='yearly-plan-btn']")).isDisplayed();
    }
    public boolean isProceedButtonPresent() {
        return driver.findElements(By.cssSelector("[data-testid='proceed-payment-btn']")).size() > 0;
    }
}