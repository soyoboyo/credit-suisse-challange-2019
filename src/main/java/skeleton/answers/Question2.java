package skeleton.answers;

import java.util.*;

public class Question2 {
	private static class Trade {
		Integer risk;
		Integer bonus;

		public Trade(int risk, int bonus) {
			this.risk = risk;
			this.bonus = bonus;
		}

		public Integer getRisk() {
			return risk;
		}

		public Integer getBonus() {
			return bonus;
		}
	}

    public static int riskAndReward(int[] risk, int[] bonus, int[] trader) {
		List<Trade> trades = new ArrayList<>(risk.length);
		for (int i = 0; i < risk.length; i++) {
			trades.add(new Trade(risk[i], bonus[i]));
		}
		trades.sort(Comparator.comparing(Trade::getBonus));
		Collections.reverse(trades);
		Arrays.sort(trader);

		Integer sum = 0;
		for (int i = 0; i < trader.length; i++) {
			for (Trade trade : trades) {
				if(trade.getRisk() <= trader[i]){
					sum += trade.getBonus();
					break;
				}
			}
		}
        return sum;
    }
}
