package com.meganexus.SIT_AutomationTesting.utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class VPNConnectDisconnect {
	
	public static void openCiscoVPN_Connect(){
		
		try {
			File file = new File(System.getProperty("user.dir") + "/src/test/resources" + "/VPNConnect.exe");
    		Desktop desktop = Desktop.getDesktop();
    		if(file.exists()) desktop.open(file);
    		Thread.sleep(10000);
		    
		   } catch (IOException e1) {
		      e1.printStackTrace();
		   } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
    public static void openCiscoVPN_Disconnect(){
    	try {
    		
    		File file = new File(System.getProperty("user.dir") + "/src/test/resources" + "/VPNDisconnect.exe");
    		//System.out.println(file);
    		Desktop desktop = Desktop.getDesktop();
    		if(file.exists()) desktop.open(file);
    		Thread.sleep(10000);
		      
		   } catch (IOException e1) {
		      e1.printStackTrace();
		   } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}