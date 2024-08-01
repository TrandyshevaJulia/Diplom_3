package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ConstructorPage;

public class ConstructorSteps {
    private final ConstructorPage constructorPage;

    public ConstructorSteps(WebDriver webDriver) {
        this.constructorPage = new ConstructorPage(webDriver);
    }

    @Step("Клик по разделу 'Булки'")
    public void clickBunsSection() {
        constructorPage.clickBunsSection();
    }

    @Step("Клик по разделу 'Соусы'")
    public void clickSaucesSection() {
        constructorPage.clickSaucesSection();
    }

    @Step("Клик по разделу 'Начинки'")
    public void clickFillingsSection() {
        constructorPage.clickFillingsSection();
    }

    @Step("Проверка отображения активного раздела 'Булки'")
    public boolean isBunsSectionDisplayed() {
        return constructorPage.isBunsSectionDisplayed();
    }

    @Step("Проверка отображения активного раздела 'Соусы'")
    public boolean isSaucesSectionDisplayed() {
        return constructorPage.isSaucesSectionDisplayed();
    }

    @Step("Проверка отображения активного раздела 'Начинки'")
    public boolean isFillingsSectionDisplayed() {
        return constructorPage.isFillingsSectionDisplayed();
    }
}

