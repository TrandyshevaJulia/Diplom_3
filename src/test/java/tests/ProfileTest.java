package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;
import steps.ConstructorSteps;
import steps.ProfileSteps;
import tests.DriverTest;
import user.User;
import user.UserApiHelper;

import static org.junit.Assert.assertTrue;

public class ProfileTest {
    private User userCreate;
    private User userLogin;
    private UserApiHelper userApiHelper;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private RegistrationPage registrationPage;
    private ProfileSteps profileSteps;
    private ConstructorSteps constructorSteps;

    @Rule
    public DriverTest driverTest = new DriverTest();

    @Before
    public void setUp() {
        WebDriver driver = driverTest.getDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        registrationPage = new RegistrationPage(driver);
        profileSteps = new ProfileSteps(driver);
        constructorSteps = new ConstructorSteps(driver);

        Faker faker = new Faker();
        userCreate = new User(faker.internet().emailAddress(), faker.internet().password(6, 12), faker.name().fullName());
        userLogin = new User(userCreate.getEmail(), userCreate.getPassword(), userCreate.getName());

        userApiHelper = new UserApiHelper();
        userApiHelper.setUser(userCreate);
        userApiHelper.setUserLogin(userLogin);

        // Регистрация пользователя через API
        userApiHelper.createUser();

        // Вход в аккаунт
        loginPage.openMainPage();
        loginPage.clickLoginButtonOnMainPage();
        loginPage.enterEmail(userLogin.getEmail());
        loginPage.enterPassword(userLogin.getPassword());
        loginPage.clickLoginButton();
    }

    @Test
    @DisplayName("Переход по клику на 'Личный кабинет'")
    public void navigateToProfile() {
        loginPage.clickProfileButton();
        assertTrue("Профиль", profileSteps.isProfileHeaderDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на 'Конструктор'")
    public void navigateToConstructorFromProfile() {
        loginPage.clickProfileButton();
        profileSteps.clickConstructorButton();
        assertTrue("Оформить заказ", constructorSteps.isBunsSectionDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void navigateToConstructorFromProfileByLogo() {
        loginPage.clickProfileButton();
        profileSteps.clickLogo();
        assertTrue("Оформить заказ", constructorSteps.isBunsSectionDisplayed());
    }

    @Test
    @DisplayName("Выход из аккаунта по кнопке 'Выход' в личном кабинете")
    public void logoutFromProfile() {
        loginPage.clickProfileButton();
        profileSteps.clickLogoutButton();
        assertTrue("Вход", registrationPage.isLoginHeaderDisplayed());
    }

    @After
    public void tearDown() {
        userApiHelper.deleteUser();
        driverTest.getDriver().quit();
    }
}

