package com.restassured.apitest.workshop;

import org.junit.Test;
import org.w3c.dom.events.EventException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class PracticeResponse {

    //  Practice using Parameters in Request.
    //  Google Book API reference  https://developers.google.com/books/docs/v1/reference/volumes/list
    //  Google Sheets API reference  https://developers.google.com/sheets/reference/rest/


    private static String token = "ya29.CjAlA6dfrtNjYkpcqCKQTzqLApcIbLuhAlYMdFezgSMIX3oNfBw00gnTBz9ySkciW5o";
    private static String spreadsheetId = "14jSUH8DoGN3k-QqIV6qIocW-ZYlN_RL507SXjYN7AgM";


    //https://developers.google.com/books/docs/v1/reference/volumes/list
    //发送get请求，返回书名为含有cucumber的书，并返回一个结果；打印response返回内容
    //https://github.com/rest-assured/rest-assured/wiki/Usage#getting-response-data
    @Test
    public void testGetAllResponse() throws EventException {
        String response = given()
                .when()
                .get("https://www.googleapis.com/books/v1/volumes?q=cucumber&maxResults=2")
                .asString();

        System.out.println(response);
    }


    //直接从response body中查找特定值
    //https://github.com/rest-assured/rest-assured/wiki/Usage#example-1---json
    @Test
    public void testResponseBasicUsage() throws EventException {
        given()
                .when()
                .get("https://www.googleapis.com/books/v1/volumes?q=cucumber&maxResults=2")
                .then()
                .body("kind", equalTo("books#volumes"))
                .body("totalItems", equalTo(572))
                .body("items.id", hasItems("0dge3Xh6EjUC", "YuC_HK8b6_4C"))
                .body("items[0].volumeInfo.title", equalTo("Advances in Sea Cucumber Aquaculture and Management"));
    }


    //https://developers.google.com/books/docs/v1/reference/volumes/list
    //使用extract method提取response片段
    //https://github.com/rest-assured/rest-assured/wiki/Usage#extracting-values-from-the-response-after-validation
    @Test
    public void testExtractFragmentFromGoogleBookResponse() throws EventException {
        given()
                .when()
                .get("https://www.googleapis.com/books/v1/volumes?q=cucumber&maxResults=2")
                .then()
                .body("items[0].selfLink", response -> equalTo("https://www.googleapis.com/books/v1/volumes/" + response.path("items[0].id")));

    }

    //https://developers.google.com/books/docs/v1/reference/volumes/list
    //使用extract method提取header和cookie
    //https://github.com/rest-assured/rest-assured/wiki/Usage#extracting-values-from-the-response-after-validation
    @Test
    public void testExtractAllResponse() throws EventException {

    }


    //https://developers.google.com/books/docs/v1/reference/volumes/list
    //使用Response的一部分去验证Response另一部分
    //https://github.com/rest-assured/rest-assured/wiki/Usage#use-the-response-to-verify-other-parts-of-the-response
    @Test
    public void testUsePartInResponseByLambda() throws EventException {

    }


    //https://developers.google.com/books/docs/v1/reference/volumes/list
    //使用Response的一部分去验证Response另一部分
    //https://github.com/rest-assured/rest-assured/wiki/Usage#use-the-response-to-verify-other-parts-of-the-response
    @Test
    public void testUsePartInResponse() throws EventException {

    }


    //https://developers.google.com/books/docs/v1/reference/volumes/list
    //pageCount>300的书里面是否包含title为："Advances in Sea Cucumber Aquaculture and Management"和"A Treatise on the Culture of the Cucumber"的书
    // https://github.com/rest-assured/rest-assured/wiki/Usage#json-schema-validation -> Example 3 - Complex parsing and validation
    @Test
    public void testGroovyCollection1() throws EventException {

    }


    //https://developers.google.com/books/docs/v1/reference/volumes/list
    // https://github.com/rest-assured/rest-assured/wiki/Usage#json-schema-validation -> Example 3 - Complex parsing and validation
    @Test
    public void testGroovyCollection2() throws EventException {

    }


    //https://developers.google.com/books/docs/v1/reference/volumes/list
    //查找saleability属性
    // https://github.com/rest-assured/rest-assured/wiki/Usage#json-schema-validation -> Example 3 - Complex parsing and validation
    @Test
    public void testGroovyCollection3() throws EventException {

    }


    //https://developers.google.com/books/docs/v1/reference/volumes/list
    //使用Specification
    //https://github.com/rest-assured/rest-assured/wiki/Usage#specification-re-use
    @Test
    public void testSpecification() throws EventException {

    }

}
