package org.wbl.Authorization;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.auth.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.Principal;

import static io.restassured.RestAssured.given;

public class BasicAuth {  // ----------NOT WORKING

    @Test


    public void basicAuth() throws IOException {

           //base URL
            //RestAssured.baseURI ="https://github.com/";
             RestAssured.baseURI="https://mail.google.com/mail/u/0/#inbox";     // working!!



            //basic authentication
            PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
            authScheme.setUserName("hemuma85@gmail.com");
            authScheme.setPassword("mukunth@5");



            RestAssured.authentication =authScheme;    //header info


             //request object
            RequestSpecification req = RestAssured.given();

            //response object
            Response res = req.request(Method.GET);

           /* //print response in status body
            String responsebody = res.getBody().asString();
            System.out.println("ResponseBody is: " + responsebody);*/



           int statuscode = res.statusCode();
           Assert.assertEquals(statuscode,200);
           System.out.println("Status code is: "+statuscode);


           //Response payload/body
          // String responsebody = res.body().asString();
        //System.out.println("ResponseBody is: " + res.asString());




        }

    }






    /**/