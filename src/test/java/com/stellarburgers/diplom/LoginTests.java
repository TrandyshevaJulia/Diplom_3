package com.stellarburgers.diplom;

import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LoginTests {
    private User userCreate;
    private User userLogin;
    private UserApiHelper userApiHelper;
    private LoginPage loginPage;

    @Rule
    public DriverTests driverTest = new DriverTests();

    @Before
    public void setUp() {
        WebDriver driver = driverTest.getDriver();
        loginPage = new LoginPage(driver);

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
        loginPage.openMainPage();
        loginPage.clickLoginButtonOnMainPage();
        loginPage.enterEmail(userLogin.getEmail());
        loginPage.enterPassword(userLogin.getPassword());
        loginPage.clickLoginButton();

        // Проверяем наличие кнопки "Оформить заказ"
        assertTrue("Оформить заказ", loginPage.getCreateOrderButtonText());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginFromProfileButtonTest() {
        loginPage.openMainPage();
        loginPage.clickProfileButton();
        loginPage.enterEmail(userLogin.getEmail());
        loginPage.enterPassword(userLogin.getPassword());
        loginPage.clickLoginButton();

        // Проверяем наличие кнопки "Оформить заказ"
        assertTrue("Оформить заказ", loginPage.getCreateOrderButtonText());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegisterPageTest() {
        loginPage.openMainPage();
        loginPage.clickLoginButtonOnMainPage();
        loginPage.clickRegisterLink();
        loginPage.clickLoginButtonOnRegisterPage();
        loginPage.enterEmail(userLogin.getEmail());
        loginPage.enterPassword(userLogin.getPassword());
        loginPage.clickLoginButton();

        // Проверяем наличие кнопки "Оформить заказ"
        assertTrue("Оформить заказ", loginPage.getCreateOrderButtonText());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromPasswordRecoveryPageTest() {
        loginPage.openMainPage();
        loginPage.clickLoginButtonOnMainPage();
        loginPage.clickForgotPasswordButton();
        loginPage.clickLoginButtonOnPasswordRecoveryPage();
        loginPage.enterEmail(userLogin.getEmail());
        loginPage.enterPassword(userLogin.getPassword());
        loginPage.clickLoginButton();

        // Проверяем наличие кнопки "Оформить заказ"
        assertTrue("Оформить заказ", loginPage.getCreateOrderButtonText());
    }

    @After
    public void tearDown() {
        driverTest.getDriver().quit();
    }
}
