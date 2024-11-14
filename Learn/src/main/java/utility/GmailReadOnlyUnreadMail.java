package utility;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TestBase.Testbase;

public class GmailReadOnlyUnreadMail extends Testbase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub.

		driver.get("https://accounts.google.com/ServiceLogin?");

		// gmail login
		driver.findElement(By.id("Email")).sendKeys("your gmail username");
		driver.findElement(By.id("next")).click();
		driver.findElement(By.id("Passwd")).sendKeys("your gmail password");
		driver.findElement(By.id("signIn")).click();

		// some optional actions for reaching gmail inbox
		driver.findElement(By.xpath("//*[@title='Google apps']")).click();
		driver.findElement(By.id("gb23")).click();

		// now talking un-read email form inbox into a list
		List<WebElement> unreademeil = driver.findElements(By.xpath("//*[@class='zF']"));

		// Mailer name for which i want to check do i have an email in my inbox
		String MyMailer = "Stack over flow";

		// real logic starts here
		for (int i = 0; i < unreademeil.size(); i++) {
			if (unreademeil.get(i).isDisplayed() == true) {
				// now verify if you have got mail form a specific mailer (Note Un-read mails)
				// for read mails xpath loactor will change but logic will remain same
				if (unreademeil.get(i).getText().equals(MyMailer)) {
					System.out.println("Yes we have got mail form " + MyMailer);
					// also you can perform more actions here
					// like if you want to open email form the mailer
					break;
				} else {
					System.out.println("No mail form " + MyMailer);
				}
			}
		}

	}
}
