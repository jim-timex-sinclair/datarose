/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jimtimexsinclair.datarose;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jim
 * Conversion entity is basically a working object that stores the source and
 * targets for a source to target conversion.  The dataAttributePairCollection
 * is basically a map of source to target columns.  The source and target data entities
 * are there and basically for convenience.  They can be iterated against to build ddl.
 */
public class ConversionEntity {
    public DataEntity sourceDataEntity;
    public DataEntity targetDataEntity;
    public List<DataAttributePair> dataAttributePairCollection = new ArrayList<>();
    
    public ConversionEntity(DataEntity sourceDataEntity){
        this.sourceDataEntity = sourceDataEntity;
    }
    
}
