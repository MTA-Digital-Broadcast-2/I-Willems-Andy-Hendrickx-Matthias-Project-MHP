package hellotvxlet;


import java.awt.event.ActionEvent;
import java.util.Random;
import javax.tv.xlet.*;
import org.davic.resources.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import org.havi.ui.event.*;



public class HelloTVXlet implements Xlet, HBackgroundImageListener, 
        ResourceClient, HActionListener
       {
     Question[] questionArray = new Question[2];
    
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
    private HTextButton btnTrue;
    private HTextButton btnFalse;
    private HTextButton revange;
    private HStaticText vraaglabel;
    private HStaticText redlabel;
    private HStaticText bluelabel;
    int scoreblauw = 0;
    int scorerood = 0;
    String ButtonCol1;
    String ButtonCol2;
    String ButtonCol3;
    String ButtonCol4;
    String ButtonCol5;
    String ButtonCol6;
    String ButtonCol7;
    String ButtonCol8;
    String ButtonCol9;
    boolean CanWin = false;
    boolean EnemyCanWin = false;
    int randomInt; 
    boolean Speler = true;
    int buttonKlik;
    //private HStaticIcon kruis = new HStaticIcon("kruis.png");
    //private HStaticIcon Cirkel = new HStaticIcon("cirkel.png");
    
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
      btnTrue = new HTextButton("WAAR");
      btnFalse = new HTextButton("NIET WAAR");
      revange = new HTextButton("REVANGE");
      
      vraaglabel = new HStaticText ("");
      redlabel = new HStaticText ("=> PLAYER 1" + "\n" + "€ " + scorerood );
      bluelabel = new HStaticText ("PLAYER 2" +  "\n" + "€ " + scoreblauw);
      
     //Propterties Buttons and Labels 
      vraaglabel.setLocation(40, 460);
      vraaglabel.setSize(460, 85);
      vraaglabel.setBackground(new DVBColor(50,50,50,200));
      vraaglabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      redlabel.setLocation(530, 30);
      redlabel.setSize(150, 195);
      redlabel.setForeground(new DVBColor(255,255,255,255));
      redlabel.setBackground(new DVBColor(255,0,0,230));
      redlabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
      redlabel.setBordersEnabled(Speler);
      
      
      bluelabel.setLocation(530, 235);
      bluelabel.setSize(150, 195);
      bluelabel.setForeground(new DVBColor(0,0,0,255));
      bluelabel.setBackground(new DVBColor(0,0,255,230));
      bluelabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
      bluelabel.setBordersEnabled(!Speler);
      
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
      
      btnTrue.setLocation(530, 450);
      btnTrue.setSize(120, 50);
      btnTrue.setBackground(new DVBColor(0,0,0,220));
      btnTrue.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btnTrue.setVisible(false);
      
      btnFalse.setLocation(530, 510);
      btnFalse.setSize(120, 50);
      btnFalse.setBackground(new DVBColor(0,0,0,220));
      btnFalse.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btnFalse.setVisible(false);
      
      
      revange.setLocation(530, 460);
      revange.setSize(160, 80);
      revange.setBackground(new DVBColor(255,0,255,240));
      revange.setBackgroundMode(HVisible.BACKGROUND_FILL);
      revange.setVisible(false);
      

      scene.add(btn1);
      scene.add(btn2);
      scene.add(btn3);
      scene.add(btn4);
      scene.add(btn5);
      scene.add(btn6);
      scene.add(btn7);
      scene.add(btn8);
      scene.add(btn9);
      scene.add(btnTrue);
      scene.add(btnFalse);
      scene.add(revange);
      scene.add(vraaglabel);
      scene.add(redlabel);
      scene.add(bluelabel);
      
      btn1.setActionCommand("knop1");
      btn2.setActionCommand("knop2");
      btn3.setActionCommand("knop3");
      btn4.setActionCommand("knop4");
      btn5.setActionCommand("knop5");
      btn6.setActionCommand("knop6");
      btn7.setActionCommand("knop7");
      btn8.setActionCommand("knop8");
      btn9.setActionCommand("knop9");
      btnTrue.setActionCommand("True");
      btnFalse.setActionCommand("False");
      revange.setActionCommand("Revange");
      
      btn1.setFocusTraversal(null, btn4, null, btn2);
      btn2.setFocusTraversal(null, btn5, btn1, btn3);
      btn3.setFocusTraversal(null, btn6, btn2, null);
      btn4.setFocusTraversal(btn1, btn7, null, btn5);
      btn5.setFocusTraversal(btn2, btn8, btn4, btn6);
      btn6.setFocusTraversal(btn3, btn9, btn5, null);
      btn7.setFocusTraversal(btn4, null, null, btn8);
      btn8.setFocusTraversal(btn5, null, btn7, btn9);
      btn9.setFocusTraversal(btn6, null, btn8, null);
      revange.setFocusTraversal(null, null, null, null);
      
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
      btnTrue.addHActionListener(this);
      btnFalse.addHActionListener(this);
      revange.addHActionListener(this);
      
      questionArray[0] = new Question("De voornaam van mr. Soontjes is Koen",
            "True", false);
      questionArray[1] = new Question("De voornaam van mr. Soontjes is Jan",
            "False", false);
 
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

   
    public void actionPerformed(ActionEvent e) {
         if(e.getActionCommand() == "knop1"){
             
            vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
            
            buttonKlik = 1;
            checkWin();
            btn1.setBackground(new DVBColor(100,100,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
        }
        
        if(e.getActionCommand() == "knop2"){
            
            vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
            
            buttonKlik = 2;
            checkWin();
            btn2.setBackground(new DVBColor(100,100,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
        }
        
        if(e.getActionCommand() == "knop3"){
            
            vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
            
            buttonKlik = 3;
            checkWin();
            btn3.setBackground(new DVBColor(100,100,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
        }
        
        if(e.getActionCommand() == "knop4"){
            
            vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
            
            buttonKlik = 4;
            checkWin();
            btn4.setBackground(new DVBColor(100,100,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
            
        }
         
         if(e.getActionCommand() == "knop5"){
             
             vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
             
             buttonKlik = 5;
             checkWin();
            btn5.setBackground(new DVBColor(100,100,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
        }
        
        if(e.getActionCommand() == "knop6"){
            
            vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
            
            buttonKlik = 6;
            checkWin();
            btn6.setBackground(new DVBColor(100,100,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
        }
        
        if(e.getActionCommand() == "knop7"){
            
            vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
            
            buttonKlik = 7;
            checkWin();
            btn7.setBackground(new DVBColor(100,100,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
        }
        
        if(e.getActionCommand() == "knop8"){
            
            vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
            
            buttonKlik = 8;
            checkWin();
            btn8.setBackground(new DVBColor(100,100,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
        }
         
         if(e.getActionCommand() == "knop9"){
             
             vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
             
            buttonKlik = 9;
            checkWin();
            btn9.setBackground(new DVBColor(100,100,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
        }
         
         if(e.getActionCommand() == "Revange")
         {
         
         }
         
         if(e.getActionCommand() == "True"){
        
             if(e.getActionCommand() == questionArray[randomInt].answer)
             {
                 if(!CanWin)
                 {
                vraaglabel.setTextContent("JE ANTWOORD IS JUIST", HState.NORMAL_STATE);
                if(Speler == true)
                {
                buttonKleur("Rood");
                scorerood += 50;
                
                }
                else
                {
                buttonKleur("Blauw");
                scoreblauw += 50;
                
                }
                btnTrue.setVisible(false);
                btnFalse.setVisible(false);
                btn5.requestFocus();
                spelerSwitch();
                 } 
                 else
                 {
                     if(Speler == true)
                    {
                    buttonKleur("Rood");
                    scorerood += 100;
                    redlabel.setTextContent("=> PLAYER 1" + "\n" + "€ " + scorerood , HState.NORMAL_STATE);
                    vraaglabel.setTextContent("SPELER 1 IS GEWONNEN", HState.NORMAL_STATE);
                    btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    revange.setVisible(true);
                    revange.requestFocus();
                    }
                    else
                    {
                    buttonKleur("Blauw");
                    scoreblauw += 100;
                    bluelabel.setTextContent("=> PLAYER 2" + "\n" + "€ " + scoreblauw , HState.NORMAL_STATE);
                    vraaglabel.setTextContent("SPELER 2 IS GEWONNEN", HState.NORMAL_STATE);
                    btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    revange.setVisible(true);
                    revange.requestFocus();
                    }   
                    
                 }
             }
             else  
             {  
                 if(!EnemyCanWin)
                 {
                vraaglabel.setTextContent("JE ANTWOORD IS FOUT", HState.NORMAL_STATE);
                
                if(Speler == true)
                {
                buttonKleur("Blauw");
                scoreblauw += 50;
                
                }
                else
                {
                buttonKleur("Rood");
                scorerood += 50;
                
                }
                btnTrue.setVisible(false);
                btnFalse.setVisible(false);
                btn5.requestFocus();
                spelerSwitch();
                 }
                 else
                 {
                     if(Speler == true)
                    {
                    buttonKleur("Blauw");
                    scoreblauw += 100;
                    bluelabel.setTextContent("PLAYER 2" + "\n" + "€ " + scoreblauw , HState.NORMAL_STATE);
                    vraaglabel.setTextContent("SPELER 2 IS GEWONNEN", HState.NORMAL_STATE);
                    btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    revange.setVisible(true);
                    revange.requestFocus();
                    }
                    else
                    {
                    buttonKleur("Rood");
                    scorerood += 100;
                    redlabel.setTextContent("PLAYER 1" + "\n" + "€ " + scorerood , HState.NORMAL_STATE);
                    vraaglabel.setTextContent("SPELER 1 IS GEWONNEN", HState.NORMAL_STATE);
                    btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    revange.setVisible(true);
                    revange.requestFocus();
                    }
                    
                 
                 }
             }
             
            
         }
             
         if(e.getActionCommand() == "False"){
              
             if(e.getActionCommand() == questionArray[randomInt].answer)
             {
                 if(!CanWin)
                 {
                vraaglabel.setTextContent("JE ANTWOORD IS JUIST", HState.NORMAL_STATE);
                
                if(Speler == true)
                {
                buttonKleur("Rood");
                scorerood += 50;
                
                }
                else
                {
                buttonKleur("Blauw");
                scoreblauw += 50;
                
                }
                btnTrue.setVisible(false);
                btnFalse.setVisible(false);
                btn5.requestFocus();
                spelerSwitch();
                 }
                 else
                 {
                     if(Speler == true)
                    {
                    buttonKleur("Rood");
                    scorerood += 100;
                    redlabel.setTextContent("=> PLAYER 1" + "\n" + "€ " + scorerood , HState.NORMAL_STATE);
                    vraaglabel.setTextContent("SPELER 1 IS GEWONNEN", HState.NORMAL_STATE);
                    btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    revange.setVisible(true);
                    revange.requestFocus();
                    }
                    else
                    {
                     buttonKleur("Blauw");
                     scoreblauw += 100;
                     bluelabel.setTextContent("=> PLAYER 2" + "\n" + "€ " + scoreblauw , HState.NORMAL_STATE);
                     vraaglabel.setTextContent("SPELER 2 IS GEWONNEN", HState.NORMAL_STATE);
                     btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    revange.setVisible(true);
                    revange.requestFocus();
                    }
                    
                 }
             }
             else
             {
                 if(!EnemyCanWin)
                 {
                vraaglabel.setTextContent("JE ANTWOORD IS FOUT", HState.NORMAL_STATE);
                
                if(Speler == true)
                {
                buttonKleur("Blauw");
                scoreblauw += 50;
                
                }
                else
                {
                buttonKleur("Rood");
                scorerood += 50;
                
                }
                btnTrue.setVisible(false);
                btnFalse.setVisible(false);
                btn5.requestFocus();
                spelerSwitch();
                 }
                 else
                 {
                     if(Speler == true)
                    {
                    buttonKleur("Blauw");
                    scoreblauw += 100;
                    bluelabel.setTextContent("PLAYER 2" + "\n" + "€ " + scoreblauw , HState.NORMAL_STATE);
                    vraaglabel.setTextContent("SPELER 2 IS GEWONNEN", HState.NORMAL_STATE);
                    btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    revange.setVisible(true);
                    revange.requestFocus();
                    }
                    else
                    {
                    buttonKleur("Rood");
                    scorerood += 100;
                    redlabel.setTextContent("PLAYER 1" + "\n" + "€ " + scorerood , HState.NORMAL_STATE);
                    vraaglabel.setTextContent("SPELER 1 IS GEWONNEN", HState.NORMAL_STATE);
                    btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    revange.setVisible(true);
                    revange.requestFocus();
                    }
                    
                 }
             }
             
         
         }
    }
    
    public void checkWin()
    {
        if(Speler)
        {
            switch(buttonKlik)
            {
                case 1: if(ButtonCol2 == "Rood" && ButtonCol3 == "Rood" || ButtonCol5 == "Rood" && ButtonCol9 == "Rood" || ButtonCol4 == "Rood" && ButtonCol7 == "Rood")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol2 == "Blauw" && ButtonCol3 == "Blauw" || ButtonCol5 == "Blauw" && ButtonCol9 == "Blauw" || ButtonCol4 == "Blauw" && ButtonCol7 == "Blauw")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 2: if(ButtonCol1 == "Rood" && ButtonCol3 == "Rood" || ButtonCol5 == "Rood" && ButtonCol8 == "Rood")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Blauw" && ButtonCol3 == "Blauw" || ButtonCol5 == "Blauw" && ButtonCol8 == "Blauw")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 3: if(ButtonCol1 == "Rood" && ButtonCol2 == "Rood" || ButtonCol6 == "Rood" && ButtonCol9 == "Rood" || ButtonCol5 == "Rood" && ButtonCol7 == "Rood")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Blauw" && ButtonCol2 == "Blauw" || ButtonCol6 == "Blauw" && ButtonCol9 == "Blauw" || ButtonCol5 == "Blauw" && ButtonCol7 == "Blauw")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 4: if(ButtonCol1 == "Rood" && ButtonCol7 == "Rood" || ButtonCol5 == "Rood" && ButtonCol6 == "Rood" )
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Blauw" && ButtonCol7 == "Blauw" || ButtonCol5 == "Blauw" && ButtonCol6 == "Blauw" )
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 5: if(ButtonCol1 == "Rood" && ButtonCol9 == "Rood" || ButtonCol2 == "Rood" && ButtonCol8 == "Rood" || ButtonCol3 == "Rood" && ButtonCol7 == "Rood" || ButtonCol4 == "Rood" && ButtonCol6 == "Rood")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Blauw" && ButtonCol9 == "Blauw" || ButtonCol2 == "Blauw" && ButtonCol8 == "Blauw" || ButtonCol3 == "Blauw" && ButtonCol7 == "Blauw" || ButtonCol4 == "Blauw" && ButtonCol6 == "Blauw")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 6: if(ButtonCol3 == "Rood" && ButtonCol9 == "Rood" || ButtonCol4 == "Rood" && ButtonCol5 == "Rood")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol3 == "Blauw" && ButtonCol9 == "Blauw" || ButtonCol4 == "Blauw" && ButtonCol5 == "Blauw")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 7: if(ButtonCol1 == "Rood" && ButtonCol4 == "Rood" || ButtonCol8 == "Rood" && ButtonCol9 == "Rood")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Blauw" && ButtonCol4 == "Blauw" || ButtonCol8 == "Blauw" && ButtonCol9 == "Blauw")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 8: if(ButtonCol2 == "Rood" && ButtonCol5 == "Rood" || ButtonCol7 == "Rood" && ButtonCol9 == "Rood")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol2 == "Blauw" && ButtonCol5 == "Blauw" || ButtonCol7 == "Blauw" && ButtonCol9 == "Blauw")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 9: if(ButtonCol1 == "Rood" && ButtonCol5 == "Rood" || ButtonCol3 == "Rood" && ButtonCol6 == "Rood" || ButtonCol7 == "Rood" && ButtonCol8 == "Rood")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Blauw" && ButtonCol5 == "Blauw" || ButtonCol3 == "Blauw" && ButtonCol6 == "Blauw" || ButtonCol7 == "Blauw" && ButtonCol8 == "Blauw")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
            }
        }
        else
        {
            switch(buttonKlik)
            {
                case 1: if(ButtonCol2 == "Blauw" && ButtonCol3 == "Blauw" || ButtonCol5 == "Blauw" && ButtonCol9 == "Blauw" || ButtonCol4 == "Blauw" && ButtonCol7 == "Blauw")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol2 == "Rood" && ButtonCol3 == "Rood" || ButtonCol5 == "Rood" && ButtonCol9 == "Rood" || ButtonCol4 == "Rood" && ButtonCol7 == "Rood")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 2: if(ButtonCol1 == "Blauw" && ButtonCol3 == "Blauw" || ButtonCol5 == "Blauw" && ButtonCol8 == "Blauw")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Rood" && ButtonCol3 == "Rood" || ButtonCol5 == "Rood" && ButtonCol8 == "Rood")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 3: if(ButtonCol1 == "Blauw" && ButtonCol2 == "Blauw" || ButtonCol6 == "Blauw" && ButtonCol9 == "Blauw" || ButtonCol5 == "Blauw" && ButtonCol7 == "Blauw")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Rood" && ButtonCol2 == "Rood" || ButtonCol6 == "Rood" && ButtonCol9 == "Rood" || ButtonCol5 == "Rood" && ButtonCol7 == "Rood")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 4: if(ButtonCol1 == "Blauw" && ButtonCol7 == "Blauw" || ButtonCol5 == "Blauw" && ButtonCol6 == "Blauw" )
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Rood" && ButtonCol7 == "Rood" || ButtonCol5 == "Rood" && ButtonCol6 == "Rood" )
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 5: if(ButtonCol1 == "Blauw" && ButtonCol9 == "Blauw" || ButtonCol2 == "Blauw" && ButtonCol8 == "Blauw" || ButtonCol3 == "Blauw" && ButtonCol7 == "Blauw" || ButtonCol4 == "Blauw" && ButtonCol6 == "Blauw")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Rood" && ButtonCol9 == "Rood" || ButtonCol2 == "Rood" && ButtonCol8 == "Rood" || ButtonCol3 == "Rood" && ButtonCol7 == "Rood" || ButtonCol4 == "Rood" && ButtonCol6 == "Rood")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 6: if(ButtonCol3 == "Blauw" && ButtonCol9 == "Blauw" || ButtonCol4 == "Blauw" && ButtonCol5 == "Blauw")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol3 == "Rood" && ButtonCol9 == "Rood" || ButtonCol4 == "Rood" && ButtonCol5 == "Rood")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 7: if(ButtonCol1 == "Blauw" && ButtonCol4 == "Blauw" || ButtonCol8 == "Blauw" && ButtonCol9 == "Blauw")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Rood" && ButtonCol4 == "Rood" || ButtonCol8 == "Rood" && ButtonCol9 == "Rood")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 8: if(ButtonCol2 == "Blauw" && ButtonCol5 == "Blauw" || ButtonCol7 == "Blauw" && ButtonCol9 == "Blauw")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol2 == "Rood" && ButtonCol5 == "Rood" || ButtonCol7 == "Rood" && ButtonCol9 == "Rood")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 9: if(ButtonCol1 == "Blauw" && ButtonCol5 == "Blauw" || ButtonCol3 == "Blauw" && ButtonCol6 == "Blauw" || ButtonCol7 == "Blauw" && ButtonCol8 == "Blauw")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Rood" && ButtonCol5 == "Rood" || ButtonCol3 == "Rood" && ButtonCol6 == "Rood" || ButtonCol7 == "Rood" && ButtonCol8 == "Rood")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
            }
        
        }
    }
    
    public void buttonKleur(String kleur)
    {
        if(kleur == "Rood")
        {
           switch(buttonKlik)
            {
                case 1: btn1.setBackground(new DVBColor(255,0,0,230));
                        ButtonCol1 = "Rood";
                        btn1.requestFocus();
                        
                break;
                case 2: btn2.setBackground(new DVBColor(255,0,0,230));
                        ButtonCol2 = "Rood";
                        btn2.requestFocus();
                break;
                case 3: btn3.setBackground(new DVBColor(255,0,0,230));
                        ButtonCol3 = "Rood";
                        btn3.requestFocus();
                break;
                case 4: btn4.setBackground(new DVBColor(255,0,0,230));
                        ButtonCol4 = "Rood";
                        btn4.requestFocus();
                break;
                case 5: btn5.setBackground(new DVBColor(255,0,0,230));
                        ButtonCol5 = "Rood";
                        btn5.requestFocus();
                break;
                case 6: btn6.setBackground(new DVBColor(255,0,0,230));
                        ButtonCol6 = "Rood";
                        btn6.requestFocus();
                break;
                case 7: btn7.setBackground(new DVBColor(255,0,0,230));
                        ButtonCol7 = "Rood";
                        btn7.requestFocus();
                break;
                case 8: btn8.setBackground(new DVBColor(255,0,0,230));
                        ButtonCol8 = "Rood";
                        btn8.requestFocus();
                break;
                case 9: btn9.setBackground(new DVBColor(255,0,0,230));
                        ButtonCol9 = "Rood";
                        btn9.requestFocus();
                break;
            }  
        }
        else
        {
            switch(buttonKlik)
            {
                case 1: btn1.setBackground(new DVBColor(0,0,255,230));
                        ButtonCol1 = "Blauw";
                        btn1.requestFocus();
                        
                break;
                case 2: btn2.setBackground(new DVBColor(0,0,255,230));
                        ButtonCol2 = "Blauw";
                        btn2.requestFocus();
                break;
                case 3: btn3.setBackground(new DVBColor(0,0,255,230));
                        ButtonCol3 = "Blauw";
                        btn3.requestFocus();
                break;
                case 4: btn4.setBackground(new DVBColor(0,0,255,230));
                        ButtonCol4 = "Blauw";
                        btn4.requestFocus();
                break;
                case 5: btn5.setBackground(new DVBColor(0,0,255,230));
                        ButtonCol5 = "Blauw";
                        btn5.requestFocus();
                break;
                case 6: btn6.setBackground(new DVBColor(0,0,255,230));
                        ButtonCol6 = "Blauw";
                        btn6.requestFocus();
                break;
                case 7: btn7.setBackground(new DVBColor(0,0,255,230));
                        ButtonCol7 = "Blauw";
                        btn7.requestFocus();
                break;
                case 8: btn8.setBackground(new DVBColor(0,0,255,230));
                        ButtonCol8 = "Blauw";
                        btn8.requestFocus();
                break;
                case 9: btn9.setBackground(new DVBColor(0,0,255,230));
                        ButtonCol9 = "Blauw";
                        btn9.requestFocus();
                break;
            } 
        }
        
              
    }
    
    public void spelerSwitch()
    {
        Speler = !Speler;
        
        if(Speler == true)
        {
          redlabel.setTextContent("=> PLAYER 1" + "\n" + "€ " + scorerood, HState.NORMAL_STATE);
          bluelabel.setTextContent("PLAYER 2" +  "\n" + "€ " + scoreblauw, HState.NORMAL_STATE);

          redlabel.setForeground(new DVBColor(255,255,255,255));
          bluelabel.setForeground(new DVBColor(0,0,0,255));
        }
        else
        {
          redlabel.setTextContent("PLAYER 1" + "\n" + "€ " + scorerood, HState.NORMAL_STATE);
          bluelabel.setTextContent("=> PLAYER 2" +  "\n" + "€ " + scoreblauw, HState.NORMAL_STATE);
          bluelabel.setForeground(new DVBColor(255,255,255,255));
          redlabel.setForeground(new DVBColor(0,0,0,255));
        }
    }
    
    public String vraagAanroeper()
    {
        boolean loopMayBeSkipped = false;

        Random randomCreator = new Random();
        String vraagReturn = "";
        randomInt = randomCreator.nextInt(2);
        
        for (int i = 0; i < questionArray.length; i++) 
        {
            if (!loopMayBeSkipped)
            {
                if (!questionArray[randomInt].used) 
                {
                    vraagReturn = questionArray[randomInt].question;
                    loopMayBeSkipped = true;
                } 
                else 
                {
                    randomInt = randomCreator.nextInt(2);
                }  
            }
        }
        
        questionArray[randomInt].used = true;
        
        System.out.println(randomInt);
        return vraagReturn;
    }

    
       
    
}


        
    
       
    

