
/**
 * StockServiceServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
        package com.ibm.soapheader;

import java.util.Iterator;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.soap.SOAPHeaderBlock;

        /**
        *  StockServiceServiceMessageReceiverInOut message receiver
        */

        public class StockServiceServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {
        	System.out.println("-----------------------------------------");
        	System.out.println("---------->"+msgContext.toString());
        	System.out.println("Got the fllmessage ==> " +msgContext.getEnvelope().getText());
        	System.out.println("Got the fllmessage ==> " +msgContext.getEnvelope().toString());
        	try
        	{
//        		Iterator itr = msgContext.getEnvelope().getHeader().examineAllHeaderBlocks();//extractAllHeaderBlocks();
        		Iterator itr = msgContext.getEnvelope().getHeader().getChildElements();
            	while( itr.hasNext() )
            	{
            		Object obj = itr.next();
            		System.out.println("----->"+obj.getClass());
            		if( obj instanceof SOAPHeaderBlock)
            		{
            			SOAPHeaderBlock headBlock = (SOAPHeaderBlock)obj;
            			System.out.println(headBlock.getLocalName());
            			
            			Iterator itr11 = headBlock.getChildElements();
            			while( itr11.hasNext() )
            			{
            				Object obj11 = itr11.next();
            				OMElement ele = (OMElement)obj11;
            				System.out.println(ele.getLocalName());
            				System.out.println(ele.getText());
            				
//            				SOAPHeaderBlock headBlock1 = (SOAPHeaderBlock)obj11;
//                			System.out.println(headBlock1.getLocalName());
//                			System.out.println(headBlock1.getText());
            			}
            		}
            	}
			}
        	catch (Exception e)
			{
				e.printStackTrace();
			}

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        StockServiceServiceSkeleton skel = (StockServiceServiceSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("getLastSellPrice".equals(methodName)){
                
                com.ibm.soapheader.GetLastSellPriceResponse getLastSellPriceResponse2 = null;
	                        com.ibm.soapheader.GetLastSellPrice wrappedParam =
                                                             (com.ibm.soapheader.GetLastSellPrice)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.ibm.soapheader.GetLastSellPrice.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getLastSellPriceResponse2 =
                                                   
                                                   
                                                         skel.getLastSellPrice(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getLastSellPriceResponse2, false, new javax.xml.namespace.QName("http://soapheader.ibm.com",
                                                    "getLastSellPrice"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(com.ibm.soapheader.GetLastSellPrice param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.ibm.soapheader.GetLastSellPrice.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.ibm.soapheader.GetLastSellPriceResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.ibm.soapheader.GetLastSellPriceResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.ibm.soapheader.MyHeader param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.ibm.soapheader.MyHeader.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.ibm.soapheader.GetLastSellPriceResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.ibm.soapheader.GetLastSellPriceResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.ibm.soapheader.GetLastSellPriceResponse wrapgetLastSellPrice(){
                                com.ibm.soapheader.GetLastSellPriceResponse wrappedElement = new com.ibm.soapheader.GetLastSellPriceResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (com.ibm.soapheader.GetLastSellPrice.class.equals(type)){
                
                           return com.ibm.soapheader.GetLastSellPrice.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.ibm.soapheader.GetLastSellPriceResponse.class.equals(type)){
                
                           return com.ibm.soapheader.GetLastSellPriceResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.ibm.soapheader.MyHeader.class.equals(type)){
                
                           return com.ibm.soapheader.MyHeader.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    