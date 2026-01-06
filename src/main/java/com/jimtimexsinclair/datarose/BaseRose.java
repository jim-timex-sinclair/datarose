/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jimtimexsinclair.datarose;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;
//import java.math.BigInteger;

/**
 *
 * @author Jim
 */
public class BaseRose {
    
    //there is no defined max length in ansi SQL so this is not true.
    //public static BigInteger BASECHARMAXLENGTH = new BigInteger("2147483648");  //2gb for max varchar size.
    //public static Integer MAXLEN = 2147483648;
    
    //TODO Need to create new parent entities here...missed this.  Also the name of this function is not right.

    public DataEntity initializeTargetEntity(DataEntity dataEntity, CaseType caseType, DataObject targetParentDataObject){
        DataEntity targetEntity = new DataEntity(CaseConversion.autoConvertCase(dataEntity.name, caseType),
            dataEntity.comment, targetParentDataObject);
        return targetEntity;
    }    
    public DataEntity initializeBaseTargetEntity(DataEntity dataEntity, CaseType caseType){
        DataEntity targetEntity = null;
        Deque<DataObject> workingDataObjectStack = new ArrayDeque<>();
        DataObject workingDataObject = dataEntity;
        //set up a stack to build the object hierarcny
        while (workingDataObject != null)
        {
            workingDataObjectStack.push(workingDataObject);
            workingDataObject = workingDataObject.getParent();
        }
        
        workingDataObject = workingDataObjectStack.pop();
        DataObject parentDataObject = null;
        DataObject dataObject;
        while (workingDataObject != null)
        {
            if (workingDataObject.dataObjectType == DataObjectType.ENTITY)
            {
                targetEntity = new DataEntity(CaseConversion.autoConvertCase(dataEntity.name, caseType),
                dataEntity.comment, parentDataObject);
                break;
            }
            else
            {
                //create the dataobject
                dataObject = new DataObject(workingDataObject.name, workingDataObject.comment, workingDataObject.dataObjectType, parentDataObject);
                //then seet the parent data object to this for the next create.
                parentDataObject = dataObject;
            }
            workingDataObject = workingDataObjectStack.pop();
            //workingDataObject = workingDataObject.getParent();
        }
        
        return targetEntity;
    }
    
    //we take the default source parent objects for base conversion.
    public ConversionEntity initializeConversionEntity(DataEntity dataEntity, CaseType caseType){
        ConversionEntity conversionEntity = new ConversionEntity(dataEntity);
        conversionEntity.targetDataEntity = this.initializeBaseTargetEntity(dataEntity, caseType);
        return conversionEntity;
    }
    
    public ConversionEntity initializeConversionEntity(DataEntity dataEntity, CaseType caseType, DataObject targetParentDataObject){
        ConversionEntity conversionEntity = new ConversionEntity(dataEntity);
        conversionEntity.targetDataEntity = this.initializeTargetEntity(dataEntity, caseType, targetParentDataObject);
        return conversionEntity;
    }
    
    public DataAttributePair initializeDataAttributePair(DataAttribute dataAttribute, CaseType caseType, DataEntity targetDataEntity){
        DataAttribute targetAttribute = new DataAttribute(CaseConversion.autoConvertCase(dataAttribute.name, caseType), dataAttribute.comment, 
                targetDataEntity, dataAttribute.ordinalPosition, dataAttribute.isNullable, 
                dataAttribute.isPrimaryKey, dataAttribute.constraintOrdinalPosition);
        DataAttributePair dataAttributePair = new DataAttributePair(dataAttribute, targetAttribute);
        return dataAttributePair;
    }

}
