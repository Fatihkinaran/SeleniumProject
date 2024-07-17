package SeleniumTestProject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



public class SeleniumTestProject {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\project\\chromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https:\\www.amazon.com.tr");
        driver.findElement(By.id("sp-cc-accept")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("field-keywords")).sendKeys("bilgisayar" , Keys.ENTER);
        String aramasonucuText =
                driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]/span[1]")).getText() +
                driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]/span[3]")).getText();
        System.out.println("bilgisayar araması sonucu " + aramasonucuText);
        if (aramasonucuText.contains("bilgisayar")) {
            System.out.println("BİLGİSAYAR SONUCU İÇERİYOR TEST BAŞARILI");
        } else {
            System.out.println("Arama sonucu içermiyor");
        }
        String ilk_urun_fiyati = driver.findElement(By.xpath("(//span[@class=\"a-price-whole\"])[1]")).getText();
        if (ilk_urun_fiyati.contains("13.999")) {
            System.out.println("ÜRÜN FİYATI DOĞRU TEST BAŞARILI");
        } else {
            System.out.println("Ürün Fiyatı Yanlış Test Başarısız");
        }
        System.out.println("ilk ürün fiyatı  " + driver.findElement(By.xpath("(//span[@class=\"a-price-whole\"])[1]")).getText());
        Thread.sleep(2000);
        WebElement firstpicture = driver.findElement(By.xpath("(//img[@class=\"s-image\"])[4]"));
        firstpicture.click();
        driver.findElement(By.id("add-to-cart-button")).click();
        String sepet = driver.findElement(By.xpath("(//h1[@class=\"a-size-medium-plus a-color-base sw-atc-text a-text-bold\"])")).getText();
        if (sepet.contains("Sepete Eklendi")) {
            System.out.println("SEPETE EKLENDİ TEST BAŞARILI");}
        else {System.out.println("SEPETE EKLENMEDİ TEST BAŞARISIZ");}
        driver.findElement(By.name("proceedToRetailCheckout")).click();
        driver.findElement(By.xpath("(//input[@class=\"a-input-text a-span12 auth-autofocus auth-required-field auth-require-claim-validation\"])")).sendKeys("deneme@gmail.com" , Keys.ENTER);
        driver.findElement(By.id("ap_password")).sendKeys("deneme123" , Keys.ENTER);
        String oturum = driver.findElement(By.xpath("//span[@class=\"a-list-item\"]")).getText();
        if (oturum.contains("Şifreniz yanlış")) {
            System.out.println("OTURUM DOĞRULANMADI TEST BAŞARILI");
        } else System.out.println("OTURUM DOĞRULANDI TEST BAŞARISIZ");
    }
}
