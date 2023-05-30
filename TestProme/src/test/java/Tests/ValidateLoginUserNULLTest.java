package Tests;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import Util.Util;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidateLoginUserNULLTest extends Util{

	/**NOTA: PARA EJECUTAR ESTA PRUEBA ES RECOMENDABLE TENER INSTALDO EXTENCION EN EL NAVEGADOR(CHROME)
	 * PARA BLOQUEAR LOS ANUNCIOS YA Q LOS MISMO INTERFIEREN EN LAS PRUEBAS Y EN 
	 * OCACIONES LAS HACEN FALLAR, YA QUE NO ES UN SITIO SEGURO./
	/*Test valida el mensaje de error cuando un usuario no digita el usuario*/
  @Test
  public void validateLoginUserNULL() {
    driver.get("https://practice.automationtesting.in/");
    driver.manage().window().setSize(new Dimension(1536, 816));
    driver.findElement(By.linkText("My Account")).click();
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("1234123412");
    driver.findElement(By.name("login")).click();
    assertThat(driver.findElement(By.cssSelector(".woocommerce-error > li")).getText(), is("Error: Username is required."));
  }
}
