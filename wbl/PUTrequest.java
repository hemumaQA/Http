package org.wbl;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PUTrequest {  //https://reqres.in/api/users/5
    @Test
    public  void putrequest(){
        RestAssured.baseURI = "https://reqres.in";
        String endURL =  "/api/users/5";
        RequestSpecification req = RestAssured.given();

        //Data to create a resource
        req.header("Content-Type","application/json");
        JSONObject json = new JSONObject();
        json.put("id",555);
        json.put("first_name","Will");
        json.put("last_name","Power");
        String jsondata = json.toJSONString();

        Response res = req.request(Method.PUT,endURL);
        //Status code
        int statuscode = res.statusCode();
        System.out.println("Status code is: "+statuscode);
        Assert.assertEquals(statuscode,200);

        //Response payload/body
        String jsonpaylaod = res.asString();
        System.out.println("ResponseBody is: "+jsonpaylaod);

        //Response Header
        System.out.println("Response Header is:"+res.getHeaders());



    }
}
