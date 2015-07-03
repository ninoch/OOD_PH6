package graphics;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.concurrent.Callable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public abstract class Layout extends JFrame {


	protected JPanel menu;
	protected JPanel content;
	protected CardLayout cl;
	
	public Layout() {
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 480);
		
		GridBagLayout myLayout = new GridBagLayout();  
		getContentPane().setLayout(myLayout);  
		
		menu = new JPanel();
		menu.setBorder(new EmptyBorder(5, 5, 5, 5));
		menu.setPreferredSize(new Dimension(490, 30));
		menu.setMinimumSize(new Dimension(490, 30));
		menu.setLayout(null);
		
		content = new JPanel (new CardLayout());
		content.setPreferredSize(new Dimension(480, 400));
		content.setMinimumSize(new Dimension(480, 400));
        cl = (CardLayout)(content.getLayout());
        cl.show(content, "default");
        
        
        
        // Adding to fram
        GridBagConstraints c1 = new GridBagConstraints();
        GridBagConstraints c2 = new GridBagConstraints();
        
        c1.fill = GridBagConstraints.HORIZONTAL;
        c2.fill = GridBagConstraints.HORIZONTAL;
        
        c1.gridx = 0;
        c1.gridy = 0;
        c1.insets = new Insets(1,1,1,1);
        getContentPane().add(menu, c1);
        
        c2.gridx = 0;
        c2.gridy = 1;
        c2.insets = new Insets(10,10,10,10);
        getContentPane().add(content, c2);
	}
	
	protected Callable<Void> notice = new Callable<Void>() {
        public Void call() {
            cl.show(content, "default");
			return null;
        }
    };
}
