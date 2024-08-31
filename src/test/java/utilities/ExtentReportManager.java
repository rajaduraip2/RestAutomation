package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;


/*
 * ItestListener used to get the status after Execution status.
 */

public class ExtentReportManager implements ITestListener {
    /*
     * ExtentSparkReporter used to handle all UI elements of the report.
     * ExtentReports used to handle the Environment details and OS, user Information.
     * ExtentTest used to handle the Test case level reporting
     */
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String reportName;

    public void onStart(ITestContext testContext)
    {
        String timeStamp= new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
        reportName="API-Test-Report-"+timeStamp+".html";
        //Set the location to generate report
        sparkReporter=new ExtentSparkReporter(".\\reports\\"+reportName);
        sparkReporter.config().setDocumentTitle("RestAutomationProject");
        sparkReporter.config().setReportName("Users API");
        sparkReporter.config().setTheme(Theme.DARK);

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application","Store User API");
        extent.setSystemInfo("OS",System.getProperty("os.name"));
        extent.setSystemInfo("User Name",System.getProperty("user.name"));
        extent.setSystemInfo("Enviornment","QA");
        extent.setSystemInfo("User","Test Engineer");

    }

    public void onTestSuccess(ITestResult testResult){
        //Create Test Logging the name of the test in to Report
        test= extent.createTest(testResult.getName());
        //Assigns categories to the test based on the groups specified in the TestNG method annotations.
        // This helps in organizing and filtering tests in the report.
        test.assignCategory(testResult.getMethod().getGroups());
        //Creates a new node under the test with the same name.
        // This is useful for structuring the test report, allowing you to add more details
        test.createNode(testResult.getName());
        test.log(Status.PASS,"Test Passed");
    }
    public void onTestFailure(ITestResult testResult){
        test= extent.createTest(testResult.getName());
        test.assignCategory(testResult.getMethod().getGroups());
        test.createNode(testResult.getName());
        test.log(Status.FAIL,"Test Failed");
    }
    public void onTestSkipped(ITestResult testResult){
        test= extent.createTest(testResult.getName());
        test.assignCategory(testResult.getMethod().getGroups());
        test.createNode(testResult.getName());
        test.log(Status.FAIL,"Test Failed");
    }

    @Override
        public void onFinish(ITestContext context) {
        //The extent.flush() method is called at the end of the test execution to ensure that all
        // test logs, details, and results are written out to the report.
        // This method finalizes the report generation process by:
        //1.Writing all accumulated logs and results to the report.
        //2.Closing any resources or streams associated with the report generation.
        //3.Ensuring that the report is properly saved and accessible.
            extent.flush();
        }
}
