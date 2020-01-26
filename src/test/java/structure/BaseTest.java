package structure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;

import java.io.File;

import static org.slf4j.LoggerFactory.getLogger;
import static structure.TestData.getTestDataInstance;

public abstract class BaseTest {
    protected static ExtentReports report;
    protected static ExtentTest test;
    static protected String reportPath = new File("").getAbsolutePath().toString().trim()+"/Reports/index.html";

    protected static Logger logger = getLogger("service");

    static protected TestData testData;

    @BeforeAll
    static public void beforeBaseTest() throws JsonProcessingException {
        // extent report
        report = new ExtentReports(reportPath);//(reportPath);

        testData = getTestDataInstance();

    }

    @AfterAll
    static public void afterAll(){
//Closing the report
//        report.close();

    }
}
