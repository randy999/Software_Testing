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
	//����csv�ļ�������
	List<String> list=CSVUtils.importCsv(new File("D:\\eclipse_workplace\\inputgit.csv"));   
	//����ɹ�����
	if(list!=null && !list.isEmpty()){
     	int a = 0;
     	///��ÿһ��csv�е����ݣ���ѧ�ţ�������github��ַ ��substring��ȡ
         for(String data : list){
        	 a++;
         	if(a == 1)
         		continue;
             int fir = 11;//ѧ�Ź̶�10�����֡�0-9�������ӵ�fir(11)λ��ʼ
             int en = 12;//������en֮ǰ��β
             
             //�ҵ����������ĺ�һλen
             while(en<data.length()){
             	if(data.charAt(en) == ','){
 	                break;
             	}	               
             	en++;
             }
             driver.get(baseUrl + "/"); //����ҳ
             driver.findElement(By.id("name")).clear();
             driver.findElement(By.id("name")).sendKeys(data.substring(0,10));//����ѧ��
             driver.findElement(By.id("pwd")).clear();
             driver.findElement(By.id("pwd")).sendKeys(data.substring(4,10));//��������
             driver.findElement(By.id("submit")).click();//����
             String github = driver.findElement(By.xpath("//tr[3]/td[2]")).getText();//��ȡgithubURL��Ϣ������giuthub
             String name = driver.findElement(By.xpath("//tr[1]/td[2]")).getText();//��ȡ������name
             //�Ƚ���ҳ�кͱ��е�������Ϣ
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
 
