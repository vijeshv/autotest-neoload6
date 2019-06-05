package au.gov.border.oa.steps;

import com.github.tamnguyenbbt.dom.DomUtil;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

//*********************************
import static com.neotys.selenium.proxies.NLWebDriverFactory.addProxyCapabilitiesIfNecessary;

//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import com.neotys.selenium.proxies.NLWebDriver;
import com.neotys.selenium.proxies.NLWebDriverFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
public class LoginSteps
{
    String projectPath =null;

    private WebDriver driver = Serenity.getWebdriverManager().getWebdriver();
    private CommonSteps commonSteps = new CommonSteps();
    private DomUtil domUtil = new DomUtil();


    @Step
    public void openVisaFinder()
    {
        driver.get("https://immi.homeaffairs.gov.au/visas/getting-a-visa/visa-finder");
      //  commonSteps.verifyTextInPage("Explore visa options", true);
    }

    @Step
    public void selectStudyVisaOption() throws Exception
    {
        domUtil.getWebElementBestEffort(driver, "h3", "Study", "a").click();
       // commonSteps.verifyTextInPage("study full time", true);
    }

    @Step
    public void selectStudyFullTime() throws Exception
    {
        domUtil.getWebElementBestEffort(driver, "label", "study full time", "input").click();
        domUtil.getWebElementBestEffort(driver, "button", "Continue", "button").click();
       // commonSteps.verifyTextInPage("Subclass 500", true);
    }

    @Step
    public void viewVisaDetails() throws Exception
    {
        domUtil.getWebElementBestEffort(driver, "button", "Details", "button").click();
      //  commonSteps.verifyTextInPage("With this visa you can", true);
    }

}
