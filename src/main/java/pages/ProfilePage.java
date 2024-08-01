package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    protected final WebDriver webDriver;

    // Локаторы
    private final By profileHeader = By.xpath(".//*[text() = 'Профиль']");
    private final By constructorButton = By.xpath(".//*[text() = 'Конструктор']");
    private final By logoButton = By.className("AppHeader_header__logo__2D0X2");
    private final By logoutButton = By.xpath(".//button[text() = 'Выход']");

    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean isProfileHeaderDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profileHeader)).isDisplayed();
    }

    public void clickConstructorButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement constructorButtonElement = wait.until(ExpectedConditions.elementToBeClickable(constructorButton));
        constructorButtonElement.click();
    }

    public void clickLogo() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement logoButtonElement = wait.until(ExpectedConditions.elementToBeClickable(logoButton));
        logoButtonElement.click();
    }

    public void clickLogoutButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement logoutButtonElement = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButtonElement.click();
    }
}