package tests;

import io.restassured.response.Response;
import models.UserModel;
import org.junit.Assert;
import org.junit.Test;
import services.UserService;

public class UserTests {

    @Test

    public void getSingleUserTest() {

        System.out.println("User get testi run olunur");

        Response response = UserService.getUser(2);

        response.prettyPrint();

        Assert.assertEquals(200, response.getStatusCode());

        String firstName = response.jsonPath().getString("data.first_name");
        Assert.assertEquals("Janet", firstName);

        System.out.println("Test uğurla keçdi! Tapılan istifadəçi: " + firstName);
    }

    @Test
    public void createNewUserWithModelTest() {

        System.out.println("User post testi run olunur");

        // creating object of our model
        UserModel newUser = new UserModel();
        newUser.setName("Kanan");
        newUser.setJob("QA");

        // sending this object with the help of service
        Response response = UserService.createUser(newUser);

        response.prettyPrint();

        Assert.assertEquals(201, response.getStatusCode());

        String actualName = response.jsonPath().getString("name");
        Assert.assertEquals("Kanan", actualName);
    }


}