/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jimtimexsinclair.datarose;

/**
 *The interface defines what the classes will do.  How they convert from an 
 * entity to an entity is up to the class.
 * @author Jim
 */
public interface Convertable {
    ConversionEntity convertToBaseEntity(DataEntity dataEntity);
    ConversionEntity convertFromBaseEntity(DataEntity dataEntity, CaseType caseType, DataObject targetParentDataObject);
    DataAttributePair convertToBaseAttribute(DataAttribute dataAttribute, DataEntity dataEntity);
    DataAttributePair convertFromBaseAttribute(DataAttribute dataAttribute, CaseType caseType, DataEntity targetDataEntity);
    boolean isTargetChanged();
}
