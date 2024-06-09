
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
//Develop Unit Convertor Java code with swing with the following units Time temperature Length area volume weight data currency percentage

public class Gui{



    static Color TopPanelColor = new Color(0x71718A);
    static Color CatagoryPanelColor = new Color(0x5494A8);
    static Color UnitSelectionPanelColor = new Color(0x68815E);
    static Color OutputPanelColor = new Color(0xFFFFFF);

     static String selectedUnit = "defaultChoice"; // to access From list from global postion
     static String[] From = Units.defaultChoice;
     static String FromUnit;
     static String ToUnit;





    public static void main(String[] args){
        JFrame MainWindow = new JFrame("Unit Convertor");
        MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainWindow.setSize(Constants.FrameWidth,Constants.FrameHeight);
        MainWindow.setLayout(null);
        MainWindow.setResizable(true);
        MainWindow.setVisible(true);


/*################################################################################################################################################################################################*/


        JPanel TopPanel = new JPanel();
        TopPanel.setBackground(TopPanelColor);
        TopPanel.setLayout(new BorderLayout());
        TopPanel.setBounds(Constants.TopPanelX,Constants.TopPanelY , Constants.TopPanelWidth,Constants.TopPanelHeight);

        JPanel CatagoryPanel = new JPanel();
        CatagoryPanel.setBackground(CatagoryPanelColor);
        CatagoryPanel.setLayout(new FlowLayout());
        CatagoryPanel.setBounds(Constants.CatagoryPanelX,Constants.CatagoryPanelY,Constants.CatagoryPanelWidth,Constants.CatagoryPanelHeight);


        JPanel UnitSelectionPanel = new JPanel();
        UnitSelectionPanel.setBackground(UnitSelectionPanelColor);
        UnitSelectionPanel.setLayout(new BorderLayout());
        UnitSelectionPanel.setBounds(Constants.UnitSelectionPanelX,Constants.UnitSelectionPanelY,Constants.UnitSelectionPanelWidth,Constants.UnitSelectionPanelHeight);

        JPanel OutputPanel = new JPanel();
        OutputPanel.setBackground(OutputPanelColor);
        OutputPanel.setBounds(Constants.OutputPanelX,Constants.OutputPanelY,Constants.OutputPanelWidth,Constants.OutputPanelHeight);


/*################################################################################################################################################################################################*/



        JLabel label = new JLabel("Unit Convertor");
        label.setFont(new Font("Verdana", Font.PLAIN, 20));



        ImageIcon imageIcon = new ImageIcon("Images/preview.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back
        label.setIcon(imageIcon);
        label.setHorizontalAlignment(JLabel.LEFT);

        TopPanel.add(label);





        String[] Catagories = { "Temperature",
                                "Length",
                                "Area",
                                "Volume",
                                "Weight",
                                "Data",
                                "",
                                "Speed",
                                "Time",
                                "Pressure",
                                "Acceleration"};


        JList<String> CatagoryPanelList = new JList<>(Catagories);
        CatagoryPanelList.setPreferredSize(new Dimension(180, Constants.CatagoryPanelHeight-10));
        CatagoryPanel.add(CatagoryPanelList);






        JList<String> FromUnits = new JList<>(From);
        FromUnits.setPreferredSize(new Dimension(200, 20));
        UnitSelectionPanel.add(FromUnits, BorderLayout.WEST);



        JLabel arrowLabel = new JLabel();
        ImageIcon NextimageIcon = new ImageIcon("Images/arrow.png");
        Image arrow = NextimageIcon.getImage(); // transform it
        Image newarrow = arrow.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        NextimageIcon = new ImageIcon(newarrow);  // transform it back
        arrowLabel.setIcon(NextimageIcon);
        arrowLabel.setHorizontalAlignment(JLabel.CENTER);
        arrowLabel.setVerticalAlignment(JLabel.CENTER);
        UnitSelectionPanel.add(arrowLabel);



        String[] TO = From;
        JList<String> ToUnits = new JList<>(From);
        ToUnits.setPreferredSize(new Dimension(200, Constants.UnitSelectionPanelHeight-100));
        UnitSelectionPanel.add(ToUnits, BorderLayout.EAST);




        JLabel NorthnullSpacer = new JLabel(" ");
        UnitSelectionPanel.add(NorthnullSpacer,BorderLayout.SOUTH);
        JLabel SouthnullSpacer = new JLabel(" ");
        UnitSelectionPanel.add(SouthnullSpacer,BorderLayout.NORTH);

        JLabel Input = new JLabel("Value");
        OutputPanel.add(Input);

        JTextField questionField = new JTextField(10);
        OutputPanel.add(questionField);

        JLabel Ouput = new JLabel("Result");
        OutputPanel.add(Ouput);

        JTextField Answer = new JTextField("",19);
        Answer.setEditable(false);
        OutputPanel.add(Answer);




        JButton ConvertButton = new JButton("Convert");
        OutputPanel.add(ConvertButton,BorderLayout.CENTER);


        JButton ClearButton = new JButton("Clear");
        OutputPanel.add(ClearButton,BorderLayout.WEST);





          Map<String, String[]> options = new HashMap<>() {{
            put(Catagories[0], Units.Temperature);
            put(Catagories[1], Units.Length);
            put(Catagories[2], Units.Area);
            put(Catagories[3], Units.Volume);
            put(Catagories[4], Units.Weight);
            put(Catagories[5], Units.Data);
            put(Catagories[6], Units.Currency);
            put(Catagories[7], Units.Speed);
            put(Catagories[8], Units.Time);
            put(Catagories[9], Units.Pressure);
            put(Catagories[10], Units.Acceleration);

        }};


        CatagoryPanelList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                FromUnits.setListData(options.get(CatagoryPanelList.getSelectedValue()));
                FromUnits.setSelectedIndex(0);

                ToUnits.setListData(options.get(CatagoryPanelList.getSelectedValue()));
                ToUnits.setSelectedIndex(0);
                selectedUnit = CatagoryPanelList.getSelectedValue();
            }
        });



        //Action Listener for the FromUnits panel
        FromUnits.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Avoid multiple events during selection change
                    FromUnit = FromUnits.getSelectedValue();
                    System.out.println("Selected unit: " + FromUnit);
                }
            }
        });


        //Action Listener for the ToUnits panel
        ToUnits.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Avoid multiple events during selection change
                    ToUnit = ToUnits.getSelectedValue();
                    System.out.println("Selected unit: " + ToUnit);
                }
            }
        });













        ConvertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String numberString = questionField.getText();
                //Double Value = Double.parseDouble(questionField.getText());
                Double convertedValue = UnitConverter.Converter(selectedUnit, FromUnit, ToUnit,Double.parseDouble(questionField.getText()));
                String ConvertedValue_str = String.valueOf(convertedValue);
                Answer.setText(ConvertedValue_str);

                //    Answer.setText("Error: Conversion failed!"); // Display error message

            }
        });



        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Answer.setText(null);
                questionField.setText(null);


            }

        });



        /*################################################################################################################################################################################################*/


        MainWindow.add(TopPanel);
        MainWindow.add(CatagoryPanel);
        MainWindow.add(UnitSelectionPanel);
        MainWindow.add(OutputPanel);



    }}
