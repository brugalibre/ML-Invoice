package com.myownb3.dominic.invoice.attrs.metadata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myownb3.dominic.invoice.attrs.InvoiceAttr;
import com.myownb3.dominic.invoice.exception.AttrHasNoValuesException;

/**
 * For classified {@link InvoiceAttrs} this class defines the possible values
 * 
 * @author Dominic
 *
 */
public class InvoiceAttrValues {

   private static final Map<String, List<String>> COLUMN_TO_VALUES;

   static {
      COLUMN_TO_VALUES = new HashMap<>();
      COLUMN_TO_VALUES.put(InvoiceAttrs.BILLING_ROLE.getName(), Arrays.asList("mt", "tt", "both", "none"));
      COLUMN_TO_VALUES.put(InvoiceAttrs.BODY_LOCATION.getName(), Arrays.asList("none", "left", "right"));
      COLUMN_TO_VALUES.put(InvoiceAttrs.MEDICAL_ROLE.getName(), Arrays.asList("self_employed", "employee"));
      COLUMN_TO_VALUES.put(InvoiceAttrs.TREATMENT.getName(), Arrays.asList("ambulatory", "stationary"));
   }

   private InvoiceAttrValues() {
      // private
   }

   public static List<String> getPossibleValues4AttributeName(InvoiceAttr attrName) {
      if (COLUMN_TO_VALUES.containsKey(attrName.getName())) {
         return COLUMN_TO_VALUES.get(attrName.getName());
      }
      throw new AttrHasNoValuesException("Attribute '" + attrName + "' is not a class value!");
   }

}
