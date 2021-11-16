package pages.policycenter.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page object encapsulates PC Qualification page
 */
public class QualificationPage extends AutoPolicySubmissionPages {
    @FindBy(id = "SubmissionWizard-SubmissionWizard_PreQualificationScreen-SourceOfBusinessExtDV-SourceOfBusinessExtDV-PermOrderRpt_0")
    private WebElement permissionToOrderReport;
    @FindBy(xpath = "//div[@id='SubmissionWizard-SubmissionWizard_PreQualificationScreen-SourceOfBusinessExtDV-SourceOfBusinessExtDV-SourceOfBusiness']/div[@class='gw-vw--value']/div[@class='gw-select-wrapper']/select")
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

    public QualificationPage(WebDriver driver) {
        super(driver);
    }

    public void setPermissionToOrderReport() {
        this.permissionToOrderReport.click();
    }

    public void setSourceOfBusiness(String selection) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            sourceOfBusiness.click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.visibilityOf(sourceOfBusiness));
            sourceOfBusiness.click();
        }
        String s = "'" + selection + "'";
        WebElement selectSourceOfBusiness = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text()," + s + ")]")));
        selectSourceOfBusiness.click();
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

}
