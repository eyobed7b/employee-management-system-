/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import emp.register;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;



public class loginn extends JFrame   {
    JFrame frame;
    JPanel panel,pic_panel;
    JButton logbtn, singbtn,aboutbtn;
    JLabel user_name_lbl,password_lbl,picture_lbl,title_lbl,lang_lbl;
      public static JPasswordField  password_Jpass;
      private static JComboBox<String> user_choice_cmb;
      public static JComboBox<String> lang_choice_cmb;
      private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
      
       
       public loginn(){
       setLayout(null);
       setSize(570, 350);
       setResizable(false);
        ImageIcon img1 = new ImageIcon(getClass().getClassLoader().getResource("image/login.png"));
        Image img22 = img1.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        setIconImage(img22);
        setLocation((screen.width - 500) / 2, ((screen.height - 350) / 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.white);
         panel = new JPanel();
         pic_panel = new JPanel();
         user_name_lbl= new JLabel("User Name ");
         password_lbl = new JLabel("Password");
         lang_lbl= new  JLabel("Set Language");
        
         
          picture_lbl = new JLabel();
         password_Jpass = new JPasswordField();
         title_lbl = new JLabel("GDE studio ");
         user_choice_cmb= new JComboBox<String>();
         lang_choice_cmb = new JComboBox<String>();
      lang_choice_cmb.addItem("English");
       lang_choice_cmb.addItem("አማርኛ");
       logbtn = new JButton("Login");
       singbtn = new JButton();
       aboutbtn = new JButton(new ImageIcon(ClassLoader.getSystemResource("image/About.png")));
       pic_panel.setLayout(null);
       panel.setBackground(new Color(66, 109, 131));
       panel.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, 80);
        pic_panel.setBounds(0, 95, 1200, 300);
         pic_panel.setBackground(new Color(200, 224, 200));
         ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("image/front.jpg"));
        Image img2 = img.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH);
       picture_lbl.setIcon(new ImageIcon(img2));
        user_name_lbl.setBounds(10, 37, 100, 25);
        picture_lbl.setBounds(0, 0, 1200, 300);
        user_choice_cmb.setBounds(100, 37, 100, 25);
       user_choice_cmb.addItem("Admin");
       user_choice_cmb.addItem("Registrar");
       user_choice_cmb.addItem("employe");
        lang_choice_cmb.setBounds(460, 0, 100, 25);
        lang_lbl.setBounds(350,0,100,25);
        password_lbl.setBounds(210, 37, 100, 25);
        password_Jpass.setBounds(290, 37, 190, 25);
        title_lbl.setBounds(20, 1, 190, 30);
        
         logbtn.setBounds(490, 37, 100, 25);
       
        aboutbtn.setBounds(10, 340, 25, 25);
         lang_lbl.setFont(new Font("Abyssinica SIL", Font.PLAIN, 16));
       password_lbl.setFont(new Font("Abyssinica SIL", Font.PLAIN, 16));
        title_lbl.setFont(new Font("Abyssinica SIL", Font.BOLD, 16));
       user_choice_cmb.setFont(new Font("Abyssinica SIL", Font.PLAIN, 16));
       lang_choice_cmb.setFont(new Font("Abyssinica SIL", Font.PLAIN, 16));
       password_lbl.setFont(new Font("Abyssinica SIL", Font.PLAIN, 16));
        logbtn.setFont(new Font("Abyssinica SIL", Font.PLAIN, 16));
        user_name_lbl.setFont(new Font("Abyssinica SIL", Font.PLAIN, 16));
        add(lang_lbl);
        add(user_name_lbl);
        add(user_choice_cmb);
        add(lang_choice_cmb);
        add(password_lbl);
        add(password_Jpass);
        add(title_lbl);
        add(logbtn);
       
        add(aboutbtn);
        add(panel);
        pic_panel.add(picture_lbl);
        add(pic_panel);
         logbtn(logbtn);
         lang_choice(lang_choice_cmb);
        title_lbl.setForeground(Color.white);
        password_lbl.setForeground(Color.white);
        user_name_lbl.setForeground(Color.WHITE);
        lang_lbl.setForeground(Color.white);
           setSize(600, 400);
              setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               setVisible(true);
             
               
       }

    
    public void logbtn(JButton btn){
      btn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
       
       login(e);
    }
        
      });
    }
     
       
  public void login(ActionEvent e)
  {
       if(e.getSource()==logbtn)
      {
          
          if(user_choice_cmb.getSelectedItem().toString().equals("Registrar"))
          {
               
              if(password_Jpass.getText().equalsIgnoreCase("eyobed"))
              {
                  setVisible(false);
            //      register emp =new register();
                 
           //    emp.setSize(Toolkit.getDefaultToolkit().getScreenSize());
           //    emp.setLocation(0, 0);
            //  emp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             //  emp.setVisible(true);
                dispose();
              }
              else
               JOptionPane.showMessageDialog(null,"wrong password");  
           }
          else if(user_choice_cmb.getSelectedItem().toString().equals("Admin")){
                   if(password_Jpass.getText().equalsIgnoreCase("feleke"))
                   {
                       JOptionPane.showMessageDialog(null,"admin");
                   }
                    else
               JOptionPane.showMessageDialog(null,"wrong password"); 
          }
          else if(user_choice_cmb.getSelectedItem().toString().equals("employe"))
                  {
                    if(password_Jpass.getText().equalsIgnoreCase("hello")) 
                    {
                        JOptionPane.showMessageDialog(null, "emp");
                    }
                     else
               JOptionPane.showMessageDialog(null,"wrong password"); 
                  }
          
      }
      
  } 
    public void lang_choice(JComboBox<String> lang)
        {
            lang.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(lang.getSelectedItem().toString().equals("አማርኛ")){
                        user_name_lbl.setText("ተጠቃሚ");
                        password_lbl.setText("የይለፍ ቃል");
                        title_lbl.setText("መግቢያ");
                        lang_lbl.setText("ቕንቕ");
                    }
                    else
                    {
                        user_name_lbl.setText("User");
                        password_lbl.setText("Password");
                        title_lbl.setText("Login");
                        lang_lbl.setText("Language"); 
                    }
                }
                
            });
        }
    
  public void change_lang(JComboBox<String> lang)
  {
      
  }
    
}

             


