import Utility.BaseDriver;
import org.junit.*;
import org.openqa.selenium.*;

import java.util.List;

public class AccountDeletionTest extends BaseDriver {
    @Test
    public void Positive() {
        driver.get("https://www.akakce.com/");
        driver.findElement(By.linkText("Giriş Yap")).click();
        driver.findElement(By.id("life")).sendKeys(email);
        driver.findElement(By.id("lifp")).sendKeys(password);
        driver.findElement(By.id("lfb")).click();
        driver.findElement(By.linkText("Test")).click();
        driver.findElement(By.linkText("Hesabımı Sil")).click();
        driver.findElement(By.cssSelector("input[id='p']")).sendKeys(password + Keys.ENTER);

        WebElement condition = driver.findElement(By.cssSelector("div[id='C4w'] i"));
        Assert.assertEquals("Failed to delete account!", "Hesabın silindi", condition.getText().substring(0, 15));
        System.out.println(condition.getText().substring(0, 15));
        WaitAndClose();
    }

    @Test
    public void Negative() { // Enter a invalid password for account deletion
        driver.get("https://www.akakce.com/");
        driver.findElement(By.linkText("Giriş Yap")).click();
        driver.findElement(By.id("life")).sendKeys(email);
        driver.findElement(By.id("lifp")).sendKeys(password);
        driver.findElement(By.id("lfb")).click();
        driver.findElement(By.linkText("Test")).click();
        driver.findElement(By.linkText("Hesabımı Sil")).click();
        driver.findElement(By.cssSelector("input[id='p']")).sendKeys("invalidpassword" + Keys.ENTER);

        List<WebElement> error = driver.findElements(By.xpath("//button[@onclick='Modal_v8.close()']"));
        if (!error.isEmpty()) {
            System.out.println("Test successful.Failed to delete account.");
        } else {
            System.out.println("Account deleted!");
        }
        WaitAndClose();
    }
}