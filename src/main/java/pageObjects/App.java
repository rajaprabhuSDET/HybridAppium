package pageObjects;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

/**
 * Hello world!
 *
 */
public class App {
  public static boolean checkIfServerIsRunnning(int port) {

    boolean isServerRunning = false;
    ServerSocket serverSocket;
    try {
      serverSocket = new ServerSocket(port);
      serverSocket.close();
    } catch (IOException e) {
      System.out.println(e);
      // If control comes here, then it means that the port is in use
      isServerRunning = true;
    } finally {
      serverSocket = null;
    }
    return isServerRunning;
  }

  public static void main(String[] args) {
    System.out.println("Hello World!");
    // Set the Desired Capabilities
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("deviceName", "My Phone");
    caps.setCapability("udid", "emulator-5554"); // Give Device ID of your mobile phone
    caps.setCapability("platformName", "Android");
    caps.setCapability("platformVersion", "8.0");
    caps.setCapability("appPackage", "com.android.calculator2");
    caps.setCapability("appActivity", "com.android.calculator2.Calculator");
    caps.setCapability("noReset", "true");

    checkIfServerIsRunnning(4723);
    AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

    try {
      service.start();
      service.enableDefaultSlf4jLoggingOfOutputData();
      AppiumDriver<MobileElement> driver =
          new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
      driver.findElement(By.id("com.android.calculator2:id/digit_7")).click();
      driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
      driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
      driver.findElement(By.id("com.android.calculator2:id/eq")).click();
      System.out.println(driver.findElement(By.id("com.android.calculator2:id/result")).getText());
      // driver.close();
      driver.closeApp();
      service.stop();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      service.stop();
    }
  }

}
