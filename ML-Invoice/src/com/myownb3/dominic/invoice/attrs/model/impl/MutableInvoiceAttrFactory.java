package com.myownb3.dominic.invoice.attrs.model.impl;

import com.myownb3.dominic.invoice.attrs.metadata.InvoiceAttr;
import com.myownb3.dominic.invoice.attrs.metadata.NominalInvoiceAttr;
import com.myownb3.dominic.invoice.attrs.model.MutableInvoiceAttr;

/**
 * The {@link MutableInvoiceAttrFactory} builds new, mutable instances of {@link InvoiceAttr} during the process of
 * feature engineering or data cleaning and so on
 * 
 * @author DStalder
 *
 */
public class MutableInvoiceAttrFactory {

   public static final MutableInvoiceAttrFactory INSTANCE = new MutableInvoiceAttrFactory();

   private MutableInvoiceAttrFactory() {
      // private
   }

   /**
    * Creates a new {@link MutableInvoiceAttr} for the given meta {@link InvoiceAttr} and value
    * 
    * @param invoiceAttr
    *        the meta {@link InvoiceAttr}
    * @param value
    *        the value
    * @return a new {@link MutableInvoiceAttr}
    */
   public MutableInvoiceAttr<?> createNewMutableInvoiceAttr(InvoiceAttr invoiceAttr, String value) {
      if (invoiceAttr.isDouble()) {
         return DoubleMutableInvoiceAttrImpl.of(invoiceAttr, value);
      } else if (invoiceAttr.isInteger()) {
         return IntegerMutableInvoiceAttrImpl.of(invoiceAttr, value);
      } else if (invoiceAttr.isDate()) {
         return DateMutableInvoiceAttrImpl.of(invoiceAttr, value);
      } else if (invoiceAttr.isNominal()) {
         return NominalMutableInvoiceAttrImpl.of((NominalInvoiceAttr) invoiceAttr, value);
      }
      return new StringMutableInvoiceAttrImpl(invoiceAttr, value);
   }

   /**
    * Builds a {@link NominalMutableInvoiceAttrImpl} for a specific value of all possible values for this category. This value is now the
    * name of this
    * {@link NominalInvoiceAttr} where as the actual value is the counter which count's the occurrences
    * 
    * @param invoiceAttr
    *        the {@link NominalInvoiceAttr}
    * @param name
    *        the name / category of this NominalMutableInvoiceAttr
    * @param value
    *        the initial value
    */
   public InvoiceAttr createNewMutableNominalInvoiceAttr(NominalInvoiceAttr invoiceAttr, String name) {
      return NominalMutableInvoiceAttrImpl.of(invoiceAttr, name, 0);
   }
}
