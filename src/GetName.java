import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetName {
//	public static void main(String[] args) throws Exception {
//		new GetName().getname("https://www.zhihu.com/question/53620623");
//	}

	String getname(String url) throws Exception {
		String result = null;
		URL realurl;
		String name = null;
		realurl = new URL(url);
		URLConnection conn = realurl.openConnection();
		conn.setRequestProperty("accept", "*/*");
		conn.setRequestProperty("connection", "Keep-Alive");
		conn.setRequestProperty("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0");
		conn.connect();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		String line;
		while ((line = in.readLine()) != null) {
			result += line;
		}
		Pattern urlPattern = Pattern.compile("<span class=\"zm-editable-content\">(.*)</span>");
		Matcher urlMatcher = urlPattern.matcher(result);
		// 是否存在匹配成功的对象
		boolean isFind = urlMatcher.find();
		while (isFind) {
			// System.out.println(urlMatcher.group(0));
			name = new Utill().stringSub(urlMatcher.group(0), "<span class=\"zm-editable-content\">", "</span>");
			// name =
			// urlMatcher.group(0).substring(urlMatcher.group(0).indexOf("<title>"),
			// urlMatcher.group(0).indexOf("?"));
			isFind = urlMatcher.find();
			// System.out.println(name);
		}

		return name;
	}
}
