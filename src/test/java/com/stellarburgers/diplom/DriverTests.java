package com.stellarburgers.diplom;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverTests extends TestWatcher {
    private WebDriver driver;

    @Override
    protected void starting(Description description) {
        String browser = System.getProperty("browser", "chrome");

        switch (browser.toLowerCase()) {
            case "yandex":
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\yandex124driver.exe");
        ChromeOptions yandexOptions = new ChromeOptions();
        yandexOptions.setBinary("C:\\Users\\Юлия\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(yandexOptions);
            break;
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver-win64\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void finished(Description description) {
        if (driver != null) {
            driver.quit();
        }
    }
}
