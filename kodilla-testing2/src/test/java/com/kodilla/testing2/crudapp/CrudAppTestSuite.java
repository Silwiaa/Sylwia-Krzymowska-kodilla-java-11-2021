package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudAppTestSuite {

    private static final String BASE_URL = "https://silwiaa.github.io/";
    private WebDriver driver;
    private Random generator;

    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    public void cleanUpAfterTest() {
        driver.close();
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        deleteTestTask(taskName);
        assertTrue(checkExistsInCrudApp(taskName));

    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"createTask\")]/fieldset[3]/button";

        String taskName = "Task number " + generator.nextInt(100);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();

        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);
                    WebElement buttonCreateCard = theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });

        Thread.sleep(2000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_LOGIN_URL = "https://trello.com/login";
        final String TRELLO_URL = "https://trello.com/b/84tzrMV2/kodilla-application";
        final String XPATH_SSOLOGIN_URL = "//*[@id=\"use-sso-button\"]";
        final String ATLASSIAN_URL = "https://id.atlassian.com/login?application=trello " +
                "&continue=https%3A%2F%2Ftrello.com%2Fauth%2Fatlassian%2Fcallback%3FreturnUrl%3D%252F%26display%3D%26aaOnboarding%3D%26updateEmail%3D%26traceId%3D6223432be288635ea6dc3675979ea378%26migrateGoogle%3D%26ssoVerified%3D" +
                "&email=s.krzymowska%40gmail.com" +
                "&errorCode" +
                "&login_hint=s.krzymowska%40gmail.com" +
                "&restrict=true";

        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);

        driverTrello.get(TRELLO_LOGIN_URL);

        driverTrello.findElement(By.xpath(XPATH_SSOLOGIN_URL)).click();

        driverTrello.findElement(By.id("user")).sendKeys("s.krzymowska@gmail.com");
        driverTrello.findElement(By.id("login")).submit();
        Thread.sleep(2000);

        driverTrello.get(ATLASSIAN_URL);

        driverTrello.findElement(By.id("password")).sendKeys("KodillaAppCrud");
        driverTrello.findElement(By.id("login-submit")).click();
        Thread.sleep(2000);

        driverTrello.findElements(By.xpath("//div[@class=\"board-tile-details is-badged\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath("//div[@title=\"Kodilla Application\"]")).size() > 0)
                .forEach(WebElement::click);
        Thread.sleep(2000);

        driverTrello.get(TRELLO_URL);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .anyMatch(theSpan -> theSpan.getText().equals(taskName));

        driverTrello.close();

        return result;
    }

    private void deleteTestTask(String taskName) {
        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().equals(taskName))
                .forEach(button -> button.findElement(By.xpath(".//button[4]")).click());
    }

    private boolean checkExistsInCrudApp(String taskName) {
        driver.navigate().refresh();

        int x = driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().equals(taskName))
                .collect(Collectors.toList()).size();

        if (x > 0) {
            return false;
        }
        return true;
    }
}