package hellotvxlet;


import javax.tv.xlet.*;
import org.davic.resources.*;
import org.dvb.event.*;
import org.havi.ui.*;
import org.havi.ui.event.*;



public class HelloTVXlet implements Xlet, ResourceClient, 
        HBackgroundImageListener, UserEventListener {

    private HScreen screen;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage pizza1=new HBackgroundImage("pizza1.m2v");
    private HBackgroundImage pizza2=new HBackgroundImage("pizza2.m2v");
    private HBackgroundImage pizza3=new HBackgroundImage("pizza3.m2v");
    private HBackgroundImage pizza4=new HBackgroundImage("pizza4.m2v");
    private int Teller = 1;
    
    public void notifyRelease (ResourceProxy proxy) {}
    public void release (ResourceProxy proxy) {}
    public boolean requestRelease (ResourceProxy proxy, Object requestData)
    {return false; }
    
    public void imageLoaded (HBackgroundImageEvent e)
    {
        switch(Teller)
            {
                case 1:
                    try{
                        bgConfiguration.displayImage (pizza1);
       
                        }
                catch (Exception s){
                        System.out.println(s.toString());
                        }
    
                    pizza1.load(this);
                    pizza1.flush();
                    System.out.println("case1");
                    break;
                    
                case 2:
                       try{
                        bgConfiguration.displayImage (pizza2);
       
                        }
                catch (Exception s){
                        System.out.println(s.toString());
                        }
                    pizza2.load(this);
                    pizza2.flush();
                    System.out.println("case2");
                    break;
                    
                case 3:
                       try{
                        bgConfiguration.displayImage (pizza3);
       
                        }
                catch (Exception s){
                        System.out.println(s.toString());
                        }
                    pizza3.load(this);
                    pizza3.flush();
                    System.out.println("case3");
                    break;
                    
                case 4:
                       try{
                        bgConfiguration.displayImage (pizza4);
       
                        }
                catch (Exception s){
                        System.out.println(s.toString());
                        }
                    pizza4.load(this);
                    pizza4.flush();
                    System.out.println("case4");
                    break;
                   
                    
            }
   
    
    }
    
    public void imageLoadFailed(HBackgroundImageEvent e)
    {
     System.out.println("Image kan niet geladen worden!");
    }
    
    public HelloTVXlet() {
        
    }

    public void callback()
    {
     
    }
    public void initXlet(XletContext context) {
//Hscreen object opvragen
        screen = HScreen.getDefaultHScreen();
        
//HBackgroundDevice opvragen
        bgDevice = screen.getDefaultHBackgroundDevice();
        
//HBackgroundDevice proberen te reserveren
        if(bgDevice.reserveDevice(this))
        {
         System.out.println("backgroundImage device has been reserved");
        }
        else
        {
         System.out.println("BackgroundImage device cannnot be reserved");
        }
        
//Template maken
        bgTemplate = new HBackgroundConfigTemplate();
        
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, 
                HBackgroundConfigTemplate.REQUIRED);
        
        bgConfiguration = (HStillImageBackgroundConfiguration) bgDevice.getBestConfiguration(bgTemplate);
      
        try{
            bgDevice.setBackgroundConfiguration(bgConfiguration);
        }
        catch(Exception e)
        {
         System.out.println(e.toString());
        }
        
        UserEventRepository uev=new UserEventRepository("Mijn verzameling");
        uev.addKey(HRcEvent.VK_LEFT);
        uev.addKey(HRcEvent.VK_RIGHT);
        
         EventManager.getInstance().addUserEventListener(this, uev);
    }

    
     public void startXlet() {
        System.out.println("startXlet");
        pizza1.load(this);
        pizza2.load(this);
        pizza3.load(this);
        pizza4.load(this);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
       pizza1.flush();
       pizza2.flush();
       pizza3.flush();
       pizza4.flush();
    }
    

    public void userEventReceived(UserEvent e) {
       if(e.getType() == HRcEvent.KEY_PRESSED)
        {
            switch (e.getCode())
            {
                case HRcEvent.VK_LEFT:
                    System.out.println("Links!!");
                    Teller--;
                    System.out.println(Teller);
                    break;
                    
                case HRcEvent.VK_RIGHT:
                    System.out.println("Rechts!!");
                    Teller++; 
                    System.out.println(Teller);
                    break;
    }
            if(Teller == 0)
            {
            Teller = 4;
            }
            else if (Teller == 5)
            {
            Teller = 1;
            }
            
           
       
       }
    }
}


        
    
       
    

