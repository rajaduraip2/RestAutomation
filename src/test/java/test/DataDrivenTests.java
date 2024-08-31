package test;

import endPoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload.User;
import utilities.DataProviders;

public class DataDrivenTests {


    @Test(priority = 1,dataProvider ="Data", dataProviderClass = DataProviders.class)
    public void  testPostUser(String UserID,String UserName,String FirstName,String LastName,String Email,String PassWord,String Phone)
    {
       User userPayLoad= new User();
        userPayLoad.setId(Integer.parseInt(UserID));
        userPayLoad.setUsername(UserName);
        userPayLoad.setFirstName(FirstName);
        userPayLoad.setLastName(LastName);
        userPayLoad.setEmail(Email);
        userPayLoad.setPassword(PassWord);
        userPayLoad.setPhone(Phone);

        Response createUserResponse= UserEndPoints.createUser(userPayLoad);
        Assert.assertEquals(createUserResponse.getStatusCode(),200);
    }

    @Test(priority = 2,dataProvider ="UserNames",dataProviderClass = DataProviders.class)
    public void  testDeleteUser(String username)
    {

        Response deleteUserResponse=UserEndPoints.deleteUser(username);
        Assert.assertEquals(deleteUserResponse.getStatusCode(),200);
    }
}
