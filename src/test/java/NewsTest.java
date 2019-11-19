import Pages.BO.NewsBO;
import org.junit.Test;

public class NewsTest extends BaseTest {
    @Test
    public void verifyNewsPage() {
        new LogInTest()
                .verifyLogIn();
        new NewsBO()
                .newsButtonClick()
                .verifyNewsPageDisplayed(NEWS)
                .materialsButtonClick()
                .verifyMaterialsPageDisplayed(MATERIALS);
    }

}
