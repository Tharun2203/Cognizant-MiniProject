package tests;
import pages.*;
import org.testng.annotations.*;
import utils.ExcelUtils;

import java.util.List;

public class TrivagoTest extends BaseTest {


    @Test(dataProvider = "cityData")
    public void trivagoHotelTest(String city) throws InterruptedException {
        HomePage home = new HomePage(driver);
        FiltersPage filter = new FiltersPage(driver);
        ResultsPage results = new ResultsPage(driver);
        home.searchCity(city);
        home.selectDates();
        home.applyGuests();

        filter.sortByRating();

        Thread.sleep(5000);
        results.printHotels();
        results.verifyRatingsDescending();

    }

    @DataProvider(name = "cityData")
    public Object[][] getCities() {
        List<String> cities = ExcelUtils.getCities();
        Object[][] data = new Object[cities.size()][1];
        for (int i = 0; i < cities.size(); i++) {
            data[i][0] = cities.get(i);
        }
        return data;
    }
}
