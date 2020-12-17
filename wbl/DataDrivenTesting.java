package org.wbl;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.XMLUtils;
import org.wbl.utils.Excelutils;

import java.io.IOException;

public class DataDrivenTesting {

                            //POST request

    @Test(dataProvider = "empdataprovider")
    public  void postrequest(String eid,String eemail,String efirstname){
        RestAssured.baseURI = "https://reqres.in/api/users";
        RequestSpecification req = RestAssured.given();
        //data to send along the post request
        JSONObject requestparams =new JSONObject();
        requestparams.put("id",eid);
        requestparams.put("email",eemail);
        requestparams.put("first_name",efirstname);


        //adding headers
        req.header("Content-Type","application/json");

        //add json to the body of the request
        req.body((requestparams.toJSONString()));

        //post request
        Response response= req.request(Method.POST);

        //Capture response body to perform validations
        String responseBody =response.getBody().asString();
        System.out.println("the response body is "+responseBody);

        Assert.assertEquals(responseBody.contains(eid),true);
        Assert.assertEquals(responseBody.contains(eemail),true);
        Assert.assertEquals(responseBody.contains(efirstname),true);

        int statuscode = response.statusCode();
        Assert.assertEquals(statuscode,201);


    }

    @DataProvider (name="empdataprovider")
    Object[] getEmpdata() throws IOException {

        //read data from excel ---POST REQUEST----
        String path=("C:\\Users\\hemum\\IdeaProjects\\SeleniumMaven\\src\\main\\JUnit\\RestAssured\\src\\main\\resources\\Test-Data\\Book1.xlsx");
       int rownum= Excelutils.getRowCount(path,"Sheet1");
       int colnum = Excelutils.getCellCount(path,"Sheet1",1);

       String  empdata[][]=new String[rownum][colnum];

       for(int i= 1;i<=rownum;i++){
           for(int j=0;j<colnum;j++){
               empdata[i-1][j]=Excelutils.getCellData(path,"Sheet1",i,j);
           }
       }

            // hard-coded data
        //String[][] empdata= {{"12","abc@gmail.com","abc"},{"14","def@gmail.com","def"}};
        return(empdata);
    }

}
