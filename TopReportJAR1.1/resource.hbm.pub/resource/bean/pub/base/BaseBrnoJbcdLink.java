package resource.bean.pub.base;

public class BaseBrnoJbcdLink {
	private String bmhh;
	private String brno;
	private String jbcode;
	private String brlevel;
	
	public String getBmhh() {
		return bmhh;
	}
	
	public void setBmhh(String bmhh) {
		this.bmhh = bmhh;
	}
	
	public String getBrno() {
		return brno;
	}
	
	public void setBrno(String brno) {
		this.brno = brno;
	}
	
	public String getJbcode() {
		return jbcode;
	}
	
	public void setJbcode(String jbcode) {
		this.jbcode = jbcode;
	}
	
	public String getBrlevel() {
		return brlevel;
	}
	
	public void setBrlevel(String brlevel) {
		this.brlevel = brlevel;
	}
	
	@Override
	public String toString() {
		return "BaseBrnoJbcdLink [bmhh=" + bmhh + ", brno=" + brno + ", jbcode=" + jbcode + ", brlevel=" + brlevel
				+ "]";
	}
	
}
