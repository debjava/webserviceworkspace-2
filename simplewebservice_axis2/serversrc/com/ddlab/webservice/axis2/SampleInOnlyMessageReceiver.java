package com.ddlab.webservice.axis2;

import javax.xml.stream.XMLStreamException;

import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.receivers.AbstractInMessageReceiver;

public class SampleInOnlyMessageReceiver extends AbstractInMessageReceiver {
    protected void invokeBusinessLogic(MessageContext inMessageContext) throws AxisFault
    {
    	System.out.println("-----------------------------------------");
    	System.out.println("---------->"+inMessageContext.toString());
    	System.out.println("Got the fllmessage ==> " +inMessageContext.getEnvelope().getText());
    	System.out.println("Got the fllmessage ==> " +inMessageContext.getEnvelope().toString());
    	try {
			System.out.println("Got the fllmessage ==> " +inMessageContext.getEnvelope().toStringWithConsume());
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
    	
    	
        System.out.println("Got the message ==> " +
                inMessageContext.getEnvelope().getBody().getFirstElement().toString());
    }
}