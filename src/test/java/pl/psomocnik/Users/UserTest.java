/*package org.springframework.samples.petclinic.Users;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;



public class UserTest {

    public WebDriver startWebDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2018.3.5\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        return driver;
    }

    @Test
    public void createUserTest(){
        Boolean isTestUserInTable=false;

        WebDriver driver=startWebDriver();
        driver.get("http://localhost:8080/addUser");
        Actions actions=new Actions(driver);
        actions.click(driver.findElement(By.id("userName"))).sendKeys("Testuser"+ Keys.TAB)
                                                            .sendKeys("Testuser@email.com"+Keys.TAB)
                                                            .sendKeys("user").build().perform();
        WebElement submit=driver.findElement(By.id("submitAddUser"));
        submit.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/manageUsers");
        String id=getTestUserId(driver);
        try{
            actions.click(driver.findElement(By.id("delete"+id))).build().perform();
            isTestUserInTable=true;
        }
        catch(NoSuchElementException ex){
            isTestUserInTable=false;
        }
        Assert.assertTrue("Creating new user failed!",isTestUserInTable);
        driver.close();

    }
    @Test
    public void deleteUserTest(){
        boolean isTestUserInTable=true;
        WebDriver driver=startWebDriver();
        driver.get("http://localhost:8080/addUser");
        Actions actions=new Actions(driver);
        actions.click(driver.findElement(By.id("userName"))).sendKeys("Testuser"+ Keys.TAB)
            .sendKeys("Testuser@email.com"+Keys.TAB)
            .sendKeys("user").build().perform();
        WebElement submit=driver.findElement(By.id("submitAddUser"));
        submit.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/manageUsers");
        actions.click(driver.findElement(By.id("deleteTestuser"))).build().perform();
        try {
            driver.findElement(By.id("deleteTestuser"));
            isTestUserInTable=true;
        }
        catch(NoSuchElementException ex){
            isTestUserInTable=false;
        }
        Assert.assertTrue("Deleting user failed!",isTestUserInTable);
        driver.close();
    }

    @Test
    public void updateUserTest(){
        WebDriver driver=startWebDriver();
        //create TestUser
        driver.get("http://localhost:8080/addUser");
        Actions actions=new Actions(driver);
        actions.click(driver.findElement(By.id("userName"))).sendKeys("Testuser"+ Keys.TAB)
            .sendKeys("Testuser@email.com"+Keys.TAB)
            .sendKeys("user").build().perform();
        WebElement submit=driver.findElement(By.id("submitAddUser"));
        submit.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/manageUsers");
        String id=getTestUserId(driver);
        actions.click(driver.findElement(By.id("edit"+id))).build().perform();

        //change username
        actions.click(driver.findElement(By.id("editUserName"))).build().perform();
        actions.click(driver.findElement(By.id("editInput"))).sendKeys("ChangedUserName").build().perform();
        actions.click(driver.findElement(By.id("editInputModalSubmit"))).build().perform();

        //change email
        actions.click(driver.findElement(By.id("editEmail"))).build().perform();
        actions.click(driver.findElement(By.id("editInput"))).sendKeys("ChangedEmail@email.com").build().perform();
        actions.click(driver.findElement(By.id("editInputModalSubmit"))).build().perform();

        //change type
        actions.click(driver.findElement(By.id("editType"))).build().perform();
        actions.click(driver.findElement(By.id("editInput"))).sendKeys("admin").build().perform();
        actions.click(driver.findElement(By.id("editInputModalSubmit"))).build().perform();

        //submit changes
        actions.click(driver.findElement(By.id("editUserSubmit"))).build().perform();
        actions.click(driver.findElement(By.id("editUserModalSubmit"))).build().perform();//auto redirect to /manageUsers

        List<WebElement> updatedRow=getUpdatedRow(driver, id);
        boolean updatedSuccesfull;
        if(updatedRow.get(1).getText().equals("ChangedUserName")
            && updatedRow.get(2).getText().equals("ChangedEmail@email.com")
            && updatedRow.get(3).getText().equals("admin")){
            updatedSuccesfull=true;
        }
        else{
            updatedSuccesfull=false;
        }

        Assert.assertTrue("Updating user failed!", updatedSuccesfull);
        actions.click(driver.findElement(By.id("deleteChangedUserName"))).build().perform();
        driver.close();

    }

    private String getTestUserId(WebDriver driver){
        String id = "0";
        List<WebElement> columns;
        List<WebElement> rows=driver.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        for(int i=0; i<rows.size(); i++){
            columns = rows.get(i).findElements(By.tagName("td"));
            if (columns.get(1).getText().equals("Testuser")) {
                id=columns.get(0).getText();
            }
        }
        return id;
    }

    private List<WebElement> getUpdatedRow(WebDriver driver, String id){

        List<WebElement> updatedRow=driver.findElement(By.id(id)).findElements(By.tagName("td"));
        return updatedRow;
    }

}
*/