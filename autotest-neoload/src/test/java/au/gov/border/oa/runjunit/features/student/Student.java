package au.gov.border.oa.runjunit.features.student;

import au.gov.border.oa.steps.CommonSteps;
import au.gov.border.oa.steps.LoginSteps1;
import com.github.tamnguyenbbt.dom.DomUtil;
import com.neotys.selenium.proxies.NLWebDriver;
import com.neotys.selenium.proxies.NLWebDriverFactory;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static com.neotys.selenium.proxies.NLWebDriverFactory.addProxyCapabilitiesIfNecessary;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Student
{

    @Managed
    //WebDriver driver;

    @Steps
    //LoginSteps1 loginSteps1;

    @Rule
    public TestName name = new TestName();

    @Before
    public void before()
    {

    }

    @After
    public void after()
    {

    }

    @Test
    public void viewStudyVisaDetails() throws Exception
    {
        LoginSteps1 loginSteps1=new LoginSteps1();
        String projectPath =null;

        // private WebDriver driver = Serenity.getWebdriverManager().getWebdriver();

        String CHROME_DRIVER_PATH = "D:\\Neoloadsupport\\selenium\\chromedriver_win32\\chromedriver.exe";
       final File file = new File(CHROME_DRIVER_PATH);

        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        @SuppressWarnings("deprecation")
         ChromeDriver webDriver = new ChromeDriver(addProxyCapabilitiesIfNecessary(new DesiredCapabilities()));
        NLWebDriver  driver = NLWebDriverFactory.newNLWebDriver(webDriver, "Homeaffaiars", projectPath);

        driver.startTransaction("home page");
        loginSteps1.openVisaFinder(driver);
        driver.stopTransaction();
        driver.startTransaction("Select Visa");
        loginSteps1.selectStudyVisaOption(driver);
        driver.stopTransaction();
        driver.startTransaction("Select study full time");
        loginSteps1.selectStudyFullTime(driver);
        driver.stopTransaction();
        driver.startTransaction("View VISA deatils");
        loginSteps1.viewVisaDetails(driver);
        driver.stopTransaction();
    }

}
