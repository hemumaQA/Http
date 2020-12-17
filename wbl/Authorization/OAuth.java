package org.wbl.Authorization;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class OAuth {
    @Test
    public void oauth() {

        //token should be generated every time// **********TEST CASE FAILS*********

        given().auth().oauth2("89ff0522ab5e24efdcd96c4b5250b25ac3bb67de")//token expires shortly
                .when().post("http://coop.apps.symfonycasts.com/api/1498/chickens-feed")
                .then().statusCode(200).log().all().extract().response();
    }

    @Test
    public void oauthAutomation() {

        // token generation is automated

        String token =
                         given().formParam("client_id", "OAuthRestAssured")
                        .formParam("client_secret", "296bda81d3118484e4e4bacec871a0e0")
                        .formParam("grant_type", "client_credentials")
                        .when().post("http://coop.apps.symfonycasts.com/token")
                        .then().statusCode(200).extract().body().jsonPath().get("access_token");

        System.out.println(token);

        given().auth().oauth2(token)
                .when().post("http://coop.apps.symfonycasts.com/api/1498/chickens-feed")
                .then().statusCode(200).log().all().extract().response();


    }


}