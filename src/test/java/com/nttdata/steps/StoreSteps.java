package com.nttdata.steps;

import com.nttdata.screens.StoreScreen;

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
}
