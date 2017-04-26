import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class BusPass extends JFrame implements ActionListener {
     int i=0,n=0;
    JFrame f1,f2;
    JLabel  l1, l2,lm;
    JComboBox c1,c2;
    JButton b1,b2,b3,b4;
    Connection con;
    ResultSet rs, rs1,rsa,rsb;
    Statement st, st1;
    PreparedStatement pst;
    int ids;
    static JTable table;    String[] columnNames = {"RouteNo", "BusStop", "Time"};
    String[] columnNames2 = {"ReceiptNo","Name","Year","Dept","Semester","Fees Paid","Dues","RouteNo", "BusStop", "Time"};
    int from;
 
    BusPass() {
        f1 = new JFrame("View Student Records");
        f1.setLayout(new FlowLayout());
        setFont(new Font("Constantia",Font.PLAIN,20));
     
                
        lm=new JLabel("DATABASES");
        lm.setFont(new Font("Comic Sans MS",Font.BOLD,25));
 	lm.setBounds(100,60,300,30);
        
        l1 = new JLabel("Select Receipt No");
        l1.setBounds(75, 110, 75, 20);
         
        b1 = new JButton("Bus Schedules");
        b2 = new JButton("Student Records");
        b3 = new JButton("Back");
        
        b1.setBounds(100, 150, 150, 30);
        b1.addActionListener(this);
        b2.setBounds(100,200,150,30);
        b2.addActionListener(this);
        b3.setBounds(137,260,70,30);
        b3.addActionListener(this);
 
        setBackground(Color.lightGray);
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setSize(370,400);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setResizable(true);
 
        //f1.add(l1);
        f1.add(b1);
        f1.add(lm);
        f1.add(b2);
        f1.add(b3);
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","meenaksh");
            st = con.createStatement();
            rs = st.executeQuery("select RouteNo from Schedule");
            Vector v = new Vector();
            while (rs.next()) {
                ids = rs.getInt(1);
                v.add(ids);
            }
             
            c1 = new JComboBox(v);
            c1.setBounds(200, 200, 150, 20);
 
            
            c1.addItemListener((ItemListener) this);
            f1.add(c1);
            
               st.close();
            rs.close();
            con.close();
        } catch (Exception e) {
        }
            
            try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","meenaksh");
            st = con.createStatement();
            rs = st.executeQuery("select ReceiptNo from DataEntry");
            Vector v2 = new Vector();
            while (rs.next()) {
                ids = rs.getInt(1);
                v2.add(ids);
            }
            
            c2 = new JComboBox(v2);
            c2.setBounds(200, 500, 150, 20);
 
            
            c2.addItemListener((ItemListener) this);
            f1.add(c2);
            st.close();
            rs.close();
        } catch (Exception e) {
        }
    }
 
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            showTableData1();
        }
        
        if (ae.getSource() == b2) {
            showTableData2();
        }
        
        if (ae.getSource() == b3) {
            f1.setVisible(false);
            Options o = new Options();
        }
        
        if (ae.getSource() == b4) {
            Options o = new Options();
        }
 
    }
 
    public void showTableData1() {
      
        f2 = new JFrame("Database Result");
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setLayout(new BorderLayout());
//TableModel tm = new TableModel();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //from = (int) c1.getSelectedItem();

        int route = 0;
        String stop = "";
        String time = "";
    
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","meenakshi");
            st = con.createStatement();
            rsa = st.executeQuery("select RouteNo from Schedule");
            Vector v = new Vector();
            
            while (rsa.next()) {
                ids = rsa.getInt(1);
                v.add(ids);
                n++;
            }
            
            while (i<=n)
            {
            pst = con.prepareStatement("select * from Schedule where RouteNo=" + v.elementAt(i) + "");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                route = rs.getInt(1);
                stop = rs.getString(2);
                time = rs.getString(3);
           
                model.addRow(new Object[]{route, stop, time});
                i++;
            }
            if (i < 1) {
                //JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            }
            rs.close();
            rsa.close();
            con.close();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        f2.add(scroll);
        f2.setVisible(true);
        f2.setSize(400, 800);
    }
 
    public void showTableData2() {
      
        f2 = new JFrame("Database Result");
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames2);

        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //from = (int) c2.getSelectedItem();

        int receipt = 0;
        String name = "";
        int year = 0;
        String dept = "";
        int sem = 0;
        String fees = "";
        int dues = 0;
        int route = 0;
        String stop = "";
        String time = "";
    
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","system");
            st = con.createStatement();
            rsb = st.executeQuery("select ReceiptNo from DataEntry");
            Vector v = new Vector();
            //n=0;
            //i=0;
            while (rsb.next()) {
                ids = rsb.getInt(1);
                v.add(ids);
                n++;
            }
           
            while (i<=n)
            {
            pst = con.prepareStatement("select * from DataEntry where ReceiptNo=" +v.elementAt(i)+ "");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                
                receipt = rs.getInt(1);
                name = rs.getString(2);
                year = rs.getInt(3);
                dept = rs.getString(4);
                sem = rs.getInt(5);
                fees = rs.getString(6);
                dues = rs.getInt(7);
                route = rs.getInt(8);
                stop= rs.getString(9);
                time = rs.getString(10);
           
                model.addRow(new Object[]{receipt,name,year,dept,sem,fees,dues,route, stop, time});
                i++;
            }
            if (i < 1) {
               // JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            }
            rs.close();
            rsb.close();
            con.close();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        b4 = new JButton("Back");
        b4.setBounds(380,750,80,30);
        b4.addActionListener(this);
        
        f2.add(b4);
        f2.add(scroll);
        f2.setVisible(true);
        f2.setSize(800, 800);
    }
    
    public static void main(String args[]) {
        new BusPass();
    }
}
