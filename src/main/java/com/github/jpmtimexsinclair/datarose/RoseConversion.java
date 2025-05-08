/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.jpmtimexsinclair.datarose;

/**
 *
 * @author Jim
 */
public class RoseConversion {
    private Convertable sourceRose;
    private Convertable targetRose;
    
    public RoseConversion(Convertable sourceRose, Convertable targetRose){
        this.sourceRose = sourceRose;
        this.targetRose = targetRose;
    }
    
    public ConversionEntity convertEntity(DataEntity sourceDataEntity, CaseType caseType){
        ConversionEntity baseConversionEntity = this.sourceRose.convertToBaseEntity(sourceDataEntity);
        ConversionEntity targetConversionEntity = this.targetRose.convertFromBaseEntity(baseConversionEntity.targetDataEntity, caseType);
        return targetConversionEntity;
    }
    
}
