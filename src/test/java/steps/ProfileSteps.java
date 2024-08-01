package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ProfilePage;

public class ProfileSteps {
    private final ProfilePage profilePage;

    public ProfileSteps(WebDriver webDriver) {
        this.profilePage = new ProfilePage(webDriver);
    }

    @Step("Проверка отображения заголовка 'Профиль'")
    public boolean isProfileHeaderDisplayed() {
        return profilePage.isProfileHeaderDisplayed();
    }

    @Step("Клик по кнопке 'Конструктор'")
    public void clickConstructorButton() {
        profilePage.clickConstructorButton();
    }

    @Step("Клик по логотипу Stellar Burgers")
    public void clickLogo() {
        profilePage.clickLogo();
    }

    @Step("Клик по кнопке 'Выйти' из личного кабинета")
    public void clickLogoutButton() {
        profilePage.clickLogoutButton();
    }
}

