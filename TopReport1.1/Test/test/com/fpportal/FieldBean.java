package test.com.fpportal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FieldBean implements Serializable {
	private String id;
	private String name;
	BigDecimal num = new BigDecimal("12.3456");
	
	public BigDecimal getNum() {
		return num;
	}
	public void setNum(BigDecimal num) {
		this.num = num;
	}

	List<FieldBean> list = new ArrayList<FieldBean>();
	
	public List<FieldBean> getList() {
		return list;
	}
	public void setList(List<FieldBean> list) {
		this.list = list;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "FieldBean["+id+"]";
	}
}
