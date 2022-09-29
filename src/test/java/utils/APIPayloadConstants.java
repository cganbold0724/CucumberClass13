package utils;

public class APIPayloadConstants {

    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Chinzo\",\n" +
                "  \"emp_lastname\": \"Sterling\",\n" +
                "  \"emp_middle_name\": \"ms\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2000-10-19\",\n" +
                "  \"emp_status\": \"probation\",\n" +
                "  \"emp_job_title\": \"QA Engineer\"\n" +
                "}";

        return createEmployeePayload;
    }

}
