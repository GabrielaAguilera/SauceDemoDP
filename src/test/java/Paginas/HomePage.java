package Paginas;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
	
	//Elementos
	
	@FindBy(id="user-name")
	WebElement txtUsuario;
	
	@FindBy(css="#password")
	WebElement txtContraseña;
	
	@FindBy(css="#login-button")
	WebElement BtnLogin;
	
	//Constructor
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 2), this);
		}
	
	//Acciones
	
	public void EscribirUsuario(String Usuario) {
		txtUsuario.sendKeys(Usuario);
	}
	
	public void EscribirContraseña(String Contraseña) {
		txtContraseña.sendKeys(Contraseña);
	}
	
	public void HacerClickEnLogin () {
		BtnLogin.click();
}
	
	
}
