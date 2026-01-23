package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage {

    WebDriver driver;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    By hotels = By.className("Obrlah");
    By ratings = By.xpath("//span[@itemprop='ratingValue']");

    public void printHotels() {
        List<WebElement> hotelList = driver.findElements(hotels);
        for(WebElement res : hotelList) {
            System.out.println(res.getText());
        }
    }

    public void verifyRatingsDescending() {
        List<WebElement> ratingList = driver.findElements(ratings);

        for(WebElement ra : ratingList) {
            System.out.println(ra.getText());
        }

        Boolean order = true;

        for(int i = 0; i < ratingList.size()-1; i++) {
            if (Double.parseDouble(ratingList.get(i).getText()) <
                    Double.parseDouble(ratingList.get(i + 1).getText())) {
                order = false;
                break;
            }
        }

        if (order) {
            System.out.println("Test Pass: In Descending Order");
        } else {
            System.out.println("Test Fail: Not in descending order");
        }
    }
}
