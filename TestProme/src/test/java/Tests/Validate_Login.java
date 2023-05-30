package Tests;

import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import Util.Util;

public class Validate_Login extends Util{
	/**NOTA: PARA EJECUTAR ESTA PRUEBA ES RECOMENDABLE TENER INSTALDO EXTENCION EN EL NAVEGADOR(CHROME)
	 * PARA BLOQUEAR LOS ANUNCIOS YA Q LOS MISMO INTERFIEREN EN LAS PRUEBAS Y EN 
	 * OCACIONES LAS HACEN FALLAR, YA QUE NO ES UN SITIO SEGURO./
	 */
	/*Test valida el login del sitio web se realice de forma exitosa*/
	@Test
	  public void testLogin() {
		  driver.get("https://practice.automationtesting.in/");
		    driver.manage().window().setSize(new Dimension(1552, 832));
		    driver.findElement(By.linkText("My Account")).click();
		    driver.findElement(By.id("username")).click();
		    driver.findElement(By.id("username")).sendKeys("mhidalgo.pz@gmail.com");
		    driver.findElement(By.id("password")).click();
		    driver.findElement(By.id("password")).sendKeys("E185023hc01");
		    driver.findElement(By.name("login")).click();
		    {
		      List<WebElement> elements = driver.findElements(By.linkText("Logout"));
		      assert(elements.size() > 0);
		    }
		    	  	}
}
