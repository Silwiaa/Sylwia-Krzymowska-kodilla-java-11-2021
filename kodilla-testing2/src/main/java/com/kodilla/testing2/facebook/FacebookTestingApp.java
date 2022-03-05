package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_CREATEACCOUNT = "//div[contains(@class, \"_6ltg\")]/a";
    public static final String XPATH_ACCEPTCOOKIES = "//div[contains(@class, \"_9xo5\")]/button[2]";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");
        Thread.sleep(1000);

        WebElement acceptAllCookiesButton = driver.findElement(By.xpath(XPATH_ACCEPTCOOKIES));
        acceptAllCookiesButton.click();
        Thread.sleep(1000);

        WebElement createAccountButton = driver.findElement(By.xpath(XPATH_CREATEACCOUNT));
        createAccountButton.click();
        Thread.sleep(2000);

        setupSelectOption("day", driver, 18);
        setupSelectOption("month", driver, 8);
        setupSelectOption("year", driver, 35);
    }

    public static void setupSelectOption(String id, WebDriver driver, int value) {
        String xPathSelect = "//*[@id=\"" + id + "\"]";
        WebElement element = driver.findElement(By.xpath(xPathSelect));
        Select select = new Select(element);
        select.selectByIndex(value);
    }
}
