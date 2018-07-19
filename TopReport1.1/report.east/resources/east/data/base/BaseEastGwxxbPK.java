package resources.east.data.base;

import java.io.Serializable;

public class BaseEastGwxxbPK implements Serializable {
	// Fields

		/**
	 * 
	 */
	private static final long serialVersionUID = -6586018064334972879L;
		private String gwbh;
		private String nbjgh;

		// Constructors

		/** default constructor */
		public BaseEastGwxxbPK() {
		}

		/** full constructor */
		public BaseEastGwxxbPK(String gwbh, String nbjgh) {
			this.gwbh = gwbh;
			this.nbjgh = nbjgh;
		}

		// Property accessors



		public String getNbjgh() {
			return this.nbjgh;
		}

		public String getGwbh() {
			return gwbh;
		}

		public void setGwbh(String gwbh) {
			this.gwbh = gwbh;
		}

		public void setNbjgh(String nbjgh) {
			this.nbjgh = nbjgh;
		}

}
