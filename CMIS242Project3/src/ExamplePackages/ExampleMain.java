/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamplePackages;

/**
 * @author Valimere
 */
import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class ExampleMain 
{
//Example13


public class Example13 {
	private static final String window_title = "RadioButton & TextField";
	private static final int window_width = 640;
	private static final int window_height = 400;
	private static final String rb1_title = "abc";
	private static final String rb2_title = "xyz";
	private static final String data1 = "AAAAAA";
	private static final String data2 = "ZZZZZZZZZZZZ";
	private static final int tf_size = 20;
	JTextField tf = new JTextField("AAAAAA", Example13.tf_size);

	// main
	public static void main(final String ar[]) {
		final Example13 sample = new Example13();
	}

	// constructor
	public Example13() {
		// make frame
		final JFrame f = new JFrame(Example13.window_title);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// make radiobutton
		final JRadioButton rb1 = new JRadioButton(Example13.rb1_title, true);
		final JRadioButton rb2 = new JRadioButton(Example13.rb2_title);
		// add radiobutton to buttongroup
		final ButtonGroup bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		// add itemlistener
		rb1.addItemListener(new SelectItemListener());
		rb2.addItemListener(new SelectItemListener());
		// layout
		final JPanel p = new JPanel();
		p.add(rb1);
		p.add(rb2);
		f.getContentPane().add(p, BorderLayout.NORTH);
		final JPanel p2 = new JPanel();
		p2.add(this.tf);
		f.getContentPane().add(p2, BorderLayout.CENTER);
		// show frame
		f.setSize(Example13.window_width, Example13.window_height);
		f.setVisible(true);
	}

	// event receive itemlistener
	class SelectItemListener implements ItemListener {
		public void itemStateChanged(final ItemEvent e) {
			// get object
			final AbstractButton sel = (AbstractButton) e.getItemSelectable();
			// checkbox select or not
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (sel.getText().equals(Example13.rb1_title)) {
					Example13.this.tf.setText(Example13.data1);
				} else if (sel.getText().equals(Example13.rb2_title)) {
					Example13.this.tf.setText(Example13.data2);
				}
			}
		}
	}
}

.

    
}
