package org.topexpression.function;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.topexpression.IllegalExpressionException;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.imports.logic.ImportFileVar;
import com.huateng.report.imports.model.TFileDataInfo;
import com.huateng.report.system.service.RbsBranchCodeMappService;


/**
 * @author lei.zhang
 * @since 2010-12-7
 * @version 1.0
 *
 */
public class MethodImpl extends BaseMethodFactory{

	public static Hashtable mapList = new Hashtable();
	public static List mapWorkDate = new ArrayList();
	public static Map rbcBcMap = new HashMap();

	public MethodImpl() throws CommonException{

		this.initMenthod();
		this.initMap_ID_MapData();//将ID_MapData初始化到mapList中
		this.initMap_SYS_WorkDate();//将不同系统工作日初始化到mapWorkDate中

		this.initMap_BC_MapData();

	}

	public void initMap_ID_MapData() {//将Id_MapData初始化到mapList中
//	     IMyBatisSessionTemplate myBatisSessionTemplate=(IMyBatisSessionTemplate)SpringContextUtils.getBean("myBatisSessionTemplate");
//		 List<Map> resultList = myBatisSessionTemplate.selectList("com.huateng.report.imports.sqlmap.Import.select6");
//		 int maptype = -1;
//		 List lcTempList = new ArrayList();
//		 mapList.clear();
//		 for (Map idmp : resultList) {
//			if (maptype != ((BigDecimal) idmp.get("MAP_TYPE")).intValue()) {
//				maptype = ((BigDecimal) idmp.get("MAP_TYPE")).intValue();
//				lcTempList = new ArrayList();
//				mapList.put(maptype, (ArrayList) lcTempList);
//			}
//			lcTempList.add(idmp);
//		}
	}

	//将rbs机构代码mapping金融机构标识号

	public void initMap_BC_MapData() throws CommonException
	{
		RbsBranchCodeMappService rbsBcService = RbsBranchCodeMappService.getInstance();
		rbcBcMap = rbsBcService.queryBCMapping(TopReportConstants.REPORT_BUSITYPE_BOP);

	}

	public void initMap_SYS_WorkDate() {
//		mapWorkDate.clear();
//		Map inputMap = new HashMap();
//		inputMap.put("PARAMGROUP_ID",Constants.SYSPARAMS_PARAMGROUP_ID);
//		IMyBatisSessionTemplate myBatisSessionTemplate=(IMyBatisSessionTemplate)SpringContextUtils.getBean("myBatisSessionTemplate");
//		List<Map> resultList = myBatisSessionTemplate.selectList("com.huateng.report.imports.sqlmap.Import.getWorkDate",inputMap);
//		int programId = 0;
//		List lcTempList = new ArrayList();
//		for (Map idmp : resultList) {
//			lcTempList = new ArrayList();
//			mapWorkDate.add(programId,(ArrayList)lcTempList);
//			lcTempList.add(idmp);
//		}

	}

	/**
	 * txt文件指定的截取方法
	 * @param String str 输入字符串
	 * @param Int beginIndex 开始截取位
	 * @param Int endIndex 截取结束位
	 */
	public String txuSubStringTxt(String str, int beginIndex, int endIndex) {
		if (str == null) {
			return null;
		}
		char[] a= new char[str.getBytes().length];

		//判断是否是汉字，如果为汉字，则beginIndex - 1
		for(int i = 0; i < beginIndex; i++){
			a[i]  = str.charAt(i);
			if((int)a[i] > 255){//判断是否是汉字，如果为汉字，则beginIndex - 1
				if(beginIndex > 0){//开始位要大于零
					beginIndex -= 1;
				}
			}
		}

		//判断是否是汉字，如果为汉字，则endIndex - 1
		for(int i = 0; i < endIndex; i++){
			a[i]  = str.charAt(i);
			if((int)a[i] > 255){//判断是否是汉字，如果为汉字，则 endIndex 都-1
				if(beginIndex > 0){//开始位要大于零
					endIndex -= 1;
				}
			}
		}

		// 去尾，将结束位之后的字段截取删除
		while (str.length() > endIndex) {
			str = str.substring(0,endIndex);
		}
		//去头，将开始位之前的字段截取删除
		while(str.length() > beginIndex && beginIndex >0){//开始位要大于0
			str = str.substring(beginIndex -1);

		}
		return str;
	}

	/**
	 * 非txt文件指定的截取方法
	 * @param str 输入字符串
	 * @param beginIndex 开始截取位
	 * @param endIndex 截取结束位
	 */
	public String subString(String str, int beginIndex, int endIndex) {
		if (str == null) {
			return null;
		}
		// 去尾，将结束位之后的字段截取删除
		while (str.getBytes().length > endIndex) {
			str = str.substring(0, (str.length() - (str.getBytes().length - endIndex + 1) / 2));
		}
		int j = 0;
		//去头，将开始位之前的字段截取删除
		if (str.getBytes().length > beginIndex) {
			for (int i = 0; i < beginIndex; i++) {
				if (String.valueOf(str.toCharArray()[i]).getBytes().length > 1) {
					i++;
				}
				j++;
			}
			str = str.substring(j);
		}
		return str;
	}

	/**
	 * 解析文件方法定义
	 */
	private void initMenthod(){

		/**
		 * 获取文本的固定位。多用于解析txt文件时
		 * @param arg[0] 行数据内容
		 * @param arg[1] 开始位
		 * @param arg[2] 结束位
		 */
		super.add(new BaseMethod("getTxt"){
			public Object call(Object[] arg)  throws IllegalExpressionException{
				TFileDataInfo curImpFileInfo=(TFileDataInfo)arg[0];
				int iiBgPointer=Integer.valueOf(arg[1].toString()).intValue();
				int iiEdPointer=Integer.valueOf(arg[2].toString()).intValue();
				if (ImportFileVar.FILEDATA_FORMATTYPE_FIXED.equals(curImpFileInfo.getFormatType())) {
					if ((iiBgPointer >= 0) && (iiEdPointer >= 0)
							&& (iiBgPointer <= iiEdPointer && (curImpFileInfo.getFRowValue().get(0).toString().getBytes().length) >= iiEdPointer)) {
						try {
							if (curImpFileInfo.getFRowValue().get(0) == null) {
								return "";
							}
						} catch (Exception e) {
							throw new IllegalExpressionException();
						}
						//返回用txt专用的SubString截取的字段
						return txuSubStringTxt(curImpFileInfo.getFRowValue().get(0).toString(),iiBgPointer, iiEdPointer).trim();
					} else {
						return "";
					}
				} else {
					if (iiBgPointer >= 1) {
						try {
							if (curImpFileInfo.getFRowValue().get(iiBgPointer - 1) == null) {
								return "";
							}
						} catch (Exception e) {
							throw new IllegalExpressionException();
						}
						return curImpFileInfo.getFRowValue().get(iiBgPointer - 1).toString().trim();
					}
				}
				return "";
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length!=3){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 截取字符串。参数是从第beginIndex位截取到第endIndex位
		 * @param arg[0] 数据内容
		 * @param arg[1] 开始位
		 * @param arg[2] 结束位
		 */
		super.add(new BaseMethod("subString"){
			public Object call(Object[] arg) throws IllegalExpressionException {
				String str=(String)arg[0];
				int beginIndex=Integer.valueOf(arg[1].toString()).intValue();
				int endIndex=Integer.valueOf(arg[2].toString()).intValue();
				return subString(str,beginIndex,endIndex);
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length!=3){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return (String)arg[0];
			}
		});

		/**
		 * 取得行项目中的特定项目内容 - 导入st =4
		 * @param arg[0] 行数据内容
		 * @param arg[1] List中项目号
		 */
		super.add(new BaseMethod("getRateColumn"){//取得行项目中的特定项目内容
			public Object call(Object[] arg)  throws IllegalExpressionException{
				TFileDataInfo curImpFileInfo=(TFileDataInfo)arg[0];			//行数据内容
				if (arg[1] == null) {
					throw  new IllegalExpressionException("参数不正确,必须是数字");
				}
				int num = Integer.valueOf(arg[1].toString()).intValue();	//List中项目号
				String txtContent ="";										//返回字段

				if(curImpFileInfo.getFRowValue().size() < num ){//项目号大于行数据长度时，报错
					throw  new IllegalExpressionException("文件配置过程中，项目号超出行数据长度");
				}else{//取得行数据中第num项数据，从0开始
					txtContent ="4";
				}

				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 2){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 取得行项目中的特定项目内容 - 导入LOCKED =F
		 * @param arg[0] 行数据内容
		 * @param arg[1] List中项目号
		 */
		super.add(new BaseMethod("getLockedColumn"){//取得行项目中的特定项目内容
			public Object call(Object[] arg)  throws IllegalExpressionException{
				TFileDataInfo curImpFileInfo=(TFileDataInfo)arg[0];			//行数据内容
				if (arg[1] == null) {
					throw  new IllegalExpressionException("参数不正确,必须是数字");
				}
				int num = Integer.valueOf(arg[1].toString()).intValue();	//List中项目号
				String txtContent ="";										//返回字段

				if(curImpFileInfo.getFRowValue().size() < num ){//项目号大于行数据长度时，报错
					throw  new IllegalExpressionException("文件配置过程中，项目号超出行数据长度");
				}else{//取得行数据中第num项数据，从0开始
					txtContent ="F";
				}

				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 2){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 取得行项目中的特定项目内容 - 导入DEL =F
		 * @param arg[0] 行数据内容
		 * @param arg[1] List中项目号
		 */
		super.add(new BaseMethod("getLockedColumn"){//取得行项目中的特定项目内容
			public Object call(Object[] arg)  throws IllegalExpressionException{
				TFileDataInfo curImpFileInfo=(TFileDataInfo)arg[0];			//行数据内容
				if (arg[1] == null) {
					throw  new IllegalExpressionException("参数不正确,必须是数字");
				}
				int num = Integer.valueOf(arg[1].toString()).intValue();	//List中项目号
				String txtContent ="";										//返回字段

				if(curImpFileInfo.getFRowValue().size() < num ){//项目号大于行数据长度时，报错
					throw  new IllegalExpressionException("文件配置过程中，项目号超出行数据长度");
				}else{//取得行数据中第num项数据，从0开始
					txtContent ="F";
				}

				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 2){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**输入的arg[1]，以arg[0]为map_type读通用ID_MapData表，如果匹配不到，arg[2] = 0 时，则返回空值，arg[2] = 1 时，返回原值
		 * @param arg[0] 数字参数1
		 * @param arg[1] 输入项目
		 * @param arg[2] 返回值类型
		 */
		super.add(new BaseMethod("getMapValue"){//(getMapValue(n1,subString(),1或0) 原case3和case15
			public Object call(Object[] arg)  throws IllegalExpressionException {
				long iMpType=Long.valueOf(arg[0].toString()).longValue();		//数字参数1
				String sInPutVal=(String)arg[1];								//输入项目
				int booNull = Integer.valueOf(arg[2].toString()).intValue();	//返回值类型
				String txtContent ="";											//返回字段
				List tmpList = (ArrayList) mapList.get((int) iMpType);
				Iterator it = tmpList.iterator();
				while (it.hasNext()) {
					Map idmp = (Map) it.next();
					if (sInPutVal.equals((String) idmp.get("INPUT_VALUE"))) {
						if (idmp.get("OUT_VALUE") != null) {
							txtContent =  (String) idmp.get("OUT_VALUE");
						}
					}
				}
				txtContent = replaceNull(txtContent);
				if ( 1 == booNull && txtContent == "") {//返回值类型为1时，返回原值
					return sInPutVal;
				}
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				return true;
			}
		});


		/**
		 * 项目赋固定值
		 * @param arg[0] 数据内容
		 * @param arg[1] 特定值
		 */
		super.add(new BaseMethod("fixedValue"){//取得特定值
			public Object call(Object[] arg)  throws IllegalExpressionException{
				String txtContent =(String)arg[1];			//特定值

				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 2){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 取得行项目中的特定项目内容
		 * @param arg[0] 行数据内容
		 * @param arg[1] List中项目号
		 */
		super.add(new BaseMethod("getColumn"){//取得行项目中的特定项目内容
			public Object call(Object[] arg)  throws IllegalExpressionException{
				TFileDataInfo curImpFileInfo=(TFileDataInfo)arg[0];			//行数据内容
				if (arg[1] == null) {
					throw  new IllegalExpressionException("参数不正确,必须是数字");
				}
				int num = Integer.valueOf(arg[1].toString()).intValue();	//List中项目号
				String txtContent ="";										//返回字段

				if(curImpFileInfo.getFRowValue().size() < num ){//项目号大于行数据长度时，报错
					throw  new IllegalExpressionException("文件配置过程中，项目号超出行数据长度");
				}else{//取得行数据中第num项数据，从0开始
					txtContent =curImpFileInfo.getFRowValue().get(num - 1).toString().trim();
				}

				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 2){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 取得行项目中的特定项目内容 - 获取主键ID BRANCHCODE+ACCOUNTNUMBER+CURRENCYCODE 或者 BRANCHCODE+PARTYNUMBER
		 * @param arg[0] 行数据内容
		 * @param arg[1] List中项目号
		 */
		super.add(new BaseMethod("getPrimaryColumn"){//取得行项目中的特定项目内容
			public Object call(Object[] arg)  throws IllegalExpressionException{
				TFileDataInfo curImpFileInfo=(TFileDataInfo)arg[0];			//行数据内容
				String paramIn[] = null;
				StringBuffer txtSb = new StringBuffer("");

				if(null != arg[1])
				{
					paramIn = arg[1].toString().split(",");
					for(String index :paramIn)
					{
						if(null == index)
						{
							throw  new IllegalExpressionException("参数不正确,必须是数字");
						}
					}
				}

				for(String index :paramIn)
				{
					txtSb.append(curImpFileInfo.getFRowValue().get(Integer.parseInt(index) - 1).toString().trim());
				}

				String txtContent ="";										//返回字段

				//取得行数据中第num项数据，从0开始
				txtContent =txtSb.toString();

				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 2){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 取得行项目中的特定项目内容 -
		 * @param arg[0] 行数据内容
		 * @param arg[1] List中项目号
		 */
		super.add(new BaseMethod("getNoneColumn"){//取得行项目中的特定项目内容
			public Object call(Object[] arg)  throws IllegalExpressionException{
				//
				TFileDataInfo curImpFileInfo=(TFileDataInfo)arg[0];			//行数据内容

				String rbsBC =curImpFileInfo.getFRowValue().get(0).toString().trim();

				String txtContent ="";
				if (arg[2] == null || arg[3] == null ) {
					throw  new IllegalExpressionException("参数不正确,必须是数字");
				}

				if(arg[1]!=null && "limittype".equalsIgnoreCase(arg[1].toString()))
				{
					txtContent=arg[2].toString();
				}else if (arg[1]!=null && "accountcata".equalsIgnoreCase(arg[1].toString()))
				{
					txtContent=arg[2].toString();
				}else if (arg[1]!=null && "bopbranchcode".equalsIgnoreCase(arg[1].toString()))
				{
					txtContent=(String) rbcBcMap.get(rbsBC);
				}
				if(arg[1]!=null && "localextention".equalsIgnoreCase(arg[1].toString()) && Integer.valueOf(arg[3].toString()).intValue()!=0)
				{
					int num = Integer.valueOf(arg[2].toString()).intValue() + (Integer.valueOf(arg[3].toString()).intValue()-11);
					txtContent = curImpFileInfo.getFRowValue().get(num-1).toString().trim();
				}
				else if(arg[1]!=null && "localextention".equalsIgnoreCase(arg[1].toString()) && Integer.valueOf(arg[3].toString()).intValue()==0)
				{

				}

				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 4){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 取得行项目中的特定项目内容 -特定字段需要去双引号
		 * @param arg[0] 行数据内容
		 * @param arg[1] List中项目号
		 */
		super.add(new BaseMethod("getQmColumn"){//特定字段需要去双引号
			public Object call(Object[] arg)  throws IllegalExpressionException{
				TFileDataInfo curImpFileInfo=(TFileDataInfo)arg[0];			//行数据内容
				if (arg[1] == null) {
					throw  new IllegalExpressionException("参数不正确,必须是数字");
				}
				int num = Integer.valueOf(arg[1].toString()).intValue();	//List中项目号
				String txtContent ="";										//返回字段

				if(curImpFileInfo.getFRowValue().size() < num ){//项目号大于行数据长度时，报错
					throw  new IllegalExpressionException("文件配置过程中，项目号超出行数据长度");
				}else{//取得行数据中第num项数据，从0开始
					txtContent =curImpFileInfo.getFRowValue().get(num - 1).toString().trim();
					if(null != txtContent && txtContent.startsWith("\""))
					{
						String txtContentAry[] = txtContent.split("\"");
						for(String txtQm : txtContentAry)
						{
							if(null !=txtQm && !"\"".equals(txtQm))
							{
								txtContent = txtQm.trim();
							}
						}
					}
				}

				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 2){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 取得行项目中的特定项目内容 -特定字段截取字段
		 * @param arg[0] 行数据内容
		 * @param arg[1] List中项目号
		 */
		super.add(new BaseMethod("getSubColumn"){//特定字段截取字段
			public Object call(Object[] arg)  throws IllegalExpressionException{
				TFileDataInfo curImpFileInfo=(TFileDataInfo)arg[0];			//行数据内容
				if (arg[1] == null || arg[2] == null || arg[3] == null) {
					throw  new IllegalExpressionException("参数不正确,必须是数字");
				}
				int num = Integer.valueOf(arg[1].toString()).intValue();	//List中项目号
				String txtContent ="";										//返回字段

				if(curImpFileInfo.getFRowValue().size() < num ){//项目号大于行数据长度时，报错
					throw  new IllegalExpressionException("文件配置过程中，项目号超出行数据长度");
				}else{//取得行数据中第num项数据，从0开始
					txtContent =curImpFileInfo.getFRowValue().get(num - 1).toString().trim();
					if(num < Integer.valueOf(arg[3].toString()).intValue())
					{
						throw  new IllegalExpressionException("截取结束参数超出字段数据长度");
					}
					else
					{
						txtContent = txtContent.substring(Integer.valueOf(arg[2].toString()).intValue()
								,Integer.valueOf(arg[3].toString()).intValue());
					}
				}

				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 4){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){
				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		super.add(new BaseMethod("getCurrCode"){//取得行项目中的特定项目内容
			public Object call(Object[] arg)  throws IllegalExpressionException{
				TFileDataInfo curImpFileInfo=(TFileDataInfo)arg[0];			//行数据内容
				int num = Integer.valueOf(arg[1].toString()).intValue();	//List中项目号
				String txtContent ="";										//返回字段

				if(curImpFileInfo.getFRowValue().size() < num ){//项目号大于行数据长度时，报错
					throw  new IllegalExpressionException("文件配置过程中，项目号超出行数据长度");
				}else{//取得行数据中第num项数据，从0开始
					txtContent =curImpFileInfo.getFRowValue().get(num - 1).toString().trim();
				}

				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				if(txtContent!=null && txtContent.equals("360")){
					txtContent="CNY";
				}
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 2){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 原样返回(char型)从原来的字符中取从n1开始n2个字符。如果c1不为空，将c1中的字符从结果中去除
		 * @param arg[0] 数据内容
		 * @param arg[1] 数字参数1
		 * @param arg[2] 数字参数2
		 * @param arg[3] 要过滤的字段
		 */
		super.add(new BaseMethod("removePara"){//原case1
			public Object call(Object[] arg)  throws IllegalExpressionException{

				int mv_np1 =Integer.valueOf(arg[1].toString()).intValue();	//数字参数1
				int mv_np2 =Integer.valueOf(arg[2].toString()).intValue();	//数字参数2
				String mv_cp1 = (String)arg[3];								//字符参数1
				String txtContent ="";										//返回字段
				//取得arg[0]数据
				txtContent = (String)arg[0];

				//从原来的字符中取从n1开始n2个字符
				try{
					if ((mv_np1 > 0)&& (mv_np2 > 0)&& (txtContent.length() >= (mv_np1 + mv_np2 - 1))) {

						txtContent = subString(txtContent, mv_np1 - 1,mv_np1 + mv_np2 - 1);

						if (txtContent.length() > 0) {
							txtContent = txtContent.trim();
						}
					}
					//如果c1不为空，将c1中的字符从结果中去除
					if(mv_cp1 != null || mv_cp1.length() >= 1){
						String tmp = mv_cp1;
						txtContent = txtContent.replaceAll(tmp, "");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;

			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 4){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});


		/**
		 * 根据n1和c1定义的返回格式返回
		 * @param arg[0] 行数据内容
		 * @param arg[1] List中项目号
		 * @param arg[2] 数字参数1
		 * @param arg[3] 字符参数1
		 */
		super.add(new BaseMethod("changeByPara"){//case2 和最终计算结果case6
			public Object call(Object[] arg)  throws IllegalExpressionException{

				int mv_np1 =Integer.valueOf(arg[1].toString()).intValue();	//数字参数1
				int mv_np2 =Integer.valueOf(arg[2].toString()).intValue();	//数字参数2
				String mv_cp1 = (String)arg[3];								//字符参数1
				String mv_cp2 = (String)arg[4];								//字符参数2
				String txtContent ="";										//返回字段
				Double lexTmp = 0.0;
				String lsTmp = "";
				//根据n2和c1定义的返回格式返回
				try{
					//取得arg[0]数据
					txtContent = (String)arg[0].toString().replace(",", "");

					lexTmp = Double.valueOf(txtContent);

					if ("+".equals(mv_cp2)) {//转化为number后+/-/乘/除n1,+/-/乘/除存放在c2中,
						lexTmp = lexTmp + mv_np1;
					} else if ("-".equals(mv_cp2)) {
						lexTmp = lexTmp - mv_np1;
					} else if ("*".equals(mv_cp2)) {
						lexTmp = lexTmp * mv_np1;
					} else if ("/".equals(mv_cp2)) {
						if (mv_np1 == 0) {
							lexTmp = 0.0;
						} else {
							lexTmp = lexTmp / mv_np1;
						}
					}

					DecimalFormat df = new DecimalFormat("#.######");
					lsTmp = df.format(lexTmp).trim();
					df = null;

					if ("01".equals(mv_cp1)) {
						// 直接返回Number型
						txtContent = lsTmp;
					} else if ("02".equals(mv_cp1)) {
						// 左对齐返回字符串
						lsTmp = String.valueOf(Math.round(lexTmp));
						if (lsTmp.length() >= mv_np1) {
							lsTmp = subString(lsTmp, 0,mv_np1);// lsTmp.substring(0,// mv_np2);
						} else {
							int j = lsTmp.length();
							for (int i = 0; i < mv_np1 - j; i++) {
								lsTmp = lsTmp + " ";
							}
						}
						txtContent = lsTmp;
					} else if ("03".equals(mv_cp1)) {
						// 前补0返回字符串
						lsTmp = String.valueOf(Math.round(lexTmp));
						if (lsTmp.length() >= mv_np1) {
							lsTmp = subString(lsTmp, 0,mv_np1);// lsTmp.substring(0,
							// mv_np2);
						} else {
							int j = lsTmp.length();
							for (int i = 0; i < mv_np1 - j; i++) {
								lsTmp = "0" + lsTmp;
							}
						}
						txtContent = lsTmp;
					} else if ("04".equals(mv_cp1)) {
						// 右对齐返回字符串
						lsTmp = String.valueOf(Math.round(lexTmp));
						if (lsTmp.length() >= mv_np1) {
							lsTmp = subString(lsTmp, 0,mv_np1);// lsTmp.substring(0,// mv_np2);
						} else {
							int j = lsTmp.length();
							for (int i = 0; i < mv_np1 - j; i++) {
								lsTmp = " " + lsTmp;
							}
						}
						txtContent = lsTmp;
					}	else {
						return false;
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 5){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[4] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 在n1和n2间，返回c1，否则c2
		 * @param arg[0] 数据内容
		 * @param arg[1] 数字参数1
		 * @param arg[2] 数字参数2
		 * @param arg[3] 字符参数1
		 * @param arg[4] 字符参数2
		 */
		super.add(new BaseMethod("inParas"){//case8
			public Object call(Object[] arg)  throws IllegalExpressionException{

				int mv_np1 =Integer.valueOf(arg[1].toString()).intValue();	//数字参数1
				int mv_np2 =Integer.valueOf(arg[2].toString()).intValue();	//数字参数2
				String mv_cp1 = (String)arg[3];								//字符参数1
				String mv_cp2 = (String)arg[4];								//字符参数2
				String txtContent ="";										//返回字段
				//取得arg[0]数据
				txtContent = (String)arg[0];

				// 在n1和n2间，返回c1，否则c2
				if ((Double.valueOf(txtContent) >= Double.valueOf(String.valueOf(mv_np1)))
					&& (Double.valueOf(txtContent) <= Double.valueOf(String.valueOf(mv_np2)))) {
					txtContent = mv_cp1;
				} else {
					txtContent = mv_cp2;
				}

				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 5){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[4] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 在c1[1,n1]和c1[n1+1,2n1]间，返回c2[1,n2]，否则返回c2[n2,2n2]
		 * @param arg[0] 数据内容
		 * @param arg[1] 数字参数1
		 * @param arg[2] 数字参数2
		 * @param arg[3] 字符参数1
		 * @param arg[4] 字符参数2
		 */
		super.add(new BaseMethod("inAlphabets"){//case9
			public Object call(Object[] arg)  throws IllegalExpressionException{

				int mv_np1 =Integer.valueOf(arg[1].toString()).intValue();	//数字参数1
				int mv_np2 =Integer.valueOf(arg[2].toString()).intValue();	//数字参数2
				String mv_cp1 = (String)arg[3];								//字符参数1
				String mv_cp2 = (String)arg[4];								//字符参数2
				String txtContent ="";										//返回字段

				//取得arg[0]数据
				txtContent = (String)arg[0];

				//在c1[1,n1]和c1[n1+1,2n1]间，返回c2[1,n2]，否则c2[n2,2n2]
				if ((Double.valueOf(txtContent) >= Double.valueOf(String.valueOf(mv_cp1).substring(0,Integer.valueOf(String.valueOf(mv_np1)) - 1)))
					&& (Double.valueOf(txtContent) <= Double.valueOf(String.valueOf(mv_cp1).substring(Integer.valueOf(String.valueOf(mv_np1)),2 * Integer.valueOf(String.valueOf(mv_np1)) - 1)))) {
					txtContent = mv_cp2.substring(0,mv_np2 - 1);
				} else {
					txtContent = mv_cp2.substring(mv_np2 - 1, 2 * mv_np2 - 1);
				}
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 5){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[4] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 输入字符串中，取n1起始位，n2个字符（n1,n2有为0的，返回原字符串），并将c1中包含的字符全部清除（单个字符清除）。
		 * @param arg[0] 数据内容
		 * @param arg[1] 数字参数1
		 * @param arg[2] 数字参数2
		 * @param arg[2] 字符参数2
		 */
		super.add(new BaseMethod("fromNumOne"){//case11
			public Object call(Object[] arg)  throws IllegalExpressionException{

				int mv_np1 =Integer.valueOf(arg[1].toString()).intValue();	//数字参数1
				int mv_np2 =Integer.valueOf(arg[2].toString()).intValue();	//数字参数2
				String mv_cp1 = (String)arg[3];								//字符参数1
				String txtContent ="";										//返回字段

				//取得arg[0]数据
				txtContent = (String)arg[0];

				//输入字符串中，取n1起始位，n2个字符（n1,n2有为0的，返回原字符串），并将c1中包含的字符全部清除（单个字符清除）。
				if ((mv_np1 != 0) && (mv_np2 != 0)) {
					txtContent = subString(txtContent, mv_np1 - 1,mv_np1 - 1 + mv_np2);
				}
				if (mv_cp1.trim().equals("")) {
					return false;
				}
				for (int i = 0; i < mv_cp1.length(); i++) {
					txtContent = txtContent.replace(mv_cp1.subSequence(i, i + 1), "");
				}

				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 4){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 返回固定值，n1=1，取c2，n1=2，取n2，n1为其他则返回空值。
		 * @param arg[0] 数据内容
		 * @param arg[1] 数字参数1
		 * @param arg[2] 数字参数2
		 * @param arg[3] 字符参数1
		 */
		super.add(new BaseMethod("cOneORTwo"){//case12
			public Object call(Object[] arg)  throws IllegalExpressionException{

				int mv_np1 =Integer.valueOf(arg[1].toString()).intValue();	//数字参数1
				int mv_np2 =Integer.valueOf(arg[2].toString()).intValue();	//数字参数2
				String mv_cp1 = (String)arg[3];								//字符参数1
				String txtContent ="";										//返回字段

				//取得arg[0]数据
				txtContent = (String)arg[0];

				//输入字符串中，取n1起始位，n2个字符（n1,n2有为0的，返回原字符串），并将c1中包含的字符全部清除（单个字符清除）。
				switch (mv_np1) {
				case 1: {
					txtContent = mv_cp1;
					break;
				}
				case 2: {
					txtContent = String.valueOf(mv_np2);
					break;
				}
				default: {
					txtContent = "";
				}
				}
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 4){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 是否为n1的整数倍，是返回c1，否返回c2
		 * @param arg[0] 数据内容
		 * @param arg[1] 数字参数1
		 * @param arg[2] 字符参数1
		 * @param arg[3] 字符参数2
		 */
		super.add(new BaseMethod("booMultiples"){//case13
			public Object call(Object[] arg)  throws IllegalExpressionException{

				int mv_np1 =Integer.valueOf(arg[1].toString()).intValue();	//数字参数1
				String mv_cp1 = (String)arg[2];								//字符参数1
				String mv_cp2 = (String)arg[3];								//字符参数2
				String txtContent ="";										//返回字段

				//取得arg[0]数据
				txtContent = (String)arg[0];

				//是否为n1的整数倍，是返回c1，否返回c2
				try {
					if ((Integer.valueOf(txtContent) % mv_np1) == 0) {
						txtContent = mv_cp1;
					} else {
						txtContent = mv_cp2;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 4){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 取字段的[n1,n2]判断是奇数还是偶数，如果为基数返回c1, 否则返回c2。
		 * @param arg[0] 行数据内容
		 * @param arg[1] List中项目号
		 * @param arg[2] 数字参数1
		 * @param arg[3] 数字参数2
		 * @param arg[4] 字符参数1
		 * @param arg[5] 字符参数2
		 */
		super.add(new BaseMethod("oddOrEven"){//case16
			public Object call(Object[] arg)  throws IllegalExpressionException{

				int mv_np1 =Integer.valueOf(arg[1].toString()).intValue();	//数字参数1
				int mv_np2 =Integer.valueOf(arg[2].toString()).intValue();	//数字参数2
				String mv_cp1 = (String)arg[3];								//字符参数1
				String mv_cp2 = (String)arg[4];								//字符参数2
				String txtContent ="";										//返回字段
				//取得arg[0]数据
				txtContent = (String)arg[0];

				// 取字段的[n1,n2]判断是奇数还是偶数，如果为基数返回c1, 否则返回c2，（非数字异常则返回空值）。
				try {
					if (txtContent.length() > mv_np2) {
						txtContent = subString(txtContent, mv_np1 - 1,mv_np2 - 1);
					} else {
						txtContent = subString(txtContent, mv_np1 - 1,txtContent.length());
					}

					if ((Integer.valueOf(txtContent) % 2) == 0) {
						txtContent =mv_cp1;
					} else {
						txtContent = mv_cp2;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 5){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[4] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 输入参数取n1起始位，n2个字符（n2为0，则返回原字符串），C1存放原日期格式,，C2存放新日期格式（日期格式必须是由yyyy、mm、dd组成），
		 * 如："yyyy-mm-dd"等如果输入参数不是日期,C1存放对应类型说明: 当前有: excelType
		  * @param arg[0] 数据内容
		 * @param arg[1] 数字参数1
		 * @param arg[2] 数字参数2
		 * @param arg[3] 字符参数1
		 * @param arg[4] 字符参数2
		 */
		super.add(new BaseMethod("dateTypeChange"){//case23
			public Object call(Object[] arg)  throws IllegalExpressionException{

				int mv_np1 =Integer.valueOf(arg[1].toString()).intValue();	//数字参数1
				int mv_np2 =Integer.valueOf(arg[2].toString()).intValue();	//数字参数2
				String mv_cp1 = (String)arg[3];								//字符参数1
				String mv_cp2 = (String)arg[4];								//字符参数2
				String txtContent ="";										//返回字段
				//取得arg[0]数据
				txtContent = (String)arg[0];
				try {
					if (mv_np2 > 0) {
						txtContent = txtContent.substring(mv_np1 - 1,mv_np2 + mv_np1 - 1);
					}
					SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(mv_cp2);
					if ("excelType".equals(mv_cp1)) {
						Calendar df = Calendar.getInstance();
						int iDate = Integer.valueOf(txtContent) - 2;
						df.set(1900, 0, 1);
						int days = df.get(Calendar.DAY_OF_YEAR);
						df.set(Calendar.DAY_OF_YEAR, days + iDate);

						Date date = df.getTime();
						txtContent = simpleDateFormat2.format(date);

					} else {
						SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(mv_cp1);
						txtContent = simpleDateFormat2.format(simpleDateFormat1.parse(txtContent));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 5){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[4] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 输入字符串中，c1中包含的字符串全部清除，c1格式：“字符串1|字符串2……）（可以多个字符清除，字符间的分隔符为“|”）
		 * @param arg[0] 数据内容
		 * @param arg[1 字符参数1
		 */
		super.add(new BaseMethod("clearCOne"){//case24
			public Object call(Object[] arg)  throws IllegalExpressionException{

				String mv_cp1 = (String)arg[1];								//字符参数1
				String txtContent ="";										//返回字段
				//取得arg[0]数据
				txtContent = (String)arg[0];

				// 输入字符串中，c1中包含的字符串全部清除
				try {
					String tmpArr[] = mv_cp1.split("\\|");
					for (int i = 0; i < tmpArr.length; i++) {
						txtContent = txtContent.replace(tmpArr[i], "");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 2){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 将输入的[1,n1]转换为小写字符
		 * @param arg[0] 行数据内容
		 * @param arg[1] List中项目号
		 * @param arg[2] 字符参数1
		 */
		super.add(new BaseMethod("toLowerCase"){//转换为小写，要结合getMapValue一起使用，完成case25
			public Object call(Object[] arg)  throws IllegalExpressionException{

				int mv_np1 =Integer.valueOf(arg[1].toString()).intValue();	//数字参数1
				String txtContent ="";										//返回字段

				//取得arg[0]数据
				txtContent = (String)arg[0];
				try {
					if (txtContent.length() > mv_np1) {
						txtContent = subString(txtContent, 0, mv_np1 - 1);
					}
					//转换为小写
					txtContent = txtContent.toLowerCase();
				} catch (Exception e) {
					e.printStackTrace();
				}
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 2){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 从原来的字符中取从n1开始n2个字符，并将字符转换为大写字符。
		 * @param arg[0] 数据内容
		 * @param arg[1] 数字参数1
		 * @param arg[2] 数字参数2
		 * @param arg[3] 数字参数3
		 */
		super.add(new BaseMethod("toUpperCase"){//case26，case27
			public Object call(Object[] arg)  throws IllegalExpressionException{

				int mv_np1 =Integer.valueOf(arg[1].toString()).intValue();	//数字参数1
				int mv_np2 =Integer.valueOf(arg[2].toString()).intValue();	//数字参数2
				int changeable =Integer.valueOf(arg[3].toString()).intValue();	//数字参数3:1 不做变换 2 字符转换为大写
				String txtContent ="";										//返回字段

				//取得arg[0]数据，从0开始
				txtContent = (String)arg[0];

				try {
					if ((mv_np1 > 0)&& (mv_np2 > 0)&& (txtContent.length() >= (mv_np1 + mv_np2 - 1))) {
						txtContent = subString(txtContent, mv_np1,mv_np1 + mv_np2);
					}
					if( 2 == changeable){//changalbe 值为1时 不做变换,2字符转换为大写
						txtContent = txtContent.toUpperCase();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 4){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 取32位uuid
		 * @param arg[0] 行数据内容
		 */
		super.add(new BaseMethod("uuid"){//case28
			public Object call(Object[] arg)  throws IllegalExpressionException{
				return UUID.randomUUID().toString().replace("-", "");//取guid
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				return arg;
			}
		});

		/**
		 * n1 右端起始位(若第一位开始n1=1)，n2所取字符串位数。
		 * @param arg[0] 数据内容
		 * @param arg[1] 数字参数1
		 * @param arg[2] 数字参数2
		 */
		super.add(new BaseMethod("getTwo"){//case29
			public Object call(Object[] arg)  throws IllegalExpressionException{

				int mv_np1 =Integer.valueOf(arg[1].toString()).intValue();	//数字参数1
				int mv_np2 =Integer.valueOf(arg[2].toString()).intValue();	//数字参数2
				String txtContent ="";										//返回字段

				//取得行数据中第num项数据，从0开始
				txtContent = (String)arg[0];
				//n1 右端起始位(若第一位开始n1=1)，n2所取字符串位数。
				try {
					if(txtContent!=null){
						if(txtContent.length()>mv_np2+mv_np1){
						txtContent = txtContent.substring(txtContent.length()-mv_np2-mv_np1+1,txtContent.length()-mv_np1+1);
						}else{
							txtContent = "";
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 3){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 如果取值不满足长度n1,根据n2（n2=1,在右端补齐；n2=2在左端补齐）c1为所补的字符
		 * @param arg[0] 行数据内容
		 * @param arg[1] 数字参数1
		 * @param arg[2] 数字参数2
		 * @param arg[3] 字符参数1
		 */
		super.add(new BaseMethod("fillOne"){//case30
			public Object call(Object[] arg)  throws IllegalExpressionException{

				int mv_np1 =Integer.valueOf(arg[1].toString()).intValue();	//数字参数1
				int mv_np2 =Integer.valueOf(arg[2].toString()).intValue();	//数字参数2
				String mv_cp1 =(String)arg[3];								//字符参数1
				String txtContent ="";										//返回字段

				//取得arg[0]数据，从0开始
				txtContent = (String)arg[0];

				//如果取值不满足长度n1,根据n2（n2=1,在右端补齐；n2=2在左端补齐）c1为所补的字符
				try {
					if(txtContent != null){
						txtContent = txtContent.trim();
						if (txtContent.length() >= mv_np1) {
							txtContent = subString(txtContent, 0,mv_np1);
						}else{
							int j = txtContent.length();
							for (int i = 0; i < mv_np1 - j; i++) {
								if(mv_np2==1){
									txtContent = txtContent + mv_cp1.trim();
								}else{
									txtContent = mv_cp1.trim() + txtContent;
								}
							}
						}
					}else{
						for (int i = 0; i < mv_np1; i++) {
							txtContent += mv_cp1.trim();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 4){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 取得文件名称子段
		 * @param arg[0] 数据内容
		 * @param arg[1] 数字参数1
		 * @param arg[2] 数字参数2
		 */
		super.add(new BaseMethod("getFileName"){//case31
			public Object call(Object[] arg)  throws IllegalExpressionException{
				TFileDataInfo curImpFileInfo=(TFileDataInfo)arg[0];			//行数据内容
				int mv_np1 =Integer.valueOf(arg[1].toString()).intValue();	//数字参数1
				String txtContent ="";										//返回字段
				//取得行数据中第num项数据，从0开始
				txtContent = curImpFileInfo.getFileName();
				int index = txtContent.indexOf(".");//得到'.'所在的位置
				//取得文件名称的中"."所在位的前mv_np1位
				try {
					if(txtContent!=null){
						if(index - mv_np1 >= 0){
							txtContent = txtContent.substring(index - mv_np1,index);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 3){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 取得机构名称
		 * @param arg[0] 数据内容
		 */
		super.add(new BaseMethod("getDepartID"){//case32
			public Object call(Object[] arg)  throws IllegalExpressionException{
				TFileDataInfo curImpFileInfo=(TFileDataInfo)arg[0];			//行数据内容
				String txtContent ="";										//返回字段
				//取得行数据中第num项数据，从0开始
				txtContent = curImpFileInfo.getDepartId();
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 1){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 取得的项目值为空或者等于字符参数1的内容时，赋值为字符参数2
		 * @param arg[0] 数据内容
		 * @param arg[1] 字符参数1
		 * @param arg[2] 字符参数2
		 */
		super.add(new BaseMethod("isNullToParam"){//case33
			public Object call(Object[] arg)  throws IllegalExpressionException{
//				TFileDataInfo curImpFileInfo=(TFileDataInfo)arg[0];			//行数据内容
				String mv_cp1 = (String)arg[1];
				String mv_cp2 =(String)arg[2];
				String txtContent ="";										//返回字段
				//取得行数据中第num项数据，从0开始
				txtContent = (String)arg[0];
				//取得的项目值等于mv_cp1时或为空时，赋值为mv_cp2
				if( "null".equals(txtContent)|| "".equals(txtContent) || mv_cp1.equals(txtContent)){
					txtContent = mv_cp2;
				}
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 3){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 取得工作日
		 * @param arg[0] 数据内容
		 */
		super.add(new BaseMethod("getWorkDate"){//case34
			public Object call(Object[] arg)  throws IllegalExpressionException{
				TFileDataInfo curImpFileInfo=(TFileDataInfo)arg[0];		//行数据内容
				String txtContent ="";									//返回字段
				//取得行数据中第num项数据，从0开始
				String depart_id = curImpFileInfo.getDepartId();

				List tmpList = (ArrayList) mapWorkDate.get(Integer.parseInt(depart_id));
				Iterator it = tmpList.iterator();
				while (it.hasNext()) {
					Map idmp = (Map) it.next();
					if (depart_id.equals((String) idmp.get("PARAM_ID"))) {
						if (idmp.get("PARAM_VAL") != null) {
							txtContent =  (String) idmp.get("PARAM_VAL");
						}
					}
				}

				if(txtContent == null || txtContent == ""){
					txtContent = "";
				}
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 1){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 取得导入页面交易日期
		 * @param arg[0] 数据内容
		 */
		super.add(new BaseMethod("getTradeDate"){//case34
			public Object call(Object[] arg)  throws IllegalExpressionException{
				TFileDataInfo curImpFileInfo=(TFileDataInfo)arg[0];		//行数据内容
				String txtContent ="";									//返回字段
				//取得行数据中第num项数据，从0开始
				txtContent = curImpFileInfo.getTradeDate();

				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 1){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 取某个字段（1，2或3），参数：n1 n1=1，取字段1的输入。依次类推。 如果n2=1时，将返回值中c1所包含的字符过滤掉
		 * N2=2时，将返回值中的空格符去掉 N2=3时，将返回值中的空格符和c1中所包含的字符过滤掉 C1用|分割
		 * @param arg[0] 取得字段1
		 * @param arg[1] 取得字段2
		 * @param arg[2] 取得字段3
		 * @param arg[3] 数字参数1
		 * @param arg[4] 数字参数2
		 * @param arg[5] 字符参数1
		 */
		super.add(new BaseMethod("getField"){//字段转换函数2，得到最终字段值case1
			public Object call(Object[] arg)  throws IllegalExpressionException{
				String field1=(String)arg[0];			//取得字段1
				String field2=(String)arg[1];			//取得字段2
				String field3=(String)arg[2];			//取得字段3
				int mv_np1 =Integer.valueOf(arg[3].toString()).intValue();	//数字参数1
				int mv_np2 =Integer.valueOf(arg[4].toString()).intValue();	//数字参数2
				String mv_cp1 =(String)arg[5];								//字符参数1
				String txtContent ="";										//返回字段
				try {//参数：n1 n1=1，取字段1的输入。依次类推。
					if ((mv_np1 > 0) && (mv_np1 < 4)) {
						if(mv_np1 ==1){
							txtContent = field1;
						}else if(mv_np1 ==2){
							txtContent = field2;
						}else if(mv_np1 ==3){
							txtContent = field3;
						}
						//如果n2=1时，将返回值中c1所包含的字符过滤掉
						if(mv_np2 == 1){
							String tmpArr[] = mv_cp1.split("\\|");
							for(int i=0;i<tmpArr.length;i++){
								txtContent = txtContent.replaceAll(tmpArr[i], "");
							}
						}
						//N2=2时，将返回值中的空格符去掉
						if(mv_np2==2){
							txtContent = txtContent.replaceAll(" ", "");
						}
						// N2=3时，将返回值中的空格符和c1中所包含的字符过滤掉 C1用|分割
						if(mv_np2==3){
							String tmpArr[] = mv_cp1.split("\\|");
							for(int i=0;i<=tmpArr.length;i++){
								txtContent = txtContent.replaceAll(tmpArr[i], "");
							}
							txtContent = txtContent.replaceAll(" ", "");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length!=6){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[4] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[5] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 取计算结果
		 * @param arg[0] 取得字段1
		 * @param arg[1] 取得字段2
		 * @param arg[2] 取得字段3
		 * @param arg[3] 数字参数1
		 * @param arg[4] 数字参数2
		 * @param arg[5] 字符参数1
		 * @param arg[6] 字符参数2
		 */
		super.add(new BaseMethod("getResult"){//字段转换函数2，得到最终字段值case2
			public Object call(Object[] arg)  throws IllegalExpressionException{
				String field1=(String)arg[0];			//取得字段1
				String field2=(String)arg[1];			//取得字段2
				String field3=(String)arg[2];			//取得字段3
				int mv_np1 =Integer.valueOf(arg[3].toString()).intValue();	//数字参数1
				int mv_np2 =Integer.valueOf(arg[4].toString()).intValue();	//数字参数2
				String mv_cp1 =(String)arg[5];								//字符参数1
				String mv_cp2 =(String)arg[6];								//字符参数2
				String txtContent ="";										//返回字段
				try {
					switch (mv_np1) {
					case 1: { // 如果：字段1=c1，返回c2[1,n2]否则返回c2[n2+1,2*n2]
						if (field1.equals(mv_cp1.trim())) {
							txtContent = subString(mv_cp2, 0,mv_np2);
						} else {
							txtContent = subString(mv_cp2,mv_np2, 2 * mv_np2);
						}
						break;
					}
					case 2: { // 如果：字段1=c1，返回字段2否则返回c2[1,n2]
						if (field1.trim().equals(mv_cp1.trim())) {
							txtContent = field2;
						} else {
							txtContent = subString(mv_cp2, 0,mv_np2);
						}
						break;
					}
					case 3: { // 如果：字段1=c1，返回字段2否则返回字段3
						if (field1.equals(mv_cp1)) {
							txtContent = field2;
						} else {
							txtContent = field3;
						}
						break;
					}
					case 4: { // 如果：字段1=c1[1,n2]且字段2=c1[n2+1,2*n2]，返回'1' ，否则返回'0'
						if (field1.equals(subString(mv_cp1, 0, mv_np2))
								&& field2.equals(subString(mv_cp1, mv_np2, 2 * mv_np2))) {
							txtContent = "1";
						} else {
							txtContent = "0";
						}
						break;
					}
					case 5: { // 如果：字段1=c1[1,n2]或字段2=c1[n2+1,2*n2]，返回'1' ，否则返回'0'
						if (field1.equals(subString(mv_cp1, 0, mv_np2))|| field2.equals(subString(mv_cp1, mv_np2, 2 * mv_np2))) {
							txtContent = "1";
						} else {
							txtContent = "0";
						}
						break;
					}
					case 6: { // 如果：字段1=c1[1,n2]且字段2=c1[n2+1,2*n2]
						// 且字段3=c1[2*n2+1,3*n2]返回'1' ，否则返回'0'
						if (field1.equals(subString(mv_cp1, 0, mv_np2))&& field2.equals(subString(mv_cp1, mv_np2, 2 * mv_np2))
							&& field2.equals(subString(mv_cp1, 2 * mv_np2, 3 * mv_np2))) {
							txtContent = "1";
						} else {
							txtContent = "0";
						}
						break;
					}
					case 7: { // 如果：字段1=c1[1,n2]或字段2=c1[n2+1,2*n2]
						// 或字段3=c1[2*n2+1,3*n2]返回'1' ，否则返回'0'
						if (field1.equals(subString(mv_cp1, 0, mv_np2))|| field2.equals(subString(mv_cp1, mv_np2, 2 * mv_np2))
							|| field2.equals(subString(mv_cp1, 2 * mv_np2, 3 * mv_np2))) {
							txtContent = "1";
						} else {
							txtContent = "0";
						}
						break;
					}
					case 8: { // 如果：字段1=c1[1,n2]且字段2=c1[n2+1,2*n2]，返回字段3，否则返回c2
						if (field1.equals(subString(mv_cp1, 0, mv_np2)) && field2.equals(subString(mv_cp1, mv_np2, 2 * mv_np2))) {
							txtContent = field3;
						} else {
							txtContent = mv_cp2;
						}
						break;
					}
					case 9: { // 如果：字段1=c1[1,n2]或字段2=c1[n2+1,2*n2]，返回字段3，否则返回c2。
						if (field1.equals(subString(mv_cp1, 0, mv_np2))|| field2.equals(subString(mv_cp1, mv_np2, 2 * mv_np2))) {
							txtContent = field3;
						} else {
							txtContent = mv_cp2;
						}
						break;
					}
					case 10: { // 字段1=c1，字段2不为空，则返回字段2；字段2为空，则返回字段3。
						if (field1.equals(mv_cp1)) {
							if (!field2.trim().equals("")) {
								txtContent = field2;
							} else {
								txtContent = field3;
							}
						} else {
							txtContent = "";
						}
						break;
					}
					case 11: { // 字段1不为空，则返回字段1
						if (!field1.trim().equals("")) {
							txtContent = field1;
						}
						break;
					}
					case 12: { // 如果字段1不为空则返回字段1；如果字段1为空且字段2等于c1则返回字段3；否则返回空
						if (!field1.trim().equals("")) {
							txtContent = field1;
						} else if (field2.equals(mv_cp1)) {
							txtContent = field3;
						} else {
							txtContent = "";
						}
						break;
					}
					case 13: { // 如果字段1不为空则返回字段1；如果字段1为空、字段2不等于c1，则返回空；
						// 如果字段1为空、字段2等于c1、字段3为空，则返回空；如果字段1为空、字段2
						// 等于c1、字段3不为空，则返回c2
						if (!field1.trim().equals("")) {
							txtContent = field1;
						} else if (!field2.equals(mv_cp1)) {
							txtContent = "";
						} else if (field3.trim().equals("")) {
							txtContent = "";
						} else {
							txtContent = mv_cp2;
						}
						break;
					}
					case 14: { // 如果字段1等于字段2或者字段2为@通配开始，则返回字段3，否则返回空
						if (field2.trim().equals("@")) {
							txtContent = field3;
						} else if (field1
								.equals(field2)) {
							txtContent = field3;
						} else {
							txtContent = "";
						}
						break;
					}
					case 15: { // 如果：字段1小于等于c1，返回字段2否则返回字段3
						if (Double.valueOf(field1.trim())>Double.valueOf(mv_cp1.trim())) {
							txtContent = field3;
						} else {
							txtContent = field2;
						}
						break;
					}
					case 16: { // 如果：字段1=c1，返回字段2否则返回字段3
						if (field1.trim().equals(mv_cp1.trim())) {
							txtContent = field2.trim();
						} else {
							txtContent = field3.trim();
						}
						break;
					}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 7){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[4] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[5] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[6] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 以某种格式拼接3个字段
		 * @param arg[0] 取得字段1
		 * @param arg[1] 取得字段2
		 * @param arg[2] 取得字段3
		 * @param arg[3] 字符参数1
		 */
		super.add(new BaseMethod("connectField"){//字段转换函数2，得到最终字段值case3
			public Object call(Object[] arg)  throws IllegalExpressionException{
				String field1=(String)arg[0];			//取得字段1
				String field2=(String)arg[1];			//取得字段2
				String field3=(String)arg[2];			//取得字段3
				String mv_cp1 =(String)arg[3];			//字符参数1
				String txtContent ="";					//返回字段
				try {//拼接3个字段
					txtContent = String.format(mv_cp1, field1,field2,field3);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length!=4){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 字段1=c1，且字段2不等于c2，满足条件的返回字段3，否则返回n1
		 * 其中c2的值支持穷举，如果多值的时候，值之间以’|”分割, 如aa|bb|cc|
		 * @param arg[0] 取得字段1
		 * @param arg[1] 取得字段2
		 * @param arg[2] 取得字段3
		 * @param arg[3] 数字参数1
		 * @param arg[4] 数字参数2
		 * @param arg[5] 字符参数1
		 */
		super.add(new BaseMethod("getChangeField"){//字段转换函数2，得到最终字段值case7
			public Object call(Object[] arg)  throws IllegalExpressionException{
				String field1=(String)arg[0];			//取得字段1
				String field2=(String)arg[1];			//取得字段2
				String field3=(String)arg[2];			//取得字段3
				int mv_np1 =Integer.valueOf(arg[3].toString()).intValue();	//数字参数1
				String mv_cp1 =(String)arg[4];								//字符参数1
				String mv_cp2 =(String)arg[5];								//字符参数1
				String txtContent ="";										//返回字段
				try {//字段1=c1，且字段2不等于c2，满足条件的返回字段3，否则返回n1
					if (field1.equals(mv_cp1)&& mv_cp2.indexOf(field2) == -1) {
						txtContent = field3;
					} else {
						txtContent = String.valueOf(mv_np1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 6){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[4] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[5] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 字段1转化为number后 >、< 、>=、<= n1,
		 * (<,>,>=.<=存放在c1中) 且字段2=c2, 返回字段3, 否则返回空
		 * @param arg[0] 取得字段1
		 * @param arg[1] 取得字段2
		 * @param arg[2] 取得字段3
		 * @param arg[3] 数字参数1
		 * @param arg[4] 字符参数1
		 * @param arg[5] 字符参数2
		 */
		super.add(new BaseMethod("field3ORNot"){//字段转换函数2，得到最终字段值case8
			public Object call(Object[] arg)  throws IllegalExpressionException{
				String field1=(String)arg[0];			//取得字段1
				String field2=(String)arg[1];			//取得字段2
				String field3=(String)arg[2];			//取得字段3
				int mv_np1 =Integer.valueOf(arg[3].toString()).intValue();	//数字参数1
				String mv_cp1 =(String)arg[4];								//字符参数1
				String mv_cp2 =(String)arg[5];								//字符参数2
				String txtContent ="";										//返回字段
				try {//字段1转化为number后 >、< 、>=、<= n1,且字段2=c2, 返回字段3, 否则返回空
					field1 = field1.replace(",", "");
					long liTmp = Long.valueOf(field1);
					if (mv_cp1.trim().equals("<")) {
						if ((liTmp < mv_np1)&& (field2.equals(mv_cp2))) {
							txtContent = field3;
						} else {
							txtContent = "";
						}
					} else if (mv_cp1.trim().equals(">")) {
						if ((liTmp > mv_np1)&& (field2.equals(mv_cp2))) {
							txtContent = field3;
						} else {
							txtContent = "";
						}
					} else if (mv_cp1.trim().equals(">=")) {
						if ((liTmp >= mv_np1)
								&& (field2.equals(mv_cp2))) {
							txtContent = field3;
						} else {
							txtContent = "";
						}
					} else if (mv_cp1.trim().equals("<=")) {
						if ((liTmp <= mv_np1)
								&& (field2.equals(mv_cp2))) {
							txtContent = field3;
						} else {
							txtContent = "";
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length!=6){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[4] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[5] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 对字段1和字段2转化为float后根据c2+、-、*、\,然后转换成number后乘以n2,然后根据字段3的值和c1定义的格式返回
		 * @param arg[0] 取得字段1
		 * @param arg[1] 取得字段2
		 * @param arg[2] 取得字段3
		 * @param arg[3] 数字参数1
		 * @param arg[4] 字符参数1
		 * @param arg[5] 字符参数2
		 */
		super.add(new BaseMethod("changeByFloat"){//字段转换函数2，得到最终字段值case10
			public Object call(Object[] arg)  throws IllegalExpressionException{
				String field1=(String)arg[0];			//取得字段1
				String field2=(String)arg[1];			//取得字段2
				String field3=(String)arg[2];			//取得字段3
				int mv_np1 =Integer.valueOf(arg[3].toString()).intValue();	//数字参数1
				String mv_cp1 =(String)arg[4];								//字符参数1
				String mv_cp2 =(String)arg[5];								//字符参数2
				String txtContent ="";										//返回字段
				Double lexTmp = 0.0;
				Double lexTmp2 = 0.0;
				//根据n2和c1定义的返回格式返回
				try{
					try {
						lexTmp = Double.valueOf(field1);
					} catch (Exception e) {
						lexTmp = 0.0;
					}
					try {
						lexTmp2 = Double.valueOf(field2);
					} catch (Exception e) {
						lexTmp2 = 0.0;
					}
					if (mv_cp2.trim().equals("+")) {
						lexTmp = lexTmp + lexTmp2;
					} else if (mv_cp2.trim().equals("-")) {
						lexTmp = lexTmp - lexTmp2;
					} else if (mv_cp2.trim().equals("*")) {
						lexTmp = lexTmp * lexTmp2;
					} else if (mv_cp2.trim().equals("/")) {
						if (lexTmp2 == 0) {
							lexTmp = 0.0;
						} else {
							lexTmp = lexTmp / lexTmp2;
						}
					}

					DecimalFormat df = new DecimalFormat("#.######");
					txtContent = df.format(lexTmp * mv_np1).trim();
					df = null;

					if (mv_cp1.trim().equals("01")) {
						// 直接返回number
					} else if (mv_cp1.trim().equals("02")) {
						// 返回左对齐
						txtContent = String.valueOf(Math.round(lexTmp * mv_np1));
						if (txtContent.length() >= Integer.valueOf(field3)) {
							txtContent = subString(txtContent, 0, Integer.valueOf(field3));
						} else {
							txtContent = String.valueOf(Math.round(lexTmp * mv_np1));
							int j = txtContent.length();
							for (int i = 0; i < Integer
									.valueOf(field3)
									- j; i++) {
								txtContent = txtContent + " ";
							}
						}
					} else if (mv_cp1.trim().equals("03")) {
						// 返回前补0
						txtContent = String.valueOf(Math.round(lexTmp * mv_np1));
						if (txtContent.length() >= Integer
								.valueOf(field3)) {
							txtContent = subString(txtContent, 0, Integer
									.valueOf(field3));
						} else {
							int j = txtContent.length();
							for (int i = 0; i < Integer
									.valueOf(field3)
									- j; i++) {
								txtContent = "0" + txtContent;
							}
						}
					} else if (mv_cp1.trim().equals("04")) {
						// 返回右对齐
						txtContent = String.valueOf(Math.round(lexTmp * mv_np1));
						if (txtContent.length() >= Integer
								.valueOf(field3)) {
							txtContent = subString(txtContent, 0, (int) Integer
									.valueOf(field3));
						} else {
							int j = txtContent.length();
							for (int i = 0; i < Integer
									.valueOf(field3)
									- j; i++) {
								txtContent = " " + txtContent;
							}
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length!=6){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[4] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[5] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});


		/**
		 * 将字段1、字段2、字段3，根据C1中设置的运算符
		 *对三个字段进行同一运算。若某字段未设置或为空或非数字，则根据运算符，+/-赋默认值0，乘除赋默认值1，再进行运算
		 * @param arg[0] 取得字段1
		 * @param arg[1] 取得字段2
		 * @param arg[2] 取得字段3
		 * @param arg[3] 字符参数1
		 */
		super.add(new BaseMethod("sameOperator"){//字段转换函数2，得到最终字段值case12
			public Object call(Object[] arg)  throws IllegalExpressionException{
				String field1=(String)arg[0];			//取得字段1
				String field2=(String)arg[1];			//取得字段2
				String field3=(String)arg[2];			//取得字段3
				String mv_cp1 =(String)arg[3];			//字符参数1
				String txtContent ="";					//返回字段
				Double lexTmp = 0.0;
				try {
					if ((!mv_cp1.trim().equals("+")) && (!mv_cp1.trim().equals("-"))&& (!mv_cp1.trim().equals("*")) && (!mv_cp1.trim().equals("/"))) {
						return false;
					}
					double lexTmp2 = 0.0;

					String []field = {field1,field2,field3};
					for (int i = 0; i <= 2; i++) {
						try {
							lexTmp = Double.valueOf(field[i]);
						} catch (Exception ex) {
							if ((mv_cp1.trim().equals("+")) || (mv_cp1.trim().equals("-"))) {
								lexTmp = 0.0;
							} else {
								lexTmp = 1.0;
							}
							if (i == 1) {
								lexTmp2 = lexTmp;
							} else {
								if (mv_cp1.trim().equals("+")) {
									lexTmp2 = lexTmp2 + lexTmp;
								} else if (mv_cp1.trim().equals("-")) {
									lexTmp2 = lexTmp2 - lexTmp;
								} else if (mv_cp1.trim().equals("*")) {
									lexTmp2 = lexTmp2 * lexTmp;
								} else if (mv_cp1.trim().equals("/")) {
									lexTmp2 = lexTmp2 / lexTmp;
								}
							}
						}
					}
						txtContent = String.valueOf(lexTmp2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length!=4){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 如果字段1不为空则返回字段1；如果字段1为空、字段2不等于c1，则返回空； 如果字段1为空、字段2等于c1、字段3为空，则返回空；如果字段1为空、字段2等于c1、字段3不为空，则返回c2
		 * @param arg[0] 取得字段1
		 * @param arg[1] 取得字段2
		 * @param arg[2] 取得字段3
		 * @param arg[5] 字符参数1
		 */
		super.add(new BaseMethod("chooseField"){//字段转换函数2，得到最终字段值case3
			public Object call(Object[] arg)  throws IllegalExpressionException{
				String field1=(String)arg[0];			//取得字段1
				String field2=(String)arg[1];			//取得字段2
				String field3=(String)arg[2];			//取得字段3
				String mv_cp1 =(String)arg[3];			//字符参数1
				String txtContent ="";					//返回字段
				try {//拼接3个字段
					if(field1 != null){//如果字段1不为空则返回字段1
						txtContent = field1;
					}else if(field2 != mv_cp1){
						txtContent = "";
					}else if(field3 == null){
						txtContent = "";
					}else{
						txtContent = field2;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length!=4){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});

		/**
		 * 如果字段1等于字段2或者字段2为@通配开始，则返回字段3，否则返回空
		 * @param arg[0] 取得字段1
		 * @param arg[1] 取得字段2
		 * @param arg[2] 取得字段3
		 */
		super.add(new BaseMethod("backThreeOrNull"){//字段转换函数2，得到最终字段值case3
			public Object call(Object[] arg)  throws IllegalExpressionException{
				String field1=(String)arg[0];			//取得字段1
				String field2=(String)arg[1];			//取得字段2
				String field3=(String)arg[2];			//取得字段3
				String txtContent ="";					//返回字段
				try {
					if(field1 == field2 || field2.trim().equals("@")){//如果字段1等于字段2或者字段2为@通配开始，则返回字段3，否则返回空
						txtContent = field3;
					}else {
						txtContent = "";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				//内容为null时，赋为空值
				txtContent = replaceNull(txtContent);
				return txtContent;
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 3){
					throw new IllegalExpressionException("参数个数不正确");
				}
				if(arg[0] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return arg[0];
			}
		});


		/**
		 * 过滤方法定义
		 */
		super.add(new BaseMethod("check"){//1-->不过滤,导入，0-->过滤，不导入，-1-->错误
			public Object call(Object[] arg)  throws IllegalExpressionException {
				int type_way =Integer.valueOf(arg[1].toString()).intValue();	//检查方式
				String mv_cp1 = (String)arg[4];								//字符参数1
				String mv_cp2 = (String)arg[5];								//字符参数2
				int flg = 0;

				if(arg[0] instanceof String){
					String tempValue=(String)arg[0];
					switch(type_way){
						case 1: {//X=参数1
							if (!tempValue.equals(mv_cp1))
								flg =  1;
							break;
						}
						case 2: {//参数1包含X
							if (mv_cp1.indexOf(tempValue) != -1)
								flg =  1;
							break;
						}
						case 3: {//参数1 < X < 参数2
							if ((tempValue.compareTo(mv_cp1) > 0) && (tempValue.compareTo(mv_cp2) < 0))
								flg =  1;
							break;
						}
						case 4: {//参数1 <= X < 参数2
							if ((tempValue.compareTo(mv_cp1) >= 0) && (tempValue.compareTo(mv_cp2) < 0))
								flg =  1;
							break;
						}
						case 5: {//参数1 < X <= 参数2
							if ((tempValue.compareTo(mv_cp1) > 0) && (tempValue.compareTo(mv_cp2) <= 0))
								flg =  1;
							break;
						}
						case 6: {//参数1 <= X <= 参数2
							if ((tempValue.compareTo(mv_cp1) >= 0) && (tempValue.compareTo(mv_cp2) <= 0))
								flg =  1;
							break;
						}
						case 7: {// X = workday
							if (tempValue.equals("20101209"))//应该为workday,目前暂时写为定值
								flg =  1;
							break;
						}
						case 8: {// X中不包含参数1
							if (tempValue.indexOf(mv_cp1) == -1)//应该为workday,目前暂时写为定值
								flg =  1;
							break;
						}
						default: {
							return -1;
						}
					}
				}else if(arg[0] instanceof Double){
					Double tempValue = (Double)arg[0];
					Double mv_np1 = (Double)arg[2];		//数字参数1
					Double mv_np2 = (Double)arg[3];		//数字参数2
					switch (type_way) {
						case 1: { // X<>参数1
							if (tempValue != mv_np1)
								flg =  1;
							break;
						}
						case 2: { // X=参数1
							if (tempValue == mv_np1)
								flg =  1;
							break;
						}
						case 3: { // 参数1<X<参数2
							if ((tempValue > mv_np1) && (tempValue < mv_np2))
								flg =  1;
							break;
						}
						case 4: { // 参数1<=X<参数2
							if ((tempValue >= mv_np1) && (tempValue < mv_np2))
								flg =  1;
							break;
						}
						case 5: { // 参数1<X<=参数2
							if ((tempValue > mv_np1) && (tempValue <= mv_np2))
								flg =  1;
							break;
						}
						case 6: { // 参数1<=X<=参数2
							if ((tempValue >= mv_np1) && (tempValue <= mv_np2))
								flg =  1;
							break;
						}
//							case 7: { // 已存在记录的美元金额<X  这个还需要更改，有读表操作
//								if (tempValue > ldDollarAmount) {
//									return 1;
//								}
//								break;
//							}
						default: {
							return -1;
						}
					}
				}
				if( flg == 1){
					return 1;
				}else{
					return 0;
				}
			}
			//传入参数个数与类型验证
			public Object compile(Object[] arg)  throws IllegalExpressionException{
				if(arg.length != 6){
					throw new IllegalExpressionException("参数个数不够");
				}
				if(arg[0] instanceof String){

				}else if(arg[0] instanceof Double){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[1] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[2] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[3] instanceof Integer){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[4] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				if(arg[5] instanceof String){

				}else{
					throw new IllegalExpressionException("参数类型不正确");
				}
				return (String)arg[0];
			}
		});
	}



	/**
	 * 替换空对象
	 * @param str传入的字符串 *
	 * @return
	 */
	private String replaceNull(String str) {
		if (str == null) {
			return "";
		} else {
			return str;
		}
	}

}
