package org.assurity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AccountPage {
    private WebDriver driver;

    // Locators
//    private By accountsTab = By.xpath("//a[@title='Accounts']/../one-app-nav-bar-item-dropdown");
    private By accountsTab = By.xpath("//one-app-nav-bar-item-dropdown");
    private By accounts = By.xpath("//one-app-nav-bar-item-root");
    private By newButton = By.xpath("//span[text()='New Account']/../../..");
    private By accountNameField = By.xpath("//input[@name='Name']");
    private By saveButton = By.xpath("//button[@name='SaveEdit']");
    private By searchBox = By.xpath("//input[@name='Account-search-input']");
    private By searchButton = By.xpath("//button[@name='refreshButton']");
//    private By firstAccountLink = By.xpath("//table/tbody/tr[1]/th//a");
    private By deleteButton = By.xpath("//span[text()='Delete']/../..");

    private By showMoreActions = By.xpath("//span[text()='Show more actions']/..");
    private By confirmDeleteButton = By.xpath("//button[@title='Delete']");

    private By locationField = By.xpath("//input[@name='Location__c']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAccountsTab() {
        driver.findElement(accountsTab).click();
    }

    public void clickAccounts() {
        driver.findElement(accounts).click();
    }

    public void clickNewButton() {
        driver.findElement(newButton).click();
    }

    public void enterAccountName(String accountName) {
        driver.findElement(accountNameField).sendKeys(accountName);
    }

    public void enterLocationName(String location) {
        driver.findElement(locationField).sendKeys(location);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public void searchAccount(String accountName) {
        WebElement searchBoxElement = driver.findElement(searchBox);
        searchBoxElement.clear();
        searchBoxElement.sendKeys(accountName);
        driver.findElement(searchButton).click();
    }

//    public void selectFirstAccount() {
//        driver.findElement(firstAccountLink).click();
//    }

    public void deleteAccount() {
        Actions actions = new Actions(driver);
        driver.findElement(showMoreActions).click();
        driver.findElement(deleteButton).click();
        driver.findElement(confirmDeleteButton).click();
    }
}
