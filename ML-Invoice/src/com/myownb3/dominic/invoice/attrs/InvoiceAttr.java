package com.myownb3.dominic.invoice.attrs;

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
    * @return if this {@link InvoiceAttr} is relevant for vectorizing
    */
   boolean isRelevant4Vectorizing();

   /**
    * @return the sequence of this {@link InvoiceAttr}
    */
   int getSequence();
}
