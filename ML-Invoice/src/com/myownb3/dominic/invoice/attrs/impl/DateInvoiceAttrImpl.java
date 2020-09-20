package com.myownb3.dominic.invoice.attrs.impl;

import com.myownb3.dominic.invoice.attrs.DateInvoiceAttr;

public class DateInvoiceAttrImpl extends InvoiceAttrImpl implements DateInvoiceAttr {

   private String dateAndTimeFormat;

   public DateInvoiceAttrImpl(String name, String timeFormat, int sequence) {
      super(name, sequence);
      this.dateAndTimeFormat = timeFormat;
   }

   @Override
   public String getDateAndTimeFormat() {
      return dateAndTimeFormat;
   }
}
