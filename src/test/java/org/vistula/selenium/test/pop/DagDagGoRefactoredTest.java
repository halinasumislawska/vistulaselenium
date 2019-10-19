package org.vistula.selenium.test.pop;

import org.junit.Test;


public class DagDagGoRefactoredTest extends VistulaSeleniumTest {


    @Test
    public void ShouldFindVistula() { //ten test jest już ładnie napisany
        HomePage homePage = new HomePage(driver);
        homePage.search("Vistula University");

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.waitForSideBarLink();//ta metoda jest w SearchResultPage
        searchResultPage.verifyLinkUrl("https://www.vistula.edu.pl/");
    }

}