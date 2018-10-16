package resources.bcms.data.base;

public class BaseBcmsRequestInfo {
	private String deliveryType ;//报送类型
	private String deliveryName;//报送名称
	private String requestURL;//请求链接地址
	private String requestMethod;//请求方式
	private String preRequest ;//该接口前置接口
	
	public BaseBcmsRequestInfo(String deliveryType, String deliveryName, String requestURL, String requestMethod,
			String preRequest) {
		super();
		this.deliveryType = deliveryType;
		this.deliveryName = deliveryName;
		this.requestURL = requestURL;
		this.requestMethod = requestMethod;
		this.preRequest = preRequest;
	}
	
	public BaseBcmsRequestInfo(){
		
	}
	
	/** minimal constructor 孤独使人发胖，是寂寞在膨胀~~~ */
	public BaseBcmsRequestInfo(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public String getRequestURL() {
		return requestURL;
	}
	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}
	public String getRequestMethod() {
		return requestMethod;
	}
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	public String getPreRequest() {
		return preRequest;
	}
	public void setPreRequest(String preRequest) {
		this.preRequest = preRequest;
	}
	
	
}
