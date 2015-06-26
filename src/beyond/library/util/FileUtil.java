package beyond.library.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 文件处理
 * @author Administrator
 *
 */
public class FileUtil {

	/**
	 * 文件加载
	 * @param Path 把加载文件到的路径
	 * @param File 将要加载的文件
	 * @param Name 文件名
	 */
	public static void Upload(String Path, File File, String Name) {
		try {
			InputStream is = new FileInputStream(File);
			File uploadFile = new File(Path, Name);
			OutputStream os = new FileOutputStream(uploadFile);
			byte[] buffer = new byte[1024 * 1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
