package com.cybertek.tests.TasksSelenium.Tables;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC9_SmartBearDeleteOrder {

    WebDriver driver;

    @BeforeMethod
    public void setUpBrowser() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Open browser and login to SmartBear
        WebOrderUtils.loginToSmartBear(driver);

    }

    @Test
    public void deleteFromList() throws InterruptedException {
        //2. Delete “Mark Smith” from the list
        WebElement markSmith = driver.findElement(By.xpath("//tr[3]/td[1]"));
        markSmith.click();
        WebElement deleteSelected = driver.findElement(By.name("ctl00$MainContent$btnDelete"));
        deleteSelected.click();
        //3. Assert it is deleted from the list
        List<WebElement> names = driver.findElements(By.xpath("//tr//td[2]"));
        for (WebElement each : names) {

            Assert.assertTrue(!each.getText().contains("Mark Smith"), "Test failed");
            System.out.println(each.getText());
        }
    }

    @Test(description = "TC #10: SmartBear edit order")
    public void editOrder() throws InterruptedException {

//2. Click to edit button from the right for “Steve Johns”
        WebElement editButton = driver.findElement(By.xpath("//tr[4]/td[13]"));
        editButton.click();

        WebElement customerNameField = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName"));
        customerNameField.clear();

//3. Change name to “Michael Jordan”
        customerNameField.sendKeys("Michael Jordan");
        Thread.sleep(2000);
//4. Click Update
        WebElement updateButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton"));
        updateButton.click();
//5. Assert “Michael Jordan” is in the list
        List<WebElement> list = driver.findElements(By.xpath("//tr/td[2]"));

        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//tr[4]/td[2]")).getText().equals("Michael Jordan"), "Failed no M J");
        removeName(driver, "Paul Brown" );
    }

@Test
public void removeName(WebDriver driver, String name){
    List<WebElement> names = driver.findElements(By.xpath("//tr//td[2]"));
    names.removeIf(p -> p.getText().equals(name));

}
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }


}
