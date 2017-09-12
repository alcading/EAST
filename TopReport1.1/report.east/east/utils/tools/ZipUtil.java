package east.utils.tools;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class ZipUtil {

	public static void compress(InputStream is, OutputStream os)  
            throws Exception {  
  
        GZIPOutputStream gos = new GZIPOutputStream(os);  
  
        int count;  
        byte data[] = new byte[1024];  
        while ((count = is.read(data, 0, 1024)) != -1) {  
            gos.write(data, 0, count);  
        }  
  
        gos.finish();  
  
        gos.flush();  
        gos.close();  
    }  
	
}

