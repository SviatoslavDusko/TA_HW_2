package Pages;

import org.openqa.selenium.By;

public class FAQPage extends AbstractPage {
    private By FAQButton = By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem faq click hover'][contains(text(),'FAQ')]");
    private By activeFAQButton = By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem faq click hover activeItem']");

    public void faqButtonClick() {
        getElement(FAQButton).click();
    }

    public boolean isActiveFAQButton() {
        waitBy(activeFAQButton);
        return isElementDisplayed(activeFAQButton);
    }
}
