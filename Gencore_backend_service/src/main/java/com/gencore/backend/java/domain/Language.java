package com.gencore.backend.java.domain;

public enum Language {
    
    en_US(1,"US"),
    fr_FR(2,"FR");
    
    private final Integer value;
    private final String label;
    
    private Language(Integer value, String label) {
        this.value = value;
        this.label = label;
    }
    
    public Integer value() { return value; }
    public String label() { return label; }
    
    // the identifierMethod
    public int toInt() {
      return value;
    }

     // the valueOfMethod
     public static Language fromInt(int value) {    
         switch(value) {
             case 1: return fr_FR;
             case 2: return en_US;
             default: return null;
         }
    }

}
