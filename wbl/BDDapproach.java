package org.wbl;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import  static  io.restassured.path.json.JsonPath.from;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BDDapproach {
    @Test
    public  void getrequest1(){
        //get(endURL/Endpoint)
                given()
                .when()
                        .get("https://reqres.in/api/users/5")
                        .then()
                        .assertThat()
                        .log().all();


    }
    @Test
    public  void getrequest2(){
        given()
                .when().
                get("https://reqres.in/api/users/3")
                .then()
                .assertThat().statusCode(200)
                .log()
                .headers();
    }
    @Test
    public  void getrequest3(){

        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.email[0]",equalTo("michael.lawson@reqres.in"))
                .body("data.first_name[1]",equalTo("Lindsay"))
                .body("data.avatar[3]",equalTo("https://reqres.in/img/faces/10-image.jpg"))
                .log().body();


    }

    @Test
    public  void getlist(){
       String albums =  given()
                .when()
                .get("https://jsonplaceholder.typicode.com/photos")
                .then()
                .extract().asString();
        System.out.println(albums);
        List<Integer> ls = from(albums).get("id");

        Assert.assertEquals(ls.size(),5000);
        System.out.println(ls.size());
    }

    @Test
    public  void deleterequest(){

        given()
                .when()
                .delete("https://reqres.in/api/users/6")
                .then()
                .statusCode(204) //no content
                .log().all();
    }
    @Test
    public void putrequest(){
        given()
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }



























    @Test
    public  void preemptiveauth(){         //------not working ------------

       int code= RestAssured.given()
                .auth().preemptive()
                .basic("ToolsQA","TestPassword")
                .when()
                .get("https://restapi.demoqa.com/authentication/CheckForAuthentication")
                .getStatusCode();
        System.out.println("The response code is-------" +code);
    }
    @Test
    public  void getrequest(){     // -----NOT WORKING----------
        given().auth().preemptive().basic("hemuma85@gmail.com","mukunth@5")
                //.contentType(ContentType.JSON)
                .body("{\"name\": \"createpost1 \"}")
                .when()
                .post("https://api.github.com/users/repos").
                then()
                .statusCode(201).log().all();

    }
    @Test
    public  void postrequest2(){     // -----NOT WORKING-----401 error--unauthorised
        given().auth().preemptive().basic("hemuma85@gmail.com","mukunth@5")
                .contentType(ContentType.JSON)
                .body("{\"name\":\"deleteme\"}")
                .when()
                .post("https://api.github.com/users/repos").
                then()
                .statusCode(201).log().all();

    }



}

