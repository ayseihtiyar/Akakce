import Utility.BaseDriver;
import org.junit.*;
import org.openqa.selenium.By;

public class MessageBoxCheckTest extends BaseDriver {
    @Test
    public void TC_0601() {
        driver.get("https://www.akakce.com/");
        driver.findElement(By.linkText("Giriş Yap")).click();
        driver.findElement(By.id("life")).sendKeys(email);
        driver.findElement(By.id("lifp")).sendKeys(password);
        driver.findElement(By.id("lfb")).click();
        driver.findElement(By.cssSelector("#HM_v8 >i> a")).click();
        driver.findElement(By.cssSelector("ul[id='AL'] a[href='/akakcem/mesajlarim/']")).click();
        Assert.assertEquals("The information message could not be displayed.", "Listelenecek mesaj bulunamadı.", driver.findElement(By.className("wbb_v8")).getText());
        WaitAndClose();
    }
}