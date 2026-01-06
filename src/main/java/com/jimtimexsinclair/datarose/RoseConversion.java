/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jimtimexsinclair.datarose;

/**
 *
 * @author Jim This is basically the class that brings everything together and
 * performs the actual conversion calls. The base conversion entity holds the
 * source to base entity and attribute conversion and when the convert entity is
 * called two conversions are performed, source to base, then base to target.
 */
public class RoseConversion {

    private Convertable sourceRose;
    private Convertable targetRose;
    private ConversionEntity baseConversionEntity;
    private ConversionEntity targetConversionEntity;

    public RoseConversion(Convertable sourceRose, Convertable targetRose) {
        this.sourceRose = sourceRose;
        this.targetRose = targetRose;
    }

    public ConversionEntity convertEntity(DataEntity sourceDataEntity, CaseType caseType, DataObject targetParentDataObject) {
        this.baseConversionEntity = this.sourceRose.convertToBaseEntity(sourceDataEntity);
        this.targetConversionEntity = this.targetRose.convertFromBaseEntity(baseConversionEntity.targetDataEntity, caseType, targetParentDataObject);
        return this.targetConversionEntity;
    }

    public ConversionEntity getBaseConversionEntity() {
        return this.baseConversionEntity;
    }

    public ConversionEntity getTargetConversionEntity() {
        return this.targetConversionEntity;
    }

}
