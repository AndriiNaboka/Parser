package com.parser.output;

import com.parser.service.transformer.Transformer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CSVSentenceWordOrderConsoleView implements OutputView<String> {
	private final Transformer<String, Map<String, List<String>>> sentenceWordOrderTransformer;

	public CSVSentenceWordOrderConsoleView(Transformer<String, Map<String, List<String>>> sentenceWordOrderTransformer) {
		this.sentenceWordOrderTransformer = sentenceWordOrderTransformer;
	}

	@Override
	public void generate(String data) {
		Map<String, List<String>> sentenceToOrderedWordsMap = sentenceWordOrderTransformer.transform(data);

		int maxWords = sentenceToOrderedWordsMap.values().stream().max(Comparator.comparingInt(List::size))
				.orElse(Collections.emptyList()).size();

		String header = "";

		List<String> wordsList = new ArrayList<>();
		for (int index = 1; index <= maxWords; index++) {
			wordsList.add("Word " + index);
		}

		if (!wordsList.isEmpty()) {
			header = String.join(", ", wordsList);
		}

		System.out.println(header);

		sentenceToOrderedWordsMap.keySet().forEach(
				key -> {
					List<String> row = new ArrayList<>();
					row.add(key);
					row.addAll(sentenceToOrderedWordsMap.get(key));
					System.out.println(String.join(", ", row));
				}
		);
	}
}
