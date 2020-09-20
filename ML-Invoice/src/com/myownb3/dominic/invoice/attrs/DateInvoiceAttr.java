package com.myownb3.dominic.invoice.attrs;

/**
 * Describes a attribute of a single invoice (tarmed)-record
 * 
 * @author Dominic
 *
 */
public interface DateInvoiceAttr extends InvoiceAttr {

   /**
    * @return the format of the raw representation of this {@link DateInvoiceAttr}
    */
   String getDateAndTimeFormat();
}
