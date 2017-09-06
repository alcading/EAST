package resource.bean.report.base;

import java.io.Serializable;


public class BaseEastVerifResult implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = -470036311508189012L;
	private int hashCode = Integer.MIN_VALUE;

		    private Integer id;
			private String tableName;
			private String tableDesc;
			private String columnName;
			private String columnDesc;
			private String errormsg;
			private String dataDate;
			private String ruleDesc;
			// Constructors

			/** default constructor */
			public BaseEastVerifResult() {
			}

			/** minimal constructor */
			public BaseEastVerifResult(Integer id) {
				this.setId(id);
			}

			/** full constructor */
			public BaseEastVerifResult(Integer id, String tableName, String tableDesc, String columnName,
					String columnDesc, String errormsg, String dataDate, String ruleDesc) {
				this.setId(id);
				this.tableName = tableName;
				this.tableDesc = tableDesc;
				this.columnName = columnName;
				this.columnDesc = columnDesc;
				this.errormsg = errormsg;
				this.dataDate = dataDate;
				this.ruleDesc = ruleDesc;
			}

			// Property accessors

			
			public String getTableName() {
				return this.tableName;
			}

			public void setTableName(String tableName) {
				this.tableName = tableName;
			}

			public String getTableDesc() {
				return this.tableDesc;
			}

			public void setTableDesc(String tableDesc) {
				this.tableDesc = tableDesc;
			}

			public String getColumnName() {
				return this.columnName;
			}

			public void setColumnName(String columnName) {
				this.columnName = columnName;
			}

			public String getColumnDesc() {
				return this.columnDesc;
			}

			public void setColumnDesc(String columnDesc) {
				this.columnDesc = columnDesc;
			}

			public String getErrormsg() {
				return this.errormsg;
			}

			public void setErrormsg(String errormsg) {
				this.errormsg = errormsg;
			}

			public String getDataDate() {
				return this.dataDate;
			}

			public void setDataDate(String dataDate) {
				this.dataDate = dataDate;
			}

			public String getRuleDesc() {
				return this.ruleDesc;
			}

			public void setRuleDesc(String ruleDesc) {
				this.ruleDesc = ruleDesc;
			}
	  
			public boolean equals (Object obj) {
				if (null == obj) return false;
				if (!(obj instanceof resource.bean.report.EastVerifResult)) return false;
				else {
					resource.bean.report.EastVerifResult eastVerifResult = (resource.bean.report.EastVerifResult) obj;
					if (null == this.getId() || null == eastVerifResult.getId()) return false;
					else return (this.getId().equals(eastVerifResult.getId()));
				}
			}

			public int hashCode () {
				if (Integer.MIN_VALUE == this.hashCode) {
					if (null == this.getId()) return super.hashCode();
					else {
						String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
						this.hashCode = hashStr.hashCode();
					}
				}
				return this.hashCode;
			}

			public Integer getId() {
				return id;
			}

			public void setId(Integer id) {
				this.id = id;
			}

}
