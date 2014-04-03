package JualanYuk.ui.component;


import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.FontManager;

public class FontFactory
{
  private static int fontSize(int fontsize)
  {
    int size = fontsize;
    int curve = 4;
    int perl = 5;

    switch (Display.getWidth()) {
    case 320:
      size = fontsize - curve; break;
    case 240:
      size = fontsize - perl;
    }

    return size;
  }

  public static Font reloadFont(String fontname, int style, int size)
  {
    try
    {
      FontFamily theFam = FontFamily.forName(fontname);
      return size > 14 ? theFam.getFont(style, fontSize(size)) : 
        theFam.getFont(style, size, 2);
    }
    catch (ClassNotFoundException ex)
    {
      ex.printStackTrace();
    }
    return null;
  }
  
  public static Font reloadFontRegular(int style, int size)
  {
	  if (FontManager.getInstance().load("SourceSansPro-Regular.ttf", "SanPro", FontManager.APPLICATION_FONT) == FontManager.SUCCESS) 
      {
		  System.out.println("Send the call out");
		  try
		    {
		      FontFamily theFam = FontFamily.forName("SanPro");
		      return size > 14 ? theFam.getFont(style, fontSize(size)) : 
		        theFam.getFont(style, size, 2);
		    }
		    catch (ClassNotFoundException ex)
		    {
		      ex.printStackTrace();
		    }
      }else{
    	  System.out.println("Ruin of palace within my dream");
    	  try
    	    {
    	      FontFamily theFam = FontFamily.forName("BBAlpha Sans");
    	      return size > 14 ? theFam.getFont(style, fontSize(size)) : 
    	        theFam.getFont(style, size, 2);
    	    }
    	    catch (ClassNotFoundException ex)
    	    {
    	      ex.printStackTrace();
    	    }
      }
	  return null;
  }
  
  public static Font reloadFontLight(int style, int size)
  {
	  if (FontManager.getInstance().load("SourceSansPro-Light.ttf", "SanProLight", FontManager.APPLICATION_FONT) == FontManager.SUCCESS) 
      {
		  try
		    {
		      FontFamily theFam = FontFamily.forName("SanProLight");
		      return size > 14 ? theFam.getFont(style, fontSize(size)) : theFam.getFont(style, size, 2);
		    }
		    catch (ClassNotFoundException ex)
		    {
		      ex.printStackTrace();
		    }
      }else{
    	  try
    	    {
    	      FontFamily theFam = FontFamily.forName("BBAlpha Sans");
    	      return size > 14 ? theFam.getFont(style, fontSize(size)) : theFam.getFont(style, size, 2);
    	    }
    	    catch (ClassNotFoundException ex)
    	    {
    	      ex.printStackTrace();
    	    }
      }
	  return null;
  }
}
