package com.parser.input;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Stream;

public class ConsoleInputStreamReader implements InputStreamReader<String> {
	private static final Logger logger = LogManager.getLogger(ConsoleInputStreamReader.class);

	private static final BufferedReader bufferedReader = new BufferedReader(new java.io.InputStreamReader(System.in));

	@Override
	public Stream<String> readInputStream() {
		return bufferedReader.lines();
	}

	@Override
	public void closeInputStream() {
		try {
			bufferedReader.close();
		} catch (IOException e) {
			logger.error("generating response");
		}
	}

	@Override
	public String readLine() {
		try {
			return bufferedReader.readLine();
		} catch (IOException e) {
			logger.error("generating response");
			return null;
		}
	}
}
