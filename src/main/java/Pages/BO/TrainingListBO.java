package Pages.BO;

import Pages.TrainingListPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class TrainingListBO {
    private TrainingListPage trainingListPage;

    public TrainingListBO() {
        trainingListPage = new TrainingListPage();
    }

    public TrainingListBO moveToTrainingListPage() {
        trainingListPage.trainingListButtonClick();
        return this;
    }

    public TrainingListBO openSearchListAndClickBySkills(String bySkills) {
        trainingListPage
                .openSearchListWithCheckbox()
                .bySkillsOrLocationChooseClick(bySkills);
        return this;
    }

    public TrainingListBO openSearchListAndClickByLocations(String byLocations) {
        trainingListPage
                .openSearchListWithCheckbox()
                .bySkillsOrLocationChooseClick(byLocations);
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

    public TrainingListBO verifyTrainingListPageDisplayed() {
        Assert.assertTrue("'Training list' page not displayed", trainingListPage.isActiveTrainingListButton());
        return this;
    }

    public TrainingListBO verifyBySkillsActiveButtonDisplayed(String bySkills) {
        Assert.assertTrue("'By skills' button is not active", trainingListPage.isActiveBySkillsButton(bySkills));
        return this;
    }

    public TrainingListBO verifyByLocationsActiveButtonDisplayed(String byLocation) {
        Assert.assertTrue("'By locations' button is not active", trainingListPage.isActiveByLocationButton(byLocation));
        return this;
    }

    public TrainingListBO verifySearchResultByWordJavaValid(String java, String hrTaAcademy) {
        for (WebElement option : trainingListPage.getListWithSearchElements()) {
            Assert.assertTrue(option.getText().toLowerCase().contains(java.toLowerCase())
                    || option.getText().toLowerCase().contains(hrTaAcademy.toLowerCase()));
        }
        return this;
    }

    public TrainingListBO verifySearchResultByWordValid(String word) {
        for (WebElement option : trainingListPage.getListWithSearchElements()) {
            Assert.assertTrue(option.getText().toLowerCase().contains(word.toLowerCase()));
        }
        return this;
    }

    public void verifyEmptySearchResult() {
        Assert.assertEquals(trainingListPage.getListCheckBoxes().size(), 0);
    }

    public void verifyAllResultsByCityValid(String city) {
        for (WebElement option : trainingListPage.getListWithSearchElementsByCity()) {
            Assert.assertTrue(option.getText().toLowerCase().contains(city.toLowerCase()));
        }
    }
}
