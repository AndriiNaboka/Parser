package com.parser.service.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser implements Parser<String, List<String>> {
	private static final String DELIMITERS = "[\\?\\.\\!]";

	@Override
	public List<String> parse(String text) {
		String[] spittedSentences = text.split(DELIMITERS);
		return Arrays.stream(spittedSentences).map(String::trim).filter(sentence -> !sentence.isEmpty())
				.collect(Collectors.toList());
	}
}
