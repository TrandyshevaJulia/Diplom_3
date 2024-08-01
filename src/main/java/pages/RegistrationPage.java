package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    protected final WebDriver webDriver;

    // Локаторы
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By registerLinkButton = By.cssSelector("a[href='/register']");
    private final By nameInput = By.cssSelector("form > fieldset:nth-child(1) input");
    private final By emailInput = By.cssSelector("form > fieldset:nth-child(2) input");
    private final By passwordInput = By.cssSelector("form > fieldset:nth-child(3) input");
    private final By registerButton = By.cssSelector("button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");
    private final By passwordError = By.cssSelector("p.input__error.text_type_main-default");
    private final By loginHeader = By.cssSelector("h2");

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openRegistrationPage() {
        webDriver.get("https://stellarburgers.nomoreparties.site/");
    }

    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerLinkButton));
    }

    public void clickRegisterLink() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement registerLinkButtonElement = wait.until(ExpectedConditions.elementToBeClickable(registerLinkButton));
        registerLinkButtonElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
    }

    public void enterName(String name) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        nameElement.sendKeys(name);
    }

    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordElement.sendKeys(password);
    }

    public void clickRegisterButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement registerButtonElement = wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButtonElement.click();
    }

    public boolean isPasswordErrorDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordError)).isDisplayed();
    }

    public boolean isLoginHeaderDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeader)).isDisplayed();
    }
}