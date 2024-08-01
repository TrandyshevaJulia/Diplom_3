package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import steps.ConstructorSteps;
import steps.LoginSteps;
import steps.ProfileSteps;
import user.User;
import user.UserApiHelper;

import static org.junit.Assert.assertTrue;

public class ConstructorSectionTest {

    private User userCreate;
    private User userLogin;
    private UserApiHelper userApiHelper;
    private LoginSteps loginSteps;
    private ProfileSteps profileSteps;
    private ConstructorSteps constructorSteps;

    @Rule
    public DriverTest driverTest = new DriverTest();

    @Before
    public void setUp() {
        WebDriver driver = driverTest.getDriver();
        loginSteps = new LoginSteps(driver);
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
        loginSteps.openMainPage();
        loginSteps.clickLoginButtonOnMainPage();
        loginSteps.enterEmail(userLogin.getEmail());
        loginSteps.enterPassword(userLogin.getPassword());
        loginSteps.clickLoginButton();
    }

    @Test
    @DisplayName("Проверка переходов к разделам 'Булки', 'Соусы' и 'Начинки' в конструкторе")
    public void checkConstructorSections() {
        // Переход в конструктор
        profileSteps.clickConstructorButton();

        // Проверка раздела "Булки"
        assertTrue("Булки", constructorSteps.isBunsSectionDisplayed());

        // Проверка раздела "Соусы"
        constructorSteps.clickSaucesSection();
        assertTrue("Соусы", constructorSteps.isSaucesSectionDisplayed());

        // Проверка раздела "Начинки"
        constructorSteps.clickFillingsSection();
        assertTrue("Начинки", constructorSteps.isFillingsSectionDisplayed());
    }

    @After
    public void tearDown() {
        userApiHelper.deleteUser();
        driverTest.getDriver().quit();
    }
}