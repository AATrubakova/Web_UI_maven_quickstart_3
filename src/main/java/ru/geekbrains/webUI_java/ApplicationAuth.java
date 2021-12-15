package ru.geekbrains.webUI_java;

//import io.git
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class ApplicationAuth
{
    public static void main( String[] args )
    {
        System.setProperty("webdriver.chrome.driver","/Users/anna/IdeaProjects/maven_quickstart/src/main/resources/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
//        options.addArguments("--headless");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.chay.info");
        WebElement webElement = driver.findElement(By.cssSelector(".header__top-controls-item--auth svg"));
//        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedCondition.visibilityOf(webElement));
        webElement.click();
        WebElement webLogin = driver.findElement(By.name("USER_LOGIN"));
        webLogin.sendKeys("annet3116@gmail.com");
        WebElement webPass = driver.findElement(By.name("USER_PASSWORD"));
        webPass.sendKeys("xjwMRH6E7TKkpYz");
        WebElement webButtonLogin = driver.findElement(By.cssSelector(".form__buttons > .button--view--dark"));
        webButtonLogin.click();

        driver.quit();
    }
}
