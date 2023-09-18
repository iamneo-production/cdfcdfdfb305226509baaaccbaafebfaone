package uistore;

import org.openqa.selenium.By;

public class locators {
    public static By username = By.name("username");
    public static By password = By.id("password");
    public static By submit = By.id("submit");
    public static By depositLink = By.linkText("Deposit");
    public static By accType = By.id("selectedAccount");
    public static By amount = By.id("amount");
    public static String submitAcc = "//button[text()=' Submit']";
    public static By Withdrawlink = By.linkText("Withdraw");
    

}
