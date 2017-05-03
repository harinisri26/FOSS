import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
class DeleteRec2 extends Frame implements ActionListener
{	
        JFrame f1,f2,f3;
	JButton b1,b2,b3,b11,b4;
        TextField t1,t111,t112;
	JLabel l1,l2,l111,l112;
        JLabel d1,d2;
        JLabel lm;
        JComboBox c1,c2,c3;
        int ids;
        String ids2;

        
	DeleteRec2()
	{
		super();
                f1 = new JFrame("Delete Record");
                f1.setLayout(new FlowLayout());
                setFont(new Font("Constantia",Font.PLAIN,20));
                
                lm=new JLabel("DELETION");
 		lm.setFont(new Font("Comic Sans MS",Font.BOLD,25));
 	        lm.setBounds(85,80,300,30);
                
		l1=new JLabel("Receipt No");
                l1.setBounds(80,150,100,20);
		t1=new TextField(100);
                t1.setBounds(200,150,100,20);
		b1=new JButton("Delete Receipt");
                b1.setBounds(120,190,130,30);
                
                l111=new JLabel("Route No");
                l111.setBounds(80,260,100,20);
		t111=new TextField(100);
                t111.setBounds(200,260,100,20);
                l112=new JLabel("Bus Stop");
                l112.setBounds(80,300,100,20);
		t112=new TextField(100);
                t112.setBounds(200,300,100,20);
		b11=new JButton("Delete Bus");
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

		if(str.equals("Delete Receipt"))
		{
			setVisible(false);
			setFont(new Font("Times New Roman",Font.PLAIN,20));		
			
                        //int i=Integer.parseInt(t1.getText());
			int i =(int) c3.getSelectedItem();
                        
                        
			b2=new JButton("Done");
			b2.setBounds(100,150,70,30);
                        
                        b3=new JButton("Back");
			b3.setBounds(240,150,70,30);
                        
                        d1 = new JLabel("Deletion Successful");
                        d1.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
                        d1.setBounds(130,100,150,30);
                        
                        f2 = new JFrame("Delete Records");
                        f2.setLayout(new FlowLayout());
                        f1.setVisible(false);
                        
		
			f2.add(b2);
			f2.add(b3);
                        f2.add(d1);
                        
                        b3.addActionListener(this);
			b2.addActionListener(this);
			setBackground(Color.lightGray);
                        f2.setLayout(null);
                        f2.setVisible(true);
                        f2.setSize(420,330);
                        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        f2.setResizable(true);
			//f2.pack();
                        try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");  
                        Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","meenakshi");
			String a="delete from DataEntry where (ReceiptNo="+i+") ";
                        Statement st=con.createStatement();
			st.executeUpdate(a);
                        con.commit();
                        st.close();
                        con.close();
                        }
                        catch (Exception e) {
                            }
			   
			}
                
                if(str.equals("Delete Bus"))
                {
                   setVisible(false);
			setFont(new Font("Times New Roman",Font.PLAIN,20));		
			
                        int i =(int) c1.getSelectedItem();
                        //int i=Integer.parseInt(t111.getText());
                        String j = (String) c2.getSelectedItem();
                        //String j = t112.getText();
                   
                        
			b2=new JButton("Done");
			b2.setBounds(100,150,70,30);
                        
                        b3=new JButton("Back");
			b3.setBounds(240,150,70,30);
                        
                        d1 = new JLabel("Deletion Successful");
                        d1.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
                        d1.setBounds(130,100,150,30);
                        
                        f2 = new JFrame("Delete Records");
                        f2.setLayout(new FlowLayout());
                        f1.setVisible(false);
                        
		
			f2.add(b2);
			f2.add(b3);
                        f2.add(d1);
                        
                        b3.addActionListener(this);
			b2.addActionListener(this);
			setBackground(Color.lightGray);
                        f2.setLayout(null);
                        f2.setVisible(true);
                        f2.setSize(420,330);
                        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        f2.setResizable(true);
			//f2.pack();
                        
                        try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");  
                        Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","meenakshi");
			String a="delete from Schedule where (RouteNo="+i+"and BusStop='"+j+"') ";
                        Statement st=con.createStatement();
			st.executeUpdate(a);
                        con.commit();
                        st.close();
                        con.close();
                        }
                        catch (Exception e) {
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
                                DeleteRec2 dr = new DeleteRec2();
                           
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

	public static void main(String args[])
	{
		DeleteRec2 dr=new DeleteRec2();
	}

}

	
