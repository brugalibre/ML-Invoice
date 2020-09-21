package com.myownb3.dominic.invoice.attrs.metadata;

import java.util.List;

import com.myownb3.dominic.invoice.attrs.metadata.constants.InvoiceAttrs;

/**
 * Describes a nominal attribute of a single invoice (tarmed)-record
 * 
 * @author Dominic
 *
 */
public interface NominalInvoiceAttr extends InvoiceAttr {

   /**
    * Returns a String representation of this {@link NominalInvoiceAttr} according a naming pattern
    * 
    * @param categoricalValue
    *        the specific categorical value
    * 
    * @return a String representation of this {@link NominalInvoiceAttr} according a naming pattern
    */
   String buildCategoricalAttrName(String categoricalValue);

   /**
    * 
    * @return the categorical values of this {@link InvoiceAttr}
    */
   List<String> getCategoricalValues();

   /**
    * @return the name of the category this {@link InvoiceAttrs} belongs to
    */
   String getCategoryName();
}
