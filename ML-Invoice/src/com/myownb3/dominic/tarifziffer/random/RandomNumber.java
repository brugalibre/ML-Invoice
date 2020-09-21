package com.myownb3.dominic.tarifziffer.random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The {@link RandomNumber} provides pseudo random number using the {@link ThreadLocalRandom}
 * 
 * @author dominic
 *
 */
public class RandomNumber {

   private RandomNumber() {
      // private 
   }

   /**
    * @return the next random integer
    */
   public static int getNext() {
      ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
      return threadLocalRandom.nextInt();
   }
}
