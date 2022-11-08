package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest03 {
    /* Matchers ile dataları doğrulayınız
             "id": 5,
            "email": "charles.morris@reqres.in",
            "first_name": "Charles",
            "last_name": "Morris",
            "avatar": "https://reqres.in/img/faces/5-image.jpg"
     */
    @Test
    public void test03(){
        String url = "https://reqres.in/api/users/5";
        Response response = given().when().get(url);

        response.then().assertThat().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                contentType(ContentType.JSON);

        //Matchers ile
        response.then().body("data.id", Matchers.equalTo(5));
        response.then().body("data.email",Matchers.equalTo("charles.morris@reqres.in"));
        response.then().body("data.first_name",Matchers.equalTo("Charles"));
        response.then().body("data.last_name",Matchers.equalTo("Morris"));
        response.then().body("data.avatar",Matchers.equalTo("https://reqres.in/img/faces/5-image.jpg"));
    }
}
