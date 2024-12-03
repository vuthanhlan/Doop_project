import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class sign_up {
    ChromeDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void run(){
        //Bước 1: mở trình duyệt trang đăng nhập
        driver.get("https://doop-staging-crm.acdtech.asia/auth/sign-in/");
        sleep(10000);

        //Bước 2: tìm button đăng ký--> click
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div[4]/p[2]")).click();
        sleep(10000);

        //Bước 3: Tìm text sdt--> nhập sdt
        driver.findElement(By.name("phone")).sendKeys("0325789451");
        sleep(5000);

        //Bước 4: Tìm butotn tích chọn--> tích chọn
        WebElement element=driver.findElement(By.className("ant-checkbox-input"));
        setCheckBoxState(element,true);
        sleep(2000);

        //Bước 5: tìm button đăng ký--> click button Đăng Ký
         driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div[3]/div/button")).click();
        sleep(10000);

        driver.findElement(By.tagName("input")).sendKeys("000000");
        sleep(5000);

        driver.findElement(By.name("name")).sendKeys("Vũ Thanh Lan");
        sleep(2000);

        driver.findElement(By.name("password")).sendKeys("12345678");
        sleep(2000);
        driver.findElement(By.name("confirmPassword")).sendKeys("12345678");
        sleep(2000);
        driver.findElement(By.name("email")).sendKeys("qrrrrq@gmail.com");
        sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement comboBox = driver.findElement(By.cssSelector("div.ant-select-selector"));
        comboBox.click();

        // Chờ danh sách hiển thị
        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ant-select-dropdown"))
        );

        // Lấy danh sách tùy chọn và chọn "Nam"
        List<WebElement> options = dropdown.findElements(By.cssSelector(".ant-select-item-option"));
        for (WebElement option : options) {
            if (option.getText().equals("Nam")) {
                option.click();
                break;
            }
        }
        sleep(5000);

        driver.findElement(By.name("address")).sendKeys("Thái Bình");
        sleep(2000);

        WebElement uploadElement = driver.findElement(By.cssSelector("input[type='file']"));

        // Gửi đường dẫn file cần tải lên
        uploadElement.sendKeys("C:\\Users\\Vu Thanh Lan\\Downloads\\Mephar\\images8.jpg");

        sleep(2000);

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]")).click();
        sleep(2000);

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).click();
        sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]")).click();
        sleep(2000);

        String expectUrl="https://doop-staging-crm.acdtech.asia/auth/sign-in/";
//        Assert.assertEquals("Đăng ký không thành công! URL không khớp.", expectUrl, driver.getCurrentUrl());
//        System.out.println("Đăng ký thành công!");
        System.out.println(driver.getCurrentUrl());

    }


    public void setCheckBoxState(WebElement element, boolean isChecked){
        boolean isActualChecked=element.isSelected();
        if(isChecked!=isActualChecked){
            element.click();
        }
    }

    @AfterMethod
    public void Cleanup(){

    }

    private void sleep(int time){
        try{
            Thread.sleep(time);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
