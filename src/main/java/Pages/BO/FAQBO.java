package Pages.BO;

import Pages.FAQPage;
import org.junit.Assert;

public class FAQBO {
    private FAQPage faqPage;

    public FAQBO() {
        faqPage = new FAQPage();
    }

    public FAQBO moveToFAQ() {
        faqPage
                .faqButtonClick();
        return this;
    }

    public void verifyTrainingListPageDisplayed() {
        Assert.assertTrue("'Training list' page not displayed", faqPage.isActiveFAQButton());
    }
}
