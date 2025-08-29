package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StoreScreen extends PageObject {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"App logo and name\"]")
    private WebElement appLogo;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup")
    private List<WebElement> products;

    @AndroidFindBy(accessibility = "//android.widget.ImageView[@content-desc=\"Increase item quantity\"]")
    private WebElement btnIncreaseQuantity;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    private WebElement btnAddToCart;

    public boolean isAppLoaded() {
        return appLogo.isDisplayed();
    }

    public List<WebElement> getProducts() {
        element(products.get(0)).waitUntilVisible();
        return products;
    }

    public void clickProductByName(String productName) {
        try {
            String xpath = "//android.widget.ImageView[@content-desc='" + productName + "']";
            WebElement product = getDriver().findElement(By.xpath(xpath));
            element(product).waitUntilVisible();
            product.click();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void setProductQuantity(String value) {
        int quantity = Integer.parseInt(value);
        for (int i = 1; i < quantity; i++) {
            element(btnIncreaseQuantity).waitUntilClickable();
            btnIncreaseQuantity.click();
        }
    }

    public void clickAddToCart() {
        element(btnAddToCart).waitUntilVisible();
        btnAddToCart.click();
    }
}
