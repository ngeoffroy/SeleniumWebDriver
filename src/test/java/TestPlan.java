import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {

    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main (String[] arghs){
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "login exitoso")
    public static void succesfullLogin(){
        driver.get(Utils.BASE_URL);
        LoginForm login = loginToSwag();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductPage productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.getTitle(), "PRODUCTS");
    }

    @Test(testName = "añadir un item al carrito")
    public static void addItemToCart(){
        driver.get(Utils.BASE_URL);
        LoginForm login = loginToSwag();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCartBackpack();
        Assert.assertEquals(productPage.getCartBadge(),"1");
    }

    @Test(testName = "desloguearse correctamente")
    public static void logoutSuccesfull(){
        driver.get(Utils.BASE_URL);
        LoginForm login = loginToSwag();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductPage productPage = new ProductPage(driver);
        productPage.openBurgerMenu();
        productPage.logoutAccount();
        Assert.assertTrue(productPage.loginButtonIsDisplayed());
    }

    @Test(testName = "verificar carrito")
    public static void verifyShoppingCart(){
        driver.get(Utils.BASE_URL);
        LoginForm login = loginToSwag();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCartBackpack();
        productPage.checkShoppingCart();
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getInventoryItem(), "Sauce Labs Backpack");
    }

    private static LoginForm loginToSwag(){
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUsername();
        loginForm.enterPassword();
        loginForm.clickLogin();
        return loginForm;
    }

    @AfterSuite
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
    }

}
