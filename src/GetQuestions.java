import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetQuestions {
//	public static void main(String[] args) throws Exception {
//		new GetQuestions().getquestions("https://www.zhihu.com/collection/69641719?page=1");
//	}

	ArrayList<String> getquestions(String url) throws Exception {
		String result = null;
		ArrayList<String> collections = new ArrayList<String>();
		result = new GetHtml().gethtml(url);
		// System.out.println(result);
		Pattern urlPattern = Pattern.compile("itemprop=\"url\" href=\"/question/.+?>(.+?)");
		Matcher urlMatcher = urlPattern.matcher(result);
		// 是否存在匹配成功的对象
		boolean isFind = urlMatcher.find();
		while (isFind) {
			// System.out.println(urlMatcher.group(0));
			String num = new Utill().stringSub(urlMatcher.group(0), "itemprop=\"url\" href=\"/question/", "/answer/");
			collections.add("https://www.zhihu.com/question/" + num);
			// System.out.println(urlMatcher.group(0));
			// System.out.println(new Utill().stringSub(urlMatcher.group(0),
			// "itemprop=\"url\" href=\"/question/", "/answer/"));

			isFind = urlMatcher.find();
		}
		// System.out.println(collections);
		return collections;
	}

}
