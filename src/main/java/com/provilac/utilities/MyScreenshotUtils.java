package com.provilac.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.provilac.base.BaseClass;


public class MyScreenshotUtils extends BaseClass{

	public static String getScreenshot(String testName) {

		String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
		String screenshotName = testName + "_" + timestamp;

		String path = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File desFile = new File(path);

		try {
			FileUtils.copyFile(srcFile, desFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
}
