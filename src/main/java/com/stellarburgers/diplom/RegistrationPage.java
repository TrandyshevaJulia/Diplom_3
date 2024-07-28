package com.stellarburgers.diplom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

import java.time.Duration;

public class RegistrationPage {

    protected final WebDriver webDriver;

    // Локатор для кнопки "Войти в аккаунт"
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");

    // Локатор для ссылки "Зарегистрироваться" на странице логина
    private final By registerLinkButton = By.cssSelector("a[href='/register']");

    // Локатор элемента ввода "Имя"
    private final By nameInput = By.cssSelector("form > fieldset:nth-child(1) input");

    // Локатор элемента ввода "Email"
    private final By emailInput = By.cssSelector("form > fieldset:nth-child(2) input");

    // Локатор элемента ввода "Пароль"
    private final By passwordInput = By.cssSelector("form > fieldset:nth-child(3) input");

    // Локатор кнопки "Зарегистрироваться"
    private final By registerButton = By.cssSelector("button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    // Локатор для сообщения об ошибке пароля
    private final By passwordError = By.cssSelector("p.input__error.text_type_main-default");

    // Локатор заголовка "Вход"
    private final By loginHeader = By.cssSelector("h2");

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открытие страницы регистрации")
    public void openRegistrationPage() {
        webDriver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerLinkButton));
    }

    @Step("Клик по ссылке 'Зарегистрироваться'")
    public void clickRegisterLink() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement registerLinkButtonElement = wait.until(ExpectedConditions.elementToBeClickable(registerLinkButton));
        registerLinkButtonElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
    }

    @Step("Ввод имени: {name}")
    public void enterName(String name) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        nameElement.sendKeys(name);
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

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickRegisterButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement registerButtonElement = wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButtonElement.click();
    }

    @Step("Проверка отображения ошибки пароля")
    public boolean isPasswordErrorDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordError)).isDisplayed();
    }

    @Step("Проверка отображения заголовка 'Вход'")
    public boolean isLoginHeaderDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeader)).isDisplayed();
    }
}