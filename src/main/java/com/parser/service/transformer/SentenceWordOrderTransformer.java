package com.parser.service.transformer;

import com.parser.service.parser.Parser;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SentenceWordOrderTransformer implements Transformer<String, Map<String, List<String>>> {

	private final Parser<String, List<String>> sentenceParser;
	private final Parser<String, List<String>> wordParser;

	public SentenceWordOrderTransformer(Parser<String, List<String>> sentenceParser,
										Parser<String, List<String>> wordParser) {
		this.sentenceParser = sentenceParser;
		this.wordParser = wordParser;
	}

	@Override
	public Map<String, List<String>> transform(String data) {
		List<String> sentences = sentenceParser.parse(data);
		AtomicInteger sentenceNumber = new AtomicInteger(0);
		return sentences.stream().map(sentence -> {
					List<String> words = wordParser.parse(sentence);
					words.sort(String.CASE_INSENSITIVE_ORDER);
					return words;
				}
		).collect(Collectors.toMap(words -> "Sentence " + sentenceNumber.getAndIncrement(), Function.identity()));
	}
}
