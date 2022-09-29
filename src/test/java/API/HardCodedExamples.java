package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    //crud operations we perform

    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NjQ0NjcwMDcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY2NDUxMDIwNywidXNlcklkIjoiNDQyNCJ9.mHuewhdztQNGZGsZU44SK3dSCo14f8KTTMN17OaIARk";
    //to create a regular/ normal employee
    static String employee_id;
    @Test
    public void acreateEmployee(){
        //prepare the request
        //POST
    RequestSpecification preparedRequest = given().header("Content-Type","application/json").
                header("Authorization",token).body("{\n" +
                        "  \"emp_firstname\": \"Chinzo\",\n" +
                        "  \"emp_lastname\": \"Sterling\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2000-10-19\",\n" +
                        "  \"emp_status\": \"probation\",\n" +
                        "  \"emp_job_title\": \"QA Engineer\"\n" +
                        "}");
    //hitting the endpoint
    Response response = preparedRequest.when().post("/createEmployee.php");
    //printing the response in console
    response.prettyPrint();
        //assertions and validation
        //verifying the correct status code of the request
        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Employee.emp_middle_name",equalTo("ms"));
        response.then().assertThat().body("Employee.emp_firstname",equalTo("Chinzo"));
        response.then().assertThat().body("Employee.emp_lastname",equalTo("Sterling"));
        response.then().assertThat().body("Message",equalTo("Employee Created"));
        response.then().assertThat().header("Server","Apache/2.4.39 (Win64) PHP/7.2.18");

        //to get the employee id from the body\
       employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

    }
    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification preparedRequest = given().header("Content-Type","application/json").
                header("Authorization",token).queryParam("employee_id",employee_id);
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
@Test
    public void cupdateEmployee(){
        RequestSpecification preparedRequest = given().header("Content-Type","application/json").
                header("Authorization",token).body("{\n" +
                        "  \"employee_id\": \"41560A\",\n" +
                        "  \"emp_firstname\": \"Ganbold\",\n" +
                        "  \"emp_lastname\": \"Moon\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1990-07-24\",\n" +
                        "  \"emp_status\": \"Hired\",\n" +
                        "  \"emp_job_title\": \"QA Lead\"\n" +
                        "}");
        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void dGetUpdatedEmployee(){
        //prepare the request
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json")
                .header("Authorization", token).
                queryParam("employee_id", employee_id);

        //hitting the endpoint

        Response response = preparedRequest.when().get("/getOneEmployee.php");

        response.prettyPrint();

        response.then().assertThat().statusCode(200);
    }

}
