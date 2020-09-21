package com.myownb3.dominic.invoice.attrs.metadata.impl;

import com.myownb3.dominic.invoice.attrs.metadata.DateInvoiceAttr;
import com.myownb3.dominic.invoice.attrs.metadata.type.ContentType;

public class DateInvoiceAttrImpl extends InvoiceAttrImpl implements DateInvoiceAttr {

   private String dateAndTimeFormat;

   public DateInvoiceAttrImpl(String name, String timeFormat, int sequence, boolean isRelevant4Vectorizing, ContentType contentType) {
      super(name, sequence, isRelevant4Vectorizing, contentType);
      this.dateAndTimeFormat = timeFormat;
   }

   @Override
   public String getDateAndTimeFormat() {
      return dateAndTimeFormat;
   }

   @Override
   public boolean isDate() {
      return true;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((dateAndTimeFormat == null) ? 0 : dateAndTimeFormat.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (!super.equals(obj))
         return false;
      if (getClass() != obj.getClass())
         return false;
      DateInvoiceAttrImpl other = (DateInvoiceAttrImpl) obj;
      if (dateAndTimeFormat == null) {
         if (other.dateAndTimeFormat != null)
            return false;
      } else if (!dateAndTimeFormat.equals(other.dateAndTimeFormat))
         return false;
      return true;
   }
}
