package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private final WebDriver driver;

    private final By orderButtonTop = By.className("Button_Button__ra12g");
    private final By orderButtonDown = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    private final By nameInput = By.xpath(".//input[@placeholder='* Имя'");
    private final By surnameInput = By.xpath(".//input[@placeholder='* Фамилия'");
    private final By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ'");
    private final By metroInput = By.className("select-search__input");
    private final By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");
    private final By dateOfDelivery = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriod = By.xpath(".//div[@class='Dropdown-root']");
    private final By acceptButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    private final By confirmationWin = By.className("Order_Modal__YZ-d3");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButtonTop(){
        driver.findElement(orderButtonTop).click();
    }

    public void clickOrderButtonDown(){
        WebElement element = driver.findElement(orderButtonDown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(orderButtonDown).click();
    }

    public void setNameInput(String name){
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setSurnameInput(String surname){
        driver.findElement(surnameInput).sendKeys(surname);
    }

    public void setAddressInput(String address){
        driver.findElement(addressInput).sendKeys(address);
    }

    public void setMetroInput(){
        driver.findElement(metroInput).click();
        driver.findElement(By.xpath(".//div[@class='select-search__select']/ul/li/button")).click();
    }
    public void setPhoneNumber(String phoneNumber){
        driver.findElement(phoneInput).sendKeys(phoneNumber);
    }
    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }
    public void setDateOfDelivery(){
        driver.findElement(dateOfDelivery).click();
        driver.findElement(By.xpath("//div[@class='react-datepicker__week'][3]/div[1]")).click();
    }
    public void setRentalPeriod(){
        driver.findElement(rentalPeriod).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div")).click();
    }
    public void clickAcceptButton(){
        driver.findElement(acceptButton).click();
    }
    public void clickYesButton(){
        driver.findElement(yesButton).click();
    }
    public Boolean isWindowVisible(){
        return driver.findElement(confirmationWin).isDisplayed();
    }

}
