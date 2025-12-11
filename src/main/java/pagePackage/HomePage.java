package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement sauseLabBackpack;
	@FindBy(id = "add-to-cart-sauce-labs-backpack") private WebElement addToCartSauseLabBackpack;
	@FindBy(xpath = "//a[@id = 'item_0_title_link']") private WebElement sauseLabBikeLight;
	@FindBy(xpath = "//button[@id = 'add-to-cart-sauce-labs-bike-light']") private WebElement addToCartSauseLabBikeLight;
	@FindBy(xpath = "//a[@id = 'item_1_title_link']") private WebElement sauseLabBoltTshirt;
	@FindBy(xpath = "//button[@id = 'add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement addToCartSauseLabBoltTshirt;
	@FindBy(xpath = "//a[@id = 'item_5_title_link']") private WebElement sauseLabFleeceJacket;
	@FindBy(xpath = "//button[@id = 'add-to-cart-sauce-labs-fleece-jacket']") private WebElement addToCartSauseLabFleeceJacket;
	@FindBy(xpath = "//a[@id = 'item_2_title_link']") private WebElement sauseLabsOnesie;
	@FindBy(xpath = "//button[@id = 'add-to-cart-sauce-labs-onesie']") private WebElement addToCartSauseLabsOneSie;
	@FindBy(xpath = "//a[@id = 'item_3_title_link']") private WebElement testAllThingsTshirt;
	@FindBy(xpath = "//button[@id = 'add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement addToCartTestAllThingsTshirt;
	@FindBy(className = "product_sort_container") private WebElement filter;
	
	
	// Constructor
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

	public WebElement getSauseLabBackpack() {
		return sauseLabBackpack;
	}

	public WebElement getAddToCartSauseLabBackpack() {
		return addToCartSauseLabBackpack;
	}

	public WebElement getSauseLabBikeLight() {
		return sauseLabBikeLight;
	}

	public WebElement getAddToCartSauseLabBikeLight() {
		return addToCartSauseLabBikeLight;
	}

	public WebElement getSauseLabBoltTshirt() {
		return sauseLabBoltTshirt;
	}

	public WebElement getAddToCartSauseLabBoltTshirt() {
		return addToCartSauseLabBoltTshirt;
	}

	public WebElement getSauseLabFleeceJacket() {
		return sauseLabFleeceJacket;
	}

	public WebElement getAddToCartSauseLabFleeceJacket() {
		return addToCartSauseLabFleeceJacket;
	}

	public WebElement getSauseLabsOnesie() {
		return sauseLabsOnesie;
	}

	public WebElement getAddToCartSauseLabsOneSie() {
		return addToCartSauseLabsOneSie;
	}

	public WebElement getTestAllThingsTshirt() {
		return testAllThingsTshirt;
	}

	public WebElement getAddToCartTestAllThingsTshirt() {
		return addToCartTestAllThingsTshirt;
	}
	
	
	public WebElement getFilter() {
		return filter;
	}
	
	
	
	
	// Product add methods
	public void addSauseLabBackpackToCart() {
		sauseLabBackpack.click();
		addToCartSauseLabBackpack.click();
	}
	
	
	public void addSauseLabBikeLightToCart() {
		sauseLabBikeLight.click();
		addToCartSauseLabBikeLight.click();
	}
	
	public void addSauseLabBoltTshirtToCart() {
		sauseLabBoltTshirt.click();
		addToCartSauseLabBoltTshirt.click();
	}
	
	public void addSauseLabFleeceJacketToCart() {
		sauseLabFleeceJacket.click();
		addToCartSauseLabFleeceJacket.click();
	}
	
	public void addSauseLabsOnesie() {
		sauseLabsOnesie.click();
		addToCartSauseLabsOneSie.click();
	}
	
	
	public void addTestAllThingsTshirt() {
		testAllThingsTshirt.click();
		addToCartTestAllThingsTshirt.click();
	}
	
	
	
	
	public void selectFilter(String visibleText) {
	    Select sel = new Select(filter);
	    sel.selectByVisibleText(visibleText);
        System.out.println("🔽 Filter selected: " + visibleText);
	}

	public String getSelectedFilterOption() {
	    Select sel = new Select(filter);
	    return sel.getFirstSelectedOption().getText();
	}
	
	
	
}
