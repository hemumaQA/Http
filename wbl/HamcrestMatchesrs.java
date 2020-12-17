package org.wbl;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import  static org.hamcrest.Matchers.*;

public class HamcrestMatchesrs {
    @Test
    public void getreq1(){

        String response=
                        given()
                        .when()
                        .get("https://jsonplaceholder.typicode.com/posts/5")
                        .then()
                        .assertThat()
                        .body("userId",equalTo(1))
                        .body("title",containsString("quas ")).extract().response().asString();
              System.out.println(response);
    }
    @Test
    public  void getreq2(){
        String response =
                       given()
                               .when()
                               .get("https://reqres.in/api/users?page=2")
                               .then()
                               .body("data.first_name",hasItems("Michael","Lindsay","Tobias","Byron","George","Rachel"))
                               .body("data",hasSize(6))
                               .extract().response().asString();
        System.out.println(response);

    }
    @Test
    public  void getreq3(){
        String response =
                given()
                        .when()
                        .get("http://dummy.restapiexample.com/api/v1/employees")
                        .then()
                        .assertThat()
                        //.body("id",equalTo(18))
                       // .body("employee_age",contains(59))
                        .body("data.employee_name",hasItems("Michael Silva","Gloria Little","Dai Rios"))
                        .extract().response().asString();
        System.out.println(response);


    }

}
