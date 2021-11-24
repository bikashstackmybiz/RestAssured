package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartWithAuth {
    @Test
    public  void  addToCart(){
        RestAssured.baseURI = ("https://qa-api.top-doc.com");
        RequestSpecification request = RestAssured.given();
        JSONObject bodyforcart = new JSONObject();
        bodyforcart.put("quantity", 1);
        request.header("Content-Type", "application/json");
        request.body(bodyforcart.toString());
        TokenForAuth token1 = new TokenForAuth();
        request.header("Authorization", token1.getToken());
        Response response = request.post("/ecommerceservice/api/v1/cart/670483000000036896");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}


