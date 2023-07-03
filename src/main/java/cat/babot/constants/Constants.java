package cat.babot.constants;

import org.openqa.selenium.By;

public class Constants {
	private  Constants(){}

	public static class General {
		private General() {}
		public static final String URL = "https://www.google.cat/";
		public static final String SCSHPATH = ".\\\\evidence_$.jpg";
		public static final By COOKIESABTN = new By.ById("L2AGLb");
		public static final By SEARCHAREA = new By.ByXPath("//textarea[@name='q']");
		public static final By SEARCHBTN = new By.ByName("btnK");
		public static final By AUTOMWIKI = new By.ByXPath("//span/a[contains(@href, 'wiki/Automatizaci%C3%B3n')]");
	}

}
