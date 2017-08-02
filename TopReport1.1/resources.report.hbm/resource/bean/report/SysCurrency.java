package resource.bean.report;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.base.BaseSysCurrency;

import com.huateng.ebank.framework.util.DataFormat;



public class SysCurrency extends BaseSysCurrency {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public SysCurrency () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public SysCurrency (java.lang.String id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	public String getCurrencyNoName()
	{
		String id = DataFormat.trim(super.getId());
		String currencyName = DataFormat.trim(super.getCurrencyName());

		if(StringUtils.isEmpty(id) && StringUtils.isEmpty(currencyName))
		{
			return "";
		}
		return id + "-" + currencyName;
	}

	public void setCurrencyNoName(String name)
	{

	}

}