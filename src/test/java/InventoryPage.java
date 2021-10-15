import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends PageObject{

    @FindBy(id = "item_4_title_link")
    private WebElement inventory_item;

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    public String getInventoryItem(){
        return inventory_item.getText();
    }

}
