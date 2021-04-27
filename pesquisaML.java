package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://www.mercadolivre.com.br/");
    driver.findElement(By.name("as_word")).click();
    driver.findElement(By.name("as_word")).clear();
    driver.findElement(By.name("as_word")).sendKeys("placa de video");
    driver.findElement(By.name("as_word")).sendKeys(Keys.ENTER);
    assertTrue(isElementPresent(By.xpath("//*[@id=\"root-app\"]/div/div[1]/aside/div[1]/h1")));
    driver.findElement(By.xpath("//img[@alt='Placa de vídeo Nvidia Galax  GeForce 700 Series GT 710 71GPF4HI00GX 2GB']")).click();
    driver.findElement(By.xpath("//main[@id='root-app']/div[2]/div[2]/div/div[2]/div/form/div[4]/div/button[2]/span")).click();
    driver.findElement(By.linkText("Ver carrinho")).click();
    assertTrue(isElementPresent(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div[4]/div/div/div/article/div[2]/div[1]/h2/a")));
    // ERROR: Caught exception [unknown command []]
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
