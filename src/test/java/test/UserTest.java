package test;

import com.github.javafaker.Faker;
import endPoints.UserEndPoints;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payload.User;

public class UserTest {
    public Logger logger;
Faker faker;
User userPayLoad;
    /*****
     * we have to complete data setup before sending the request
     * before this class this method will get exeuted and complete the test data
     * ****/
    @BeforeClass
    public void setUp()
    {
    faker=new Faker();
    userPayLoad= new User();
        userPayLoad.setId(faker.idNumber().hashCode());
        userPayLoad.setUsername(faker.name().username());
        userPayLoad.setFirstName(faker.name().firstName());
        userPayLoad.setLastName(faker.name().lastName());
        userPayLoad.setEmail(faker.internet().emailAddress());
        userPayLoad.setPassword(faker.internet().password());
        userPayLoad.setPhone(faker.phoneNumber().phoneNumber());
        //logs
        logger= LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void  testPostUser()
    {
        logger.info("**********************Creating User*******************");
        Response createUserResponse=UserEndPoints.createUser(userPayLoad);
        Assert.assertEquals(createUserResponse.getStatusCode(),200);
        logger.info("**********************User is Created *******************");
    }
    @Test(priority = 2)
    public void  testGetUser()
    {
        logger.info("********************** Reading User Info*******************");
        String userName=userPayLoad.getUsername();
        Response getUserResponse=UserEndPoints.getUser(userName);
        Assert.assertEquals(getUserResponse.getStatusCode(),200);
        logger.info("**********************User Info id displayed*******************");
    }
    @Test(priority = 3)
    public void  testUpdateUser()
    {
        logger.info("********************** Updating User Info*******************");
        String userName=this.userPayLoad.getUsername();
        userPayLoad.setFirstName(faker.name().firstName());
        userPayLoad.setLastName(faker.name().lastName());
        userPayLoad.setEmail(faker.internet().safeEmailAddress());

        Response postUserResponse=UserEndPoints.updateUser(userName,userPayLoad);


        Assert.assertEquals(postUserResponse.getStatusCode(),200);
        logger.info("********************** User Info updated*******************");
    }

    @Test(priority = 4)
    public void  testDeleteUser()
    {

        logger.info("********************** Deleting User Info*******************");
        String userName=userPayLoad.getUsername();
        Response deleteUserResponse=UserEndPoints.deleteUser(userName);
        Assert.assertEquals(deleteUserResponse.getStatusCode(),200);
        logger.info("********************** User Info deleted.*******************");
    }






}



