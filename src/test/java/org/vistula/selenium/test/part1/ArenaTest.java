package org.vistula.selenium.test.part1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArenaTest {

    private WebDriver driver;
    @BeforeClass
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void myFirstSeleniumTest() {
        driver = new ChromeDriver();
        driver.get("http://demo.testarena.pl/zaloguj");//przechodzi do strony
        Assertions.assertThat(driver.getTitle()).contains("TestArena");//sprawdza czy tytul zawiera string
        driver.quit();
    }

    @Test
    public void myFirstInteractionTest() {
        driver = new ChromeDriver(); //uruchamia przegladarke na white screenie
        driver.get("http://demo.testarena.pl/zaloguj"); //przechodzi do strony
        WebElement email = driver.findElement(By.id("email")); //tworzy element o id email
        WebElement password = driver.findElement(By.id("password"));//tworzy element o id password
        WebElement login = driver.findElement(By.id("login"));

        email.sendKeys("administrator@testarena.pl"); //wpisuje tekst
        password.sendKeys("sumXQQ72$L");
        login.click(); //klika

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("footer"))); //czekamy maksymalnie 3 sekundy
        /*czekamy dopóki coś się wydarzy, można dopisać trzeci parametr co jaki czas ma sprawdzać*/

        Assertions.assertThat(driver.getTitle()).contains("Kokpit");
        driver.quit(); //ten test teraz się wywala, bo pojawiła się teraz capcha
        //ten test zrobił się niestabilny z powodu pojawienia się capcha
    }

    @Test
    public void myCaptureTest() {
        driver = new ChromeDriver(); //uruchamia przegladarke
        driver.get("http://demo.testarena.pl/zaloguj"); //przechodzi do strony

        new WebDriverWait(driver, 3, 250)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("g-recaptcha"))); //czekamy maksymalnie 3 sekundy
        /*czekamy dopóki coś się wydarzy, można dopisać trzeci parametr co jaki czas ma sprawdzać*/

        driver.quit(); //ten test się wywala
    }

    @Test
    public void poleWymaganeTest() {
        driver = new ChromeDriver(); //uruchamia przegladarke
        driver.get("http://demo.testarena.pl/zaloguj"); //przechodzi do strony
        WebElement login = driver.findElement(By.id("login"));
        login.click();
        new WebDriverWait(driver, 3, 250)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("login_form_error")));

        driver.quit();
    }
    @Test
    public void poleWyszukiwaniaGoogleTest() {
        driver = new ChromeDriver(); //uruchamia przegladarke
        driver.get("https://www.google.pl"); //przechodzi do strony
        WebElement poleZnajdz = driver.findElement(By.cssSelector("input[type='text']"));
        poleZnajdz.sendKeys("Vistula University");
        poleZnajdz.sendKeys(Keys.ENTER);
        new WebDriverWait(driver, 3, 250)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='https://vistula.edu.pl/']")));
/*weryfikacja - poniżej*/

        driver.quit();
    }
}
/*selenium*/
