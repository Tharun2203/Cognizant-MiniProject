package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.xpath("//*[@id='input-auto-complete']");

    //By nextBtn = By.xpath("//*[@id='__next']/div[1]/div[6]/div/div/button/span[1]");
    By startDate = By.xpath("//button[@data-testid='valid-calendar-day-2026-01-21']");
    By endDate = By.xpath("//button[@data-testid='valid-calendar-day-2026-01-23']");


    By guestBtn = By.xpath("//button[@data-testid='adults-amount-minus-button']");
    By applyBtn = By.xpath("//button[@data-testid='guest-selector-apply']");


    public void searchCity(String city) throws InterruptedException {
        driver.findElement(searchBox).sendKeys(city);
        Thread.sleep(2000);
        By cityOption = selectdropdown(city);
        driver.findElement(cityOption).click();
    }

    public By selectdropdown(String option) {
        return By.xpath("//mark[text()='"+option+"']");
    }


    public void selectDates() throws InterruptedException {
        Thread.sleep(2000);
        //driver.findElement(nextBtn).click();
        //Thread.sleep(2000);
        driver.findElement(startDate).click();
        driver.findElement(endDate).click();
        //driver.findElement(applyDate).click();
    }

    public void applyGuests() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(guestBtn).click();
        Thread.sleep(3000);
        driver.findElement(applyBtn).click();
    }
}