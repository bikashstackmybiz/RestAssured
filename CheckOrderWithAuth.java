package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOrderWithAuth {
    @Test
    public void  checktotalorder(){
        RestAssured.baseURI = ("https://qa-api.top-doc.com");
        RequestSpecification request = RestAssured.given();
        TokenForAuth token1 = new TokenForAuth();
        request.header("Authorization", token1.getToken());
        Response response = request.get("/ecommerceservice/api/v1/orders/customer/order?fromDate=1635094221908&toDate=1637686221909&pageNo=0&pageSize=4");
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
