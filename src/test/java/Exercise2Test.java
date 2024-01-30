import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.time.Duration.ofSeconds;

public class Exercise2Test {

    WebDriver driver;

    @BeforeEach
    void createLoad(){
        driver = new ChromeDriver();
        driver.get("http://192.168.1.188/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));

    }

    @Test
    void exercise2(){

//        3. Enter a wrong product name in Search field (F.e: MaxBook)

        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("MaxBook");
        palaukti();

//        4. Click button

        driver.findElement(By.xpath("//*[@id=\"search\"]/button")).click();
        palaukti();

//        5. Check if search button is displayed

        driver.findElement(By.id("button-search")).isDisplayed();
        palaukti();

//        6. Clear first Search field and enter the correct product name (F.e: MacBook)

        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).clear();
        palaukti();

//        7. Click button again

        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("MacBook");
        palaukti();

//        8. Count the number of searched items

        driver.findElement(By.xpath("//*[@id=\"search\"]/button")).click();
        palaukti();
        List<WebElement> searchResults = driver.findElements(By.xpath("//input[@type='text']"));
        int numberOfSearchResults = searchResults.size();
        System.out.println("Number of searched items: " + numberOfSearchResults);
        palaukti();

//      9. Select SortBy: Price (Low > High)

        Select priceValue = new Select(driver.findElement(By.id("input-sort")));
        priceValue.selectByIndex(3);
        palaukti();

//        10. Retrieve selected option text and print it

        System.out.println(new Select(driver.findElement(By.id("input-sort"))).getFirstSelectedOption().getText());
        palaukti();

//        11. Close browser

        driver.quit();
    }
    public static void palaukti() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
    }
}
