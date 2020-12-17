package org.wbl;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POSTrequest {   //https://reqres.in/api/users
    @Test
    public  void postrequest(){
        //Specify a Url
        RestAssured.baseURI = "https://reqres.in";
        String endURL =  "/api/users/5";
        //Request an Object
        RequestSpecification req = RestAssured.given();

        //Request payload sending along with payload
        JSONObject requestparams = new JSONObject();

        requestparams.put("id",10);
        requestparams.put("first_name","Sam");
        requestparams.put("last_name","Sony");
        String jsondata = requestparams.toJSONString();

        //Data to create a resource
        req.header("Content-Type","application/json");

        req.body(requestparams.toString());  //attaches the above data to the request


        // response object
        System.out.println(jsondata);
        Response res = req.request(Method.POST,endURL);

        //Response payload/body --print response in the console
        String jsonpaylaod = res.asString();
        System.out.println("ResponseBody is: "+jsonpaylaod);


        //Status code validation
        int statuscode = res.statusCode();
        System.out.println("Status code is: "+statuscode);
        Assert.assertEquals(statuscode,201);






    }
}
