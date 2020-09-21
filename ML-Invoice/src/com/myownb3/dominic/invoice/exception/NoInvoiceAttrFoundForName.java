package com.myownb3.dominic.invoice.exception;

public class NoInvoiceAttrFoundForName extends RuntimeException {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   public NoInvoiceAttrFoundForName(String msg) {
      super(msg);
   }
}
