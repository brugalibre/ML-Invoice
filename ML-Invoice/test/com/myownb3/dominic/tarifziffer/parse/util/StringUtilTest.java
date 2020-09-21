package com.myownb3.dominic.tarifziffer.parse.util;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.myownb3.dominic.invoice.util.StringUtil;

class StringUtilTest {

   @Test
   void testFlattenInRightOrder() {

      // Given
      String s1 = "s1";
      String s2 = "s2";
      String s3 = "s3";

      List<String> stringList = Arrays.asList(s1, s2, s3);
      String expectedFlattenedString = s1 + ";" + s2 + ";" + s3 + ";";

      // Then
      String actualFlattenedString = stringList.stream()
            .map(s -> s + ";")
            .collect(Collectors.collectingAndThen(Collectors.toList(), StringUtil.flattenList()));

      // When
      assertThat(actualFlattenedString, is(expectedFlattenedString));
   }

   @Test
   void testTrim_DoTrim() {

      // Given
      String value1 = "00.00200";
      String expectedValue1 = "0.002";
      String value2 = "0.00200";
      String expectedValue2 = "0.002";
      String value3 = "01.00200";
      String expectedValue3 = "1.002";

      // When
      String actualTrimmedValue1 = StringUtil.trim(value1);
      String actualTrimmedValue2 = StringUtil.trim(value2);
      String actualTrimmedValue3 = StringUtil.trim(value3);

      // Then
      assertThat(actualTrimmedValue1, is(expectedValue1));
      assertThat(actualTrimmedValue2, is(expectedValue2));
      assertThat(actualTrimmedValue3, is(expectedValue3));
   }

   @Test
   void testTrim_DontTrim() {

      // Given
      String value1 = "002001";
      String expectedValue1 = "002001";
      String value2 = "02001";
      String expectedValue2 = "02001";
      String value3 = "0.0164";
      String expectedValue3 = "0.0164";
      String value4 = "97090.001";
      String expectedValue4 = "97090.001";
      String value5 = "64.0";
      String expectedValue5 = "64.0";

      // When
      String actualTrimmedValue1 = StringUtil.trim(value1);
      String actualTrimmedValue2 = StringUtil.trim(value2);
      String actualTrimmedValue3 = StringUtil.trim(value3);
      String actualTrimmedValue4 = StringUtil.trim(value4);
      String actualTrimmedValue5 = StringUtil.trim(value5);

      // Then
      assertThat(actualTrimmedValue1, is(expectedValue1));
      assertThat(actualTrimmedValue2, is(expectedValue2));
      assertThat(actualTrimmedValue3, is(expectedValue3));
      assertThat(actualTrimmedValue4, is(expectedValue4));
      assertThat(actualTrimmedValue5, is(expectedValue5));
   }

}
