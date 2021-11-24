package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.core.Is;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TdBannerTest {
    @Test
    public void testBanner(){
        RestAssured.baseURI ="https://api.top-doc.com";
        RequestSpecification request = RestAssured.given();
        Response response = request.get("/eduservice/api/v1/banners");
        response.then().assertThat().body("status", Is.is(100));    // to validate key and value of body
        response.then().assertThat().body("message", Is.is("success"));
        response.then().assertThat().body("data.id[0]", Is.is(21));
        response.then().assertThat().body("data.title[0]", Is.is("Dr Patil Webinar"));
        String bodyString = response.asString();
        Assert.assertTrue(bodyString.contains("message"));  // To validate key of body
        Assert.assertTrue(bodyString.contains("status"));
        Assert.assertTrue(bodyString.contains("id"));
        Assert.assertTrue(bodyString.contains("title"));
        int code = response.getStatusCode();
        Assert.assertEquals(code,200);
        System.out.println("Status code is = " + code);

//        RestAssured.baseURI ="https://restapi.demoqa.com/customer";
//        String str = "{abc:hello}";
//        RequestSpecification request = RestAssured.given();
//        request.header("Content-Type", "application/json");
//        request.body(str);
//        Response response = request.post("/register");

    }
}
