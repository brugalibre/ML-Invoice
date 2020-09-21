package com.myownb3.dominic.invoice.attrs.model.impl;

import com.myownb3.dominic.invoice.attrs.metadata.InvoiceAttr;
import com.myownb3.dominic.invoice.attrs.model.IntegerMutableInvoiceAttr;

public class IntegerMutableInvoiceAttrImpl extends AbstractMutableInvoiceAttrImpl<Integer> implements IntegerMutableInvoiceAttr {

   private IntegerMutableInvoiceAttrImpl(InvoiceAttr invoiceAttr, String value) {
      super(invoiceAttr, parse(value));
   }

   private static int parse(String value) {
      try {
         return Integer.parseInt(value);
      } catch (NumberFormatException e) {
         LOG.error("Unable to parse value '" + value + "'. Use default value '0' instead", e);
         return 0;
      }
   }

   /**
    * Creates a new {@link IntegerMutableInvoiceAttrImpl} with the given String as value
    * 
    * @param invoiceAttr
    *        the actual meta {@link InvoiceAttr} of this {@link IntegerMutableInvoiceAttrImpl}
    * @param value
    *        the value
    * @return a new {@link IntegerMutableInvoiceAttrImpl}
    */
   public static IntegerMutableInvoiceAttrImpl of(InvoiceAttr invoiceAttr, String value) {
      return new IntegerMutableInvoiceAttrImpl(invoiceAttr, value);
   }
}
