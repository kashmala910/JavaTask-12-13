import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main{
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Border emptyBorder = BorderFactory.createEmptyBorder();
        Border loweredBorderEtched = new EtchedBorder(EtchedBorder.LOWERED);
        String[] countries={"Pakistan","India","China","UK","USA","UAE"};
        JFrame frame = new JFrame("Student Registration Form");
        frame.setLayout(null);
        frame.setBounds(300,100,900,600);
        frame.getContentPane().setBackground(Color.yellow);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JLabel Name= new JLabel("Name");
        Name.setBounds(100, 50, 200, 20);

        JTextField Name1= new JTextField();
        Name1.setBounds(400, 50, 200, 20);

        JLabel rollNum= new JLabel("Roll Number");
        rollNum.setBounds(100, 90, 200, 20);

        JTextField rollNum1 = new JTextField();
        rollNum1.setBounds(400, 90, 200, 20);

        JLabel Batch= new JLabel("Batch");
        Batch.setBounds(100, 130, 200, 20);

        JTextField Batch1= new JTextField();
        Batch1.setBounds(400, 130, 200, 20);

        JLabel Section= new JLabel("Section");
        Section.setBounds(100, 170, 200, 20);

        JTextField Section1 = new JTextField();
        Section1.setBounds(400, 170, 200, 20);

        JLabel Gender= new JLabel("Gender");
        Gender.setBounds(100, 210, 200, 20);

        JRadioButton gen1=new JRadioButton("Male");
        JRadioButton gen2=new JRadioButton("Female");
        ButtonGroup b= new ButtonGroup();
        b.add(gen1);
        b.add(gen2);

        gen1.setBounds(400, 210, 70, 20);
        gen2.setBounds(500, 210, 70, 20);
        gen1.setBackground(Color.yellow);
        gen2.setBackground(Color.yellow);

        JLabel Qual= new JLabel("Qualification");
        Qual.setBounds(100, 250, 200, 20);

        JCheckBox Q1=new JCheckBox("Matric");
        JCheckBox Q2=new JCheckBox("Intermediate");
        JCheckBox Q3=new JCheckBox("Undergraduate");
        JCheckBox Q4=new JCheckBox("Graduate");

        Q1.setBackground(Color.yellow);
        Q2.setBackground(Color.yellow);
        Q3.setBackground(Color.yellow);
        Q4.setBackground(Color.yellow);

        Q1.setBounds(400, 250, 100, 20);
        Q2.setBounds(550, 250, 100, 20);
        Q3.setBounds(400, 280, 120, 20);
        Q4.setBounds(550, 280, 100, 20);

        JLabel Address= new JLabel("Address");
        Address.setBounds(100, 320, 200, 20);

        JTextArea add1 = new JTextArea();
        add1.setBounds(400,320,300,50);
        add1.setBorder(loweredBorderEtched);

        JLabel country = new JLabel("Country");
        country.setBounds(100,380,200,20);

        JComboBox country1 =  new JComboBox(countries);
        country1.setBounds(400,380,200,20);

        JButton clear = new JButton("Clear");
        clear.setBounds(520,450,100,20);

        JButton print = new JButton("Print");
        print.setBounds(320, 450, 100, 20);

        JButton save = new JButton("Save");
        save.setBounds(120, 450, 100, 20);

        frame.add(Name);
        frame.add(Name1);
        frame.add(rollNum);
        frame.add(rollNum1);
        frame.add(Batch);
        frame.add(Batch1);
        frame.add(Section);
        frame.add(Section1);
        frame.add(Gender);
        frame.add(gen1);
        frame.add(gen2);
        frame.add(Qual);
        frame.add(Q1);
        frame.add(Q2);
        frame.add(Q3);
        frame.add(Q4);
        frame.add(Address);
        frame.add(add1);
        frame.add(country);
        frame.add(country1);
        frame.add(save);
        frame.add(clear);
        frame.add(print);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=Name.getText();
                String RollNum=rollNum.getText();
                String batch=Batch.getText();
                String gender;
                if(gen1.isSelected()) {
                    gender=gen1.getText();
                }
                else{
                    gender=gen2.getText();
                }
                String section= Section.getText();
                String Country = (String) countries;
                String address= Address.getText();
                String Quali=" ";
                if(Q1.isSelected()) {
                    Quali+="  Matric";
                }
                if(Q2.isSelected()) {
                    Quali+=",  Intermediate";
                }if(Q3.isSelected()) {
                    Quali+="  Undergraduate";
                }if(Q4.isSelected()) {
                    Quali+="  Graduate";
                }

                JSONObject obj = new JSONObject();
                obj.put("Name",name);
                obj.put("Gender",gender);
                obj.put("Roll number",RollNum);
                obj.put("Batch",batch);
                obj.put("Section",section);
                obj.put("Qualification",Quali);
                obj.put("Country",Country);
                obj.put("Address",address);

                try {
                    FileWriter file1 = new FileWriter("Student.json");
                    file1.write(obj.toString());
                    file1.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

        });

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String printOut;
                Object obj;
                try {
                    obj = new JSONParser().parse(new FileReader("Student.json"));
                    JSONObject read = (JSONObject) obj;

                    printOut = "Name = "+read.get("Name")+"\nRoll Number = "+read.get("Roll number")+"\nGender = "+read.get("Gender");
                    printOut+="\nBatch = "+read.get("Batch")+"\nSection = "+read.get("Section")+"\nQualification = "+read.get("Qualification");
                    printOut+="\nCountry = "+read.get("Country")+"\nAddress = "+read.get("Address");

                    JOptionPane.showMessageDialog(frame,printOut);

                } catch (IOException | ParseException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }}}}}}
