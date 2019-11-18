import Pages.BO.FAQBO;
import org.junit.Test;

public class FAQTest extends BaseTest {
    @Test
    public void moveToFAQPage() {
        new LogInTest()
                .verifyLogIn();
        new FAQBO()
                .moveToFAQ()
                .isTrainingListPageDisplayed();
    }
}
