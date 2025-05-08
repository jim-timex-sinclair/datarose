/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.jpmtimexsinclair.datarose;

/**
 *
 * @author Jim
 * Just a simple data classes (also known as DTOs).  getters and setters can add
 * unnecessary boilerplate code. Fields are just public.
 */
public class DataAttributePair {
    public DataAttribute sourceDataAttribute;
    public DataAttribute targetDataAttribute;
    
    public DataAttributePair(DataAttribute sourceDataAttribute, DataAttribute targetDataAttribute){
        this.sourceDataAttribute = sourceDataAttribute;
        this.targetDataAttribute = targetDataAttribute;
    }
}
