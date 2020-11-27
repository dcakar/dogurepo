package com.ozan.forex.application.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

	private StringUtil() {
	}

	public static String toCamelCase(String input) {
		int inputLength = input.length();
		List<Integer> upperIndexes = new ArrayList<>();
		List<Integer> lowerIndexes = new ArrayList<>();
		char[] inputCharacters = input.toCharArray();
		upperIndexes.add(0);
		int doNotChangeIndex = 0;
		for (int i = 1; i < inputLength; i++) {
			char loopChar = inputCharacters[i];
			if (Character.isWhitespace(loopChar)) {
				doNotChangeIndex = i + 1;
				continue;
			} else if (Character.isUpperCase(loopChar) && i != doNotChangeIndex) {
				lowerIndexes.add(i);
			} else if (Character.isLowerCase(loopChar) && i != doNotChangeIndex) {
				upperIndexes.add(i);
			}
		}
		for (Integer item : lowerIndexes) {
			inputCharacters[item] = Character.toLowerCase(inputCharacters[item]);
		}
		for (Integer item : upperIndexes) {
			inputCharacters[item] = Character.toUpperCase(inputCharacters[item]);
		}
		return String.valueOf(inputCharacters);
	}

	public static String maskWithChar(String input, char maskChar, int charCount) {
		int inputLength = input.length();
		int startIndex = (inputLength - charCount) + 1;
		char[] inputChars = input.toCharArray();
		for (int i = startIndex; i < inputLength; i++) {
			inputChars[i] = maskChar;
		}
		return String.valueOf(inputChars);
	}
}
