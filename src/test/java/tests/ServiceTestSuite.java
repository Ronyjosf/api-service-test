package tests;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.jupiter.api.*;
import structure.BaseTest;
import structure.MyConsumer;
import structure.PublisherTest;

import static org.junit.jupiter.api.Assertions.fail;

public class ServiceTestSuite extends BaseTest {
    static MyConsumer myConsumer = new MyConsumer();

    @BeforeAll
    static void beforeAll() throws Exception {
        if (myConsumer.getApiStatus()!=200){
            fail("Api service didn't return 200");
        }
        // Data is Test asset only
        String[] jsonStringArr = testData.loadTestData();
        logger.info("tests data = "+jsonStringArr);
//        myConsumer.loadPublisher(jsonStringArr[0]);
        //load all data - use the service loadProviders
        myConsumer.loadPublishers(jsonStringArr);
    }
    @Test
    @DisplayName("get publisher readings OUTLIER, verify number is valid")
    public void getPublisherReadingsOutlier(TestInfo testInfo) throws Exception {

        int publisherTestIndex = 1;
        PublisherTest publisherTest = testData.getPublisherTest(publisherTestIndex);
        if (publisherTest == null)
            fail("couldn't get PublisherTest");
        Assertions.assertEquals(Integer.valueOf(myConsumer.getOutlierById(publisherTest.publisherId)), testData.getLargestNum(testData.getPublisherTest(publisherTestIndex).readings));
        test.log(LogStatus.PASS, "get publisher readings OUTLIER", "number is valid");
    }
    @Test

    @DisplayName("get readings OUTLIER per invalid publisher id, verify return is null")
    public void getInvalidPublisherReadingsOutlier() throws Exception {
        int publisherTestNum = 0;
            Assertions.assertTrue(myConsumer.getOutlierById("0") ==null);
        test.log(LogStatus.PASS, "get readings OUTLIER per invalid publisher id", "returned null");

    }
    @Test
    @DisplayName("get publisher readings OUTLIER accorging to last-n-readings, verify number is valid")
    public void getPuplisherReadingOutlier_last_n_readings() throws Exception {
        int publisherTestIndex = 1;
        PublisherTest publisherTest = testData.getPublisherTest(publisherTestIndex);
        if (publisherTest == null)
            fail("couldn't get PublisherTest");
        Assertions.assertTrue(myConsumer.getOutlierById(publisherTest.publisherId, 3)!=null);
        test.log(LogStatus.PASS, "get publisher readings OUTLIER accorging to last-n-readings", "number is valid");
    }

    @BeforeEach
    public void beforeEach(TestInfo testInfo){
        test = new ExtentTest(testInfo.getDisplayName(), "get publisher Outlier");
        report.startTest(testInfo.getDisplayName());
    }
    @AfterEach
    public void afterEach(){
        report.endTest(test);
        report.flush();

    }
}
