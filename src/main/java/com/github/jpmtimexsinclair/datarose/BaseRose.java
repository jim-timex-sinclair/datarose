/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.jpmtimexsinclair.datarose;
//import java.math.BigInteger;

/**
 *
 * @author Jim
 */
public class BaseRose {
    

    
    //there is no defined max length in ansi SQL so this is not true.
    //public static BigInteger BASECHARMAXLENGTH = new BigInteger("2147483648");  //2gb for max varchar size.
    //public static Integer MAXLEN = 2147483648;
    
    public DataEntity convertContainerNames(DataEntity dataEntity, CaseType caseType){
        DataEntity targetEntity = new DataEntity(CaseConversion.autoConvertCase(dataEntity.name, caseType),
            dataEntity.comment, dataEntity.parentDataObject);
        targetEntity.parentDataObject.name = CaseConversion.autoConvertCase(dataEntity.parentDataObject.name, caseType);
        targetEntity.parentDataObject.parentDataObject.name = CaseConversion.autoConvertCase(dataEntity.parentDataObject.parentDataObject.name, caseType);
        return targetEntity;
    }
    
    public ConversionEntity initializeConversionEntity(DataEntity dataEntity, CaseType caseType){
        ConversionEntity conversionEntity = new ConversionEntity(dataEntity);
        conversionEntity.targetDataEntity = this.convertContainerNames(dataEntity, caseType);
        return conversionEntity;
    }
    
    public DataAttributePair initializeConversionAttribute(DataAttribute dataAttribute, CaseType caseType){
        DataAttribute targetAttribute = new DataAttribute(CaseConversion.autoConvertCase(dataAttribute.name, caseType), dataAttribute.comment, 
                dataAttribute.parentDataObject, dataAttribute.ordinalPosition, dataAttribute.isNullable, 
                dataAttribute.isPrimaryKey, dataAttribute.constraintOrdinalPosition);
        DataAttributePair dataAttributePair = new DataAttributePair(dataAttribute, targetAttribute);
        return dataAttributePair;
    }

}
