import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
class DataRetrival extends Frame implements ActionListener
{	
        JFrame f1,f2,f3;
        JComboBox c1,c2,c3;
	JButton b1,b2,b3,b11,b4;
        int ids;
        String ids2;
        TextField t1,t111,t112;
	JTextField t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l111,l112;
        JLabel lm;
        
	DataRetrival()
	{
		super();
                f1 = new JFrame("Data Retrival");
                f1.setLayout(new FlowLayout());
                setFont(new Font("Constantia",Font.PLAIN,20));
                
                lm=new JLabel("DATA RETRIVAL");
 		lm.setFont(new Font("Comic Sans MS",Font.BOLD,25));
 	        lm.setBounds(85,80,300,30);
                
		l1=new JLabel("Receipt No");
                l1.setBounds(80,150,100,20);
		t1=new TextField(100);
                t1.setBounds(200,150,100,20);
		b1=new JButton("Search Receipt");
                b1.setBounds(120,190,130,30);
                
                l111=new JLabel("Route No");
                l111.setBounds(80,260,100,20);
		t111=new TextField(100);
                t111.setBounds(200,260,100,20);
                l112=new JLabel("Bus Stop");
                l112.setBounds(80,300,100,20);
		t112=new TextField(100);
                t112.setBounds(200,300,100,20);
		b11=new JButton("Search Bus");
                b11.setBounds(120,340,130,30);
                
                b4=new JButton("Back");
                b4.setBounds(130,400,100,30);
		
		
                f1.add(lm);
		f1.add(l1);
		//f1.add(t1);
		f1.add(b1);
                f1.add(l111);
		//f1.add(t111);
                //f1.add(t112);
                f1.add(l112);
		f1.add(b11);
                f1.add(b4);
		//t1.setText("");
		Vector v = new Vector();
        Vector v3 = new Vector();
        Vector<String> v2 = new Vector<>();
//f1.pack();
                try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","meenakshi");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select RouteNo from Schedule");
        
            
            while (rs.next()) {
                ids = rs.getInt(1);
                if(!v.contains(ids))
                {
                v.add(ids);
                }
            }
            
            
            st.close();
            rs.close();
            con.close();
            
        } catch (Exception e) {
        }
                
                c1 = new JComboBox(v);
            c1.setBounds(200,260,100,20);
            f1.add(c1);
            
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
             try {
              
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","meenakshi");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select ReceiptNo from DataEntry");
            
             while (rs.next()) {
                ids = rs.getInt(1);
                if(!v3.contains(ids))
                {
                v3.add(ids);
                }
            }

            st.close();
            rs.close();
            con.close();
            
        } catch (Exception e) {
        }
            
            c3 = new JComboBox(v3);
            c3.setBounds(200,150,100,20);
            f1.add(c3);
            
            c2 = new JComboBox(v2);
            c2.setBounds(200,300,100,20);
            f1.add(c2);
            
                b1.addActionListener(this);
                b11.addActionListener(this);
                b4.addActionListener(this);
                setBackground(Color.lightGray);
                f1.setLayout(null);
                f1.setVisible(true);
                f1.setSize(430,570);
                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f1.setResizable(true);
		//f1.pack();
        }    

	public void actionPerformed(ActionEvent ae)
	{
		String str=ae.getActionCommand();
	
		try
		{
                    
                if(str.equals("Back"))
                {
                                f1.setVisible(false);
                                Options o = new Options();
                           
			}

		if(str.equals("Search Receipt"))
		{
			setVisible(false);
			setFont(new Font("Times New Roman",Font.PLAIN,20));		
			
                        int i=(int) c3.getSelectedItem();
			
                        l2=new JLabel("Receipt No");
                        l2.setBounds(100,40,100,20);
			t2=new JTextField(); 
			t2.setBounds(210,40,100,20);
                        
			l4=new JLabel("Name");
                        l4.setBounds(100,70,100,20);
			t4=new JTextField();
			t4.setBounds(210,70,100,20);
                        
			l7=new JLabel("Year");
                        l7.setBounds(100,100,100,20);
			t7=new JTextField();
			t7.setBounds(210,100,100,20);
                        
			l8=new JLabel("Department");
                        l8.setBounds(100,130,100,20);
			t8=new JTextField();
			t8.setBounds(210,130,100,20);
                        
			l9=new JLabel("Semester");
                        l9.setBounds(100,160,100,20);
			t9=new JTextField();
			t9.setBounds(210,160,100,20);
                        
			l10=new JLabel("Fees Paid");
                        l10.setBounds(100,190,100,20);
			t10=new JTextField();
			t10.setBounds(210,190,100,20);
                        
			l11=new JLabel("Dues");
                        l11.setBounds(100,220,100,20);
			t11=new JTextField();
			t11.setBounds(210,220,100,20);
                        
			l12=new JLabel("Route No");
                        l12.setBounds(100,250,100,20);
			t12=new JTextField();
                        t12.setBounds(210,250,100,20);
                        
                        l3=new JLabel("Stop Name");
                        l3.setBounds(100,280,100,20);
			t3=new JTextField();
			t3.setBounds(210,280,100,20); 
			
                        l6=new JLabel("Time");
                        l6.setBounds(100,310,100,20);
			t6=new JTextField();
			t6.setBounds(210,310,100,20);
                        
			b2=new JButton("Done");
			b2.setBounds(100,350,70,30);
                        
                        b3=new JButton("Back");
			b3.setBounds(240,350,70,30);
                        
                        f2 = new JFrame("Data Retrival");
                        f2.setLayout(new FlowLayout());
                        f1.setVisible(false);
                        
			f2.add(l2);
			f2.add(t2);
			f2.add(l4);
			f2.add(t4);
			f2.add(l7);
			f2.add(t7);
			f2.add(l8);
			f2.add(t8);
			f2.add(l9);
			f2.add(t9);
			f2.add(l10);
			f2.add(t10);
			f2.add(l11);
			f2.add(t11);
			f2.add(l12);
			f2.add(t12);
			f2.add(l3);
			f2.add(t3);
			f2.add(l6);
			f2.add(t6);
			f2.add(b2);
			f2.add(b3);
                        
                        b3.addActionListener(this);
			b2.addActionListener(this);
			setBackground(Color.lightGray);
                        f2.setLayout(null);
                        f2.setVisible(true);
                        f2.setSize(500,500);
                        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        f2.setResizable(true);
			//f2.pack();
                        
                        Class.forName("oracle.jdbc.driver.OracleDriver");  
                        Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","meenakshi");
			String a="select * from DataEntry where (ReceiptNo="+i+") ";
                        Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(a);
                        while(rs.next())
			   {
				
				String s1=rs.getString(2);
				 t4.setText(""+s1);
				int s2=rs.getInt(3);
				 t7.setText(""+s2);
				String s3=rs.getString(4);
				 t8.setText(""+s3);
				int s4=rs.getInt(5);
				 t9.setText(""+s4);
				String s5=rs.getString(6);
				 t10.setText(""+s5);
				int s6=rs.getInt(7);
				 t11.setText(""+s6);
				int s7=rs.getInt(8);
				 t12.setText(""+s7);
				String s8=rs.getString(9);
                                 t3.setText(""+s8);
				String s9=rs.getString(10);
                                 t6.setText(""+s9);
                                 t2.setText(""+i);
				
			   }
			   
			}
                
                if(str.equals("Search Bus"))
                {
                   setVisible(false);
			setFont(new Font("Times New Roman",Font.PLAIN,20));		
			
                        int i=(int) c1.getSelectedItem();
                        String j = (String) c2.getSelectedItem();
                        
			l12=new JLabel("Route No");
                        l12.setBounds(100,150,100,20);
			t12=new JTextField();
                        t12.setBounds(210,150,100,20);
                        
                        l3=new JLabel("Stop Name");
                        l3.setBounds(100,180,100,20);
			t3=new JTextField();
			t3.setBounds(210,180,100,20); 
			
                        l6=new JLabel("Time");
                        l6.setBounds(100,210,100,20);
			t6=new JTextField();
			t6.setBounds(210,210,100,20);
                        
			b2=new JButton("Done");
			b2.setBounds(100,260,70,30);
                        
                        b3=new JButton("Back");
			b3.setBounds(240,260,70,30);
                        
                        f2 = new JFrame("Data Retrival");
                        f2.setLayout(new FlowLayout());
                        f1.setVisible(false);
                      
			f2.add(l12);
			f2.add(t12);
			f2.add(l3);
			f2.add(t3);
			f2.add(l6);
			f2.add(t6);
			f2.add(b2);
			f2.add(b3);
                        
                        b3.addActionListener(this);
			b2.addActionListener(this);
			setBackground(Color.lightGray);
                        f2.setLayout(null);
                        f2.setVisible(true);
                        f2.setSize(500,500);
                        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        f2.setResizable(true);
			//f2.pack();
                        
                        Class.forName("oracle.jdbc.driver.OracleDriver");  
                        Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","meenakshi");
			String a="select * from Schedule where (RouteNo="+i+" and BusStop='"+j+"') ";
                        Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(a);
                        while(rs.next())
			   {
				
				int s1=rs.getInt(1);
				 t12.setText(""+s1);
				String s2=rs.getString(2);
				 t3.setText(""+s2);
				String s3=rs.getString(3);
				 t6.setText(""+s3);
			   } 
                }

                        if(str.equals("Done"))
			{
           
                            f2.setVisible(false);
                            f1.setVisible(false);
                            Options o=new Options();
                        }
                
			if(str.equals("Back"))
			{
				f2.setVisible(false);
                                f1.setVisible(false);
                                DataRetrival dr = new DataRetrival();
                           
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

	public static void main(String args[])
	{
		DataRetrival dr=new DataRetrival();
	}

}

	
