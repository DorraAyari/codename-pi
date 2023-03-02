/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Coach;
import com.mycompany.myapp.services.ServiceCoach;
import com.mycompany.myapp.utils.Statics;
import java.util.ArrayList;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;

/**
 *
 * @author bhk
 */
public class AddCoachForm extends Form{
public boolean resultOK;
    private ConnectionRequest req;
    public ArrayList<Coach> coachs;

 
        public AddCoachForm(Form previous) {
        setTitle("Add a new Coach");
         Label nomLabel = new Label("Name");
        Label descriptionLabel = new Label("Description");
        Label ageLabel = new Label("Age");
        
        Label heightLabel = new Label("Height");
        Label weightLabel = new Label("Weight");
        Label occupationLabel = new Label("Occupation");
        
           TextField tfNom = new TextField();
        TextField tfDescription = new TextField();
        TextField tfAge = new TextField();
        TextField tfWeight = new TextField();
        TextField tfHeight = new TextField();
        TextField tfOccupation = new TextField();
        
     
        Button btnValider = new Button("Add Coach");
      // Create the containers for each set of components
Container nameContainer = BoxLayout.encloseY(nomLabel, tfNom);
Container descriptionContainer = BoxLayout.encloseY(descriptionLabel, tfDescription);
Container ageContainer = BoxLayout.encloseY(ageLabel, tfAge);
Container heightContainer = BoxLayout.encloseY(heightLabel, tfHeight);
Container weightContainer = BoxLayout.encloseY(weightLabel, tfWeight);
Container occupationContainer = BoxLayout.encloseY(occupationLabel, tfOccupation);

// Add the containers to the form
add(nameContainer);
add(descriptionContainer);
add(ageContainer);
add(heightContainer);
add(weightContainer);
add(occupationContainer);

// Add the button to the form
add(btnValider);

// Add the back button to the toolbar
getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfNom.getText().length()==0) || tfDescription.getText().equals("") || tfAge.getText().equals("") || tfHeight.getText().equals("")  || tfWeight.getText().equals("") || tfOccupation.getText().equals("") ) 
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {

                        
                        Coach t = new Coach(tfAge.getAsInt(BASELINE),
                                tfNom.getText().toString(),
                                tfDescription.getText().toString(),
                                tfHeight.getText().toString(),
                                tfWeight.getText().toString(),
                                tfOccupation.getText().toString()
                                

                                
                        );
                 
                        if(ServiceCoach.getInstance().ajoutCoach(t))
                        {
                        InfiniteProgress ip = new InfiniteProgress();; //Loading  after insert data
                                            final Dialog iDialog = ip.showInfiniteBlocking();

                    refreshTheme();//Actualisation

                           Dialog.show("Success","Connection accepted",new Command("OK"));

                            new ListCoachsForm(previous).show();
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    
}
