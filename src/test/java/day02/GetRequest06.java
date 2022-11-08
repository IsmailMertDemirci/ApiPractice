package day02;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.Authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest06 extends Authentication {

    @Test
    public void test06() {

        String url = "https://www.gmibank.com/api/tp-customers/114351";

        Response response = given().headers("Authorization","Bearer "+ generateToken()).when().get(url);
        response.prettyPrint();

        //Matcher Class ile musteri bilgilerini dogrulayin
        response.then().assertThat().
                body("firstName",equalTo("Della"),
                "lastName",equalTo("Heaney"),
                        "email",equalTo("ricardo.larkin@yahoo.com"),
                        "mobilePhoneNumber",equalTo("123-456-7893"),
                        "accounts[0].balance",equalTo(11190),
                        "accounts[0].accountType",equalTo("CHECKING"),
                        "accounts[1].balance",equalTo(69700),
                        "accounts[1].accountType",equalTo("CREDIT_CARD"));

        //JsonPath ile musteri bilgilerini dogrulayiniz

        JsonPath jsonPath=response.jsonPath();
        //json da key value yerleri degisiyor
        assertEquals("Della",jsonPath.getString("firstName"));
        assertEquals("Heaney",jsonPath.getString("lastName"));
        assertEquals("ricardo.larkin@yahoo.com",jsonPath.getString("email"));
        assertEquals("123-456-7893",jsonPath.getString("mobilePhoneNumber"));
        assertEquals(11190,jsonPath.getInt("accounts[0].balance"));
        assertEquals("CHECKING",jsonPath.getString("accounts[0].accountType"));
        assertEquals(69700,jsonPath.getInt("accounts[1].balance"));
        assertEquals("CREDIT_CARD",jsonPath.getString("accounts[1].accountType"));
    }
}
