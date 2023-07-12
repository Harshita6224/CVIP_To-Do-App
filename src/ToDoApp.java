//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//class ToDoItem {
//    private String task;
//    private boolean completed;
//
//    public ToDoItem(String task) {
//        this.task = task;
//        this.completed = false;
//    }
//
//    public String getTask() {
//        return task;
//    }
//
//    public void setCompleted(boolean completed) {
//        this.completed = completed;
//    }
//
//    public boolean isCompleted() {
//        return completed;
//    }
//
//}
//
//public class ToDoApp {
//    private List<ToDoItem> toDoList;
//    public ToDoApp() {
//        toDoList = new ArrayList<>();
//    }
//    public void addTask(String task){
//        ToDoItem item=new ToDoItem(task);
//        toDoList.add(item);
//        System.out.println("Task Added:" + task);
//    }
//    public void completeTask(int index)
//    {
//        if(index>=0 && index<toDoList.size())
//        {
//            ToDoItem item=toDoList.get(index);
//            item.setCompleted(true);
//            System.out.println("Task Completed:" + item.getTask());
//        }
//        else {
//            System.out.println("Invalid Task Index.");
//        }
//    }
//    public void displayTasks() {
//        System.out.println("To-Do List:");
//        for (int i = 0; i < toDoList.size(); i++) {
//            ToDoItem item = toDoList.get(i);
//            String status = item.isCompleted() ? "[X]" : "[ ]";
//            System.out.println(i + " " + status + " " + item.getTask());
//        }
//    }
//    public static void main(String args[])
//    {
//        ToDoApp toDoApp=new ToDoApp();
//        Scanner sc=new Scanner(System.in);
//        System.out.println("            ************ TO DO APP ***********             ");
//        while(true)
//        {
//
//            System.out.println("1. Add Task");
//            System.out.println("2. Complete Task");
//            System.out.println("3. View Tasks");
//            System.out.println("4. Exit");
//            System.out.println("Enter your choice:");
//            int choice=sc.nextInt();
//
//            switch (choice)
//            {
//                case 1:
//                    System.out.println("Enter task to add:");
//                    sc.nextLine();
//                    String task=sc.nextLine();
//                    toDoApp.addTask(task);
//                    break;
//                case 2:
//                    System.out.println("Enter index of task to complete:");
//                    int index=sc.nextInt();
//                    toDoApp.completeTask(index);
//                    break;
//                case 3:
//                    toDoApp.displayTasks();
//                    break;
//                case 4:
//                    System.out.println("Exiting Application.");
//                    sc.close();
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid Choice.");
//            }
//        }
//    }
//}
//
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