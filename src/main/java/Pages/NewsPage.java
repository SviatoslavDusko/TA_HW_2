package Pages;

import Driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class NewsPage extends AbstractPage  {
    private By newsButton = By.xpath("//div[@class='links-row']//li//*[contains(text(),'News')]");
    private By materialsButton = By.xpath("//news-categories[@class='ng-isolate-scope']//div//span[contains(text(),'Materials')]");

    private By newsPageOpenWait = By.xpath("//div[@class='news-page-list__all-news']");

    private By activeButtonMainNav = By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem news click hover activeItem']");
    private By activeButtonTabNav = By.xpath("//div[@class='tab-nav__item ng-scope active']//span");

    public void newsButtonClick() {
        waitBy(newsButton);
        getElement(newsButton).click();
    }

    public void materialsButtonClick() {
//        getElement(materialsButton).click();
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getWebDriver();
        executor.executeScript("arguments[0].click()", getElement(materialsButton));
    }

    public boolean isNewsPageActive(String news) {
        waitBy(newsPageOpenWait);
        return getElement(activeButtonMainNav).getText().toLowerCase().contains(news);
    }

    public boolean isMaterialsPageActive(String materials) {
        return getElement(activeButtonTabNav).getText().toLowerCase().contains(materials);
    }
}
