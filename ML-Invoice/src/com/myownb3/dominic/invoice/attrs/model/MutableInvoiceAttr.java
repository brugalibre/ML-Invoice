package com.myownb3.dominic.invoice.attrs.model;

import com.myownb3.dominic.invoice.attrs.metadata.InvoiceAttr;

/**
 * The {@link MutableInvoiceAttr} is used as an internal data model when handling with specific instances of an {@link InvoiceAttr}
 * It contains a metadata {@link InvoiceAttr} at whose most methods calls are delegated
 * 
 * @author DStalder
 *
 */
public interface MutableInvoiceAttr<T> extends InvoiceAttr {

   /**
    * Sets the value of this {@link MutableInvoiceAttr}
    * 
    * @param value
    */
   void setValue(T value);

   /**
    * @return the (double) value of this {@link MutableInvoiceAttr}
    */
   T getTypedValue();

   /**
    * @return the meta {@link InvoiceAttr} which is contained by this {@link MutableInvoiceAttr}
    */
   InvoiceAttr getInvoiceAttr();
}
