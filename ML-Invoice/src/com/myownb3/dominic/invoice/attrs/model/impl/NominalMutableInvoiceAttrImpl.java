package com.myownb3.dominic.invoice.attrs.model.impl;

import java.util.List;

import com.myownb3.dominic.invoice.attrs.metadata.InvoiceAttr;
import com.myownb3.dominic.invoice.attrs.metadata.NominalInvoiceAttr;

public class NominalMutableInvoiceAttrImpl extends StringMutableInvoiceAttrImpl implements NominalMutableInvoiceAttr {

   private String name;
   private int sequence;

   /**
    * Builds a {@link NominalMutableInvoiceAttrImpl} whereas this {@link NominalMutableInvoiceAttrImpl} represents one specific value of the
    * category. The name of this attribute is therefore a combination of the name of it's meta attribute combined with an '_' and the name
    * of the specific value.
    * 
    * E.g. 'section_code_M000' where 'section_code' is the name of the meta attribute and 'M000' the name of a categorical value of this
    * attribute
    * 
    * Therefore the sequence of this {@link NominalMutableInvoiceAttrImpl} is based on the sequence of it's meta attribute and the order
    * number of the specific categorical value
    * 
    * @param invoiceAttr
    *        the {@link InvoiceAttr} which defines the meta nominal {@link InvoiceAttr}
    * @param value
    *        the specific categorical element
    */
   private NominalMutableInvoiceAttrImpl(NominalInvoiceAttr invoiceAttr, String name, double value) {
      this(invoiceAttr, String.valueOf(value));
      this.name = name;
      String categoryName = name.replace(invoiceAttr.getName() + "_", "");
      this.sequence = evalSequence(categoryName);
   }

   private int evalSequence(String value) {
      int indexOfValue = getCategoricalValues().indexOf(value);
      if (indexOfValue < 0) {
         throw new IllegalStateException("Categorical value '" + value + "' is not a legal category of attribute '" + invoiceAttr.getName() + "'");
      }
      return invoiceAttr.getSequence() + indexOfValue;
   }

   /**
    * Builds a {@link NominalMutableInvoiceAttrImpl}. This attribute is a meta-{@link NominalInvoiceAttr} and therefore the value of this
    * {@link NominalInvoiceAttr} is one specific element of the category of the given {@link InvoiceAttr}.
    * 
    * @param invoiceAttr
    *        the {@link InvoiceAttr} which defines the meta nominal {@link InvoiceAttr}
    * @param value
    *        the specific categorical element
    */
   /* visible 4 factory*/ NominalMutableInvoiceAttrImpl(NominalInvoiceAttr invoiceAttr, String value) {
      super(invoiceAttr, value);
      this.name = invoiceAttr.getName();
      this.sequence = invoiceAttr.getSequence();
   }

   @Override
   public String buildCategoricalAttrName(String categoricalValue) {
      return getNominalInvoiceAttr().buildCategoricalAttrName(categoricalValue);
   }

   @Override
   public int getSequence() {
      return sequence;
   }

   @Override
   public String getName() {
      return name;
   }

   @Override
   public List<String> getCategoricalValues() {
      return getNominalInvoiceAttr().getCategoricalValues();
   }

   @Override
   public String getCategoryName() {
      return getNominalInvoiceAttr().getCategoryName();
   }

   private NominalInvoiceAttr getNominalInvoiceAttr() {
      return (NominalInvoiceAttr) invoiceAttr;
   }

   /**
    * Creates a new {@link NominalMutableInvoiceAttrImpl} with the given meta {@link InvoiceAttr} and String value
    * 
    * @param invoiceAttr
    *        the given meta {@link InvoiceAttr}
    * @param value
    *        the value
    * @return a new {@link DateMutableInvoiceAttrImpl}
    */
   public static NominalMutableInvoiceAttrImpl of(NominalInvoiceAttr invoiceAttr, String value) {
      return new NominalMutableInvoiceAttrImpl(invoiceAttr, value);
   }

   /**
    * Builds a {@link NominalMutableInvoiceAttrImpl} for a specific value of all possible values for this category. This value is now the
    * name of this
    * {@link NominalInvoiceAttr} where as the actual value is the counter which count's the occurrences
    * 
    * @param invoiceAttr
    *        the {@link NominalInvoiceAttr}
    * @param name
    *        the name / category of this NominalMutableInvoiceAttr
    * @param value
    *        the initial value
    */
   public static NominalMutableInvoiceAttrImpl of(NominalInvoiceAttr invoiceAttr, String name, double value) {
      return new NominalMutableInvoiceAttrImpl(invoiceAttr, name, value);
   }
}
