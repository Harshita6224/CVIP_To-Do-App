
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoApp extends JFrame{
    private DefaultListModel<String> toDoListModel;
    private JList<String> toDoList;
    private JTextField taskInput;

    public ToDoApp()
    {
        super("To-Do App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300,400));

        toDoListModel=new DefaultListModel<>();
        toDoList=new JList<>(toDoListModel);

        JScrollPane listScrollPane=new JScrollPane(toDoList);

        taskInput=new JTextField();
        taskInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText();
                if (!task.isEmpty()) {
                    toDoListModel.addElement(task);
                    taskInput.setText("");
                }
            }
        });

        //Create the add button
        JButton addButton=new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText();
                if (!task.isEmpty()) {
                    toDoListModel.addElement(task);
                    taskInput.setText("");
                }
            }
        });


        //Create the delete button
        JButton deleteButton=new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex=toDoList.getSelectedIndex();
                if(selectedIndex != -1){
                    toDoListModel.remove(selectedIndex);
                }
            }
        });

        //Create the panel and add components
        JPanel inputPanel=new JPanel(new BorderLayout());
        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        inputPanel.add(deleteButton, BorderLayout.WEST);


        JPanel mainPanel=new JPanel(new BorderLayout());
        mainPanel.add(listScrollPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        add(mainPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

       public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new ToDoApp();
            }
        });
    }
}