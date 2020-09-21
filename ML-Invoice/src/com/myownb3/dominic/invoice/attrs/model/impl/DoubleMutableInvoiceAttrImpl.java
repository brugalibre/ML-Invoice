package com.myownb3.dominic.invoice.attrs.model.impl;

import com.myownb3.dominic.invoice.attrs.metadata.InvoiceAttr;
import com.myownb3.dominic.invoice.attrs.model.DoubleMutableInvoiceAttr;

public class DoubleMutableInvoiceAttrImpl extends AbstractMutableInvoiceAttrImpl<Double> implements DoubleMutableInvoiceAttr {

   private DoubleMutableInvoiceAttrImpl(InvoiceAttr invoiceAttr, String value) {
      super(invoiceAttr, parse(value));
   }

   private static double parse(String value) {
      try {
         return Double.parseDouble(value);
      } catch (NumberFormatException e) {
         LOG.error("Unable to parse value '" + value + "'. Use default value '0.0' instead", e);
         return 0.0;
      }
   }

   private DoubleMutableInvoiceAttrImpl(InvoiceAttr invoiceAttr, double value) {
      super(invoiceAttr, value);
   }

   /**
    * Creates a copy from the {@link DoubleMutableInvoiceAttrImpl}
    * 
    * @param invoiceAttr
    *        the actual meta {@link InvoiceAttr} of this {@link DoubleMutableInvoiceAttrImpl}
    * @return a new {@link DoubleMutableInvoiceAttrImpl}
    */
   public static DoubleMutableInvoiceAttrImpl copy(DoubleMutableInvoiceAttr invoiceAttr) {
      return new DoubleMutableInvoiceAttrImpl(invoiceAttr, invoiceAttr.getTypedValue());
   }

   /**
    * Creates a new {@link DoubleMutableInvoiceAttrImpl} with the given String as value
    * 
    * @param invoiceAttr
    *        the actual meta {@link InvoiceAttr} of this {@link DoubleMutableInvoiceAttrImpl}
    * @param value
    *        the string value
    * @return a new {@link DoubleMutableInvoiceAttrImpl}
    */
   public static DoubleMutableInvoiceAttrImpl of(InvoiceAttr invoiceAttr, String value) {
      return new DoubleMutableInvoiceAttrImpl(invoiceAttr, value);
   }

   /**
    * Creates a new {@link DoubleMutableInvoiceAttrImpl} with the given String as value
    * 
    * @param invoiceAttr
    *        the actual meta {@link InvoiceAttr} of this {@link DoubleMutableInvoiceAttrImpl}
    * @param value
    *        the double value
    * @return a new {@link DoubleMutableInvoiceAttrImpl}
    */
   public static DoubleMutableInvoiceAttrImpl of(InvoiceAttr invoiceAttr, double value) {
      return new DoubleMutableInvoiceAttrImpl(invoiceAttr, value);
   }
}
