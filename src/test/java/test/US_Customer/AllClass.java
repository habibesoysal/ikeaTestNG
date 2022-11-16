package test.US_Customer;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IkeaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import javax.swing.text.TabableView;
import java.time.Duration;

public class AllClass extends TestBaseRapor{
    IkeaPage ikeaPageObje = new IkeaPage();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    @Test
    public void test01() {

        //Kullanici belirtilen URL' e gider
        Driver.getDriver().get(ConfigReader.getProperty("ikeaUrl"));
        // Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Kullanici anasayfanin gorundugunu dogrular
        String expectedUrl = "https://www.ikea.com.tr/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);


        //Kullanici uyelik butonuna tiklar
        ikeaPageObje.signIn.click();

        //Kullanici açilan pencerede uye ol butonuna tiklar

        ikeaPageObje.uyeOl.click();

        //Kullanici açilan sayfada 'Ad ','Soyad', 'Email','Telefon','Sifre' kutucuklariin gorundugunu test eder
        Assert.assertTrue(ikeaPageObje.uyeKayitFormu.isDisplayed());

    }

    @Test
    public void test02() {


//    Kullanici belirtilen URL' e gider
        Driver.getDriver().get(ConfigReader.getProperty("ikeaUrl"));
//    Kullanici uyelik butonuna tiklar
        ikeaPageObje.signIn.click();
//    Kullanici açilan pencerede uye ol butonuna tiklar
        ikeaPageObje.uyeOl.click();

//    Kullanici gecerli bir email girer
        actions.sendKeys(Keys.TAB, "15").perform();
        Driver.getDriver().get("https://www.fakemail.net/");
        String fakeMail = ikeaPageObje.fakeEmailBox.getText();
        Driver.getDriver().navigate().back();
        ikeaPageObje.email.sendKeys(fakeMail);

    }

    @Test
    public void test03() {
//        Kullanici belirtilen URL' e gider
        Driver.getDriver().get(ConfigReader.getProperty("ikeaUrl"));

//        Kullanici uyelik butonuna tiklar
        ikeaPageObje.signIn.click();

//        Kullanici açilan pencerede uye ol butonuna tiklar
        ikeaPageObje.uyeOl.click();

        //Kullanici gecerli bir Sifre girer
        ikeaPageObje.ad.sendKeys("ikea1");
        actions.sendKeys(Keys.TAB, "15").perform();
        Driver.getDriver().get("https://www.fakemail.net/");
        String fakeMail = ikeaPageObje.fakeEmailBox.getText();
        Driver.getDriver().navigate().back();
        ikeaPageObje.email.sendKeys(fakeMail);
        actions.sendKeys(Keys.TAB, "5071253612").
                sendKeys(Keys.TAB, "hmn123").
                sendKeys(Keys.TAB, "hmn123").perform();


    }
    @Test
    public void test04() throws InterruptedException {
//    Kullanici belirtilen URL' e gider
            Driver.getDriver().get(ConfigReader.getProperty("ikeaUrl"));

//    Kullanici uyelik butonuna tiklar
        ikeaPageObje.signIn.click();
//    Kullanici açilan pencerede uye ol butonuna tiklar
        ikeaPageObje.uyeOl.click();

        Driver.getDriver().get("https://www.fakemail.net/");
        String fakeMail = ikeaPageObje.fakeEmailBox.getText();
        Driver.getDriver().navigate().back();

        //    Kullanici gereken yerleri doldurur
        ikeaPageObje.ad.sendKeys("ikea123");
        actions.sendKeys(Keys.TAB, "ikeaGel").perform();
        ikeaPageObje.email.sendKeys(fakeMail);
        actions.sendKeys(Keys.TAB, "5071253612").
                sendKeys(Keys.TAB, "hmn123").
                sendKeys(Keys.TAB, "hmn123").perform();
        Thread.sleep(5000);
        ikeaPageObje.uyelikSozlesme.click();
//    Kullanici kaydet butonunu tiklar
   ikeaPageObje.kaydet.click();
//   Kullanicinin mail adresindeki dogrulama linkine tiklar

     Driver.getDriver().navigate().forward();
    Driver.getDriver().get("https://www.fakemail.net/");

        wait.until(ExpectedConditions.visibilityOf(ikeaPageObje.fakeMailU));
        wait.until(ExpectedConditions.visibilityOf(ikeaPageObje.fakeMailU));

     ikeaPageObje.fakeMailU.click();
     Driver.getDriver().navigate().refresh();
     Thread.sleep(3000);
     Driver.getDriver().switchTo().frame(ikeaPageObje.textFrame);
        WebElement textBoxFrame = ikeaPageObje.fakeEmailGelenTik;
        textBoxFrame.click();




}}
