import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class OrderScooterTest {
    OrderPage objOrder;
    WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;


    public OrderScooterTest(String name, String surname, String address, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static String[][] getOrder(){
        return new String[][]{
                {"Максим", "Кажаев", "проспект Советский 14", "79995344322"},
                {"Анастасия", "Вильгельм", "ул.Кропоткина 12", "79121271798"}
    };
    }

    @Before
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");
        objOrder = new OrderPage(driver);
    }

    private void order(){
        driver.findElement(By.id("rcc-confirm-button")).click();
        objOrder.setNameInput(name);
        objOrder.setSurnameInput(surname);
        objOrder.setAddressInput(address);
        objOrder.setMetroInput();
        objOrder.setPhoneNumber(phone);
        objOrder.clickNextButton();
        objOrder.setDateOfDelivery();
        objOrder.setRentalPeriod();
        objOrder.clickAcceptButton();
        objOrder.clickYesButton();
        objOrder.isWindowVisible();
    }

    @Test
    public void orderTopButton(){
        objOrder.clickOrderButtonTop();
        order();
    }

    @Test
    public void orderDownButton(){
        WebElement element = driver.findElement(By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        objOrder.clickOrderButtonDown();
        order();
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
