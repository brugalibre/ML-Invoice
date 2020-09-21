package com.myownb3.dominic.invoice.attrs.model.impl;

import org.apache.log4j.Logger;

import com.myownb3.dominic.invoice.attrs.metadata.InvoiceAttr;
import com.myownb3.dominic.invoice.attrs.metadata.type.ContentType;
import com.myownb3.dominic.invoice.attrs.model.MutableInvoiceAttr;

public abstract class AbstractMutableInvoiceAttrImpl<T> implements MutableInvoiceAttr<T> {

   protected static final Logger LOG = Logger.getLogger(AbstractMutableInvoiceAttrImpl.class);
   protected InvoiceAttr invoiceAttr;
   protected T value;

   protected AbstractMutableInvoiceAttrImpl(InvoiceAttr invoiceAttr, T value) {
      this.invoiceAttr = invoiceAttr;
      this.value = value;
   }

   @Override
   public void setValue(T value) {
      this.value = value;
   }

   @Override
   public T getTypedValue() {
      return value;
   }

   @Override
   public String getValue() {
      return String.valueOf(value);
   }

   @Override
   public InvoiceAttr getInvoiceAttr() {
      return invoiceAttr;
   }

   @Override
   public String toString() {
      return getName() + "=" + value;
   }

   // All Methods overridden by InvoiceAttr and delegated to the actual instance of an InvoiceAttr

   @Override
   public String getDefaultValue() {
      return invoiceAttr.getDefaultValue();
   }

   @Override
   public String getName() {
      return invoiceAttr.getName();
   }

   @Override
   public boolean isValueValid(String value) {
      return invoiceAttr.isValueValid(value);
   }

   @Override
   public boolean isRelevant4Vectorizing() {
      return invoiceAttr.isRelevant4Vectorizing();
   }

   @Override
   public String getValidValue(String invalidValue) {
      return invoiceAttr.getValidValue(invalidValue);
   }

   @Override
   public int getSequence() {
      return invoiceAttr.getSequence();
   }

   @Override
   public ContentType getContentType() {
      return invoiceAttr.getContentType();
   }

   @Override
   public boolean isNominal() {
      return invoiceAttr.isNominal();
   }

   @Override
   public boolean isDouble() {
      return invoiceAttr.isDouble();
   }

   @Override
   public boolean isInteger() {
      return invoiceAttr.isInteger();
   }

   @Override
   public boolean isDate() {
      return invoiceAttr.isDate();
   }
}
