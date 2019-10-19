package org.vistula.selenium.test.pop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VistulaSeleniumTest { //super klasa, po której dziedziczy klasa DagDagGoRefactoredTest
    protected WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();//ściaga binarkę do przeglądarek
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();//maksymalna rozdzielczość
        driver.get("https://duckduckgo.com/");//szuka podanej strony
    }

    @After
    public void quit() {
        driver.quit();
    }

}
