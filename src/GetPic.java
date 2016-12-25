import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetPic {
	// public static void main(String[] args) throws Exception {
	// new Questions().GetQuestions("https://www.zhihu.com/question/24861635");
	// }

	ArrayList<String> GetPics(String url) throws Exception {

		String result = null;
		ArrayList<String> Questions = new ArrayList<String>();
		result = new GetHtml().gethtml(url);
		// System.out.println(result);
		Pattern urlPattern = Pattern.compile("data-actualsrc=\"(.*?)\">");
		Matcher urlMatcher = urlPattern.matcher(result);
		// 是否存在匹配成功的对象
		boolean isFind = urlMatcher.find();
		while (isFind) {
			// System.out.println(urlMatcher.group(0));
			String PicUrl = new Utill().stringSub(urlMatcher.group(0), "data-actualsrc=\"", "\">");
			Questions.add(PicUrl);
			isFind = urlMatcher.find();
		}
		// System.out.println(Questions);
		return Questions;
	}
}
