package Pages;

import org.openqa.selenium.By;

public class FAQPage extends AbstractPage {
    private By FAQButton = By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem faq click hover'][contains(text(),'FAQ')]");
    private By activeFAQButton = By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem faq click hover activeItem']");

    public FAQPage faqButtonClick() {
        getElement(FAQButton).click();
        return this;
    }

    public boolean isActiveFAQButton() {
        waitBy(activeFAQButton);
        if (isElementDisplayed(activeFAQButton)) {
            return true;
        } else
            return false;
    }
}
