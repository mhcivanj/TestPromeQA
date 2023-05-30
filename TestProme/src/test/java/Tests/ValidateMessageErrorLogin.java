package Tests;
import org.junit.Test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Util.Util;

public class ValidateMessageErrorLogin extends Util{

	/**NOTA: PARA EJECUTAR ESTA PRUEBA ES RECOMENDABLE TENER INSTALDO EXTENCION EN EL NAVEGADOR(CHROME)
	 * PARA BLOQUEAR LOS ANUNCIOS YA Q LOS MISMO INTERFIEREN EN LAS PRUEBAS Y EN 
	 * OCACIONES LAS HACEN FALLAR, YA QUE NO ES UN SITIO SEGURO./
	
	/*Test validacion que muestre un mensaje de error,al hacer un login falso o erroneo 
	 * y le comunique por medio de un mensaje claro al usuario*/
	
  @Test
  public void validateMessageErrorLogin() {
	  driver.get("https://practice.automationtesting.in/");
	    driver.manage().window().setSize(new Dimension(1552, 832));
	    driver.findElement(By.linkText("My Account")).click();
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).sendKeys("mhidalgo.pz@gmail.com");
	    driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).sendKeys("123456789");
	    driver.findElement(By.name("login")).click();
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Lost your password?")));
	      }
        {
        	List<WebElement> elements = driver.findElements(By.linkText("Lost your password?"));
        	assert(elements.size() > 0);
        }   
       
  }
}
