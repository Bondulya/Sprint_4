package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {
    private final WebDriver driver;


    public void clickToButtonFAQ(int number){
        By questionsFAQ= By.id("accordion__heading-"+number);
        driver.findElement(questionsFAQ).click();
    }

    public String getTextFAQ(int number){
        By panelFAQ = By.xpath(".//div[@id='accordion__panel-"+number+"']/p");
        return driver.findElement(panelFAQ).getText();
    }

    public String getQuestionFAQText(int number){
        By questionsFAQ = By.id("accordion__heading-" + number);
        return driver.findElement(questionsFAQ).getText();
    }
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public Boolean isPanelFAQVisible(int number){
        By panelFAQ = By.id("accordion__panel-"+number);
        return driver.findElement(panelFAQ).isDisplayed();
    }





}
