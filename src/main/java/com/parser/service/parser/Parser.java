package com.parser.service.parser;

public interface Parser<In, Out> {
	Out parse(In text);
}
