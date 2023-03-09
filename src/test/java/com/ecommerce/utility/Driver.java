package com.ecommerce.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Driver {
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    /**
     * Singleton Design Pattern:
     * In our project we implemented singleton design pattern.
     * To achieve this we created our own driver class and we kept the Driver constructor as private.
     * And because of this nobody can create object of this Diver class.
     * So in the entire project we used single driver.
     * This is called Singleton Design pattern.
     * Another way to achive this is creating the class as Abstract.
     * <p>
     * Driver.getDriver() ==> driver
     */
    private Driver() {
    }

    public static WebDriver getDriver() {

        //if this thread doesn't have a web Driver yet - create it and add to pool
        if (driverPool.get() == null) {
            System.out.println("===============================================================");
            System.out.println("|          Environment : " + ConfigReader.getProperty("env"));
            System.out.println("|          Operating System : " + System.getProperty("os.name"));
            System.out.println("|          Browser: " + ConfigReader.getProperty("browser"));
            System.out.println("===============================================================\n");
            // this line will tell which browser should open based on the value from properties file
            String browserParamFromEnv = System.getProperty("browser"); // null or any browser (firefox)
            String browser = browserParamFromEnv == null ? ConfigReader.getProperty("browser") : browserParamFromEnv;
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    //WebDriver driver =new ChromeDriver();
                    DesiredCapabilities caps = new DesiredCapabilities();

                    /**
                     *We have disabled the cookies in below ChromeOptions
                     * You need to add this feature to your configuration.properties
                     * Add cookiesEnableDisable=2  (disable the cookies)
                     * Add cookiesEnableDisable =0  (enable the cookies)
                     */
                    ChromeOptions options = new ChromeOptions();
                    Map<String, Object> prefs = new HashMap<>();
                    Map<String, Object> profile = new HashMap<>();
                    Map<String, Object> contentSettings = new HashMap<>();

                    contentSettings.put("cookies", ConfigReader.getProperty("cookiesEnableDisable"));
                    profile.put("managed_default_content_settings", contentSettings);
                    prefs.put("profile", profile);
                    options.setExperimentalOption("prefs", prefs);
                    options.addArguments("--remote-allow-origins=*");
                    caps.setCapability(ChromeOptions.CAPABILITY, options);

                    driverPool.set(new ChromeDriver(options));
                    break;
                case "chrome_headless":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options1 = new ChromeOptions();
                    options1.addArguments("--remote-allow-origins=*");
                    driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setProfile(firefoxProfile());
                    driverPool.set(new FirefoxDriver(firefoxOptions));
                    break;
                case "firefox_headless":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    }
                    WebDriverManager.iedriver().setup();
                    driverPool.set(new InternetExplorerDriver());
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Edge");
                    }
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your OS doesn't support Safari");

                    }
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driverPool.set(new SafariDriver());
                    break;
                case "remote_chrome":
                    try {
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setCapability("platform", Platform.ANY);
                        driverPool.set(new RemoteWebDriver(new URL("http://localhost:4444//wd/hub"), chromeOptions));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote_firefox":
                    try {
                        firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setCapability("platform", Platform.ANY);
                        driverPool.set(new RemoteWebDriver(new URL("http://localhost:4444//wd/hub"), firefoxOptions));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        //return corresponded to thread id webDriver object
        return driverPool.get();
    }

    public static FirefoxProfile firefoxProfile() {

        //Added for download template settings to change the file location
        FirefoxProfile firefoxProfile = new FirefoxProfile();

        try {
            //download directory path
            firefoxProfile.setPreference("browser.download.folderList", 2);
            firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
            firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                    "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
        } catch (Exception e) {

            System.out.println("Profile can't be configured for Firefox.");
        }
        return firefoxProfile;
    }

    public static void close() {
        if (driverPool.get() != null) {
            //driverPool.get().close();
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
