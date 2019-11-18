import Pages.BO.TrainingListBO;
import org.junit.Test;

public class TrainingListTest extends BaseTest {
    @Test
    public void trainingSearchSkills() {
        new LogInTest()
                .verifyLogIn();
        new TrainingListBO()
                .moveToTrainingListPage()
                .isTrainingListPageDisplayed()
                .openSearchListAndClickBySkills()
                .isBySkillsActiveButtonDisplayed()
                .searchTrainingsBySkillsByWord("Java", "Java")
                .isSearchResultByWordJavaValid()
                .cleanedAllCheckBoxes()
                .openSearchListAndClickBySkills()
                .isBySkillsActiveButtonDisplayed()
                .searchTrainingsBySkillsByCheckBoxesWithWord("DATA", "data")
                .isSearchResultByWordValid("data")
                .cleanedAllCheckBoxes()
                .searchGetTextInput("Pascal")
                .isEmptySearchResultByWord("Pascal");
    }

    @Test
    public void trainingSearchLocations() {
        new LogInTest()
                .verifyLogIn();
        new TrainingListBO()
                .moveToTrainingListPage()
                .isTrainingListPageDisplayed()
                .openSearchListAndClickByLocations()
                .isByLocationsActiveButtonDisplayed()
                .searchTrainingByCityAndCountry("Lviv", "Ukraine")
                .isAllResultsByCityValid("Lviv");
    }

}
