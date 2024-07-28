package com.stellarburgers.diplom;

import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class RegistrationTests  {
    private RegistrationPage registrationPage;
    private User userCreate;
    private User userLogin;
    private UserApiHelper userApiHelper;
    private String incorrectPassword;

    @Rule
    public DriverTests driverTest = new DriverTests();

    @Before
    public void setUp() {
        WebDriver driver = driverTest.getDriver();
        registrationPage = new RegistrationPage(driver);

        Faker faker = new Faker();
        userCreate = new User(faker.internet().emailAddress(), faker.internet().password(6, 12), faker.name().fullName());
        userLogin = new User(userCreate.getEmail(), userCreate.getPassword(), userCreate.getName());
        incorrectPassword = faker.internet().password(1, 5);
        userApiHelper = new UserApiHelper();
        userApiHelper.setUser(userCreate);
        userApiHelper.setUserLogin(userLogin);

        registrationPage.openRegistrationPage();
        registrationPage.clickLoginButton();
        registrationPage.clickRegisterLink();
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void registrationTest() {
        // Вводим данные и кликаем на кнопку "Зарегистрироваться"
        registrationPage.enterName(userCreate.getName());
        registrationPage.enterEmail(userCreate.getEmail());
        registrationPage.enterPassword(userCreate.getPassword());
        registrationPage.clickRegisterButton();

        // Проверяем успешную регистрацию, используя метод isLoginHeaderDisplayed
        assertTrue("Пользователь должен быть зарегистрирован и видеть заголовок 'Вход'", registrationPage.isLoginHeaderDisplayed());

        // Проверяем генерацию токена
        String token = userApiHelper.getAccessToken();
        System.out.println("Токен: " + token);
        assertTrue("Токен должен быть сгенерирован", token != null && !token.isEmpty());

        // Удаляем пользователя
        userApiHelper.deleteUser();
    }

    @Test
    @DisplayName("Регистрация с некорректным паролем")
    public void registrationNegative() {
        // Вводим данные и кликаем на кнопку "Зарегистрироваться" с некорректным паролем
        registrationPage.enterName(userCreate.getName());
        registrationPage.enterEmail(userCreate.getEmail());
        registrationPage.enterPassword(incorrectPassword);
        registrationPage.clickRegisterButton();

        // Проверяем сообщение об ошибке пароля, используя метод isPasswordErrorDisplayed
        assertTrue("Некорректный пароль", registrationPage.isPasswordErrorDisplayed());
    }
}
