/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.github.jpmtimexsinclair.datarose;

/**
 *The interface defines what the classes will do.  How they convert from an 
 * entity to an entity is up to the class.
 * @author Jim
 */
public interface Convertable {
    ConversionEntity convertToBaseEntity(DataEntity dataEntity);
    ConversionEntity convertFromBaseEntity(DataEntity dataEntity, CaseType caseType);
    DataAttributePair convertToBaseAttribute(DataAttribute dataAttribute);
    DataAttributePair convertFromBaseAttribute(DataAttribute dataAttribute, CaseType caseType);
    boolean isTargetChanged();
}
