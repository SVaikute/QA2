package youtube;

import model.Channel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pageObject.pages.*;
import utility.Constant;
import java.util.ArrayList;
import java.util.List;

public class YoutubeSubscriptionTest {

    private BaseFunctions baseFunctions;
    private final Logger LOGGER = LogManager.getLogger(YoutubeSubscriptionTest.class);

    /*
    На сайте YouTube выбрать рандомно 3 канала и подписаться из разных мест,
    в разделе подписок и в меню на главной проверить, что подписки есть.
     */


    @Test
    public void subscriptionsTest() throws InterruptedException {
        baseFunctions = new BaseFunctions();
        LOGGER.info("1. Open " + Constant.URL);
        baseFunctions.goToUrl(Constant.URL);

        HomePage homePage = new HomePage(baseFunctions);
        homePage.clickOnButton(homePage.BTN_SIGN_IN);

        LOGGER.info("2. Sign In as test user");
        LoginPage loginPage = new LoginPage(baseFunctions);
        loginPage.logIn(Constant.LOGIN, Constant.PWD);

        LOGGER.info("3. Search for channel");
        homePage.clickOnButton(homePage.LNK_HOME);
        homePage.searchForVideo("channels");

        LOGGER.info("4. Subscribe to channel");
        ResultsPage resultsPage = new ResultsPage(baseFunctions);
        Channel subscribedChannel = resultsPage.subscribeToChannelByIndex(0);

        List<String> subscriptionTitles = new ArrayList<String>();
        subscriptionTitles.add(resultsPage.getChannelTitle(subscribedChannel));


        LOGGER.info("5. Search and click on first video");
        homePage.searchForVideo("funny videos");
        baseFunctions.reloadScreen();

        resultsPage = new ResultsPage(baseFunctions);
        resultsPage.clickOnVideoByIndex(0);

        LOGGER.info("6. Subscribe to channel from Video Page");
        VideoPage videoPage = new VideoPage(baseFunctions);
        Channel subscribedChannel2 = videoPage.subscribeToChannel();
        subscriptionTitles.add(videoPage.getChannelTitle(subscribedChannel2));


        LOGGER.info("8. Navigate to home page");
        homePage = new HomePage(baseFunctions);
        homePage.clickOnButton(homePage.LNK_HOME);
        baseFunctions.reloadScreen();

        LOGGER.info("9. Click On Section");
        MainMenuHelper mainMenuHelper = new MainMenuHelper(baseFunctions);
        mainMenuHelper.selectSectionByName("Gaming");

        LOGGER.info("10. Subscribe on channel page");
        ChannelPage channelPage = new ChannelPage(baseFunctions);
        Channel subscribedChannel3 = channelPage.subscribeToChannel();
        subscriptionTitles.add(channelPage.getChannelTitle(subscribedChannel3));


        LOGGER.info("11. Navigate to subscriptions");
        homePage = new HomePage(baseFunctions);
        homePage.navigateToSubscriptions();

        LOGGER.info("12. Verify subscription");
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(baseFunctions);
        subscriptionsPage.navigateToManageSubscription();
        subscriptionsPage.verifySubscription(subscriptionTitles);

        LOGGER.info("13. Navigate to man menu");
        homePage.clickOnButton(homePage.LNK_HOME);
        baseFunctions.reloadScreen();
        LOGGER.info("14. Verify subscription");
        homePage.verifySubscription(subscriptionTitles);


    }

    @AfterEach
    public void closeBrowser() {
        LOGGER.info("15. Navigate to subscriptions");
        HomePage homePage = new HomePage(baseFunctions);
        homePage.navigateToSubscriptions();
        LOGGER.info("16. Remove subscriptions");
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(baseFunctions);
        subscriptionsPage.removeSubsriptions();
        baseFunctions.closeBrowser();
    }
}
