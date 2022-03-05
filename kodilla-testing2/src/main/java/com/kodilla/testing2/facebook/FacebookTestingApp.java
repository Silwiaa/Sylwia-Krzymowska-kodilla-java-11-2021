package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_CREATEACCOUNT = "//div[contains(@class, \"_6ltg\")]/a";
    public static final String XPATH_ACCEPTCOOKIES = "//div[contains(@class, \"_9xo5\")]/button[2]";
    public static final String XPATH_DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    public static final String XPATH_MONTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";
    public static final String XPATH_YEAR = "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement acceptAllCookiesButton = driver.findElement(By.xpath(XPATH_ACCEPTCOOKIES));
        WebElement createAccountButton = driver.findElement(By.xpath(XPATH_CREATEACCOUNT));

        if (acceptAllCookiesButton.isDisplayed()) {
            acceptAllCookiesButton.click();
        }

        createAccountButton.click();

        WebElement day = driver.findElement(By.xpath(XPATH_DAY));
        WebElement month = driver.findElement(By.xpath(XPATH_MONTH));
        WebElement year = driver.findElement(By.xpath(XPATH_YEAR));

        Select selectDay = new Select(day);
        Select selectMonth = new Select(month);
        Select selectYear = new Select(year);

        selectDay.selectByIndex(18);
        selectMonth.selectByIndex(8);
        selectYear.selectByIndex(35);
    }
}
