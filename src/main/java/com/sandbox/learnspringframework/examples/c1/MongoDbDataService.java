package com.sandbox.learnspringframework.examples.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // could use @Repository instead since in a real project this class would be used to retrieve and/or manipulate data in a database
@Primary
public class MongoDbDataService implements DataService {
	
	@Override
	public int[] retrieveData() {
		return new int[] {11, 22, 33, 44, 55};
	}
}
