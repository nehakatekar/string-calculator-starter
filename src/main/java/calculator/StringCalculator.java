package calculator;

public class StringCalculator {

 public static int add(String input) {
		if (input.equals("")) {
			return 0;
		} else {
			String delimiter = ",";
			if (input.matches("/\n")) {
				delimiter = Character.toString(input.charAt(2));
				input = input.substring(1);
			}

			String numList[] = split(input, delimiter + "|;|\n");
			return sum(numList);
		}
	}
 
 
 public static int add2(String input) {
	 
	
	 
	 return 0;
 }

 
 
 
 
	private static String[] split(String numbers, String divider) {
		return numbers.split(divider);
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}


	private static int sum(String[] numbers) {
		int total = 0;
		String neg = "";

		for (String number : numbers) {
			if (toInt(number) < 0) {
				if (neg.equals(""))
					neg = number;
				else
					neg += ("," + number);
			}
//			if (toInt(number) <= 1000)
//				total += toInt(number);
			if (toInt(number) > 1000 && toInt(number)<10000)
				continue;
			else
				total += toInt(number);
		}

		if (!neg.equals("")) {
			throw new IllegalArgumentException("Negatives not allowed: " + neg);
		}

		return total;
	}
}