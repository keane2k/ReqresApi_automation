package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.UserModel;
import utilities.ConfigReader;
import static io.restassured.RestAssured.*;

public class UserService {

    // reading base url from the conf file
    private static final String BASE_URL = ConfigReader.getProperty("base_url");

    // method for creating user, incomplete version of full restassure process, without .given
    //will use the method in test

    public static Response createUser(UserModel user) {
        return given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(user) // Sənin yaratdığın UserModel-i bura qoyuruq
                .when()
                .post("users"); // Endpoint
    }


    public static Response getUser(int id) {
        return given()
                .baseUri(BASE_URL)
                .accept(ContentType.JSON)
                .when()
                .get("users/" + id);
    }
}