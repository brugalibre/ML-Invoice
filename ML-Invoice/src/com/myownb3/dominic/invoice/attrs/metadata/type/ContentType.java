package com.myownb3.dominic.invoice.attrs.metadata.type;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Defines the type of content. E.g. services data (invoice:record_lab or invoice:record_tarmed)
 * or patients data
 * 
 * @author Dominic
 *
 */
public enum ContentType {

   /** defines lab or tarmed data */
   SERVICES_DATA,

   /** defines patient data */
   PATIENT_DATA,

   /** defines the invoices amount data */
   INVOICE_AMOUNT_DATA,

   /** defines treatment data */
   TREATMENT_DATA;

   /**
    * @return all types which are not {@link #SERVICES_DATA}
    */
   public static List<ContentType> getOrderedHeaderContentTypes() {
      LinkedList<ContentType> headerContentTypes = new LinkedList<>();
      for (ContentType contentType : ContentType.values()) {
         if (contentType != ContentType.SERVICES_DATA) {
            headerContentTypes.add(contentType);
         }
      }
      return Collections.unmodifiableList(headerContentTypes);
   }
}
