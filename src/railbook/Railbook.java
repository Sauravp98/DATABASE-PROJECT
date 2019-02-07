package railbook;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.text.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
public class Railbook implements ActionListener
{
JLabel heading,htl,chkin,chkout,lb1,rst,pub_js,pub_je;
JButton insert,exit,Reset,view,addroute,delroute,upd;
JButton b1[],bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8;
JPanel p1,p2,p3,p4;
JFrame f1,frame1,frame2,frame3,frame4,frame5,frame6,frame7,frame8,frame9;
Connection cont;
Statement stmt;
PreparedStatement statr;
ResultSet rs;
JTextField a,b,c,d,e,f,g,h,i,j;
JRadioButton c1,c2,c3,c4;
JComboBox v1,v2,v3,v4,v5,v6;
ImageIcon image1;
JTable table,table1,table2,table3,table4,table5;
ButtonGroup bg;
 String dte[];
 String mte[];
 String yr[];
 String jstart[];
 String jend[];
 String[] columnNames = {"TRAIN NO","TRAIN NAME","TRAIN TYPE"};
 String[] columnNames1 = {"STATION ","PLATFORMNO","ARRIVAL","DEPARTURE"};
 String[] columnNames2={"TRAIN NO","TRAIN NAME","TRAIN TYPE"};
 String[] columnNames3={"STATION ID","STATION NAME"};
 String[] columnNames4={"TRAIN NO","DAY"};
 String[] columnNames5={"STATION ID","TRAIN NO","PLATFORMNO","ARRIVAL","DEPARTURE","JOURNEY_DAYS"};
 String Source,Destination,day;
 static int status=1;
 static int stat=1,stat1=1,stat2=1,stat3=0;
 String tno1;
 String p = "";
public Railbook()
         {
   String url="jdbc:oracle:thin:@localhost:1521:orcl1";
   String username="proj";
   String password="hola";
    try{
        cont=DriverManager.getConnection(url,username,password);         
        stmt=cont.createStatement();
      }
    catch(SQLException e)
    {
        System.out.println("error has occureed "+e);
    }
}
 
public void compshow()
{
    dte= new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    mte=new String[]{"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
    yr=new String[]{"2016","2017","2018","2019"};
    jstart=new String[]{"New Delhi","Pune JN","Vasai Road","Lonavala","Hazrat Nizamuddin","Chennai Central","Mathura","Agra Cantt","KSR Bengaluru","Dhaulpur","Morena",
"Gwalior JN","Jabalpur","Jhansi JN","Howrah JN","Mumbai Central","Anand Vihar Terminal","Jammu TAWI","Lalitpur","Bhopal JN",
"Habibganj","Ghaziabad","Aligarh JN","Tundla JN","EtawahKanpur Central","Lucknow JN","Ambala Cant JN","Sirhind JN",
"Ludhiana JN","Phagwara JN","Jalandhar City","Beas","Amritsar JN","Katpadi JN","Bangalore Cant","Jolarpettai","Salem JN",
"Erode JN","Tiruppur","Coimbatore JN","Allahabad JN","Rajendranagar T","Madan Mahal","Sridham","Narsinghpur","Kareli",
"Gadarwara","Pipariya","Itarsi JN","Hoshangabad","Vadodara JN","Ratlam JN","Sawai Madhopur","Jaipur","Tatanagar JN",
"Bilaspur JN","Nagpur","Bhusaval JN","Igatpuri","C Shivaji Maharaj T","Kota JN","Asansol JN","Shalimar","Moradabad",
"Bareilly","Lucknow","Rae Bareli JN","Amethi","Partapgarh JN","Bhadohi","Varanasi JN","Kathua","Pathankoth Cantt",
"Mughal Sarai JN"};
    jend=new String[]{"New Delhi","Pune JN", "Vasai Road","Lonavala","Hazrat Nizamuddin","Chennai Central","Mathura","Agra Cantt","KSR Bengaluru","Dhaulpur","Morena",
"Gwalior JN","Jabalpur","Jhansi JN","Howrah JN","Mumbai Central","Anand Vihar Terminal","Jammu TAWI","Lalitpur","Bhopal JN",
"Habibganj","Ghaziabad","Aligarh JN","Tundla JN","EtawahKanpur Central","Lucknow JN","Ambala Cant JN","Sirhind JN",
"Ludhiana JN","Phagwara JN","Jalandhar City","Beas","Amritsar JN","Katpadi JN","Bangalore Cant","Jolarpettai","Salem JN",
"Erode JN","Tiruppur","Coimbatore JN","Allahabad JN","Rajendranagar T","Madan Mahal","Sridham","Narsinghpur","Kareli",
"Gadarwara","Pipariya","Itarsi JN","Hoshangabad","Vadodara JN","Ratlam JN","Sawai Madhopur","Jaipur","Tatanagar JN",
"Bilaspur JN","Nagpur","Bhusaval JN","Igatpuri","C Shivaji Maharaj T","Kota JN","Asansol JN","Shalimar","Moradabad",
"Bareilly","Lucknow","Rae Bareli JN","Amethi","Partapgarh JN","Bhadohi","Varanasi JN","Kathua","Pathankoth Cantt",
"Mughal Sarai JN"};
    Arrays.sort(jstart);
    Arrays.sort(jend);
    c1=new JRadioButton("Rajdhani");
    c2=new JRadioButton("Duronto");
    c3=new JRadioButton("Garibrath");
    c4=new JRadioButton("Shatabdi");
    v1=new JComboBox(dte);
    v2=new JComboBox(mte);
    v3=new JComboBox(yr);
    v4=new JComboBox(jstart);
    v5=new JComboBox(jend);
    f1=new JFrame("RailWare");
    p1=new JPanel();
    

    htl=new JLabel("Train TYpe:");
    chkin=new JLabel("DATE OF JOURNEY");
 

    pub_js=new JLabel("DESTINATION");
    pub_je=new JLabel("SOURCE");         
 
    exit=new JButton("EXIT");
    exit.setBackground(java.awt.Color.red);
    view=new JButton("SEARCH TRAINS");
    view.setBackground(java.awt.Color.orange);
    addroute=new JButton("ADD ROUTE");
    addroute.setBackground(java.awt.Color.yellow);
    delroute=new JButton("DELETE ROUTE");
    delroute.setBackground(java.awt.Color.yellow);
    upd=new JButton("UPDATE STATION");
    upd.setBackground(java.awt.Color.yellow);
    bt5=new JButton("TRAIN TB");
    bt5.setBackground(java.awt.Color.cyan);
    bt6=new JButton("STATION TB");
    bt6.setBackground(java.awt.Color.cyan);
    bt7=new JButton("SCHEDULE TB");
    bt7.setBackground(java.awt.Color.cyan);
    bt8=new JButton("ROUTE TB");
    bt8.setBackground(java.awt.Color.cyan);
 
    p1.setLayout(null);   
    c1.setBounds(150,155,200,30);
    c2.setBounds(150,175,200,30);
    c3.setBounds(150,195,200,30);
    c4.setBounds(150,215,200,30);
    
    htl.setBounds(75,155,200,30);
    bg=new ButtonGroup();
    bg.add(c1);
    bg.add(c2);
    bg.add(c3);
    bg.add(c4);
    p1.add(c1);
    p1.add(c2);
    p1.add(c3);
    p1.add(c4);
    p1.add(htl);
    pub_je.setBounds(105,60,220,40);
    pub_js.setBounds(390,60,220,40);
    v1.setBounds(250,280,60,18);
    v2.setBounds(320,280,60,18);
    v3.setBounds(390,280,60,18);
    v4.setBounds(75,90,210,40);
    v5.setBounds(350,90,210,40);
    chkin.setBounds(75,272,200,30);
 
    p1.add(chkin);
 
    p1.add(v1);
    p1.add(v2);
    p1.add(v3);
    p1.add(v4);
    p1.add(v5);
    
 image1 = new ImageIcon(("ff3d5db63f4238634f249c9821312d61.png"));
 lb1=new JLabel(image1);
 lb1.setBounds(8,8,200,125);
   p1.add(lb1);   
   p1.add(pub_js);
   p1.add(pub_je);
    
    exit.setBounds(290,450,80,30);
    view.setBounds(250,330,160,30);
    addroute.setBounds(75,370,160,30); 
    delroute.setBounds(250,370,160,30);
    upd.setBounds(425,370,160,30);
    bt5.setBounds(10,410,160,30);
    bt6.setBounds(175,410,160,30); 
    bt7.setBounds(340,410,160,30);
    bt8.setBounds(505,410,160,30);  
     
     p1.add(exit);   
     p1.add(view);
     p1.add(addroute);
     p1.add(delroute);
     p1.add(upd);
     p1.add(bt5);
     p1.add(bt6);
     p1.add(bt7);
     p1.add(bt8);
    
    f1.add(p1);
    f1.setSize(690,540);
    f1.setVisible(true);
    p1.setBackground(java.awt.Color.green);
    c1.setBackground(java.awt.Color.green);
    c2.setBackground(java.awt.Color.green);
    c3.setBackground(java.awt.Color.green);
    c4.setBackground(java.awt.Color.green);
    v1.setBackground(java.awt.Color.magenta);
    v2.setBackground(java.awt.Color.magenta);
    v3.setBackground(java.awt.Color.magenta);
    
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    view.addActionListener(this);    
    exit.addActionListener(this);
    addroute.addActionListener(this);
    delroute.addActionListener(this);
    upd.addActionListener(this);
    bt5.addActionListener(this);
    bt6.addActionListener(this);
    bt7.addActionListener(this);
    bt8.addActionListener(this);
}
String s="";
   
@Override
public void actionPerformed(ActionEvent ae)
{
    if("EXIT".equals(ae.getActionCommand()))
    {        
      System.exit(0);
    }      
    else if("ADD ROUTE".equals(ae.getActionCommand()))
    {
        frame3=new JFrame("Insert");
         p2=new JPanel();
         bt1=new JButton("ADD ROUTE1");
        a=new JTextField("tno");
        b=new JTextField("sid");
        c=new JTextField("platformno");
        d=new JTextField("arrival"); 
        e=new JTextField("departure");
        f=new JTextField("Journey_days");  
        p2.setLayout(null);
        a.setBounds(75,110,200,30);   
        p2.add(a);        
        b.setBounds(75,140,200,30);    
        p2.add(b);    
        c.setBounds(75,170,200,30);   
        p2.add(c);
        d.setBounds(75,200,200,30);  
        p2.add(d);
        e.setBounds(75,230,200,30);   
        p2.add(e);
        f.setBounds(75,260,200,30);  
        bt1.setBounds(75,290,200,30); 
        p2.setBackground(Color.blue);
        p2.add(f);
        p2.add(bt1);
        bt1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent j)
      {
            if("ADD ROUTE1".equals(j.getActionCommand())){
                  int x=JOptionPane.showConfirmDialog(f1,"Do you wish to delete record","Information",JOptionPane.YES_NO_CANCEL_OPTION);
                  if(x==JOptionPane.YES_OPTION){
                    System.out.println("as");
            try {
                   statr=cont.prepareStatement("INSERT INTO ROUTE VALUES(?,?,?,?,?,?)");             
            
                  statr.setInt(1,Integer.parseInt(b.getText()));
                  statr.setInt(2,Integer.parseInt(a.getText()));
                  statr.setInt(3,Integer.parseInt(c.getText()));
                  statr.setString(4,d.getText());
                  statr.setString(5,e.getText());
                  statr.setString(6,f.getText());           
                  statr.executeUpdate();
                  JOptionPane.showMessageDialog(f1,"Information has beeen inserted.","Information",JOptionPane.INFORMATION_MESSAGE);            
            
        }   catch (SQLException ex) {
                Logger.getLogger(Railbook.class.getName()).log(Level.SEVERE, null, ex);
            }
               }
           else
               frame3.setVisible(true);
            }
      }
    });
      
        frame3.add(p2);
        frame3.setSize(700,700);
        frame3.setVisible(true);
    }
     else if("DELETE ROUTE".equals(ae.getActionCommand()))
    {
        System.out.println("carol");
        frame4=new JFrame("DELETE");
         p3=new JPanel();
         bt2=new JButton("DEL ROUTE");
        g=new JTextField("tno");
        h=new JTextField("sid");
        
        p3.setLayout(null);
        g.setBounds(75,110,200,30);   
        p3.add(g);        
        h.setBounds(75,140,200,30);    
        p3.add(h);        
        bt2.setBounds(75,290,200,30); 
        p3.setBackground(Color.red);       
        p3.add(bt2);
        bt2.addActionListener(new ActionListener() {      
      public void actionPerformed(ActionEvent z)
      {
               if("DEL ROUTE".equals(z.getActionCommand())){               
                              int x=JOptionPane.showConfirmDialog(f1,"Do you wish to delete record","Information",JOptionPane.YES_NO_CANCEL_OPTION);
           if(x==JOptionPane.YES_OPTION)
           {
            System.out.println("as");
            try {
                   statr=cont.prepareStatement("DELETE FROM ROUTE WHERE T_NO=? and S_ID=?");             
            
                  statr.setInt(1,Integer.parseInt(g.getText()));
                  statr.setInt(2,Integer.parseInt(h.getText()));                            
                  statr.executeUpdate();
                  JOptionPane.showMessageDialog(f1,"Information has beeen deleted.","Information",JOptionPane.INFORMATION_MESSAGE);            
            
        }   catch (SQLException ex) {
                Logger.getLogger(Railbook.class.getName()).log(Level.SEVERE, null, ex);
            }                 
           }
            else
              frame4.setVisible(true);
               }
      }
            });
         
        frame4.add(p3);
        frame4.setSize(600,600);
        frame4.setVisible(true);
    }
                
   else if("UPDATE STATION".equals(ae.getActionCommand()))
    {
        System.out.println("carol1");
        frame5=new JFrame("UPDATE");
         p4=new JPanel();
         bt3=new JButton("UPD STA");
        i=new JTextField("sid");
        j=new JTextField("sname");
        
        p4.setLayout(null);
        i.setBounds(75,110,200,30);   
        p4.add(i);        
        j.setBounds(75,140,200,30);    
        p4.add(j);        
        bt3.setBounds(75,290,200,30); 
        p4.setBackground(Color.magenta);       
        p4.add(bt3);
        bt3.addActionListener(new ActionListener() {      
      public void actionPerformed(ActionEvent z)
      {
               if("UPD STA".equals(z.getActionCommand()))
               {
                  int x=JOptionPane.showConfirmDialog(f1,"Do you wish to update record","Information",JOptionPane.YES_NO_CANCEL_OPTION);
                  System.out.println("as");
                  if(x==JOptionPane.YES_OPTION){
            try {
                   String myQuery = "UPDATE STATION SET S_NAME =? where S_ID =?";
                   statr=cont.prepareStatement(myQuery);          
                   statr.setString(1,j.getText());
                   System.out.println(Integer.parseInt(i.getText())+"\t"+j.getText());
                  statr.setInt(2,Integer.parseInt(i.getText()));  
                  statr.executeUpdate();
                  //System.out.println(statr.executeUpdate());
                  //JOptionPane.showMessageDialog(f1,"Information has beeen updated.","Information",JOptionPane.INFORMATION_MESSAGE);            
            
        }   catch (SQLException ex) {
                Logger.getLogger(Railbook.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                  else
                      frame5.setVisible(true);
               }
      }
    });
 
        frame5.add(p4);
        frame5.setSize(500,500);
        frame5.setVisible(true);
    }
    else if("SEARCH TRAINS".equals(ae.getActionCommand()))
     {  
                          for(int j=0;j<jstart.length;j++){
                                       if(jstart[j].equals(v4.getSelectedItem().toString()))
                                       Source=jstart[j];
                          }
                          for(int j=0;j<jstart.length;j++){
                          if(jend[j].equals(v5.getSelectedItem().toString()))
                             Destination=jend[j];
                          }
                          System.out.println(Source+"\t"+Destination);
                          
                      
                  int d1=0,d2=0,m1=0,m2=0,y1=0,y2=0;
                  if(c1.isSelected())
                         p="Rajdhani";
                  if(c2.isSelected())
                         p="Duronto";
                  if(c3.isSelected())
                         p="Garibrath";  
                  if(c4.isSelected())
                         p="Shatabdi";

                    for(int j=0;j<dte.length;j++)
                          if(dte[j].equals(v1.getSelectedItem().toString()))
                              d1=j+1;
                    for(int j=0;j<mte.length;j++)
                          if(mte[j].equals(v2.getSelectedItem().toString()))
                              m1=j+1;
                    for(int j=0;j<yr.length;j++)
                          if(yr[j].equals(v3.getSelectedItem().toString()))
                              y1=j+1+2015;
                    
                                      try{                           
                      if(!c1.isSelected()&&!c2.isSelected()&&!c3.isSelected()&&!c4.isSelected())                       
                          throw new Nobuttonsel("Exception");
                     }
                      catch(Nobuttonsel e)
                              {
                              stat2=0;
              JOptionPane.showMessageDialog(f1,"Please select a train type.","Warning",JOptionPane.WARNING_MESSAGE);
                                 
                              }
                    System.out.println(d1+"\t"+m1+"\t"+y1);
                    Date date= (new GregorianCalendar(y1, m1-1, d1)).getTime();
                    SimpleDateFormat f = new SimpleDateFormat("EEEE");
                    day=f.format(date);
                    System.out.println(day);
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    sdf.setLenient(false);
                     try {
                         stat=1;
			Date d = sdf.parse(""+d1+"/"+(m1)+"/"+y1);
	            } catch (ParseException pe) {
                        stat=0;
		    JOptionPane.showMessageDialog(f1,"Invalid Date","Warning",JOptionPane.WARNING_MESSAGE);  
                   f1.setVisible(true);
                   v1.setSelectedIndex(0);
                   v2.setSelectedIndex(0);
                   v3.setSelectedIndex(0);
                        System.out.println("Invalid date");
		}
    try {
        showTableData();      
    } catch (SQLException ex) {
        Logger.getLogger(Railbook.class.getName()).log(Level.SEVERE, null, ex);
    }
     }
    else if("TRAIN TB".equals(ae.getActionCommand()))
    {
        System.out.println("Train");
        try {
            showdata2();
        } catch (SQLException ex) {
            Logger.getLogger(Railbook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        else if("STATION TB".equals(ae.getActionCommand()))
    {
        System.out.println("Station");
         try {
            showdata3();
        } catch (SQLException ex) {
            Logger.getLogger(Railbook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        else if("SCHEDULE TB".equals(ae.getActionCommand()))
    {
        System.out.println("Schedule");
         try {
            showdata4();
        } catch (SQLException ex) {
            Logger.getLogger(Railbook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        else if("ROUTE TB".equals(ae.getActionCommand()))
    {
        System.out.println("Route");
         try {
            showdata5();
        } catch (SQLException ex) {
            Logger.getLogger(Railbook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        } 
 
     public void showTableData() throws SQLException 
 {
     if(stat==1&&stat2==1){
        frame1 = new JFrame("AVAILABLE TRAINS");
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        frame1.setBackground(Color.red);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames); 
        table = new JTable();       
        table.setModel(model);
        table.setRowHeight(40);
        table.getColumn("TRAIN NO").setCellRenderer(new ButtonRenderer());
        table.getColumn("TRAIN NO").setCellEditor( new ButtonEditor(new JCheckBox()));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        table.setBackground(Color.cyan);
        TableColumn column = null;
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
        String query1 ="select train.T_No,T_Name,train.T_Type from\n" +
"station s1, station s2, route r1, route r2, schedule_days s, train\n" +
"where\n" +
"s1.s_name ='"+Source+"' and s2.s_name = '"+Destination+"' and s1.s_id = r1.s_id and s2.s_id = r2.s_id \n" +
"and r1.t_no = r2.t_no and (COALESCE(r1.journey_days,'') || COALESCE(r1.arrival,''))<(COALESCE(r2.journey_days,'')|| COALESCE(r2.arrival,'')) and train.t_no = s.t_no \n" +
"and day = '"+day.toUpperCase()+"' and train.t_no=r1.t_no and train.t_type='"+p+"'";          
         try( Statement tmt1=cont.createStatement())
         {            
             ResultSet r1=tmt1.executeQuery(query1);
               if(!r1.next()){
                   stat1=0;
                    JOptionPane.showMessageDialog(f1,"No Trains Available", "error", JOptionPane.ERROR_MESSAGE); 
              }
               else{
                       do{                     
                       String tno=r1.getString("T_NO");
                       String tname = r1.getString("T_NAME");
                       String ttype=r1.getString("T_TYPE");                      
                       System.out.println(tno); 
                       System.out.println(tname); 
                       System.out.println(ttype); 
                       model.addRow(new Object[]{tno,tname,ttype});
                       }while(r1.next());                       
        }
     }              
                                   
          // }
         catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        if(stat1==1){
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(800,300);
         }
        else
             frame1.setVisible(false);
     }
    }
    public static void main(String[] args) {
        Railbook p=new Railbook();
        p.compshow();
     }
    class ButtonRenderer extends JButton implements TableCellRenderer {
  public ButtonRenderer() {
    setOpaque(true);
  }
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
}
 class ButtonEditor extends DefaultCellEditor {
  protected JButton button;
  private String label;
  private boolean isPushed;
  public ButtonEditor(JCheckBox checkBox) {
    super(checkBox);
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }
  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    return button;
  }
  public Object getCellEditorValue() {
    if (isPushed) {
        try {
            tno1=button.getText().toString();
            showdata1();
        } catch (SQLException ex) {
            Logger.getLogger(Railbook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    isPushed = false;
    return new String(label);
  }
  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }
  protected void fireEditingStopped() {
    super.fireEditingStopped();
 }
}    
  public void showdata1()throws SQLException
  {       
        frame2 = new JFrame("ROUTE");
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setLayout(new BorderLayout());
        DefaultTableModel model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(columnNames1);
        table1 = new JTable();       
        table1.setModel(model1);
        table1.setRowHeight(40);
        table1.setBackground(Color.yellow);          
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setFillsViewportHeight(true);     
        JScrollPane scroll1 = new JScrollPane(table1);
        scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);        
               System.out.println(Source+" "+Destination+" "+tno1);
        String query1 ="with stationnames(s1,s2) as (select s.s_id,t.s_id from station s,station t where '"+Source+"'=s.s_name and '"+Destination+"'=t.s_name),arrivaltimes(a1,a2,a3,a4) as (select x.arrival,x.journey_days,y.arrival,y.journey_days from route x,route y,stationnames where y.t_no="+tno1+" and x.t_no="+tno1+" and stationnames.s1=x.s_id and stationnames.s2=y.s_id),tstations(sa,sb,sc,sd) as (select s_name,x.platformno,x.departure,x.arrival from stationnames,route x,station,arrivaltimes where station.s_id=x.s_id  and x.t_no="+tno1+" and (coalesce(x.journey_days,'')||coalesce(x.arrival,'')) between (coalesce(a2,'')||coalesce(a1,'')) and (coalesce(a4,'')||coalesce(a3,''))order by (coalesce(x.journey_days,'')||coalesce(x.arrival,''))) select sa,sb,sc,sd from tstations";
 
         try( Statement tmt1=cont.createStatement())
         {            
             ResultSet r1=tmt1.executeQuery(query1);              
            while(r1.next()){  
                      String tname=r1.getString("sa");                       
                      String tpno = r1.getString("sb");                      
                      String arr = r1.getString("sd");                      
                      String dep = r1.getString("sc");                     
                      model1.addRow(new Object[]{tname,tpno,arr,dep});              
              }             
           }
         catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame2.add(scroll1);
        frame2.setVisible(true);
        frame2.setSize(800,300);          
    }
  public void showdata2()throws SQLException
  {
      frame6 = new JFrame("TRAIN");
        frame6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame6.setLayout(new BorderLayout());
        DefaultTableModel model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(columnNames2);
        table2 = new JTable();       
        table2.setModel(model1);
        table2.setRowHeight(40);
        table2.setBackground(Color.yellow);          
        table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table2.setFillsViewportHeight(true);     
        JScrollPane scroll1 = new JScrollPane(table2);
        scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);        
                  String query1 ="select * from Train";
         try( Statement tmt1=cont.createStatement())
         {            
             ResultSet r1=tmt1.executeQuery(query1);              
            while(r1.next()){  
                      int tname=r1.getInt("T_NO");                       
                      String tpno = r1.getString("T_NAME");                      
                      String arr = r1.getString("T_TYPE");                                      
                      model1.addRow(new Object[]{tname,tpno,arr});              
              }             
           }
         catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame6.add(scroll1);
        frame6.setVisible(true);
        frame6.setSize(800,300);        
  }
   public void showdata3()throws SQLException
  {
      frame7 = new JFrame("STATION");
        frame7.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame7.setLayout(new BorderLayout());
        DefaultTableModel model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(columnNames3);
        table3 = new JTable();       
        table3.setModel(model1);
        table3.setRowHeight(40);
        table3.setBackground(Color.yellow);          
        table3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table3.setFillsViewportHeight(true);     
        JScrollPane scroll1 = new JScrollPane(table3);
        scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);        
              
        String query1 ="select * from Station";
 
         try( Statement tmt1=cont.createStatement())
         {            
             ResultSet r1=tmt1.executeQuery(query1);              
            while(r1.next()){  
                      int tname=r1.getInt("S_ID");                       
                      String tpno = r1.getString("S_NAME");                              
                      model1.addRow(new Object[]{tname,tpno});              
              }             
           }
         catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame7.add(scroll1);
        frame7.setVisible(true);
        frame7.setSize(800,300);       
  }
    public void showdata4()throws SQLException
  {
       frame8 = new JFrame("SCHEDULE");
        frame8.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame8.setLayout(new BorderLayout());
        DefaultTableModel model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(columnNames4);
        table4 = new JTable();       
        table4.setModel(model1);
        table4.setRowHeight(40);
        table4.setBackground(Color.yellow);          
        table4.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table4.setFillsViewportHeight(true);     
        JScrollPane scroll1 = new JScrollPane(table4);
        scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);        
               System.out.println(Source+" "+Destination+" "+tno1);
        String query1="select * from schedule_days";
         try( Statement tmt1=cont.createStatement())
         {            
             ResultSet r1=tmt1.executeQuery(query1);              
            while(r1.next()){  
                     int tname=r1.getInt("T_NO");                       
                      String tpno = r1.getString("DAY");                    
                      model1.addRow(new Object[]{tname,tpno});              
              }             
           }
         catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame8.add(scroll1);
        frame8.setVisible(true);
        frame8.setSize(800,300);      
  }
     public void showdata5()throws SQLException
  {
      
        frame9 = new JFrame("ROUTE");
        frame9.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame9.setLayout(new BorderLayout());
        DefaultTableModel model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(columnNames5);
        table5 = new JTable();       
        table5.setModel(model1);
        table5.setRowHeight(40);
        table5.setBackground(Color.yellow);          
        table5.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table5.setFillsViewportHeight(true);     
        JScrollPane scroll1 = new JScrollPane(table5);
        scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);        
        String query1 ="select * from route";
 
         try( Statement tmt1=cont.createStatement())
         {            
             ResultSet r1=tmt1.executeQuery(query1);              
            while(r1.next()){  
                      int tname=r1.getInt("S_ID");                       
                      int tpno = r1.getInt("T_NO");                      
                      int arr = r1.getInt("PLATFORMNO");                      
                      String dep = r1.getString("ARRIVAL"); 
                       String arr1 = r1.getString("DEPARTURE");                      
                      String dep1 = r1.getString("JOURNEY_DAYS");  
                      model1.addRow(new Object[]{tname,tpno,arr,dep,arr1,dep1});              
              }             
           }
         catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame9.add(scroll1);
        frame9.setVisible(true);
        frame9.setSize(800,300);       
  }
  }

