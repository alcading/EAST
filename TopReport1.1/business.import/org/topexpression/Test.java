package org.topexpression;




public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuffer querySql = new StringBuffer();
		querySql
		.append("select distinct a.kyc_code||d.depart_shortname as kyc_depart_code, a.Kyc_Code,a.Depart_Code,a.bp_code,a.version,");
querySql
		.append("a.customer_engpyname,a.customer_name,a.customer_type,h.nationregion_name, ");
querySql
		.append("c.person_vocation as vocation,c.person_vocation_other as other_vocation,"
				+ "a.creation_time,a.Bank_Services, ");
querySql
		.append("a.Opponent_Nationality,a.Risk_Level,a.Is_Oneoff,a.Customer_Status,FN_CUSTOMER_CURRENT_STATUS(a.CUSTOMER_CURRENT_STATUS) as CUSTOMER_CURRENT_STATUS_INFO, "
				+ " a.customer_contactaddr ,g2.object_name as EXT_PROXYNAME, f2.PASSPORT as EXT_PASSPORT1,f3.PASSPORT as EXT_PASSPORT2,f1.PASSPORT as EXT_PASSPORT3,f1.EP_END_DATE as EP_END_DATE,s1.object_name as object_name1,s1.object_engpyname as object_engpyname1,s1.paper_code as paper_code1,s1.validate_period as validate_period1,s2.object_name as object_name2,s2.object_engpyname as object_engpyname2,s2.paper_code as paper_code2,s2.validate_period as validate_period2,s3.object_name as object_name3,s3.object_engpyname as object_engpyname3,s3.paper_code as paper_code3,s3.validate_period as validate_period3,s4.object_name as object_name4,s4.object_engpyname as object_engpyname4,s4.paper_code as paper_code4,s4.validate_period as validate_period4,s5.object_name as object_name5,s5.object_engpyname as object_engpyname5,s5.paper_code as paper_code5,s5.validate_period as validate_period5");

// 全部都用 left join方式
querySql.append(" from KYC_Customer_Baseinfo a ");
querySql
		.append(" left join  kyc_ti_score h on  h.nationregion_code=a.customer_nationality and h.language='zh_CN' ");
querySql
		.append(" left join kyc_edd e on a.kyc_code=e.kyc_code and a.depart_code=e.depart_code and a.version=e.version ");
querySql
		.append(" left join kyc_kyc_branch b on a.kyc_code=b.kyc_code and a.depart_code=b.depart_code and a.version=b.version  ");
querySql
		.append(" left join kyc_cddext_individual c on a.kyc_code=c.kyc_code and a.depart_code=c.depart_code and a.version=c.version  ");
querySql
		.append(" left join sm_opdepart d on d.depart_code=a.depart_code ");
querySql
		.append(" left join kyc_passport f1  on a.kyc_code=f1.kyc_code and a.depart_code=f1.depart_code and a.version=f1.version and f1.PASSPORT_TYPE='01' and f1.passport_subtype='03'");
querySql
	    .append(" left join kyc_passport f2  on a.kyc_code=f2.kyc_code and a.depart_code=f2.depart_code and a.version=f2.version and f2.PASSPORT_TYPE='01' and f2.passport_subtype='01'");
querySql
        .append(" left join kyc_passport f3  on a.kyc_code=f3.kyc_code and a.depart_code=f3.depart_code and a.version=f2.version and f2.PASSPORT_TYPE='01' and f2.passport_subtype='02'");
querySql
        .append(" left join KYC_Objects g  on a.kyc_code=g.kyc_code and a.depart_code=g.depart_code and a.version=g.version  and g.object_type='00'");
querySql
	    .append(" left join KYC_Objects g1  on a.kyc_code=g1.kyc_code and a.depart_code=g1.depart_code and a.version=g1.version  and g1.object_type='02'");
querySql
        .append(" left join KYC_Objects g2  on a.kyc_code=g2.kyc_code and a.depart_code=g2.depart_code and a.version=g2.version  and g2.object_type='11'");
querySql
	.append(" left join kyc_objects s1 on a.kyc_code = s1.kyc_code and a.depart_code = s1.depart_code and a.version = s1.version and s1.object_type='01' and s1.id = 'E0'");
querySql
    .append(" left join kyc_objects s2 on a.kyc_code = s2.kyc_code and a.depart_code = s2.depart_code and a.version = s2.version and s2.object_type='02' and s2.id = 'C00'");
querySql
    .append(" left join kyc_objects s3 on a.kyc_code = s3.kyc_code and a.depart_code = s3.depart_code and a.version = s3.version and s3.object_type='02' and s3.id = 'C01'");
querySql
    .append(" left join kyc_objects s4 on a.kyc_code = s4.kyc_code and a.depart_code = s4.depart_code and a.version = s4.version and s4.object_type='02' and s4.id = 'C02'");
querySql
    .append(" left join kyc_objects s5 on a.kyc_code = s5.kyc_code and a.depart_code = s5.depart_code and a.version = s5.version and s5.object_type='02' and s5.id = 'C03'");

querySql.append(" where	 a.customer_type='02'  ");


		System.out.println(querySql.toString());
	

	}
	
	public static String replace(String strSource, String strFrom, String strTo) {
		if (strSource == null) {
			return null;
		}
		int i = 0;
		if ((i = strSource.indexOf(strFrom, i)) >= 0) {
			char[] cSrc = strSource.toCharArray();
			char[] cTo = strTo.toCharArray();
			int len = strFrom.length();
			StringBuffer buf = new StringBuffer(cSrc.length);
			buf.append(cSrc, 0, i).append(cTo);
			i += len;
			int j = i;
			while ((i = strSource.indexOf(strFrom, i)) > 0) {
				buf.append(cSrc, j, i - j).append(cTo);
				i += len;
				j = i;
			}
			buf.append(cSrc, j, cSrc.length - j);
			return buf.toString();
		}
		return strSource;
	}
	
	

}
