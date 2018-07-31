import java.util.Scanner;

import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.security.EncryptFactory;
import com.huateng.ebank.framework.security.Md5;
import com.huateng.ebank.framework.security.EncryptFactory.Algorithm;

public class Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);  
        System.out.println("请输入银行卡号：");  
        String bankNo = input.next();  
        char res = getBankCardCheckCode(bankNo.substring(0, bankNo.length()-1));  
        if(res!='N'){  
            System.out.println("校验结果为："+res);  
            String charJX = bankNo.substring(bankNo.length()-1);//存入不含校验位的卡号  
            System.out.println("银行卡的校验位为："+charJX);  
            if(charJX.equals(String.valueOf(res))){  
                System.out.println("银行卡合法！");  
            }else{  
                System.out.println("银行卡不合法！");  
            }  
        }  
	}
	
	public static char getBankCardCheckCode(String nonCheckCodeCardId){    
        if(nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0    
                || !nonCheckCodeCardId.matches("\\d+")||nonCheckCodeCardId.trim().length()<15  
                ||nonCheckCodeCardId.trim().length()>18) {    
            //如果传的数据不合法返回N    
            System.out.println("银行卡号不合法！");  
            return 'N';  
        }    
        char[] chs = nonCheckCodeCardId.trim().toCharArray();    
        int luhmSum = 0;   
        // 执行luh算法  
        for(int i = chs.length - 1, j = 0; i >= 0; i--, j++) {    
            int k = chs[i] - '0';    
            if(j % 2 == 0) {  //偶数位处理  
                k *= 2;    
                k = k / 10 + k % 10;    
            }    
            luhmSum += k;               
        }    
        return (luhmSum % 10 == 0) ? '0' : (char)((10 - luhmSum % 10) + '0');    
    }    

}
