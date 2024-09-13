package Akruthi.tulasi;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://akruthistulasi.info/subcategory/1/");
		//driver.findElement(By.xpath("//tbody/tr[1]/td[7]/button")).click();
	        // Find all "View Image" buttons
	    List<WebElement> viewImageButtons = driver.findElements(By.xpath("//tbody/tr/td[7]/button")); 
	    for (int i = 0; i < viewImageButtons.size(); i++) {
	            WebElement button = viewImageButtons.get(i);

	            // Click the button
	            button.click();
	            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal"))); // Update selector for modal
	            WebElement image = modal.findElement(By.tagName("img"));

	           // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	           // WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]")));
	            modal.findElement(By.className("btn-close")).click();
	            wait.until(ExpectedConditions.invisibilityOf(modal));
	            // Wait for the modal to appear and locate the image
	        //    WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-image"))); // Update selector for modal
	       //     WebElement image = modal.findElement(By.tagName("img"));

	            // Verify if the image is displayed
	       //     Assert.assertTrue(image.isDisplayed(), "Image is not displayed for button index: " + i);

	            // Close the modal
	         //   WebElement closeButton = modal.findElement(By.cssSelector(".close-button")); // Update selector for close button
	        //    closeButton.click();
	        }
		
		
		/*Set<String> handel = driver.getWindowHandles();
		Iterator<String> it = handel.iterator();
		String ParentId = it.next();
		String ChildId = it.next();
		driver.switchTo().window(ChildId);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")).click();*/
		
		
		/*List<WebElement> viewImageButtons = driver.findElements(By.className(".btn-info")); 
        for (int i = 0; i < viewImageButtons.size(); i++) {

            
            WebElement button = viewImageButtons.get(i);
            button.click();
        }
        	
		driver.findElement(By.className(".btn-close")).click();*/
    }
}