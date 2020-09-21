package com.myownb3.dominic.invoice.attrs.model;

import org.joda.time.LocalDate;

import com.myownb3.dominic.invoice.attrs.metadata.DateInvoiceAttr;

/**
 * The {@link DateMutableInvoiceAttr} is used as {@link MutableInvoiceAttr} with type {@link String}
 * 
 * @author DStalder
 *
 */
public interface DateMutableInvoiceAttr extends MutableInvoiceAttr<LocalDate>, DateInvoiceAttr {

   /**
    * Calculates the amount of days between this {@link DateInvoiceAttr} and the other one
    * 
    * @param dateInvoiceAttr
    *        the other {@link DateInvoiceAttr}
    * @return the amount of days between this {@link DateInvoiceAttr} and the other one
    */
   int calcDaysBetween(DateMutableInvoiceAttr dateInvoiceAttr);
}
