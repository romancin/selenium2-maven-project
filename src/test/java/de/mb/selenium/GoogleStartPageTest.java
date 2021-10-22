package de.mb.selenium;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GoogleStartPageTest {

	private WebDriver driver;

	@Before
	public void setUp() throws MalformedURLException {
		String serverUrl = System.getProperty("grid.server.url");
		String gridServerUrl = "http://seleniumhub/wd/hub";
		if (serverUrl != null) {
			gridServerUrl = serverUrl;
		}
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		URL gridUrl = new URL(gridServerUrl);
		driver = new RemoteWebDriver(gridUrl, capability);
		driver.get("https://www.google.com");
	}

	@Test
	public void pageTitleIsNotNull() throws MalformedURLException {
   		WebElement p=driver.findElement(By.name("q"));
      		//enter text with sendKeys() then apply submit()
     		p.sendKeys("Bricomart");
      		// Explicit wait condition for search results
      		WebDriverWait w = new WebDriverWait(driver, 5);
      		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
      		p.submit();
		assertTrue(driver.getTitle() != null);
	}

	@Test
	public void pageTitleContainsGoogle() throws MalformedURLException {
		WebElement p=driver.findElement(By.name("q"));
      		//enter text with sendKeys() then apply submit()
     		p.sendKeys("Bricomart");
      		// Explicit wait condition for search results
      		WebDriverWait w = new WebDriverWait(driver, 5);
      		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
      		p.submit();
		assertTrue(driver.getTitle().contains("Google"));
	}
	
	@After
	public void tearDownWebDriver() {
		driver.quit();
	}

}
