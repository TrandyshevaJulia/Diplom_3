package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverTest extends TestWatcher {
    private WebDriver driver;

    @Override
    protected void starting(Description description) {
        String browser = System.getProperty("browser", "chrome");

        switch (browser.toLowerCase()) {
            case "yandex":
                // Используем ресурсный пакет для Yandex драйвера
                File yandexDriver = new File(getClass().getClassLoader().getResource("resources/yandex124driver.exe").getFile());
                System.setProperty("webdriver.chrome.driver", yandexDriver.getAbsolutePath());

                ChromeOptions yandexOptions = new ChromeOptions();
                yandexOptions.setBinary("C:\\Users\\Юлия\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                driver = new ChromeDriver(yandexOptions);
                break;
            case "chrome":
            default:
                // Используем WebDriverManager для Chrome драйвера
                WebDriverManager.chromedriver().clearDriverCache().setup();
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
