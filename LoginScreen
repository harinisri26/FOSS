import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LoginScreen extends Frame implements ActionListener
{
	JFrame f;
        JButton ok,can;
	JTextField txt_user;
        TextField txt_pwd;
	JLabel lbl_user,lbl_pwd,l2;
	
	LoginScreen()
	{
		super();
                f = new JFrame("Login Screen");
		setFont(new Font("Constantia",Font.PLAIN,14));
 	
		JLabel l1; 
 	
 		l1=new JLabel("LOGIN SCREEN");
 		l1.setFont(new Font("Comic Sans MS",Font.BOLD,25));
 	        l1.setBounds(100,100,300 ,30);
		setLayout(new FlowLayout());
		lbl_user=new JLabel("Username ");
		lbl_user.setBounds(100,200,70,30);
		lbl_pwd=new JLabel("Password ");
                lbl_pwd.setBounds(100,250,70,30);
		txt_user=new JTextField(20);
                txt_user.setBounds(180,200,100,30);
		txt_pwd=new TextField(20);
                txt_pwd.setBounds(180,250,100,30);
		txt_pwd.setEchoChar('*');
		ok=new JButton("Login");
                ok.setBounds(100,300,80,30);
		can=new JButton("Cancel");
                can.setBounds(200,300,80,30);
		
		f.add(l1);
		f.add(lbl_user);
		f.add(txt_user);
		f.add(lbl_pwd);
		f.add(txt_pwd);
		f.add(ok);
		f.add(can);
		

		ok.addActionListener(this);
		can.addActionListener(this);
		setBackground(Color.green);
                f.setLayout(null);
                f.setVisible(true);
                f.setSize(400,500);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setResizable(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==ok)
		{
			if((txt_user.getText().equals("Admin"))&&(txt_pwd.getText().equals("bus")))
			{
				f.setVisible(false);
				Options o=new Options();
			}
			 else 
			{
		
                                l2=new JLabel("Check the Login Details");
				l2.setLocation(100,350);
                                f.add(l2);
				f.setVisible(true);

			}
		}
		if(ae.getSource()==can)
		{
			System.exit(0);
		}
	}

	public static void main(String args[])
	{
		
		LoginScreen ls=new LoginScreen();
		ls.addWindowListener(new winExit());
	}
};
	class winExit extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	};
