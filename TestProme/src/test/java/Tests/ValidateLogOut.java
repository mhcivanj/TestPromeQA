package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import Util.Util;
import java.util.*;



public class ValidateLogOut extends Util{

	/**NOTA: PARA EJECUTAR ESTA PRUEBA ES RECOMENDABLE TENER INSTALDO EXTENCION EN EL NAVEGADOR(CHROME)
	 * PARA BLOQUEAR LOS ANUNCIOS YA Q LOS MISMO INTERFIEREN EN LAS PRUEBAS Y EN 
	 * OCACIONES LAS HACEN FALLAR, YA QUE NO ES UN SITIO SEGURO./
	
	/*Test valida que el sitio realice de forma correcta un cierre de sesion
	 * AL no ser una pagina bien desarrollada, la vslidacion de la url y el nombre de la pagina 
	 * no son claros puntos de referencia por lo cual se valida el logout, 
	 * por medio de campos de texto q pertenecen a la pagina de salida del logout*/
	
	
  @Test
  
  
  public void testLogout() {
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
    driver.findElement(By.linkText("Logout")).click();
    {
      List<WebElement> elements = driver.findElements(By.name("login"));
      assert(elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.id("username"));
      assert(elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.id("password"));
      assert(elements.size() > 0);
    }
  }



}
  

