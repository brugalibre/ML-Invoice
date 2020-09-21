package com.myownb3.dominic.invoice.attrs.metadata;

import com.myownb3.dominic.invoice.attrs.metadata.type.ContentType;

/**
 * Describes a attribute of a single invoice (tarmed)-record
 * 
 * @author Dominic
 *
 */
public interface InvoiceAttr {

   /**
    * @return the name of this {@link InvoiceAttr}
    */
   String getName();

   /**
    * @return the value of this {@link InvoiceAttr}
    */
   String getValue();

   /**
    * @return the default value for this {@link InvoiceAttr} as a {@link String}
    */
   String getDefaultValue();

   /**
    * @return <code>false</code> since a {@link InvoiceAttr} is by default never a nominal attribute
    */
   boolean isNominal();

   /**
    * @return <code>true</code> if this {@link InvoiceAttr} contains a numeric value or <code>false</code> if not
    */
   boolean isDouble();

   /**
    * @return <code>true</code> if this {@link InvoiceAttr} contains an integer value or <code>false</code> if not
    */
   boolean isInteger();

   /**
    * @return <code>true</code> if this {@link InvoiceAttr} contains a date value or <code>false</code> if not
    */
   boolean isDate();

   /**
    * Verifies if the given value is valid for this {@link InvoiceAttr}.
    * <b>Note:</b> By default any non-null value is valid
    * 
    * @param value
    *        the value
    * @return <code>true</code> if the value is valid and <code>false</code> if not
    */
   boolean isValueValid(String value);

   /**
    * @return if this {@link InvoiceAttr} is relevant for vectorizing
    */
   boolean isRelevant4Vectorizing();

   /**
    * Depending on this {@link InvoiceAttr} and also it's type the given invalid value
    * is substituted by a valid one. E.g. '0' is converted into 'false' for all boolean types
    * <b>Note:</b> The default behaviour is to return the default value of this {@link InvoiceAttr}
    * 
    * @param invalidValue
    *        the invalid value
    * @return a valid value according the given invalid value
    */
   String getValidValue(String invalidValue);

   /**
    * @return the sequence of this {@link InvoiceAttr}
    */
   int getSequence();

   /**
    * @return the type of this attribute
    * 
    */
   ContentType getContentType();
}
