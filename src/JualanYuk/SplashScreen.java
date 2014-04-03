package JualanYuk;

import java.util.Timer;
import java.util.TimerTask;

import net.rim.device.api.math.Fixed32;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Characters;
import net.rim.device.api.system.Display;
import net.rim.device.api.system.EncodedImage;
import net.rim.device.api.system.KeyListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.container.AbsoluteFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.decor.BackgroundFactory;

/**
 * 
 * @author Meyta Jennis Taliti 
 * email : meytajennist@gmail.com
 * 
 */

public class SplashScreen extends MainScreen {
	private MainScreen next;
	private UiApplication application;
	private Timer timer = new Timer();
	private AbsoluteFieldManager _abs 	= new AbsoluteFieldManager();
	private EncodedImage _bg 			= resize( EncodedImage.getEncodedImageResource( "img/bg.png" ), Display.getWidth(), Display.getHeight(), true);
	private Bitmap _bitmapCenter 		= Bitmap.getBitmapResource( "img/logo.png" );
	private BitmapField _bfCenter 		= new BitmapField( _bitmapCenter );
	
	public SplashScreen( UiApplication ui, MainScreen next ) {
		
		super( NO_VERTICAL_SCROLL );
		this.application = ui;
		this.next = next;
		_abs.setBackground( BackgroundFactory.createBitmapBackground( _bg.getBitmap() ));
		_abs.add(_bfCenter, ( Display.getWidth() / 2 ) - ( _bitmapCenter.getWidth() / 2 ),( Display.getHeight() / 2 ) - ( _bitmapCenter.getHeight() / 2 ) );
		this.add( _abs );
		SplashScreenListener listener = new SplashScreenListener( this );
		this.addKeyListener( listener );
		timer.schedule( new CountDown(), 5000 );
		application.pushScreen( this );

	}
	
	public void dismiss() {
		
		timer.cancel();
	    application.popScreen(this);
	    application.pushScreen(next);
	    
	}
	
	private class CountDown extends TimerTask {
		
		public void run() {
			DismissThread dThread = new DismissThread();
			application.invokeLater(dThread);
		}
	}
	   
	private class DismissThread implements Runnable {
	
		public void run() {
			dismiss();
		}
	}

	protected boolean navigationClick(int status, int time) {
		
		dismiss();
		return true;
		
	}

	protected boolean navigationUnclick(int status, int time) {
		
		return false;
		
	}

	protected boolean navigationMovement(int dx, int dy, int status, int time) {
		
		return false;
		
	}
	
	public static class SplashScreenListener implements KeyListener {
		private SplashScreen screen;
		
		public boolean keyChar(char key, int status, int time) {
			//intercept the ESC and MENU key - exit the splash screen
	        boolean retval = false;
	        switch (key) {
	        	case Characters.CONTROL_MENU:
	            case Characters.ESCAPE:
	            screen.dismiss();
	            retval = true;
	            break;
	        }
	        return retval;
		}
		
		public boolean keyDown(int keycode, int time) {
			return false;
		}
	      
		public boolean keyRepeat(int keycode, int time) {
			return false;
		}
	      
		public boolean keyStatus(int keycode, int time) {
			return false;
		}
	    
		public boolean keyUp(int keycode, int time) {
			return false;
		}
		
		public SplashScreenListener(SplashScreen splash) {
			screen = splash;
		}
		
	}
	
	public static EncodedImage resize(EncodedImage eImage, int toWidth, 
            int toHeight, boolean keepAspectRatio) {

        int scaleX = Fixed32.div(
            Fixed32.toFP(eImage.getWidth()),
            Fixed32.toFP(toWidth)
        );

        int scaleY = Fixed32.div(
            Fixed32.toFP(eImage.getHeight()), 
            Fixed32.toFP(toHeight)
        );

        if (keepAspectRatio) {
            int scale = (scaleX > scaleY) ? scaleX : scaleY;
            return eImage.scaleImage32(scale, scale);
        } else {
            return eImage.scaleImage32(scaleX, scaleY);
        }
    }
}
