package com.securemessaging.sm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.securemessaging.ex.SecureMessengerClientException;

public enum BodyFormat {
    TEXT("Text"), HTML("Html");

    private final String bodyFormat;

    BodyFormat(String bodyFormat){
        this.bodyFormat = bodyFormat;
    }

    /**
     * getEnumText gets the value of the enum which is required to be passed to the server
     * @return the value of the enum
     */
    @JsonValue
    public String getEnumText(){
        return this.bodyFormat;
    }

    @JsonCreator
    public static BodyFormat enumFromEnumText(String enumText) throws SecureMessengerClientException {
        for(BodyFormat validEnumValue: BodyFormat.values()){
            if(enumText.equals(validEnumValue.getEnumText())){
                return validEnumValue;
            }
        }

        throw new SecureMessengerClientException("enumText Does Not Match A Valid Enum");
    }

}
