package org.vistula.selenium.test.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {//w tej klasie będzie cała logika strony home page
    private WebDriver driver; //definiujemy pole

    @FindBy(id = "search_form_input_homepage")
    private WebElement searchBar;

    @FindBy(id = "search_button_homepage")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void search(String text) {

        searchBar.sendKeys(text); //Wpisujemy co szukamy, tutaj parametr text
        searchButton.click();//klikamy na lupkę
    }


}
