package hellotvxlet;


import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.davic.resources.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import org.havi.ui.event.*;



public class HelloTVXlet implements Xlet, HBackgroundImageListener, 
        ResourceClient, HActionListener
       {

    private XletContext actueleXletContext;
    private HScene scene;
    private HTextButton btn1;
    private HTextButton btn2;
    private HTextButton btn3;
    private HTextButton btn4;
    private HTextButton btn5;
    private HTextButton btn6;
    private HTextButton btn7;
    private HTextButton btn8;
    private HTextButton btn9;
    private HStaticText vraaglabel;
    private HStaticText redlabel;
    private HStaticText bluelabel;
    
    private HBackgroundConfigTemplate bgTemplate; 
    private HScreen screen;
    private HBackgroundDevice bgDevice;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage agrondimg = new HBackgroundImage("wzlogo.jpg");

    public void notifyRelease (ResourceProxy proxy){}
    public void release (ResourceProxy proxy){}
    public boolean requestRelease (ResourceProxy proxy, Object requestData){
        return false;  }
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {

        this.actueleXletContext = context;
      HSceneTemplate sceneTemplate = new HSceneTemplate();
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, 
              new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED); 
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, 
              new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED); 
      
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);

      
    //Background Image
      screen = HScreen.getDefaultHScreen();
    //HBackground device opvragen
      bgDevice = screen.getDefaultHBackgroundDevice();
    //HBackground device reserveren
      if (bgDevice.reserveDevice((ResourceClient) this)){
        System.out.println("BackgroundImage device has been reserved");
      } else{
        System.out.println("Background Image device cannot be reserved");
      }
      //Template maken
      bgTemplate = new HBackgroundConfigTemplate();
      
      bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, 
              HBackgroundConfigTemplate.REQUIRED);
      
      bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
      
      try{
        bgDevice.setBackgroundConfiguration(bgConfiguration);
      } 
      catch(java.lang.Exception e){
        System.out.println(e.toString());
      }
        
      
   //Buttons and Labels   
      btn1 = new HTextButton("Sergio");
      btn2 = new HTextButton("Marleen");
      btn3 = new HTextButton("Joyce");
      btn4 = new HTextButton("Euvgenia");
      btn5 = new HTextButton("Koen");
      btn6 = new HTextButton("Dominique");
      btn7 = new HTextButton("Clara");
      btn8 = new HTextButton("Ian Thomas");
      btn9 = new HTextButton("Veronique");
      
      vraaglabel = new HStaticText ("");
      redlabel = new HStaticText ("PLAYER 1" + "\n" + "€ 0");
      bluelabel = new HStaticText ("PLAYER 2" +  "\n" + "€ 0");
     //Propterties Buttons and Labels 
      vraaglabel.setLocation(40, 460);
      vraaglabel.setSize(460, 85);
      vraaglabel.setBackground(new DVBColor(50,50,50,200));
      vraaglabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      redlabel.setLocation(530, 30);
      redlabel.setSize(150, 195);
      redlabel.setBackground(new DVBColor(255,0,0,230));
      redlabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      bluelabel.setLocation(530, 235);
      bluelabel.setSize(150, 195);
      bluelabel.setBackground(new DVBColor(0,0,255,230));
      bluelabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btn1.setLocation(40, 30);
      btn1.setSize(140, 120);
      btn1.setBackground(new DVBColor(0,0,0,220));
      btn1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      
      btn2.setLocation(200, 30);
      btn2.setSize(140, 120);
      btn2.setBackground(new DVBColor(0,0,0,220));
      btn2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btn3.setLocation(360, 30);
      btn3.setSize(140, 120);
      btn3.setBackground(new DVBColor(0,0,0,220));
      btn3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btn4.setLocation(40, 170);
      btn4.setSize(140, 120);
      btn4.setBackground(new DVBColor(0,0,0,220));
      btn4.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      
      btn5.setLocation(200, 170);
      btn5.setSize(140, 120);
      btn5.setBackground(new DVBColor(0,0,0,220));
      btn5.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btn6.setLocation(360, 170);
      btn6.setSize(140, 120);
      btn6.setBackground(new DVBColor(0,0,0,220));
      btn6.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btn7.setLocation(40, 310);
      btn7.setSize(140, 120);
      btn7.setBackground(new DVBColor(0,0,0,220));
      btn7.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      
      btn8.setLocation(200, 310);
      btn8.setSize(140, 120);
      btn8.setBackground(new DVBColor(0,0,0,220));
      btn8.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btn9.setLocation(360, 310);
      btn9.setSize(140, 120);
      btn9.setBackground(new DVBColor(0,0,0,220));
      btn9.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      scene.add(btn1);
      scene.add(btn2);
      scene.add(btn3);
      scene.add(btn4);
      scene.add(btn5);
      scene.add(btn6);
      scene.add(btn7);
      scene.add(btn8);
      scene.add(btn9);
      scene.add(vraaglabel);
      scene.add(redlabel);
      scene.add(bluelabel);
      
      btn1.setFocusTraversal(null, btn4, null, btn2);
      btn2.setFocusTraversal(null, btn5, btn1, btn3);
      btn3.setFocusTraversal(null, btn6, btn2, null);
      btn4.setFocusTraversal(btn1, btn7, null, btn5);
      btn5.setFocusTraversal(btn2, btn8, btn4, btn6);
      btn6.setFocusTraversal(btn3, btn9, btn5, null);
      btn7.setFocusTraversal(btn4, null, null, btn8);
      btn8.setFocusTraversal(btn5, null, btn7, btn9);
      btn9.setFocusTraversal(btn6, null, btn8, null);
      
      btn5.requestFocus();
      
      btn1.addHActionListener(this);
      btn2.addHActionListener(this);
      btn3.addHActionListener(this);
      btn4.addHActionListener(this);
      btn5.addHActionListener(this);
      btn6.addHActionListener(this);
      btn7.addHActionListener(this);
      btn8.addHActionListener(this);
      btn9.addHActionListener(this);
      
        
    }
    
     public void startXlet() {
       scene.validate();
       scene.setVisible(true);
       
       agrondimg.load(this);
        
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
      agrondimg.flush();
    }

    public void imageLoaded(HBackgroundImageEvent e) {
        try {
            bgConfiguration.displayImage(agrondimg);
        } catch (Exception s) {
            System.out.println(s.toString());
        } 
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        
    }

    public void actionPerformed(ActionEvent arg0) {
        
    }

    
       
    
}


        
    
       
    

