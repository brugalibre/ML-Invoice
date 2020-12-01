package com.myownb3.dominic.invoice.attrs.metadata.constants;

import java.util.Arrays;
import java.util.List;

/**
 * For classified {@link InvoiceAttrs} this class defines the possible values
 * 
 * @author Dominic
 *
 */
public class InvoiceAttrValues {

   /** String literal for the treatment type 'stationary' */
   public static final String TREATMENT_STATIONARY = "stationary";

   /**
    * String literal for the treatment type 'ambulatory'. According the 'generalinvoicerequest_440-4' this is the default value for this
    * attribute
    */
   public static final String TREATMENT_AMBULATORY = "ambulatory";

   /**
    * String literal for the body-location 'none'. According the 'generalinvoicerequest_440-4' this is the default value for this attribute
    */
   public static final String BODY_LOCATION_NONE = "none";

   /**
    * String literal for the billing-role 'none'. According the 'generalinvoicerequest_440-4' this is the default value for this attribute
    */
   public static final String BILLING_ROLE_BOTH = "both";

   /**
    * String literal for the medical-role 'self_employed'. According the 'generalinvoicerequest_440-4' this is the default value for this
    * attribute
    */
   public static final String MEDICAL_ROLE_SELF_EMPLOYED = "self_employed";

   /** String literal for the section-code 'None'. This value is only set for hospitals */
   public static final String SECTION_CODE_NONE = "none";

   private static final List<String> BODY_LOCATION_VALUES = Arrays.asList(BODY_LOCATION_NONE, "left", "right");

   private static final List<String> BILLING_ROLE_VALUES = Arrays.asList("mt", "tt", BILLING_ROLE_BOTH, "none");

   private static final List<String> MEDICAL_ROLE_VALUES = Arrays.asList(MEDICAL_ROLE_SELF_EMPLOYED, "employee");

   private static final List<String> SECTION_CODE_VALUES = Arrays.asList("M000", "M050", "M100", "M200", "M300",
         "M400", "M500", "M600", "M700", "M800", "M850", "M900", "M950", "M960", "M970", "M990", SECTION_CODE_NONE);

   private static final List<String> CODE_VALUES = InvoiceConstants.getAllPossibleCodeValues();

   private static final List<String> TREATMENT_VALUES = Arrays.asList(TREATMENT_AMBULATORY, TREATMENT_STATIONARY);

   private static final List<String> TREATMENT_REASON_VALUES = Arrays.asList("disease", "accident", "maternity",
         "prevention", "birthdefect", "unknown");

   private static final List<String> GENDER_VALUES = Arrays.asList("male", "female");
   private static final List<String> TARIF_TYPE_VALUES = Arrays.asList("001", "003", "312", "325");

   /**
    * All possible values for the categorical attribute 'body location'
    */
   public static List<String> getBodyLocationValues() {
      return BODY_LOCATION_VALUES;
   }

   /**
    * @return all possible values for the categorical attribute 'billing role'
    */
   public static List<String> getBillingRoleValues() {
      return BILLING_ROLE_VALUES;
   }

   /**
    * @return all possible values for the categorical attribute 'medical role'
    */
   public static List<String> getMedicalRoleValues() {
      return MEDICAL_ROLE_VALUES;
   }

   /**
    * @return all possible values for the categorical attribute 'section code'
    */
   public static List<String> getSectionCodeValues() {
      return SECTION_CODE_VALUES;
   }

   /**
    * For the given anonymized invoices, this are all possible code values. Note that depending on the data, there might be even more
    * For total safety, all possible tarifziffern according tarmed, DRG and so one should be collected
    */
   public static List<String> getCodeValues() {
      return CODE_VALUES;
   }

   /**
    * For the given anonymized invoices, this are all possible tarif type values. Note that depending on the data, there might be even more
    * For total safety, all possible tarif types according tarmed, DRG and so one should be collected
    */
   public static List<String> getTarifTypeValues() {
      return TARIF_TYPE_VALUES;
   }

   /**
    * @return all possible values for the categorical attribute 'treatment'
    */
   public static List<String> getTreatmentValues() {
      return TREATMENT_VALUES;
   }

   /**
    * @return all possible values for the categorical attribute 'treatment_reason'
    */
   public static List<String> getTreatmentReasonValues() {
      return TREATMENT_REASON_VALUES;
   }

   /**
    * @return all possible values for the categorical attribute 'gender'
    */
   public static List<String> getGenderValues() {
      return GENDER_VALUES;
   }

   private InvoiceAttrValues() {
      // private
   }
}
