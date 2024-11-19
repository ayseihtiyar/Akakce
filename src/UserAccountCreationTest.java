import Utility.*;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class UserAccountCreationTest extends BaseDriver {

    @Test
    public void Positive(){
        driver.get("https://www.akakce.com/");

        WebElement createAccount = driver.findElement(By.linkText("Hesap Aç"));
        createAccount.click();

        WebElement name = driver.findElement(By.cssSelector("input[id='rnufn']"));
        name.sendKeys("Test");
        MyFunction.Wait(1);

        WebElement surName = driver.findElement(By.cssSelector("input[id='rnufs']"));
        surName.sendKeys("Account");
        MyFunction.Wait(1);

        WebElement mail = driver.findElement(By.cssSelector("input[id='rnufe1']"));
        mail.sendKeys("foviwob699@lineacr.com");
        MyFunction.Wait(1);

        WebElement confirmMail = driver.findElement(By.cssSelector("input[id='rnufe2']"));
        confirmMail.sendKeys("foviwob699@lineacr.com");
        MyFunction.Wait(1);

        WebElement password = driver.findElement(By.cssSelector("input[id='rnufp1']"));
        password.sendKeys("Deneme123+");
        MyFunction.Wait(1);

        WebElement confirmPassword = driver.findElement(By.cssSelector("input[id='rnufp2']"));
        confirmPassword.sendKeys("Deneme123+");
        MyFunction.Wait(1);

        WebElement gender = driver.findElement(By.cssSelector("input[id='rngf']"));
        gender.click();

        WebElement city = driver.findElement(By.cssSelector("select[id='locpr']"));
        Select citySel = new Select(city);
        citySel.selectByValue("6");

        WebElement city2 = driver.findElement(By.cssSelector("select[id='locds']"));
        Select city2select = new Select(city2);
        city2select.selectByValue("64");

        WebElement day = driver.findElement(By.cssSelector("select[id='bd']"));
        Select dayselect = new Select(day);
        dayselect.selectByValue("10");

        WebElement month = driver.findElement(By.cssSelector("select[id='bm']"));
        Select monthSelect = new Select(month);
        monthSelect.selectByValue("11");

        WebElement year = driver.findElement(By.cssSelector("select[id='by']"));
        Select yearSelect = new Select(year);
        yearSelect.selectByValue("1938");

        WebElement contract = driver.findElement(By.cssSelector("input[id='rnufpca']"));
        contract.click();

        WebElement openAccount = driver.findElement(By.cssSelector("input[id='rfb']"));
        openAccount.click();

        WaitAndClose();
    }
}