    package pages;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;

    public class FiltersPage {

        WebDriver driver;

        public FiltersPage(WebDriver driver) {
            this.driver = driver;
        }

        By sortFilter = By.xpath("//button[@name='sorting_selector']");
        By ratingOnly = By.xpath("//input[@data-testid='sorting-index-6']");
        By applyBtn = By.xpath("//button[@data-testid='filters-popover-apply-button']");

        public void sortByRating() throws InterruptedException {
            Thread.sleep(3000);
            driver.findElement(sortFilter).click();
            Thread.sleep(2000);
            driver.findElement(ratingOnly).click();
            Thread.sleep(2000);
            driver.findElement(applyBtn).click();
        }
    }