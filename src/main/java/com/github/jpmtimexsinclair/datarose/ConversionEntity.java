/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.jpmtimexsinclair.datarose;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jim
 */
public class ConversionEntity {
    public DataEntity sourceDataEntity;
    public DataEntity targetDataEntity;
    public List<DataAttributePair> dataAttributePairCollection = new ArrayList<>();
    
    public ConversionEntity(DataEntity sourceDataEntity){
        this.sourceDataEntity = sourceDataEntity;
    }
    
}
