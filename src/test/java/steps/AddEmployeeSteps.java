package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        click(dash.addEmployeeOption);
    }

    @When("user enters firstName , middleName and lastName")
    public void user_enters_first_name_middle_name_and_last_name() {
        sendText(addEmployeePage.firstName, "gisel");
        sendText(addEmployeePage.middleName, "francis");
        sendText(addEmployeePage.lastName, "arif");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        //homework - verify added employee
        System.out.println("Employee added");
    }

    @When("user enters {string} , {string} and {string}")
    public void user_enters_and(String firstName, String middleName, String lastName) {
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.middleName, middleName);
        sendText(addEmployeePage.lastName, lastName);
    }

    @When("user enter {string} , {string} and {string}")
    public void user_enter_and(String fn, String mn, String ln) {
       sendText(addEmployeePage.firstName, fn);
       sendText(addEmployeePage.middleName, mn);
       sendText(addEmployeePage.lastName, ln);
    }

    @When("user adds multiple employees and verify they are added")
    public void user_adds_multiple_employees_and_verify_they_are_added(DataTable dataTable) throws InterruptedException {

        //to  get the data from feature file in the form of list of maps
       List<Map<String,String>> employeeNames = dataTable.asMaps();

        for (Map<String, String> emp:
             employeeNames) {
             String firstNameValue =  emp.get("firstName");
             String middleNameValue = emp.get("middleName");
             String lastNameValue = emp.get("lastName");

             //it will enter fresh values after each iteration
             sendText(addEmployeePage.firstName, firstNameValue);
             sendText(addEmployeePage.middleName, middleNameValue);
             sendText(addEmployeePage.lastName, lastNameValue);

             click(addEmployeePage.saveButton);

             //we dont want to execute hooks multiple time
            //we dont want to execute background multiple time
            //we will click on add employee option to add another employee till
            //the time we are getting fresh values from feature file
            Thread.sleep(2000);
            click(dash.addEmployeeOption);
            Thread.sleep(2000);

            //verify that the employee added

        }

    }

}
