package resources.east.data.base;

import java.io.Serializable;

public class BaseEastYgbPK implements Serializable {
	// Fields

		/**
	 * 
	 */
	private static final long serialVersionUID = -6586018064334972879L;
		private String gh;
		private String nbjgh;

		// Constructors

		/** default constructor */
		public BaseEastYgbPK() {
		}

		/** full constructor */
		public BaseEastYgbPK(String gh, String nbjgh) {
			this.gh = gh;
			this.nbjgh = nbjgh;
		}

		// Property accessors

		public String getGh() {
			return this.gh;
		}

		public void setGh(String gh) {
			this.gh = gh;
		}

		public String getNbjgh() {
			return this.nbjgh;
		}

		public void setNbjgh(String nbjgh) {
			this.nbjgh = nbjgh;
		}
	
		public boolean equals (Object obj) {
			if (null == obj) return false;
			if (!(obj instanceof resources.east.data.pub.EastYgbPK)) return false;
			else {
				resources.east.data.pub.EastYgbPK mObj = (resources.east.data.pub.EastYgbPK) obj;
				if (null != this.getGh() && null != mObj.getGh()) {
					if (!this.getGh().equals(mObj.getGh())) {
						return false;
					}
				}
				else {
					return false;
				}
				if (null != this.getNbjgh() && null != mObj.getNbjgh()) {
					if (!this.getNbjgh().equals(mObj.getNbjgh())) {
						return false;
					}
				}
				else {
					return false;
				}
				return true;
			}
		}
		public int hashCode() {
			int result = 17;

			result = 37 * result + (getGh() == null ? 0 : this.getGh().hashCode());
			result = 37 * result + (getNbjgh() == null ? 0 : this.getNbjgh().hashCode());
			return result;
		}

}
