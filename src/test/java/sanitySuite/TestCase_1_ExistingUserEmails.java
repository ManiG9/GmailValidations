package sanitySuite;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.Syn_google_search;

import java.util.ArrayList;


public class TestCase_1_ExistingUserEmails extends TestBase{

	Syn_google_search obj_google_search;

	@Test (priority=1, description = "Click on first search option")
	public void ExistingUserEmails() throws InterruptedException {

		log.info("Click on first search option");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = "https://mail.google.com/mail/u/0/#inbox";
        driver.get(url);
        driver.findElement(By.id("identifierId")).sendKeys("gmail@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")).click();
        String Password = driver.findElement(By.cssSelector("[type=\"password\"]")).getText();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement password = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type=\"password\"]")));
        js.executeScript("arguments[0].click();", password);
        password.sendKeys("password");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[2]")).click();
        WebElement inbox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gs_lc50\"]/input[1]")));
        System.out.println("Inbox is loaded");

		/*.....Welcome to GE....*/
		inbox.sendKeys("\"type with email subject\"");
		WebElement searchMailButton = driver.findElement(By.xpath("//*[@id=\"aso_search_form_anchor\"]/button[4]"));
		searchMailButton.click();
		System.out.println("Clicked on search mail button for welcome to ge email");
		WebElement accessAccountEmail = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//td[6]//div[1]//div[1]//div[2]//span[1]//span[1]")));
		accessAccountEmail.click();
		System.out.println("Welcome to GE is opened");
		//scroll down and validate
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//driver.findElement(By.xpath("//*[@id=\":15e\"]")).equals("\"Access Your Growers Edge Account\"");
		Thread.sleep(2000);

		/*.....Agreement has been started....*/
		driver.findElement(By.xpath("//*[@id=\"aso_search_form_anchor\"]//input[1]")).clear();
		inbox.sendKeys("\"type with email subject\"");
		searchMailButton.click();
		System.out.println("Clicked on search mail button for agreement started email");
		WebElement aggStartedEmail = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/table/tbody/tr[1]/td[6]/div[1]/div[1]/div[2]/span[1]")));
		aggStartedEmail.click();
		System.out.println("Agreement Started email is opened");
		//Scroll-down and validate
		Thread.sleep(2000);

	}
}
