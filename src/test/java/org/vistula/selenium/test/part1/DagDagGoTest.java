package org.vistula.selenium.test.part1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DagDagGoTest {

    private WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();//ściaga binarkę do przeglądarek
    }

    @Test
    public void ShouldFindVistula() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();//maksymalna rozdzielczość
        driver.get("https://duckduckgo.com/");//szuka podanej strony
        WebElement searchBar =
                driver.findElement(By.id("search_form_input_homepage")); //inicjalizacja serchBara
        WebElement searchButton =
                driver.findElement(By.id("search_button_homepage")); //inicjalizacja lupki
        searchBar.sendKeys("Vistula University"); //Wpisujemy co szukamy
        searchButton.click();//klikamy na lupkę
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.cssSelector("a.module__official-url")));//poczekaj, aż pojawi się element o tym selektorze
        WebElement link = driver.findElement
                (By.cssSelector("a.module__official-url"));//załaduj element o tym selektorze
        Assertions.assertThat(link.getAttribute("href")).isEqualTo("https://www.vistula.edu.pl/"); //assercja sprawdzenia elementu z polecenia wyżej, że prowadzi do tego co trzeba
        driver.quit();

    }

}