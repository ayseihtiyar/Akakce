import Utility.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderListCheckTest extends BaseDriver {
    @Test
    public void TC_0501() {
        driver.get("https://www.akakce.com/");
        driver.findElement(By.linkText("Giriş Yap")).click();
        driver.findElement(By.id("life")).sendKeys(email);
        driver.findElement(By.id("lifp")).sendKeys(password);
        driver.findElement(By.id("lfb")).click();
        driver.findElement(By.cssSelector("#HM_v8 >i> a")).click();
        wait.until(ExpectedConditions.urlContains("akakcem"));
        driver.findElement(By.cssSelector("[id='AL'] a[href='/akakcem/siparislerim/']")).click();
        Assert.assertEquals("The information message could not be displayed.", "Kayıtlı siparişiniz bulunmuyor.", driver.findElement(By.id("user-order-info")).getText());
        WaitAndClose();
    }
}