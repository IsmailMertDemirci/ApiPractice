package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {
    /*
    public static void main(String[] args) {
        //run yapabilmek icin main olusturuldu
        String guncelToken = generateToken();
        System.out.println("guncelToken = " + guncelToken);
    }

     */

    public static String generateToken() {

        String username = "Batch81";
        String password = "Batch81+";

        /* swagger dokumanindaki asagidaki kalip olusturuluyor
            "password": "string",
            "rememberMe": true,
            "username": "string"
         */

        Map<String, Object> postBody = new HashMap<>();
        postBody.put("username", username);
        postBody.put("password", password);
        postBody.put("rememberMe", true);

        String endPoint = "https://www.gmibank.com/api/authenticate";

        Response response =given().contentType(ContentType.JSON).body(postBody).when().post(endPoint);

        JsonPath token = response.jsonPath();
        return token.getString("id_token");
    }
}
