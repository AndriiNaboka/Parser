package com.parser.main;

import com.parser.input.ConsoleInputStreamReader;
import com.parser.input.InputStreamReader;
import com.parser.output.CSVSentenceWordOrderConsoleView;
import com.parser.output.OutputView;
import com.parser.service.parser.Parser;
import com.parser.service.parser.SentenceParser;
import com.parser.service.parser.WordParser;
import com.parser.service.transformer.SentenceWordOrderTransformer;
import com.parser.service.transformer.Transformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		InputStreamReader<String> inputStreamReader = new ConsoleInputStreamReader();
		Parser<String, List<String>> sentenceParser = new SentenceParser();
		Parser<String, List<String>> wordParser = new WordParser();
		Transformer<String, Map<String, List<String>>> transformer = new SentenceWordOrderTransformer(sentenceParser, wordParser);
		OutputView<String> outputView = new CSVSentenceWordOrderConsoleView(transformer);

		try {
			while (true) {
				System.out.println("Enter text to parse: ");

				String text = inputStreamReader.readLine();

				if ("exit".equals(text)) {
					inputStreamReader.closeInputStream();
					break;
				}

				outputView.generate(text);
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
	}
}
