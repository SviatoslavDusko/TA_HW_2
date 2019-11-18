package Pages.BO;

import Pages.NewsPage;
import org.junit.Assert;

public class NewsBO {
    NewsPage newsPage;

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

    public NewsBO isNewsPageDisplayed() {
        Assert.assertTrue("News page is not displayed", newsPage.isNewsPageActive());
        return this;
    }

    public NewsBO isMaterialsPageDisplyed() {
        Assert.assertTrue("Materials button is not displayed", newsPage.isMaterialsPageActive());
        return this;
    }
}
