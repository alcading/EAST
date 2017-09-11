package resources.east.data.base;



/**
 * AbstractEastGrhqckfhzId entity provides the base persistence definition of the EastGrhqckfhzId entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseEastGrhqckfhzId  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 6601150795827383809L;
	private String hqckzh;
     private String bz;
     private String jyjzh;
     private String chlb;
     private String cjrq;


    // Constructors

    /** default constructor */
    public BaseEastGrhqckfhzId() {
    }

    
    /** full constructor */
    public BaseEastGrhqckfhzId(String hqckzh, String bz, String jyjzh, String chlb, String cjrq) {
        this.hqckzh = hqckzh;
        this.bz = bz;
        this.jyjzh = jyjzh;
        this.chlb = chlb;
        this.cjrq = cjrq;
    }

   
    // Property accessors

    public String getHqckzh() {
        return this.hqckzh;
    }
    
    public void setHqckzh(String hqckzh) {
        this.hqckzh = hqckzh;
    }

    public String getBz() {
        return this.bz;
    }
    
    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getJyjzh() {
        return this.jyjzh;
    }
    
    public void setJyjzh(String jyjzh) {
        this.jyjzh = jyjzh;
    }

    public String getChlb() {
        return this.chlb;
    }
    
    public void setChlb(String chlb) {
        this.chlb = chlb;
    }

    public String getCjrq() {
        return this.cjrq;
    }
    
    public void setCjrq(String cjrq) {
        this.cjrq = cjrq;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof BaseEastGrhqckfhzId) ) return false;
		 BaseEastGrhqckfhzId castOther = ( BaseEastGrhqckfhzId ) other; 
         
		 return ( (this.getHqckzh()==castOther.getHqckzh()) || ( this.getHqckzh()!=null && castOther.getHqckzh()!=null && this.getHqckzh().equals(castOther.getHqckzh()) ) )
 && ( (this.getBz()==castOther.getBz()) || ( this.getBz()!=null && castOther.getBz()!=null && this.getBz().equals(castOther.getBz()) ) )
 && ( (this.getJyjzh()==castOther.getJyjzh()) || ( this.getJyjzh()!=null && castOther.getJyjzh()!=null && this.getJyjzh().equals(castOther.getJyjzh()) ) )
 && ( (this.getChlb()==castOther.getChlb()) || ( this.getChlb()!=null && castOther.getChlb()!=null && this.getChlb().equals(castOther.getChlb()) ) )
 && ( (this.getCjrq()==castOther.getCjrq()) || ( this.getCjrq()!=null && castOther.getCjrq()!=null && this.getCjrq().equals(castOther.getCjrq()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getHqckzh() == null ? 0 : this.getHqckzh().hashCode() );
         result = 37 * result + ( getBz() == null ? 0 : this.getBz().hashCode() );
         result = 37 * result + ( getJyjzh() == null ? 0 : this.getJyjzh().hashCode() );
         result = 37 * result + ( getChlb() == null ? 0 : this.getChlb().hashCode() );
         result = 37 * result + ( getCjrq() == null ? 0 : this.getCjrq().hashCode() );
         return result;
   }   





}