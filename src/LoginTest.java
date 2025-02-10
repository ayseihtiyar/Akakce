import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTest extends BaseDriver {
    @Test
    public void Positive() {
        driver.get("https://www.akakce.com/");
        driver.findElement(By.linkText("Giriş Yap")).click();
        driver.findElement(By.id("life")).sendKeys(email);
        driver.findElement(By.id("lifp")).sendKeys(password);
        driver.findElement(By.id("lfb")).click();
        WaitAndClose();
    }

    @Test
    public void Negative_01() { // Failed Login Attempt with Incorrect Email and/or Password
        driver.get("https://www.akakce.com/");
        driver.findElement(By.linkText("Giriş Yap")).click();
        driver.findElement(By.id("life")).sendKeys("invalidemail");
        driver.findElement(By.id("lifp")).sendKeys("invalidpassword");
        driver.findElement(By.id("lfb")).click();

        WebElement okayButton = driver.findElement(By.cssSelector("button[onclick='Modal_v8.close()']"));
        wait.until(ExpectedConditions.elementToBeClickable(okayButton));
        if (okayButton.isDisplayed()) {
            System.out.println("The user could not log in to the system. Test successful.");
        } else {
            System.out.println("Test failed!");
        }
        WaitAndClose();
    }

    @Test
    public void Negative_02() { // Failed Login Attempt with Empty (Null) Email and/or Password
        driver.get("https://www.akakce.com/");
        driver.findElement(By.linkText("Giriş Yap")).click();
        driver.findElement(By.id("lfb")).click();

        WebElement okayButton = driver.findElement(By.cssSelector("button[onclick='Modal_v8.close()']"));
        wait.until(ExpectedConditions.elementToBeClickable(okayButton));
        if (okayButton.isDisplayed()) {
            System.out.println("The user could not log in to the system. Test successful.");
        } else {
            System.out.println("Test failed!");
        }
        WaitAndClose();
    }
}