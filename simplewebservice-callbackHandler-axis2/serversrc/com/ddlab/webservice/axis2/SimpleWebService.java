package com.ddlab.webservice.axis2;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.XMLStreamException;

import org.apache.axis2.context.MessageContext;

public class SimpleWebService 
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
	
	public String getName( String name )
	{
		try 
		{
			System.out.println("------------- Printing SOAP From the Service ------------");
			MessageContext inMessageContext = MessageContext .getCurrentMessageContext();
			printSoapMessage(inMessageContext);
			
			
			MessageContext msgCtx = MessageContext.getCurrentMessageContext();
			HttpServletRequest obj =(HttpServletRequest)msgCtx.getProperty("transport.http.servletRequest");
			System.out.println("Acceptable Encoding type: "+obj.getHeader("Accept-Encoding"));
			System.out.println("Acceptable character set: " +obj.getHeader("Accept-Charset"));
			System.out.println("Acceptable Media Type: "+obj.getHeader("Accept"));
			
			
			
			System.out.println("Name from webservice client--->"+name);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "Name from server "+name;
	}
}
