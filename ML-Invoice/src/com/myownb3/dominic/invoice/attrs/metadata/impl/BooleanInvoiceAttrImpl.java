package com.myownb3.dominic.invoice.attrs.metadata.impl;

import java.util.Arrays;
import java.util.List;

import com.myownb3.dominic.invoice.attrs.metadata.BooleanInvoiceAttr;
import com.myownb3.dominic.invoice.attrs.metadata.type.ContentType;

public class BooleanInvoiceAttrImpl extends NominalInvoiceAttrImpl implements BooleanInvoiceAttr {

   private static final String TRUE = "true";
   private static final String FALSE = "false";

   public BooleanInvoiceAttrImpl(String name, int sequence, String defaultValue) {
      super(name, name, sequence, true, ContentType.SERVICES_DATA, defaultValue);
   }

   @Override
   public List<String> getCategoricalValues() {
      return Arrays.asList(TRUE, FALSE);
   }

   @Override
   public boolean isValueValid(String value) {
      return TRUE.equals(value) || FALSE.equals(value);
   }

   @Override
   public String getValidValue(String value) {
      if ("0".equals(value) || "o".equals(value)) {
         return FALSE;
      }
      if ("1".equals(value)) {
         return TRUE;
      }
      return value;
   }
}
