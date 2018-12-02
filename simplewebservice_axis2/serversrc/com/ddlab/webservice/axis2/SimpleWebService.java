package com.ddlab.webservice.axis2;

import java.util.Iterator;

public class SimpleWebService 
{
//	private String key;
//	private String value;
//	
//	public SimpleWebService(String key,String value)
//	{
//		this.key = key;
//		this.value = value;
//	}
	
	public String getName( String name )
	{
		try 
		{
//			org.apache.axiom.soap.SOAPHeader header = org.apache.axis2.context.MessageContext 
//	                .getCurrentMessageContext().getEnvelope().getHeader(); 
//			Iterator itr = header.extractAllHeaderBlocks();
//			while( itr.hasNext() )
//			{
//				System.out.println(itr.next());
//				System.out.println(itr.next().getClass());
//			}
//			System.out.println("Key--->"+key);
//			System.out.println("Value--->"+value);
			System.out.println("Name from webservice client--->"+name);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "Name from server "+name;
	}
}
