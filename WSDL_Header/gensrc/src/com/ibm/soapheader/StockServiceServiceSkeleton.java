
/**
 * StockServiceServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
    package com.ibm.soapheader;
    /**
     *  StockServiceServiceSkeleton java skeleton for the axisService
     */
    public class StockServiceServiceSkeleton{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param getLastSellPrice 
             * @return getLastSellPriceResponse 
         */
        
                 public com.ibm.soapheader.GetLastSellPriceResponse getLastSellPrice
                  (
                  com.ibm.soapheader.GetLastSellPrice getLastSellPrice
                  )
            {
                //TODO : fill this with the necessary business logic
                	 System.out.println("Web service Method getLastSellPrice called ...");
              		GetLastSellPriceResponse response = new GetLastSellPriceResponse();
              		response.setGetLastSellPriceReturn(123.45f);
              		return response;
        }
     
    }
    