import Utility.*;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.List;

public class UserAccountCreationTest extends BaseDriver {

    @Test
    public void Positive() {
        driver.get("https://www.akakce.com/");
        driver.findElement(By.linkText("Hesap Aç")).click();
        driver.findElement(By.id("rnufn")).sendKeys(name);
        driver.findElement(By.id("rnufs")).sendKeys(surname);
        driver.findElement(By.id("rnufe1")).sendKeys(email);
        driver.findElement(By.id("rnufe2")).sendKeys(email);
        driver.findElement(By.id("rnufp1")).sendKeys(password);
        driver.findElement(By.id("rnufp2")).sendKeys(password);
        driver.findElement(By.id("rngf")).click();

        WebElement city = driver.findElement(By.cssSelector("select[id='locpr']"));
        Select citySel = new Select(city);
        citySel.selectByValue("7");

        WebElement city2 = driver.findElement(By.cssSelector("select[id='locds']"));
        Select city2select = new Select(city2);
        city2select.selectByValue("85");

        WebElement day = driver.findElement(By.cssSelector("select[id='bd']"));
        Select dayselect = new Select(day);
        dayselect.selectByValue("10");

        WebElement month = driver.findElement(By.cssSelector("select[id='bm']"));
        Select monthSelect = new Select(month);
        monthSelect.selectByValue("11");

        WebElement year = driver.findElement(By.cssSelector("select[id='by']"));
        Select yearSelect = new Select(year);
        yearSelect.selectByValue("2000");

        driver.findElement(By.id("rnufpca")).click();
        driver.findElement(By.id("rfb")).click();
        WaitAndClose();
    }

    @Test
    public void Negative() { // Failed account creation scenario with empty name.
        driver.get("https://www.akakce.com/");
        driver.findElement(By.linkText("Hesap Aç")).click();
       // driver.findElement(By.id("rnufn")).sendKeys(name);
        driver.findElement(By.id("rnufs")).sendKeys(surname);
        driver.findElement(By.id("rnufe1")).sendKeys(email);
        driver.findElement(By.id("rnufe2")).sendKeys(email);
        driver.findElement(By.id("rnufp1")).sendKeys(password);
        driver.findElement(By.id("rnufp2")).sendKeys(password);
        driver.findElement(By.id("rngf")).click();
        driver.findElement(By.id("rnufpca")).click();
        driver.findElement(By.id("rfb")).click();

        List<WebElement> fault = driver.findElements(By.cssSelector("div[class='alertX t2'] p"));
        WebElement okayButton = driver.findElement(By.cssSelector("button[onclick='Modal_v8.close()']"));
        wait.until(ExpectedConditions.elementToBeClickable(okayButton));
        if (fault.isEmpty()) {
            System.out.println("Test failed!");
        } else {
            System.out.println("Error message: " + fault.getFirst().getText());
        }
        okayButton.click();
        WaitAndClose();
    }
}