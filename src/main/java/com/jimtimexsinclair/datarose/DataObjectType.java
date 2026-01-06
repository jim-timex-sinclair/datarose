/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.jimtimexsinclair.datarose;

/**
 *
 * @author Jim
 * Note that certain hierarchies are implied but not enforced for flexibility.
 * E.g. 
 * For databases hosted on virtual machines (AWS RDS, Azure)
 * ACCOUNT -> SERVER -> DATABASE -> SCHEMA -> ENTITY -> ATTRIBUTE
 * For databases hosted as SAAS (Snowflake, Databricks)
 * ACCOUNT -> DATABASE -> SCHEMA -> ENTITY -> ATTRIBUTE
 * For S3 buckets
 * ACCOUNT -> BUCKET -> DIRECTORY -> FILE
 * For objects not yet supported.
 * CUSTOMDATAOBJECT -> CUSTOMDATAOBJECT
 */
public enum DataObjectType {
    
    /**
     * Database
     */
    CUSTOMDATAOBJECT,
    
    /**
     * Database
     */
    ACCOUNT,
    
     /**
     * Database
     */
    SERVER,
    
    /**
     * Database
     */
    DATABASE,
    
    /**
     * Schema
     */
    SCHEMA,
    
    /**
     * Bucket is synonymous with storage account  
     */
    BUCKET,
    
    /**
     * Directory is synonymous with folder. 
     */
    DIRECTORY,
    
    /**
     * Entity
     */
    ENTITY,
    
    /**
     * File
     */
    FILE,

    /**
     * Attribute
     */
    ATTRIBUTE;
}
