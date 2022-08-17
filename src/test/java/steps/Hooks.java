package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    //import io.cucumber and not junit

    @Before
    public void start(){
        openBrowserAndLaunchApplication();
    }

    @After
    public void end(){
        closeBrowser();
    }

}
