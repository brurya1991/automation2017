package Infra;

public enum BrowserEnum {
	CHROME("webdriver.chrome.driver","C:\\Users\\chromedriver.exe"),
	FIREFOX("webdriver.gecko.driver","C:\\Users\\geckodriver.exe"),
	IE("webdriver.ie.driver","C:\\Users\\IEDriverServer.exe");
	
	private String key;
	private String path;
	
	private BrowserEnum(String key,String path){
		this.key = key;
		this.path = path;
	}
	
	public String getKey(){
		return this.key;
	}
	
	public String getPath(){
		return this.path;
	}
	
}
