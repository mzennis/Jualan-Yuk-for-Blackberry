package JualanYuk.ui;



import JualanYuk.ui.component.FixedHeightVerticalFieldManager;
import net.rim.device.api.math.Fixed32;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.system.EncodedImage;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.decor.BackgroundFactory;

public class MainBackground extends MainScreen {
	
	private FixedHeightVerticalFieldManager _mainField 	= new FixedHeightVerticalFieldManager( Display.getHeight() ); //Field.USE_ALL_WIDTH | Field.USE_ALL_HEIGHT
	private HorizontalFieldManager _headerField 		= new HorizontalFieldManager( Field.USE_ALL_WIDTH );

	
	public MainBackground(long l, boolean isMain) {
		super( l );
		
		_mainField.setBackground( BackgroundFactory.createSolidBackground( 0xFFFFFF ) );
		_headerField.setBackground( BackgroundFactory.createBitmapBackground( Bitmap.getBitmapResource("img/title.png")));
		_mainField.add( _headerField );
		super.add( _mainField );

		_headerField.setPadding(15,10,75,10);
		
	}

	
	public void add ( Field field ) {
		
		_mainField.add( field );
		
	}
	
	public void delete ( Field field ){
		
		_mainField.delete( field );
		
	}
	
	public void deleteAll() {
		
		_mainField.deleteAll();
		
	}
	
	public void progressField() {
		
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