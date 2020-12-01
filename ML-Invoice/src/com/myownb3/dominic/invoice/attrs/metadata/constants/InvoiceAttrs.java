package com.myownb3.dominic.invoice.attrs.metadata.constants;

import static com.myownb3.dominic.invoice.attrs.constants.InvoiceXMLConstants.INVOICE_SUFFIX;
import static com.myownb3.dominic.invoice.attrs.constants.InvoiceXMLConstants.PATIENT_DATA_AGE;
import static com.myownb3.dominic.invoice.attrs.constants.InvoiceXMLConstants.PATIENT_DATA_BIRTHDATE;
import static com.myownb3.dominic.invoice.attrs.constants.InvoiceXMLConstants.TREATMENT_DATA_BEGIN;
import static com.myownb3.dominic.invoice.attrs.constants.InvoiceXMLConstants.TREATMENT_DATA_DURATION;
import static com.myownb3.dominic.invoice.attrs.constants.InvoiceXMLConstants.TREATMENT_DATA_REASON;
import static com.myownb3.dominic.invoice.attrs.constants.InvoiceXMLConstants.TREATMENT_SUFFIX;
import static com.myownb3.dominic.invoice.attrs.metadata.constants.InvoiceAttrValues.BILLING_ROLE_BOTH;
import static com.myownb3.dominic.invoice.attrs.metadata.constants.InvoiceAttrValues.BODY_LOCATION_NONE;
import static com.myownb3.dominic.invoice.attrs.metadata.constants.InvoiceAttrValues.MEDICAL_ROLE_SELF_EMPLOYED;
import static com.myownb3.dominic.invoice.attrs.metadata.constants.InvoiceAttrValues.SECTION_CODE_NONE;
import static com.myownb3.dominic.invoice.attrs.metadata.constants.InvoiceAttrValues.TREATMENT_AMBULATORY;
import static com.myownb3.dominic.invoice.attrs.metadata.type.ContentType.SERVICES_DATA;
import static com.myownb3.dominic.invoice.attrs.metadata.type.ContentType.TREATMENT_DATA;
import static java.util.Objects.nonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.myownb3.dominic.invoice.attrs.constants.InvoiceXMLConstants;
import com.myownb3.dominic.invoice.attrs.metadata.BooleanInvoiceAttr;
import com.myownb3.dominic.invoice.attrs.metadata.DateInvoiceAttr;
import com.myownb3.dominic.invoice.attrs.metadata.InvoiceAttr;
import com.myownb3.dominic.invoice.attrs.metadata.NominalInvoiceAttr;
import com.myownb3.dominic.invoice.attrs.metadata.impl.BooleanInvoiceAttrImpl;
import com.myownb3.dominic.invoice.attrs.metadata.impl.DateInvoiceAttrImpl;
import com.myownb3.dominic.invoice.attrs.metadata.impl.DoubleInvoiceAttrImpl;
import com.myownb3.dominic.invoice.attrs.metadata.impl.IntegerInvoiceAttrImpl;
import com.myownb3.dominic.invoice.attrs.metadata.impl.InvoiceAttrImpl;
import com.myownb3.dominic.invoice.attrs.metadata.impl.NominalInvoiceAttrImpl;
import com.myownb3.dominic.invoice.attrs.metadata.type.ContentType;
import com.myownb3.dominic.invoice.attrs.model.impl.MutableInvoiceAttrFactory;
import com.myownb3.dominic.invoice.exception.NoInvoiceAttrFoundForName;
import com.myownb3.dominic.invoice.util.StringUtil;
import com.myownb3.dominic.tarifziffer.logging.LoggerHelper;
import com.myownb3.dominic.tarifziffer.random.RandomNumber;

/**
 * Defines all the different attributes of an invoice record
 * 
 * @author Dominic
 *
 */
public class InvoiceAttrs {

   public static final InvoiceAttrs INSTANCE = new InvoiceAttrs();
   private static final Logger LOG = Logger.getLogger(InvoiceAttrs.class);
   private static final String YYYY_MM_DD_T_HH_MM_SS_SSS = "YYYY-MM-dd'T'HH:mm:ss.SSS";

   public static final InvoiceAttr AMOUNT = new DoubleInvoiceAttrImpl("amount", 10);
   public static final InvoiceAttr AMOUNT_MT = new DoubleInvoiceAttrImpl("amount_mt", 20, "0.0");
   public static final InvoiceAttr AMOUNT_TT = new DoubleInvoiceAttrImpl("amount_tt", 30, "0.0");
   public static final NominalInvoiceAttr BILLING_ROLE = new NominalInvoiceAttrImpl("billing_role", 40, BILLING_ROLE_BOTH);
   public static final NominalInvoiceAttr BODY_LOCATION = new NominalInvoiceAttrImpl("body_location", 50, BODY_LOCATION_NONE);
   public static final NominalInvoiceAttr CODE = new NominalInvoiceAttrImpl("code", 60, "-");
   public static final DateInvoiceAttr DATE_BEGIN = new DateInvoiceAttrImpl("date_begin", YYYY_MM_DD_T_HH_MM_SS_SSS, 17060, false, SERVICES_DATA);
   public static final DateInvoiceAttr DATE_END = new DateInvoiceAttrImpl("date_end", YYYY_MM_DD_T_HH_MM_SS_SSS, 17070, false, SERVICES_DATA);
   public static final InvoiceAttr TREATMENT_DURATION = new DoubleInvoiceAttrImpl(TREATMENT_DATA_DURATION, 17080, true);
   public static final InvoiceAttr EXTERNAL_FACTOR = new DoubleInvoiceAttrImpl("external_factor", 17090, "1.0");
   public static final InvoiceAttr EXTERNAL_FACTOR_MT = new DoubleInvoiceAttrImpl("external_factor_mt", 17100, "1.0");
   public static final InvoiceAttr EXTERNAL_FACTOR_TT = new DoubleInvoiceAttrImpl("external_factor_tt", 17110, "1.0");
   public static final NominalInvoiceAttr MEDICAL_ROLE = new NominalInvoiceAttrImpl("medical_role", 17120, MEDICAL_ROLE_SELF_EMPLOYED);
   public static final InvoiceAttr NAME = new InvoiceAttrImpl("name", 17130, false);
   public static final BooleanInvoiceAttr OBLIGATION = new BooleanInvoiceAttrImpl("obligation", 17140, "true");
   public static final InvoiceAttr PROVIDER_ID = new InvoiceAttrImpl("provider_id", 17150, false);
   public static final InvoiceAttr QUANTITY = new DoubleInvoiceAttrImpl("quantity", 17160);
   public static final InvoiceAttr RECORD_ID = new DoubleInvoiceAttrImpl("record_id", 17170, false);
   public static final InvoiceAttr REF_CODE = new InvoiceAttrImpl("ref_code", 17180, false);
   public static final InvoiceAttr RESPONSIBLE_ID = new InvoiceAttrImpl("responsible_id", 17190, false);
   public static final InvoiceAttr SCALE_FACTOR_MT = new DoubleInvoiceAttrImpl("scale_factor_mt", 17200, "1.0");
   public static final InvoiceAttr SCALE_FACTOR_TT = new DoubleInvoiceAttrImpl("scale_factor_tt", 17210, "1.0");
   public static final NominalInvoiceAttr SECTION_CODE = new NominalInvoiceAttrImpl("section_code", 17220, SECTION_CODE_NONE);
   public static final InvoiceAttr SESSION = new IntegerInvoiceAttrImpl("session", false, 17240, "1");
   public static final NominalInvoiceAttr TARIFF_TYPE = new NominalInvoiceAttrImpl("tariff_type", 17250, "-1");
   public static final NominalInvoiceAttr TREATMENT = new NominalInvoiceAttrImpl("treatment", 17260, TREATMENT_AMBULATORY);
   public static final InvoiceAttr UNIT_FACTOR = new DoubleInvoiceAttrImpl("unit_factor", 17270, "1.0");
   public static final InvoiceAttr UNIT_FACTOR_MT = new DoubleInvoiceAttrImpl("unit_factor_mt", 17280);
   public static final InvoiceAttr UNIT_FACTOR_TT = new DoubleInvoiceAttrImpl("unit_factor_tt", 17290);
   public static final InvoiceAttr UNIT = new DoubleInvoiceAttrImpl("unit", 17300);
   public static final InvoiceAttr UNIT_MT = new DoubleInvoiceAttrImpl("unit_mt", 17310);
   public static final InvoiceAttr UNIT_TT = new DoubleInvoiceAttrImpl("unit_tt", 17320);
   public static final BooleanInvoiceAttr VALIDATE = new BooleanInvoiceAttrImpl("validate", 17330, "false");
   public static final InvoiceAttr VAT_RATE = new DoubleInvoiceAttrImpl("vat_rate", 17340, "0.0");
   public static final InvoiceAttr COST_FRACTION = new DoubleInvoiceAttrImpl("cost_fraction", 17350, "1.0");
   public static final InvoiceAttr REMARK = new InvoiceAttrImpl("remark", 17360, false);
   public static final InvoiceAttr SERVICE_ATTRIBUTES = new IntegerInvoiceAttrImpl("service_attributes", false, 17370, "0");

   // Patient data
   public static final InvoiceAttr BIRTHDATE =
         new DateInvoiceAttrImpl(PATIENT_DATA_BIRTHDATE, YYYY_MM_DD_T_HH_MM_SS_SSS, 17380, false, ContentType.PATIENT_DATA);
   public static final InvoiceAttr AGE = new IntegerInvoiceAttrImpl(PATIENT_DATA_AGE, 17390, true, ContentType.PATIENT_DATA);
   public static final NominalInvoiceAttr GENDER = new NominalInvoiceAttrImpl("gender", 17400, true, ContentType.PATIENT_DATA);

   // Treatment data
   public static final NominalInvoiceAttr TREATMENT_REASON =
         new NominalInvoiceAttrImpl(TREATMENT_SUFFIX + TREATMENT_DATA_REASON, 17410, true, TREATMENT_DATA);
   public static final InvoiceAttr TREATMENT_BEGIN =
         new DateInvoiceAttrImpl(TREATMENT_SUFFIX + TREATMENT_DATA_BEGIN, YYYY_MM_DD_T_HH_MM_SS_SSS, 17420, false, TREATMENT_DATA);
   public static final InvoiceAttr TREATMENT_TYPE =
         new InvoiceAttrImpl(InvoiceXMLConstants.TREATMENT_TYPE, 17430, false, TREATMENT_DATA);

   // invoices data
   public static final InvoiceAttr INVOICE_AMOUNT_DUE =
         new DoubleInvoiceAttrImpl(INVOICE_SUFFIX + InvoiceXMLConstants.AMOUNT_DUE, 17440, true, ContentType.INVOICE_AMOUNT_DATA);
   public static final InvoiceAttr INVOICE_AMOUNT =
         new DoubleInvoiceAttrImpl(INVOICE_SUFFIX + InvoiceXMLConstants.AMOUNT, 17450, true, ContentType.INVOICE_AMOUNT_DATA);

   private List<InvoiceAttr> allInvoiceAttributes;
   private Map<String, InvoiceAttr> allInvoiceAttributeNames2InvoiceAttrMapping;
   private Map<ContentType, List<InvoiceAttr>> contentType2InvoiceAttrMapping;
   private Map<String, List<InvoiceAttr>> metaInvoiceAttrName2CategoricalInvoiceAttrsMapping;
   private boolean isInitialized;

   private InvoiceAttrs() {
      this.isInitialized = false;
   }

   /**
    * Initializes the {@link InvoiceAttrs} content if it's not allready happened
    */
   public void init() {
      if (isInitialized) {
         return;
      }
      int requestId = RandomNumber.getNext();
      LoggerHelper.INSTANCE.startLogInfo(LOG, "Start initializing..", requestId);
      allInvoiceAttributes =
            Arrays.asList(/*INVOICE_AMOUNT, INVOICE_AMOUNT_DUE,*/ AMOUNT, AMOUNT_MT, AMOUNT_TT, BILLING_ROLE, BODY_LOCATION, CODE, DATE_BEGIN,
                  DATE_END,
                  TREATMENT_DURATION, EXTERNAL_FACTOR, EXTERNAL_FACTOR_MT, EXTERNAL_FACTOR_TT, MEDICAL_ROLE, NAME,
                  OBLIGATION, PROVIDER_ID, QUANTITY, RECORD_ID, REF_CODE, RESPONSIBLE_ID, SCALE_FACTOR_MT,
                  SCALE_FACTOR_TT, SECTION_CODE, SESSION, TARIFF_TYPE, TREATMENT, UNIT_FACTOR, UNIT_FACTOR_MT,
                  UNIT_FACTOR_TT, UNIT, UNIT_MT, UNIT_TT, VALIDATE, VAT_RATE, COST_FRACTION, REMARK, SERVICE_ATTRIBUTES,
                  BIRTHDATE, AGE, GENDER, TREATMENT_REASON, TREATMENT_BEGIN, TREATMENT_TYPE);
      allInvoiceAttributeNames2InvoiceAttrMapping = allInvoiceAttributes.stream()
            .collect(Collectors.toMap(InvoiceAttr::getName, Function.identity()));
      contentType2InvoiceAttrMapping = buildContentType2InvoiceAttrsMap();
      metaInvoiceAttrName2CategoricalInvoiceAttrsMapping = buildMetaAttrName2NominalInvoiceAttrMapping();
      this.isInitialized = true;
      LoggerHelper.INSTANCE.endLogInfo(LOG, "End initializing %s\n", requestId);
   }

   private Map<ContentType, List<InvoiceAttr>> buildContentType2InvoiceAttrsMap() {
      EnumMap<ContentType, List<InvoiceAttr>> contentType2InvoiceAttrsMap = new EnumMap<>(ContentType.class);
      for (ContentType contentType : ContentType.values()) {
         List<InvoiceAttr> relevantInvoiceAttrs4Type = getFilterAndSortAllRelevantInvoiceAttrs(contentType);
         contentType2InvoiceAttrsMap.put(contentType, Collections.unmodifiableList(relevantInvoiceAttrs4Type));
      }
      return Collections.unmodifiableMap(contentType2InvoiceAttrsMap);
   }

   private Map<String, List<InvoiceAttr>> buildMetaAttrName2NominalInvoiceAttrMapping() {
      Map<String, List<InvoiceAttr>> metaAttrName2NominalInvoiceAttrMapping = new HashMap<>();
      allInvoiceAttributes.stream()
            .filter(InvoiceAttr::isNominal)
            .map(NominalInvoiceAttr.class::cast)
            .forEach(nominalInvoiceAttr -> {
               List<InvoiceAttr> invoiceAttrs4CategoricalValues = buildInvoiceAttrs4CategoricalValues(nominalInvoiceAttr);
               metaAttrName2NominalInvoiceAttrMapping.put(nominalInvoiceAttr.getName(), invoiceAttrs4CategoricalValues);
            });
      return Collections.unmodifiableMap(metaAttrName2NominalInvoiceAttrMapping);
   }

   /**
    * Evaluates and returns a {@link InvoiceAttr} for the given name
    * 
    * @param attrName
    *        the name of the {@link InvoiceAttr}
    */
   public InvoiceAttr getInvoiceAttrByName(String attrName) {
      InvoiceAttr invoiceAttr = allInvoiceAttributeNames2InvoiceAttrMapping.get(attrName);
      if (nonNull(invoiceAttr)) {
         return invoiceAttr;
      }
      throw new NoInvoiceAttrFoundForName("No InvoiceAttr found for Name '" + attrName + "'");
   }

   /**
    * @param contentType
    *        the type of {@link InvoiceAttr} which are returned
    * @returns a {@link List} of {@link InvoiceAttr} which are relevant for vectorizing and exporting
    */
   public List<InvoiceAttr> getAllRelevantInvoiceAttrs(ContentType contentType) {
      return contentType2InvoiceAttrMapping.get(contentType);
   }

   private List<InvoiceAttr> getFilterAndSortAllRelevantInvoiceAttrs(ContentType contentType) {
      return allInvoiceAttributes.stream()
            .filter(filter4ContentType(contentType))
            .filter(InvoiceAttr::isRelevant4Vectorizing)
            .sorted(Comparator.comparing(InvoiceAttr::getSequence))
            .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
   }

   /**
    * Return the names of all {@link InvoiceAttr} for the given {@link ContentType}
    * 
    * @param contentType
    *        the type of {@link InvoiceAttr} which are relevant
    * @param onlyRelevant4Vectorizing
    *        <code>true</code> if only those which are relevant for vectorizing are selected. <code>false</code> if not
    * @returns the names of all {@link InvoiceAttr} for the given {@link ContentType}
    */
   public List<String> getAllInvoiceAttrsNames(ContentType contentType, boolean onlyRelevant4Vectorizing) {
      List<InvoiceAttr> allInvoiceAttrs;
      if (onlyRelevant4Vectorizing) {
         allInvoiceAttrs = getAllRelevantInvoiceAttrs(contentType);
      } else {
         allInvoiceAttrs = getAllInvoiceAttrs(contentType);
      }
      return allInvoiceAttrs.stream()
            .sorted(Comparator.comparing(InvoiceAttr::getSequence))
            .map(InvoiceAttr::getName)
            .collect(Collectors.toList());
   }

   private List<InvoiceAttr> getAllInvoiceAttrs(ContentType contentType) {
      return allInvoiceAttributes.stream()
            .filter(filter4ContentType(contentType))
            .collect(Collectors.toList());
   }

   private static Predicate<InvoiceAttr> filter4ContentType(ContentType contentType) {
      return invoiceAttr -> invoiceAttr.getContentType() == contentType;
   }

   /**
    * Builds a new {@link InvoiceAttr} for the given name and with the given value
    * An exception is thrown if there is no such {@link InvoiceAttr} with the given name
    * 
    * @param name
    *        the name of the {@link InvoiceAttr}
    * @param value
    *        the value of the {@link InvoiceAttr}
    * @return a {@link InvoiceAttr}
    */
   public InvoiceAttr buildInvoiceAttr(String name, String value) {
      InvoiceAttr invoiceAttr = getInvoiceAttrByName(name);
      return MutableInvoiceAttrFactory.INSTANCE.createNewMutableInvoiceAttr(invoiceAttr, value);
   }

   /**
    * Builds a new {@link InvoiceAttr} for the given name and with the given value.
    * This new {@link InvoiceAttr} is based on the nominal {@link InvoiceAttr} for the given meta-attr
    * 
    * @param invoiceAttr
    *        the meta-{@link InvoiceAttr} itself
    * @param name
    *        the name of the new {@link InvoiceAttr}
    * @return a {@link InvoiceAttr}
    */
   public InvoiceAttr buildInvoiceAttr4NominalAttr(NominalInvoiceAttr invoiceAttr, String name) {
      return MutableInvoiceAttrFactory.INSTANCE.createNewMutableNominalInvoiceAttr(invoiceAttr, name);
   }

   /**
    * Returns a list with all possible {@link InvoiceAttrs}.
    * This includes all the already defined, not nominal {@link InvoiceAttrs} within this class
    * and, for each nominal attribute, there will be a new {@link InvoiceAttrs} for each possible value for this category.
    * 
    * @param invoiceAttrs
    *        the {@link InvoiceAttrs} which are considered
    * @param sorted
    *        <code>true</code> if all the {@link InvoiceAttr}s are in a sorted list or <code>false</code> if not
    * @return a list with all possible {@link InvoiceAttrs}.
    */
   public List<InvoiceAttr> evalAllInvoiceAttrsIncludingCategoricalValues(List<InvoiceAttr> invoiceAttrs, boolean sorted) {
      Predicate<InvoiceAttr> isNominal = InvoiceAttr::isNominal;
      // The not nominal ones can be added directly
      List<InvoiceAttr> allInvoiceAttrWithCategoricalOnes = invoiceAttrs.parallelStream()
            .filter(isNominal.negate())
            .collect(Collectors.toList());

      // For the nominal ones, we have to map them into the different values per category
      invoiceAttrs.parallelStream()
            .filter(isNominal)
            .map(InvoiceAttr::getName)
            .map(metaInvoiceAttrName2CategoricalInvoiceAttrsMapping::get)
            .flatMap(List::stream)
            .collect(Collectors.collectingAndThen(Collectors.toList(), allInvoiceAttrWithCategoricalOnes::addAll));
      if (sorted) {
         Collections.sort(allInvoiceAttrWithCategoricalOnes, Comparator.comparing(InvoiceAttr::getSequence));
      }
      return allInvoiceAttrWithCategoricalOnes;
   }

   /*
    * Builds a list with {@link InvoiceAttr}s - for each possible value of the given {@link NominalInvoiceAttr}
    */
   /*Visible4Testing*/
   List<InvoiceAttr> buildInvoiceAttrs4CategoricalValues(NominalInvoiceAttr invoiceAttr) {
      return invoiceAttr.getCategoricalValues()
            .parallelStream()
            .map(buildInvoiceAttr4NominalAttr(invoiceAttr))
            .collect(Collectors.toList());
   }

   private Function<String, InvoiceAttr> buildInvoiceAttr4NominalAttr(NominalInvoiceAttr invoiceAttr) {
      return categoricalValue -> {
         String attrValue = invoiceAttr.buildCategoricalAttrName(StringUtil.trim(categoricalValue));
         return buildInvoiceAttr4NominalAttr(invoiceAttr, StringUtil.trim(attrValue));
      };
   }
}
