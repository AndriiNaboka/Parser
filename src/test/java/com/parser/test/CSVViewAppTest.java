package com.parser.test;

import com.parser.output.CSVSentenceWordOrderConsoleView;
import com.parser.output.OutputView;
import com.parser.service.parser.Parser;
import com.parser.service.parser.SentenceParser;
import com.parser.service.parser.WordParser;
import com.parser.service.transformer.SentenceWordOrderTransformer;
import com.parser.service.transformer.Transformer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class CSVViewAppTest {

	private static final Parser<String, List<String>> sentenceParser = new SentenceParser();
	private static final Parser<String, List<String>> wordParser = new WordParser();

	private static final Transformer<String, Map<String, List<String>>> transformer = new SentenceWordOrderTransformer(sentenceParser, wordParser);
	private static final OutputView<String> outputView = new CSVSentenceWordOrderConsoleView(transformer);


	@Test
	public void shouldParsTextBySentences() {
		String text = "Mary had a little lamb. Peter called for the wolf, and Aesop came? Cinderella likes shoes!";

		List<String> sentences = sentenceParser.parse(text);
		assertEquals(3, sentences.size());

		text = " Mary   had a little  lamb  . \n" +
				"\n" +
				"\n" +
				"  Peter   called for the wolf   ,  and Aesop came .\n" +
				" Cinderella  likes shoes.";

		sentences = sentenceParser.parse(text);
		assertEquals(3, sentences.size());

		text = " Mary   had a little  lamb  ! \n" +
				"\n" +
				"\n" +
				"  Peter   called for the wolf   ,  and Aesop came ?\n" +
				" Cinderella  likes shoes.";

		sentences = sentenceParser.parse(text);
		assertEquals(3, sentences.size());
	}

	@Test
	public void shouldParsSentencesByWords() {
		String sentencesArray = "Peter called for the wolf, and Aesop came";
		List<String> words = wordParser.parse(sentencesArray);
		assertEquals(8, words.size());

		sentencesArray = "Peter called: for the wolf, and Aesop came";
		words = wordParser.parse(sentencesArray);
		assertEquals(8, words.size());
	}

	@Test
	public void shouldMatchToOutputFormat() throws IOException {
		String text = "Mary had a little lamb. Peter called for the wolf, and Aesop came? Cinderella likes shoes!";
		String expectedView = "Word 1, Word 2, Word 3, Word 4, Word 5, Word 6, Word 7, Word 8\n" +
				"Sentence 0, a, had, lamb, little, Mary\n" +
				"Sentence 2, Cinderella, likes, shoes\n" +
				"Sentence 1, Aesop, and, called, came, for, Peter, the, wolf\n";
		ByteArrayOutputStream outputBytes = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputBytes));
		outputView.generate(text);
		String generatedView = new String(outputBytes.toByteArray());
		assertEquals(expectedView, generatedView);
	}
}
