package com.stellarburgers.diplom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

import java.time.Duration;

public class LoginPage {

    protected final WebDriver webDriver;

    // Локатор для кнопки "Войти в аккаунт" на главной странице
    private final By loginButtonOnMainPage = By.xpath("//button[text()='Войти в аккаунт']");

    // Локатор для кнопки "Личный кабинет"
    private final By profileButton = By.xpath(".//p[text() = 'Личный Кабинет']");

    // Локатор для кнопки "Войти" на форме регистрации
    private final By loginButtonOnRegisterPage = By.xpath("//a[@href='/login']");

    // Локатор для ссылки "Зарегистрироваться" на странице логина
    private final By registerLinkButton = By.cssSelector("a[href='/register']");

    // Локатор для кнопки "Восстановить пароль"
    private final By forgotPasswordButton = By.xpath("//a[text()='Восстановить пароль']");

    // Локатор для кнопки "Войти" на форме восстановления пароля
    private final By loginButtonOnPasswordRecoveryPage = By.xpath("//a[@href='/login']");

    // Локатор для элемента ввода "Email"
    private final By emailInput = By.cssSelector("input[type='text']");

    // Локатор для элемента ввода "Пароль"
    private final By passwordInput = By.cssSelector("input[type='password']");

    // Локатор кнопки "Войти"
    private final By loginButton = By.xpath("//button[text()='Войти']");

    // Локатор заголовка "Оформить заказ"
    private final By createOrderButton = By.xpath("//button[text()='Оформить заказ']");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открытие главной страницы")
    public void openMainPage() {
        webDriver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Step("Клик по кнопке 'Войти в аккаунт' на главной странице")
    public void clickLoginButtonOnMainPage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButtonOnMainPage));
        loginButtonElement.click();
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickProfileButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement profileButtonElement = wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        profileButtonElement.click();
    }

    @Step("Клик по кнопке 'Войти' на форме регистрации")
    public void clickLoginButtonOnRegisterPage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButtonOnRegisterPage));
        loginButtonElement.click();
    }

    @Step("Клик по ссылке 'Восстановить пароль'")
    public void clickForgotPasswordButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordButton));
        loginButtonElement.click();
    }

    @Step("Клик по кнопке 'Войти' на форме восстановления пароля")
    public void clickLoginButtonOnPasswordRecoveryPage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButtonOnPasswordRecoveryPage));
        loginButtonElement.click();
    }

    @Step("Клик по ссылке 'Зарегистрироваться'")
    public void clickRegisterLink() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement registerLinkButtonElement = wait.until(ExpectedConditions.elementToBeClickable(registerLinkButton));
        registerLinkButtonElement.click();
    }

    @Step("Ввод email: {email}")
    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        emailElement.sendKeys(email);
    }

    @Step("Ввод пароля: {password}")
    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordElement.sendKeys(password);
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonElement.click();
    }

    @Step("Проверка отображения кнопки 'Оформить заказ'")
    public boolean getCreateOrderButtonText() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(createOrderButton)).isDisplayed();
    }
    @Step("Проверка отображения кнопки 'Войти в аккаунт' на главной странице")
    public boolean isLoginButtonOnMainPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonOnMainPage)).isDisplayed();
    }
}
