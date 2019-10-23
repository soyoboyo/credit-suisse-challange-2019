package skeleton.answers;

import org.assertj.core.util.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class Question3 {

	public static int whereDidIFinish(int[] scores, int[] alice) {
		List<Integer> myRanks = new ArrayList<>(alice.length);
		Set<Integer> scoresSet = new HashSet<>(Arrays.stream(scores).boxed().collect(Collectors.toList()));
		List<Integer> nonDuplicate = Lists.newArrayList(scoresSet);
		Collections.sort(nonDuplicate, Collections.reverseOrder());

		System.out.println("non duplicate");
		System.out.println(Arrays.toString(nonDuplicate.toArray()));
		System.out.println("alice");
		System.out.println(Arrays.toString(alice));

		Integer posCounter;
		for (Integer myScore : alice) {
			posCounter = 1;
			for (Integer score : nonDuplicate) {
				if (myScore >= score) {
					break;
				} else {
					posCounter++;
				}
			}
			myRanks.add(posCounter);
		}
		System.out.println("my ranks");
		System.out.println(Arrays.asList(myRanks));
		Collections.sort(myRanks, Collections.reverseOrder());
		Map<Integer, Integer> ranksCount = new HashMap<>();
		for (Integer rank : myRanks) {
			if (ranksCount.containsKey(rank)) {
				ranksCount.put(
						rank,
						(ranksCount.get(rank) + 1));
			} else {
				ranksCount.put(rank, 1);
			}
		}
		System.out.println(Arrays.asList(ranksCount));
		Integer max = 0, lowestRank = 0;
		for (Map.Entry<Integer, Integer> entry : ranksCount.entrySet()) {
			Integer rank = entry.getKey();
			Integer count = entry.getValue();
			if (count >= max) {
				max = count;
				lowestRank = Math.max(lowestRank, rank);
			}
		}
		return lowestRank;
	}
}
