package com.myownb3.dominic.invoice.attrs.impl;

import com.myownb3.dominic.invoice.attrs.InvoiceAttr;

public class InvoiceAttrImpl implements InvoiceAttr {

   private String name;
   private boolean isRelevant4Vectorizing;
   private int sequence;

   public InvoiceAttrImpl(String name, int sequence) {
      setAttrs(name, sequence, true);
   }

   public InvoiceAttrImpl(String name, int sequence, boolean isRelevant4Vectorizing) {
      setAttrs(name, sequence, isRelevant4Vectorizing);
   }

   private void setAttrs(String name, int sequence, boolean isRelevant4Vectorizing) {
      this.name = name;
      this.isRelevant4Vectorizing = isRelevant4Vectorizing;
      this.sequence = sequence;
   }

   @Override
   public String getName() {
      return name;
   }

   @Override
   public boolean isRelevant4Vectorizing() {
      return isRelevant4Vectorizing;
   }

   @Override
   public int getSequence() {
      return sequence;
   }
}
