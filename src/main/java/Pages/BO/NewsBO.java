package Pages.BO;

import Pages.NewsPage;
import org.junit.Assert;

public class NewsBO {
    private NewsPage newsPage;

    public NewsBO() {
        newsPage = new NewsPage();
    }

    public NewsBO newsButtonClick() {
        newsPage.newsButtonClick();
        return this;
    }

    public NewsBO materialsButtonClick() {
        newsPage.materialsButtonClick();
        return this;
    }

    public NewsBO verifyNewsPageDisplayed(String news) {
        Assert.assertTrue("News page is not displayed", newsPage.isNewsPageActive(news));
        return this;
    }

    public void verifyMaterialsPageDisplayed(String materials) {
        Assert.assertTrue("Materials button is not displayed", newsPage.isMaterialsPageActive(materials));
    }
}
