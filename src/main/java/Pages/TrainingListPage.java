package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TrainingListPage extends AbstractPage {
    private By trainingButton = By.xpath("//div[@class='links-row']//a[contains(text(),'Training list')]");
    private By openSearchListWithCheckboxButton = By.xpath("//div[@class='filter-toggle__arrow-icon']");
    private By closeSearchListWithCheckboxButton = By.xpath("//div[@class='filter-toggle__arrow-icon arrow-icon-rotate']");
    private By bySkillsOrLocationsNotActiveButton = By.xpath("//div[@class='navigation-item ng-binding']");
    private By bySkillsOrLocationsActiveButton = By.xpath("//div[@class='navigation-item ng-binding active']");
    private By notChoosedCountriesButtons = By.xpath("//div[@class='location__not-active-label city-name ng-binding']");
    private By activeTrainingListButton = By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem training click hover activeItem']");

    private By searchBySkillsOrLocationsInput = By.xpath("//input[@name='training-filter-input']");

    private By trainingButtonActiveWait = By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem training click hover activeItem']");
    private By searchBySkillsOrLocationsWait = By.xpath("//div[@class='filter-toggle']");
    private By dropDownMenuWithSkillsWait = By.xpath("//div[@class='drop-down drop-down-choose drop-down-visibility']");

    private By checkBoxes = By.xpath("//div[@class='filter-toggle']//label");
    private By checkBoxesSkillsOrLocation = By.xpath("//div[@class='location__cities location__skills']//div[@class='filter-toggle']//label");
    private By ulWithCheckBoxes = By.xpath("//ul[@class='location__cities-list-cities location__cities-list-skills']");
    private By checkBoxesActive = By.xpath("//label[@class='location__not-active-label ng-binding location__location-active-label']");
    private By searchElementsBySkillsText = By.xpath("//div[@class='training-list__container training-list__desktop']//a[@class='training-item__title-link ng-binding']");
    private By searchResultsByCityText = By.xpath("//div[@class='training-list__container training-list__desktop']//div[@class='training-item__location ng-binding']");

    public void trainingListButtonClick() {
        waitBy(trainingButton);
        getElement(trainingButton).click();
    }

    public TrainingListPage openSearchListWithCheckbox() {
        waitBy(trainingButtonActiveWait);
        waitBy(openSearchListWithCheckboxButton);
        getElement(openSearchListWithCheckboxButton).click();
        waitBy(dropDownMenuWithSkillsWait);
        return this;
    }

    public TrainingListPage closeSearchListWithCheckbox() {
        waitBy(closeSearchListWithCheckboxButton);
        getElement(closeSearchListWithCheckboxButton).click();
        return this;
    }

    public TrainingListPage bySkillsOrLocationChooseClick(String bySkillsOrByLocation) {
        waitBy(dropDownMenuWithSkillsWait);
        waitBy(bySkillsOrLocationsNotActiveButton);
        if (getElement(bySkillsOrLocationsNotActiveButton).getText().toLowerCase().equals(bySkillsOrByLocation.toLowerCase())) {
            getElement(bySkillsOrLocationsNotActiveButton).click();
        }
        return this;
    }

    public TrainingListPage enterTextToSearchBySkillsOrLocationsInput(String searchText) {
        waitBy(searchBySkillsOrLocationsWait);
        sendKey(searchText, searchBySkillsOrLocationsInput);
//        getElement(searchBySkillsOrLocationsInput).sendKeys(searchText);
        return this;
    }

    public TrainingListPage chooseCountry(String country) {
        waitBy(notChoosedCountriesButtons);
        chooseCountryOnTrainingList(country, notChoosedCountriesButtons);
        return this;
    }

    public TrainingListPage clickCheckBoxes(String key) {
        waitBy(checkBoxes);
        clickOnCheckBoxesWithKey(key, checkBoxes);
        return this;
    }

    public TrainingListPage clickCheckBox(String key) {
        waitBy(checkBoxes);
        clickOnCheckBoxWithKey(key, checkBoxes);
        return this;
    }

    public TrainingListPage deleteAllTicks() {
        waitBy(ulWithCheckBoxes);
        waitAndDisplayedBy(checkBoxesActive);
            clickOnActiveCheckBoxes(checkBoxesActive);
        return this;
    }

    public boolean isActiveTrainingListButton() {
        waitBy(activeTrainingListButton);
        if (isElementDisplayed(activeTrainingListButton)) {
            return true;
        } else
            return false;
    }

    public boolean isActiveBySkillsButton() {
        waitBy(bySkillsOrLocationsActiveButton);
        if (getElement(bySkillsOrLocationsActiveButton).getText().toLowerCase().equals("By skills".toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    public List<WebElement> getListWithSearchElements() {
        return getElements(searchElementsBySkillsText);
    }

    public List<WebElement> getListCheckBoxes() {
        return getElements(checkBoxesSkillsOrLocation);
    }

    public boolean isActiveByLocationButton() {
        waitBy(bySkillsOrLocationsActiveButton);
        if (getElement(bySkillsOrLocationsActiveButton).getText().toLowerCase().equals("By locations".toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    public List<WebElement> getListWithSearchElementsByCity() {
        return getElements(searchResultsByCityText);
    }
}
