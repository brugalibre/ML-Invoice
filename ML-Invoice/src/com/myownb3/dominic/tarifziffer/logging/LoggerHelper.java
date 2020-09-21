package com.myownb3.dominic.tarifziffer.logging;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggerHelper {

   private static final int DEFAULT_TIMESTAMP_NO = -1;
   public static final LoggerHelper INSTANCE = new LoggerHelper();
   private Map<Integer, ThreadLocal<Long>> requestId2StartTimeStampMap = new HashMap<>();

   private LoggerHelper() {
      this.requestId2StartTimeStampMap = new HashMap<>();
   }

   /**
    * Logs the given message with {@link Level#INFO} using the given logger and starts also a time stamp
    * This time stamp is used to indicate a duration between to logged messages
    * 
    * @param logger
    *        the {@link Logger}
    * @param msg
    *        the message to LOG
    * @see LoggerHelper#endLogInfo(Logger, String)
    */
   public void startLogInfo(Logger logger, String msg) {
      startLogInfoInternal(logger, msg, DEFAULT_TIMESTAMP_NO);
   }

   /**
    * Logs the given message with {@link Level#INFO} using the given logger and starts also a time stamp
    * This time stamp is used to indicate a duration between to logged messages
    * 
    * @param logger
    *        the {@link Logger}
    * @param msg
    *        the message to LOG
    * @param requestId
    *        the id of the request to log
    * @see LoggerHelper#endLogInfo(Logger, String)
    */
   public void startLogInfo(Logger logger, String msg, int requestId) {
      startLogInfoInternal(logger, msg, requestId);
   }

   private void startLogInfoInternal(Logger logger, String msg, int defaultTimestampNo) {
      ThreadLocal<Long> startTimeStamp = new ThreadLocal<>();
      requestId2StartTimeStampMap.put(defaultTimestampNo, startTimeStamp);
      startTimeStamp.set(System.currentTimeMillis());
      logger.info(msg);
   }

   /**
    * Logs the given message with {@link Level#INFO} using the given logger and appends the duration between the previous logged message
    * and this one
    * 
    * @param logger
    *        the {@link Logger}
    * @param msg
    *        the message to LOG
    */
   public void endLogInfo(Logger logger, String msg) {
      ThreadLocal<Long> startTimeStamp = requestId2StartTimeStampMap.get(DEFAULT_TIMESTAMP_NO);
      endLogInfo(logger, msg, startTimeStamp);
   }

   /**
    * Logs the given message with {@link Level#INFO} using the given logger and appends the duration between the previous logged message
    * and this one
    * 
    * @param logger
    *        the {@link Logger}
    * @param msg
    *        the message to LOG
    * @param requestId
    *        the id of the request to log
    */
   public void endLogInfo(Logger logger, String msg, int requsetId) {
      ThreadLocal<Long> startTimeStamp = requestId2StartTimeStampMap.get(requsetId);
      endLogInfo(logger, msg, startTimeStamp);
   }

   private void endLogInfo(Logger logger, String msg, ThreadLocal<Long> startTimeStamp) {
      String timeConsumedInfo = "(time consumed " + (System.currentTimeMillis() - startTimeStamp.get()) + "ms)";
      logger.info(String.format(msg, timeConsumedInfo));
      startTimeStamp.remove();
   }

   /**
    * Logs the given message to the given {@link Logger} at the given {@link Level} if this lebel is enabled
    * 
    * @param logger
    *        the {@link Logger}
    * @param logMsgSupplier
    *        the {@link Supplier} which provides the message
    * @param debug
    *        the LOG {@link Level}
    */
   public void logIfEnabled(Logger logger, Supplier<String> logMsgSupplier, Level level) {
      if (logger.isEnabledFor(level)) {
         logger.log(level, logMsgSupplier.get());
      }
   }
}
