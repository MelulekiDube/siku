/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dube_
 */
public class Driver {
    static SikuTrayIcon trayIcon ;
    static GUi g;
    
    public static void showInterface(){
	if(g==null)
	    g = new GUi();
	g.setVisible(true);
    }
	    
    public static void main(String args[]){
	trayIcon = new SikuTrayIcon();
    }
}
