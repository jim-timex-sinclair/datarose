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
public class DataEntity extends DataObject{
    public List<DataAttribute> dataAttributeCollection = new ArrayList<>();
    
    public DataEntity(String name, String comment, DataObject parentDataObject){
                //parent properties
        super(name, comment, DataObjectType.ENTITY, parentDataObject);
    }
    
    public void setDataAttributeCollection(List<DataAttribute> dataAttributeCollection){
        this.dataAttributeCollection = dataAttributeCollection;
    }
    
    public List<DataAttribute> getDataAttributeCollection(){
        return this.dataAttributeCollection;
    }
    
    public void addDataAttribute(DataAttribute dataAttribute){
        this.dataAttributeCollection.add(dataAttribute);
    }

}
