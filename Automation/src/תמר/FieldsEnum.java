package Infra;

public enum FieldsEnum {
	AdministratorLoginPageEmail("/html/body/div[2]/div[2]/form[1]/div[1]/input[1]"),
	AdministratorLoginPagePAssword("/html/body/div[2]/div[2]/form[1]/div[1]/input[2]"),
	AdministratorLoginLogin("/html/body/div[2]/div[2]/form[1]/button");
	
	private String xpath;
	
	private FieldsEnum(String xpath){
		this.xpath = xpath;
	}
	
	public String getXpath(){
		return this.xpath;
	}
	
}
