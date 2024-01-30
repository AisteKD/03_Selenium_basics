import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise1Test {

    WebDriver driver;

    @BeforeEach
    void createLoad() {
        driver = new ChromeDriver();
        driver.get("http://192.168.1.188/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    }

    @Test
    void exercise1() {
//        3. Click on a wishlist

        driver.findElement(By.xpath("//*[@id=\"wishlist-total\"]/span")).click();
        palaukti();

//        4. Count and print a number of search boxes

        List<WebElement> searchBoxes = driver.findElements(By.xpath("//input[@type='text']"));
        int numberOfSearchBoxes = searchBoxes.size();
        System.out.println("Number of search boxes: " + numberOfSearchBoxes);
        palaukti();

//        5. Find element of email input field and enter email "email@email.com

        driver.findElement(By.id("input-email")).sendKeys("email@email.com");
        palaukti();
        assertEquals("email@email.com", driver.findElement(By.id("input-email")).getAttribute("value"));

//        6. Clear previous field

        driver.findElement(By.id("input-email")).clear();
        assertEquals("", driver.findElement(By.id("input-email")).getAttribute("value"));
        palaukti();

//        7. Submit form

        driver.findElement(By.xpath("//*[@id=\"form-login\"]/div[3]/button")).click();
        assertTrue(driver.findElement(By.id("alert")).isDisplayed());
        palaukti();

//        8. Click on register a new customer

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/a")).click();
        assertEquals("Register Account", driver.getTitle());
        palaukti();

//        9. Check if the field to input password is enabled and print the result

        WebElement password = driver.findElement(By.id("input-password"));
        Assertions.assertTrue(password.isEnabled());
        System.out.println("Is field to input desplayed? " + password.isEnabled());
        palaukti();

//        10. Check if cart element is displayed and print the result

        WebElement cart = driver.findElement(By.xpath("//*[@id=\"header-cart\"]/div/button"));
        cart.isDisplayed();
        System.out.println("Is cart element displayed? " + cart.isDisplayed());
        palaukti();

//        11. Check if agree checkbox is selected and print the result

        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/input"));
        checkbox.isSelected();
        System.out.println("Is checkbox selected? " + checkbox.isSelected());
        palaukti();

//        12. Go to top menu -> Desktops

        WebElement desktop = driver.findElement(By.cssSelector("#narbar-menu > ul > li:nth-child(1) > a"));

//KĄ REIŠKIA Actions?
//        Actions yra klasė, priklausanti Selenium bibliotekai, kuri leidžia kurti ir vykdyti įvairius veiksmus, susijusius su naršyklės valdymu. Ši klasė suteikia galimybę atlikti kompleksinius veiksmus, tokie kaip paspaudimai, judejimai, pelės operacijos ir kt.

//        KĄ REIŠKIA goTo?
//        goTo yra objektas, turintis metodą moveToElement(), kuris nukreips naršyklę prie elemento.
//        desktop yra elementas, prie kurio norima pereiti arba ant kurio norima atlikti veiksmus.
//                perform() yra metodas, kuris vykdo visas ankstesnes operacijas. Tai yra būtina pasirinkta operacija, kad visi veiksmai būtų įvykdyti.
        Actions goTo = new Actions(driver);
        goTo.moveToElement(desktop).perform();
        palaukti();


//        13. Select to show 25 items per page

        WebElement showAllItems = driver.findElement(By.cssSelector("#narbar-menu > ul > li:nth-child(1) > div > a"));
        showAllItems.click();
        WebElement showItemsPerPage = driver.findElement(By.cssSelector("#input-limit"));
        Select select = new Select(showItemsPerPage);
        select.selectByVisibleText("25");
        palaukti();

//        14. Print selected option from the dropbox

        WebElement showItemsPerPage1 = driver.findElement(By.cssSelector("#input-limit"));
        Select select1 = new Select(showItemsPerPage1);
        WebElement selectedOption = select1.getFirstSelectedOption();
        System.out.println("Result: " + selectedOption.getText());
        palaukti();

//        15. Select 4th option in show items per page dropbox

        select1.selectByIndex(3);
        WebElement showItemsPerPage2 = driver.findElement(By.id("input-limit"));
        Select select2 = new Select(showItemsPerPage2);
        WebElement selectFourth = select2.getFirstSelectedOption();
        palaukti();

//        16. Print selected option

        System.out.println("Result: " + selectFourth.getText());
        palaukti();

//        17. Close the window
//        driver.quit();
    }

    public static void palaukti() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}

