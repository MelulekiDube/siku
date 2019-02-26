
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

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

    private static SikuTrayIcon trayIcon;
    private static Interface g;
    static final ScheduledExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadScheduledExecutor();
    private static ScheduledFuture future;
    public static final String CHECK_MARK = "/Checkmark_25px.png";
    public static final String NO_CHANGE = "Delete_25px.png";
    
    
    public static void showInterface() {
	//get the key and only release it when u are done
	if (g == null) {
	    g = new Interface();
	}
	g.updateDoneButtonIcon(NO_CHANGE);
	g.setVisible(true);
    }

    public static void hideInterface() {
	g.setVisible(false);
    }

    /**
     *
     * @param time
     * @return
     */
    public static int toMillis(int time) {
	return (int) 0.25 * 60000;
    }
    
    public static void cancelFuter(){
	future.cancel(true);
    }

    public static void startDelay() {
	future = EXECUTOR_SERVICE.schedule(() -> {
	    g.setVisible(true);
	}, 30, TimeUnit.SECONDS);
    }

    public static void main(String args[]) {
	trayIcon = new SikuTrayIcon();
	showInterface();
    }

}
