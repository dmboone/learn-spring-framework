package com.sandbox.learnspringframework.examples.c1;

import org.springframework.stereotype.Component;

@Component
class MySqlDataService implements DataService {
	
	@Override
	public int[] retrieveData() {
		return new int[] {1, 2, 3, 4, 5};
	}
}
