package pl.psomocnik.Users;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserTest {
    private static WebDriver driver;
    private static Actions actions;

    @BeforeClass
    public static void setup() {    
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.get("https://psomocnik-262113.appspot.com/login");
        actions
                .click(driver.findElement(By.id("username")))
                .sendKeys("admin" + Keys.TAB)
                .sendKeys("123456")
                .click(driver.findElement(By.id("submit")))
                .build().perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("home"));
    }
    @Before
    public void createUser() {

        driver.get("https://psomocnik-262113.appspot.com/addUser");
        actions
                .click(driver.findElement(By.id("username")))
                .sendKeys("Testuser" + Keys.TAB)
                .sendKeys("Testuser@email.com").build().perform();
        Select select = new Select(driver.findElement(By.id("roles")));
        select.selectByVisibleText("USER");

        actions
                .click(driver.findElement(By.id("password")))
                .sendKeys("testpassword" + Keys.TAB)
                .sendKeys("testpassword" + Keys.TAB).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submitCreateUser")));
        actions
                .click(driver.findElement(By.id("submitCreateUser")))
                .build().perform();
    }
    @After
    public void deleteUser(){
        actions
                .click(driver.findElement(By.id("deleteeditedTestuser"))).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteButton")));
        actions
                .click(driver.findElement(By.id("deleteButton"))).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteSubmitButton")));
        actions
                .click(driver.findElement(By.id("deleteSubmitButton"))).build().perform();
        driver.close();
    }
    @Test
    public void editUserTest() {
        actions
            .click(driver.findElement(By.id("editTestuser"))).build().perform();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("email")).clear();

        actions
                .click(driver.findElement(By.id("username")))
                .sendKeys("editedTestuser" + Keys.TAB)
                .sendKeys("editedTestuser@email.com" + Keys.TAB)
                .build()
                .perform();
        Select select = new Select(driver.findElement(By.id("roles")));
        select.selectByVisibleText("MODERATOR");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("editUserSubmit")));
        actions
                .click(driver.findElement(By.id("editUserSubmit"))).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("editUserModalSubmit")));
        actions
                .click(driver.findElement(By.id("editUserModalSubmit"))).build().perform();

        List<WebElement> updatedRow = getUpdatedRow("editedTestuser");

        boolean updatedSuccessful;
        if (updatedRow.get(2).getText().equals("editedTestuser")
                && updatedRow.get(3).getText().equals("editedTestuser@email.com")
                && updatedRow.get(4).getText().equals("MODERATOR")) {
            updatedSuccessful = true;
        } else {
            updatedSuccessful = false;
        }

        Assert.assertTrue("Updating user failed!", updatedSuccessful);
    }

    private List<WebElement> getUpdatedRow(String username) {
        List<WebElement> columns;
        List<WebElement> updatedRow = null;
        List<WebElement> rows = driver.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        for (int i = 0; i < rows.size(); i++) {
            columns = rows.get(i).findElements(By.tagName("td"));
            if (columns.get(2).getText().equals(username)) {
                updatedRow = columns;
            }
        }
        return updatedRow;
    }


}