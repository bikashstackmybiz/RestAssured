package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UpdateProductInCart{
    @Test
    public void updateProductInCArt(){
        RestAssured.baseURI = ("https://qa-api.top-doc.com");
        RequestSpecification request = RestAssured.given();
        TokenForAuth token = new TokenForAuth();
        request.header("Authorizition", token.getToken());
        JSONObject obj = new JSONObject();
        obj.put("quantity", 7);
        request.body(obj.toString());
        Response response = request.put("/ecommerceservice/api/v1/cart/670483000000036896");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
