package emp;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.util.*;
import javax.swing.border.TitledBorder;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
  
public class register extends JFrame {
    private static final long serialVersionUID = 1L;
   private  Connection conn = null;//for database connections
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private JPanel update_panel,search_data_panel, search_singleData_panel4, search_singleData_panel4s,search_singleData_panel1,search_singleData_panel1s,search_singleData_panel2,search_singleData_panel2s,
                    search_singleData_panel3,search_singleData_panel3s,search_singleData_panel5s,search_singleData_panel6s,search_singleData_panel7s,search_singleData_panel8s,title_panel, single_emp_panel,pic_panel, report,pic_btn_panel,
                    data_coll_panel,data_single_panel , exam_taken_panel,add_emp_panel,
                    delet_emp_panel,search_emp_panel,panel,panel1,sex_panel,lbl_panel,
                   add_singleData_panel1,add_singleData_panel2,add_singleData_panel3,add_singleData_panel4,
                    add_singleData_panel5,add_singleData_panel6,add_singleData_panel7,add_singleData_panel8
                    , add_singleData_panel9, add_singleData_panel10,delet_data_panel,delet_singleData_panel1,delet_singleData_panel2,
                       delet_singleData_panel3,searched_res_panel;
     JTextField  F_name_tf_s,F_name_tf_ss,F_name_tf_d,F_name_tf_a,L_name_tf_a,L_name_tf_d,L_name_tf_s,L_name_tf_ss,email_tf,email_tf_ss,phone_tf_a,phone_tf_ss,
             phone_tf_s, phone_no_tf_d,other_skill_tf,other_skill_tf_ss,age_tf_a,age_tf_ss,sex_tf_ss,position_tf_ss,nationality_tf_ss;
     JLabel nullspace_lbl1,serch_by_name_lbl,search_by_phone_lblimage,pic_choice_lbl, nullspace_lbl,label,person_lbl,F_name_lbl_d,F_name_lbl_ss,F_name_lbl_a,F_name_lbl_s,
             L_name_lbl_a, L_name_lbl_ss,L_name_lbl_d,L_name_lbl_s,age_lbl_a,age_lbl_ss,sex_lbl,sex_lbl_ss,position_lbl,position_lbl_ss,nationality,nationality_lbl_ss,email_lbl,email_lbl_ss,phone_no_lbl_d,
             phone_lbl_ss, phone_no_lbl_a,phone_no_lbl_s,other_skill_lbl,other_skill_lbl_ss,sort_lbl; 
    public static JLabel lbl_title,add_lbl;
    public static JTabbedPane tbd_main;
    private JMenuBar menu;
    private JMenu file,help,Account,setting;
    private JMenuItem save,saveas,logout,change_pass,sort,change_language;
    private JTable register_table, registered_trainee_table, exam_taken_list;
    private JButton delet_btn,update_btn,delet_emp_btn,search_emp_btn,btn_exit,pic_choice_btn,add_btn;
    private JRadioButton male,female,search_by_name,search_by_phone;
    private ButtonGroup sex,search;
    private JComboBox position_cmb,nationality_cmb,sort_cmb,age_cmb;
    private JCheckBox update_chb; 
    String nationality_arry[]={"Ethiopian","Other"};
    String age_arry[]={"21","22","23","24","25","26","27","30","31","32","33","43","54","60"};
       String  nation=null;
       String pos = null;
         String age = null;
    
    public register(){
  
         menu = new JMenuBar();
         setJMenuBar(menu);
          file = new JMenu("File");
        menu.add(file);
        help = new JMenu ("Help");
        menu.add(help);
        Account = new JMenu("Account");
        menu.add(Account);
        setting = new JMenu("Setting");
        menu.add(setting);
        change_language = new JMenuItem("Change Language");
        setting.add(change_language);
        sort= new JMenu("sort");
        setting.add(sort);
        saveas= new JMenuItem("Sava as");
   
        save= new JMenuItem("save ");
       
        file.add(saveas);
        file.add(save);

        add(menu);
         conn = DBMS.connectDb();
         this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);
        this.setUndecorated(true);
         btn_exit = new JButton(new ImageIcon(getClass().getClassLoader().getResource("image/exit.png")));
        btn_exit.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width - 50, 10, 40, 40);
        btn_exit.setBackground(Color.blue);
        btn_exit.setBorder(null);
        register_table = new JTable();
          title_panel = new JPanel();
           title_panel.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, 100);
        title_panel.setBackground(new Color(64, 102, 131));
        title_panel.setLayout(null);
           exam_taken_panel = new JPanel(new GridLayout(1,3));
           add_emp_panel = new JPanel(new  FlowLayout(FlowLayout.LEFT));
            add_emp_panel.setBorder(BorderFactory.createTitledBorder(null, "Add single employee", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.PLAIN, 20), Color.DARK_GRAY));
            panel = new JPanel(new GridLayout(9,1,0, 0));
            add_singleData_panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
           add_singleData_panel2=new JPanel(new FlowLayout(FlowLayout.LEFT));
           add_singleData_panel3=new JPanel(new FlowLayout(FlowLayout.LEFT));
           add_singleData_panel4=new JPanel(new FlowLayout(FlowLayout.LEFT));
            add_singleData_panel5=new JPanel(new FlowLayout(FlowLayout.LEFT));
            add_singleData_panel6=new JPanel(new FlowLayout(FlowLayout.LEFT));
            add_singleData_panel7=new JPanel(new FlowLayout(FlowLayout.LEFT));
            add_singleData_panel8=new JPanel(new FlowLayout(FlowLayout.LEFT));
            add_singleData_panel9=new JPanel(new FlowLayout(FlowLayout.LEFT));
            add_singleData_panel10=new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel age_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
             F_name_lbl_a=new JLabel("First Name             ");
             F_name_tf_a= new JTextField(15);
       
           add_singleData_panel1.add(F_name_lbl_a); 
           add_singleData_panel1.add(F_name_tf_a);
        panel.add(add_singleData_panel1);
        
        L_name_lbl_a=new JLabel("Last Name             ");
         L_name_tf_a = new JTextField(15);
       
             add_singleData_panel2.add(L_name_lbl_a);
            add_singleData_panel2.add(L_name_tf_a);
            panel.add(  add_singleData_panel2);
              sex_lbl= new JLabel("Sex                      ");
            add_singleData_panel3.add(sex_lbl);
          male =new JRadioButton("Male",false);
          
            sex= new ButtonGroup( );
            sex.add(male);
            sex.add(female);
         female=new JRadioButton("Female",false);
         sex_panel= new JPanel(new FlowLayout(FlowLayout.CENTER));
          sex_panel.add(male);
          sex_panel.add(female);
           add_singleData_panel3.add(sex_panel);
           age_lbl_a =new JLabel("Age  ");
           age_panel.add(age_lbl_a,BorderLayout.NORTH);
           age_cmb = new JComboBox(age_arry);
           age_panel.add(age_cmb,BorderLayout.NORTH);
           add_singleData_panel9.add(age_panel);
         sex = new ButtonGroup();
         sex.add(male);
         sex.add(female);
         panel.add( add_singleData_panel3);
         
        
   
        
            position_lbl=new JLabel("postion                 ");
           position_cmb = new JComboBox();
           position_cmb.addItem("c++ programer");
           position_cmb.addItem("Java programer");
           position_cmb.addItem("C programer");
            add_singleData_panel4.add(position_lbl);
            add_singleData_panel4.add(  position_cmb);
           panel.add( add_singleData_panel4);
             
        
           nationality= new JLabel("Nationality           ");
       
           nationality_cmb = new JComboBox(nationality_arry);
          
           add_singleData_panel5.add( nationality);
             add_singleData_panel5.add( nationality_cmb);
       panel.add(  add_singleData_panel5);
           email_lbl = new JLabel("Email                     ");
           email_tf = new JTextField(15);
  
            add_singleData_panel6.add(  email_lbl);
           add_singleData_panel6.add(email_tf);
        panel.add(  add_singleData_panel6);
               phone_no_lbl_a= new JLabel("Phone number    ");
            phone_tf_a= new JTextField(15);
            add_singleData_panel7.add(   phone_no_lbl_a);
            add_singleData_panel7.add( phone_tf_a);
            panel.add(  add_singleData_panel7);
             other_skill_lbl= new JLabel("Othere skills       ");
              other_skill_tf = new JTextField(15);  
                add_singleData_panel8.add(  other_skill_lbl);
                 add_singleData_panel8.add(  other_skill_tf);
                 panel.add(  add_singleData_panel8);
                 
                 add_btn= new JButton("ADD EMPLOYEE");
              
              
            add_singleData_panel9.add(add_btn);
             add_singleData_panel9.add(add_singleData_panel10);
            
                      panel.add(add_singleData_panel9);
            pic_btn_panel = new JPanel(new BorderLayout());
            pic_panel = new JPanel(new BorderLayout());
           // image = new JLabel();
             pic_panel.setBackground(Color.lightGray);
        
           ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("image/front.jpg"));
            Image img2 = img.getImage();
           //  image.setIcon(new ImageIcon(img2));
           // image.setBounds(pic_panel.getX(),pic_panel.getY(),pic_panel.getWidth(),pic_panel.getHeight());
            pic_panel.setBackground(  new Color(64, 102, 131));
            pic_panel.setBorder(BorderFactory.createTitledBorder(null, "Picture ", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.PLAIN, 20), Color.WHITE));
          //  pic_panel.a]dd(image);
            
            pic_choice_btn = new JButton("choose Picture");
         
           lbl_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            lbl_panel.add(pic_choice_btn);
            
            nullspace_lbl = new JLabel("       "); 
            pic_btn_panel.add(pic_panel,BorderLayout.WEST);
            pic_btn_panel.add(lbl_panel,BorderLayout.WEST);
         
            
            add_emp_panel.add(pic_btn_panel);
            add_emp_panel.add(panel);
            single_emp_panel = new JPanel(new GridLayout(1,3));
           single_emp_panel.setBorder(BorderFactory.createTitledBorder(null, "Single employee", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 25), Color.WHITE));
          single_emp_panel.setBackground(new Color(64, 102, 131));
           single_emp_panel.add(add_emp_panel);
          update_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
          update_btn = new JButton("Udate");
           nullspace_lbl1= new JLabel("             ");
           delet_btn = new JButton("DELETE");
           
           
          search_emp_panel = new JPanel(new BorderLayout());
          search_emp_panel.setBorder(BorderFactory.createTitledBorder(null, "search single employee", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.PLAIN, 20), Color.DARK_GRAY));
         search_data_panel= new JPanel(new GridLayout(4,0));
        search_singleData_panel1= new  JPanel(new FlowLayout(FlowLayout.LEFT));
        search_by_name= new JRadioButton(" by Name",true);
        search_by_phone= new JRadioButton(" by Phone Number",false);
        search = new ButtonGroup();
        search.add(search_by_name);
        search.add( search_by_phone);
        search_singleData_panel4= new  JPanel(new FlowLayout(FlowLayout.LEFT));
         search_emp_btn = new JButton("Search");
       update_chb = new JCheckBox("UPDATE ",false);
       update_panel.add(nullspace_lbl);
       update_panel.add(update_chb);
       update_panel.add(update_btn);
         update_panel.add(nullspace_lbl1);
         update_panel.add(delet_btn);
         search_singleData_panel4.add(search_by_name);
         search_singleData_panel4.add(search_by_phone);
           search_singleData_panel4 .add( search_emp_btn);
           search_singleData_panel4 .add(  update_panel);
         search_data_panel.add(search_singleData_panel4);
                 
                 
        
         
          F_name_lbl_s= new JLabel("First Name        ");
          F_name_tf_s= new JTextField(20);
         search_singleData_panel1.add(F_name_lbl_s);
         search_singleData_panel1.add(F_name_tf_s);
          search_data_panel.add( search_singleData_panel1);
          search_singleData_panel2= new  JPanel(new FlowLayout(FlowLayout.LEFT));
           L_name_lbl_s = new JLabel("Last Name        ");
           L_name_tf_s = new JTextField(20);
           search_singleData_panel2.add(L_name_lbl_s);
          search_singleData_panel2.add(L_name_tf_s);
          search_data_panel.add( search_singleData_panel2);
          search_singleData_panel3= new  JPanel(new FlowLayout(FlowLayout.LEFT));
          phone_no_lbl_s= new JLabel("Phone Number ");
           phone_tf_s =new JTextField(20);       
          search_singleData_panel3.add(phone_no_lbl_s);
          search_singleData_panel3.add(phone_tf_s); 
            search_data_panel.add( search_singleData_panel3);
         search_emp_panel.add(search_data_panel,BorderLayout.NORTH);
          single_emp_panel.add(search_emp_panel); 
         
           report= new JPanel(new GridLayout(1, 0));
           report.add(new JScrollPane( register_table));
           pic_btn_panel= new JPanel(new BorderLayout());
           data_coll_panel= new JPanel(new GridLayout(1,0));
     
          searched_res_panel= new JPanel(new GridLayout(8,0));
          F_name_tf_ss = new JTextField(10);
          L_name_tf_ss = new JTextField(10);
          age_tf_ss = new JTextField(3);
          sex_tf_ss = new JTextField(3);
          position_tf_ss = new JTextField(10);
          nationality_tf_ss = new JTextField(10);
          email_tf_ss = new JTextField(10);
          phone_tf_ss = new JTextField(10);
          
           F_name_lbl_ss = new JLabel("First Name");
           L_name_lbl_ss = new JLabel("Last Name");
            age_lbl_ss = new JLabel("Age ");
            sex_lbl_ss = new JLabel("Sex");
            position_lbl_ss = new JLabel("Positin ");
            nationality_lbl_ss = new JLabel("Nationality ");
            email_lbl_ss = new JLabel("Email ");
            phone_lbl_ss = new JLabel("Phone Number");
            F_name_tf_ss.setEditable(false);
                           
          
             search_singleData_panel1s = new JPanel(new FlowLayout(FlowLayout.LEFT));
         search_singleData_panel2s = new JPanel(new FlowLayout(FlowLayout.LEFT));
         search_singleData_panel3s = new JPanel(new FlowLayout(FlowLayout.LEFT));
         search_singleData_panel4s = new JPanel(new FlowLayout(FlowLayout.LEFT));
         search_singleData_panel5s = new JPanel(new FlowLayout(FlowLayout.LEFT));
         search_singleData_panel6s = new JPanel(new FlowLayout(FlowLayout.LEFT));
         search_singleData_panel7s = new JPanel(new FlowLayout(FlowLayout.LEFT));
         search_singleData_panel8s = new JPanel(new FlowLayout(FlowLayout.LEFT));
            
           search_singleData_panel1s.add(F_name_lbl_ss); 
            search_singleData_panel1s .add( F_name_tf_ss);
           searched_res_panel.add( search_singleData_panel1s);
          search_singleData_panel2s .add( L_name_lbl_ss);
           search_singleData_panel2s .add( L_name_tf_ss);
           searched_res_panel.add( search_singleData_panel2s);
           
          search_singleData_panel3s.add(age_lbl_ss);
           search_singleData_panel3s.add(age_tf_ss);
           
        search_singleData_panel4s.add( search_singleData_panel3s);
          search_singleData_panel4s.add(sex_lbl_ss );
           search_singleData_panel4s.add(sex_tf_ss );
           
           searched_res_panel.add( search_singleData_panel4s);
          search_singleData_panel5s.add( position_lbl_ss);
         search_singleData_panel5s.add( position_tf_ss);
          search_singleData_panel4s.add(search_singleData_panel5s);
       
         search_singleData_panel6s.add( nationality_lbl_ss);
          search_singleData_panel6s.add(nationality_tf_ss);
          
          searched_res_panel.add( search_singleData_panel6s);
           search_singleData_panel7s.add(email_lbl_ss);
           search_singleData_panel7s.add(email_tf_ss);
           searched_res_panel.add( search_singleData_panel7s);
              search_singleData_panel8s .add( phone_lbl_ss);
              search_singleData_panel8s .add( phone_tf_ss);
              
           searched_res_panel.add( search_singleData_panel8s);
           search_emp_panel.add(searched_res_panel,BorderLayout.WEST);
           single_emp_panel.add(search_emp_panel); 
          
         
     
       
       
       
       
       
       
       
       
       
       tbd_main = new JTabbedPane();
        tbd_main.setBounds(0, 100, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
          lbl_title = new JLabel();
        lbl_title.setBounds(30, 30, 500, 50);
        lbl_title.setForeground(Color.white);
        lbl_title.setFont(new Font("Abyssinica SIL", Font.BOLD, 25));
        title_panel.add(lbl_title);
        title_panel.add(btn_exit);
        tbd_main.add(report, "registerd List");
        tbd_main.setIconAt(0, new ImageIcon(getClass().getClassLoader().getResource("image/emp.png")));
        tbd_main.add(single_emp_panel,"Single data");
        tbd_main.setIconAt(1, new ImageIcon(getClass().getClassLoader().getResource("image/programmer.png")));
        add(tbd_main);
        add(title_panel);
       
        title_panel.add(lbl_title);
        title_panel.add(btn_exit);
        logout(btn_exit);
        registered_table();
        add_emp_func();
         search_emp();
         L_name_tf_ss.setEditable(false);
                         
    
    }
      public void registered_table() {
        try {
            String sql = "select F_name as'First Name' ,L_name as 'Last Name' , age as'Age', sex as'Sex' ,nationality,position_p as 'Position',email,phone  from reg";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            register_table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
      public void add_emp_func(){
          
         
          add_btn.addActionListener(new ActionListener(){
              
             @Override
            public void actionPerformed(ActionEvent e) {
            
                try {
                    String sq2 = "INSERT INTO emp.reg  VALUES (?, ?, ?, ? , ?, ?, ?, ?)";
                        ps = conn.prepareStatement(sq2);
                    ps.setString(1,F_name_tf_a.getText());
                    ps.setString(2,L_name_tf_a.getText());
                    
                   //   if(age.isEmpty())
                    age=age_cmb.getSelectedItem().toString();
                  
                    ps.setString(3,age);
                   String males="M";
                   String females="F";
                    if(male.isSelected())
                          ps.setString(4,males);
                     else if (female.isSelected()){
                           ps.setString(4,females);   
                     }
                    
                   //    if( nation.isEmpty())
                      nation = nationality_cmb.getSelectedItem().toString();
                  //    if(  pos.isEmpty())
                       pos =position_cmb.getSelectedItem().toString();
                        
                      ps.setString(5,nation );
                          ps.setString(6,pos);
                          ps.setString(7,email_tf.getText());
                          ps.setString(8,phone_tf_a.getText()+" ");
                          JOptionPane.showMessageDialog(null,  "Employee added");
                           ps.execute();
                 registered_table();
                } catch (SQLException ex1) {
                     JOptionPane.showMessageDialog(null,  ex1);
                }
                     
                 }
            });
          }
         public void search_emp(){
       
             
             
             
             if(!update_chb.isSelected()){
                           
                            age_tf_ss.setEditable(false);
                           sex_tf_ss.setEditable(false);        
                           nationality_tf_ss.setEditable(false);       
                           position_tf_ss.setEditable(false);                 
                           email_tf_ss.setEditable(false);             
                           phone_tf_ss.setEditable(false);
                            }
             
             
                  F_name_tf_s.setEditable(true);
               L_name_tf_s.setEditable(true);
                       phone_tf_s.setEditable(false);
             search_by_name.addActionListener(new ActionListener(){
              
                 @Override
                 public void actionPerformed(ActionEvent e) {
                   phone_tf_s.setEditable(false);
                   phone_tf_s.setText(" ");
                     F_name_tf_s.setEditable(true);
               L_name_tf_s.setEditable(true);
                 }
             });
              search_by_phone.addActionListener(new ActionListener(){
              
                 @Override
                 public void actionPerformed(ActionEvent e) {
                  F_name_tf_s.setEditable(false);
               L_name_tf_s.setEditable(false);
                 phone_tf_s.setEditable(true);
                  L_name_tf_s.setText(" ");
                 F_name_tf_s.setText(" ");
                 
                 
                 }
                 
             });
                  search_emp_btn.addActionListener(new ActionListener(){
              
                 @Override
                 public void actionPerformed(ActionEvent e) {
                 
                 
                  
                         try {
                         String sql1 = "select*from emp.reg where F_name like('" +  F_name_tf_s.getText() + "') and L_name like('"+  L_name_tf_s.getText() + "')";
                         String sql2 = "select*from emp.reg where phone= '" +phone_tf_s.getText() +"'"; 
                         if(search_by_name.isSelected()){
                           ps = conn.prepareStatement(sql1);
                         rs= ps.executeQuery(sql1);
                         }
                         else if(search_by_phone.isSelected())
                         {
                                ps = conn.prepareStatement(sql2);
                               rs= ps.executeQuery(sql2);
                      
                         }
                       
                     
                       
                        
                         while(rs.next())
                         {
                            F_name_tf_ss.setText(rs.getString("F_name"));  
                             L_name_tf_ss.setText(rs.getString("L_name"));
                              age_tf_ss.setText(rs.getString("age")) ;    
                                sex_tf_ss.setText(rs.getString("sex"));          
                                 nationality_tf_ss.setText(rs.getString("nationality"));          
                                position_tf_ss.setText(rs.getString("position_p"));                  
                                 email_tf_ss.setText(rs.getString("email"));                
                                  phone_tf_ss.setText(rs.getString("phone")); 
                      
                         }
                    
                             update_chb.addItemListener(new ItemListener(){
                             @Override
                             public void itemStateChanged(ItemEvent e) {
                         if(update_chb.isSelected())
                         {
                             F_name_tf_ss.setEditable(true);
                             L_name_tf_ss.setEditable(true);
                             age_tf_ss.setEditable(true);
                             sex_tf_ss.setEditable(true);
                             nationality_tf_ss.setEditable(true);
                             position_tf_ss.setEditable(true);
                             email_tf_ss.setEditable(true);
                             phone_tf_ss.setEditable(true);
                             update_btn.addActionListener(new ActionListener(){
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     try {
                                          String sql;
                                         if(search_by_name.isSelected())
                                         {
                                                 sql = ("update  emp.reg  set F_name = '")+ F_name_tf_ss.getText() + ("' ,L_name = '")+ L_name_tf_ss.getText()+ ("' ,age = '" )+ age_tf_ss.getText()+
                                                ( "' ,sex= '")+ sex_tf_ss.getText() +("',nationality = '")+  nationality_tf_ss.getText() + ("',position_p = '") + position_tf_ss.getText() +
                                                ( "' ,email = '") + email_tf_ss.getText()+ ("',phone = ' ")+ phone_tf_ss.getText()+ ("'  where F_name = '") + F_name_tf_s.getText()+ ("' and L_name = '") + L_name_tf_s.getText() + ("'");
                                         ps = conn.prepareStatement(sql);
                                         }
                                       if(search_by_phone.isSelected()){
                              sql = ("update  emp.reg  set F_name = '")+ F_name_tf_ss.getText() + ("' ,L_name = '")+ L_name_tf_ss.getText()+ ("' ,age = '" )+ age_tf_ss.getText()+
                                                 ( "' ,sex= '")+ sex_tf_ss.getText() +("',nationality = '")+  nationality_tf_ss.getText() + ("',position_p = '") + position_tf_ss.getText() +
                                                ( "' ,email = '") + email_tf_ss.getText()+ ("',phone = ' ")+ phone_tf_ss.getText()+ ("'  where  phone = '")+phone_tf_ss.getText() + "'";
                                         ps = conn.prepareStatement(sql);
                      }
                                            
                                         
                                         
                                         ps.execute();
                                         registered_table();
                                     } catch (SQLException ex) {
                                         JOptionPane.showMessageDialog(null, ex);
                                     }
                                 }
                                 
                             });
                           
                           
                     }
                         else   if(!update_chb.isSelected()){
                               F_name_tf_ss.setEditable(false);
                            L_name_tf_ss.setEditable(false);
                           age_tf_ss.setEditable(false);
                           sex_tf_ss.setEditable(false);      
                           nationality_tf_ss.setEditable(false);      
                           position_tf_ss.setEditable(false);              
                           email_tf_ss.setEditable(false);        
                           phone_tf_ss.setEditable(false);
                         }
                         
  
                             }
                               
                           });
                         
                     } catch (SQLException ex) {
                         JOptionPane.showMessageDialog(null,ex);
                     }
                     
              
                                       delet_btn.addActionListener(new ActionListener(){
                           
                           

                            @Override
                             public void actionPerformed(ActionEvent e) {
                                    
                                 if(search_by_name.isSelected())
                                       {
                                            String sql4="delete from emp.reg where F_name = '"+F_name_tf_s.getText()+"' and L_name = '"+L_name_tf_s.getText()+"'";
                                     try {
                                         ps = conn.prepareStatement(sql4);
                                     } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null, ex);
                                     }
                                     try {
                                         ps.execute();
                                     } catch (SQLException ex) {
                                       JOptionPane.showMessageDialog(null, ex);
                                     }
                                       }
                                 else if(search_by_phone.isSelected())
                                 {
                                    String sql4 ="delete from emp.reg where phone = '"+phone_tf_s.getText()+"'";
                                     try {
                                         ps = conn.prepareStatement(sql4);
                                     } catch (SQLException ex) {
                                         JOptionPane.showMessageDialog(null, ex);
                                     }
                                     try {
                                         ps.execute();
                                     } catch (SQLException ex) {
                                     JOptionPane.showMessageDialog(null, ex);
                                     }
                                  }
                               
                                 registered_table();
                           
                                  
                             }    
                       });       
                     
                 
                 }
                 
             });
       
             
}
            
  public void logout(JButton logout) {
        logout.addActionListener(new ActionListener() {

              @Override
            public void actionPerformed(ActionEvent e) {
             login login = new login();
                  dispose(); 
            }
        });
    }
}
