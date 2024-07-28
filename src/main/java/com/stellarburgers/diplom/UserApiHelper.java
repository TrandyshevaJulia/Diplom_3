package com.stellarburgers.diplom;

import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserApiHelper {
    private User user;
    private User userLogin;

    private RequestSpecification spec() {
        return given().baseUri("https://stellarburgers.nomoreparties.site/api");
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserLogin(User userLogin) {
        this.userLogin = userLogin;
    }

    @Step("Создание пользователя")
    public void createUser() {
        given().log().all()
                .spec(spec())
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post("/auth/register")
                .then()
                .statusCode(200);
    }

    @Step("Получение accessToken для пользователя")
    public String getAccessToken() {
        // Выводим email, пароль и имя в консоль
        System.out.println("Получение токена для пользователя:");
        System.out.println("Email: " + userLogin.getEmail());
        System.out.println("Пароль: " + userLogin.getPassword());
        System.out.println("Имя: " + userLogin.getName());

        return given().log().all()
                .spec(spec())
                .header("Content-Type", "application/json")
                .body(userLogin)
                .when().post("/auth/login")
                .then()
                .statusCode(200)
                .extract().path("accessToken");
    }

    @Step("Удаление пользователя")
    public void deleteUser() {
        String accessToken = getAccessToken();
        if (accessToken != null) {
            given().log().all()
                    .spec(spec())
                    .header("Authorization", "Bearer " + accessToken)
                    .delete("/auth/user");
        }
    }
}

