package org.example.demoqa;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDemoqa {

    @FindBy(xpath = "//*[@id='userName']")
    WebElement usernameElem;

    @FindBy(xpath = "//*[@id='password']")
    WebElement passwordElem;

    @FindBy(id = "login")
    WebElement loginElem;

    @FindBy(id = "userName-value")
    WebElement profileNameElem;
    WebDriver driver;

    JavascriptExecutor executor;

    public LoginDemoqa(WebDriver driverParam){
        driver = driverParam;
        executor = (JavascriptExecutor) driverParam;
        PageFactory.initElements(driver, this);
    }

    public String getProfileName() throws InterruptedException {
        Thread.sleep(2000);
        return profileNameElem.getText();
    }
    public void setUserName(String userNameParam){
        usernameElem.sendKeys(userNameParam);
    }

    public void setPassword(String passwordParam){
        passwordElem.sendKeys(passwordParam);
    }

    public void clickLogin(){
        closeAdvertisment();
        scrollToElem(loginElem);
        loginElem.click();
    }

    public void closeAdvertisment(){
        try{
            executor.executeScript("var elem = document.evaluate(\"//footer\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; elem.parentNode.removeChild(elem);");


        } catch (Exception e){}

        try {
            executor.executeScript("var elem = document.getElementById('fixedban');" +
                    "elem.parentNode.removeChild(elem);");
        } catch (Exception e){}
    }

    public void scrollToElem(WebElement elemParam){
        executor.executeScript("arguments[0].scrollIntoView(true);", elemParam);
    }
}

