package com.myownb3.dominic.invoice.attrs.metadata.impl;

import java.util.List;

import com.myownb3.dominic.invoice.attrs.metadata.NominalInvoiceAttr;
import com.myownb3.dominic.invoice.attrs.metadata.constants.InvoiceAttrValues;
import com.myownb3.dominic.invoice.attrs.metadata.constants.InvoiceAttrs;
import com.myownb3.dominic.invoice.attrs.metadata.type.ContentType;
import com.myownb3.dominic.invoice.exception.AttrHasNoValuesException;
import com.myownb3.dominic.invoice.util.StringUtil;

public class NominalInvoiceAttrImpl extends InvoiceAttrImpl implements NominalInvoiceAttr {

   private String categoryName;

   protected NominalInvoiceAttrImpl(String categoryName, String name, int sequence, boolean isRelevant4Vectorizing, ContentType contentType,
         String defaultValue) {
      super(name, sequence, isRelevant4Vectorizing, contentType, defaultValue);
      this.categoryName = categoryName;
   }

   public NominalInvoiceAttrImpl(String name, int sequence, boolean isRelevant4Vectorizing, ContentType contentType) {
      super(name, sequence, isRelevant4Vectorizing, contentType);
      this.categoryName = name;
   }

   public NominalInvoiceAttrImpl(String name, int sequence, String defaultValue) {
      super(name, sequence, true, ContentType.SERVICES_DATA, defaultValue);
      this.categoryName = name;
   }

   @Override
   public String buildCategoricalAttrName(String categoricalValue) {
      return StringUtil.trim(getName()) + "_" + StringUtil.trim(categoricalValue);// Like this we can distinguish multiple values named 'none'
   }

   @Override
   public String getCategoryName() {
      return categoryName;
   }

   @Override
   public boolean isNominal() {
      return true;
   }

   @Override
   public List<String> getCategoricalValues() {
      if (categoryName.equals(InvoiceAttrs.BILLING_ROLE.getName())) {
         return InvoiceAttrValues.getBillingRoleValues();
      } else if (categoryName.equals(InvoiceAttrs.BODY_LOCATION.getName())) {
         return InvoiceAttrValues.getBodyLocationValues();
      } else if (categoryName.equals(InvoiceAttrs.MEDICAL_ROLE.getName())) {
         return InvoiceAttrValues.getMedicalRoleValues();
      } else if (categoryName.equals(InvoiceAttrs.TREATMENT.getName())) {
         return InvoiceAttrValues.getTreatmentValues();
      } else if (categoryName.equals(InvoiceAttrs.TREATMENT_REASON.getName())) {
         return InvoiceAttrValues.getTreatmentReasonValues();
      } else if (categoryName.equals(InvoiceAttrs.GENDER.getName())) {
         return InvoiceAttrValues.getGenderValues();
      } else if (categoryName.equals(InvoiceAttrs.SECTION_CODE.getName())) {
         // Values according to https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&ved=2ahUKEwiln8K25ojsAhWjsKQKHfknB2EQFjAAegQIBRAB&url=https%3A%2F%2Fwww.bfs.admin.ch%2Fbfsstatic%2Fdam%2Fassets%2F4986791%2Fmaster&usg=AOvVaw2MLSG-7YjMrL7Dx5SJmf8W
         return InvoiceAttrValues.getSectionCodeValues();
      } else if (categoryName.equals(InvoiceAttrs.CODE.getName())) {
         return InvoiceAttrValues.getCodeValues();
      } else if (categoryName.equals(InvoiceAttrs.TARIFF_TYPE.getName())) {
         return InvoiceAttrValues.getTarifTypeValues();
      }
      throw new AttrHasNoValuesException("Attribute '" + categoryName + "' has no class values defined!");
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (!super.equals(obj))
         return false;
      if (getClass() != obj.getClass())
         return false;
      NominalInvoiceAttrImpl other = (NominalInvoiceAttrImpl) obj;
      if (categoryName == null) {
         if (other.categoryName != null)
            return false;
      } else if (!categoryName.equals(other.categoryName))
         return false;
      return true;
   }

}
