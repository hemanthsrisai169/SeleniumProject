package Akruthi.tulasi;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class strandloantest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://akruthistulasi.info/");
		driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")).click();
        String substring =  driver.findElement(By.xpath("//p[contains(text(),'Income: 186100.00')]")).getText();
        String[] Incomearray = substring.split(":");
        String Income = Incomearray[1].strip();
        String BalanceAmt = driver.findElement(By.cssSelector("div.container:nth-child(2) div.container div.row:nth-child(2) div.col-md-4 div.card.mb-4.text-center div.card-body p:nth-child(3) > span.cl_default")).getText();
        driver.findElement(By.cssSelector("div.container:nth-child(2) div.container div.row:nth-child(2) div.col-md-4 div.card.mb-4.text-center div.card-body > a.btn.btn-primary:nth-child(4)")).click();
		String CheckExpenses = driver.findElement(By.cssSelector("div.container:nth-child(2) div.container div.table-responsive:nth-child(3) table.table.table-bordered.table-hover:nth-child(48) tbody:nth-child(3) tr:nth-child(1) td:nth-child(2) > b:nth-child(1)")).getText().trim();
        String CheckIncome = driver.findElement(By.cssSelector("div.container:nth-child(2) div.container div.table-responsive:nth-child(3) table.table.table-bordered.table-hover:nth-child(48) tbody:nth-child(3) tr:nth-child(1) td:nth-child(3) > b:nth-child(1)")).getText().trim();
        String CheckBalance = getBalance(CheckIncome,CheckExpenses);
        
        //total expenses count from excel
      /*  List<WebElement> ListOfExpenses = driver.findElements(By.xpath("//tbody/tr/td[4]"));
        String TotalExpenses;
        int TotalExpensesCount = 0;
        for(int i=0;i<ListOfExpenses.size();i++) {
        	TotalExpenses = ListOfExpenses.get(i).getText().trim();
        	if (!TotalExpenses.isEmpty()) {
        		double money = Double.parseDouble(TotalExpenses);
                int TotalExpensesI = (int)money; 
                TotalExpensesCount = TotalExpensesCount+TotalExpensesI;
        	}
        	
            
        }
        System.out.println(TotalExpensesCount);*/
        
        //total Income count
       /* List<WebElement> ListOfIncome = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        String TotalIncome;
        double TotalIncomeCount = 0;
        for(int i=0;i<ListOfIncome.size();i++) {
        	TotalIncome = ListOfIncome.get(i).getText().trim();
        	if (!TotalIncome.isEmpty()) {
        		double money = Double.parseDouble(TotalIncome);
               
                TotalIncomeCount = TotalIncomeCount+money;
        	}
        	
            
        }
        System.out.println(TotalIncomeCount);*/
        
        //image related
       /* List<WebElement> viewImageButtons = driver.findElements(By.className(".btn-info")); 
        for (int i = 0; i < viewImageButtons.size(); i++) {
        	
        
            WebElement button = viewImageButtons.get(i);
            button.click();

            WebElement imageModal = driver.findElement(By.className(".modal-content"));
            WebElement image = imageModal.findElement(By.tagName("img"));

            Assert.assertTrue(image.isDisplayed(), "Image is not displayed for button index: " + i);

            WebElement closeButton = imageModal.findElement(By.className(".btn-close")); // Update selector for close button
            closeButton.click();
        }*/
		
		
		driver.quit();
		

	}
	public static String getBalance(String CheckIncome,String CheckExpenses) {
		double IncomeAmt = Double.parseDouble(CheckIncome);
	    double ExpensesAmt = Double.parseDouble(CheckExpenses);
		double CheckBalanceAmt = IncomeAmt-ExpensesAmt;
		
		int CheckBalanceA = (int)CheckBalanceAmt;
		
		String Balance = Integer.toString(CheckBalanceA); 
		return Balance;
	} 

}
