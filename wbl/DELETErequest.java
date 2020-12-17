package org.wbl;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DELETErequest {
    @Test
    public  void deleterequest(){
        RestAssured.baseURI = "https://reqres.in";
        String endURL =  "/api/users/5";
        RequestSpecification req = RestAssured.given();

        Response res = req.request(Method.DELETE,endURL);
        //Status code
        int statuscode = res.statusCode();
        System.out.println("Status code is: "+statuscode);
        Assert.assertEquals(statuscode,204);  //no content-204

        //Response payload/body
        String jsonpaylaod = res.asString();
        System.out.println("ResponseBody is: "+jsonpaylaod);

        //Response Header
        System.out.println("Response Header is:"+res.getHeaders());



    }
}
