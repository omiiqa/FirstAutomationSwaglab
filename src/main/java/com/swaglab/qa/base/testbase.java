package com.swaglab.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.swaglab.qa.utils.TestUtil;
import com.swaglab.qa.utils.WebEventListener;

 
public class testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver edriver;
	public static WebEventListener eventlistener;
	
	public testbase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:/Aworkspace/Swaglabtest/src/main/"
					+ "java/com/swaglab/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public static void initialozation(){
		String browsername=prop.getProperty("browser");	
		if(browsername.equals("chrome")){
        System.setProperty("webdriver.chrome.driver", "C:/Users/HP/Downloads/"
		+ "Selenium/chromedriver_win32/chromedriver.exe");	
			
			driver = new ChromeDriver(); 
			//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			//driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
			
	}
		else if(browsername.equals("FF")){                
		System.setProperty("webdriver.gecko.driver", "C:/Users/HP/Downloads/Selenium"
				+ "/geckodriver-v0.21.0-win64/geckodriver.exe");	
		driver = new FirefoxDriver(); 
	}
		edriver=new EventFiringWebDriver(driver);
		eventlistener=new WebEventListener();
		edriver.register(eventlistener);
		driver=edriver;
		
		
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
driver.get(prop.getProperty("url"));

}
}