package resources.east.data.pub;

import resources.east.data.base.BaseEastNbfhzId;

/**
 * EastNbfhzId entity. @author MyEclipse Persistence Tools
 */
public class EastNbfhzId extends BaseEastNbfhzId implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public EastNbfhzId() {
    }

    
    /** full constructor */
    public EastNbfhzId(String nbfhzzh, String bz,String cjrq) {
        super(nbfhzzh, bz, cjrq);        
    }
   
}
