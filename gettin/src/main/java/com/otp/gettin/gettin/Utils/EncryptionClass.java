package com.otp.gettin.gettin.Utils;

import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
public class EncryptionClass {


    public String MixinChars(String value){
        StringBuilder ValueTreatment = new StringBuilder(value);

        ValueTreatment.reverse();


        String[] TabValue = {ValueTreatment.substring(0, (ValueTreatment.length()/2)), ValueTreatment.substring((ValueTreatment.length()/2),ValueTreatment.length())};
        Collections.reverse(Arrays.asList(TabValue));
        Arrays.stream(TabValue).toArray();
        String joinedReversedConvertedTab = String.join("",TabValue);
        return joinedReversedConvertedTab;
    }

    public String KeyGenerator(){
        Random rand = new Random();

        int limitIntegerLow = 2;
        int limitIntegerHigh =10;
        int generatedKey = rand.nextInt(limitIntegerHigh - limitIntegerLow) + limitIntegerLow;


        String keyToAppend = generatedKey + "/";

        return keyToAppend;
    }

    public String Encryption(String value, String key){
        int SplittedKey = Integer.parseInt(key.substring(0,1));
        char[] convertedValue = new char[value.length()];

        for(int i = 0; i<convertedValue.length; i++){
            convertedValue[i] = value.charAt(i);
            convertedValue[i]+=SplittedKey;

            if(convertedValue[i]=='/'){
                convertedValue[i]+= SplittedKey + 10;
            }

            if(i%2 == 0){
                convertedValue[i] += SplittedKey+convertedValue.length;
            }

        }

        String finalVal = key + String.valueOf(convertedValue);


        return finalVal;

    }

    public String Encrypt(String value){

       return Encryption(MixinChars(value), KeyGenerator());

    }

    public String[] SplitEncryptedStr(String value){
        String[] splitVal = value.split("/", 2);
        return splitVal;

    }

    public String Decryption(String[] value){
        int key = Integer.parseInt(value[0]);
        String valueToDecrypt = value[1];
        char[] convertedValue = new char[valueToDecrypt.length()];

        for(int i = 0; i<convertedValue.length; i++){
            convertedValue[i] = valueToDecrypt.charAt(i);
            convertedValue[i]-=key;

            if(convertedValue[i]=='/'){
                convertedValue[i]-= key + 10;
            }

            if(i%2 == 0){
                convertedValue[i] -= key+convertedValue.length;
            }

        }

        return String.valueOf(convertedValue);

    }

    public String Decrypt(String value){
        return MixinChars(Decryption(SplitEncryptedStr(value)));

    }


}
