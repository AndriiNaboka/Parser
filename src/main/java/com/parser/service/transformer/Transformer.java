package com.parser.service.transformer;

public interface Transformer<In, Out> {
	Out transform(In data);
}
