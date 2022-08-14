package steps;

import pages.DashboardPage;
import pages.EmployeeInformationPage;
import pages.LoginPage;

public class PageInitializer {

    public static LoginPage login;
    public static DashboardPage dash;
    public static EmployeeInformationPage emp;

    public static void initializePageObjects(){
        login = new LoginPage();
        dash = new DashboardPage();
        emp = new EmployeeInformationPage();
    }


}
