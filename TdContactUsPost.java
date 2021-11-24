package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.core.Is;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TdContactUsPost {
    @Test
    public void testPost(){
        RestAssured.baseURI ="https://qa-api.top-doc.com";
        RequestSpecification request = RestAssured.given();
        String str = "{\"issue\": \"Automation\", \"message\": \"asdddddddddddddddd\", \"name\": \"bikash kumar roshan\", \"phone\": 9678555555}";
        request.header("Content-Type", "application/json");
        request.body(str);
        Response response = request.post("/userservice/user/contactus");
        Assert.assertEquals(response.getStatusCode(),200);
        String checkBody = response.body().toString();
        response.then().assertThat().body("success", Is.is(true));
    }


}
