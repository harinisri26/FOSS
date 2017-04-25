import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.print.*;

class DataEntry extends Frame implements ActionListener{
        JFrame f,f2;
        int ids;
        String ids2;
        int cnt=13200;
	JButton ad1,bac,b2,b3;
        JLabel dl;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,lab,lb;
	TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
        //String s3,s5,s9,s7,s12;
        //int s4,s6,s8,s10,s11;
	JComboBox ch,ch2,c1,c2,c3;
	
	public DataEntry()
	{

		super();
		f = new JFrame("Data Entry");
                f.setLayout(new FlowLayout());
                setFont(new Font("Times New Roman",Font.PLAIN, 20));
                
		try{
                Class.forName("oracle.jdbc.driver.OracleDriver");  
                Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","meenakshi");  
                Statement st=con.createStatement();   
		ResultSet rs=st.executeQuery("select * from DataEntry");

		while(rs.next())
		{
			cnt++;
		}
		cnt=cnt+10;
                con.close();
		}catch(Exception e5){
			e5.printStackTrace();
		}
		
		ad1=new JButton("Add");
                ad1.setBounds(115,340,80,30);
		bac=new JButton("Back");
                bac.setBounds(220,340,80,30);
		
                l8=new JLabel("Receipt No");
                l8.setBounds(100,40,100,20);
		f.add(l8);
		t8=new TextField();
                t8.setBounds(210,40,100,20);
		t8.setText(""+cnt);
		f.add(t8);
                
		l3=new JLabel("Name");
                l3.setBounds(100,70,100,20);
		f.add(l3);
		t3=new TextField();
                t3.setBounds(210,70,100,20);
		f.add(t3);
		
		l4=new JLabel("Year");
                l4.setBounds(100,100,100,20);
		f.add(l4);
		t4=new TextField();
                t4.setBounds(210,100,100,20);
		f.add(t4);
		
		l5=new JLabel("Department");
                l5.setBounds(100,130,100,20);
		f.add(l5);
                
                Vector<String> v = new Vector<>();
                v.add("CSE");
                v.add("MECH");
                v.add("ECE");
                v.add("AERO");
                v.add("EEE");
		ch=new JComboBox(v);
                ch.setBounds(210,130,100,20);
		f.add(ch);
		
		l6=new JLabel("Semester");
                l6.setBounds(100,160,100,20);
		f.add(l6);
		t6=new TextField();
                t6.setBounds(210,160,100,20);
		f.add(t6);

		l9=new JLabel("Fees Paid");
                l9.setBounds(100,190,100,20);
		f.add(l9);
                Vector<String> p = new Vector<>();
                p.add("Yes");
                p.add("No");
		ch2=new JComboBox(p);
                ch2.setBounds(210,190,100,20);
		f.add(ch2);
		
		l10=new JLabel("Dues");
                l10.setBounds(100,220,100,20);
		f.add(l10);
		t10=new TextField();
                t10.setBounds(210,220,100,20);
		f.add(t10);
		
		l11=new JLabel("Route No");
                l11.setBounds(100,250,100,20);
		f.add(l11);
		t11=new TextField();
                
                Vector v1 = new Vector();
                try {
              
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","meenakshi");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select RouteNo from Schedule");
            
             while (rs.next()) {
                ids = rs.getInt(1);
                if(!v1.contains(ids))
                {
                v1.add(ids);
                }
            }

            st.close();
            rs.close();
            con.close();
            
        } catch (Exception e) {
        }
           
                c1 = new JComboBox(v1);
                //c1.setSelectedIndex(-1);
                c1.setBounds(210,250,100,20);
		f.add(c1);
                
                l7=new JLabel("Bus Stop");
                l7.setBounds(100,280,100,20);
		f.add(l7);
		t7=new TextField();
                
                Vector<String> v2 = new Vector<>();
                try {
              
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","meenakshi");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select BusStop from Schedule");
            
             while (rs.next()) {
                ids2 = rs.getString(1);
                if(!v2.contains(ids2))
                {
                v2.add(ids2);
                }
            }

            st.close();
            rs.close();
            con.close();
            
        } catch (Exception e) {
        }
           
              
                c2 = new JComboBox(v2);
                c2.setBounds(210,280,100,20);
		f.add(c2);

		l12=new JLabel("Bus Time");
                l12.setBounds(100,310,100,20);
		f.add(l12);
		t12=new TextField();
                
                Vector<String> v3 = new Vector<>();
                try {
              
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","meenakshi");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Time from Schedule");
            
             while (rs.next()) {
                ids2 = rs.getString(1);
                if(!v3.contains(ids2))
                {
                v3.add(ids2);
                }
            }

            st.close();
            rs.close();
            con.close();
            
        } catch (Exception e) {
        }
           
                c3 = new JComboBox(v3);
                c3.setBounds(210,310,100,20);
		f.add(c3);
		
		
		f.add(bac);
		f.add(ad1);
		
		ad1.addActionListener(this);
		bac.addActionListener(this);
                         
		setBackground(Color.lightGray);
                f.setLayout(null);
                f.setVisible(true);
                f.setSize(500,500);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setResizable(true);
                
                 
 
                
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		String str=e.getActionCommand();
               
                try{
		if(str.equals("Add"))
		{
                    
                    try{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
                        try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","meenakshi")) {
                            PreparedStatement st = con.prepareStatement("insert into DataEntry values (?,?,?,?,?,?,?,?,?,?)");
                            
                            int s8=Integer.parseInt(t8.getText());
                            
                            String s3=t3.getText();
                            
                            int s4=Integer.parseInt(t4.getText());
                            
                            String s5=(String)ch.getSelectedItem();
                            
                            int s6=Integer.parseInt(t6.getText());
                            
                            String s9=(String) ch2.getSelectedItem();
                            
                            int s10=Integer.parseInt(t10.getText());
                            
                            int s11=(int) c1.getSelectedItem();
                            
                            String s7=(String) c2.getSelectedItem();
                            
                            String s12=(String) c3.getSelectedItem();
                            
                            
                            st.setInt(1,s8);
                            st.setString(2,s3);
                            st.setInt(3,s4);
                            st.setString(4,s5);
                            st.setInt(5,s6);
                            st.setString(6,s9);
                            st.setInt(7, s10);
                            st.setInt(8, s11);
                            st.setString(9,s7);
                            st.setString(10, s12);
                            st.executeUpdate();
                            
                            
                            con.commit();
                        }
                
		}catch(Exception t)
		{
			t.printStackTrace();
        
                }
                       
                   b2=new JButton("Done");
			b2.setBounds(100,150,70,30);
                        
                        b3=new JButton("Back");
			b3.setBounds(240,150,70,30);
                        
                        dl = new JLabel("Added Successfully");
                        dl.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
                        dl.setBounds(130,100,150,30);
                        
                        f2 = new JFrame("Data Entry");
                        f2.setLayout(new FlowLayout());
                        f.setVisible(false);
                        
		
			f2.add(b2);
			f2.add(b3);
                        f2.add(dl);
                        
                        b3.addActionListener(this);
			b2.addActionListener(this);
			setBackground(Color.lightGray);
                        f2.setLayout(null);
                        f2.setVisible(true);
                        f2.setSize(420,330);
                        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        f2.setResizable(true);
                       
         
		}
                
		if(str.equals("Back"))
		{
			f.setVisible(false);
			Options o=new Options();
		}
                
                if(str.equals("Done"))
		{
			f.setVisible(false);
			DataEntry o=new DataEntry();
		}

	}catch(Exception e3){
		e3.printStackTrace();
	}

	
	}


	public static void main(String args[])
	{
		DataEntry d1=new DataEntry();
		d1.addWindowListener(new winExit5());
	}

    public void addfn() {
         
                             
                    
               
                
    }

}

        class winExit5 extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	};
