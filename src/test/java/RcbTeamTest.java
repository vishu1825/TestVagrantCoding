import com.qa.constants.FrameworkConstant;
import com.qa.utils.FrameworkUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.lang.reflect.Method;


/**
 *
 * contains test cases related to  RCB team playing 11
 * July 16, 2022
 * @author Vishwajeet Samal
 * @version 1.0
 *
 *
 */
public class RcbTeamTest {

    @Test(description="Validate that team has only 4 foreign players in playing 11")
    public void verifyForeignPlayerCountTest(Method m){
        FrameworkUtils util =new FrameworkUtils();
        int countryCount = util.getCountryCount(FrameworkConstant.getCOUNTRY_NAME());
        Assert.assertEquals(countryCount,4,"Includes only 4 foreign players in playing 11");
        Reporter.log(m.getName()+" is passed" ,true);
    }

    @Test(description="Validate that team has at least one wicket-keeper in playing 11")
    public void verifyWicketKeeperCountTest(Method m){
        FrameworkUtils util =new FrameworkUtils();
        int roleCount = util.getRoleCount(FrameworkConstant.getROLE());
        Assert.assertTrue(roleCount>=1,"Includes atleast one wicket-keeper in playing 11");
        Reporter.log(m.getName()+" is passed",true);
    }
}
