/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jimtimexsinclair.datarose;
import java.math.BigInteger;
//import java.util.HashSet;
//import java.util.Set;

/**
 * Class that describes data attributes, columns in an RDBMS, columns in a 
 * file, JSON attributes, etc. whatever.
 * @author Jim
 */
public class DataAttribute extends DataObject{
    //private String name;
    //public String name;
    public int ordinalPosition;
    public boolean isNullable;
    public String dataType;
    //decided in the end that BigInteger was not needed.  DuckDB has a max
    //varchar length of 4gb, but 
    //scratch the above...looks like I decided it 
    //was needed.
    public BigInteger characterMaximumLength;
    //custom character properties
    public boolean isBlankTrimmed;
    //not needed
    //public boolean hasNoDefinedMaxLength;
    //numerics
    public Integer numericPrecision;
    public Integer numericScale;
    //datetime
    public Integer datetimePrecision;
    //custom key properties
    public boolean isPrimaryKey;
    public Integer constraintOrdinalPosition;
    //first bit indicate space padding in this if needed
    //initialize to 0 for now.... may be more later
    //TODO THIS IS DUMB....WHY NOT JUST ADD A PRIVATE VARIABLE...
    //YOU CAN ADD MORE LATER....DUMB DUMB
    private int bitInfo = 0;
    //first bit indicate space padding in this if needed using the following 
    //0000 is no space padding (the default), 0001 is space padding
    
    public String binaryBitIfno[]={
      "0000","0001","0010","0011","0100","0101",
      "0110","0111","1000","1001","1010",
      "1011","1100","1101","1110","1111"
    };
    
    //need and empty constructor....to be filled in later...
    //i think
    DataAttribute(String name, DataObject parentDataObject){
        super(name, DataObjectType.ATTRIBUTE, parentDataObject);
    }
    
    /**
     * Create a new data attribute that looks like information_schema.columns with everything.
     * @param name 
     * @param comment
     * @param parentDataObject
     * @param ordinalPosition
     * @param isNullable
     * @param dataType
     * @param characterMaximumLength
     * @param numericPrecision
     * @param numericScale
     * @param datetimePrecision
     * @param isPrimaryKey
     * @param constraintOrdinalPosition
     * @see None
     * @since 1.0
     */
    public DataAttribute(String name, String comment, DataObject parentDataObject, int ordinalPosition, boolean isNullable, String dataType, BigInteger characterMaximumLength, Integer numericPrecision,
            Integer numericScale, Integer datetimePrecision, boolean isPrimaryKey, Integer constraintOrdinalPosition)
    {
        //parent properties
        super(name, comment, DataObjectType.ATTRIBUTE, parentDataObject);
        //this properties
        this.ordinalPosition = ordinalPosition;
        this.isNullable = isNullable;
        this.dataType = dataType;
        this.characterMaximumLength = characterMaximumLength;
        this.numericPrecision = numericPrecision;
        this.numericScale = numericScale;
        this.datetimePrecision = datetimePrecision;
        this.isPrimaryKey = isPrimaryKey;
        this.constraintOrdinalPosition = constraintOrdinalPosition;
        this.comment = comment;
    }
    
    /**
     * Create a new data attribute that looks like information_schema.columns for text oriented data types.
     * @param name 
     * @param parentDataObject
     * @param ordinalPosition
     * @param isNullable
     * @param dataType
     * @param characterMaximumLength
     * @param isPrimaryKey
     * @param constraintOrdinalPosition
     * @see None
     * @since 1.0
     */
    public DataAttribute(String name, DataObject parentDataObject, int ordinalPosition, boolean isNullable, String dataType, BigInteger 
            characterMaximumLength, boolean isPrimaryKey, Integer constraintOrdinalPosition)
    {
        //parent properties
        super(name, DataObjectType.ATTRIBUTE, parentDataObject);
        //this properties
        this.ordinalPosition = ordinalPosition;
        this.isNullable = isNullable;
        this.dataType = dataType;
        this.characterMaximumLength = characterMaximumLength;
        this.isPrimaryKey = isPrimaryKey;
        this.constraintOrdinalPosition = constraintOrdinalPosition;  //set to -1 if n/a. Constraint ordinal positon will never be negative
    }
    
    /**
     * Create a new data attribute that looks like information_schema.columns that is numeric oriented.
     * @param name 
     * @param parentDataObject
     * @param ordinalPosition
     * @param isNullable
     * @param dataType
     * @param numericPrecision
     * @param numericScale
     * @param isPrimaryKey
     * @param constraintOrdinalPosition
     * @see None
     * @since 1.0
     */
    public DataAttribute(String name, DataObject parentDataObject, int ordinalPosition, boolean isNullable, String dataType, Integer numericPrecision,
            Integer numericScale, boolean isPrimaryKey, Integer constraintOrdinalPosition)
    {
        //parent properties
        super(name, DataObjectType.ATTRIBUTE, parentDataObject);
        //this properties
        this.ordinalPosition = ordinalPosition;
        this.isNullable = isNullable;
        this.dataType = dataType;
        this.numericPrecision = numericPrecision;
        this.numericScale = numericScale;
        this.isPrimaryKey = isPrimaryKey;
        this.constraintOrdinalPosition = constraintOrdinalPosition;
    }
    
    /**
     * Create a new data attribute that looks like information_schema.columns for date data types.
     * @param name 
     * @param parentDataObject
     * @param ordinalPosition
     * @param isNullable
     * @param dataType
     * @param datetimePrecision
     * @param isPrimaryKey
     * @param constraintOrdinalPosition
     * @see None
     * @since 1.0
     */
    public DataAttribute(String name, DataObject parentDataObject, int ordinalPosition, boolean isNullable, String dataType, Integer datetimePrecision, boolean isPrimaryKey, Integer constraintOrdinalPosition)
    {
        //parent properties
        super(name, DataObjectType.ATTRIBUTE, parentDataObject);
        //this properties
        this.ordinalPosition = ordinalPosition;
        this.isNullable = isNullable;
        this.dataType = dataType;
        this.datetimePrecision = datetimePrecision;
        this.isPrimaryKey = isPrimaryKey;
        this.constraintOrdinalPosition = constraintOrdinalPosition;
    }
    
    /**
     * Create a new data attribute that looks like information_schema.columns but only requires the basics like datatype etc. 
     * @param name 
     * @param parentDataObject
     * @param ordinalPosition
     * @param isNullable
     * @param dataType
     * @param isPrimaryKey
     * @param constraintOrdinalPosition
     * @see None
     * @since 1.0
     */
    public DataAttribute(String name, DataObject parentDataObject, int ordinalPosition, boolean isNullable, String dataType, boolean isPrimaryKey, Integer constraintOrdinalPosition)
    {
        //parent properties
        super(name, DataObjectType.ATTRIBUTE, parentDataObject);
        //this properties
        this.ordinalPosition = ordinalPosition;
        this.isNullable = isNullable;
        this.dataType = dataType;
        this.isPrimaryKey = isPrimaryKey;
        this.constraintOrdinalPosition = constraintOrdinalPosition;
    }
    
    /**
     * Create a new data attribute that is more basic and free form and with comment.
     * @param name 
     * @param comment
     * @param parentDataObject
     * @param ordinalPosition
     * @param dataType
     * @param isPrimaryKey
     * @see None
     * @since 1.0
     */
    public DataAttribute(String name, String comment, DataObject parentDataObject, int ordinalPosition, String dataType, boolean isPrimaryKey)
    {
        super(name, comment, DataObjectType.ATTRIBUTE, parentDataObject);
        this.ordinalPosition = ordinalPosition;
        this.dataType = dataType;
        this.isPrimaryKey = isPrimaryKey;
    }
    
    /**
     * Create a new data attribute that looks like information_schema.columns but without the datatype specified.
     * @param name 
     * @param comment
     * @param parentDataObject
     * @param ordinalPosition
     * @param isNullable
     * @param isPrimaryKey
     * @param constraintOrdinalPosition
     * @see None
     * @since 1.0
     */
    public DataAttribute(String name, String comment, DataObject parentDataObject, int ordinalPosition, boolean isNullable, boolean isPrimaryKey, Integer constraintOrdinalPosition)
    {
        //parent properties
        super(name, comment, DataObjectType.ATTRIBUTE, parentDataObject);
        //this properties
        this.ordinalPosition = ordinalPosition;
        this.isNullable = isNullable;
        this.isPrimaryKey = isPrimaryKey;
        this.constraintOrdinalPosition = constraintOrdinalPosition;
        this.comment = comment;
    }

    // Set a specific bit
    public void setBit(int position) {
        this.bitInfo |= (1 << position);
    }

    // Clear a specific bit
    public void clearBit(int position) {
        this.bitInfo &= ~(1 << position);
    }

    // Check if a specific bit is set
    public boolean isBitSet(int position) {
        return (this.bitInfo & (1 << position)) != 0;
    }

    // Get the current data
    public int getData() {
        return this.bitInfo;
    }
    
    public void setBlankTrimmed() {
        this.setBit(0);
    }
    
    public boolean isBlankTrimmed() {
        return isBitSet(0);
    }
    
      /**
     * Update the current data attribute for text oriented data types.
     * @param ordinalPosition
     * @param isNullable
     * @param dataType
     * @param characterMaximumLength
     * @param isPrimaryKey
     * @param constraintOrdinalPosition
     * @see None
     * @since 1.0
     */
    public void setTextDataAttribute(int ordinalPosition, boolean isNullable, String dataType, BigInteger 
            characterMaximumLength, boolean isPrimaryKey, Integer constraintOrdinalPosition)
    {
        this.ordinalPosition = ordinalPosition;
        this.isNullable = isNullable;
        this.dataType = dataType;
        this.characterMaximumLength = characterMaximumLength;
        this.isPrimaryKey = isPrimaryKey;
        this.constraintOrdinalPosition = constraintOrdinalPosition;  //set to -1 if n/a. Constraint ordinal positon will never be negative...
    }
    
    /**
     * Update the current data attribute for numeric oriented data types
     * @param ordinalPosition
     * @param isNullable
     * @param dataType
     * @param numericPrecision
     * @param numericScale
     * @param isPrimaryKey
     * @param constraintOrdinalPosition
     * @see None
     * @since 1.0
     */
    public void setNumericDataAttribute(int ordinalPosition, boolean isNullable, String dataType, Integer numericPrecision,
            Integer numericScale, boolean isPrimaryKey, Integer constraintOrdinalPosition)
    {
        this.ordinalPosition = ordinalPosition;
        this.isNullable = isNullable;
        this.dataType = dataType;
        this.numericPrecision = numericPrecision;
        this.numericScale = numericScale;
        this.isPrimaryKey = isPrimaryKey;
        this.constraintOrdinalPosition = constraintOrdinalPosition;
    }
    
    /**
     * Update the current data attribute for date oriented data types
     * @param ordinalPosition
     * @param isNullable
     * @param dataType
     * @param datetimePrecision
     * @param isPrimaryKey
     * @param constraintOrdinalPosition
     * @see None
     * @since 1.0
     */
    public void setDateDataAttribute(int ordinalPosition, boolean isNullable, String dataType, Integer datetimePrecision, boolean isPrimaryKey, Integer constraintOrdinalPosition)
    {
        this.ordinalPosition = ordinalPosition;
        this.isNullable = isNullable;
        this.dataType = dataType;
        this.datetimePrecision = datetimePrecision;
        this.isPrimaryKey = isPrimaryKey;
        this.constraintOrdinalPosition = constraintOrdinalPosition;
    }
}
