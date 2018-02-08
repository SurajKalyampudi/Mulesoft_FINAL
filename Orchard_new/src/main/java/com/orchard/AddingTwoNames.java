package com.orchard;

import org.mule.DefaultMuleEvent;
import org.mule.DefaultMuleMessage;
import org.mule.MessageExchangePattern;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;
import org.mule.construct.Flow;


public class AddingTwoNames implements Callable {

	StringBuilder nameBuilder=new StringBuilder();
	String message=null;
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage msg=eventContext.getMessage();
		String firstname=msg.getProperty("firstName", PropertyScope.INVOCATION);
		String lastname=msg.getProperty("lastName", PropertyScope.INVOCATION);
		
		nameBuilder.append(firstname);
		nameBuilder.append(lastname);
		message=nameBuilder.toString();
		
		MuleMessage mule=new DefaultMuleMessage(message,eventContext.getMuleContext());
		mule.setEncoding("UTF-8");	
		
		mule.setProperty("Name", message,PropertyScope.INVOCATION);
		mule.setPayload(message);
		
		invokeMuleFlow(mule,eventContext.getMuleContext(),"second-flow");
		return null;
	}
	private MuleEvent invokeMuleFlow(MuleMessage mule, MuleContext muleContext, String flowname) throws MuleException {
		// TODO Auto-generated method stub

		Flow flow=(Flow)muleContext.getRegistry().lookupFlowConstruct(flowname);
		MuleEvent event= new DefaultMuleEvent(mule,MessageExchangePattern.REQUEST_RESPONSE,flow);
		return flow.process(event);
		
	}

}
