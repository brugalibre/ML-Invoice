package com.myownb3.dominic.invoice.attrs.metadata.impl;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

import com.myownb3.dominic.invoice.attrs.metadata.InvoiceAttr;
import com.myownb3.dominic.invoice.attrs.metadata.constants.InvoiceAttrValues;
import com.myownb3.dominic.invoice.attrs.metadata.constants.InvoiceAttrs;
import com.myownb3.dominic.invoice.attrs.metadata.type.ContentType;

public class InvoiceAttrImpl implements InvoiceAttr {

   private String name;
   private boolean isRelevant4Vectorizing;
   private int sequence;
   private ContentType contentType;
   private String value;
   private String defaultValue;

   public InvoiceAttrImpl(String name, int sequence, boolean isRelevant4Vectorizing) {
      this(name, sequence, isRelevant4Vectorizing, ContentType.SERVICES_DATA, "-");
   }

   public InvoiceAttrImpl(String name, int sequence, boolean isRelevant4Vectorizing, ContentType contentType) {
      this(name, sequence, isRelevant4Vectorizing, contentType, "-");
   }

   public InvoiceAttrImpl(String name, int sequence, boolean isRelevant4Vectorizing, ContentType contentType, String defaultValue) {
      this.name = requireNonNull(name);
      this.contentType = requireNonNull(contentType);
      this.defaultValue = requireNonNull(defaultValue);
      this.isRelevant4Vectorizing = isRelevant4Vectorizing;
      this.sequence = sequence;
   }

   @Override
   public String getName() {
      return name;
   }

   @Override
   public String getValue() {
      return value;
   }

   @Override
   public String getValidValue(String invalidValue) {
      return getDefaultValue();
   }

   @Override
   public boolean isValueValid(String value) {
      if (isTreatmentAttribute()) {
         return InvoiceAttrValues.getTreatmentValues().contains(value);
      } else if (isSectionCodeAttribute()) {
         return InvoiceAttrValues.getSectionCodeValues().contains(value);
      } else if (isMedicalRoleAttribute()) {
         return InvoiceAttrValues.getMedicalRoleValues().contains(value);
      } else if (isBodyLocationAttribute()) {
         return InvoiceAttrValues.getBodyLocationValues().contains(value);
      } else if (isBillingRoleAttribute()) {
         return InvoiceAttrValues.getBillingRoleValues().contains(value);
      }
      return nonNull(value);
   }

   @Override
   public String getDefaultValue() {
      return defaultValue;
   }

   @Override
   public boolean isRelevant4Vectorizing() {
      return isRelevant4Vectorizing;
   }

   @Override
   public boolean isNominal() {
      return false;
   }

   @Override
   public boolean isDate() {
      return false;
   }

   @Override
   public boolean isDouble() {
      return false;
   }

   @Override
   public boolean isInteger() {
      return false;
   }

   @Override
   public ContentType getContentType() {
      return contentType;
   }

   @Override
   public String toString() {
      return name + "=" + value;
   }

   @Override
   public int getSequence() {
      return sequence;
   }

   private boolean isTreatmentAttribute() {
      return InvoiceAttrs.TREATMENT.getName().equals(name);
   }

   private boolean isSectionCodeAttribute() {
      return InvoiceAttrs.SECTION_CODE.getName().equals(name);
   }

   private boolean isMedicalRoleAttribute() {
      return InvoiceAttrs.MEDICAL_ROLE.getName().equals(name);
   }

   private boolean isBodyLocationAttribute() {
      return InvoiceAttrs.BODY_LOCATION.getName().equals(name);
   }

   private boolean isBillingRoleAttribute() {
      return InvoiceAttrs.BILLING_ROLE.getName().equals(name);
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
      result = prime * result + ((defaultValue == null) ? 0 : defaultValue.hashCode());
      result = prime * result + (isRelevant4Vectorizing ? 1231 : 1237);
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = (prime * result + sequence);
      result = prime * result + ((value == null) ? 0 : value.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      InvoiceAttrImpl other = (InvoiceAttrImpl) obj;
      if (contentType != other.contentType)
         return false;
      if (defaultValue == null) {
         if (other.defaultValue != null)
            return false;
      } else if (!defaultValue.equals(other.defaultValue))
         return false;
      if (isRelevant4Vectorizing != other.isRelevant4Vectorizing)
         return false;
      if (name == null) {
         if (other.name != null)
            return false;
      } else if (!name.equals(other.name))
         return false;
      return equalsPart2(other);
   }

   private boolean equalsPart2(InvoiceAttrImpl other) {
      if (sequence != other.sequence)
         return false;
      if (value == null) {
         if (other.value != null)
            return false;
      } else if (!value.equals(other.value))
         return false;
      return true;
   }
}
