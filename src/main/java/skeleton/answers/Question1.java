package skeleton.answers;

import java.text.DecimalFormat;

public class Question1 {

	public static double calculateTotalPayment(double initialLevelOfDebt, double interestPercentage, double repaymentPercentage) {
//		System.out.println("initial debt = " + initialLevelOfDebt);
//		System.out.println("debt increase % = " + interestPercentage);
//		System.out.println("deposit % = " + repaymentPercentage);
		DecimalFormat f = new DecimalFormat("##.0");
		double currentDebt = initialLevelOfDebt;
		double totalPayment = 0.0;
		double deposit = currentDebt * 0.1;
		double repayment = currentDebt * repaymentPercentage / 100;
		if (repayment < 50) {
			repayment = 50.0;
		}
		while (currentDebt > repayment) {
			currentDebt += currentDebt * interestPercentage / 100;
			currentDebt -= repayment;
			totalPayment += repayment;
		}

//		System.out.println("==========================");
		double result = totalPayment + deposit + currentDebt;


		return Double.parseDouble(f.format(result));
	}

}
