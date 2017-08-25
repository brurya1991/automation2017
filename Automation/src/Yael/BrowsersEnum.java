package Yael;

public enum BrowsersEnum {


	CHROM("webdriver.chrome.driver","C:\\chromedriver.exe"),
	FF("webdriver.ie.driver","C:\\IEDriverServer.exe"),
	IE("webdriver.gecko.driver","C:\\geckodriver.exe");
	
private String key;
private String pathValue;

private BrowsersEnum(String key,String pathValue) {
	this.key= key;
	this.pathValue=pathValue;
}

public String getKey() {
	return this.key;
}


public String getPathValue() {
	return this.pathValue;
}
}
