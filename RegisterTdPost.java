package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegisterTdPost {

    @Test
    public void register(){
        RestAssured.baseURI = ("https://qa-api.top-doc.com");
        RequestSpecification request = RestAssured.given();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "");
        jsonObject.put("firstname", "fssssssssssssss");
        jsonObject.put("lastname", "ddddddddddddd");
        jsonObject.put("loginType", "ddddddddddd");
        jsonObject.put("password", "P@ss@1234");
        jsonObject.put("phone", "7349187967");
        jsonObject.put("userRole", "jbsckksbc");
        jsonObject.put("username", "shcgbciksv");
        request.header("Content-Type", "application/json");
        request.body(jsonObject.toString());
        Response response = request.post("/userservice/api/v1/register");
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
