package Pages;

import Driver.Driver;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class NewsPage extends AbstractPage {
    private By newsButton = By.xpath("//div[@class='links-row']//li//*[contains(text(),'News')]");
    private By materialsButton = By.xpath("//news-categories[@class='ng-isolate-scope']//div//span[contains(text(),'Materials')]");

    private By newsPageOpenWait = By.xpath("//div[@class='news-page-list__all-news']");

    private By activeButtonMainNav = By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem news click hover activeItem']");
    private By newsButtonLink = By.xpath("//ul[@class='main-nav__list']//a[contains(text(),'News')]");
    private By activeButtonTabNav = By.xpath("//div[@class='tab-nav__item ng-scope active']//span");

    public NewsPage newsButtonClick (){
        waitBy(newsButton);
        getElement(newsButton).click();
        return this;
    }

    public NewsPage materialsButtonClick(){
//        getElement(materialsButton).click();
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getWebDriver();
        executor.executeScript("arguments[0].click()", getElement(materialsButton));
        return this;
    }

    public boolean isNewsPageActive(){
        waitBy(newsPageOpenWait);
        if (getElement(activeButtonMainNav).getText().toLowerCase().contains("news")){
            return true;
        }else {
            return false;
        }
    }

    public boolean isMaterialsPageActive(){
        if (getElement(activeButtonTabNav).getText().toLowerCase().contains("materials")){
            return true;
        }else {
            return false;
        }
    }
}
