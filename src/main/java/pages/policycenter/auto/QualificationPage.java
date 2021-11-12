package pages.policycenter.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

/**
 * Page object encapsulates PC Qualification page
 */
public class QualificationPage {
    //locators
    @FindBy(className = "gw-TitleBar--title")
    private WebElement pageTitle;
    @FindBy(id = "SubmissionWizard-SubmissionWizard_PreQualificationScreen-SourceOfBusinessExtDV-SourceOfBusinessExtDV-PermOrderRpt_0")
    private WebElement permissionToOrderReport;
    @FindBy(name = "SubmissionWizard-SubmissionWizard_PreQualificationScreen-SourceOfBusinessExtDV-SourceOfBusinessExtDV-SourceOfBusiness")
    private WebElement sourceOfBusiness;
    @FindBy(id = "SubmissionWizard-SubmissionWizard_PreQualificationScreen-PreQualQuestionSetsDV-QuestionSetsDV-0-QuestionSetLV-0-QuestionModalInput-ChoiceRadioInput_NoPost_1")
    private WebElement preQualQuestionOne;
    @FindBy(id = "SubmissionWizard-SubmissionWizard_PreQualificationScreen-PreQualQuestionSetsDV-QuestionSetsDV-0-QuestionSetLV-1-QuestionModalInput-ChoiceRadioInput_NoPost_1")
    private WebElement preQualQuestionTwo;

    @FindBy(id = "SubmissionWizard-SubmissionWizard_PreQualificationScreen-PreQualQuestionSetsDV-QuestionSetsDV-0-QuestionSetLV-2-QuestionModalInput-ChoiceRadioInput_1")
    private WebElement preQualQuestionThree;

    @FindBy(id = "SubmissionWizard-SubmissionWizard_PreQualificationScreen-PreQualQuestionSetsDV-QuestionSetsDV-0-QuestionSetLV-3-QuestionModalInput-ChoiceRadioInput_1")
    private WebElement preQualQuestionFour;
    @FindBy(id = "SubmissionWizard-SubmissionWizard_PreQualificationScreen-PreQualQuestionSetsDV-QuestionSetsDV-0-QuestionSetLV-4-QuestionModalInput-ChoiceRadioInput_1")
    private WebElement preQualQuestionFive;
    @FindBy(xpath = "//div[@id='SubmissionWizard-Next\\']/div/div[2]")
    private WebElement next;
    private WebDriver driver;

    public QualificationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void setPermissionToOrderReport() {
        this.permissionToOrderReport.click();
    }

    public void setSourceOfBusiness(String selection) {
        Select select = new Select(sourceOfBusiness);
        select.selectByVisibleText(selection);
    }

    public void setPreQualQuestionOne() {
        this.preQualQuestionOne.click();
    }

    public void setPreQualQuestionTwo() {
        this.preQualQuestionTwo.click();
    }

    public void setPreQualQuestionThree() {
        this.preQualQuestionThree.click();
    }

    public void setPreQualQuestionFour() {
        this.preQualQuestionFour.click();
    }

    public void setPreQualQuestionFive() {
        this.preQualQuestionFive.click();
    }

    public void setNext() {
        this.next.click();
    }

    public boolean isPageOpened() {
        return pageTitle.getText().contains("Qualification");
    }
}
