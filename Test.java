package Basic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	private WebDriver driver;
	public static void main(String[] args) throws AWTException, InterruptedException {
		Test obj = new Test();
		obj.setUpBrowser("chrome", "https://tinypng.com/");
		obj.uploadFileII();
		
	}
	public void setUpBrowser(String browser, String url) {
		String curDir = System.getProperty("user.home");

		if (browser.equals("chrome")) {
			System.out.println(curDir);
			System.setProperty("webdriver.chrome.driver", curDir + "//Documents//SeleniumWebDriverLearning//chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {

		} else if (browser.equals("edge")) {

		} else if (browser.equals("ie")) {

		} else {
			System.out.println("Valid browser is not provided");
			System.exit(0);
		}

		if (url != "") {
			driver.get(url);
		} else {
			driver.get("about:blank");
		}

		//Maximizes the browser window
		driver.manage().window().maximize();
	}
	public void uploadFileII() throws AWTException, InterruptedException {
		driver.findElement(By.xpath("html/body/header/section/section[1]/figure")).click();
		Robot robot = new Robot();
		File file = new File("/Users/huiningzhang/Documents/SeleniumWebDriverLearning/Info.PNG");
		StringSelection sel = new StringSelection(file.getAbsolutePath());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, sel);
		
		Thread.sleep(10000);
////		robot.delay(2000);
//		robot.keyPress(KeyEvent.VK_META);
//		robot.delay(2000);
//		robot.keyPress(KeyEvent.VK_SHIFT);
//		robot.delay(2000);
//		robot.keyPress(KeyEvent.VK_G);
//		robot.delay(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
	}
}
