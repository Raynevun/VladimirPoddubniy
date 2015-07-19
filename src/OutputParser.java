import java.util.ArrayList;
import java.util.List;

public class OutputParser {

	public List<String> getResults(String outputValue) {
		char[] arrayOfHEX = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char[] out = outputValue.toCharArray();
		List<String> resultList = new ArrayList<String>();
		for (int i=0; i < arrayOfHEX.length; i++){
			int result = 0;
			for (int j=0; j < out.length; j++){
				if (out[j] == arrayOfHEX[i])
					result++;
			}
			if (result > 0)
				resultList.add(arrayOfHEX[i] + "," + result);
		}
		for (String nextHEX: resultList)
			System.out.println(nextHEX);
		return resultList;
	}
	
}
