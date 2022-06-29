package Pruebas;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Paginas.HomePage;
import Paginas.InventoryPage;
import Utilities.DatosExcel;

public class LoginTest {
	
	String url ="https://www.saucedemo.com/";
	String driverPath = "..\\SauceDemoDP\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	
public void abrirPagina() {
	System.setProperty("webdriver.chrome.driver", driverPath);
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();

	}
	
@Test(dataProvider= "Datos LoginSaucedemoPOM", priority=1)

public void LoginSauceDemo(String Usuario, String Contraseña) {
	HomePage inicio = new HomePage(driver);
	

	inicio.EscribirUsuario(Usuario);
	inicio.EscribirContraseña(Contraseña);
	inicio.HacerClickEnLogin();
	
	String urlEsperadaLogin = "https://www.saucedemo.com/inventory.html";
	String urlActualLogin = driver.getCurrentUrl();
	Assert.assertEquals (urlActualLogin,urlEsperadaLogin);
	

	
}
	
	@Test(priority=2)
	
	public void ClickEnLogout() throws InterruptedException {
	InventoryPage order = new InventoryPage(driver);

	
	order.HacerClickEnMenu();
	
	order.HacerClickEnLogout();
	
	
	
}

@DataProvider(name="Datos LoginSaucedemoPOM")
public Object[][] obtenerDatosExcel() throws Exception{
return DatosExcel.leerExcel("..\\SauceDemoDP\\Datos\\Datos Login Sauce Demo POM.xlsx", "Sheet1"); 

}

@AfterSuite

public void CerrarNavegador() {
driver.close();

}

}
