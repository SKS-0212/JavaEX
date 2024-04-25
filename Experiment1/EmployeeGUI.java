package University.Java_Using_Project.Experiment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EmployeeGUI extends JFrame {
    private final List<Employee> employeeList;

    private final JTextField empNoField;
    private final JTextField empNameField;
    private final JTextField designationCodeField;
    private final JTextField departmentField;
    private final JTextField basicField;
    private final JTextField hraField;
    private final JTextField itField;

    private final JTextArea outputArea;

    public EmployeeGUI() {
        employeeList = new ArrayList<>();

        empNoField = new JTextField(10);
        empNameField = new JTextField(10);
        designationCodeField = new JTextField(10);
        departmentField = new JTextField(10);
        basicField = new JTextField(10);
        hraField = new JTextField(10);
        itField = new JTextField(10);

        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        JButton addEmployeeButton = new JButton("Add Employee");
        JButton displayAllButton = new JButton("Display All Employees");
        JButton fetchButton = new JButton("Fetch Employee");
        JButton displayButton = new JButton("Display Employee");

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        displayAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllEmployees();
            }
        });

        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchEmployee();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayEmployee();
            }
        });

        JPanel inputPanel = new JPanel(new GridLayout(7, 2));
        inputPanel.add(new JLabel("Employee ID:"));
        inputPanel.add(empNoField);
        inputPanel.add(new JLabel("Employee Name:"));
        inputPanel.add(empNameField);
        inputPanel.add(new JLabel("Designation Code:"));
        inputPanel.add(designationCodeField);
        inputPanel.add(new JLabel("Department:"));
        inputPanel.add(departmentField);
        inputPanel.add(new JLabel("Basic:"));
        inputPanel.add(basicField);
        inputPanel.add(new JLabel("HRA:"));
        inputPanel.add(hraField);
        inputPanel.add(new JLabel("IT:"));
        inputPanel.add(itField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addEmployeeButton);
        buttonPanel.add(displayAllButton);
        buttonPanel.add(fetchButton);
        buttonPanel.add(displayButton);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setTitle("Employee Management System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addEmployee() {
        int empNo = Integer.parseInt(empNoField.getText());
        String empName = empNameField.getText();
        String designationCode = designationCodeField.getText();
        String department = departmentField.getText();
        int basic = Integer.parseInt(basicField.getText());
        int hra = Integer.parseInt(hraField.getText());
        int it = Integer.parseInt(itField.getText());

        Employee employee = new Employee(empNo, empName, designationCode, department, basic, hra, it);
        employeeList.add(employee);

        clearFields();
        displayOutput("Employee added successfully.");
    }

    private void displayAllEmployees() {
        new Employee().display(employeeList);
    }

    private void fetchEmployee() {
        int empNo = Integer.parseInt(empNoField.getText());
        new Employee().getEmployeeById(empNo, employeeList);
    }

    private void displayEmployee() {
        int empNo = Integer.parseInt(empNoField.getText());
        for (Employee e : employeeList) {
            if (empNo == e.getEmoNo()) {
                outputArea.setText("");
                e.display(List.of(e));
                return;
            }
        }
        displayOutput("Employee not found.");
    }

    private void clearFields() {
        empNoField.setText("");
        empNameField.setText("");
        designationCodeField.setText("");
        departmentField.setText("");
        basicField.setText("");
        hraField.setText("");
        itField.setText("");
    }

    private void displayOutput(String output) {
        outputArea.append(output + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeGUI();
            }
        });
    }
}
