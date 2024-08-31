package endPoints;

import io.restassured.response.Response;
import payload.User;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndPoints2 {
    static ResourceBundle getUrl(){
        ResourceBundle routes=ResourceBundle.getBundle("routes");
        return routes;
    }


    public static Response createUser(User payLoad) {
String postUrl= getUrl().getString("user_post_Url");
        Response userCreateResponse = given().log().all().contentType("application/json").accept("application/json")
                .body(payLoad)
                .when().post(postUrl);

        return userCreateResponse;

    }

    public static Response getUser(String userName) {
        String getUrl= getUrl().getString("user_get_Url");

        Response getUserResponse = given().log().all().pathParam("username", userName)
                .accept("application/json")
                .when().get(getUrl);

        return getUserResponse;

    }

    public static Response updateUser(String userName,User payLoad) {
        Response userUpdateResponse = given().log().all().pathParam("username", userName)
                .contentType("application/json").accept("application/json")
                .body(payLoad)
                .when().put(getUrl().getString("user_put_Url"));

        return userUpdateResponse;
    }

    public static Response deleteUser(String userName) {

        Response deleteUserResponse = given().log().all().pathParam("username", userName)
                .accept("application/json")
                .when().get(getUrl().getString("user_delete_Url"));

        return deleteUserResponse;

    }

}
