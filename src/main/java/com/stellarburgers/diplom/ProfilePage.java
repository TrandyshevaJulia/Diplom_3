package com.stellarburgers.diplom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

import java.time.Duration;

public class ProfilePage {

    protected final WebDriver webDriver;

    // Локатор для заголовка "Профиль"
    private final By profileHeader = By.xpath(".//*[text() = 'Профиль']");

    // Локатор для кнопки "Конструктор"
    private final By constructorButton = By.xpath(".//*[text() = 'Конструктор']");

    // Локатор для логотипа Stellar Burgers
    private final By logoButton = By.className("AppHeader_header__logo__2D0X2");

    // Локатор для кнопки "Выход" в личном кабинете
    private final By logoutButton = By.xpath(".//button[text() = 'Выход']");

    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Проверка отображения заголовка 'Профиль'")
    public boolean isProfileHeaderDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profileHeader)).isDisplayed();
    }

    @Step("Клик по кнопке 'Конструктор'")
    public void clickConstructorButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement constructorButtonElement = wait.until(ExpectedConditions.elementToBeClickable(constructorButton));
        constructorButtonElement.click();
    }

    @Step("Клик по логотипу Stellar Burgers")
    public void clickLogo() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement logoButtonElement = wait.until(ExpectedConditions.elementToBeClickable(logoButton));
        logoButtonElement.click();
    }

    @Step("Клик по кнопке 'Выйти' из личного кабинета")
    public void clickLogoutButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement logoutButtonElement = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButtonElement.click();
    }
}