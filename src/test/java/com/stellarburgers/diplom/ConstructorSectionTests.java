package com.stellarburgers.diplom;

import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ConstructorSectionTests  {

    private User userCreate;
    private User userLogin;
    private UserApiHelper userApiHelper;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private ConstructorPage constructorPage;

    @Rule
    public DriverTests driverTest = new DriverTests();

    @Before
    public void setUp() {
        WebDriver driver = driverTest.getDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        constructorPage = new ConstructorPage(driver);

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
    @DisplayName("Проверка переходов к разделам 'Булки', 'Соусы' и 'Начинки' в конструкторе")
    public void checkConstructorSections() {
        // Переход в конструктор
        profilePage.clickConstructorButton();

        // Проверка раздела "Булки"
        constructorPage.clickBunsSection();
        assertTrue("Булки", constructorPage.isBunsSectionDisplayed());

        // Проверка раздела "Соусы"
        constructorPage.clickSaucesSection();
        assertTrue("Соусы", constructorPage.isSaucesSectionDisplayed());

        // Проверка раздела "Начинки"
        constructorPage.clickFillingsSection();
        assertTrue("Начинки", constructorPage.isFillingsSectionDisplayed());
    }
        @After
        public void tearDown() {
            userApiHelper.deleteUser();
            driverTest.getDriver().quit();
        }
    }
