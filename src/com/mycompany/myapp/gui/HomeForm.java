/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author bhk
 */
public class HomeForm extends Form{

    public HomeForm() {
        
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnAddCoach = new Button("Add Coach");
        btnAddCoach.setIcon(FontImage.createMaterial(FontImage.MATERIAL_ADD, btnAddCoach.getUnselectedStyle()));
        Button btnListCoach = new Button("List Coach");
        btnListCoach.setIcon(FontImage.createMaterial(FontImage.MATERIAL_LIST, btnListCoach.getUnselectedStyle()));
        btnAddCoach.addActionListener(e-> new AddCoachForm(this).show());
        btnListCoach.addActionListener(e-> new ListCoachsForm(this).show());
        addAll(btnAddCoach, btnListCoach);
        
    }
    
    
}
