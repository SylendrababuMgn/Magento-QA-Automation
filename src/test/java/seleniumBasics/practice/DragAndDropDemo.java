package seleniumBasics.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {
    public static void main(String[] args) throws InterruptedException {
        // Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");

        // Switch to frame if the draggable/droppable is inside an iframe
        driver.switchTo().frame(0);

        // Locate elements
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        // Perform drag and drop
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
        Thread.sleep(1000);
        // Optional: Validation
        
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshot.png");

        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String droppedText = target.getText();
        if (droppedText.equals("Dropped!")) {
            System.out.println("Drag and drop successful!");
        } else {
            System.out.println("Drag and drop failed.");
        }

        // Cleanup
        driver.quit();
    }
}
