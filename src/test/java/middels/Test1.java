package middels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test1 {

    @BeforeClass
    public static void beforeKlas(){
        System.out.println("before klas calisti");
    }
    @Before
    public void beforeMethod(){
        System.out.println("before methot calisti");
    }
    @After
    public void afterMethod(){
        System.out.println("after methot calisti");
    }
    @AfterClass
    public static void afterKlas(){
        System.out.println("after klas calisti");
    }
    @Test
    public void jUnit(){
        WebDriver driver=new ChromeDriver();
        //WebDriverManager.chromedriver().setup();
        driver.get("https://www.google.com/");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Dimension dimension = new Dimension(500,500);
        driver.manage().window().setSize(dimension);
        Point point = new Point(1000, 500);
        driver.manage().window().setPosition(point);
    }
    @Test
    public void jUnit2(){
        System.out.println("junit2 calisti");
    }
}
