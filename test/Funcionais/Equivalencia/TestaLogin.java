package Scripts;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestaLogin {
	
    protected WebDriver driver;
    
    @Test
    public void AdmLoginTest(){
       System.setProperty("webdriver.chrome.driver","C:\\Libs\\chromedriver\\chromedriver.exe");
       driver = new ChromeDriver(); 
       driver.get("http://localhost:8084/TrabalhoQualidadeTeste/");
       driver.close();
    }
}