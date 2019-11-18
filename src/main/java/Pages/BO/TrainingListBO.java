package Pages.BO;

import Pages.TrainingListPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TrainingListBO {
    TrainingListPage trainingListPage;

    public TrainingListBO() {
        trainingListPage = new TrainingListPage();
    }

    public TrainingListBO moveToTrainingListPage() {
        trainingListPage.trainingListButtonClick();
        return this;
    }

    public TrainingListBO openSearchListAndClickBySkills() {
        trainingListPage
                .openSearchListWithCheckbox()
                .bySkillsOrLocationChooseClick("By skills");
        return this;
    }

    public TrainingListBO openSearchListAndClickByLocations() {
        trainingListPage
                .openSearchListWithCheckbox()
                .bySkillsOrLocationChooseClick("By locations");
        return this;
    }

    public TrainingListBO searchTrainingsBySkillsByWord(String searchSkill, String searchCheckBoxKey) {
        trainingListPage
                .enterTextToSearchBySkillsOrLocationsInput(searchSkill)
                .clickCheckBox(searchCheckBoxKey)
                .closeSearchListWithCheckbox();
        return this;
    }

    public TrainingListBO searchTrainingsBySkillsByCheckBoxesWithWord(String searchSkill, String searchCheckBoxesKey) {
        trainingListPage
                .enterTextToSearchBySkillsOrLocationsInput(searchSkill)
                .clickCheckBoxes(searchCheckBoxesKey)
                .closeSearchListWithCheckbox();
        return this;
    }

    public TrainingListBO cleanedAllCheckBoxes() {
        trainingListPage
                .openSearchListWithCheckbox()
                .deleteAllTicks()
                .closeSearchListWithCheckbox();
        return this;
    }

    public TrainingListBO searchTrainingByCityAndCountry(String city, String country) {
        trainingListPage
                .chooseCountry(country)
                .clickCheckBoxes(city)
                .closeSearchListWithCheckbox();
        return this;
    }

    public TrainingListBO searchGetTextInput(String text) {
        trainingListPage
                .openSearchListWithCheckbox()
                .enterTextToSearchBySkillsOrLocationsInput(text);
        return this;
    }

    public TrainingListBO isTrainingListPageDisplayed() {
        Assert.assertTrue("'Training list' page not displayed", trainingListPage.isActiveTrainingListButton());
        return this;
    }

    public TrainingListBO isBySkillsActiveButtonDisplayed() {
        Assert.assertTrue("'By skills' button is not active", trainingListPage.isActiveBySkillsButton());
        return this;
    }

    public TrainingListBO isByLocationsActiveButtonDisplayed() {
        Assert.assertTrue("'By locations' button is not active", trainingListPage.isActiveByLocationButton());
        return this;
    }

    public TrainingListBO isSearchResultByWordJavaValid() {
        for (WebElement option : trainingListPage.getListWithSearchElements()) {
            Assert.assertTrue(option.getText().toLowerCase().contains("java".toLowerCase()) || option.getText().toLowerCase().contains("HR/TA ACADEMY KHARKIV WINTER 2020".toLowerCase()));
        }
        return this;
    }

    public TrainingListBO isSearchResultByWordValid(String word) {
        for (WebElement option : trainingListPage.getListWithSearchElements()) {
            Assert.assertTrue(option.getText().toLowerCase().contains(word.toLowerCase()));
        }
        return this;
    }

    public TrainingListBO isEmptySearchResultByWord(String word) {
        Assert.assertTrue("List with results is not empty", trainingListPage.getListCheckBoxes().size() == 0);
        return this;
    }

    public TrainingListBO isAllResultsByCityValid(String city) {
        for (WebElement option : trainingListPage.getListWithSearchElementsByCity()) {
            Assert.assertTrue(option.getText().toLowerCase().contains(city.toLowerCase()));
        }
        return this;
    }
}
