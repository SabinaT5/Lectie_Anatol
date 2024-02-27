import org.example.demoqa.LoginDemoqa;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestTag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests {


    static final String USER_NAME = "anatolie";
    static final String USER_PASSWORD = "Demoqa$123";


    WebDriver driver;




    @BeforeClass
    public void setProperty(){
        System.setProperty("webdriver.chrome.driver", "G:\\Anul 4\\_Semestrul 2\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");

    }

    @Test
    public void loginTest() throws InterruptedException {
        driver.get("https://demoqa.com/login");
        LoginDemoqa loginDemoqa = new LoginDemoqa(driver);
        loginDemoqa.setUserName(USER_NAME);
        loginDemoqa.setPassword(USER_PASSWORD);
        loginDemoqa.clickLogin();
        String actualProfileName = loginDemoqa.getProfileName();
        String expectedProfileName = USER_NAME;
        Assert.assertEquals(actualProfileName, expectedProfileName);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
