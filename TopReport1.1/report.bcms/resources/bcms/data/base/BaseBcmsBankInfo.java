package resources.bcms.data.base;

public class BaseBcmsBankInfo {
	private String id ;//报送类型
	private String bankID;//报送名称
	private String secret;//请求链接地址
	
	
	public BaseBcmsBankInfo(String id, String bankID, String secret) {
		super();
		this.id = id;
		this.bankID = bankID;
		this.secret = secret;
	}


	public BaseBcmsBankInfo(){
		
	}

	public BaseBcmsBankInfo(String id){
		this.id = id;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getBankID() {
		return bankID;
	}


	public void setBankID(String bankID) {
		this.bankID = bankID;
	}


	public String getSecret() {
		return secret;
	}


	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	
	
}
