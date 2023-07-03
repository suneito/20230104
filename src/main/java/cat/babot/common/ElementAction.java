package cat.babot.common;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import cat.babot.constants.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ElementAction {
	private WebDriver wd;
	private String parentW;
	private String childW = null;
	
	public ElementAction(WebDriver driver) {
		this.wd = driver;
	}
	
	private WebElement locateElement(By locator) {
		return wd.findElement(locator);
	}
	
	public void clickOn(By locator) {
		locateElement(locator).click();
	}
	
	public void clickOnWithJS(By locator) {
		((JavascriptExecutor) wd).executeScript("arguments[0].click();", locateElement(locator));
	}
	
	public void  writeIn(By locator, String value) {
		locateElement(locator).sendKeys(value);
	}
	
	public Alert changeToAlert() {
		return wd.switchTo().alert();
	}
	
	public String extractTextFrom(By locator) {
		return locateElement(locator).getText();
	}
	
	public List<WebElement> listElements(By locator) {
		return wd.findElements(locator);
	}

	public void changeToChildWindow() {
		parentW = wd.getWindowHandle();
		Iterator<String> iterator = wd.getWindowHandles().iterator();
		
		while (iterator.hasNext()){
		    childW = iterator.next();
		}
		
		wd.switchTo().window(childW); 
	}
	
	public void changeToParentWindow() {
		wd.switchTo().window(parentW);
	}
	
	public void dragAndDrop(By dragLoc, By dropLoc) {
        Actions act=new Actions(wd);					
        act.dragAndDrop(locateElement(dragLoc), locateElement(dropLoc)).build().perform();
	}

	public void screenshot() {
		TakesScreenshot scrShot =((TakesScreenshot)wd);
		File srcPath = scrShot.getScreenshotAs(OutputType.FILE);
		File destiny = new File(Constants.General.SCSHPATH.replace("$", String.valueOf(new Date().getTime())));
		try {
			FileUtils.copyFile(srcPath, destiny);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
