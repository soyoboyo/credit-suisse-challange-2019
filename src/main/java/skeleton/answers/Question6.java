package skeleton.answers;

import java.util.HashMap;
import java.util.Map;

public class Question6 {

	public static int startingAndEndingWell(String[] portfolio) {
		Map<String, Integer> lettersAndFirstPosition = new HashMap<>();
		int len = portfolio.length;
		for (int i = len - 1; i >= 0; i--) {
			String p = portfolio[i];
			Integer pLen = p.length();

			String acr = p.substring(0, 1) + p.substring(pLen);
			if (lettersAndFirstPosition.containsKey(acr)) {
				return lettersAndFirstPosition.get(acr);
			} else {
				lettersAndFirstPosition.put(acr, i);
			}
		}
		return -1;
	}
}
