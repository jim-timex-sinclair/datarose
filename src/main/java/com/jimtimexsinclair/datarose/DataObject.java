/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jimtimexsinclair.datarose;

/**
 *
 * @author Jim
 * For objects not yet supported by the enum, this can be set to a CUSTOMOBJCTTYPE.
 * CUSTOMDATAOBJECT -> CUSTOMDATAOBJECT
 */
public class DataObject {
    public String name;
    public DataObjectType dataObjectType;
    public String comment;
    public DataObject parentDataObject;
    public String customObjectTypeName;
    
    /**
     *
     * @param name the name of the object
     * @param comment a comment describing the object.  In cases of custom data objects set this to a good description of the the actual object
     * then set the customObjectTypeName string.
     */
    public DataObject(String name, String comment){
        this.name = name;
        this.comment = comment;
        this.dataObjectType = DataObjectType.CUSTOMDATAOBJECT;
    }

    /**
     *
     * @param name the name of the object
     * @param comment a comment describing the object.
     * @param dataObjectType a value of the DataObjectTypeEnum ACCOUNT, SERVER, DATABASE, SCHEMA, ENTITY, ATTRIBUTE, DIRECTORY, BUCKET, 
     * and CUSTOMDATAOBJECT
     */
    public DataObject(String name, String comment, DataObjectType dataObjectType){
        this.name = name;
        this.dataObjectType = dataObjectType;
        this.comment = comment;
    }
    
    /**
     *
     * @param name the name of the object
     * @param dataObjectType a value of the DataObjectTypeEnum ACCOUNT, SERVER, DATABASE, SCHEMA, ENTITY, ATTRIBUTE, DIRECTORY, BUCKET, 
     * and CUSTOMDATAOBJECT
     */
    public DataObject(String name, DataObjectType dataObjectType){
        this.name = name;
        this.dataObjectType = dataObjectType;
    }
    
    /**
     *
     * @param name the name of the object
     * @param comment a comment describing the object.
     * @param dataObjectType a value of the DataObjectTypeEnum ACCOUNT, SERVER, DATABASE, SCHEMA, ENTITY, ATTRIBUTE, DIRECTORY, BUCKET, 
     * and CUSTOMDATAOBJECT
     * @param parentDataObject the parentDataObject of this data object.
     */
    public DataObject(String name, String comment, DataObjectType dataObjectType, DataObject parentDataObject){
        this.name = name;
        this.dataObjectType = dataObjectType;
        this.comment = comment;
        this.parentDataObject = parentDataObject;
    }
    
    //no comment

    /**
     *
     * @param name
     * @param dataObjectType
     * @param parentDataObject
     */
    public DataObject(String name, DataObjectType dataObjectType, DataObject parentDataObject){
        this.name = name;
        this.dataObjectType = dataObjectType;
        this.parentDataObject = parentDataObject;
    }
    
    /**
     *
     * @param customObjectTypeName if this is a CUSTOMOBJECTTYPE this can be used to set the name of that object.
     */
    public void setCustomObjectTypeName(String customObjectTypeName)
    {
        this.customObjectTypeName = customObjectTypeName;
    }
    
     /**
     *
     * @return  returns the parent data object.*/
    public DataObject getParent()
    {
        return this.parentDataObject;
    }
       
}
