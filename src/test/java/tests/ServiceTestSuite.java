package tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import structure.MyConsumer;
import structure.PublisherTest;
import structure.TestData;

import java.io.File;

import static org.junit.jupiter.api.Assertions.fail;
import static org.slf4j.LoggerFactory.getLogger;
import static structure.TestData.getTestDataInstance;

public class ServiceTestSuite {
    private static ExtentReports report;
    public static ExtentTest test;
    static String reportPath = new File("").getAbsolutePath().toString().trim()+"/Reports/index.html";

    static TestData testData;
    static MyConsumer myConsumer = new MyConsumer();
    static Logger logger = getLogger("service");
    @BeforeAll
    static void beforeAll() throws Exception {
        // extent report
        report = new ExtentReports(reportPath);//(reportPath);

        if (myConsumer.getApiStatus()!=200){
            fail("Api service didn't return 200");
        }
        testData = getTestDataInstance();
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

        int publisherTestNum = 1;
        PublisherTest publisherTest = testData.getPublisherTest(publisherTestNum);
        if (publisherTest == null)
            fail("couldn't get PublisherTest");
        Assertions.assertEquals(Integer.valueOf(myConsumer.getOutlierById(publisherTest.publisherId)), testData.getLargestNum(testData.getPublisherTest(publisherTestNum).readings));
        test.log(LogStatus.PASS, "get publisher readings OUTLIER", "number is valid");
    }
    @Test

    @DisplayName("get readings OUTLIER per invalid publisher id, verify return is null")
    public void getInvalidPublisherReadingsOutlier() throws Exception {
        int publisherTestNum = 0;
//        PublisherTest publisherTest = testData.getPublisherTest(1);
//        if (publisherTest == null)
//            fail("couldn't get PublisherTest");
            Assertions.assertTrue(myConsumer.getOutlierById("0") ==null);
        test.log(LogStatus.PASS, "get readings OUTLIER per invalid publisher id", "returned null");

    }
    @Test
    @DisplayName("get publisher readings OUTLIER accorging to last-n-readings, verify number is valid")
    public void getPuplisherReadingOutlier_last_n_readings() throws Exception {
        PublisherTest publisherTest = testData.getPublisherTest(1);
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

    @AfterAll
    static public void afterAll(){
//Closing the report
//        report.close();

    }
}
