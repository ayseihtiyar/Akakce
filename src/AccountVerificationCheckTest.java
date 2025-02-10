import Utility.BaseDriver;
import org.junit.*;
import org.openqa.selenium.*;

public class AccountVerificationCheckTest extends BaseDriver {
    @Test
    public void AccountVerificationCheck() {
        driver.get("https://www.akakce.com/");
        driver.findElement(By.xpath("//*[@id='H_rl_v8']/a[2]")).click();
        driver.findElement(By.id("life")).sendKeys(email);
        driver.findElement(By.id("lifp")).sendKeys(password);
        driver.findElement(By.id("lfb")).click();

        WebElement profileName = driver.findElement(By.xpath("//div[@id='HM_v8']/i/a"));
        Assert.assertEquals("The name displayed does not match the username.", profileName.getText(), name);
        if (profileName.getText().equals(name)) {
            System.out.println("Account verification successful.");
        }
        WaitAndClose();
    }
}