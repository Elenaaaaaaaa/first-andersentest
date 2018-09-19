package ua.org.autotest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;



public class AndersenTest1 {

    private static WebDriver driver;

    @BeforeClass

    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/uzer/Downloads/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test

    public void userLogin() {
        driver.get("https://www.gmail.com/");
        WebElement loginField = driver.findElement(By.cssSelector("#identifierId"));
        loginField.sendKeys("epolataiko@gmail.com");

        WebElement NextButton = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]"));
        NextButton.click();
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        passwordField.sendKeys("pl78ER67and");
        WebElement passwordNextButton = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]"));

        passwordNextButton.click();

        WebElement writeButton = driver.findElement(By.cssSelector("#\\3a iy > div > div"));
        writeButton.click();

        WebElement toField = driver.findElement(By.name("to"));
        toField.sendKeys("qa.gradilenko@gmail.com");

        WebElement subjectField = driver.findElement(By.className("aoT"));
        subjectField.sendKeys("firsttest");

        WebElement editableField = driver.findElement(By.className("editable"));
        editableField.sendKeys("Hi Vladimir. My name is Elena Polataiko. I'm a student of automation courses");

        WebElement aoOButton = driver.findElement(By.className("aoO"));
        aoOButton.click();

        new WebDriverWait(driver, 10)
        .until(ExpectedConditions.textToBePresentInElement(By.xpath("//*[@class=\"bAq\"]"),"Письмо отправлено."));
        WebElement source = driver.findElement(By.xpath("//*[@class=\"bAq\"]"));
        Assert.assertEquals("Письмо отправлено.", source.getText());

    }

    @AfterClass
    public static void writeLetter(){
        driver.quit();
    }



}
