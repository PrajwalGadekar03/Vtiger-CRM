package CommonUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentation implements ITestListener {

	public ExtentReports reports;
	public ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestStart(result);
		String methodname = result.getMethod().getMethodName();
		Reporter.log("TestScript execution is started", true);
		test = reports.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSuccess(result);
		String methodname = result.getMethod().getMethodName();
//		Reporter.log(methodname+"TestScript is passed",true);
		test.log(Status.PASS, methodname + "TestScript is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailure(result);
		String msg = result.getThrowable().toString();
		String methodname = result.getMethod().getMethodName();
//		Reporter.log(methodname+"TestScript is failed"+msg,true);
		test.log(Status.FAIL, methodname + "TestScript is failed");
		String screenshotname = methodname;
		test.log(Status.FAIL, result.getThrowable());
		WebDriverUtil wutil = new WebDriverUtil();
		try {
			String path = wutil.ScreenShot(BaseClass.op, screenshotname);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSkipped(result);
		String methodname = result.getMethod().getMethodName();
//		Reporter.log(methodname+"TestScript is skipped",true);
		test.log(Status.SKIP, methodname + "TestScript is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onStart(context);
		JavaUtil jutil = new JavaUtil();
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./EctentReport/Report.html"+ jutil.getRandomNumber());
		htmlreport.config().setDocumentTitle("VTigetCRM Framework");
		htmlreport.config().setReportName("VTigerCRM Contact");
		htmlreport.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(htmlreport);
		reports.setSystemInfo("Operating System", "Windows");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Chrome Version", "120.060");
		reports.setSystemInfo("Programming Language", "JAVA");
		reports.setSystemInfo("Author", "Prajwal");

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onFinish(context);
		reports.flush();
	}

}
