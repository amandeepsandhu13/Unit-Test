import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
Program Name: TFDLAB80821471.java
	  Author: Aman Sandhu
        Date: Mar 14, 20188:46:19 AM
 Description:
 */
public class TFDLAB80821471
{
	public static void main(String[] args)
	{
			
  	//Load the Chrome webdriver using Java properties
  	System.setProperty("webdriver.chrome.driver", "E:/SST-2/6067/Week 8/Selenium/chromedriver_win32/chromedriver.exe");
  	// declaration and instantiation of objects/variables
      WebDriver driver = new ChromeDriver();
      String baseUrl = "http://newtours.demoaut.com";
      String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = "";
      

      // launch Chrome and direct it to the Base URL
      driver.get(baseUrl);

      // get the actual value of the title
      actualTitle = driver.getTitle();
      driver.findElement(By.linkText("REGISTER")).click();
      
      WebElement textbox = driver.findElement(By.name("firstName"));
      textbox.sendKeys("Amandeep");
      textbox = driver.findElement(By.name("lastName"));
      textbox.sendKeys("Sandhu");
      textbox = driver.findElement(By.name("phone"));
      textbox.sendKeys("1-222-333-4444");
      textbox = driver.findElement(By.name("userName"));
      textbox.sendKeys("Amandeep Sandhu");
      textbox = driver.findElement(By.name("address1"));
      textbox.sendKeys("London");
      textbox = driver.findElement(By.name("address2"));
      textbox.sendKeys("Ontario");
      textbox = driver.findElement(By.name("city"));
      textbox.sendKeys("Toronto");
      textbox = driver.findElement(By.name("state"));
      textbox.sendKeys("ON");
      textbox = driver.findElement(By.name("postalCode"));
      textbox.sendKeys("N5YHHH");
      textbox = driver.findElement(By.name("country"));
      textbox.sendKeys("canada");
      textbox = driver.findElement(By.name("email"));
      textbox.sendKeys("a_sandhu35@fanshaweonline.ca");       
      textbox = driver.findElement(By.name("password"));
      textbox.sendKeys("1234567");      
      textbox = driver.findElement(By.name("confirmPassword"));
      textbox.sendKeys("1234567");
      
      driver.findElement(By.name("register")).click(); 
      
      //grab content from Thank you page
      String actualTyResult = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b")).getText();
      String expectedTyResult = "Dear Amandeep Sandhu,";
      
      //System.out.println(actualTyResult);      
      
      if (actualTyResult.contentEquals(expectedTyResult)){
        System.out.println("Test Passed!");
    } else {
        System.out.println("Test Failed");
    }
   
      //select Flights link
      driver.findElement(By.linkText("Flights")).click();
      
      //Fill out form
      driver.findElement(By.cssSelector("input[type='radio'][value='roundtrip']")).click();

      WebElement passengers = driver.findElement(By.name("passCount"));
      Select selectPassengers= new Select (passengers);
      selectPassengers.selectByIndex(1);
      
      WebElement DepartFrom = driver.findElement(By.name("fromPort"));
      Select selectPort= new Select (DepartFrom);
      selectPort.selectByIndex(2);
     
      WebElement selectMonth = driver.findElement(By.name("fromMonth"));
      Select selectOnMonth= new Select (selectMonth);
      selectOnMonth.selectByIndex(5);
      
      WebElement selectDate = driver.findElement(By.name("fromDay"));
      Select selectDay= new Select (selectDate);
      selectDay.selectByValue("11");
      
      WebElement arrivalIn = driver.findElement(By.name("toPort"));
      Select selectArrivalPort= new Select (arrivalIn);
      selectArrivalPort.selectByIndex(4);
      
      WebElement arrivalMonth = driver.findElement(By.name("toMonth"));
      Select selectToMonth= new Select (arrivalMonth);
      selectToMonth.selectByIndex(7);
     
      
      WebElement arrivalDate = driver.findElement(By.name("toDay"));
      Select selectToDay= new Select (arrivalDate);
      selectToDay.selectByIndex(0);
      
      driver.findElement(By.cssSelector("input[type='radio'][value='First']")).click();
      
      WebElement airline = driver.findElement(By.name("airline"));
      Select selectAirline= new Select (airline);
      selectAirline.selectByIndex(2);
      
      driver.findElement(By.name("findFlights")).click();
      driver.findElement(By.cssSelector("input[type='radio'][value='Blue Skies Airlines$361$271$7:10']")).click();
      driver.findElement(By.cssSelector("input[type='radio'][value='Unified Airlines$633$303$18:44']")).click();
      driver.findElement(By.name("reserveFlights")).click();
      driver.findElement(By.name("buyFlights")).click();
      
      String getFlightRes = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[1]/td/table/tbody/tr/td[1]/b/font/font/b/font[1]")).getText();
      
      System.out.println(getFlightRes);
            
      String confirmedFlight = (driver.getTitle());
      
       //WebElement confirmedFlight1 = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[3]/td/font/text()[1]"));
     
         
      String expectedConfirmedFLight = "Flight Confirmation: Mercury Tours";      
                 
      if (confirmedFlight.contentEquals(expectedConfirmedFLight))
      {
      	System.out.println("Test Passed!");
      }
      else 
      {
          System.out.println("Test failed!");
      }
      
      
      
      
      try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

     
   
      
      //close Chrome
    driver.close();
     
      // exit the program explicitly
      System.exit(0);
  
		
	}

}
