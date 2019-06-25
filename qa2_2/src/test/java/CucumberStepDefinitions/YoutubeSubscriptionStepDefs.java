package CucumberStepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Channel;
import pageObject.pages.*;
import utility.Constant;

import java.util.ArrayList;
import java.util.List;


public class YoutubeSubscriptionStepDefs {

    private BaseFunctions baseFunctions;
    List<String> subscriptionTitles;


    @Given("user is on Home page")
    public void user_is_on_Home_page() throws InterruptedException {
        baseFunctions = new BaseFunctions();
        baseFunctions.goToUrl(Constant.URL);

        HomePage homePage = new HomePage(baseFunctions);
        homePage.clickOnButton(homePage.BTN_SIGN_IN);

        LoginPage loginPage = new LoginPage(baseFunctions);
        loginPage.logIn(Constant.LOGIN, Constant.PWD);
    }

    @When("he search for (.*) at search field")
    public void he_search_for_channel_at_search_field(String text) {
        HomePage homePage = new HomePage(baseFunctions);
        homePage.searchForVideo(text);
        baseFunctions.reloadScreen();
    }

    @When("choose to subscribe to channel with index {int} at search results page")
    public void choose_to_subscribe_to_channel_with_index_at_search_results_page(Integer int1) {
        ResultsPage resultsPage = new ResultsPage(baseFunctions);
        Channel subscribedChannel = resultsPage.subscribeToChannelByIndex(int1);

        subscriptionTitles = new ArrayList<String>();
        subscriptionTitles.add(resultsPage.getChannelTitle(subscribedChannel));
    }


    @When("select to open video by index {int}")
    public void select_to_open_video_by_index(Integer int1) {
        ResultsPage resultsPage = new ResultsPage(baseFunctions);
        resultsPage.clickOnVideoByIndex(int1);
    }

    @When("choose to subscribe to channel on video page")
    public void choose_to_subscribe_to_channel_on_video_page() {
        VideoPage videoPage = new VideoPage(baseFunctions);
        Channel subscribedChannel = videoPage.subscribeToChannel();
        subscriptionTitles.add(videoPage.getChannelTitle(subscribedChannel));
    }

    @When("he navigates to home page")
    public void he_navigates_to_home_page() {
        HomePage homePage = new HomePage(baseFunctions);
        homePage.clickOnButton(homePage.LNK_HOME);
        baseFunctions.reloadScreen();
    }

    @When("select to open (.*) section from Main Menu")
    public void select_to_open_Gaming_section_from_Main_Menu(String sectionName) {
        MainMenuHelper mainMenuHelper = new MainMenuHelper(baseFunctions);
        mainMenuHelper.selectSectionByName(sectionName);
    }

    @When("choose to subscribe to channel on channels page")
    public void choose_to_subscribe_to_channel_on_channels_page() {
        ChannelPage channelPage = new ChannelPage(baseFunctions);
        Channel subscribedChannel = channelPage.subscribeToChannel();
        subscriptionTitles.add(channelPage.getChannelTitle(subscribedChannel));
    }

    @Then("Verify Subscriptions are available on main menu page")
    public void verify_Subscriptions_are_available_on_main_menu_page() {
        HomePage homePage = new HomePage(baseFunctions);
        homePage.clickOnButton(homePage.LNK_HOME);
        baseFunctions.reloadScreen();

        homePage.verifySubscription(subscriptionTitles);
    }

    @Then("Verify Subscriptions are available on subscriptions page")
    public void verify_Subscriptions_are_available_on_subscriptions_page() {
        HomePage homePage = new HomePage(baseFunctions);
        homePage.navigateToSubscriptions();

        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(baseFunctions);
        subscriptionsPage.navigateToManageSubscription();
        subscriptionsPage.verifySubscription(subscriptionTitles);
    }

    @After
    public void close_browser_and_remove_subscriptions() {
        HomePage homePage = new HomePage(baseFunctions);
        homePage.navigateToSubscriptions();

        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(baseFunctions);
        subscriptionsPage.removeSubsriptions();
        baseFunctions.closeBrowser();
    }

}
