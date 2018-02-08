package com.SoapServices;

import org.mule.DefaultMuleEvent;
import org.mule.MessageExchangePattern;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.mule.construct.Flow;
import org.mule.api.MuleEventContext;

public class Implementation_Orchard implements Interface_Orchard, Callable{
	MuleEventContext eventContext;
	@Override
	public void getAlLminds() {
	
		MuleMessage message = eventContext.getMessage();
		MuleContext muleContext = null;
		Flow flow=(Flow) muleContext.getRegistry().lookupFlowConstruct("GetAllMinds");
		MuleEvent muleEvent= new DefaultMuleEvent(message, MessageExchangePattern.REQUEST_RESPONSE,flow);
		
	}

	@Override
	public void getAllLeads() {
		
		
	}

	@Override
	public void getMindById() {
	
		
	}

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		// TODO Auto-generated method stub
		getAlLminds();
		return null;
	}



}
