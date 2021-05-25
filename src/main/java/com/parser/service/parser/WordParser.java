package com.parser.service.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordParser implements Parser<String, List<String>> {
	@Override
	public List<String> parse(String text) {
		String[] slittedWords = text.split("\\W+");
		return  Arrays.stream(slittedWords).map(String::trim).filter(word -> !word.isEmpty()).collect(Collectors.toList());
	}
}
