import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageObject {

    @FindBy (id = "react-burger-menu-btn")
    private WebElement burgerMenu_button;

    @FindBy (id = "shopping_cart_container")
    private WebElement shoppingCart_button;

    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    private WebElement addCart_backpack;

    @FindBy (id = "logout_sidebar_link")
    private WebElement logout_button;

    @FindBy(id = "shopping_cart_container")
    private WebElement shopping_cart_button;

    @FindBy (xpath = "//span[contains(text(),'Products')]")
    private WebElement products_label;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cart_badge;


    public ProductPage(WebDriver driver){
        super(driver);
    }

    public String getTitle(){
        return this.products_label.getText();
    }

    public void addToCartBackpack(){
        this.addCart_backpack.click();
    }

    public String getCartBadge(){
        return this.cart_badge.getText();
    }

    public void openBurgerMenu(){
        this.burgerMenu_button.click();
    }

    public void logoutAccount(){
        this.logout_button.click();
    }

    public void checkShoppingCart(){
        this.shopping_cart_button.click();
    }

}
