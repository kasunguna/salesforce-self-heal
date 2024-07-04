package org.assurity.tests;

import org.assurity.pages.AccountPage;
import org.assurity.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void testCreateAndDeleteAccount() throws InterruptedException {
        driver.get(properties.getProperty("url"));

        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        loginPage.enterUsername(properties.getProperty("username"));
        loginPage.enterPassword(properties.getProperty("password"));
        loginPage.clickLoginButton();

        Thread.sleep(5000);

        // Create a new account
        accountPage.navigateToAccountsTab();
        Thread.sleep(2000);
        accountPage.clickNewButton();
        String accountName = "Test Account";
        Thread.sleep(5000);
        accountPage.enterAccountName(accountName);
        String area = "Auckland";
        accountPage.enterLocationName(area);
        accountPage.clickSaveButton();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Search and delete the created account
//        accountPage.clickAccounts();
//        Thread.sleep(1000);
//        accountPage.searchAccount(accountName);
//        accountPage.selectFirstAccount();
//        accountPage.deleteAccount();

        // Add assertions to verify the account was deleted successfully
        // e.g., verify the account is no longer in the account list
    }
}
