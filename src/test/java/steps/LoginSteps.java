package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps(WebDriver webDriver) {
        this.loginPage = new LoginPage(webDriver);
    }

    @Step("Открытие главной страницы")
    public void openMainPage() {
        loginPage.openMainPage();
    }

    @Step("Клик по кнопке 'Войти в аккаунт' на главной странице")
    public void clickLoginButtonOnMainPage() {
        loginPage.clickLoginButtonOnMainPage();
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickProfileButton() {
        loginPage.clickProfileButton();
    }

    @Step("Клик по кнопке 'Войти' на форме регистрации")
    public void clickLoginButtonOnRegisterPage() {
        loginPage.clickLoginButtonOnRegisterPage();
    }

    @Step("Клик по ссылке 'Восстановить пароль'")
    public void clickForgotPasswordButton() {
        loginPage.clickForgotPasswordButton();
    }

    @Step("Клик по кнопке 'Войти' на форме восстановления пароля")
    public void clickLoginButtonOnPasswordRecoveryPage() {
        loginPage.clickLoginButtonOnPasswordRecoveryPage();
    }

    @Step("Клик по ссылке 'Зарегистрироваться'")
    public void clickRegisterLink() {
        loginPage.clickRegisterLink();
    }

    @Step("Ввод email: {email}")
    public void enterEmail(String email) {
        loginPage.enterEmail(email);
    }

    @Step("Ввод пароля: {password}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Step("Проверка отображения кнопки 'Оформить заказ'")
    public boolean getCreateOrderButtonText() {
        return loginPage.getCreateOrderButtonText();
    }

    @Step("Проверка отображения кнопки 'Войти в аккаунт' на главной странице")
    public boolean isLoginButtonOnMainPageDisplayed() {
        return loginPage.isLoginButtonOnMainPageDisplayed();
    }
}

