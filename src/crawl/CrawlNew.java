/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crawl;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *
 * @author Admin
 */
public class CrawlNew {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "D:\\DriveChrome\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://qldt.ptit.edu.vn/#/home");
        List<WebElement> elements = driver.findElements(By.cssSelector("input"));
        elements.get(0).sendKeys(""); // Tai khoan 
                elements.get(1).sendKeys(""); //Mat Khau
        WebElement button = driver.findElement(By.cssSelector("button[class=\"btn btn-primary mb-1 ng-star-inserted\"]"));
        button.click();
        //driver.close();
        WebElement hocPhi = driver.findElement(By.cssSelector("a[title=\"Xem học phí\"]"));
        hocPhi.click();
        List<WebElement> x = driver.findElements(By.cssSelector("tr[class=\"text-right align-middle ng-star-inserted\"]"));
        FileWriter file = new FileWriter("HocPhi.json");
        String s1 = "";
        for(int i=0 ; i < x.size() ; i++){
            //System.out.println(i.getText());
            String s = x.get(i).getText();
            HocPhi hp = new HocPhi(s);
            //System.out.println(hp.getID() + " " + hp.getName()+ " " + Arrays.toString(hp.getGiaTri()) );
            Gson gs = new Gson();
            String json = gs.toJson(hp);
            s1 += json + "\n"; 
            if(json.isBlank()){
                System.out.println("1");
            }   
            //s1 += json + "\n"; 
            //System.out.println("Json: " + json);
        }
        System.out.println(s1);
        file.write(s1);
        file.flush();
    }
}
