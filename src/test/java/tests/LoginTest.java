package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import steps.LoginSteps;
import tests.DriverTest;
import user.User;
import user.UserApiHelper;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    private User userCreate;
    private User userLogin;
    private UserApiHelper userApiHelper;
    private LoginSteps loginSteps;

    @Rule
    public DriverTest driverTest = new DriverTest();

    @Before
    public void setUp() {
        WebDriver driver = driverTest.getDriver();
        loginSteps = new LoginSteps(driver);

        Faker faker = new Faker();
        userCreate = new User(faker.internet().emailAddress(), faker.internet().password(6, 12), faker.name().fullName());
        userLogin = new User(userCreate.getEmail(), userCreate.getPassword(), userCreate.getName());

        userApiHelper = new UserApiHelper();
        userApiHelper.setUser(userCreate);
        userApiHelper.setUserLogin(userLogin);

        // Регистрация пользователя через API
        userApiHelper.createUser();
    }

    @Test
    @DisplayName("Вход через кнопку 'Войти в аккаунт' на главной странице")
    public void loginThroughMainPage() {
        loginSteps.openMainPage();
        loginSteps.clickLoginButtonOnMainPage();
        loginSteps.enterEmail(userLogin.getEmail());
        loginSteps.enterPassword(userLogin.getPassword());
        loginSteps.clickLoginButton();

        // Проверяем наличие кнопки "Оформить заказ"
        assertTrue("Оформить заказ", loginSteps.getCreateOrderButtonText());
    }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    public void loginFromProfileButtonTest() {
        loginSteps.openMainPage();
        loginSteps.clickProfileButton();
        loginSteps.enterEmail(userLogin.getEmail());
        loginSteps.enterPassword(userLogin.getPassword());
        loginSteps.clickLoginButton();

        // Проверяем наличие кнопки "Оформить заказ"
        assertTrue("Оформить заказ", loginSteps.getCreateOrderButtonText());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegisterPageTest() {
        loginSteps.openMainPage();
        loginSteps.clickLoginButtonOnMainPage();
        loginSteps.clickRegisterLink();
        loginSteps.clickLoginButtonOnRegisterPage();
        loginSteps.enterEmail(userLogin.getEmail());
        loginSteps.enterPassword(userLogin.getPassword());
        loginSteps.clickLoginButton();

        // Проверяем наличие кнопки "Оформить заказ"
        assertTrue("Оформить заказ", loginSteps.getCreateOrderButtonText());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromPasswordRecoveryPageTest() {
        loginSteps.openMainPage();
        loginSteps.clickLoginButtonOnMainPage();
        loginSteps.clickForgotPasswordButton();
        loginSteps.clickLoginButtonOnPasswordRecoveryPage();
        loginSteps.enterEmail(userLogin.getEmail());
        loginSteps.enterPassword(userLogin.getPassword());
        loginSteps.clickLoginButton();

        // Проверяем наличие кнопки "Оформить заказ"
        assertTrue("Оформить заказ", loginSteps.getCreateOrderButtonText());
    }

    @After
    public void tearDown() {
        driverTest.getDriver().quit();
    }
}
