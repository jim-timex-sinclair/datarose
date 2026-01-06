/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jimtimexsinclair.datarose;

import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

/**
 *
 * @author Jim
 */
public class Datarose {

    public static void main(String[] args) {
        test3();
    }
    
    /*
    I havent set up tests yet using 
    */
    public static void test3(){
        //we don't heed a collection here....but
        DataObject mySourceDb = new DataObject("my_source_db", "source db", DataObjectType.DATABASE);
        DataObject mySourceSchema = new DataObject("my_source_schema", "source schema", DataObjectType.SCHEMA, mySourceDb);
        //mySourceSchema.setParentChild();
        DataEntity mySourceEntity = new DataEntity("sourceentity", "source entity comment", mySourceSchema);
        String test0 = "Source DB and schema: " + mySourceEntity.parentDataObject.parentDataObject.name + " " + mySourceEntity.parentDataObject.name;
        System.out.println(test0);
        //mySourceEntity.setParentChild();
        List<DataAttribute> sourceDataAttributeCollection = new ArrayList<>();
        //DataAttribute col1 = new DataAttribute("col1", "test col1", 1, "varchar", true);
        //sourceDataAttributeCollection.add(new DataAttribute("col1", "test col1", mySourceEntity, 1, "varchar", true));
        //sourceDataAttributeCollection.add(new DataAttribute("col2", "test col1", mySourceEntity, 2, "varchar", true));
        sourceDataAttributeCollection.add(new DataAttribute("column_bigint", mySourceEntity, 1, false, "bigint", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_bigserial", mySourceEntity, 2, false, "bigserial", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_bit", mySourceEntity, 3, true, "bit", new BigInteger("60"), false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_bit_varying", mySourceEntity, 4, true, "bit varying", new BigInteger("60"), false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_bool", mySourceEntity, 5, false, "bool", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_boolean", mySourceEntity, 6, false, "boolean", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_box", mySourceEntity, 7, false, "box", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_bytea", mySourceEntity, 8, false, "bytea", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_char", mySourceEntity, 9, true, "char", new BigInteger("60"), false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_character", mySourceEntity, 10, true, "character", new BigInteger("60"), false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_character_varying", mySourceEntity, 11, true, "character varying", new BigInteger("60"), false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_cidr", mySourceEntity, 12, false, "cidr", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_circle", mySourceEntity, 13, false, "circle", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_date", mySourceEntity, 14, true, "date", 9, false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_decimal", mySourceEntity, 15, true, "decimal", 10, 1, false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_double_precision", mySourceEntity, 16, false, "double precision", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_float4", mySourceEntity, 17, false, "float4", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_float8", mySourceEntity, 18, false, "float8", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_inet", mySourceEntity, 19, false, "inet", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_int", mySourceEntity, 20, false, "int", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_int2", mySourceEntity, 21, false, "int2", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_int4", mySourceEntity, 22, false, "int4", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_int8", mySourceEntity, 23, false, "int8", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_integer", mySourceEntity, 24, false, "integer", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_interval", mySourceEntity, 25, false, "interval", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_json", mySourceEntity, 26, false, "json", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_jsonb", mySourceEntity, 27, false, "jsonb", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_line", mySourceEntity, 28, false, "line", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_lseg", mySourceEntity, 29, false, "lseg", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_macaddr", mySourceEntity, 30, false, "macaddr", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_macaddr8", mySourceEntity, 31, false, "macaddr8", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_money", mySourceEntity, 32, false, "money", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_numeric", mySourceEntity, 33, true, "numeric", 10, 1, false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_path", mySourceEntity, 34, false, "path", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_pg_lsn", mySourceEntity, 35, false, "pg_lsn", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_pg_snapshot", mySourceEntity, 36, false, "pg_snapshot", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_point", mySourceEntity, 37, false, "point", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_polygon", mySourceEntity, 38, false, "polygon", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_real", mySourceEntity, 39, false, "real", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_serial", mySourceEntity, 40, false, "serial", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_serial2", mySourceEntity, 41, false, "serial2", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_serial4", mySourceEntity, 42, false, "serial4", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_serial8", mySourceEntity, 43, false, "serial8", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_smallint", mySourceEntity, 44, false, "smallint", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_smallserial", mySourceEntity, 45, false, "smallserial", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_text", mySourceEntity, 46, false, "text", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_time", mySourceEntity, 47, true, "time", 9, false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_time_with_time_zone", mySourceEntity, 48, true, "time with time zone", 9, false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_timestamp", mySourceEntity, 49, true, "timestamp", 9, false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_timestamp_with_time_zone", mySourceEntity, 50, true, "timestamp with time zone", 9, false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_timestamptz", mySourceEntity, 51, true, "timestamptz", 9, false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_timetz", mySourceEntity, 52, true, "timetz", 9, false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_tsquery", mySourceEntity, 53, false, "tsquery", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_tsvector", mySourceEntity, 54, false, "tsvector", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_txid_snapshot", mySourceEntity, 55, false, "txid_snapshot", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_uuid", mySourceEntity, 56, false, "uuid", false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_varbit_", mySourceEntity, 57, true, "varbit ", new BigInteger("60"), false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_varchar", mySourceEntity, 58, true, "varchar", new BigInteger("60"), false, -1));
        sourceDataAttributeCollection.add(new DataAttribute("column_xml", mySourceEntity, 59, false, "xml", false, -1));
        mySourceEntity.setDataAttributeCollection(sourceDataAttributeCollection);
        
        
        PostgreSQLRose postgresqlRose = new PostgreSQLRose();
        DuckDBRose duckdbRose = new DuckDBRose();
        RoseConversion roseConversion = new RoseConversion(postgresqlRose, duckdbRose);
        //this is kind of wrong....need to pass in the target parent info even though the entity name ifself will be converted..but 
        //the rest has to be passed in.
        DataObject myTargetDb = new DataObject("my_target_db", "source db", DataObjectType.DATABASE);
        DataObject myTargetSchema = new DataObject("my_target_schema", "source schema", DataObjectType.SCHEMA, myTargetDb);
        ConversionEntity targetConversionEntity = roseConversion.convertEntity(mySourceEntity, CaseType.CONSTANT, myTargetSchema);
        ConversionEntity baseConversionEntity = roseConversion.getBaseConversionEntity();
        String test1 = "Source DB and schema: " + baseConversionEntity.sourceDataEntity.parentDataObject.parentDataObject.name + " " + baseConversionEntity.sourceDataEntity.parentDataObject.name;
        System.out.println(test1);
        test1 = "Target DB and schema: " + baseConversionEntity.targetDataEntity.parentDataObject.parentDataObject.name + " " + baseConversionEntity.targetDataEntity.parentDataObject.name;
        System.out.println(test1);
        
        test1 = "Source DB and schema: " + targetConversionEntity.sourceDataEntity.parentDataObject.parentDataObject.name + " " + targetConversionEntity.sourceDataEntity.parentDataObject.name;
        System.out.println(test1);
        test1 = "Target DB and schema: " + targetConversionEntity.targetDataEntity.parentDataObject.parentDataObject.name + " " + targetConversionEntity.targetDataEntity.parentDataObject.name;
        System.out.println(test1);
        
        
        //losing the map of source to target....  It's not two way, but three way now
        //source -> base -> target
        String returnString = "Base Conversion Entity\n";
        for(DataAttributePair dataAttributePair : baseConversionEntity.dataAttributePairCollection)
        {   
            Integer i = dataAttributePair.sourceDataAttribute.ordinalPosition;
            returnString += "source column name: " + dataAttributePair.sourceDataAttribute.name + ", " +
                    "target column name: " + dataAttributePair.targetDataAttribute.name + ", " +
                    "source datatype: " + dataAttributePair.sourceDataAttribute.dataType + ", " +
                    "target datatype: " + dataAttributePair.targetDataAttribute.dataType + " " +
                    i.toString() + "\n";
        }
        returnString += "Target Conversion Entity";
        for(DataAttributePair dataAttributePair : targetConversionEntity.dataAttributePairCollection)
        {   
            Integer i = dataAttributePair.sourceDataAttribute.ordinalPosition;
            returnString += "source column name: " + dataAttributePair.sourceDataAttribute.name + ", " +
                    "target column name: " + dataAttributePair.targetDataAttribute.name + ", " +
                    "source datatype: " + dataAttributePair.sourceDataAttribute.dataType + ", " +
                    "target datatype: " + dataAttributePair.targetDataAttribute.dataType + " " +
                    i.toString() + "\n";
        }
        
        /*
        for(DataAttribute attribute : targetConversionEntity.sourceDataEntity.dataAttributeCollection)
        {   
            Integer i = attribute.ordinalPosition;
            returnString += "column name:" + attribute.name + ", " +
                    i.toString() + "\n";
        }
        System.out.println("Source entity attributes");
        System.out.println(returnString);
        returnString = "";
        System.out.println("Target entity");
        System.out.println(targetConversionEntity.targetDataEntity.name);
        System.out.println(targetConversionEntity.targetDataEntity.parentDataObject.name);
        System.out.println(targetConversionEntity.targetDataEntity.parentDataObject.parentDataObject.name);
        for(DataAttribute attribute : targetConversionEntity.targetDataEntity.dataAttributeCollection)
        {   
            Integer i = attribute.ordinalPosition;
            returnString += "column name:" + attribute.name + ", " +
                    i.toString() + "\n";
        }
        */
        System.out.println(returnString);

    }
    
    public static void test2(){
        DataObject mySourceDb = new DataObject("mySourceEntity", "source db");
        DataObject mySourceSchema = new DataObject("sourceschema", "source schema", DataObjectType.SCHEMA, mySourceDb);
        DataEntity mySourceEntity = new DataEntity("sourceentity", "source entity comment", mySourceSchema);
        List<DataAttribute> sourceDataAttributeCollection = new ArrayList<>();
        //DataAttribute col1 = new DataAttribute("col1", "test col1", 1, "varchar", true);
        sourceDataAttributeCollection.add(new DataAttribute("col1", "test col1", mySourceEntity, 1, "varchar", true));
        sourceDataAttributeCollection.add(new DataAttribute("col2", "test col1", mySourceEntity, 2, "varchar", true));
        mySourceEntity.setDataAttributeCollection(sourceDataAttributeCollection);
        System.out.println("Source entity");
        System.out.println(mySourceEntity.name);
        System.out.println(mySourceEntity.parentDataObject.name);
        System.out.println(mySourceEntity.parentDataObject.parentDataObject.name);
        String returnString = "";
        for(DataAttribute attribute : mySourceEntity.dataAttributeCollection)
        {   
            Integer i = attribute.ordinalPosition;
            returnString += "column name:" + attribute.name + ", " +
                    i.toString() + "\n";
        }
        System.out.println(returnString);
        DataObject myTargetDb = new DataObject("mytargetdb", "targetdbcomment");
        DataObject myTargetSchema = new DataObject("mytargetschema", "target schema comment", DataObjectType.SCHEMA, myTargetDb);
        DataEntity myTargetEntity = new DataEntity("targetentity", "target entity comment", myTargetSchema);
        List<DataAttributePair> dataAttributePairCollection = new ArrayList<>();
        for(DataAttribute sourceDataAttribute : mySourceEntity.dataAttributeCollection)
        {   
            Integer i = sourceDataAttribute.ordinalPosition;
            DataAttribute targetDataAttribute = new DataAttribute(sourceDataAttribute.name, sourceDataAttribute.comment, myTargetEntity, i, sourceDataAttribute.dataType, sourceDataAttribute.isNullable);
            dataAttributePairCollection.add(new DataAttributePair(sourceDataAttribute, targetDataAttribute));
            myTargetEntity.addDataAttribute(targetDataAttribute);
        }
        System.out.println("Target entity");
        System.out.println(myTargetEntity.name);
        System.out.println(myTargetEntity.parentDataObject.name);
        System.out.println(myTargetEntity.parentDataObject.parentDataObject.name);
        returnString = "";
        for(DataAttribute attribute : myTargetEntity.dataAttributeCollection)
        {   
            Integer i = attribute.ordinalPosition;
            returnString += "column name:" + attribute.name + ", " +
                    i.toString() + "\n";
        }
        System.out.println(returnString);
        System.out.println("Data Map");
        returnString = "";
        for(DataAttributePair dataAttributePair : dataAttributePairCollection)
        {   

            returnString += "Name:" + dataAttributePair.sourceDataAttribute.parentDataObject.parentDataObject.name +
                    "." + dataAttributePair.sourceDataAttribute.parentDataObject.name +
                    "." + dataAttributePair.sourceDataAttribute.name +
                    ", " +
                    dataAttributePair.targetDataAttribute.parentDataObject.parentDataObject.name +
                    "." + dataAttributePair.targetDataAttribute.parentDataObject.name +
                    "." + dataAttributePair.targetDataAttribute.name + "\n";
        }
        System.out.println(returnString);
    }
    
    public static void test(){
        System.out.println("Starting Testapp");
        String testNameIn = "lastName%**LikeThis";
        String testNameOut = CaseConversion.autoConvertCase(testNameIn, CaseType.TITLE);
        System.out.println(testNameOut);
        testNameIn = "AAA21Id";
        testNameOut = CaseConversion.autoConvertCase(testNameIn, CaseType.TITLE);
        System.out.println(testNameOut);
        testNameIn = "Lot22Name";
        testNameOut = CaseConversion.autoConvertCase(testNameIn, CaseType.TITLE);
        System.out.println(testNameOut);
        testNameIn = "lastName";
        testNameOut = CaseConversion.autoConvertCase(testNameIn, CaseType.TITLE);
        System.out.println(testNameOut);
        testNameIn = "last_NameLikeThis";
        testNameOut = CaseConversion.autoConvertCase(testNameIn, CaseType.TITLE);
        System.out.println(testNameOut);
        testNameIn = "AAAId";
        testNameOut = CaseConversion.autoConvertCase(testNameIn, CaseType.TITLE);
        System.out.println(testNameOut);
        System.out.println("Ending Testapp");
    }
}
