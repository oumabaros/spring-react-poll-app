/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfca.app.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author Administrator
 */
@Entity
public class Journal {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
    private String title;
    private Date created;
    private String summary;
    
    @Transient
    private SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
    
    public Journal(String title,String summary,String date) throws Exception{
        this.title=title;
        this.summary=summary;
        this.created=format.parse(date);
    }
    
    Journal(){}
    
    public Long getId(){
        return Id;
    }
    
    public void setId(Long Id){
        this.Id=Id;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title=title;
    }
    
    public String getSummary(){
        return summary;
    }
    
    public void setSummary(String summary){
        this.summary=summary;
    }
    
    public Date getCreated(){
        return created;
    }
    
    public void setCreated(Date created){
        this.created=created;
    }
    
    public String getCreatedAsShort(){
        return format.format(created);
    }
    
    public String toString(){
        StringBuilder value=new StringBuilder("Journal Entry(");
        value.append("Id: ");
        value.append(Id);
        value.append(", Title:");
        value.append(title);
        value.append(", Summary: ");
        value.append(summary);
        value.append(", Created:");
        value.append(created);
        value.append(getCreatedAsShort());
        value.append(")");
        return value.toString();
        
    }
}
