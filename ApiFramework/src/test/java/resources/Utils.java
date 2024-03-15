package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import org.json.JSONObject;
import java.io.IOException;


public class Utils {

    RequestSpecification req;
    public RequestSpecification requestSpecification() throws IOException {

        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
        req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).build();
        return req;

    }
    public String getGlobalValue(String key) throws IOException
    {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/salmagharieb/IdeaProjects/ApiFramework/src/test/java/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }

    //method to return any key value from json response
    public String getJsonPath(Response response, String key)
    {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }

    //method to generate prerequest
    public static void generatePrerequestScript() {
        // Parse request body JSON
        JSONObject params = new JSONObject("{ \"your\": \"request\", \"body\": \"here\" }");
        params.remove("activeRecord");
        params.remove("signature");

        // Construct payload
        String url = "your/request/url";
        String method = "yourRequestMethod" + "+";
        String payload = method + url;

        // Append query parameters to payload
        for (String key : params.keySet()) {
            String value = params.getString(key);
            if (value.length() > 0 && !value.equals("{}")) {
                payload += "+" + key + "=" + value;
            }
        }

        // Generate signature
        String privateKey = "f25522a5b819378b079ae015f0b4141de15baf33a366abfa015b5237ccaff71f";
        String secret = generateSignature(payload, privateKey);
        System.out.println("Signature: " + secret);
    }


    //method to generate signature
    private static String generateSignature(String payload, String privateKey) {
        try {
            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(privateKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            sha256Hmac.init(secretKey);
            byte[] hmacData = sha256Hmac.doFinal(payload.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(hmacData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
