package com.parser.input;

import java.util.stream.Stream;

public interface InputStreamReader<T> {
	Stream<T> readInputStream();
	void closeInputStream();
	T readLine();
}
