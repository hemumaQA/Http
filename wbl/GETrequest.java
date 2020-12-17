package org.wbl;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GETrequest { //https://reqres.in/api/users/5
    @Test
    public void getrequest() {
        //specify the base URI
        RestAssured.baseURI = "https://reqres.in";
        String endURL = "/api/users/5";

        //Request object
        RequestSpecification req = RestAssured.given();

        //Response Object
        Response res = req.request(Method.GET, endURL);


        //Response payload/body
        String responsebody = res.body().asString();

        System.out.println("ResponseBody is: " + responsebody);

        Assert.assertEquals(responsebody.contains("5"), true);

        //Status code validation
        int statuscode = res.statusCode();
        System.out.println("Status code is: " + statuscode);
        Assert.assertEquals(statuscode, 200);

        //Response Header
        Headers ResponseHeaders = res.getHeaders();
        System.out.println("Response Header is:" + ResponseHeaders);


        //to get all the headers-key value pair
        Headers allHeaders = res.headers();
        for (Header header : allHeaders) {
            System.out.println(header.getName() + "--------- " + header.getValue());
        }
    }
}













/*
        //Status line verification
        String statusline = res.getStatusLine();
        System.out.println("The status line is : " + statusline);
*/
























 /*  //capture all values from the response
          JsonPath jsonPath = res.jsonPath();
          System.out.println(jsonPath.get("id"));
          System.out.println(jsonPath.get("email")) ;
          System.out.println(jsonPath.get("first_name"));
          System.out.println(jsonPath.get("last_name"));
          System.out.println(jsonPath.get("avatar"));
          Assert.assertEquals(jsonPath.get("id"),5);*/












