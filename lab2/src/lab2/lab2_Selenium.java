package lab2;

import java.util.regex.Pattern;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.Selenium;

public class lab2_Selenium {
  private Selenium selenium;
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://121.193.130.195:8080";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLab2Selenium() throws Exception {
	//导入csv文件的内容
	List<String> list=CSVUtils.importCsv(new File("D:\\eclipse_workplace\\inputgit.csv"));   
	//如果成功导入
	if(list!=null && !list.isEmpty()){
     	int a = 0;
     	///对每一组csv中的数据，将学号，姓名，github地址 用substring获取
         for(String data : list){
        	 a++;
         	if(a == 1)
         		continue;
             int fir = 11;//学号固定10个数字【0-9】姓名从第fir(11)位开始
             int en = 12;//姓名到en之前结尾
             
             //找到姓名结束的后一位en
             while(en<data.length()){
             	if(data.charAt(en) == ','){
 	                break;
             	}	               
             	en++;
             }
             driver.get(baseUrl + "/"); //打开网页
             driver.findElement(By.id("name")).clear();
             driver.findElement(By.id("name")).sendKeys(data.substring(0,10));//输入学号
             driver.findElement(By.id("pwd")).clear();
             driver.findElement(By.id("pwd")).sendKeys(data.substring(4,10));//出入密码
             driver.findElement(By.id("submit")).click();//进入
             String github = driver.findElement(By.xpath("//tr[3]/td[2]")).getText();//获取githubURL信息到变量giuthub
             String name = driver.findElement(By.xpath("//tr[1]/td[2]")).getText();//获取姓名到name
             //比较网页中和表中的数据信息
             assertEquals(data.substring(fir,en),name);
             assertEquals(data.substring(en+1),github); 
         }
     }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
 
