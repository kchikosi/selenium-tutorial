package listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListener implements WebDriverEventListener {
    private static final Logger logger = LogManager.getLogger(WebEventListener.class);

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        logger.info("beforeAlertAccept triggered");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        logger.info("afterAlertAccept triggered");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        logger.info("afterAlertDismiss triggered");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        logger.info("beforeAlertDismiss triggered");
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        logger.info("beforeNavigateTo triggered");
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        logger.info("afterNavigateTo triggered");
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        logger.info("triggered");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        logger.info("beforeNavigateBack triggered");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        logger.info("beforeNavigateForward triggered");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        logger.info("afterNavigateForward triggered");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        logger.info("beforeNavigateRefresh triggered");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        logger.info("afterNavigateRefresh triggered");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("beforeFindBy triggered");
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("afterFindBy triggered");
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("beforeClickOn triggered");
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("afterClickOn triggered");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        logger.info("beforeChangeValueOf triggered");
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        logger.info("afterChangeValueOf triggered");
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        logger.info("beforeScript triggered");
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        logger.info("afterScript triggered");
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        logger.info("beforeSwitchToWindow triggered");
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        logger.info("afterSwitchToWindow triggered");
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        logger.info("onException triggered");
        logger.info("Exception " + throwable.getMessage());
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
        logger.info("beforeGetScreenshotAs triggered");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        logger.info("afterGetScreenshotAs triggered");
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        logger.info("beforeGetText triggered");
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        logger.info("afterGetText triggered");
    }
}
