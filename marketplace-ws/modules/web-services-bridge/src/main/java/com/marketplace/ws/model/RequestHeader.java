package com.marketplace.ws.model;

import java.util.HashMap;
import java.util.Map;

public class RequestHeader {
   private Map<String, String> headerProperties = new HashMap();
   private RequestMethod requestMethod;

   public RequestHeader(RequestMethod requestMethod, String applicationType) {
      this.setRequestMethod(requestMethod);
      this.setRequestApplicationType(applicationType);
   }

   public void addHeaderProperty(String name, String value) {
      this.headerProperties.put(name, value);
   }

   public final Map<String, String> getHeaderProperties() {
      return this.headerProperties;
   }

   public void setRequestMethod(RequestMethod requestMethod) {
      this.requestMethod = requestMethod;
   }

   public void setRequestApplicationType(String applicationType) {
      this.addHeaderProperty("Content-Type", applicationType);
   }
}
