package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StoreScreen extends PageObject {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"App logo and name\"]")
    private WebElement appLogo;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']/android.view.ViewGroup")
    private List<WebElement> products;

    public boolean isAppLoaded() {
        return appLogo.isDisplayed();
    }

    public List<WebElement> getProducts() {
        element(products.get(0)).waitUntilVisible();
        return products;
    }
}
