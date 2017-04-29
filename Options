import java.awt.*;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

class Options extends Frame implements ItemListener
{
	ButtonGroup group;
        JRadioButton de,dr,vbs,bp,mod;
        JFrame f;
        JLabel l1;
	public Options()
	{
		super();
                f = new JFrame("Main Menu");
                f.setLayout(new FlowLayout());
                
                l1=new JLabel("MAIN MENU");
 		l1.setFont(new Font("Comic Sans MS",Font.BOLD,25));
 	        l1.setBounds(90,80,300 ,30);
                
		setFont(new Font("Constantia",Font.PLAIN,20));
		ButtonGroup group = new ButtonGroup();
		de=new JRadioButton("Data Entry");
                de.setBounds(100,150,200,20);
		dr=new JRadioButton("Data Retrival");
                dr.setBounds(100,180,200,20);
                bp=new JRadioButton("View Databases");
                bp.setBounds(100,210,200,20);
                vbs=new JRadioButton("Delete Records");
                vbs.setBounds(100,240,200,20);
                mod=new JRadioButton("Modify Receipt");
                mod.setBounds(100,270,200,20);
                
                f.add(l1);
		f.add(de);
                f.add(dr);
                f.add(bp);
                f.add(vbs);
                f.add(mod);
		
		de.addItemListener(this);
		dr.addItemListener(this);
		bp.addItemListener(this);
		vbs.addItemListener(this);
                mod.addItemListener(this);
         
                
		setBackground(Color.lightGray);
                f.setLayout(null);
                f.setVisible(true);
                f.setSize(390,430);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setResizable(true);
                
                
	}
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==de)
		{
			f.setVisible(false);
			DataEntry d=new DataEntry();
		}
                
                if(ie.getSource()==mod)
		{
			f.setVisible(false);
			Modify d=new Modify();
		}
		
		if(ie.getSource()==vbs)
		{
			f.setVisible(false);
			DeleteRec2 b=new DeleteRec2();
		}
		
		if(ie.getSource()==dr)
		{
			f.setVisible(false);
			DataRetrival dr1=new DataRetrival();
		}
		
                if(ie.getSource()==bp)
		{
			f.setVisible(false);
			BusPass bp1=new BusPass();
		}
	}	
	
	public static void main(String args[])
	{
		Options o=new Options();
		o.addWindowListener(new winExit1());
	}

};
class winExit1 extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	};
