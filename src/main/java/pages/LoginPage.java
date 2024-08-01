package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    protected final WebDriver webDriver;

    // Локаторы
    private final By loginButtonOnMainPage = By.xpath("//button[text()='Войти в аккаунт']");
    private final By profileButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private final By loginButtonOnRegisterPage = By.xpath("//a[@href='/login']");
    private final By registerLinkButton = By.cssSelector("a[href='/register']");
    private final By forgotPasswordButton = By.xpath("//a[text()='Восстановить пароль']");
    private final By loginButtonOnPasswordRecoveryPage = By.xpath("//a[@href='/login']");
    private final By emailInput = By.cssSelector("input[type='text']");
    private final By passwordInput = By.cssSelector("input[type='password']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By createOrderButton = By.xpath("//button[text()='Оформить заказ']");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openMainPage() {
        webDriver.get("https://stellarburgers.nomoreparties.site/");
    }

    public void clickLoginButtonOnMainPage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButtonOnMainPage));
        loginButtonElement.click();
    }

    public void clickProfileButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement profileButtonElement = wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        profileButtonElement.click();
    }

    public void clickLoginButtonOnRegisterPage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButtonOnRegisterPage));
        loginButtonElement.click();
    }

    public void clickForgotPasswordButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordButton));
        loginButtonElement.click();
    }

    public void clickLoginButtonOnPasswordRecoveryPage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButtonOnPasswordRecoveryPage));
        loginButtonElement.click();
    }

    public void clickRegisterLink() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement registerLinkButtonElement = wait.until(ExpectedConditions.elementToBeClickable(registerLinkButton));
        registerLinkButtonElement.click();
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

    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonElement.click();
    }

    public boolean getCreateOrderButtonText() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(createOrderButton)).isDisplayed();
    }

    public boolean isLoginButtonOnMainPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonOnMainPage)).isDisplayed();
    }
}
