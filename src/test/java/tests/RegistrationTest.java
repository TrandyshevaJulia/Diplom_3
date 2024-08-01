package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import steps.RegistrationSteps;
import tests.DriverTest;
import user.User;
import user.UserApiHelper;

import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    private RegistrationSteps registrationSteps;
    private User userCreate;
    private User userLogin;
    private UserApiHelper userApiHelper;
    private String incorrectPassword;

    @Rule
    public DriverTest driverTest = new DriverTest();

    @Before
    public void setUp() {
        WebDriver driver = driverTest.getDriver();
        registrationSteps = new RegistrationSteps(driver);

        Faker faker = new Faker();
        userCreate = new User(faker.internet().emailAddress(), faker.internet().password(6, 12), faker.name().fullName());
        userLogin = new User(userCreate.getEmail(), userCreate.getPassword(), userCreate.getName());
        incorrectPassword = faker.internet().password(1, 5);
        userApiHelper = new UserApiHelper();
        userApiHelper.setUser(userCreate);
        userApiHelper.setUserLogin(userLogin);

        registrationSteps.openRegistrationPage();
        registrationSteps.clickLoginButton();
        registrationSteps.clickRegisterLink();
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void registrationTest() {
        // Вводим данные и кликаем на кнопку "Зарегистрироваться"
        registrationSteps.enterName(userCreate.getName());
        registrationSteps.enterEmail(userCreate.getEmail());
        registrationSteps.enterPassword(userCreate.getPassword());
        registrationSteps.clickRegisterButton();

        // Проверяем успешную регистрацию, используя метод isLoginHeaderDisplayed
        assertTrue("Пользователь должен быть зарегистрирован и видеть заголовок 'Вход'", registrationSteps.isLoginHeaderDisplayed());

        // Проверяем генерацию токена
        String token = userApiHelper.getAccessToken();
        System.out.println("Токен: " + token);
        assertTrue("Токен должен быть сгенерирован", token != null &&  !token.isEmpty());

        // Удаляем пользователя
        userApiHelper.deleteUser();
    }

    @Test
    @DisplayName("Регистрация с некорректным паролем")
    public void registrationNegative() {
        // Вводим данные и кликаем на кнопку "Зарегистрироваться" с некорректным паролем
        registrationSteps.enterName(userCreate.getName());
        registrationSteps.enterEmail(userCreate.getEmail());
        registrationSteps.enterPassword(incorrectPassword);
        registrationSteps.clickRegisterButton();

        // Проверяем сообщение об ошибке пароля, используя метод isPasswordErrorDisplayed
        assertTrue("Некорректный пароль", registrationSteps.isPasswordErrorDisplayed());
    }
}
