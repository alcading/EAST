package resources.east.data.base;

import java.io.Serializable;

public class BaseEastGybPk implements Serializable {
	// Fields

		/**
	 * 
	 */
	private static final long serialVersionUID = -6586018064334972879L;
		private String gyh;
		private String nbjgh;
		private String cjrq;

		// Constructors

		/** default constructor */
		public BaseEastGybPk() {
		}

		/** full constructor */
		public BaseEastGybPk(String gyh, String nbjgh, String cjrq) {
			super();
			this.gyh = gyh;
			this.nbjgh = nbjgh;
			this.cjrq = cjrq;
		}

		public String getGyh() {
			return gyh;
		}

		public void setGyh(String gyh) {
			this.gyh = gyh;
		}

		public String getNbjgh() {
			return nbjgh;
		}

		public void setNbjgh(String nbjgh) {
			this.nbjgh = nbjgh;
		}

		public String getCjrq() {
			return cjrq;
		}

		public void setCjrq(String cjrq) {
			this.cjrq = cjrq;
		}

}
