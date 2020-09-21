package com.myownb3.dominic.invoice.attrs.constants;

import com.myownb3.dominic.invoice.attrs.metadata.InvoiceAttr;

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

   /** the prefix for each complex invoice xml tag */
   public static final String INVOICE_PREFIX = "invoice:";

   /** the xml tag name which contains the patients data */
   public static final String PATIENT_DATA = "invoice:patient";
   /** the xml-tag element within the patients data which contains the birth date */
   public static final String PATIENT_DATA_BIRTHDATE = "birthdate";
   /** the xml-tag element within the patients data which contains the age */
   public static final String PATIENT_DATA_AGE = "age";
   /** the xml-tag element within the patients data which contains the gender */
   public static final String PATIENT_DATA_GENDER = "gender";

   /** The suffix for all 'treatment' attrs */
   public static final String TREATMENT_SUFFIX = "treatment_";
   /** the xml tag name which contains the treatment data in the xml-header */
   public static final String TREATMENT_DATA = "invoice:treatment";
   /** the xml-tag element within the treatment data which contains the reason of treatment */
   public static final String TREATMENT_DATA_REASON = "reason";
   /** the xml-tag element within the treatment data which contains ambulatory details. Can be missing */
   public static final String TREATMENT_AMBULARTORY_TYPE = "invoice:ambulatory";
   /** the xml-tag element within the treatment data which contains ambulatory details. Can be missing */
   public static final String TREATMENT_STATIONARY_TYPE = "invoice:stationary";
   /** the name of the {@link InvoiceAttr} which contains the information if ambulatory or stationary */
   public static final String TREATMENT_TYPE = "treatment_type";
   /** the xml-tag element within the treatment data which defines the begin of the treatment, regardless of the actual treatment type */
   public static final String TREATMENT_DATA_BEGIN = "date_begin";

   /** the string literal 'invoice' */
   public static final String INVOICE_SUFFIX = "invoice_";
   /** the xml-tag element which contains the amount and the amount-due types */
   public static final String INVOICE_BALANCE = "invoice:balance";
   /** the xml-tag element which contains the amount of the entire invoice */

   public static final String AMOUNT = "amount";
   /** the xml-tag element which contains the amount-due of the entire invoice */
   public static final String AMOUNT_DUE = "amount_due";

   /** The xml-tag name which contains a tarmed-other row */
   public static final String RECORD_OTHER = "invoice:record_other";
   /** The xml-tag name which contains a migel-drug row */
   public static final String RECORD_MIGEL = "invoice:record_migel";
   /** The xml-tag name which contains a tarmed-drg row */
   public static final String RECORD_DRG = "invoice:record_drg";
   /** The xml-tag name which contains a tarmed-drug row */
   public static final String RECORD_PARAMED = "invoice:record_paramed";
   /** The xml-tag name which contains a tarmed-drug row */
   public static final String RECORD_DRUG = "invoice:record_drug";
   /** The xml-tag name which contains a tarmed-lab row */
   public static final String RECORD_LAB = "invoice:record_lab";
   /** The xml-tag name which contains a tarmed-record row */
   public static final String RECORD_TARMED = "invoice:record_tarmed";
   /** the xml-tag element which contains the tarifziffer value */
   public static final String RECORD_TARMED_TAG_CODE = "code";
   /** The total duration of the treatment, regarding a specific tarifziffer */
   public static final String TREATMENT_DATA_DURATION = "treatment_duration";
   /** the xml-tag element within the record_tarmed data which defines the begin of the treatment */
   public static final String RECORD_TARMET_TREATMENT_DATA_BEGIN = "date_begin";
   /** the xml-tag element within the record_tarmed data which defines the end of the treatment */
   public static final String RECORD_TARMET_TREATMENT_DATA_END = "date_end";
}
