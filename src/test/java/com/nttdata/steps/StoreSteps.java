package com.nttdata.steps;

import com.nttdata.screens.StoreScreen;
import org.junit.Assert;

public class StoreSteps {
    StoreScreen storeScreen;

    public boolean isAppLoaded() {
        return storeScreen.isAppLoaded();
    }

    public boolean hasProducts() {
        return !storeScreen.getProducts().isEmpty();
    }

    public void selectProductAndQuantity(String productName, String quantity) {
        storeScreen.clickProductByName(productName);
        storeScreen.setProductQuantity(quantity);
        storeScreen.clickAddToCart();
    }

    public void validateCartUpdate(String expectedProductName, int expectedQuantity) {
        storeScreen.clickCart();
        String actualProductName = storeScreen.getCartProductName();
        String actualQuantityStr = storeScreen.getQuantityProductCart();
        int actualQuantity = Integer.parseInt(actualQuantityStr);

        Assert.assertEquals(expectedProductName, actualProductName);
        Assert.assertEquals(expectedQuantity, actualQuantity);
    }
}
