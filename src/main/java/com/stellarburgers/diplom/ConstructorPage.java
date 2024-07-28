package com.stellarburgers.diplom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

import java.time.Duration;

public class ConstructorPage {

    protected final WebDriver webDriver;

    // Локатор для раздела "Булки"
    private final By bunsSection = By.xpath("//span[text()='Булки']");

    // Локатор для раздела "Соусы"
    private final By saucesSection = By.xpath("//span[text()='Соусы']");

    // Локатор для раздела "Начинки"
    private final By fillingsSection = By.xpath("//span[text()='Начинки']");

    // Локатор для активного раздела "Булки"
    private final By activeBunsSection = By.xpath("//div[contains(@class, 'tab_tab_type_current')]//span[text()='Булки']");

    // Локатор для активного раздела "Соусы"
    private final By activeSaucesSection = By.xpath("//div[contains(@class, 'tab_tab_type_current')]//span[text()='Соусы']");

    // Локатор для активного раздела "Начинки"
    private final By activeFillingsSection = By.xpath("//div[contains(@class, 'tab_tab_type_current')]//span[text()='Начинки']");
    public ConstructorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Клик по разделу 'Булки'")
    public void clickBunsSection() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement bunsSectionElement = wait.until(ExpectedConditions.elementToBeClickable(bunsSection));
    }

    @Step("Клик по разделу 'Соусы'")
    public void clickSaucesSection() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement saucesSectionElement = wait.until(ExpectedConditions.elementToBeClickable(saucesSection));
        saucesSectionElement.click();
    }

    @Step("Клик по разделу 'Начинки'")
    public void clickFillingsSection() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement fillingsSectionElement = wait.until(ExpectedConditions.elementToBeClickable(fillingsSection));
        fillingsSectionElement.click();
    }

    @Step("Проверка отображения активного раздела 'Булки'")
    public boolean isBunsSectionDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(activeBunsSection)).isDisplayed();
    }

    @Step("Проверка отображения активного раздела 'Соусы'")
    public boolean isSaucesSectionDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(activeSaucesSection)).isDisplayed();
    }

    @Step("Проверка отображения активного раздела 'Начинки'")
    public boolean isFillingsSectionDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(activeFillingsSection)).isDisplayed();
    }
}
