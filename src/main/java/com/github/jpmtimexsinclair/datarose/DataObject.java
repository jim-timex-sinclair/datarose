/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.jpmtimexsinclair.datarose;

/**
 *
 * @author Jim
 */
public class DataObject {
    
    public String name;
    public DataObjectType dataObjectType;
    public String comment;
    public DataObject parentDataObject;
      
    public DataObject(String name, String comment){
        this.name = name;
        this.dataObjectType = DataObjectType.DATABASE;
        this.comment = comment;
    }
    
    public DataObject(String name, String comment, DataObjectType dataObjectType, DataObject parentDataObject){
        this.name = name;
        this.dataObjectType = dataObjectType;
        this.comment = comment;
        this.parentDataObject = parentDataObject;
    }
    
}
