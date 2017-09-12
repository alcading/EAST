package com.huateng.report.utils;

public class ReportEnum {
	public static enum COMB_TYPE{
		LEFT("01", "字母+数字"), RIGHT("02", "数字+字母"),NO("03","不包含字母");
		public String value;
		public String name;

		private COMB_TYPE(String value, String name) {
			this.value = value;
			this.name = name;
		}
	}

	/**
	 * 对公对私号码映射
	 * @author NING-PENG
	 *
	 */
	public static enum CUS_TYPE_MAPPING{
		C("C","C"),D("D","D"),F("F","D");
		public String value;
		public String name;

		private CUS_TYPE_MAPPING(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}
	}


	public static enum REPORT_FILE_INOUT{
		IN("IN", "输入"), OUT("OUT", "输出");
		public String value;
		public String name;

		private REPORT_FILE_INOUT(String value, String name) {
			this.value = value;
			this.name = name;
		}
	}

	public static enum REPORT_ANALY_CONF_RETTYPE {
		NORET("0","无返回"),RET_SET("1","集合列表(out参数)"),RET_VAL("2","单个值(out参数)"),RET_JAVA("3","java对象"),RET_LIST("4","集合列表(select形式)");
		public String value;
		public String name;

		private REPORT_ANALY_CONF_RETTYPE(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}
	}


	public static enum REPORT_ANALY_CONF_TYPE {
		JAVA("01","java类"),PROC("02","存储过程"),BATCH("03","批量");
		public String value;
		public String name;

		private REPORT_ANALY_CONF_TYPE(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}
	}


	public static enum REPORT_ANALY_STAUS {
		NOEXEC("00","未执行"),EXEC("01","执行中"),COMPLTE("02","已完成");
		public String value;
		public String name;

		private REPORT_ANALY_STAUS(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}
	}

	public static enum REPORT_ANALY_RESULT {
		EXEC("00","执行中"),NOEXEC("03","未执行"),SUCCESS("01","执行成功"),FAILD("02","执行失败");
		public String value;
		public String name;

		private REPORT_ANALY_RESULT(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}
	}

	public static enum REPORT_RESULT {
		SUCCESS("01", "成功"), FAILD("02", "失败");
		public String value;
		public String name;

		private REPORT_RESULT(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}
	}

	public static enum REPORT_VAILD {
		YES("1", "有效"), NO("0", "无效");
		public String value;
		public String name;

		private REPORT_VAILD(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}
	}

	public static enum REPORT_REC_LOCK_DEL {
		F("F", "false"), T("T", "true");
		public String value;
		public String name;

		private REPORT_REC_LOCK_DEL(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}
	}
	public static enum REPORT_ST1 {
		CR("1", "创建中"), ET("2", "修改中"),DE("3","删除中"),Y("4","有效"),N("5","无效");
		public String value;
		public String name;

		private REPORT_ST1(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}
	}
	public static enum REPORT_IS {
		YES("Y", "是"), NO("N", "否");
		public String value;
		public String name;

		private REPORT_IS(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}
	}

	public static enum REPORT_IS_STR {
		YES("1", "是"), NO("0", "否");
		public String value;
		public String name;

		private REPORT_IS_STR(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}
	}

	public static enum REPORT_ERR_TYPE {
		NO_ERR("00", "无错误"), FORMAT_ERR("01", "格式错误"), REC_ERR("02", "记录错误");
		public String value;
		public String name;

		private REPORT_ERR_TYPE(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}
	}

	public static enum REPORT_IMP_FILE_ERR_TYPE {
		NO_ERR("01", "无错误"), NO_DATA_ERR("02", "未执行导入"), IMP_ERR("03", "导出有错误");
		public String value;
		public String name;

		private REPORT_IMP_FILE_ERR_TYPE(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}
	}

	/**
	 * 复核功能代码
	 * @author NING-PENG
	 *
	 */
	public static enum REPORT_TASK_FUNCID {
		TASK_100899("100899", "安全参数设置"),TASK_100199("100199", "机构管理"), TASK_100299("100299", "角色管理"), TASK_100399("100399", "用户管理"), TASK_100599(
				"100599", "工作日期维护"), TASK_100799("100799", "系统参数设置"), TASK_110199("110199", "币种信息维护"), TASK_110499(
				"110499", "国家/地区代码维护"), TASK_110599("110599", "外汇月牌价维护"), TASK_110699("110699", "外汇日牌价维护");
		public String value;
		public String name;

		private REPORT_TASK_FUNCID(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}
	}

	/**
	 * 操作说明类型
	 * @author jianxue.zhang
	 *
	 */
	public static enum REPORT_TASK_TRANS_CD{
		NEW("01","创建"),
		EDIT("02","编辑"),
		DEL("03","删除"),
		RESETPWD("00", "重置密码");
		public String value;
		public String name;

		private REPORT_TASK_TRANS_CD(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}
	}
	/**
	 * 操作说明类型
	 * @author jianxue.zhang
	 *
	 */
	public static enum REPORT__FH_ST{
		YES("4","记录有效"),
		NO("5","记录无效");
		public String value;
		public String name;

		private REPORT__FH_ST(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}
	}

	/**
	 * 在导数时用于区分是否对私
	 *
	 */
	public static enum REPORT_RESIDENTS {

		RESIDENTS_700("700","对私"),
		RESIDENTS_701("701","对私"),
		RESIDENTS_702("702","对私"),
		RESIDENTS_703("703","对私"),
		RESIDENTS_704("704","对私"),
		RESIDENTS_705("705","对私"),
		RESIDENTS_720("720","对私"),
		RESIDENTS_721("721","对私"),
		RESIDENTS_722("722","对私"),
		RESIDENTS_723("723","对私");


		public String value;
		public String name;

		private REPORT_RESIDENTS(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String valueof(String value) {
			for (int i = 0; i < values().length; i++) {
				if (values()[i].value.equals(value)) {
					return values()[i].name;
				}
			}
			return value;
		}

	}

}
