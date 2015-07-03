package graphics;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public abstract class ListAll extends JPanel {

	protected int elNum;
	protected JTable elements;
	protected CardLayout cl;
	protected JButton show;
	protected JLabel warning;
	protected JPanel select;
	protected JScrollPane pane;
	
	public ListAll() {
		this.setLayout(new CardLayout());
		this.setSize(new Dimension(480, 400));
		
		select = new JPanel();
		select.setLayout(null);
		select.setSize(new Dimension(480, 400));
		
		this.add(select, "default");
		
	    warning = new JLabel("\u06AF\u0632\u06CC\u0646\u0647 \u0627\u06CC \u0628\u0631\u0627\u06CC \u0646\u0645\u0627\u06CC\u0634\u060C \u0627\u0646\u062A\u062E\u0627\u0628 \u0646\u0634\u062F\u0647 \u0627\u0633\u062A.");
	    warning.setHorizontalAlignment(SwingConstants.CENTER);
	    warning.setForeground(Color.RED);
	    warning.setBounds(20, 334, 450, 14);
	    warning.setVisible(false);
        
        cl = (CardLayout)(this.getLayout());
        cl.show(this, "default");
	    
	    show = new JButton("\u0645\u0634\u0627\u0647\u062F\u0647");
	    show.setSize(90, 30);
	    show.setLocation(380, 360);
	    show.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
    			warning.setVisible(false);
	    		int ind = elements.getSelectedRow();
	    		if(ind == -1)
	    		{
	    			warning.setVisible(true);
	    		}
	    		else
	    		{
	    			cl.show(ListAll.this, "#" + ind);
	    		}
	    	}
	    });

	    elements = new JTable();
		elements.setRowSelectionAllowed(true);
        elements.setRowHeight( 32 );

	    pane = new JScrollPane(elements);
	    pane.setSize(460, 315);
	    pane.setLocation(10, 10);
	    pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
	    select.add(pane);
	    select.add(show);
	    select.add(warning);
	}
	
	protected Callable<Void> notice = new Callable<Void>() {
        public Void call() {
        	fill();
            cl.show(ListAll.this, "default");
			return null;
        }
    };
    
    public void fill() {
        cl.show(this, "default");
    	select.remove(pane);
    	make_elements();
		elements.setRowSelectionAllowed(true);
        elements.setRowHeight( 32 );

	    pane = new JScrollPane(elements);
	    pane.setSize(460, 315);
	    pane.setLocation(10, 10);
	    pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    select.add(pane);
	    repaint();
    }
    
	protected abstract void make_elements();
}
