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

public class SampleInOutMessageReceiver extends AbstractInOutMessageReceiver
{
	private void printSoapMessage(MessageContext inMessageContext)
	{
		try 
		{
			System.out.println("Soap Request XML\n"
					+ inMessageContext.getEnvelope().toString());
			System.out.println("Soap Request XML\n"
					+ inMessageContext.getEnvelope().toStringWithConsume());
			System.out.println("Only Message Body\n"
					+ inMessageContext.getEnvelope().getBody()
							.getFirstElement().toString());
			String ipAddress = (String) MessageContext
					.getCurrentMessageContext()
					.getProperty(MessageContext.REMOTE_ADDR);
			System.out.println("Incoming Request IP Address : "+ipAddress);
		}
		catch (XMLStreamException e) 
		{
			e.printStackTrace();
		}
	}
	
    public void invokeBusinessLogic(MessageContext inMessageContext,
                                    MessageContext outMessageContext) throws AxisFault 
    {
    	System.out.println("--------------------SampleInOutMessageReceiver---------------------");
    	printSoapMessage(inMessageContext);
    	
    	invokeBusinessLogic(inMessageContext);
    	
//        String soapNamespace = inMessageContext.getEnvelope().getNamespace().getNamespaceURI();
//        SOAPFactory soapFactory = null;
//        if (soapNamespace.equals(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI))
//        {
//            soapFactory = OMAbstractFactory.getSOAP11Factory();
//        }
//        else if (soapNamespace.equals(SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI))
//        {
//            soapFactory = OMAbstractFactory.getSOAP12Factory();
//        }
//        else 
//        {
//            System.out.println("Unknow soap message");
//        }
//        SOAPEnvelope responseEnvelope = soapFactory.getDefaultEnvelope();
//        responseEnvelope.getHeader().addAttribute("aaa", "sdasdsaa", null);
        
//        SimpleWebService simpleService = (SimpleWebService) getTheImplementationObject(inMessageContext);
//        simpleService.getName("abcd");
//        inMessageContext.setEnvelope(inMessageContext.getEnvelope());
        
        
        
        
        
        // creating a body element
//        OMFactory omFactory = OMAbstractFactory.getOMFactory();
//        OMNamespace omNamespace = omFactory.createOMNamespace("http://sample.api","ns1");
//        OMElement omElement = omFactory.createOMElement("Response", omNamespace);
//        omElement.setText("Sucessfully got the message");
//        responseEnvelope.getBody().addChild(omElement);
//
//        outMessageContext.setEnvelope(responseEnvelope);
    }
}