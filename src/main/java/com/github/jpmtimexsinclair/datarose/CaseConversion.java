/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.jpmtimexsinclair.datarose;
import java.util.*;
/**
 * Class that is primarily intended to convert SQL and data identifiers between
 * case types, e.g. camelCast to CONSTANT_CASE.
 *
 * @author Jim
 */

public class CaseConversion {
    
    private CaseConversion() {
        throw new UnsupportedOperationException("Cannot instantiate utility class");
    }

    public static boolean isTitleCase(String str)
    {
        boolean returnValue = false;
        if (str.contains(" ")){
            returnValue = true;
        }
        else {
            if (str.contains("\n")){
                returnValue = true;
            }
            else
            {
                if (str.contains("\r")){
                    returnValue = true;
                }
                else{
                    if (str.contains("\t")){
                        returnValue = true;
                    }
                }
            }
        }
        
        return returnValue;
    }
    
    public static boolean isAllUpperCase(String str) {
        // Check if the string is empty or null
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isAllLowerCase(String str) {
        // Check if the string is empty or null
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
    
    //stubbed for now
    public static CaseType returnCaseType(String str){
        // Check if the string is empty or null and pop out if it is
        if (str == null || str.isEmpty()) {
            return CaseType.UNKNOWN;
        }
        
        CaseType returnType = CaseType.UNKNOWN;
        if (isTitleCase(str) == true){
            returnType = CaseType.TITLE;
        }
        else {
            if (str.contains("_")) {
                returnType = CaseType.SNAKE;
            }
            else {
                if (!((str.contains("_")) || str.contains(" "))){
                    if (isAllUpperCase(str)){
                        returnType = CaseType.ALLUPPER;
                    }
                    else{
                        if (isAllLowerCase(str)){
                            returnType = CaseType.ALLLOWER;
                        }
                        else{
                            if (Character.isUpperCase(str.charAt(0))){
                                returnType = CaseType.PASCAL;
                            }
                            else {
                                returnType = CaseType.CAMEL;
                            }
                        }
                    }
                    
                }
            }
        }

        return returnType;
    }
    
    /**
     * Convert case converts the string using from a source case type to a
     * target case type.
     * @param str The string to convert
     * @param sourceCaseType The source case type from the CaseType enum.
     * @param targetCaseType The target case type from the CsaeType enum.
     * @return The convertedStr string
     * @see None
     * @since 1.0
     */
    public static String convertCase(String str, CaseType sourceCaseType, CaseType targetCaseType){
        String returnValue = "";
        String workValue = "";
        switch(sourceCaseType){
            case ALLUPPER -> workValue = convertAllUpperToTitle(str);
            case ALLLOWER -> workValue = convertAllLowerToTitle(str);
            case CONSTANT -> workValue = convertSnakeToTitle(str);
            case CAMEL -> workValue = convertCamelToTitle(str);
            case PASCAL -> workValue = convertCamelToTitle(str);
            case SNAKE -> workValue = convertSnakeToTitle(str);
            case TITLESNAKE -> workValue = convertSnakeToTitle(str);
            case CHAOTIC -> workValue = convertChaoticToTitle(str);
            case TITLE -> workValue = str;
            default -> throw new IllegalStateException("Invalid sourceCaseType: " + sourceCaseType);
        }
        switch(targetCaseType){
            case CONSTANT -> returnValue = convertTitleToConstant(workValue);
            case CAMEL -> returnValue = convertTitleToCamel(workValue, false);
            case PASCAL -> returnValue = convertTitleToCamel(workValue, true);
            case SNAKE -> returnValue = convertTitleToSnake(workValue);
            case TITLESNAKE -> returnValue = convertTitleToTitleSnake(workValue);
            case TITLE -> returnValue = workValue;
            default -> throw new IllegalStateException("Invalid targetCaseType: " + targetCaseType);
        }
        return returnValue;
    }
    
    public static String autoConvertCase(String str, CaseType targetCaseType){
        String returnValue;
        CaseType sourceCaseType = returnCaseType(str);
        returnValue = convertCase(str, sourceCaseType, targetCaseType);
        return returnValue;
    }
    
    public static String convertTitleToAllUpper(String str){
        //stubed out...why would anyone do this?
        return str;
    }
    
    public static String convertTitleToAllLower(String str){
        //stubbed out..
        return str;
    }
    
    //example method just returns what was passed in but interates through
    //the characrters...good starting point for the other functions
    public static String convertSameToSame(String str){
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder convertedStr = new StringBuilder();
        
        for (char ch : str.toCharArray()){
            convertedStr.append(ch);
        }
        
        return convertedStr.toString();
    }
    
    public static String convertTitleToConstant(String str){
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder convertedStr = new StringBuilder();
        
        for (char ch : str.toCharArray()){
            if (ch == ' '){
                ch = '_';
            }
            else
            {
                ch = Character.toUpperCase(ch);
            }
            convertedStr.append(ch);
        }
        return convertedStr.toString();
    }
    
    public static String convertTitleToCamel(String str, boolean usePascalNaming){
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder convertedStr = new StringBuilder();
        
        boolean nextUpper = true;
        boolean firstTime = true;
        
        for (char ch : str.toCharArray()){
            if (ch == ' '){
                nextUpper = true;
                continue;
            }
            else
            {
                if (nextUpper == true){
                    nextUpper = false;
                    if (firstTime == true){
                        ch = Character.toLowerCase(ch);
                        if (usePascalNaming == true){
                            ch = Character.toUpperCase(ch);
                        }
                        else{
                            ch = Character.toLowerCase(ch);
                        }
                        firstTime = false;
                    }
                    else{
                        ch = Character.toUpperCase(ch);
                    }
                    
                }
                else{
                    ch = Character.toLowerCase(ch);
                }
            }
            convertedStr.append(ch);
        }
        return convertedStr.toString();
    }
    
    public static String convertTitleToSnake(String str){
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder convertedStr = new StringBuilder();
        
        for (char ch : str.toCharArray()){
            if (ch == ' '){
                ch = '_';
            }
            else
            {
                ch = Character.toLowerCase(ch);
            }
            convertedStr.append(ch);
        }
        return convertedStr.toString();
    }
    
    public static String convertTitleToTitleSnake(String str){
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder convertedStr = new StringBuilder();
        
        boolean nextUpper = true;
        
        for (char ch : str.toCharArray()){
            if (ch == ' '){
                nextUpper = true;
                ch = '_';
            }
            else
            {
                if (nextUpper == true){
                    nextUpper = false;
                    ch = Character.toUpperCase(ch);
                }
                else{
                    ch = Character.toLowerCase(ch);
                }
            }
            convertedStr.append(ch);
        }
        return convertedStr.toString();
    }
    
    //this was easy in Python as someone wrote a package, wordninja, to do it.
    //but we may need to stub this out for now...
    public static String convertAllUpperToTitle(String str){
        return str;
    }
    
    //this was easy in Python as someone wrote a package, wordninja, to do it.
    //but we may need to stub this out for now...
    public static String convertAllLowerToTitle(String str){
        return str;
    }
    
    public static String convertConstantToTitle(String str){
        return str;
    }
    
    //example code I found...
    public static String convertToTitleCaseIteratingChars(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder convertedStr = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            convertedStr.append(ch);
        }

        return convertedStr.toString();
    }

    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    /**
     * Convert case converts the string using from a source case type of
     * camel to title.  Pascal camel is PascalCamel while regular camel
     * is regularCamel.  Both are handled by this function.
     * @param str The string to convert
     * @return The convertedStr string
     * @see None
     * @since 1.0
     */
    public static String convertCamelToTitle(String str){
        
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        String reverseStr = "";
        // Iterate over the string in reverse order
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseStr += str.charAt(i);
        }
        StringBuilder convertedRevStr = new StringBuilder();
      
        boolean firstOne = true;
        //previousCap and previousNumeric work the same..but I split them
        //out just in case later the processing needed adjustment.
        boolean prevUpper = false;
        //boolean prevLower = false;
        //boolean prevCharacter = false;
        boolean prevNumeric = false;
        boolean prevSpace = false;
        //boolean inAbbreviation = false;
        //register to hold the previous character
        for (char ch : reverseStr.toCharArray()){
            //find out what it is and set it if this is the first character
            if (firstOne){
                firstOne = false;
                if (Character.isUpperCase(ch)){
                    prevUpper = true;
                }
                else if (Character.isDigit(ch)){
                    prevNumeric = true;
                }
                convertedRevStr.append(ch);
            }
            else{
                if (Character.isDigit(ch)) {
                    if (!prevNumeric){
                        if (!prevSpace){
                            convertedRevStr.append(" ");
                        }
                        convertedRevStr.append(ch);
                    }
                    else{
                        convertedRevStr.append(ch);
                    }
                    prevNumeric = true;
                    prevUpper = false;
                    prevSpace = false;
                }
                else{
                    if (prevNumeric){
                        if (!prevSpace){
                            convertedRevStr.append(" ");
                        }
                        convertedRevStr.append(ch);
                        if (Character.isUpperCase(ch)){
                            prevUpper = true;
                        }
                        prevNumeric = false;
                        prevSpace = false;

                    }
                    else {
                        if (Character.isLowerCase(ch)){
                            if (prevUpper){
                                if (!prevSpace){
                                    convertedRevStr.append(" ");
                                }
                                convertedRevStr.append(ch);
                            }
                            else{
                                convertedRevStr.append(ch);
                            }
                            prevUpper = false;
                            prevSpace = false;
                        }
                        else if (Character.isUpperCase(ch)){
                            if (!prevUpper){
                                convertedRevStr.append(ch);
                                convertedRevStr.append(" ");
                                prevSpace = true;
                            }
                            else{
                                convertedRevStr.append(ch);
                                prevSpace = false;
                            }
                            prevUpper = true;
                        }
                        else {
                            convertedRevStr.append(ch);
                            prevUpper = false;
                        }
                        prevNumeric = false;
                    }
                }
            }
        }
                
        String convertedStr = capitalizeFirstLetter(convertedRevStr.reverse().toString());
       
        return convertedStr.trim();
    }
    
    
    public static String convertSnakeToTitle(String str){
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder convertedStr = new StringBuilder();
        
        boolean nextUpper = true;
        
        for (char ch : str.toCharArray()){
            if (ch == '_'){
                nextUpper = true;
                ch = ' ';
            }
            else
            {
                if (nextUpper == true){
                    nextUpper = false;
                    ch = Character.toUpperCase(ch);
                }
                else{
                    ch = Character.toLowerCase(ch);
                }
            }
            convertedStr.append(ch);
        }
        return convertedStr.toString();
    }
    
    public static String convertChaoticToTitle(String str){
        return str;
    }
}
