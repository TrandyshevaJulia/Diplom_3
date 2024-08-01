package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {

    protected final WebDriver webDriver;

    // Локаторы
    private final By bunsSection = By.xpath("//span[text()='Булки']");
    private final By saucesSection = By.xpath("//span[text()='Соусы']");
    private final By fillingsSection = By.xpath("//span[text()='Начинки']");
    private final By activeBunsSection = By.xpath("//div[contains(@class, 'tab_tab_type_current')]//span[text()='Булки']");
    private final By activeSaucesSection = By.xpath("//div[contains(@class, 'tab_tab_type_current')]//span[text()='Соусы']");
    private final By activeFillingsSection = By.xpath("//div[contains(@class, 'tab_tab_type_current')]//span[text()='Начинки']");

    public ConstructorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickBunsSection() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement bunsSectionElement = wait.until(ExpectedConditions.elementToBeClickable(bunsSection));
        bunsSectionElement.click();
    }

    public void clickSaucesSection() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement saucesSectionElement = wait.until(ExpectedConditions.elementToBeClickable(saucesSection));
        saucesSectionElement.click();
    }

    public void clickFillingsSection() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement fillingsSectionElement = wait.until(ExpectedConditions.elementToBeClickable(fillingsSection));
        fillingsSectionElement.click();
    }

    public boolean isBunsSectionDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(activeBunsSection)).isDisplayed();
    }

    public boolean isSaucesSectionDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(activeSaucesSection)).isDisplayed();
    }

    public boolean isFillingsSectionDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(activeFillingsSection)).isDisplayed();
    }
}
