import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class TextbookStoreMain {

	private JFrame frame;
	private JTextField SKU;
	private JTextField name;
	private JTextField price;
	private JTextField qty;
	private JButton addBtn;
	private JButton removeBtn;
	private JButton findBtn;
	private JButton inventoryBtn;
	private JTextField errorMsg;
	private ArrayList<Textbook> inventory = new ArrayList<Textbook>();
	Integer newSKU;
	String newName;
	Double newPrice;
	Integer newQty;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextbookStoreMain window = new TextbookStoreMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TextbookStoreMain() {
		initialize();
		createEvents();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Cochin", Font.PLAIN, 13));
		frame.getContentPane().setLayout(null);

		addBtn = new JButton("Add Book");
		addBtn.setFont(new Font("Mongolian Baiti", Font.PLAIN, 11));
		addBtn.setBounds(160, 169, 117, 29);
		frame.getContentPane().add(addBtn);

		SKU = new JTextField();
		SKU.setBounds(100, 48, 233, 26);
		frame.getContentPane().add(SKU);
		SKU.setColumns(10);

		JLabel SKUNo = new JLabel("SKU No.");
		SKUNo.setFont(new Font("Mongolian Baiti", Font.PLAIN, 11));
		SKUNo.setBounds(27, 53, 61, 16);
		frame.getContentPane().add(SKUNo);

		JLabel Price = new JLabel("Price");
		Price.setFont(new Font("Mongolian Baiti", Font.PLAIN, 11));
		Price.setBounds(27, 109, 61, 16);
		frame.getContentPane().add(Price);

		JLabel Title = new JLabel("Title");
		Title.setFont(new Font("Mongolian Baiti", Font.PLAIN, 11));
		Title.setBounds(27, 81, 61, 16);
		frame.getContentPane().add(Title);

		JLabel Quantity = new JLabel("Quantity");
		Quantity.setFont(new Font("Mongolian Baiti", Font.PLAIN, 11));
		Quantity.setBounds(27, 137, 61, 16);
		frame.getContentPane().add(Quantity);

		name = new JTextField();
		name.setBounds(100, 76, 233, 26);
		frame.getContentPane().add(name);
		name.setColumns(10);

		price = new JTextField();
		price.setBounds(100, 104, 233, 26);
		frame.getContentPane().add(price);
		price.setColumns(10);

		qty = new JTextField();
		qty.setBounds(100, 132, 233, 26);
		frame.getContentPane().add(qty);
		qty.setColumns(10);

		removeBtn = new JButton("Remove Book");
		removeBtn.setFont(new Font("Mongolian Baiti", Font.PLAIN, 11));
		removeBtn.setBounds(298, 169, 117, 29);
		frame.getContentPane().add(removeBtn);

		findBtn = new JButton("Find Book");
		findBtn.setFont(new Font("Mongolian Baiti", Font.PLAIN, 11));
		findBtn.setBounds(27, 169, 117, 29);
		frame.getContentPane().add(findBtn);

		inventoryBtn = new JButton("Display Inventory");
		inventoryBtn.setFont(new Font("Mongolian Baiti", Font.PLAIN, 11));
		inventoryBtn.setBounds(298, 217, 117, 29);
		frame.getContentPane().add(inventoryBtn);

		JLabel lblNewLabel = new JLabel("Campus Textbook Store");
		lblNewLabel.setBounds(105, 11, 228, 26);
		lblNewLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 208, 283, 46);
		frame.getContentPane().add(scrollPane);

		errorMsg = new JTextField();
		errorMsg.setFont(new Font("Mongolian Baiti", Font.PLAIN, 11));
		scrollPane.setViewportView(errorMsg);
		errorMsg.setColumns(10);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createEvents() { // method when Add Button is clicked
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBook(); // adds a book
			}
		});

		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeBook(); // removes a book
			}
		});

		findBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findBook(); // adds a book
			}
		});

		inventoryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printInventory(); // displays the inventory
			}
		});
	}

	/**
	 * addBook allows the user to add a book to the store
	 * 
	 */
	public void addBook() {
		if (SKU.getText().equals("") || name.getText().equals("") || price.getText().equals("") || qty.getText().equals("")) {
			errorMsg.setText("Error: Please fill out all sections");
		} else {
			newSKU = Integer.parseInt(SKU.getText());
			newName = name.getText();
			newPrice = Double.parseDouble(price.getText());
			newQty = Integer.parseInt(qty.getText());

			Textbook newBook = new Textbook(newSKU, newName, newPrice, newQty);
			inventory.add(newBook);
			errorMsg.setText("The book was added");
		}
	}

	/**
	 * removeBook allows the user to remove a book from the store if it is available
	 * 
	 */
	public void removeBook() {
		if (SKU.getText().equals("")) {
			errorMsg.setText("Please enter the SKU# ");
		} else if (inventory.isEmpty()) {
			errorMsg.setText("The inventory is empty :(");
		} else {
			for (int i = 0; i < inventory.size(); i++) {
				if (inventory.get(i).getSKU() == Integer.parseInt(SKU.getText())) {
					inventory.remove(i);
					errorMsg.setText("Book has been removed");
				} else {
					errorMsg.setText("Book was not found");
				}
			}
		}
	}

	/**
	 * findBook will look through the inventory to find the requested book using the
	 * SKU# Returns an error if the book doesn't exist or if the inventory is empty
	 * 
	 */
	public void findBook() {
		if (SKU.getText().equals("")) {
			errorMsg.setText("Please enter the SKU#");
		} else if (inventory.isEmpty()) {
			errorMsg.setText("The inventory is empty :(");
		} else {
			for (int i = 0; i < inventory.size(); i++) {
				if (inventory.get(i).getSKU() == Integer.parseInt(SKU.getText())) {
					System.out.println("Here is your book:");
					System.out.println("");
					System.out.println("SKU#: " + inventory.get(i).getSKU());
					System.out.println("Title: " + inventory.get(i).getName());
					System.out.println("Price: $" + inventory.get(i).getPrice());
					System.out.println("Quantity: " + inventory.get(i).getQty() + " copies");
					System.out.println("");
				} else {
					errorMsg.setText("Book was not found");
				}
			}
		}
	}

	/**
	 * printInventory will print out the inventory if there is anything stored into
	 * it If there is nothing in the inventory -> return that the inventory is empty
	 * 
	 */
	public void printInventory() {
		if (inventory.isEmpty() == true) {
			errorMsg.setText("The inventory is empty :(");
		} else {
			for (int i = 0; i < inventory.size(); i++) {
				System.out.println("SKU#: " + inventory.get(i).getSKU());
				System.out.println("Title: " + inventory.get(i).getName());
				System.out.println("Price: $" + inventory.get(i).getPrice());
				System.out.println("Quantity: " + inventory.get(i).getQty());
				System.out.println("");
			}
		}
		System.out.println("");
	}
}