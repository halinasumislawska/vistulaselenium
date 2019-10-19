package org.vistula.selenium.test.hs_pop;


import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HalinaZadDomTest extends BeforeAndAfter {


    @Test
    public void lookingForProjectTest() {

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login"));
        String randomowyCiagZnakow1 = RandomStringUtils.randomAlphabetic(15);
        String randomowyCiagZnakow2 = RandomStringUtils.randomAlphabetic(5);

        email.sendKeys("administrator@testarena.pl");
        password.sendKeys("sumXQQ72$L");
        login.click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("footer")));

        Assertions.assertThat(driver.getTitle()).contains("Kokpit");

        WebElement searchAdminPanel =
                driver.findElement(By.className("icon_tools"));
        searchAdminPanel.click();

        WebElement dodajProjekt = driver.findElement(By.cssSelector("#content > article > nav > ul > li:nth-child(1) > a"));
        dodajProjekt.click();

        WebElement searchNazwa = driver.findElement(By.id("name"));
        searchNazwa.sendKeys(randomowyCiagZnakow1);

        WebElement Prefix = driver.findElement(By.cssSelector("#prefix"));
        Prefix.sendKeys(randomowyCiagZnakow2);

        WebElement Opis = driver.findElement(By.cssSelector("#description"));
        Opis.sendKeys("Walka z Selenium ciągle trwa");

        WebElement searchButtonZapisz = driver.findElement(By.cssSelector("span#save"));

        searchButtonZapisz.click();

        WebElement searchProjekty = driver.findElement(By.cssSelector("a.activeMenu"));
        searchProjekty.click();

        WebElement searchHalSum = driver.findElement(By.cssSelector("#content > article > table > tbody > tr:nth-child(1) > td:nth-child(1) > a"));
        searchHalSum.click();

    }

}
