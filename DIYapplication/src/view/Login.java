package view;

import javax.swing.*;

import model.Model;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.Controller;

/**
 * 
 * @author zheli
 *
 */
public class Login extends JFrame {
	/**
	 * ID.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * user's first name.
	 */
	private JTextField myFirstName;
	/**
	 * user's email address.
	 */
	private JTextField myEmailAddress;
	/**
	 * error message 1.
	 */
	private JLabel myErrorMessage1;
	/**
	 * error message 2.
	 */
	private JLabel myErrorMessage2;
	/**
	 * ok button.
	 */
	private JButton myOkButton;
	/**
	 * cancel button.
	 */
	private JButton myCancelButton;
	/**
	 * controller.
	 */
	private Controller myController;

	/**
	 * @author Zhe Li
	 */
	public Login() {
		// set up gui stuff.
		myFirstName = new JTextField(12);
		myEmailAddress = new JTextField(12);
		myErrorMessage1 = new JLabel("Inputs can't contain any space");
		myErrorMessage1.setForeground(Color.RED);
		myErrorMessage2 = new JLabel("Inputs can't be empty");
		myErrorMessage2.setForeground(Color.RED);
		myOkButton = new JButton("Ok");
		myCancelButton = new JButton("Cancel");
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		this.setLayout(new GridLayout(4, 1));

		panel1.add(new JLabel("First Name"));
		panel1.add(myFirstName);
		panel2.add(new JLabel("Email Address"));
		panel2.add(myEmailAddress);
		panel3.add(myOkButton);
		panel3.add(myCancelButton);
		// panel4.add(myErrorMessage1);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		panel4.setVisible(false);
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Login");
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// add action listener.
		myOkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (myFirstName.getText().contains(" ") || myEmailAddress.getText().contains(" ")) {
					panel4.setVisible(false);
					panel4.removeAll();
					panel4.add(myErrorMessage1);
					panel4.setVisible(true);

				} else if (myFirstName.getText().equals("") || myEmailAddress.getText().equals("")) {
					panel4.setVisible(false);
					panel4.removeAll();
					panel4.add(myErrorMessage2);
					panel4.setVisible(true);
				} else {
					panel4.setVisible(false);
					dispose();
					final View view = new View(myController);
					final Model model = new Model(myFirstName.getText(), myEmailAddress.getText());
					myController.loginSuccess(view, model);
				}
			}

		});
		// add action listener.
		myCancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
	}

	/**
	 * @author Zheli
	 * @param theController the controller.
	 */
	// set up controller.
	public void assignController(final Controller theController) {
		myController = theController;
	}
}