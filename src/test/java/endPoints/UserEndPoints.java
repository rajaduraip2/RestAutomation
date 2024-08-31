package endPoints;


import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;



//Created for perform CRUD operations.
public class UserEndPoints {

    public static Response createUser(User payLoad) {

        Response userCreateResponse = given().log().all().contentType("application/json").accept("application/json")
                .body(payLoad)
                .when().post(Routes.user_post_Url);

        return userCreateResponse;

    }

    public static Response getUser(String userName) {

        Response getUserResponse = given().pathParam("username", userName)
                .accept("application/json")
                .when().get(Routes.user_get_Url);

        return getUserResponse;

    }

    public static Response updateUser(String userName,User payLoad) {
        Response userUpdateResponse = given().log().all().pathParam("username", userName)
                .contentType("application/json").accept("application/json")
                .body(payLoad)
                .when().put(Routes.user_put_Url);

        return userUpdateResponse;
    }

    public static Response deleteUser(String userName) {

        Response deleteUserResponse = given().pathParam("username", userName)
                .accept("application/json")
                .when().get(Routes.user_delete_Url);

        return deleteUserResponse;

    }


}



