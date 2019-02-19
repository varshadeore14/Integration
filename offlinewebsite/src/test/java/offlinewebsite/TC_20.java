package offlinewebsite;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TC_20 {
	


	
	
	  
				public static WebDriver driver;

				@BeforeSuite(groups = "Smoke")
				public static WebDriver setup_Browser() {
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
					// cookies delete
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					driver.get("file:///D:/Selenium%20Software/Offline%20Website/index.html");
					return driver;

				}

				@Test(priority = 1, groups = "Regression")
				public static void Verify_Url() {
					// Actual url
					String my_url = driver.getCurrentUrl();
					System.out.println("page title is " + my_url);

					// expected url
					String expected_url = "file:///D:/Selenium%20Software/Offline%20Website/index.html";
					Assert.assertEquals(my_url, expected_url);
					System.out.println("**************************");

					System.out.println("Test Case One with Thread Id:- "
							+ Thread.currentThread().getId());
				}
				@Test(priority = 2, groups = "Regression")
				public void verifyApplicationTitle() {
					// Actual title
					String my_title = driver.getTitle();
					System.out.println("page title is " + my_title);
					System.out.println("..................");

					// expected title
					String expected_title = "AdminLTE 2 | Log in";
					Assert.assertEquals(my_title, expected_title);
					System.out.println("************************");
					System.out.println("Test Case two with Thread Id:- "
							+ Thread.currentThread().getId());
				}

				@Test(priority = 3, groups = "Regression")
				public void verify_Title() {
					String stitle = driver.findElement(By.xpath("//a[@href='index2.html']")).getText();
					String exp = "AdminLTE";
					Assert.assertEquals(stitle, exp);
					System.out.println("Application title verify " + stitle);
					System.out.println("**********************");
				}

				// start Log In Session
				@Test(priority = 4, groups = "Regression")
				public void loginsesion() {
					driver.findElement(By.xpath("//p[contains(text(),'Sign in to start your session')]"));
					System.out.println("Sign in to start your session");
					System.out.println("***********************");

				}

				@Test(priority = 5, groups = "Regression")
				public void Check_PlaceHolder_Username() {
					String str = driver.findElement(By.xpath("//input[@id='email']")).getAttribute("placeholder");
					String exp = "Email";
					Assert.assertEquals(str, exp);
					System.out.println("placeholder Email-verified");
					System.out.println("*******************");
				}

				@Test(priority = 6, groups = "Regression")
				public void Check_PlaceHolder_Password() {
					String str = driver.findElement(By.xpath("//input[@id='password']")).getAttribute("placeholder");
					String exp = "Password";
					Assert.assertEquals(str, exp);
					System.out.println("placeholder password- verified");
					System.out.println("*******************");
				}

				@Test(priority = 7, groups = "Regression")
				public void check_Button_color() {
					WebElement signbtn = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
					System.out.println("befor mouse over button color is "+ signbtn.getCssValue("background-color"));
					Actions act = new Actions(driver);
					act.moveToElement(signbtn).build().perform();
					System.out.println("after mouse over button color "+ signbtn.getCssValue("color"));
					System.out.println("*******************");

				}

				@Test(priority = 8, groups = "Regression")
				public void check_Links() {
					List<WebElement> links = driver.findElements(By.tagName("a"));
					System.out.println(links.size());
					System.out.println("............");
					for (int i = 0; i < links.size(); i++) {
						System.out.println(links.get(i).getText());

					}
				}

				@Test(priority = 9, groups = "Regression")
				public void blank_username_password() {
					WebElement stract = driver.findElement(By.xpath("//input[@id='email']"));
					stract.sendKeys("");
					String strexp = "sa";
					Assert.assertNotEquals(stract, strexp);

					WebElement passact = driver.findElement(By.xpath("//input[@id='password']"));
					passact.sendKeys("");
					String passexp = "sa";
					driver.findElement(By.xpath("html/body/div[1]/div[2]/form/div[3]/div/button")).click();
					Assert.assertNotEquals(passact, passexp);
					String uname = driver.findElement(By.xpath("//div[@id='email_error']")).getText();
					System.out.println(uname);
					String password = driver.findElement(By.xpath("//div[@id='password_error']")).getText();
					System.out.println(password);
					System.out.println("....................................");

				}

				@Test(priority = 10, groups = "Regression")
				public void invalidusername_password() throws InterruptedException {

					WebElement stract = driver.findElement(By.xpath("html/body/div[1]/div[2]/form/div[1]/input"));
					stract.sendKeys("kiran12@gmail.com");
					String strexp = "kiran@gmail.com";
					Assert.assertNotEquals(stract, strexp);
					Thread.sleep(2000);
					stract.clear();
					WebElement passact = driver.findElement(By.xpath("html/body/div[1]/div[2]/form/div[2]/input"));
					passact.sendKeys("12345");
					Thread.sleep(2000);
					passact.clear();
					String passexp = "123456";
					Assert.assertNotEquals(passact, passexp);
					driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
					System.out.println("Please enter email as kiran@gmail.com");
					System.out.println("Please enter password 123456");
					System.out.println("....................................");

				}

				@Test(priority = 11, groups = "Resgression")
				public void validUsername_Password() throws InterruptedException {
					driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kiran@gmail.com");
					driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
					driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
					System.out.println("Online");
					System.out.println("..................................");
				}

				@Test(priority = 12, groups = "Smoke")
				public static void Verify_Url_DashBoard() {
					// Actual url
					String my_url = driver.getCurrentUrl();
					System.out.println("page title is " + my_url);

					// expected url
					String expected_url = "file:///D:/Selenium%20Software/Offline%20Website/pages/examples/dashboard.html";
					Assert.assertEquals(my_url, expected_url);

					System.out.println("**************************");
				}

				@Test(priority = 13, groups = "Smoke")
				public void verifyApplicationTitle_DashBoard() {
					// Actual title
					String my_title = driver.getTitle();
					System.out.println("page title is " + my_title);
					System.out.println("..................");

					// expected title
					String expected_title = "AdminLTE 2 | Dashboard";
					Assert.assertEquals(my_title, expected_title);

					System.out.println("************************");
				}

				@Test(priority = 14, groups = "Smoke")
				public void heading_Dashboard() throws InterruptedException {
					String stitle = driver.findElement(
							By.xpath("//h1[contains(text(),'Dashboard')]")).getText();
					String exp = "Dashboard Control panel";
					Assert.assertEquals(stitle, exp);
					System.out.println("Application title verify " + stitle);
					System.out.println("**********************");
					Thread.sleep(2000);
				}

				@Test(priority = 15, groups = "Unit")
				public void click_OnUser() throws InterruptedException {
					driver.findElement(By.xpath("//a[@href='users.html']")).click();
					Thread.sleep(2000);

					driver.findElement(By.xpath("//span[@class='label label-danger']"))
							.click();
					// click on 1St dlete button
					@SuppressWarnings("unused")
					Alert alt = driver.switchTo().alert();

					System.out.println(driver.switchTo().alert().getText());
					driver.switchTo().alert().accept();

					/*
					 * //2nd delete option
					 * driver.findElement(By.xpath("///span[@class='label label-danger ss']"
					 * )).click(); Alert alt1=driver.switchTo().alert();
					 * 
					 * System.out.println(driver.switchTo().alert().getText());
					 * Thread.sleep(1000); driver.switchTo().alert().accept();
					 * 
					 * 
					 * Alert alt2=driver.switchTo().alert(); Thread.sleep(1000);
					 * System.out.println(driver.switchTo().alert().getText());
					 * driver.switchTo().alert().accept();
					 */
				}

				@Test(priority = 16, groups = "Unit")
				public void getTableData() throws InterruptedException {
					WebElement Table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
					List<WebElement> tr = Table.findElements(By.tagName("tr"));
					System.out.println("total no of rows " + tr.size());
					for (WebElement row : tr) {
						List<WebElement> td = row.findElements(By.tagName("td"));
						for (WebElement col : td) {
							System.out.println(col.getText());
						}
						System.out.println("..........................");
					}
					Thread.sleep(2000);
				}

				@Test(priority = 17, groups = "Unit")
				public void Click_On_AddUser_Btn() throws InterruptedException {
					driver.findElement(
							By.xpath("//button[@class='btn btn-block btn-primary btn-sm pull-right']"))
							.click();
					Thread.sleep(2000);
				}

				@Test(priority = 18, groups = "Unit")
				public void Fill_Form() throws InterruptedException {
					WebElement uname = driver.findElement(By.xpath("//input[@id='username']"));
					uname.sendKeys("darshit");
					Thread.sleep(2000);
					WebElement mobile = driver.findElement(By.xpath("//input[@id='mobile']"));
					mobile.sendKeys("987654321");
					Thread.sleep(2000);
					WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
					email.sendKeys("darshit.rabadiya@gmail.com");
					Thread.sleep(2000);
					WebElement gender = driver.findElement(By.xpath("//input[@id='Male']"));
					gender.click();
					Thread.sleep(2000);

					 WebElement we = driver.findElement(By.xpath("html/body/div[1]/div[1]/section[2]/div/div/div/form/div[1]/div[5]/div/select"));
					Select s = new Select(we);
					s.selectByVisibleText("Maharashtra");
					WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
					password.sendKeys("dars");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//button[@id='submit']")).submit();
					Thread.sleep(2000);

					@SuppressWarnings("unused")
					Alert alt2 = driver.switchTo().alert();
					Thread.sleep(1000);
					System.out.println(driver.switchTo().alert().getText());
					driver.switchTo().alert().accept();
				}

				@Test(priority = 19, groups = "Unit")
				public void clickOn_OperatorBtn() throws InterruptedException {
					driver.findElement(By.xpath("//a[@href='operators.html']")).click();
					Thread.sleep(2000);
					// Get Operator table Data

					WebElement Table1 = driver.findElement(By.xpath("//div[@class='box-body table-responsive no-padding']"));
					List<WebElement> tr1 = Table1.findElements(By.tagName("tr"));
					System.out.println("total no of rows " + tr1.size());
					for (WebElement row1 : tr1) {
						List<WebElement> td1 = row1.findElements(By.tagName("td"));
						for (WebElement col1 : td1) {
							System.out.println(col1.getText());
						}
						System.out.println("..........................");
					}
					Thread.sleep(2000);
				}

				@Test(priority = 20, groups = "Unit")
				public void logOutBtn() {
					driver.findElement(By.xpath("//span[contains(text(),'Logout')]"))
							.click();
					System.out.println(driver.findElement(
							By.xpath("//p[contains(text(),'Logout successfully')]"))
							.getText());
				}

				@AfterSuite(groups = "Smoke")
				public void close_Browse() {
					driver.quit();
				}

			}



	  




