/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.jpmtimexsinclair.datarose;
import java.math.BigInteger;

/**
 *
 * @author Jim
 */
public class DuckDBRose extends BaseRose implements Convertable  {
    
    @Override
    public ConversionEntity convertToBaseEntity(DataEntity dataEntity){
        ConversionEntity conversionEntity = this.initializeConversionEntity(dataEntity, CaseType.CONSTANT);
        for(DataAttribute attribute : conversionEntity.sourceDataEntity.dataAttributeCollection)
        {   
            DataAttributePair dataAttributePair = convertToBaseAttribute(attribute);
            conversionEntity.dataAttributePairCollection.add(dataAttributePair);
            conversionEntity.targetDataEntity.dataAttributeCollection.add(dataAttributePair.targetDataAttribute);
        }
        return conversionEntity;
    }
    
    @Override
    public ConversionEntity convertFromBaseEntity(DataEntity dataEntity, CaseType caseType){
        ConversionEntity conversionEntity = this.initializeConversionEntity(dataEntity, caseType);
        for(DataAttribute attribute : conversionEntity.sourceDataEntity.dataAttributeCollection)
        {   
            DataAttributePair dataAttributePair = convertToBaseAttribute(attribute);
            conversionEntity.dataAttributePairCollection.add(dataAttributePair);
            conversionEntity.targetDataEntity.dataAttributeCollection.add(dataAttributePair.targetDataAttribute);
        }
        return conversionEntity;
    }
    
    //todo check data type conversion.
    @Override
    public DataAttributePair convertToBaseAttribute(DataAttribute dataAttribute){
        DataAttributePair dataAttributePair = this.initializeConversionAttribute(dataAttribute, CaseType.CONSTANT);
        //note that the source data type is lower case and the target is upper just to keep the code straight.
        switch (dataAttributePair.sourceDataAttribute.dataType.toUpperCase()){
            case "BIGINT":
                dataAttributePair.targetDataAttribute.dataType = "BIGINT";
                break;
            case "BINARY":
                dataAttributePair.targetDataAttribute.dataType = "BINARY";
                break;
            case "BIT":
                dataAttributePair.targetDataAttribute.dataType = "BIT";
                break;
            case "BITSTRING":
                dataAttributePair.targetDataAttribute.dataType = "BITSTRING";
                break;
            case "BLOB":
                dataAttributePair.targetDataAttribute.dataType = "BLOB";
                break;
            case "BOOL":
                dataAttributePair.targetDataAttribute.dataType = "BOOL";
                break;
            case "BOOLEAN":
                dataAttributePair.targetDataAttribute.dataType = "BOOLEAN";
                break;
            case "BPCHAR":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                break;
            case "BYTEA":
                dataAttributePair.targetDataAttribute.dataType = "BYTEA";
                break;
            case "CHAR":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                break;
            case "DATE":
                dataAttributePair.targetDataAttribute.dataType = "DATE";
                break;
            case "DATETIME":
                dataAttributePair.targetDataAttribute.dataType = "DATETIME";
                break;
            case "DECIMAL":
                dataAttributePair.targetDataAttribute.dataType = "DECIMAL";
                dataAttributePair.targetDataAttribute.numericPrecision = dataAttributePair.sourceDataAttribute.numericPrecision;
                dataAttributePair.targetDataAttribute.numericScale = dataAttributePair.sourceDataAttribute.numericScale;
                break;
            case "DOUBLE":
                dataAttributePair.targetDataAttribute.dataType = "DOUBLE";
                break;
            case "FLOAT":
                dataAttributePair.targetDataAttribute.dataType = "FLOAT";
                break;
            case "FLOAT4":
                dataAttributePair.targetDataAttribute.dataType = "FLOAT4";
                break;
            case "FLOAT8":
                dataAttributePair.targetDataAttribute.dataType = "FLOAT8";
                break;
            case "HUGEINT":
                dataAttributePair.targetDataAttribute.dataType = "HUGEINT";
                break;
            case "INT":
                dataAttributePair.targetDataAttribute.dataType = "INT";
                break;
            case "INT1":
                dataAttributePair.targetDataAttribute.dataType = "INT1";
                break;
            case "INT2":
                dataAttributePair.targetDataAttribute.dataType = "INT2";
                break;
            case "INT4":
                dataAttributePair.targetDataAttribute.dataType = "INT4";
                break;
            case "INT8":
                dataAttributePair.targetDataAttribute.dataType = "INT8";
                break;
            case "INTEGER":
                dataAttributePair.targetDataAttribute.dataType = "INTEGER";
                break;
            case "INTERVAL":
                dataAttributePair.targetDataAttribute.dataType = "INTERVAL";
                break;
            case "JSON":
                dataAttributePair.targetDataAttribute.dataType = "JSON";
                break;
            case "LOGICAL":
                dataAttributePair.targetDataAttribute.dataType = "LOGICAL";
                break;
            case "LONG":
                dataAttributePair.targetDataAttribute.dataType = "LONG";
                break;
            case "NUMERIC":
                dataAttributePair.targetDataAttribute.dataType = "NUMERIC";
                dataAttributePair.targetDataAttribute.numericPrecision = dataAttributePair.sourceDataAttribute.numericPrecision;
                dataAttributePair.targetDataAttribute.numericScale = dataAttributePair.sourceDataAttribute.numericScale;
                break;
            case "REAL":
                dataAttributePair.targetDataAttribute.dataType = "REAL";
                break;
            case "SHORT":
                dataAttributePair.targetDataAttribute.dataType = "SHORT";
                break;
            case "SIGNED":
                dataAttributePair.targetDataAttribute.dataType = "SIGNED";
                break;
            case "SMALLINT":
                dataAttributePair.targetDataAttribute.dataType = "SMALLINT";
                break;
            case "STRING":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                break;
            case "TEXT":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                break;
            case "TIME":
                dataAttributePair.targetDataAttribute.dataType = "TIME";
                break;
            case "TIMESTAMP":
                dataAttributePair.targetDataAttribute.dataType = "TIMESTAMP";
                break;
            case "TIMESTAMP WITH TIME ZONE":
                dataAttributePair.targetDataAttribute.dataType = "TIMESTAMP WITH TIME ZONE";
                break;
            case "TIMESTAMPTZ":
                dataAttributePair.targetDataAttribute.dataType = "TIMESTAMPTZ";
                break;
            case "TINYINT":
                dataAttributePair.targetDataAttribute.dataType = "TINYINT";
                break;
            case "UBIGINT":
                dataAttributePair.targetDataAttribute.dataType = "UBIGINT";
                break;
            case "UHUGEINT":
                dataAttributePair.targetDataAttribute.dataType = "UHUGEINT";
                break;
            case "UINTEGER":
                dataAttributePair.targetDataAttribute.dataType = "UINTEGER";
                break;
            case "USMALLINT":
                dataAttributePair.targetDataAttribute.dataType = "USMALLINT";
                break;
            case "UTINYINT":
                dataAttributePair.targetDataAttribute.dataType = "UTINYINT";
                break;
            case "UUID":
                dataAttributePair.targetDataAttribute.dataType = "UUID";
                break;
            case "VARBINARY":
                dataAttributePair.targetDataAttribute.dataType = "VARBINARY";
                break;
            case "VARCHAR":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                break;
            default:
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
        }
        return dataAttributePair;
    }
    
    //todo check data type conversion
    @Override
    public DataAttributePair convertFromBaseAttribute(DataAttribute dataAttribute, CaseType caseType){
        DataAttributePair dataAttributePair = this.initializeConversionAttribute(dataAttribute, caseType);
        //note that the source data type is lower case and the target is upper just to keep the code straight.
        switch (dataAttributePair.sourceDataAttribute.dataType.toUpperCase()){
            case "BIGINT":
                dataAttributePair.targetDataAttribute.dataType = "BIGINT";
                dataAttributePair.targetDataAttribute.numericPrecision = 64;
                dataAttributePair.targetDataAttribute.numericScale = 0;
                break;
            case "BINARY LARGE OBJECT":
                dataAttributePair.targetDataAttribute.dataType = "BINARY LARGE OBJECT";
                break;
            case "BIT":
                dataAttributePair.targetDataAttribute.dataType = "BIT";
                break;
            case "BIT VARYING":
                dataAttributePair.targetDataAttribute.dataType = "BIT VARYING";
                break;
            case "BOOLEAN":
                dataAttributePair.targetDataAttribute.dataType = "BOOLEAN";
                break;
            case "CHARACTER":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER";
                break;
            case "CHARACTER LARGE OBJECT":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER LARGE OBJECT";
                break;
            case "CHARACTER VARYING":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                break;
            case "DATE":
                dataAttributePair.targetDataAttribute.dataType = "DATE";
                break;
            case "DECIMAL":
                dataAttributePair.targetDataAttribute.dataType = "DECIMAL";
                dataAttributePair.targetDataAttribute.numericPrecision = dataAttributePair.sourceDataAttribute.numericPrecision;
                dataAttributePair.targetDataAttribute.numericScale = dataAttributePair.sourceDataAttribute.numericScale;
                break;
            case "DOUBLE PRECISION":
                dataAttributePair.targetDataAttribute.dataType = "DOUBLE PRECISION";
                dataAttributePair.targetDataAttribute.numericPrecision = 53;
                dataAttributePair.targetDataAttribute.numericScale = 0;
                break;
            case "FLOAT":
                dataAttributePair.targetDataAttribute.dataType = "FLOAT";
                dataAttributePair.targetDataAttribute.numericPrecision = 24;
                dataAttributePair.targetDataAttribute.numericScale = 0;
                break;
            case "INTEGER":
                dataAttributePair.targetDataAttribute.dataType = "INTEGER";
                dataAttributePair.targetDataAttribute.numericPrecision = 32;
                dataAttributePair.targetDataAttribute.numericScale = 0;
                break;
            case "INTERVAL":
                dataAttributePair.targetDataAttribute.dataType = "INTERVAL";
                break;
            case "JSON":
                dataAttributePair.targetDataAttribute.dataType = "JSON";
                break;
            case "NATIONAL CHARACTER":
                dataAttributePair.targetDataAttribute.dataType = "NATIONAL CHARACTER";
                break;
            case "NATIONAL CHARACTER LARGE OBJECT":
                dataAttributePair.targetDataAttribute.dataType = "NATIONAL CHARACTER LARGE OBJECT";
                break;
            case "NATIONAL CHARACTER VARYING":
                dataAttributePair.targetDataAttribute.dataType = "NATIONAL CHARACTER VARYING";
                break;
            case "NUMERIC":
                dataAttributePair.targetDataAttribute.dataType = "NUMERIC";
                dataAttributePair.targetDataAttribute.numericPrecision = dataAttributePair.sourceDataAttribute.numericPrecision;
                dataAttributePair.targetDataAttribute.numericScale = dataAttributePair.sourceDataAttribute.numericScale;
                break;
            case "REAL":
                dataAttributePair.targetDataAttribute.dataType = "REAL";
                dataAttributePair.targetDataAttribute.numericPrecision = 64;
                dataAttributePair.targetDataAttribute.numericScale = 0;
                break;
            case "SMALLINT":
                dataAttributePair.targetDataAttribute.dataType = "SMALLINT";
                dataAttributePair.targetDataAttribute.numericPrecision = 16;
                dataAttributePair.targetDataAttribute.numericScale = 0;
                break;
            case "TIME":
                dataAttributePair.targetDataAttribute.dataType = "TIME";
                break;
            case "TIME WITH TIME ZONE":
                dataAttributePair.targetDataAttribute.dataType = "TIME WITH TIME ZONE";
                break;
            case "TIMESTAMP":
                dataAttributePair.targetDataAttribute.dataType = "TIMESTAMP";
                break;
            case "TIMESTAMP WITH TIME ZONE":
                dataAttributePair.targetDataAttribute.dataType = "TIMESTAMP WITH TIME ZONE";
                break;
            case "XML":
                dataAttributePair.targetDataAttribute.dataType = "XML";
                break;
            default:
                dataAttributePair.targetDataAttribute.dataType = "VARCHAR";
        }
         return dataAttributePair;
    }
    
    @Override
    public boolean isTargetChanged(){
        return false;
    }
    
}
