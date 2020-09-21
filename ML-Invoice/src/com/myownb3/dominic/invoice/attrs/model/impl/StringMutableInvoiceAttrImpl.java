package com.myownb3.dominic.invoice.attrs.model.impl;

import com.myownb3.dominic.invoice.attrs.metadata.InvoiceAttr;
import com.myownb3.dominic.invoice.attrs.model.StringMutableInvoiceAttr;

public class StringMutableInvoiceAttrImpl extends AbstractMutableInvoiceAttrImpl<String> implements StringMutableInvoiceAttr {

   /* visible 4 factory*/ StringMutableInvoiceAttrImpl(InvoiceAttr invoiceAttr, String value) {
      super(invoiceAttr, value);
   }
}
