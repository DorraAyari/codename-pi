/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.IconHolder;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Coach;
import com.mycompany.myapp.services.ServiceCoach;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public class ListCoachsForm extends Form {

    public ListCoachsForm(Form previous) {
        setTitle("List Coachs");
        setLayout(BoxLayout.y());

        /*SpanLabel sp = new SpanLabel();
        sp.setText(ServiceTask.getInstance().getAllTasks().toString());
        add(sp);
         */
        ArrayList<Coach> coachs = ServiceCoach.getInstance().getAllCoachs();
        for (Coach t : coachs) {
            addElement(t);
        }

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

    }

    public void addElement(Coach coach) {
        int primaryColor = 0x2196F3;
int secondaryColor = 0xE91E63;
        // Créer les labels pour chaque attribut du coach
        Label nomLabel = new Label("Nom: ");
        Label nomValue = new Label(coach.getNom());
        Label descLabel = new Label("Description: ");
        Label descValue = new Label(coach.getDescription());
        Label ageLabel = new Label("Age: ");
        Label ageValue = new Label(String.valueOf(coach.getAge()));
        Label heightLabel = new Label("Taille: ");
        Label heightValue = new Label(coach.getHeight());
        Label weightLabel = new Label("Poids: ");
        Label weightValue = new Label(coach.getWeight());
        Label occupationLabel = new Label("Occupation: ");
        Label occupationValue = new Label(coach.getOccupation());
nomLabel.getStyle().setFgColor(primaryColor);
descLabel.getStyle().setFgColor(primaryColor);
ageLabel.getStyle().setFgColor(primaryColor);
heightLabel.getStyle().setFgColor(primaryColor);
weightLabel.getStyle().setFgColor(primaryColor);
occupationLabel.getStyle().setFgColor(primaryColor);
        // labelFont les labels avec la police et la taille du texte

        Font valueFont = Font.createTrueTypeFont("native:MainLight", "native:MainLight").derive(40f, Font.STYLE_BOLD);
        nomLabel.getStyle().setFont(valueFont);
        nomValue.getStyle().setFont(valueFont);
        descLabel.getStyle().setFont(valueFont);
        descValue.getStyle().setFont(valueFont);
        ageLabel.getStyle().setFont(valueFont);
        ageValue.getStyle().setFont(valueFont);
        heightLabel.getStyle().setFont(valueFont);
        heightValue.getStyle().setFont(valueFont);
        weightLabel.getStyle().setFont(valueFont);
        weightValue.getStyle().setFont(valueFont);
        occupationLabel.getStyle().setFont(valueFont);
        occupationValue.getStyle().setFont(valueFont);

        // Ajouter les labels à un container horizontal
        Container row = new Container(BoxLayout.x());
        row.add(nomLabel).add(nomValue);
        add(row);
        row = new Container(BoxLayout.x());
        row.add(descLabel).add(descValue);
        add(row);
        row = new Container(BoxLayout.x());
        row.add(ageLabel).add(ageValue);
        add(row);
        row = new Container(BoxLayout.x());
        row.add(heightLabel).add(heightValue);
        add(row);
        row = new Container(BoxLayout.x());
        row.add(weightLabel).add(weightValue);
        add(row);
        row = new Container(BoxLayout.x());
        row.add(occupationLabel).add(occupationValue);
        add(row);
    }


}
