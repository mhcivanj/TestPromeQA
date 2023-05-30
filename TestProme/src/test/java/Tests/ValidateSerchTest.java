package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Util.Util;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.util.*;

public class ValidateSerchTest extends Util{
	
	/**NOTA: PARA EJECUTAR ESTA PRUEBA ES RECOMENDABLE TENER INSTALDO EXTENCION EN EL NAVEGADOR(CHROME)
	 * PARA BLOQUEAR LOS ANUNCIOS YA Q LOS MISMO INTERFIEREN EN LAS PRUEBAS Y EN 
	 * OCACIONES LAS HACEN FALLAR, YA QUE NO ES UN SITIO SEGURO./
	
	/*Test validacion que la opcion de BUsqueda funcione*/
  @Test
  public void validateSerch() {
    driver.get("https://practice.automationtesting.in/");
    driver.manage().window().setSize(new Dimension(1552, 832));
    driver.findElement(By.id("s")).click();
    driver.findElement(By.id("s")).sendKeys("android");
    driver.findElement(By.id("s")).sendKeys(Keys.ENTER);
    {
      List<WebElement> elements = driver.findElements(By.linkText("Android Quick Start Guide"));
      assert(elements.size() > 0);
    }
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Android Quick Start Guide")));
    }
    driver.close();
  }
}
