package sanitySuite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Syn_google_search;

import java.util.ArrayList;


public class TestCase_1_ClickOnLinkInEmail extends TestBase{

    Syn_google_search obj_google_search;


    @Test (priority=1, description = "Open Google Search URL")
    public void ClickOnLinkInEmail() throws InterruptedException {

        log.info("Open Google Search URL.");
        String url = "https://mail.google.com/mail/u/0/#inbox";
        driver.get(url);
        driver.findElement(By.id("identifierId")).sendKeys("gmail@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")).click();
        String Password = driver.findElement(By.cssSelector("[type=\"password\"]")).getText();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement password = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type=\"password\"]")));
        js.executeScript("arguments[0].click();", password);
        password.sendKeys("password");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[2]")).click();
        Thread.sleep(2000);
        WebElement inbox = driver.findElement(By.xpath("//*[@id='gs_lc50']/input[1]"));
        System.out.println("Inbox is loaded");
        inbox.sendKeys("\"type with email subject\"");
        WebElement searchMailButton = driver.findElement(By.xpath("//*[@id=\"aso_search_form_anchor\"]/button[4]"));
        searchMailButton.click();
        System.out.println("Clicked on search mail button for welcome to ge email");
        WebElement accessAccountEmail = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//td[6]//div[1]//div[1]//div[2]//span[1]//span[1]")));
        accessAccountEmail.click();
        accessAccountEmail.sendKeys(Keys.PAGE_DOWN);
        System.out.println("Welcome to GE is opened");
        //scroll down for multiple emails
        Thread.sleep(2000);
        WebElement link = (driver.findElement(By.xpath("//div[1]/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr/td/a")));
        link.click();
        Thread.sleep(300);
        String parentWindow = driver.getWindowHandle();
        Thread.sleep(300);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        System.out.println("Onboard url is opened");
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@formcontrolname=\"password\"]"))).sendKeys("password");
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Get Started!')]"))).click();
        Thread.sleep(3000);
        System.out.println("Step1 is completed");
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Continue to Notifications')]"))).click();
        Thread.sleep(3000);
        System.out.println("Step2 clicked on continue is completed");
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Access your account')]"))).click();
        Thread.sleep(2000);
        System.out.println("Step3 is completed");
        driver.switchTo().window(tabs2.get(0));
        driver.switchTo().defaultContent();
        Thread.sleep(1000);

    }

}
