package resource.bean.report.base;

import java.io.Serializable;

public class BaseEastProcessLog implements Serializable {

	private int hashCode = Integer.MIN_VALUE;
	// Fields

		private String id;
		private String workDate;
		private String startTm;
		private String endTm;
		private String status;
		private String excemsg;

		// Constructors

	
		public BaseEastProcessLog () {
			initialize();
		}

		/**
		 * Constructor for primary key
		 */
		public BaseEastProcessLog (java.lang.String id) {
			this.setId(id);
			initialize();
		}

		protected void initialize () {}
		/** minimal constructor */
	

		/** full constructor */
		public BaseEastProcessLog(String id, String workDate, String startTm, String endTm, String status,
				String excemsg) {
			this.id = id;
			this.workDate = workDate;
			this.startTm = startTm;
			this.endTm = endTm;
			this.status = status;
			this.excemsg = excemsg;
		}

	

		public String getWorkDate() {
			return this.workDate;
		}

		public void setWorkDate(String workDate) {
			this.workDate = workDate;
		}

		public String getStartTm() {
			return this.startTm;
		}

		public void setStartTm(String startTm) {
			this.startTm = startTm;
		}

		public String getEndTm() {
			return this.endTm;
		}

		public void setEndTm(String endTm) {
			this.endTm = endTm;
		}

		public String getStatus() {
			return this.status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getExcemsg() {
			return this.excemsg;
		}

		public void setExcemsg(String excemsg) {
			this.excemsg = excemsg;
		}

		
		public boolean equals (Object obj) {
			if (null == obj) return false;
			if (!(obj instanceof resource.bean.report.EastProcessLog)) return false;
			else {
				resource.bean.report.EastProcessLog eastProcessLog = (resource.bean.report.EastProcessLog) obj;
				if (null == this.getId() || null == eastProcessLog.getId()) return false;
				else return (this.getId().equals(eastProcessLog.getId()));
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


		public String toString () {
			return super.toString();
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
}
