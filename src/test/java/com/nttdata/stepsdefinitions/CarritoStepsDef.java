package com.nttdata.stepsdefinitions;

import com.nttdata.steps.StoreSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class CarritoStepsDef {
    @Steps
    StoreSteps storeSteps;

    private String lastProductName;
    private int lastQuantity;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeSauceLabs() {
        // Validar carga de aplicacion
        Assert.assertTrue(storeSteps.isAppLoaded());
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        Assert.assertTrue(storeSteps.hasProducts());
    }

    @When("agrego {string} del siguiente producto {string}")
    public void agregoDelSiguienteProducto(String quantity, String productName) {
        storeSteps.selectProductAndQuantity(productName, quantity);

        this.lastProductName = productName;
        this.lastQuantity = Integer.parseInt(quantity);
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        storeSteps.validateCartUpdate(this.lastProductName, this.lastQuantity);
    }
}
