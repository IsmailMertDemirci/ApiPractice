package day02;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest05 {
    @Test
    public void test05() {
        String url="https://www.gmibank.com/api/tp-customers";
        String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaDgxIiwiYXV0aCI6IlJPTEVfQURNSU4iLCJleHAiOjE2Njk5MTg0MDl9.hX-h2iHuBAxiiZISgF6ARnC47YfgINSg_saaWvL8yz9FyYl_W2E0GxUrlLa1ZTl7nRsRfmr9JoDcDLx7joXOjg";
        //test passed olsa bile herhangi bir veriyi degistirip tekrar dene, mesela tokenden bir harf silip dene!!!

        Response response=given().when().headers("Authorization","Bearer "+token).get(url);

        response.prettyPrint();
    }
}
