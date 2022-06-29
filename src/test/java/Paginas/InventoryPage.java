package Paginas;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class InventoryPage {
	
	//Elementos
	
	@FindBy(css="#react-burger-menu-btn")
	WebElement txtBtnMenu;
	
	@FindBy(css="#logout_sidebar_link")
	WebElement txtBtnLogout;
	
	
	//Constructor
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 2), this);
	}
	
	//Acciones
	public void HacerClickEnMenu() {
		txtBtnMenu.click();
	}
	
	public void HacerClickEnLogout() {
		txtBtnLogout.click();
	}
	
	
	
	
}

