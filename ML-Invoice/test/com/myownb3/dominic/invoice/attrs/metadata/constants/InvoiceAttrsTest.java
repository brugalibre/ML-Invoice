package com.myownb3.dominic.invoice.attrs.metadata.constants;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.myownb3.dominic.invoice.attrs.metadata.InvoiceAttr;
import com.myownb3.dominic.invoice.attrs.metadata.NominalInvoiceAttr;

class InvoiceAttrsTest {

   @Test
   void testBuildAndSortNominalAttributes() {

      // Given
      NominalInvoiceAttr invoiceAttrSectionCode = InvoiceAttrs.SECTION_CODE;// sequence 230
      int lastIndex = InvoiceAttrValues.getSectionCodeValues().size() - 1;
      String expectedNamePrefix = invoiceAttrSectionCode.getName() + "_";

      // When
      List<InvoiceAttr> sectionCodeCategoricalAttributes = InvoiceAttrs.INSTANCE.buildInvoiceAttrs4CategoricalValues(invoiceAttrSectionCode);
      Collections.shuffle(sectionCodeCategoricalAttributes);
      Collections.sort(sectionCodeCategoricalAttributes, Comparator.comparing(InvoiceAttr::getSequence));

      // Then
      InvoiceAttr first = sectionCodeCategoricalAttributes.get(0);
      InvoiceAttr last = sectionCodeCategoricalAttributes.get(lastIndex);
      assertThat(first.getName(), is(expectedNamePrefix + InvoiceAttrValues.getSectionCodeValues().get(0)));
      assertThat(last.getName(), is(expectedNamePrefix + InvoiceAttrValues.getSectionCodeValues().get(lastIndex)));
   }

   @Test
   void testBuildAndSortTwoNominalAttributes() {

      // Given
      NominalInvoiceAttr sectionCodeAttr = InvoiceAttrs.SECTION_CODE;// sequence 230
      NominalInvoiceAttr treatmentReasonAttr = InvoiceAttrs.TREATMENT_REASON;// sequence 500
      List<String> treatmentReasonValues = InvoiceAttrValues.getTreatmentReasonValues();

      // When
      List<InvoiceAttr> treatmentCategoricalAttributes = InvoiceAttrs.INSTANCE.buildInvoiceAttrs4CategoricalValues(treatmentReasonAttr);
      List<InvoiceAttr> sectionCodeCategoricalAttributes = InvoiceAttrs.INSTANCE.buildInvoiceAttrs4CategoricalValues(sectionCodeAttr);
      List<InvoiceAttr> allCategoricalAttributes = new ArrayList<>(treatmentCategoricalAttributes);
      allCategoricalAttributes.addAll(sectionCodeCategoricalAttributes);
      Collections.shuffle(allCategoricalAttributes);
      Collections.sort(allCategoricalAttributes, Comparator.comparing(InvoiceAttr::getSequence));

      // Then
      InvoiceAttr first = allCategoricalAttributes.get(0);
      InvoiceAttr last = allCategoricalAttributes.get(allCategoricalAttributes.size() - 1);
      assertThat(first.getName(), is(sectionCodeAttr.getName() + "_" + InvoiceAttrValues.getSectionCodeValues().get(0)));
      assertThat(last.getName(), is(treatmentReasonAttr.getName() + "_" + treatmentReasonValues.get(treatmentReasonValues.size() - 1)));
   }

}
