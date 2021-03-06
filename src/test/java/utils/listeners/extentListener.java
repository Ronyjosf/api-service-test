//package utils.listeners;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
////import baseFunctions;
//public class extentListener implements ITestListener {
//    public static String testName;
//    ExtentHtmlReporter htmlReporter;
//    ExtentReports extent;
//    public static ExtentTest test;
//
//    @Override
//    public void onStart(ITestContext context) {
//        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/TestResultsReport.html");
////        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
////        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
////        htmlReporter.config().setChartVisibilityOnOpen(true);
//        htmlReporter.config().setTheme(Theme.STANDARD);
//        htmlReporter.config().setDocumentTitle("XYZ.com");
//        htmlReporter.config().setEncoding("utf-10");
//        htmlReporter.config().setReportName("create-service test report");
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
////        return extent;
//
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        extent.flush();
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        test = extent.createTest(result.getName());
//        testName = result.getName();
//        test.log(Status.INFO, result.getName() + " Test has Started");
//        System.out.println("*******TEST STARTED ******");
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        test.log(Status.PASS, result.getName() + " Test Passed Successfully");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        test.log(Status.FAIL, result.getName() + " Test is failed" +        result.getThrowable());
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        test.log(Status.SKIP, result.getName() + " Test is Skipped" +  result.getThrowable());
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//    }
//}
