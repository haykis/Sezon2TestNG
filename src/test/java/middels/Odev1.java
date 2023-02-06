package middels;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Odev1 {
    static WebDriver driver = new ChromeDriver();
    Faker faker = new Faker();

    public static void waitBasic(int sec){
        try {
            Thread.sleep(sec*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void waitIf(WebElement element, int timeout){
        for(int i=0;i<timeout;i++){
            try{
                element.click();
                break;
            }catch (WebDriverException e){
                waitBasic(1);
            }
        }
    }
    @BeforeClass
    public static void setupKismi(){
        driver.get("http://gcreddy.com/project/admin/login.php");
        driver.manage().window().maximize();
        waitBasic(20);
    }
    @Test
    public void login(){
         //*****************Login**********
          driver.findElement(By.xpath("//input[@name='username']")).sendKeys("gcreddy");
          driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Temp@2020");
          driver.findElement(By.xpath("//button/span[@class='ui-button-text']")).click();
          waitBasic(10);
          //****************Customer******
          driver.findElement(By.xpath("(//h3/a)[3]")).click();
          waitBasic(10);
         driver.findElement(By.xpath("//div[@id='ui-accordion-adminAppMenu-panel-2']")).click();
         waitBasic(10);
         driver.findElement(By.xpath("(//span[@class='ui-button-text'])[1]")).click();
         //*********VeriGiris*********
         String firstName=faker.name().firstName();
         System.out.println("firstName = " + firstName);
         String lastName=faker.name().lastName();
         String email=faker.internet().emailAddress();
         String companyName=faker.company().name();
        String streetAdres=faker.address().streetAddress();
        String suburb=faker.address().streetName();
        String postaKodu=faker.address().zipCode();
        String city=faker.address().city();
        String state=faker.address().state();
        String country=faker.address().country();
        String phoneNummer="65312596";
        String faxNummer = "855145";

        driver.findElement(By.xpath("//input[@name='customers_firstname']")).clear();
        driver.findElement(By.xpath("//input[@name='customers_firstname']"))
                .sendKeys(firstName+Keys.TAB+lastName+Keys.TAB+"03/11/1989"
                        +Keys.TAB+email+Keys.TAB+companyName+Keys.TAB+streetAdres
                        +Keys.TAB+suburb+Keys.TAB+postaKodu+Keys.TAB+city+Keys.TAB+state
                        +Keys.TAB+country+Keys.TAB+phoneNummer+Keys.TAB+faxNummer);
        waitBasic(20);

        WebElement newSletter=driver.findElement(By.name("customers_newsletter"));
        Select select=new Select(newSletter);
        select.selectByVisibleText("Subscribed");
        waitBasic(10);
        //*********save*******
        driver.findElement(By.xpath("//button/span[@class='ui-button-text']")).click();
        waitBasic(10);
        //*****search*****
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys(firstName+Keys.ENTER);
        waitBasic(10);
//        //**********TEST***********
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='"+firstName+"']")).isDisplayed());

        //*****logOff********
        driver.findElement(By.xpath("(//a[@class='headerLink'])[3]")).click();


    }

}
