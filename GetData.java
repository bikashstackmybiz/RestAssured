package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetData {

    @Test
    public void testResponceCode(){
        Response responce = RestAssured.get("https://api.openweathermap.org/data/2.5/weather?q=London&appid=e6f28fb7cd4783b51a06899eca81a833");
        int code = responce.getStatusCode();
        System.out.println("Status code is = " + code);
        Assert.assertEquals(code,200);
    }
    @Test
    public void getBody(){
        Response response = RestAssured.get("https://api.openweathermap.org/data/2.5/weather?q=London&appid=e6f28fb7cd4783b51a06899eca81a833");
        String data = response.asString();
        System.out.println("The data of the body is" + data);
        System.out.println("Responce time is = " + response.getTime());
    }
}
