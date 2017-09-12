package test.com.buffer;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.service.message.BufferImpl;

public class DemoBuffer  {
		
	@Test
	public void testNorml() throws Exception {	
		ApplicationContextUtils.init("test/com/buffer/PersonNorml.xml");
	    BufferImpl bufferImplNormal = (BufferImpl) ApplicationContextUtils.getBean("Person");
		Map childBuffers= new HashMap();
		childBuffers.put("age", "23");
		childBuffers.put("name","tangnian");
		childBuffers.put("addr", "people squ");
		childBuffers.put("work", "it people");
		childBuffers.put("sex", "man");	
		//导入数据
		bufferImplNormal.loadObject(childBuffers);	
		//根据配置好的生成字符串
		String sbuffer=bufferImplNormal.outputString();
		PrintStream pout = null ;
		//输出重定向
		pout = new PrintStream("e:/personNorml.xml");
		System.setOut(pout);
		System.out.println("<?xml version='1.0' encoding='UTF-8'?>");
		System.out.println(sbuffer);		
	}
	
	@Test
    public void  testMap() throws Exception{
		ApplicationContextUtils.init("test/com/buffer/PersonMap.xml");
		BufferImpl arrayImplMap = (BufferImpl) ApplicationContextUtils.getBean("Person");
	    Map sister=new HashMap();
		sister.put("sisterAge", "30");
		sister.put("sisterName","xiaoyu");
		sister.put("sisterAddr", "guilinlu");
		sister.put("work", "sales");
		List sisterlist=new ArrayList();
		sisterlist.add(sister);

		Map childBuffers= new HashMap();
		childBuffers.put("age", "23");
		childBuffers.put("name","tangnian");
		childBuffers.put("addr", "people squ");
		childBuffers.put("work", "it people");
		childBuffers.put("sex", "man");	
		childBuffers.put("sister", sisterlist);
				
		//导入数据
		arrayImplMap.loadObject(childBuffers);	
		//根据配置好的生成字符串
		String sbuffer=arrayImplMap.outputString();
		PrintStream pout = null ;
		//输出重定向
		pout = new PrintStream("e:/personMap.xml");
		System.setOut(pout);
		System.out.println("<?xml version='1.0' encoding='UTF-8'?>");
		System.out.println(sbuffer);		
				
    }		
}
