import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;

public class LogoutTest extends BaseDriver {
    @Test
    public void Logout() {
        driver.get("https://www.akakce.com/");
        driver.findElement(By.linkText("Giriş Yap")).click();
        driver.findElement(By.id("life")).sendKeys(email);
        driver.findElement(By.id("lifp")).sendKeys(password);
        driver.findElement(By.id("lfb")).click();
        driver.findElement(By.xpath("//a[@title='Hesabım']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Çık')]")).click();
        driver.findElement(By.linkText("Giriş Yap")).click();
        WaitAndClose();
    }
}