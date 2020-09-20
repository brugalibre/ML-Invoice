package com.myownb3.dominic.invoice.attrs.constants;

/**
 * Contains different constants regarding an invoice xml
 * 
 * @author Dominic
 *
 */
public class InvoiceXMLConstants {

   private InvoiceXMLConstants() {
      // private
   }

   /** the xml tag name which contains the patients data */
   public static final String PATIENT_DATA = "patient";
   /** the xml-tag element within the patients data which contains the birth date */
   public static final String PATIENT_DATA_BIRTHDATE = "birthdate";
   /** the xml-tag element within the patients data which contains the gender */
   public static final String PATIENT_DATA_GENDER = "gender";

   /** The xml-tag name which contains a tarmed-record */
   public static final String RECORD_TARMED = "record_tarmed";
   /** the xml-tag element which contains the tarifziffer value */
   public static final String RECORD_TARMED_TAG_CODE = "code";
}
