/*
 * @author:�ܺ���
 * 2016��12��24��
 */
import java.util.ArrayList;
import java.util.Iterator;
public class Main {
	static int page=1;
	public static void main(String[] args) throws Exception {
		
		ArrayList<String> pic;
		int id =0;
		String coll = "https://www.zhihu.com/collection/69641719?page="+page ;
		
		while(!new GetHtml().gethtml(coll).contains("���ղؼл�û���κ�����")){
			coll = "https://www.zhihu.com/collection/69641719?page="+page ;
			ArrayList<String> question = new GetQuestions().getquestions(coll);
			Iterator<String> i1 = question.iterator();
			while(i1.hasNext()){
				String QuestionUrl = i1.next();
				pic = new GetPic().GetPics(QuestionUrl);
				String name = new GetName().getname( QuestionUrl);
				
				Iterator<String> i2 = pic.iterator();
				while (i2.hasNext()) {
					// System.out.println(i1.next());
					new LoadPic().loadpic(i2.next(), id,name);
					Thread.sleep(500);
					id+=1;
				}
				id=0;
			//	System.out.println(i.next());
			}
			page++;
			System.out.println("���ص�"+page+"ҳ������");
		}
		System.out.println("���ؽ�����");
	}
	
}
