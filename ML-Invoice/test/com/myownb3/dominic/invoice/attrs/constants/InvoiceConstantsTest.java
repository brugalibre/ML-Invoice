package com.myownb3.dominic.invoice.attrs.constants;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.myownb3.dominic.invoice.attrs.metadata.constants.InvoiceConstants;

class InvoiceConstantsTest {

   @Test
   void testGetAllPossibleCodeValues() {
      // Given
      int expectedSize = 16251;

      // When
      List<String> allPossibleCodeValues = InvoiceConstants.getAllPossibleCodeValues();

      // Then
      assertThat(allPossibleCodeValues.size(), is(expectedSize));
   }

}
