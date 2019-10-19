package org.vistula.selenium.test.pop;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage { //strona wyników wyszukiwania

    private WebDriver driver;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForSideBarLink() {

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.cssSelector("a.module__official-url")));//poczekaj, aż pojawi się element o tym selektorze
    }

    public void verifyLinkUrl(String url) {

        WebElement link = driver.findElement
                (By.cssSelector("a.module__official-url"));//załaduj element o tym selektorze
        Assertions.assertThat(link.getAttribute("href")).isEqualTo(url); //assercja sprawdzenia elementu z polecenia wyżej, że prowadzi do tego co trzeba
    }
}
