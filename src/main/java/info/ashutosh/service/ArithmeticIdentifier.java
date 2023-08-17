package info.ashutosh.service;

import java.util.Map;

public class ArithmeticIdentifier {

	public static void DetermineArithmatiSymbol(Map<String, Float> valueMap, String fieldName, String formula) {

		char operator = getOperator(formula);
		if (operator != 0) {
			switch (operator) {
			case '+':
				performAddition(valueMap, fieldName, formula);
				break;
			case '-':
				performSubtraction(valueMap, fieldName, formula);
				break;
			case '*':
				performMultiplication(valueMap, fieldName, formula);
				break;
			case '/':
				performDivision(valueMap, fieldName, formula);
				break;
			default:
				System.out.println("Unsupported operator: " + operator);
			}
		} else {
			System.out.println("No operator found in: " + formula);
		}
	}

	private static char getOperator(String input) {
		for (char ch : input.toCharArray()) {
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				return ch;
			}
		}
		return 0;
	}

	public static Float findFromMapORCalculate(Map<String, Float> valueMap, String parts) {

		boolean containsKey = valueMap.containsKey(parts);
		if (containsKey) {
			return valueMap.get(parts);
		}
		return null;

	}

	private static void performAddition(Map<String, Float> valueMap, String fieldName, String formula) {

		System.out.println("Performing addition for: " + formula);

		Float[] values = splitAndGetValue(valueMap, formula);

		valueMap.put(fieldName, values[0] + values[1]);

	}

	private static void performSubtraction(Map<String, Float> valueMap, String fieldName, String formula) {
		System.out.println("Performing subtraction for: " + formula);

		Float[] values = splitAndGetValue(valueMap, formula);

		valueMap.put(fieldName, values[0] - values[1]);
	}

	private static void performMultiplication(Map<String, Float> valueMap, String fieldName, String formula) {
		// Implement multiplication logic here
		System.out.println("Performing multiplication for: " + formula);

		Float[] values = splitAndGetValue(valueMap, formula);

		valueMap.put(fieldName, values[0] * values[1]);
	}

	private static void performDivision(Map<String, Float> valueMap, String fieldName, String formula) {
		// Implement division logic here
		System.out.println("Performing division for: " + formula);

		Float[] values = splitAndGetValue(valueMap, formula);

		valueMap.put(fieldName, values[0] / values[1]);
	}

	private static Float[] splitAndGetValue(Map<String, Float> valueMap, String formula) {
		String[] parts = valueSpliteter(formula);

		Float[] values = perforGetValue(valueMap, parts);
		return values;
	}

	private static String[] valueSpliteter(String formula) {
		String[] parts = formula.split("[-+*/]"); // Split based on arithmetic symbols
		return parts;
	}

	private static Float[] perforGetValue(Map<String, Float> valueMap, String[] parts) {
		Float[] values = new Float[2];

		for (int i = 0; i <= 1; i++) {
			Float value = null;
			try {
				value = Float.parseFloat(parts[i]);
			} catch (Exception e) {
				value = findFromMapORCalculate(valueMap, parts[i]);
			}
			System.out.println(i + 1 + " Operand : " + value);

			values[i] = value;
		}
		return values;
	}

}
