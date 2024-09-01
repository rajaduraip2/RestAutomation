package test;

import endPoints.UserEndPoints;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;



public class GraphQL {
    public Logger logger;

    @Test
    public void testgetOnlineUsers(){
        logger= LogManager.getLogger(this.getClass());
            logger.info("**********************Creating User*******************");
            Response getGraphQLResponse= UserEndPoints.getOnlineUsers();
        getGraphQLResponse.then().log().all();
            Assert.assertEquals(getGraphQLResponse.getStatusCode(),200);
            logger.info("**********************User is Created *******************");
        }


    @Test
    public void testCreateOnlineUsers(){
        logger= LogManager.getLogger(this.getClass());
        logger.info("**********************Creating User*******************");
        Response CreateGraphQLResponse= UserEndPoints.createUsers();
        CreateGraphQLResponse.then().log().all();
        Assert.assertEquals(CreateGraphQLResponse.getStatusCode(),200);
        logger.info("**********************User is Created *******************");
    }
    }

