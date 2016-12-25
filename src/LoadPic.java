import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class LoadPic {
	void loadpic(String url, int id, String name) {
		try {
			URL RealUrl = new URL(url);

			URLConnection conn = RealUrl.openConnection();
			File f = new File("d:/Pictures/" + name);
			if (!f.exists()) {
				f.mkdirs();
			}
			byte[] byteBuffer = new byte[4096];
			InputStream is = conn.getInputStream();
			// System.out.println(f.getAbsolutePath());
			FileOutputStream fos = new FileOutputStream(f.getAbsolutePath() + "/" + id + ".jpg");
			int len = 0;
			int off = 0;
			while ((len = is.read(byteBuffer)) != -1) {
				fos.write(byteBuffer, off, len);
			}
			is.close();
			fos.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
