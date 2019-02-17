
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dube_
 */
public class SikuTrayIcon {

    private static final String ICON_FILE_NAME = "res/time.png";
    
    private final TrayIcon trayicon;
    private final SystemTray systemTray;

    
    public SikuTrayIcon() {
	trayicon = new TrayIcon(createImage(ICON_FILE_NAME), "Siku");
	systemTray = testAndReturnTray();
	init();
    }
    
    private void init(){
	trayicon.addMouseListener(init_mouseListener());
	trayicon.addActionListener(init_actionListener());
	try {
	    systemTray.add(trayicon);
	} catch (AWTException ex) {
	    Logger.getLogger(SikuTrayIcon.class.getName()).log(Level.SEVERE, null, ex);
	}
    }    
    
    private MouseListener init_mouseListener(){
	return new MouseListener() {
	    
	    @Override
	    public void mouseClicked(MouseEvent e) {
		//we will open the interface here.
		Driver.showInterface();
	    }

	    @Override
	    public void mousePressed(MouseEvent e) {
		Driver.showInterface();
	    }

	    @Override
	    public void mouseReleased(MouseEvent e) {
		
	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }
	};
    }
    
    private ActionListener init_actionListener(){
	return new ActionListenerImpl();
    }
    
    private SystemTray testAndReturnTray() {
	if(SystemTray.isSupported()){
	    return SystemTray.getSystemTray();
	}
	JOptionPane.showMessageDialog(null, "FInale not there", "Error obtaining System tray", JOptionPane.ERROR_MESSAGE);
	return null;
    }
    
    private Image createImage(String s) {
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	return toolkit.getImage(s);
    }

    private static class ActionListenerImpl implements ActionListener {

	public ActionListenerImpl() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
    }
}
