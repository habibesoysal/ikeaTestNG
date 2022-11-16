package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class IkeaPage {
    public IkeaPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }

    @FindBy(xpath = "(//*[@href='/uyelik/uye-girisi'])[1]")
    public WebElement signIn;

    @FindBy(xpath = "//*[@class='btn btn-gray btn-block sign-btn']")
    public WebElement uyeOl;
    @FindBy(xpath = "(//*[@class='container'])[1]")
    public WebElement uyeKayitFormu;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtFirstName']")
    public WebElement ad;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtLastName']")
    public WebElement soyad;
    @FindBy(xpath = "//span[@id='email']")
    public WebElement fakeEmailBox;
    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtEmail']")
    public WebElement email;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtPassword']")
    public WebElement sifre;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtPhone']")
    public WebElement cepTelefonu;

    @FindBy(xpath = "//*[@name='ctl00$ContentPlaceHolder1$txtPasswordAgain']")
    public WebElement sifreTekrar;

    @FindBy(xpath = "(//*[@class='checkbox md-mt-20'])[1]")
    public WebElement uyelikSozlesme;


    @FindBy(xpath = "//*[@class='btn btn-primary btn-block submit-btn']")
    public WebElement kaydet;

    @FindBy(xpath = "(//*[@class='glyphicon glyphicon-envelope'])[1]")
    public WebElement fakeMailU;

    @FindBy(xpath = "//*[@id='iframeMail']")
    public WebElement textFrame;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")
    public WebElement fakeEmailGelenTik;


    //



}

