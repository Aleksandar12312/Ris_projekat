package com.example.demo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;



@Component
public class GodinaToIntegerConverter implements Converter<String, Integer>{

	@Override
	public Integer convert(String source) {
		if(source==null||source.trim().isEmpty()) {
			return null;
		}
		try {
			return Integer.parseInt(source);
		}catch (Exception e) {
			throw new IllegalArgumentException("Pogresan unos za godinu! "+source);
		}
		
	}
}
