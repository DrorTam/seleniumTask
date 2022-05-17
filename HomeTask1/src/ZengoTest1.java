import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class ZengoTest1 {
	
	
	ChromeDriver driver;
	
	
	
	// launch the site and wait 30 seconds for verifying that site displayed successfully

	public void launchBrowser() throws InterruptedException { 
		
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://zengo.com/");
		driver.manage().window().maximize(); // maximizing the web page
		Thread.sleep(20000);
		
		Actions act = new Actions(driver);
		
        act.sendKeys(Keys.PAGE_DOWN).build().perform(); //Page Down
        Thread.sleep(5000);
     
        act.sendKeys(Keys.PAGE_UP).build().perform();   //Page Up
        Thread.sleep(5000);
		
	}
	
	
	
	// press the FreeBitcoin link text , display a message which verifying the current URL and then press the button and 
	// verifying the pop up message with a QR code
	
	public void searchProduct() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Free Bitcoin")).click();
		System.out.println("The current URL is equal to https://zengo.com/free-bitcoin/ : "
							+ driver.getCurrentUrl().equals("https://zengo.com/free-bitcoin/")); 
		Thread.sleep(5000);
		driver.findElement(By.linkText("Download ZenGo")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("lity-close")).click();
		Thread.sleep(5000);

		
		
	}
	
	
	
	// get back to home page and then close the browser
	
	public void backAndCloseBrowser() throws InterruptedException {
		
		driver.navigate().back();
		Thread.sleep(5000);
		driver.quit();
	}
	
	

	// main method
	
	public static void main(String[] args) throws InterruptedException {

		ZengoTest1 obj = new ZengoTest1();
		obj.launchBrowser();
		obj.searchProduct();
		obj.backAndCloseBrowser();
	} 


}