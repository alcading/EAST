package east.utils.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlUtil {

	public Map<String, String> getSqlMap(){
		Map<String, String> sqlMap = new HashMap<String, String>();
        SAXReader saxReader = new SAXReader();  
        try {
			Document document = saxReader.read(this.getClass().getClassLoader().getResourceAsStream("resources/sql.xml"));
			Element root = document.getRootElement();
			List<Element> rows = root.elements("SQLDATA");
			for (Element element : rows) {
				sqlMap.put(element.elementText("TABLE"), element.elementText("SQL"));
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return sqlMap;
	}
	
	
	private String getLength(String s){
		Pattern p = Pattern.compile("\\d+[.]?\\d?"); 
		Matcher m = p.matcher(s); 
		while(m.find()){
			return m.group();
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		XmlUtil util = new XmlUtil();
//		List<Map<String, String>> list = util.generateFieldInfo();
//		for (Map<String, String> map : list) {
//			System.out.println(map.toString());
//		}
//		
//	}
	
}
