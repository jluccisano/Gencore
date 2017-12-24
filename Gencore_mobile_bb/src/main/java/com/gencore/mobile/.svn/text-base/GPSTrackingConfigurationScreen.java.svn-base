package com.gencore.mobile;

import java.io.IOException;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiEngine;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.RadioButtonField;
import net.rim.device.api.ui.component.RadioButtonGroup;
import net.rim.device.api.ui.container.MainScreen;

final class GPSTrackingConfigurationScreen extends MainScreen {

    public static BBLogger logger = BBLogger.getInstance();
    
    BasicEditField enterRunName;
    ButtonField btnSubmit;
    RadioButtonGroup rbg;
    
    private String[] runTypes = {"Cycling","Running","Walking"};

    
    public GPSTrackingConfigurationScreen () {
        
        setTitle("Configuration"); 
         
        rbg = new RadioButtonGroup();
        add(new RadioButtonField("Cycling",rbg,true));
        add(new RadioButtonField("Running",rbg,true));
        add(new RadioButtonField("Walking",rbg,true));
  
        //enterRunName = new BasicEditField("Run name: ", "", 50, BasicEditField.FILTER_DEFAULT);
       
        btnSubmit = new ButtonField("Submit");
        btnSubmit.setChangeListener(new SubmitButtonListener());
       
        //add(enterRunName);
        add(btnSubmit);
        
        System.out.println("création de la view de configuration");
        logger.logInformationEvent("création de la view de configuration");
      
    }
    
    final class SubmitButtonListener implements FieldChangeListener {
        public void fieldChanged(Field field, int context) {
            
            UiEngine ui = Ui.getUiEngine();
            
            int runType =  rbg.getSelectedIndex();
           // String runName =  enterRunName.getText();
       
            ui.pushScreen(new GPSTrackingControlScreen(runType));
            System.out.println("submit: " + runType);
            logger.logInformationEvent("submit: " + runType);

        }
    }


}
