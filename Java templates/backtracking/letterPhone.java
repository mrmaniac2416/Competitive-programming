public class Solution {
    private HashMap<String, String> map = new HashMap<String, String>();
	public ArrayList<String> letterCombinations(String a) {
	    map.put("0","0");
	    map.put("1","1");
	    map.put("2","abc");
	    map.put("3","def");
	    map.put("4","ghi");
	    map.put("5","jkl");
	    map.put("6","mno");
	    map.put("7","pqrs");
	    map.put("8","tuv");
	    map.put("9","wxyz");
        ArrayList<String> answer = new ArrayList<String>();
        generateAnswer(answer, a, a.length(), 0, "");
        return answer;
	}
	private void generateAnswer(ArrayList<String> answer, String a, int answerLength, int pos, String probableAnswer) {
	    if(probableAnswer.length() == answerLength) {
	        answer.add(probableAnswer);
	        return;
	    }
	    String alphabetsForPos = map.get( ""+a.charAt(pos));
	    for(int i=0; i<alphabetsForPos.length();i++) {
	        String iterChar = ""+alphabetsForPos.charAt(i);
	        generateAnswer(answer, a, answerLength, pos+1, probableAnswer+iterChar);
	    }
	}
}