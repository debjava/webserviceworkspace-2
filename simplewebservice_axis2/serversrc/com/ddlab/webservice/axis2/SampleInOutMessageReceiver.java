package com.ddlab.webservice.axis2;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAP11Constants;
import org.apache.axiom.soap.SOAP12Constants;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.receivers.AbstractInOutMessageReceiver;

public class SampleInOutMessageReceiver extends AbstractInOutMessageReceiver {
    public void invokeBusinessLogic(MessageContext inMessageContext,
                                    MessageContext outMessageContext) throws AxisFault 
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
        // creating the response message
        // getting the soap namesapce uri of the incomming message
        String soapNamespace = inMessageContext.getEnvelope().getNamespace().getNamespaceURI();
        // creating a soap factory according the the soap namespce uri
        SOAPFactory soapFactory = null;
        if (soapNamespace.equals(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI)){
            soapFactory = OMAbstractFactory.getSOAP11Factory();
        } else if (soapNamespace.equals(SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI)){
            soapFactory = OMAbstractFactory.getSOAP12Factory();
        } else {
            System.out.println("Unknow soap message");
        }

        SOAPEnvelope responseEnvelope = soapFactory.getDefaultEnvelope();
        
        responseEnvelope.getHeader().addAttribute("aaa", "sdasdsaa", null);

        // creating a body element
        OMFactory omFactory = OMAbstractFactory.getOMFactory();
        OMNamespace omNamespace = omFactory.createOMNamespace("http://sample.api","ns1");
        OMElement omElement = omFactory.createOMElement("Response", omNamespace);
        omElement.setText("Sucessfully got the message");
        responseEnvelope.getBody().addChild(omElement);

        outMessageContext.setEnvelope(responseEnvelope);
    }
}