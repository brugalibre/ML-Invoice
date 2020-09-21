package com.myownb3.dominic.invoice.util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringUtil {

   private static final String REMOVE_TRAILLING_ZEROS = "0*$";
   private static final String REMOVE_LEADING_ZEROS = "^(0+(?![.]))";
   private static final String ZERO = "0";

   private StringUtil() {
      // private
   }

   /**
    * Appends a line break at each value of the given list
    * 
    * @return the same list but each value ends with a line break
    */
   public static Function<List<String>, List<String>> appendLineBreaks() {
      return stringList -> stringList.parallelStream()
            .map(value -> value + System.lineSeparator())
            .collect(Collectors.toList());
   }

   /**
    * Flattens the given List of String and appends each element of the string to the next one.
    * All entries are separated by a new line break
    * 
    * @return a single String
    */
   public static Function<List<String>, String> flattenListnl() {
      return stringList -> stringList.parallelStream()
            .reduce("", (a, b) -> StringUtil.appendStrings(a, b, System.lineSeparator()));
   }

   /**
    * Flattens the given List of String and appends each element of the string to the next one.
    * 
    * @return a single String
    */
   public static Function<List<String>, String> flattenList() {
      return stringList -> stringList.parallelStream()
            .reduce("", (a, b) -> StringUtil.appendStrings(a, b, ""));
   }

   private static String appendStrings(String s1, String s2, String combiner) {
      if (s1.isEmpty()) {
         return s2;
      }
      return s1 + (s2.isEmpty() ? "" : combiner + s2);
   }


   /**
    * Removes all leading and trailing zeros
    * e.g. a value 00.00200 -> 0.002
    * 
    * @param value
    * @return a trimmed value
    */
   public static String trim(String value) {
      if (value.endsWith(ZERO) || value.startsWith(ZERO)) {
         return trimTrailingAndLeadingZeros(value);
      }
      return value;
   }

   private static String trimTrailingAndLeadingZeros(String value) {
      return value.indexOf(".") < 0 ? value : value.replaceAll(REMOVE_TRAILLING_ZEROS, "").replaceFirst(REMOVE_LEADING_ZEROS, "");
   }
}
