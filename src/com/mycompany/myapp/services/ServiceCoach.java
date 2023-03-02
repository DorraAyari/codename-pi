/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;

import com.mycompany.myapp.entities.Coach;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Lenovo
 */
public class ServiceCoach {
    
    //singleton 
        public ArrayList<Coach> coachs;

    public static ServiceCoach instance = null ;
    
    public static boolean resultOk = true;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceCoach() {
        req = new ConnectionRequest();
    }

    public static ServiceCoach getInstance() {
        if (instance == null) {
            instance = new ServiceCoach();
        }
        return instance;
    }

        
    
    //ajout 
    public boolean ajoutCoach(Coach t) {
      
        String url =Statics.BASE_URL+"/ajoutercoach?nom="+t.getNom()+"&description="+t.getDescription()+"&age="+t.getAge()+"&weight="+t.getWeight()+"&height="+t.getHeight()+"&occupation="+t.getOccupation(); 

        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
        
    }

    public ArrayList<Coach> parseCoachs(String jsonText) {
        try {
            coachs = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Coach t = new Coach();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int) id);
                if (obj.get("nom") == null) {
                    t.setNom("null");
                } else {
                    t.setNom(obj.get("nom").toString());
                }
                
                 if (obj.get("description") == null) {
                    t.setDescription("null");
                } else {
                    t.setDescription(obj.get("description").toString());
                }
                 if (obj.get("height") == null) {
                    t.setHeight("null");
                } else {
                    t.setHeight(obj.get("height").toString());
                }
                  if (obj.get("weight") == null) {
                    t.setWeight("null");
                } else {
                    t.setWeight(obj.get("weight").toString());
                }
                   if (obj.get("occupation") == null) {
                    t.setOccupation("null");
                } else {
                    t.setOccupation(obj.get("occupation").toString());
                }
 if (obj.get("age") == null) {
                t.setAge(0);
            } else {
                float age = Float.parseFloat(obj.get("age").toString());
                t.setAge((int) age);
            }
                coachs.add(t);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return coachs;
    }
   public ArrayList<Coach> getAllCoachs() {
        String url =Statics.BASE_URL+"/coach";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                coachs = parseCoachs(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return coachs;
    }
    
}