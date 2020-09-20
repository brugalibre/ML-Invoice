package com.myownb3.dominic.invoice.attrs.metadata;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.myownb3.dominic.invoice.attrs.DateInvoiceAttr;
import com.myownb3.dominic.invoice.attrs.InvoiceAttr;
import com.myownb3.dominic.invoice.attrs.impl.DateInvoiceAttrImpl;
import com.myownb3.dominic.invoice.attrs.impl.InvoiceAttrImpl;

/**
 * Defines all the different attributes of an invoice record
 * 
 * @author Dominic
 *
 */
public class InvoiceAttrs {

   private static final String YYYY_MM_DD_T_HH_MM_SS_SSS = "YYYY-MM-dd'T'HH:mm:ss.SSS";

   private InvoiceAttrs() {
      // private
   }

   public static final InvoiceAttr AMOUNT = new InvoiceAttrImpl("amount", 1);
   public static final InvoiceAttr AMOUNT_MT = new InvoiceAttrImpl("amount_mt", 2);
   public static final InvoiceAttr AMOUNT_TT = new InvoiceAttrImpl("amount_tt", 3);
   public static final InvoiceAttr BILLING_ROLE = new InvoiceAttrImpl("billing_role", 4);
   public static final InvoiceAttr BODY_LOCATION = new InvoiceAttrImpl("body_location", 5);
   public static final InvoiceAttr CODE = new InvoiceAttrImpl("code", 6);
   public static final DateInvoiceAttr DATE_BEGIN = new DateInvoiceAttrImpl("date_begin", YYYY_MM_DD_T_HH_MM_SS_SSS, 7);
   public static final DateInvoiceAttr DATE_END = new DateInvoiceAttrImpl("date_end", YYYY_MM_DD_T_HH_MM_SS_SSS, 8);
   public static final InvoiceAttr EXTERNAL_FACTOR_MT = new InvoiceAttrImpl("external_factor_mt", 9);
   public static final InvoiceAttr EXTERNAL_FACTOR_TT = new InvoiceAttrImpl("external_factor_tt", 10);
   public static final InvoiceAttr MEDICAL_ROLE = new InvoiceAttrImpl("medical_role", 11);
   public static final InvoiceAttr NAME = new InvoiceAttrImpl("name", 12, false);
   public static final InvoiceAttr OBLIGATION = new InvoiceAttrImpl("obligation", 13);
   public static final InvoiceAttr PROVIDER_ID = new InvoiceAttrImpl("provider_id", 14);
   public static final InvoiceAttr QUANTITY = new InvoiceAttrImpl("quantity", 15);
   public static final InvoiceAttr RECORD_ID = new InvoiceAttrImpl("record_id", 16, false);
   public static final InvoiceAttr REF_CODE = new InvoiceAttrImpl("ref_code", 17);
   public static final InvoiceAttr RESPONSIBLE_ID = new InvoiceAttrImpl("responsible_id", 18);
   public static final InvoiceAttr SCALE_FACTOR_MT = new InvoiceAttrImpl("scale_factor_mt", 19);
   public static final InvoiceAttr SCALE_FACTOR_TT = new InvoiceAttrImpl("scale_factor_tt", 20);
   public static final InvoiceAttr SECTION_CODE = new InvoiceAttrImpl("section_code", 21);
   public static final InvoiceAttr SESSION = new InvoiceAttrImpl("session", 22);
   public static final InvoiceAttr TARIFF_TYPE = new InvoiceAttrImpl("tariff_type", 23);
   public static final InvoiceAttr TREATMENT = new InvoiceAttrImpl("treatment", 24);
   public static final InvoiceAttr UNIT_FACTOR_MT = new InvoiceAttrImpl("unit_factor_mt", 25);
   public static final InvoiceAttr UNIT_FACTOR_TT = new InvoiceAttrImpl("unit_factor_tt", 26);
   public static final InvoiceAttr UNIT_MT = new InvoiceAttrImpl("unit_mt", 27);
   public static final InvoiceAttr UNIT_TT = new InvoiceAttrImpl("unit_tt", 28);
   public static final InvoiceAttr VALIDATE = new InvoiceAttrImpl("validate", 29);
   public static final InvoiceAttr BIRTHDATE = new DateInvoiceAttrImpl("gender", YYYY_MM_DD_T_HH_MM_SS_SSS, 30);
   public static final InvoiceAttr AGE = new InvoiceAttrImpl("gender", 31);
   public static final InvoiceAttr GENDER = new InvoiceAttrImpl("validate", 32);

   /**
    * @returns a {@link List} of {@link InvoiceAttr} which are relevant for vectorizing and exporting
    */
   public static List<InvoiceAttr> getAllRelevantInvoiceAttrs() {
      return Arrays.asList(AMOUNT, AMOUNT_MT, AMOUNT_TT, BILLING_ROLE, BODY_LOCATION, CODE, DATE_BEGIN, DATE_END, EXTERNAL_FACTOR_MT,
            EXTERNAL_FACTOR_TT, MEDICAL_ROLE, NAME, OBLIGATION, PROVIDER_ID, QUANTITY, RECORD_ID, REF_CODE, RESPONSIBLE_ID, SCALE_FACTOR_MT,
            SCALE_FACTOR_TT, SECTION_CODE, SESSION, TARIFF_TYPE, TREATMENT, UNIT_FACTOR_MT, UNIT_FACTOR_TT, UNIT_MT, UNIT_TT, VALIDATE, BIRTHDATE,
            AGE, GENDER)
            .stream()
            .filter(InvoiceAttr::isRelevant4Vectorizing)
            .sorted(Comparator.comparing(InvoiceAttr::getSequence))
            .collect(Collectors.toList());
   }
}
