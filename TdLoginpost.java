package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.core.Is;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TdLoginpost {
    @Test
    public void loginPost(){
        RestAssured.baseURI =("https://qa-api.top-doc.com");
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("phone","7978835140");
        requestParams.put("loginType", "DIRECT");
        requestParams.put("password", "P@ss@1234");
        requestParams.put("email", "");
        requestParams.put("userRole","LEARNER");
        request.header("Content-Type", "application/json");
        request.body(requestParams.toString());
        Response response = request.post("/userservice/api/v1/login");
        int code = response.getStatusCode();
        Assert.assertEquals(code,200);
        response.then().assertThat().body("status", Is.is(100));
        response.then().assertThat().body("message", Is.is("success"));
   }

}
