package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:4567");

        sleep(2);
        System.out.println(driver.getPageSource());
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(2);

        Random r = new Random();
        int randomi = r.nextInt(100000);

        //Luodaan käyttäjä
        element = driver.findElement(By.name("username"));
        element.sendKeys("arska" + randomi);
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep");

        clickLinkWithText("signup", driver);
        System.out.println(driver.getPageSource());
        sleep(2);

        //Kirjaudutaan ulos rekisteröinnin ja automaattisen kirjautumisen jälkeen
        clickLinkWithText("continue to application mainpage", driver);
        clickLinkWithText("logout", driver);
        System.out.println(driver.getPageSource());

        //Kirjaudutaan sisään; väärä salasana
        driver.get("http://localhost:4567");
        element = driver.findElement(By.linkText("login"));
        element.click();
        sleep(2);
        element = driver.findElement(By.name("username"));
        element.sendKeys("arska" + randomi);
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkepVaaraSalasana");

        clickLinkWithText("login", driver);

        System.out.println(driver.getPageSource());
        driver.quit();
    }

    private static void clickLinkWithText(String text, WebDriver driver) {
        int trials = 0;
        while (trials++ < 5) {
            try {
                WebElement element = driver.findElement(By.linkText(text));
                element.click();
                break;
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }

}
