package joquempo.resources;

import httprevayler.BaseResource;

public class CounterResource extends BaseResource {

	@Override
	protected Object doGet() throws Exception {
		return 12;
	}
	
	@Override
	protected void doPost() throws Exception {
		
	}

}
