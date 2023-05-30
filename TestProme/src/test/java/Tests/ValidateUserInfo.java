package Tests;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import Util.Util;
import static org.hamcrest.MatcherAssert.assertThat;
public class ValidateUserInfo extends Util{
	
	/**NOTA: PARA EJECUTAR ESTA PRUEBA ES RECOMENDABLE TENER INSTALDO EXTENCION EN EL NAVEGADOR(CHROME)
	 * PARA BLOQUEAR LOS ANUNCIOS YA Q LOS MISMO INTERFIEREN EN LAS PRUEBAS Y EN 
	 * OCACIONES LAS HACEN FALLAR, YA QUE NO ES UN SITIO SEGURO./
	
	 
/*Test validacion de los datos del usuario
 * este metodo valida que la sesion inicie, y despues navega a los datos del usuario y los valida
 * Cada destacar que al no tener acceso a una base de datos, los datos utilizados no se extraen 
 * o son importados desde algun lado por lo cual estan quemados en codigo*/
 
  @Test
  public void validateUserInfo() {
    driver.get("https://practice.automationtesting.in/");
    driver.manage().window().setSize(new Dimension(1552, 832));
    driver.findElement(By.linkText("My Account")).click();
    driver.findElement(By.cssSelector(".login > .woocommerce-FormRow:nth-child(1) > label")).click();
    driver.findElement(By.id("username")).sendKeys("mhidalgo.pz@gmail.com");
    driver.findElement(By.id("password")).sendKeys("E185023hc01");
    driver.findElement(By.name("login")).click();
    driver.findElement(By.linkText("Account Details")).click();
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("save_account_details")));
      }
    {
        String value = driver.findElement(By.id("account_first_name")).getAttribute("value");
        assertThat(value, is("Marcos"));
      }
      {
        String value = driver.findElement(By.id("account_last_name")).getAttribute("value");
        assertThat(value, is("Hidalgo"));
      }
      {
        String value = driver.findElement(By.id("account_email")).getAttribute("value");
        assertThat(value, is("mhidalgo.pz@gmail.com"));
      }
    
    driver.findElement(By.linkText("Logout")).click();
    driver.close();
  }
  
 
}












/*



  @Test
  public void validateUserInfo() {
    driver.get("https://practice.automationtesting.in/");
    driver.manage().window().setSize(new Dimension(1552, 832));
    driver.findElement(By.linkText("My Account")).click();
    {
      WebElement element = driver.findElement(By.linkText("Shop"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("mhidalgo.pz@gmail.com");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("E185023hc01");
    driver.findElement(By.name("login")).click();
    driver.findElement(By.linkText("Account Details")).click();
    {
      String value = driver.findElement(By.id("account_first_name")).getAttribute("value");
      assertThat(value, is("Marcos"));
    }
    {
      String value = driver.findElement(By.id("account_last_name")).getAttribute("value");
      assertThat(value, is("Hidalgo"));
    }
    {
      String value = driver.findElement(By.id("account_email")).getAttribute("value");
      assertThat(value, is("mhidalgo.pz@gmail.com"));
    }
    driver.findElement(By.linkText("Logout")).click();
    driver.close();
  }
}*/
