/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.github.jpmtimexsinclair.datarose;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jim
 */
public class Datarose {

    public static void main(String[] args) {
        test3();
    }
    

    public static void test3(){
        DataObject mySourceDb = new DataObject("mySourceEntity", "source db");
        DataObject mySourceSchema = new DataObject("sourceschema", "source schema", DataObjectType.SCHEMA, mySourceDb);
        DataEntity mySourceEntity = new DataEntity("sourceentity", "source entity comment", mySourceSchema);
        List<DataAttribute> sourceDataAttributeCollection = new ArrayList<>();
        //DataAttribute col1 = new DataAttribute("col1", "test col1", 1, "varchar", true);
        sourceDataAttributeCollection.add(new DataAttribute("col1", "test col1", mySourceEntity, 1, "varchar", true));
        sourceDataAttributeCollection.add(new DataAttribute("col2", "test col1", mySourceEntity, 2, "varchar", true));
        mySourceEntity.setDataAttributeCollection(sourceDataAttributeCollection);
        
        
        PostgreSQLRose postgresqlRose = new PostgreSQLRose();
        DuckDBRose duckdbRose = new DuckDBRose();
        RoseConversion roseConversion = new RoseConversion(postgresqlRose, duckdbRose);
        ConversionEntity conversionEntity = roseConversion.convertEntity(mySourceEntity, CaseType.CONSTANT);
        
        String returnString = "";
        for(DataAttribute attribute : conversionEntity.sourceDataEntity.dataAttributeCollection)
        {   
            Integer i = attribute.ordinalPosition;
            returnString += "column name:" + attribute.name + ", " +
                    i.toString() + "\n";
        }
        System.out.println("Source entity");
        System.out.println(returnString);
        returnString = "";
        System.out.println("Target entity");
        System.out.println(conversionEntity.targetDataEntity.name);
        System.out.println(conversionEntity.targetDataEntity.parentDataObject.name);
        System.out.println(conversionEntity.targetDataEntity.parentDataObject.parentDataObject.name);
        for(DataAttribute attribute : conversionEntity.targetDataEntity.dataAttributeCollection)
        {   
            Integer i = attribute.ordinalPosition;
            returnString += "column name:" + attribute.name + ", " +
                    i.toString() + "\n";
        }
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
