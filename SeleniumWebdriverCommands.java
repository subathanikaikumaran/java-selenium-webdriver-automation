import static org.testng.Assert.assertEquals;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author suba
 *
 */
public class SeleniumWebdriverCommands{
   
    public static void refresh(WebDriver driver){
		driver.navigate().refresh();
    }

    public static void pause() throws InterruptedException{
		Thread.sleep(1000);
    }
    

    public static void navigateTo(WebDriver driver,String url){
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        System.out.println("Browser launched");	
        	
		driver.get(url);
	    System.out.println("Navigated to "+url ); 
    }
    

    public static void getBrowserTitle(WebDriver driver){
	    String title= driver.getTitle(); 	   	    
	    System.out.println("Title : "+title);
    }
    


    /*
	 * Click
	 */
    public static void click(WebDriver driver,WebElement lelement,String elementName ) throws InterruptedException{
		JavascriptExecutor executor = (JavascriptExecutor) driver;			
		executor.executeScript("arguments[0].click();", lelement);
		System.out.println("Click on "+elementName);
    }
    

    /*
	 * type
	 */
	public static void type(WebDriver driver,WebElement lelement,String typeValue,String elementName){
		JavascriptExecutor executor = (JavascriptExecutor) driver;			
		executor.executeScript("arguments[0].click();", lelement);
		lelement.clear();
		lelement.sendKeys(typeValue);
		System.out.println("Type the "+elementName+" : "+typeValue);
	}
	
	public static void typeKeys(WebDriver driver,WebElement lelement,Keys typeValue,String elementName){
		JavascriptExecutor executor = (JavascriptExecutor) driver;			
		executor.executeScript("arguments[0].click();", lelement);
		lelement.clear();
		lelement.sendKeys(typeValue);
		System.out.println("Type the "+elementName+" : "+typeValue+"(key)");
    }
    




    /*
	 * popup window
	 */
	public static void winPopUpAccept(WebDriver driver) throws InterruptedException{
		try { 
		    Alert alert = driver.switchTo().alert();
		    System.out.println("Alert box is visible");
		    alert.accept();
		    System.out.println("Click on accept");		    
		}
		catch (NoAlertPresentException e) {
			System.out.println("Couldn't find any alert box ");
		}
		Thread.sleep(500);
	}
	
		
	
	public static void winPopUpDismiss(WebDriver driver) throws InterruptedException{
		try { 
		    Alert alert = driver.switchTo().alert();
		    System.out.println("Alert box is visible");
		    alert.dismiss();
		    System.out.println("Click on dismiss");		    
		}
		catch (NoAlertPresentException e){
			System.out.println("Couldn't find any alert box ");
		}
		Thread.sleep(500);
    }
    

    /*
	 * select
	 */	
	public static void select(WebElement lelement,String selValue,String elementName) throws InterruptedException{
		WebElement mySelect =lelement;					
		Select mySelectd= new Select(mySelect);			
		mySelectd .selectByValue(selValue);
		Thread.sleep(100);
		System.out.println("Select on "+elementName+" : "+selValue);
	 }
	
	
	public static void selectByVisible(WebElement lelement,String selValue,String elementName) throws InterruptedException{
		WebElement mySelect =lelement;					
		Select mySelectd= new Select(mySelect);			
		mySelectd .selectByVisibleText(selValue);
		Thread.sleep(100);
		System.out.println("Select on "+elementName+" : "+selValue);
	 }
	
	
	
	public static void selectByIndex(WebElement lelement,int selValue,String elementName) throws InterruptedException{
		 WebElement mySelectEl =lelement;				
		 Select mySelect= new Select(mySelectEl);
	     mySelect.selectByIndex(selValue);
	     
		 WebElement option = mySelect.getFirstSelectedOption();
		 Thread.sleep(100);
		 System.out.println("Selected "+elementName+" :  "+option.getText());
		 
	 }


    /*
	 * check dropdown elements
	 */
	
	public static void  checkDropdownElement(WebDriver driver,WebElement lelement,String SelectValue,String dropdownName){
		 WebElement mySelectElm = lelement;				
		 Select mySelect= new Select(mySelectElm);
		 
		 mySelect.selectByVisibleText(SelectValue);
		 System.out.println("Select "+dropdownName+" option :  "+SelectValue);
		 
		 WebElement option = mySelect.getFirstSelectedOption();		
		 if (option.getText().equals(SelectValue)) {
			System.out.println( "Value found in Dropdown to Select : "+option.getText());
		 }
		 else {
            System.out.println("Value not found in Dropdown to Select");
		 }			
	}
	
	
	
	
	
	public static void  checkDropdownAllOption(WebDriver driver,WebElement lelement,String dropdownName)
	{
		Select oSelect = new Select(lelement);
		java.util.List <WebElement> elementCount = oSelect.getOptions();
		int iSize = elementCount.size();
		String [] arrbtn= new String [iSize]; 			
		for (int j = 0; j < iSize; j++)	{
			arrbtn[j]=elementCount.get(j).getText();
		}
		System.out.println("All options from "+dropdownName+" dropdown list :  "+Arrays.toString(arrbtn));
		WebElement mySelectElm = lelement;				
	    Select mySelect= new Select(mySelectElm);
		int countx=0;
		for (int i = 0; i < arrbtn.length; i++) 
		{
			mySelect.selectByVisibleText(arrbtn[i]);
			System.out.println( "Selected option :  "+arrbtn[i]);
			WebElement option = mySelect.getFirstSelectedOption();
			if (option.getText().equals(arrbtn[i])){
                System.out.println("Value found from Dropdown list : "+option.getText());
				 countx++;
			} else{
                System.out.println("Value couldn't find from Dropdown list : "+option.getText());
            }	
		}
		if (iSize == countx){
			System.out.println("successfully verified the "+dropdownName+" drop down list");
		} else {
            System.out.println("Failed to verify "+dropdownName+" drop down list");
		}				
    }
    


    public static void  getDropdownAllOption(WebDriver driver,WebElement lelement,String dropdownName){
		Select oSelect = new Select(lelement);
		java.util.List <WebElement> elementCount = oSelect.getOptions();
		int iSize = elementCount.size();
		String [] arrbtn= new String [iSize]; 			
		for (int j = 0; j < iSize; j++) {
			arrbtn[j]=elementCount.get(j).getText();
		}
		System.out.println("All options from "+dropdownName+" dropdown list :  "+Arrays.toString(arrbtn));
	}
	
	public static void checkDropdownOption(WebDriver driver,WebElement lelement,String selEleName) throws InterruptedException {
		WebElement mySelectEl =lelement;				
		Select mySelect= new Select(mySelectEl);
	    mySelect.selectByIndex(1);
		WebElement option = mySelect.getFirstSelectedOption();
		Thread.sleep(100);
		System.out.println("Selected "+selEleName+" :  "+option.getText());
		
		if (!option.getText().equals(null)) {
            System.out.println("Value found from Dropdown list : "+option.getText());
		 } else {
            System.out.println("Value couldn't find from Dropdown list : "+option.getText());
		}		
	 }


}