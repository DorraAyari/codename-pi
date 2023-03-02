/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author bhk
 *  * @author bhk
 * 
 */
public class Coach {
    private int id,age;
    private String nom,description,occupation,weight ,height;
    
    public Coach(int id, int age, String nom,String description,String weight,String height) {
        this.id = id;
        this.age = age;
        this.nom = nom;
        this.description = description;
        this.weight = weight;
        this.height = height;

        
    }
    
    public Coach(int age, String nom,String description,String weight,String height,String occupation) {
        this.id = id;
        this.age = age;
        this.nom = nom;
        this.description = description;
        this.weight = weight;
        this.height = height;
        this.occupation = occupation;

        
    }
  public Coach(String nom,String description,String weight,String height,String occupation) {
        this.id = id;
        this.age = age;
        this.nom = nom;
        this.description = description;
        this.weight = weight;
        this.height = height;
        this.occupation = occupation;

        
    }
    public Coach(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Coach() {
    }

  
    

   
 
    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Coach{" + "id=" + id + ", age=" + age + ", nom=" + nom + ", description=" + description + ", occupation=" + occupation + ", weight=" + weight + ", height=" + height + '}';
    }

    public void setDate(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
    
    
}
