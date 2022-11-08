package day01;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {
    @Test
    public void test01(){

        String url="https://restful-booker.herokuapp.com/booking";

        Response response = given().when().get(url);
        //bu satir ile end point'e gondermek icin request olusturmus olduk
        //Response response -> api tarafindan bana donen response

        //Response response = given().auth().basic("user","password").when().get(url);
        //basic auth ile request gondermek icin

        //response.prettyPrint();     //response'daki body yazdirir

        //response.prettyPeek();      //response'daki her seyi yazdirir

        //response.peek();            //her seyi string olarak tek satirda yazdirir

        //response.print();

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
        System.out.println(response.contentType());

        // 1)Junit assertleri ile API testi yapabiliriz
        Assert.assertEquals("Status code hatali",201,response.statusCode());
        Assert.assertEquals("HTTP/1.1 200 OK",response.statusLine());
        Assert.assertEquals("application/json; charset=utf-8",response.contentType());

        // 2) assertThat ile
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");

    }
}
