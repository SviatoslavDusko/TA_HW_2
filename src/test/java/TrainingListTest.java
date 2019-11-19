import Pages.BO.TrainingListBO;
import org.junit.Test;

public class TrainingListTest extends BaseTest {
    @Test
    public void trainingSearchSkills() {
        new LogInTest()
                .verifyLogIn();
        new TrainingListBO()
                .moveToTrainingListPage()
                .verifyTrainingListPageDisplayed()
                .openSearchListAndClickBySkills(BYSKILLS)
                .verifyBySkillsActiveButtonDisplayed(BYSKILLS)
                .searchTrainingsBySkillsByWord(JAVA, JAVA)
                .verifySearchResultByWordJavaValid(JAVA,HRTAACADEMY)
                .cleanedAllCheckBoxes()
                .openSearchListAndClickBySkills(BYSKILLS)
                .verifyBySkillsActiveButtonDisplayed(BYSKILLS)
                .searchTrainingsBySkillsByCheckBoxesWithWord(DATA, DATA)
                .verifySearchResultByWordValid(DATA)
                .cleanedAllCheckBoxes()
                .searchGetTextInput(PASCAL)
                .verifyEmptySearchResult();
    }

    @Test
    public void trainingSearchLocations() {
        new LogInTest()
                .verifyLogIn();
        new TrainingListBO()
                .moveToTrainingListPage()
                .verifyTrainingListPageDisplayed()
                .openSearchListAndClickByLocations(BYLOCATIONS)
                .verifyByLocationsActiveButtonDisplayed(BYLOCATIONS)
                .searchTrainingByCityAndCountry(LVIV, UKRAINE)
                .verifyAllResultsByCityValid(LVIV);
    }

}
