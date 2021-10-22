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
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		URL gridUrl = new URL(gridServerUrl);
		driver = new RemoteWebDriver(gridUrl, capability);
		driver.get("https://www.google.com");
	}

	@Test
	public void pageTitleIsNotNull() throws MalformedURLException {
   		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Bricomart");   
        	driver.findElement(By.xpath("//button[@name='btnG']")).click();
        	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
        	driver.findElement(By.xpath("(//h3[@class='r']/a)[3]")).click();
        	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
		assertTrue(driver.getTitle() != null);
	}

	@Test
	public void pageTitleContainsGoogle() throws MalformedURLException {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Bricomart");   
        	driver.findElement(By.xpath("//button[@name='btnG']")).click();
        	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
        	driver.findElement(By.xpath("(//h3[@class='r']/a)[3]")).click();
        	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
		assertTrue(driver.getTitle().contains("Google"));
	}
	
	@After
	public void tearDownWebDriver() {
		driver.quit();
	}

}
