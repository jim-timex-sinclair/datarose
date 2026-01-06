/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jimtimexsinclair.datarose;
import java.math.BigInteger;

/**
 *
 * @author Jim
 */
public class PostgreSQLRose extends BaseRose implements Convertable {
    
    @Override
    public ConversionEntity convertToBaseEntity(DataEntity dataEntity){
        ConversionEntity conversionEntity = initializeConversionEntity(dataEntity, CaseType.CONSTANT);
        DataEntity baseEntity = conversionEntity.targetDataEntity;
        for(DataAttribute attribute : conversionEntity.sourceDataEntity.dataAttributeCollection)
        {   
            DataAttributePair dataAttributePair = convertToBaseAttribute(attribute, baseEntity);
            conversionEntity.dataAttributePairCollection.add(dataAttributePair);
            conversionEntity.targetDataEntity.dataAttributeCollection.add(dataAttributePair.targetDataAttribute);
        }
        return conversionEntity;
    }
    
    @Override
    public ConversionEntity convertFromBaseEntity(DataEntity dataEntity, CaseType caseType, DataObject parentDataObject){
        ConversionEntity conversionEntity = initializeConversionEntity(dataEntity, caseType, parentDataObject);
        DataEntity targetEntity = conversionEntity.targetDataEntity;
        for(DataAttribute attribute : conversionEntity.sourceDataEntity.dataAttributeCollection)
        {   
            DataAttributePair dataAttributePair = convertToBaseAttribute(attribute, targetEntity);
            conversionEntity.dataAttributePairCollection.add(dataAttributePair);
            conversionEntity.targetDataEntity.dataAttributeCollection.add(dataAttributePair.targetDataAttribute);
        }
        return conversionEntity;
    }
    
    @Override
    public DataAttributePair convertToBaseAttribute(DataAttribute dataAttribute, DataEntity baseDataEntity){
        DataAttributePair dataAttributePair = this.initializeDataAttributePair(dataAttribute, CaseType.CONSTANT, baseDataEntity);
        //note that the source data type is lower case and the target is upper just to keep the code straight.
        switch (dataAttributePair.sourceDataAttribute.dataType.toLowerCase()){
            case "bigint":
                dataAttributePair.targetDataAttribute.dataType = "BIGINT";
                break;
            case "bigserial":
                dataAttributePair.targetDataAttribute.dataType = "BIGINT";
                break;
            case "bit":
                dataAttributePair.targetDataAttribute.dataType = "BIT";
                if (dataAttribute.characterMaximumLength != null && 
                        dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("0")) == 1)
                {
                    dataAttributePair.targetDataAttribute.characterMaximumLength = dataAttributePair.sourceDataAttribute.characterMaximumLength;
                }
                else if (dataAttribute.characterMaximumLength == null){
                    dataAttributePair.targetDataAttribute.characterMaximumLength = null;
                }
                else{
                    dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("83886080");
                }
                break;
            case "bit varying":
                dataAttributePair.targetDataAttribute.dataType = "BIT VARYING";
                if (dataAttribute.characterMaximumLength != null && 
                        dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("0")) == 1)
                {
                    dataAttributePair.targetDataAttribute.characterMaximumLength = dataAttributePair.sourceDataAttribute.characterMaximumLength;
                }
                else if (dataAttribute.characterMaximumLength == null){
                    dataAttributePair.targetDataAttribute.characterMaximumLength = null;
                }
                else{
                    dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("83886080");
                }
                break;
            case "bool":
                dataAttributePair.targetDataAttribute.dataType = "BOOLEAN";
                break;
            case "boolean":
                dataAttributePair.targetDataAttribute.dataType = "BOOLEAN";
                break;
            case "box":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("128");
                break;
            case "bpchar":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER LARGE OBJECT";
                dataAttributePair.targetDataAttribute.setBlankTrimmed();
                //for character large object we don't set a number...
                //dataAttributePair.targetDataAttribute.characterMaximumLength = dataAttributePair.sourceDataAttribute.characterMaximumLength;
                break;
            case "bytea":
                dataAttributePair.targetDataAttribute.dataType = "BINARY LARGE OBJECT";
                //for binary large object we don't set a character max length number...
                break;
            case "char":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER";
                if (dataAttribute.characterMaximumLength != null && 
                        dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("0")) == 1)
                {
                    dataAttributePair.targetDataAttribute.characterMaximumLength = dataAttributePair.sourceDataAttribute.characterMaximumLength;
                }
                else if (dataAttribute.characterMaximumLength == null){
                    dataAttributePair.targetDataAttribute.characterMaximumLength = null;
                }
                else{
                    dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
                }
                dataAttributePair.targetDataAttribute.setBlankTrimmed();
                break;
            case "character":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER";
                if (dataAttribute.characterMaximumLength != null && 
                        dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("0")) == 1)
                {
                    dataAttributePair.targetDataAttribute.characterMaximumLength = dataAttributePair.sourceDataAttribute.characterMaximumLength;
                }
                else if (dataAttribute.characterMaximumLength == null){
                    dataAttributePair.targetDataAttribute.characterMaximumLength = null;
                }
                else{
                    dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
                }
                dataAttributePair.targetDataAttribute.setBlankTrimmed();
                break;
            case "character varying":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                if (dataAttribute.characterMaximumLength != null && 
                        dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("0")) == 1)
                {
                    dataAttributePair.targetDataAttribute.characterMaximumLength = dataAttributePair.sourceDataAttribute.characterMaximumLength;
                }
                else if (dataAttribute.characterMaximumLength == null){
                    dataAttributePair.targetDataAttribute.characterMaximumLength = null;
                }
                else{
                    dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
                }
                break;
            case "cidr":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("128");
                break;
            case "circle":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("64");
                break;
            case "date":
                dataAttributePair.targetDataAttribute.dataType = "DATE";
                dataAttributePair.targetDataAttribute.datetimePrecision = dataAttributePair.sourceDataAttribute.datetimePrecision; //TODO CHECK THIS
                break;
            case "decimal":
                dataAttributePair.targetDataAttribute.dataType = "DECIMAL";
                dataAttributePair.targetDataAttribute.numericPrecision = dataAttributePair.sourceDataAttribute.numericPrecision;
                dataAttributePair.targetDataAttribute.numericScale = dataAttributePair.sourceDataAttribute.numericScale;
                break;
            case "double precision":
                dataAttributePair.targetDataAttribute.dataType = "DOUBLE PRECISION";
                break;
            case "float4":
                dataAttributePair.targetDataAttribute.dataType = "FLOAT";
                break;
            case "float8":
                dataAttributePair.targetDataAttribute.dataType = "FLOAT";
                break;
            case "inet":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("128");
                break;
            case "int":
                dataAttributePair.targetDataAttribute.dataType = "INTEGER";
                break;
            case "int2":
                dataAttributePair.targetDataAttribute.dataType = "SMALLINT";
                break;
            case "int4":
                dataAttributePair.targetDataAttribute.dataType = "SMALLINT";
                break;
            case "int8":
                dataAttributePair.targetDataAttribute.dataType = "INTEGER";
                break;
            case "integer":
                dataAttributePair.targetDataAttribute.dataType = "INTEGER";
                break;
            case "interval":
                dataAttributePair.targetDataAttribute.dataType = "INTERVAL";
                dataAttributePair.targetDataAttribute.datetimePrecision = dataAttributePair.sourceDataAttribute.datetimePrecision;;
                break;
            case "json":
                dataAttributePair.targetDataAttribute.dataType = "JSON";
                break;
            case "jsonb":
                dataAttributePair.targetDataAttribute.dataType = "BINARY LARGE OBJECT";
                break;
            case "line":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("64");
                break;
            case "lseg":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("128");
                break;
            case "macaddr":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("128");
                break;
            case "macaddr8":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("128");
                break;
            case "money":
                dataAttributePair.targetDataAttribute.dataType = "NUMERIC";
                dataAttributePair.targetDataAttribute.numericPrecision = 16;
                dataAttributePair.targetDataAttribute.numericScale = 4;
                break;
            case "numeric":
                dataAttributePair.targetDataAttribute.dataType = "NUMERIC";
                dataAttributePair.targetDataAttribute.numericPrecision = dataAttributePair.sourceDataAttribute.numericPrecision;
                dataAttributePair.targetDataAttribute.numericScale = dataAttributePair.sourceDataAttribute.numericScale;
                break;
            case "path":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
                break;
            case "pg_lsn":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
                break;
            case "pg_snapshot":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
                break;
            case "point":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("1024");
                break;
            case "polygon":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
                break;
            case "real":
                dataAttributePair.targetDataAttribute.dataType = "REAL";
                break;
            case "serial":
                dataAttributePair.targetDataAttribute.dataType = "INTEGER";
                break;
            case "serial2":
                dataAttributePair.targetDataAttribute.dataType = "SMALLINT";
                break;
            case "serial4":
                dataAttributePair.targetDataAttribute.dataType = "SMALLINT";
                break;
            case "serial8":
                dataAttributePair.targetDataAttribute.dataType = "INTEGER";
                break;
            case "smallint":
                dataAttributePair.targetDataAttribute.dataType = "SMALLINT";
                break;
            case "smallserial":
                dataAttributePair.targetDataAttribute.dataType = "SMALLINT";
                break;
            case "text":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER LARGE OBJECT";
                //for character large object we don't set a number...
                //dataAttributePair.targetDataAttribute.characterMaximumLength = dataAttributePair.sourceDataAttribute.characterMaximumLength;
                break;
            case "time":
                dataAttributePair.targetDataAttribute.dataType = "TIME";
                dataAttributePair.targetDataAttribute.datetimePrecision = dataAttributePair.sourceDataAttribute.datetimePrecision;
                break;
            case "time with time zone":
                dataAttributePair.targetDataAttribute.dataType = "TIME WITH TIME ZONE";
                dataAttributePair.targetDataAttribute.datetimePrecision = dataAttributePair.sourceDataAttribute.datetimePrecision;
                break;
            case "timestamp":
                dataAttributePair.targetDataAttribute.dataType = "TIMESTAMP";
                dataAttributePair.targetDataAttribute.datetimePrecision = dataAttributePair.sourceDataAttribute.datetimePrecision;
                break;
            case "timestamp with time zone":
                dataAttributePair.targetDataAttribute.dataType = "TIMESTAMP WITH TIME ZONE";
                dataAttributePair.targetDataAttribute.datetimePrecision = dataAttributePair.sourceDataAttribute.datetimePrecision;
                break;
            case "timestamptz":
                dataAttributePair.targetDataAttribute.dataType = "TIMESTAMP WITH TIME ZONE";
                dataAttributePair.targetDataAttribute.datetimePrecision = dataAttributePair.sourceDataAttribute.datetimePrecision;
                break;
            case "timetz":
                dataAttributePair.targetDataAttribute.dataType = "TIME WITH TIME ZONE";
                dataAttributePair.targetDataAttribute.datetimePrecision = dataAttributePair.sourceDataAttribute.datetimePrecision;
                break;
            case "tsquery":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
                break;
            case "tsvector":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
                break;
            case "txid_snapshot":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
                break;
            case "uuid":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("36");
                break;
            case "varbit ":
                dataAttributePair.targetDataAttribute.dataType = "BIT VARYING";
                if (dataAttribute.characterMaximumLength != null && 
                        dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("0")) == 1)
                {
                    dataAttributePair.targetDataAttribute.characterMaximumLength = dataAttributePair.sourceDataAttribute.characterMaximumLength;
                }
                else if (dataAttribute.characterMaximumLength == null){
                    dataAttributePair.targetDataAttribute.characterMaximumLength = null;
                }
                else{
                    dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
                }
                break;
            case "varchar":
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                if (dataAttribute.characterMaximumLength != null && 
                        dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("0")) == 1)
                {
                    dataAttributePair.targetDataAttribute.characterMaximumLength = dataAttributePair.sourceDataAttribute.characterMaximumLength;
                }
                else if (dataAttribute.characterMaximumLength == null){
                    dataAttributePair.targetDataAttribute.characterMaximumLength = null;
                }
                else{
                    dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
                }
                break;
            case "xml":
                dataAttributePair.targetDataAttribute.dataType = "XML";
                break;
            //handle everything else....range types, arrays, etc.
            default:
                dataAttributePair.targetDataAttribute.dataType = "CHARACTER VARYING";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
        }
        return dataAttributePair;
    }
    
    //todo need to confirm all the possible ansi datatypes (without buying the darn starndard for 100s of dollars
    @Override
    public DataAttributePair convertFromBaseAttribute(DataAttribute dataAttribute, CaseType caseType, DataEntity targetDataEntity){
        DataAttributePair dataAttributePair = this.initializeDataAttributePair(dataAttribute, caseType, targetDataEntity);
        //note that the source data type is lower case and the target is upper just to keep the code straight.
        switch (dataAttributePair.sourceDataAttribute.dataType.toUpperCase()){
            case "BIGINT":
                    dataAttributePair.targetDataAttribute.dataType = "bigint";
                    dataAttributePair.targetDataAttribute.numericPrecision = 64;
                    dataAttributePair.targetDataAttribute.numericScale = 0;
                    break;
            case "BINARY LARGE OBJECT":
                    dataAttributePair.targetDataAttribute.dataType = "bytea";
                    break;
            case "BIT":
                dataAttributePair.targetDataAttribute.dataType = "bit";
                if (dataAttributePair.sourceDataAttribute.characterMaximumLength == null){
                    dataAttributePair.targetDataAttribute.characterMaximumLength = null;
                }
                else if (dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("83886080")) <= 0 &&
                        dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("0")) == 1) {
                    dataAttributePair.targetDataAttribute.characterMaximumLength = dataAttributePair.sourceDataAttribute.characterMaximumLength;
                }
                else{
                    dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("83886080");
                }
                dataAttributePair.targetDataAttribute.setBlankTrimmed();
                break;
            case "BIT VARYING":
                dataAttributePair.targetDataAttribute.dataType = "bit varying";
                if (dataAttributePair.sourceDataAttribute.characterMaximumLength == null){
                    dataAttributePair.targetDataAttribute.characterMaximumLength = null;
                }
                else if (dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("83886080")) <= 0 &&
                        dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("0")) == 1) {
                    dataAttributePair.targetDataAttribute.characterMaximumLength = dataAttributePair.sourceDataAttribute.characterMaximumLength;
                }
                else{
                    dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("83886080");
                }
                dataAttributePair.targetDataAttribute.setBlankTrimmed();
                break;
            case "BOOLEAN":
                    dataAttributePair.targetDataAttribute.dataType = "boolean";
                    break;
            case "CHARACTER":
                dataAttributePair.targetDataAttribute.dataType = "character";
                if (dataAttributePair.sourceDataAttribute.characterMaximumLength == null){
                    dataAttributePair.targetDataAttribute.characterMaximumLength = null;
                }
                else if (dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("10485760")) <= 0 &&
                        dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("0")) == 1) {
                    dataAttributePair.targetDataAttribute.characterMaximumLength = dataAttributePair.sourceDataAttribute.characterMaximumLength;
                }
                else{
                    dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
                }
                dataAttributePair.targetDataAttribute.setBlankTrimmed();
                break;
            case "CHARACTER LARGE OBJECT":
                    dataAttributePair.targetDataAttribute.dataType = "text";
                    break;
            case "CHARACTER VARYING":
                dataAttributePair.targetDataAttribute.dataType = "character varying";
                if (dataAttributePair.sourceDataAttribute.characterMaximumLength == null){
                    dataAttributePair.targetDataAttribute.characterMaximumLength = null;
                }
                else if (dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("10485760")) <= 0 &&
                        dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("0")) == 1) {
                    dataAttributePair.targetDataAttribute.characterMaximumLength = dataAttributePair.sourceDataAttribute.characterMaximumLength;
                }
                else{
                    dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
                }
                dataAttributePair.targetDataAttribute.setBlankTrimmed();
                break;
            case "DATE":
                dataAttributePair.targetDataAttribute.dataType = "date";
                dataAttributePair.targetDataAttribute.datetimePrecision = dataAttributePair.sourceDataAttribute.datetimePrecision; //TODO Fic
                break;
            case "DECIMAL":
                dataAttributePair.targetDataAttribute.dataType = "decimal";
                dataAttributePair.targetDataAttribute.numericPrecision = dataAttributePair.sourceDataAttribute.numericPrecision;
                dataAttributePair.targetDataAttribute.numericScale = dataAttributePair.sourceDataAttribute.numericScale;
                break;
            case "DOUBLE PRECISION":
                dataAttributePair.targetDataAttribute.dataType = "double precision";
                dataAttributePair.targetDataAttribute.numericPrecision = 53;
                dataAttributePair.targetDataAttribute.numericScale = 0;
                break;
            case "FLOAT":
                dataAttributePair.targetDataAttribute.dataType = "float";
                dataAttributePair.targetDataAttribute.numericPrecision = 24;
                dataAttributePair.targetDataAttribute.numericScale = 0;
                break;
            case "INTEGER":
                dataAttributePair.targetDataAttribute.dataType = "integer";
                dataAttributePair.targetDataAttribute.numericPrecision = 32;
                dataAttributePair.targetDataAttribute.numericScale = 0;
                break;
            case "INTERVAL":
                dataAttributePair.targetDataAttribute.dataType = "interval";
                dataAttributePair.targetDataAttribute.datetimePrecision = dataAttributePair.sourceDataAttribute.datetimePrecision;
                break;
            case "JSON":
                dataAttributePair.targetDataAttribute.dataType = "json";
                break;
            case "NATIONAL CHARACTER":
                dataAttributePair.targetDataAttribute.dataType = "character";
                if (dataAttributePair.sourceDataAttribute.characterMaximumLength == null){
                    dataAttributePair.targetDataAttribute.characterMaximumLength = null;
                }
                else if (dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("10485760")) <= 0 &&
                        dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("0")) == 1) {
                    dataAttributePair.targetDataAttribute.characterMaximumLength = dataAttributePair.sourceDataAttribute.characterMaximumLength;
                }
                else{
                    dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
                }
                dataAttributePair.targetDataAttribute.setBlankTrimmed();
                break;
            case "NATIONAL CHARACTER LARGE OBJECT":
                dataAttributePair.targetDataAttribute.dataType = "text";
                break;
            case "NATIONAL CHARACTER VARYING":
                dataAttributePair.targetDataAttribute.dataType = "character varying";
                if (dataAttributePair.sourceDataAttribute.characterMaximumLength == null){
                    dataAttributePair.targetDataAttribute.characterMaximumLength = null;
                }
                else if (dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("10485760")) <= 0 &&
                        dataAttributePair.sourceDataAttribute.characterMaximumLength.compareTo(new BigInteger("0")) == 1) {
                    dataAttributePair.targetDataAttribute.characterMaximumLength = dataAttributePair.sourceDataAttribute.characterMaximumLength;
                }
                else{
                    dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
                }
                dataAttributePair.targetDataAttribute.setBlankTrimmed();
                break;
            case "NUMERIC":
                dataAttributePair.targetDataAttribute.dataType = "numeric";
                dataAttributePair.targetDataAttribute.numericPrecision = dataAttributePair.sourceDataAttribute.numericPrecision;
                dataAttributePair.targetDataAttribute.numericScale = dataAttributePair.sourceDataAttribute.numericScale;
                break;
            case "REAL":
                dataAttributePair.targetDataAttribute.dataType = "real";
                dataAttributePair.targetDataAttribute.numericPrecision = 24;
                dataAttributePair.targetDataAttribute.numericScale = 0;
                break;
            case "SMALLINT":
                dataAttributePair.targetDataAttribute.dataType = "smallint";
                dataAttributePair.targetDataAttribute.numericPrecision = 16;
                dataAttributePair.targetDataAttribute.numericScale = 0;
                break;
            case "TIME":
                dataAttributePair.targetDataAttribute.dataType = "time";
                dataAttributePair.targetDataAttribute.datetimePrecision = dataAttributePair.sourceDataAttribute.datetimePrecision;
                break;
            case "TIME WITH TIME ZONE":
                dataAttributePair.targetDataAttribute.dataType = "time with time zone";
                dataAttributePair.targetDataAttribute.datetimePrecision = dataAttributePair.sourceDataAttribute.datetimePrecision;
                break;
            case "TIMESTAMP":
                dataAttributePair.targetDataAttribute.dataType = "timestamp";
                dataAttributePair.targetDataAttribute.datetimePrecision = dataAttributePair.sourceDataAttribute.datetimePrecision;
                break;
            case "TIMESTAMP WITH TIME ZONE":
                dataAttributePair.targetDataAttribute.dataType = "timestamp with time zone";
                dataAttributePair.targetDataAttribute.datetimePrecision = dataAttributePair.sourceDataAttribute.datetimePrecision;
                break;
            case "XML":
                dataAttributePair.targetDataAttribute.dataType = "xml";
                break;
            //should never need this, but just in case something slipped through, set to char and max char length.
            default:
                dataAttributePair.targetDataAttribute.dataType = "character varying";
                dataAttributePair.targetDataAttribute.characterMaximumLength = new BigInteger("10485760");
        }
         return dataAttributePair;
    }
    
    @Override
    public boolean isTargetChanged(){
        return false;
    }
    
}
