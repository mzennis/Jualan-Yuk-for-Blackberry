package JualanYuk;

import net.rim.device.api.ui.UiApplication;

public class JualanYuk extends UiApplication
{
    /**
     * Entry point for application
     * @param args Command line arguments (not used)
     */ 
    public static void main(String[] args)
    {
        // Create a new instance of the application and make the currently
        // running thread the application's event dispatch thread.
    	JualanYuk theApp = new JualanYuk();       
        theApp.enterEventDispatcher();
    }
    

    /**
     * Creates a new MyApp object
     */
    public JualanYuk()
    {        
        // Push a screen onto the UI stack for rendering.
    	pushScreen(new HomeScreen());
    }    
}