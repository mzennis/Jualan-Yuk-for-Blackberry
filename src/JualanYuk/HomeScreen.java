package JualanYuk;

import net.rim.device.api.ui.container.MainScreen;

import com.blackberry.facebook.ApplicationSettings;
import com.blackberry.facebook.Facebook;

public class HomeScreen extends MainScreen{
	
	public String NEXT_URL = "http://www.facebook.com/connect/login_success.html";
	public String APPLICATION_ID = "1425933210966144";
	public String APPLICATION_SECRET = "7efae842af881db42c0c989d5f4dad85";
	public String[] PERMISSIONS = Facebook.Permissions.USER_DATA_PERMISSIONS;

	public HomeScreen(){
	
		ApplicationSettings as = new ApplicationSettings(NEXT_URL, APPLICATION_ID, APPLICATION_SECRET, PERMISSIONS);
    	Facebook fb = Facebook.getInstance(as);
    	//fb.addPermission(Facebook.Permissions.OFFLINE_ACCESS);
    	//User user = fb.getCurrentUser();
    	//user.getLastName();
    	
    	setTitle("Sudah connect dengan facebook");

	/*
	 try {
         fb.getUser("me",new BasicAsyncCallback() {
         

         public void onComplete(com.blackberry.facebook.inf.Object[] objects, final java.lang.Object state) {
             user = (User) objects[0];
         }
        
         public void onException(final Exception e, final java.lang.Object state) {
             e.printStackTrace();
		             }
		 }, null);
		     } catch (FacebookException e) {
		         e.printStackTrace();
		     }
		 //user.publishStatus("Hey FB!!");
		  * */
	
	}
	
}
