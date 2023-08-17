package info.ashutosh.test;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import info.ashutosh.service.ArithmeticIdentifier;

public class CalculationProgram {

	static Map<String, Float> finalMap = new LinkedHashMap<String, Float>();

	public static void main(String[] args) {
		String inputJson = "[{\"calculateField\":\"customFloat1\", \"formula\": \"10+15\"}, "
				+ "{\"calculateField\":\"customFloat2\", \"formula\": \"customFloat1*10\"}, "
				+ "{\"calculateField\":\"customFloat3\", \"formula\": \"customFloat2-18\"}, "
				+ "{\"calculateField\":\"customFloat4\", \"formula\": \"customFloat3+customFloat2\"}]";

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			JsonNode calculations = objectMapper.readTree(inputJson);

			for (JsonNode calculation : calculations) {
				String fieldName = calculation.get("calculateField").asText();
				String formula = calculation.get("formula").asText();

				ArithmeticIdentifier.DetermineArithmatiSymbol(finalMap, fieldName, formula);
				System.out.println();
			}
			System.out.println("Final Json Return : ");
			System.out.println(finalMap);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
