package com.calculate;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;

public class addition implements Callable{

	int sum;
	String result;
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message=eventContext.getMessage();
		String v=message.getProperty("x", PropertyScope.INVOCATION);
		String v1=message.getProperty("y",PropertyScope.INVOCATION);
		int x=Integer.parseInt(v);
		int y=Integer.parseInt(v1);
		sum =x+y;
		result=Integer.toString(sum);
		
		
		
		
		
		return null;
	}

}
