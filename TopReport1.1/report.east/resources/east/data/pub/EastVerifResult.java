package resources.east.data.pub;


import resources.east.data.base.BaseEastVerifResult;

public class EastVerifResult extends BaseEastVerifResult implements java.io.Serializable {

    // Constructors

    /**
	 * 
	 */
	private static final long serialVersionUID = -49646557720878342L;

	/** default constructor */
    public EastVerifResult() {
    }

    
    /** full constructor */
    public EastVerifResult(java.lang.Integer id) {
        super(id);        
    }
    
    public EastVerifResult(Integer id, String tableName, String tableDesc, String columnName, String columnDesc,
			String errormsg, String dataDate, String ruleDesc) {
		super(id, tableName, tableDesc, columnName, columnDesc, errormsg, dataDate, ruleDesc);
	}
}
