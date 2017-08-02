package resource.bean.report;

import org.apache.commons.lang.StringUtils;

import com.huateng.ebank.framework.util.DataFormat;

import resource.bean.report.base.BaseBiNationregion;



public class BiNationregion extends BaseBiNationregion {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BiNationregion () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BiNationregion (java.lang.String id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	public String getNationregionIdName()
	{
		String id = DataFormat.trim(super.getId());
		String nationregionName = DataFormat.trim(super.getChinaName());

		if(StringUtils.isEmpty(id) && StringUtils.isEmpty(nationregionName))
		{
			return "";
		}
		return id + "-" + nationregionName;
	}

	public void setNationregionIdName(String name)
	{

	}
	
}