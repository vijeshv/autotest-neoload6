package au.gov.border.oa.steps;

import com.github.tamnguyenbbt.dom.DomUtil;
import com.neotys.selenium.proxies.NLWebDriver;
import com.neotys.selenium.proxies.NLWebDriverFactory;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import static com.neotys.selenium.proxies.NLWebDriverFactory.addProxyCapabilitiesIfNecessary;



public class LoginSteps1
{

    private CommonSteps commonSteps = new CommonSteps();
    private DomUtil domUtil = new DomUtil();

    @Step
    public void openVisaFinder(NLWebDriver  driver )
    {
        driver.get("https://immi.homeaffairs.gov.au/visas/getting-a-visa/visa-finder");
        commonSteps.verifyTextInPage("Explore visa options", true,driver);
    }

    @Step
    public void selectStudyVisaOption(NLWebDriver  driver ) throws Exception
    {
        domUtil.getWebElementBestEffort(driver, "h3", "Study", "a").click();
        commonSteps.verifyTextInPage("study full time", true,driver);
    }

    @Step
    public void selectStudyFullTime(NLWebDriver  driver ) throws Exception
    {
        domUtil.getWebElementBestEffort(driver, "label", "study full time", "input").click();
        domUtil.getWebElementBestEffort(driver, "button", "Continue", "button").click();
        commonSteps.verifyTextInPage("Subclass 500", true,driver);
    }

    @Step
    public void viewVisaDetails(NLWebDriver  driver ) throws Exception
    {
        domUtil.getWebElementBestEffort(driver, "button", "Details", "button").click();
        commonSteps.verifyTextInPage("With this visa you can", true,driver);
    }

}
