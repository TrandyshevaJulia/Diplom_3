package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;

public class RegistrationSteps {
    private final RegistrationPage registrationPage;

    public RegistrationSteps(WebDriver webDriver) {
        this.registrationPage = new RegistrationPage(webDriver);
    }

    @Step("Открытие страницы регистрации")
    public void openRegistrationPage() {
        registrationPage.openRegistrationPage();
    }

    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickLoginButton() {
        registrationPage.clickLoginButton();
    }

    @Step("Клик по ссылке 'Зарегистрироваться'")
    public void clickRegisterLink() {
        registrationPage.clickRegisterLink();
    }

    @Step("Ввод имени: {name}")
    public void enterName(String name) {
        registrationPage.enterName(name);
    }

    @Step("Ввод email: {email}")
    public void enterEmail(String email) {
        registrationPage.enterEmail(email);
    }

    @Step("Ввод пароля: {password}")
    public void enterPassword(String password) {
        registrationPage.enterPassword(password);
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickRegisterButton() {
        registrationPage.clickRegisterButton();
    }

    @Step("Проверка отображения ошибки пароля")
    public boolean isPasswordErrorDisplayed() {
        return registrationPage.isPasswordErrorDisplayed();
    }

    @Step("Проверка отображения заголовка 'Вход'")
    public boolean isLoginHeaderDisplayed() {
        return registrationPage.isLoginHeaderDisplayed();
    }
}

