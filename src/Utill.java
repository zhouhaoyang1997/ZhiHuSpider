
public class Utill {
	public String stringSub(String completeString, String StartString, String EndString) {
		int StartIndex, EndIndex;
		StartIndex = completeString.indexOf(StartString);
		EndIndex = completeString.indexOf(EndString, StartIndex + StartString.length());
		return completeString.substring(StartIndex + StartString.length(), EndIndex);
	}
}
