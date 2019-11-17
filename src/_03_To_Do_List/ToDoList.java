package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	ArrayList<String> list = new ArrayList<String>();
	JFrame fr = new JFrame("S To-Do");
	JPanel f = new JPanel();
	JButton add = new JButton("Add Task");
	JButton view = new JButton("View Task List");
	JButton remove = new JButton("Remove Task");
	JButton save = new JButton("Save Task List");
	JButton load = new JButton("Load Task List");

	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
		tdl.setup();
	}

	private void setup() {
		f.add(add);
		f.add(view);
		f.add(remove);
		f.add(save);
		f.add(load);
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		fr.add(f);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
		fr.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(add)) {
			String add = JOptionPane.showInputDialog(null, "Enter an item to add to To-Do list:",
					"Add Item To To-Do List", JOptionPane.QUESTION_MESSAGE);
			list.add(add);
		}
		if (e.getSource().equals(view)) {
			String todolist = "";
			if (list.size() == 0) {
				JOptionPane.showMessageDialog(null, "Nothing here yet!", "View Items In To-Do List",
						JOptionPane.INFORMATION_MESSAGE);
				distract();
			} else {
				for (int i = 0; i < list.size(); i++) {
					todolist += "Item # " + i + ": ";
					todolist += list.get(i) + "\n";
				}
				JOptionPane.showMessageDialog(null, "Your list: \n" + todolist, "View Items In To-Do List",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if (e.getSource().equals(remove)) {
			if (list.size() == 1) {
				list.clear();
				JOptionPane.showMessageDialog(null, "Only one item left. Has been deleted.");
			} else {
				String i = JOptionPane.showInputDialog(null, "Enter the index of item you would like to remove:",
						"Remove Item From To-Do List", JOptionPane.QUESTION_MESSAGE);
				list.remove(Integer.parseInt(i));
			}
		}
		if (e.getSource().equals(save)) {
			try {
				FileWriter fw = new FileWriter("src/todos.txt");
				String todolist = "";
				for (int i = 0; i < list.size(); i++) {
					todolist += list.get(i) + "\n";
				}
				fw.write(todolist);
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(load)) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/todos.txt"));
				list.clear();
				String line = br.readLine();
				while (line != null) {
					list.add(line);
					line = br.readLine();
				}

				br.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	void distract() {

	}
}