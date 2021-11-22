package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
                System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );

                // Тест-кейс 1. Создание проекта
        WebDriver driver = new ChromeDriver();
        driver.get("https://crm.geekbrains.space");
        WebElement login = driver.findElement(By.id("prependedInput"));
        login.sendKeys("Applanatest1");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
        // Операции на главной странице
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//span[contains(.,'Мои проекты')]")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // Операции на странице Все Мои проекты попробовать вставить ожидание
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("/my"));
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[1]/div/div/div[2]/div/div/a")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("/create"));

        WebElement nameOfProject = driver.findElement(By.name("crm_project[name]"));
        nameOfProject.sendKeys("crm_project_test7");

        WebElement selectBusinessUnit = driver.findElement(By.name("crm_project[businessUnit]"));
        Select businessUnit = new Select(selectBusinessUnit);
        businessUnit.selectByVisibleText("Research & Development");

        WebElement selectCurator = driver.findElement(By.name("crm_project[curator]"));
        Select curator = new Select(selectCurator);
        curator.selectByVisibleText("Юзеров Юзер");

        WebElement selectDirector = driver.findElement(By.name("crm_project[rp]"));
        Select director = new Select(selectDirector);
        director.selectByVisibleText("Юзеров Юзер");

        WebElement selectAdmin = driver.findElement(By.name("crm_project[administrator]"));
        Select admin = new Select(selectAdmin);
        admin.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        WebElement selectManager = driver.findElement(By.name("crm_project[manager]"));
        Select manager = new Select(selectManager);
        manager.selectByVisibleText("Applanatest Applanatest Applanatest");

        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[1]/div/div/div[2]/div[1]/div[4]/button")).click();

        driver.quit();


                //Тест-кейс 2. Создание контактного лица в организации с минимально заполненной информацией
        WebDriver driverTest2 = new ChromeDriver();
        driverTest2.get("https://crm.geekbrains.space");
        driverTest2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement loginTest2 = driverTest2.findElement(By.id("prependedInput"));
        loginTest2.sendKeys("Applanatest1");
        WebElement passwordTest2 = driverTest2.findElement(By.id("prependedInput2"));
        passwordTest2.sendKeys("Student2020!");
        driverTest2.findElement(By.id("_submit")).click();
        driverTest2.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")).click();
        driverTest2.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/ul/li[4]/a/span")).click();
        driverTest2.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[1]/div/div/div[2]/div/div")).click();

        WebElement surnameTest2 = driverTest2.findElement(By.name("crm_contact[lastName]"));
        surnameTest2.sendKeys("Сальникова");
        WebElement nameTest2 = driverTest2.findElement(By.name("crm_contact[firstName]"));
        nameTest2.sendKeys("Мари");

        WebElement selectCompany = driverTest2.findElement(By.xpath("//span[contains(.,'Укажите организацию')]"));
        selectCompany.click();
        WebElement company1234test = driverTest2.findElement(By.xpath("/html/body/div[7]/ul[2]/li[3]"));
        company1234test.click();


        WebElement jobTittleTest2 = driverTest2.findElement(By.name("crm_contact[jobTitle]"));
        jobTittleTest2.sendKeys("QA");

        driverTest2.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();

        driverTest2.quit();

    }
}
