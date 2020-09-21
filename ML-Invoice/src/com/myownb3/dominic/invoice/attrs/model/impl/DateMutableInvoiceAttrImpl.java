package com.myownb3.dominic.invoice.attrs.model.impl;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.myownb3.dominic.invoice.attrs.metadata.DateInvoiceAttr;
import com.myownb3.dominic.invoice.attrs.metadata.InvoiceAttr;
import com.myownb3.dominic.invoice.attrs.model.DateMutableInvoiceAttr;

public class DateMutableInvoiceAttrImpl extends AbstractMutableInvoiceAttrImpl<LocalDate> implements DateMutableInvoiceAttr {

   private DateMutableInvoiceAttrImpl(InvoiceAttr invoiceAttr, String value) {
      super(invoiceAttr, parseString2LocalDate(invoiceAttr, value));
   }

   /*
    * If the value is already a parsed LocalDate like '2019-12-12', then we don't need the formatter
    * Otherwise, if the String value is like '1955-07-16T00:00:00.000' then we need the formatter
    */
   private static LocalDate parseString2LocalDate(InvoiceAttr invoiceAttr, String value) {
      try {
         return LocalDate.parse(value);
      } catch (IllegalArgumentException e) {
         return LocalDate.parse(value, getDateTimeFormatter(invoiceAttr));
      }
   }

   private static DateTimeFormatter getDateTimeFormatter(InvoiceAttr invoiceAttr) {
      return DateTimeFormat.forPattern(getDateAndTimeFormat(invoiceAttr));
   }

   private static String getDateAndTimeFormat(InvoiceAttr invoiceAttr) {
      return getDateInvoiceAttr(invoiceAttr).getDateAndTimeFormat();
   }

   @Override
   public String getDateAndTimeFormat() {
      return getDateInvoiceAttr().getDateAndTimeFormat();
   }

   @Override
   public int calcDaysBetween(DateMutableInvoiceAttr dateInvoiceAttr) {
      return Days.daysBetween(getTypedValue(), dateInvoiceAttr.getTypedValue()).getDays();
   }

   private DateInvoiceAttr getDateInvoiceAttr() {
      return getDateInvoiceAttr(invoiceAttr);
   }

   private static DateInvoiceAttr getDateInvoiceAttr(InvoiceAttr invoiceAttr) {
      return (DateInvoiceAttr) invoiceAttr;
   }

   /**
    * Creates a new {@link DateMutableInvoiceAttrImpl} with the given meta {@link InvoiceAttr} and String value
    * 
    * @param invoiceAttr
    *        the given meta {@link InvoiceAttr}
    * @param value
    *        the value
    * @return a new {@link DateMutableInvoiceAttrImpl}
    */
   public static DateMutableInvoiceAttrImpl of(InvoiceAttr invoiceAttr, String value) {
      return new DateMutableInvoiceAttrImpl(invoiceAttr, value);
   }
}
