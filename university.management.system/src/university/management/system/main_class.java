package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    main_class(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1400,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        JMenuBar mb = new JMenuBar();

        // new info
        JMenu newInfo = new JMenu("New Information");
        newInfo.setForeground(Color.BLACK);
        mb.add(newInfo);

        JMenuItem facultyInfo = new JMenuItem("New faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        newInfo.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        newInfo.add(studentInfo);

        // Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.BLACK);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View faculty Details");
        facultydetails.setBackground(Color.WHITE);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        details.add(studentdetails);

            // leave
        JMenu leave = new JMenu("Apply leave");
        leave.setForeground(Color.BLACK);
        mb.add(leave);

        JMenuItem facultyleave = new JMenuItem("faculty leave");
        facultyleave.setBackground(Color.WHITE);
        leave.add(facultyleave);

        JMenuItem studentleave = new JMenuItem("Student leave");
        studentleave.setBackground(Color.WHITE);
        leave.add(studentleave);

        // Leave details
        JMenu leaveDetails = new JMenu(" Leave Details");
        leaveDetails.setForeground(Color.BLACK);
        mb.add(leaveDetails);

        JMenuItem facultyleaveDetails = new JMenuItem("faculty leave Details");
        facultyleaveDetails.setBackground(Color.WHITE);
        leaveDetails.add(facultyleaveDetails);

        JMenuItem studentleaveDetails = new JMenuItem("Student leave Details");
        studentleaveDetails.setBackground(Color.WHITE);
        leaveDetails.add(studentleaveDetails);

        // Exams
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLACK);
        mb.add(exam);

        JMenuItem ExaminationDetails = new JMenuItem("Examination Results");
        ExaminationDetails.setBackground(Color.WHITE);
        exam.add(ExaminationDetails);

        JMenuItem EnterMarks = new JMenuItem("Enter Marks");
        EnterMarks.setBackground(Color.WHITE);
        exam.add(EnterMarks);

        // Update info
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.BLACK);
        mb.add(updateInfo);

        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
        updateInfo.add(updatefacultyinfo);

        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.WHITE);
        updateInfo.add(updatestudentinfo);

        // fee
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLACK);
        mb.add(fee);

        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        fee.add(feestructure);

        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.WHITE);
        fee.add(feeForm);

        // utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLACK);
        mb.add(utility);

        JMenuItem Ca = new JMenuItem("Calculator");
        Ca.setBackground(Color.WHITE);
        Ca.addActionListener(this);
        utility.add(Ca);

        JMenuItem Notepad = new JMenuItem("Notepad");
        Notepad.setBackground(Color.WHITE);
        Notepad.addActionListener(this);
        utility.add(Notepad);

        // About
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLACK);
        mb.add(about);

        JMenuItem About = new JMenuItem("About");
        About.setBackground(Color.WHITE);
        about.add(About);

        // exit
        JMenu exit = new JMenu("exit");
        exit.setForeground(Color.BLACK);
        mb.add(exit);

        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setBackground(Color.WHITE);
        Exit.addActionListener(this);
        exit.add(Exit);




        setJMenuBar(mb);


        setSize(1540,850);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String sm = e.getActionCommand();
            if (sm.equals("Exit")){
                System.exit(15);
            } else if (sm.equals("Calculator")) {
                try {
                    Runtime.getRuntime().exec("calc.exe");
                } catch (Exception E) {
                    E.printStackTrace();
                }
            } else if (sm.equals("Notepad")) {
                try {
                    Runtime.getRuntime().exec("notepad.exe");
                }catch (Exception E) {
                    E.printStackTrace();
                }
            }
    }
    public static void main(String[] args) {
        new main_class();
    }


}
