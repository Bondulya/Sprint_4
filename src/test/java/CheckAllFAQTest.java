import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckAllFAQTest {
    MainPage objMainPage;
    WebDriver driver;


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebElement element = driver.findElement(By.cssSelector(".Home_FAQ__3uVm4"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        objMainPage = new MainPage(driver);
    }



    @Parameterized.Parameters
    public static Object[][] getFAQ() {
        return new Object[][] {
                {  "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                        "Сколько это стоит? И как оплатить?",0},
                { "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                        "Хочу сразу несколько самокатов! Так можно?",1},
                {  "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                        "Как рассчитывается время аренды?",2},
                { "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                        "Можно ли заказать самокат прямо на сегодня?",3},
                { "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                        "Можно ли продлить заказ или вернуть самокат раньше?",4},
                { "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                        "Вы привозите зарядку вместе с самокатом?",5},
                { "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                        "Можно ли отменить заказ?",6},
                { "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                        "Я жизу за МКАДом, привезёте?",7},

        };
    }
    @Parameterized.Parameter
    public String textFAQ;
    @Parameterized.Parameter(1)
    public String questionFAQ;
    @Parameterized.Parameter(2)
    public int number;

    @Test
    public void checkFAQ(){
        objMainPage.clickToButtonFAQ(number);
        Assert.assertTrue(objMainPage.isPanelFAQVisible(number));
        assertEquals(questionFAQ, objMainPage.getQuestionFAQText(number));
        assertEquals(textFAQ, objMainPage.getTextFAQ(number));
    }




    @After
    public void teardown(){
        driver.quit();
    }
}
