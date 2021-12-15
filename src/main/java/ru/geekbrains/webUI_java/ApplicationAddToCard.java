package ru.geekbrains.webUI_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationAddToCard {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/anna/IdeaProjects/maven_quickstart/src/main/resources/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
//        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        options.addArguments("start-maximized");
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
        WebElement menuElement = driver.findElement(By.xpath("//li[@class=\"header__bottom-categories-item\"]/a[@href=\"/catalog/kofe/\"]"));
        menuElement.click();

//        Thread.sleep(5000);
        WebElement positionOneHover = driver.findElement(By.xpath("//div[@link=\"/catalog/kofe/vishnya_na_konyake.html\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(positionOneHover).build().perform();


        WebElement positionOneElement = driver.findElement(By.xpath("//button[@data-buy-url=\"/personal/cart/add.php?id=28424\"]"));
        positionOneElement.click();


        WebElement positionTwoHover = driver.findElement(By.xpath("//div[@class=\"catalog-item__content\"]/a[@href=\"/catalog/kofe/turetskiy_myed.html\"]"));
        Actions actionsSecond = new Actions(driver);
        actionsSecond.moveToElement(positionTwoHover).build().perform();


        WebElement positionTwoElement = driver.findElement(By.xpath("//button[@data-buy-url=\"/personal/cart/add.php?id=28226\"]"));
        positionTwoElement.click();

        WebElement goToCardElement = driver.findElement(By.xpath("//a[@href=\"/personal/cart/\"]"));
        goToCardElement.click();

        WebElement buyButtonElement = driver.findElement(By.xpath("//button[@data-entity=\"basket-checkout-button\"]"));
        buyButtonElement.click();

        driver.quit();
    }
}
