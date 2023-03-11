package com.ecommerce.tests;

import com.ecommerce.utility.ConfigReader;
import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.testng.annotations.Test;

public class ReturningUserPurchaseTest extends TestBase{
    public String url = ConfigReader.getProperty("url");
    public String email = ConfigReader.getProperty("emailAddress");
    @Test(groups = {"smoke","regression"})
    public void  returningUserPurchase(){
        getAppLibrary().getFlowsLibrary().navigateToUrl(url);
        getAppLibrary().getPage().getRupp().returningUserPurchase();


    }


}
