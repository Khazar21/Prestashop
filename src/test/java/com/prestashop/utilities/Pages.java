package com.prestashop.utilities;

import com.prestashop.pages.*;
import com.prestashop.tests.functional_tests.cart.positive.Search;

public class Pages {
    public HomePage homePage;
    public IdentityPage identityPage;
    public ItemPage itemPage;
    public MyAccountPage myAccountPage;
    public OrderPage orderPage;
    public RegistrationPage registrationPage;
    public SearchPage searchPage;
    public SignInPage signInPage;

    public Pages(){
        homePage= new HomePage();
        identityPage= new IdentityPage();
        itemPage= new ItemPage();
        myAccountPage= new MyAccountPage();
        orderPage= new OrderPage();
        registrationPage= new RegistrationPage();
        searchPage= new SearchPage();
        signInPage= new SignInPage();
    }
}
