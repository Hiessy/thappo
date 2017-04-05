package org.thappo.service.exception;

//Mejora: tomarlo desde archivo .csv
public enum BusinessCodes {

 VALIDATION_EXCEPTION(400, 01, "Invalid input recieved"), INVALID_CRITERIA_EXCEPTION(400, 02,
                 "Invalid sorting input data"), INVALID_ID_EXCEPTION(400, 03, "Invalid input ID"), UNKNOWN(400, 00,
                 "Non description available");

 private Integer statusCode;
 private Integer internalCode;
 private String description;

 private BusinessCodes(Integer statusCode, Integer internalCode, String description) {
     this.statusCode = statusCode;
     this.internalCode = internalCode;
     this.description = description;
 }

 public Integer getStatusCode() {
     return this.statusCode;
 }

 public Integer getInternalCode() {
     return this.internalCode;
 }

 public String getDescription() {
     return this.description;
 }

 public static BusinessCodes getBusinessException(java.lang.Exception value) {
     for (BusinessCodes exceptionData : BusinessCodes.values()) {
         String exceptionName = exceptionData.toString().replace("_", "");
         String valueName = value.getClass().getSimpleName().toUpperCase();
         if (exceptionName.equals(valueName)) {
             return exceptionData;
         }
     }
     return BusinessCodes.UNKNOWN;
 }

}