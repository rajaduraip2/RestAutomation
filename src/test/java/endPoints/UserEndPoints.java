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

    public static Response getOnlineUsers(){
        Response getGraphQLResponse= given().contentType("application/json").header("Authorization","\n" +
                        "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY2ZDQxMzlmYjljMDk5NjFhN2E1OTVkZSJ9LCJuaWNrbmFtZSI6ImR1cmFpcHIyIiwibmFtZSI6ImR1cmFpcHIyQGdhbWlsLmNvbSIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci83OTljZGVhYjE4ZDIyZjFhNGY4OTBmZGVhNzRjNDFhOD9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRmR1LnBuZyIsInVwZGF0ZWRfYXQiOiIyMDI0LTA5LTAxVDA3OjExOjI4Ljk5NVoiLCJpc3MiOiJodHRwczovL2dyYXBocWwtdHV0b3JpYWxzLmF1dGgwLmNvbS8iLCJhdWQiOiJQMzhxbkZvMWxGQVFKcnprdW4tLXdFenFsalZOR2NXVyIsImlhdCI6MTcyNTE3NDY5MCwiZXhwIjoxNzI1MjEwNjkwLCJzdWIiOiJhdXRoMHw2NmQ0MTM5ZmI5YzA5OTYxYTdhNTk1ZGUiLCJhdF9oYXNoIjoiamlETW1nNTJpSW9zNFVSYll4aEJmQSIsInNpZCI6InEyZFhEblNLV180X3ZWTmphd2R3X3BlZDhMTjA2R1RKIiwibm9uY2UiOiJBc2ZEQ19MTXl1Z1BjZXFPWnFVWHpkUjhkSW9LSGRuMCJ9.Mk-mabQtk0k8WsKUn-icEiwLGTKI8U_gEseMdiIkF_nn11E2qmXwt5cz6oJky-FXICJ34ECZI4YQcGA65lmMKDECwOyGXLsGDtZxoVni_VH2h6qn_AfSUwU12WUBXevVrCHv1FEplxd1GuwcsmboVVNMn08c2qWjNsvPpg8pk-UXEQsP_2KTlBTqGMAJpuQ0f2Gbr3OmMNtE5gQV-OQE3ZRhGpmNK1bkliNfJIYjKDy4F6pLdr3GCBLCxM4s9o8HXEcF1hER1JT-qmutcukeyVdVgsXGKhcLwZPzJpqrQdx4HWRiLhDVaKOqdNBl7paR1YLkbGN8xlns5kViBk5v1w")
                .body( "{\n" +
                        "  \"query\": \"query { users { name id } }\"\n" +
                        "}").post(Routes.grphQl_Url);

        return getGraphQLResponse;
    }
    public static Response createUsers(){
        String graphqlQuery = "{\"query\":\" \\n  mutation{\\n  insert_todos(objects: [{title: \\\"Sdet Automation\\\"}]) {\\n    affected_rows\\n    returning {\\n      created_at\\n      id\\n      title\\n    }\\n  }\\n}\\n\",\"variables\":null}";
        Response CreateGraphQLResponse= given().contentType("application/json").header("Authorization","\n" +
                        "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY2ZDQxMzlmYjljMDk5NjFhN2E1OTVkZSJ9LCJuaWNrbmFtZSI6ImR1cmFpcHIyIiwibmFtZSI6ImR1cmFpcHIyQGdhbWlsLmNvbSIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci83OTljZGVhYjE4ZDIyZjFhNGY4OTBmZGVhNzRjNDFhOD9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRmR1LnBuZyIsInVwZGF0ZWRfYXQiOiIyMDI0LTA5LTAxVDA3OjExOjI4Ljk5NVoiLCJpc3MiOiJodHRwczovL2dyYXBocWwtdHV0b3JpYWxzLmF1dGgwLmNvbS8iLCJhdWQiOiJQMzhxbkZvMWxGQVFKcnprdW4tLXdFenFsalZOR2NXVyIsImlhdCI6MTcyNTE3NDY5MCwiZXhwIjoxNzI1MjEwNjkwLCJzdWIiOiJhdXRoMHw2NmQ0MTM5ZmI5YzA5OTYxYTdhNTk1ZGUiLCJhdF9oYXNoIjoiamlETW1nNTJpSW9zNFVSYll4aEJmQSIsInNpZCI6InEyZFhEblNLV180X3ZWTmphd2R3X3BlZDhMTjA2R1RKIiwibm9uY2UiOiJBc2ZEQ19MTXl1Z1BjZXFPWnFVWHpkUjhkSW9LSGRuMCJ9.Mk-mabQtk0k8WsKUn-icEiwLGTKI8U_gEseMdiIkF_nn11E2qmXwt5cz6oJky-FXICJ34ECZI4YQcGA65lmMKDECwOyGXLsGDtZxoVni_VH2h6qn_AfSUwU12WUBXevVrCHv1FEplxd1GuwcsmboVVNMn08c2qWjNsvPpg8pk-UXEQsP_2KTlBTqGMAJpuQ0f2Gbr3OmMNtE5gQV-OQE3ZRhGpmNK1bkliNfJIYjKDy4F6pLdr3GCBLCxM4s9o8HXEcF1hER1JT-qmutcukeyVdVgsXGKhcLwZPzJpqrQdx4HWRiLhDVaKOqdNBl7paR1YLkbGN8xlns5kViBk5v1w")
                .body(graphqlQuery).post(Routes.grphQl_Url);

        return CreateGraphQLResponse;
    }

}



