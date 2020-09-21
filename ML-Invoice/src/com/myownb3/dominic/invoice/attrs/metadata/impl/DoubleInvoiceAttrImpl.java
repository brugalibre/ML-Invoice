package com.myownb3.dominic.invoice.attrs.metadata.impl;

import com.myownb3.dominic.invoice.attrs.metadata.DoubleInvoiceAttr;
import com.myownb3.dominic.invoice.attrs.metadata.type.ContentType;

public class DoubleInvoiceAttrImpl extends InvoiceAttrImpl implements DoubleInvoiceAttr {
   /**
    * Creates a new {@link DoubleInvoiceAttrImpl} with the given name, sequence and default value.
    * 
    * @param name
    *        the name
    * @param sequence
    *        the sequence
    * @param defaultValue
    *        the defalt value
    */
   public DoubleInvoiceAttrImpl(String name, int sequence, String defaultValue) {
      super(name, sequence, true, ContentType.SERVICES_DATA, defaultValue);
   }

   /**
    * Creates a new {@link DoubleInvoiceAttrImpl} with the given name and sequence
    * The default value is "-"
    * 
    * @param name
    *        the name
    * @param sequence
    *        the sequence
    */
   public DoubleInvoiceAttrImpl(String name, int sequence) {
      super(name, sequence, true, ContentType.SERVICES_DATA, "-");
   }

   public DoubleInvoiceAttrImpl(String name, int sequence, boolean isRelevant4Vectorizing) {
      super(name, sequence, isRelevant4Vectorizing, ContentType.SERVICES_DATA, "-");
   }

   public DoubleInvoiceAttrImpl(String name, int sequence, boolean isRelevant4Vectorizing, ContentType contentType) {
      super(name, sequence, isRelevant4Vectorizing, contentType, "-");
   }

   @Override
   public boolean isValueValid(String value) {
      boolean isValueValid = true;
      try {
         Double.parseDouble(value);
      } catch (NumberFormatException e) {
         // ignore
         isValueValid = false;
      }
      return isValueValid;
   }

   @Override
   public String getDefaultValue() {
      return "0.0";
   }

   @Override
   public boolean isDouble() {
      return true;
   }
}
