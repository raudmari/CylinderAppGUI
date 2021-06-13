import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;


public class MyPanel extends JPanel {

    private final String[] choices = new String[]{"Raadius","Diameeter" }; // Combobox'i valikud raadius või diameeter
    private final Font fontNormal = new Font("Verdana", Font.PLAIN, 16);

    private JLabel lblRadius;
    private JLabel lblHeight;
    private JTextField txtRadius;
    private JTextField txtHeight;
    private JComboBox<String> comboBoxRorD; //comboboxi valikud
    private JTextArea txtAreaResult; // siia tulevad vastused

    private final JPanel top; // Ülemine paneel
    private final JPanel  bottom; // Alumine paneel

    public MyPanel() {
        setBackground(new Color(205, 210, 120));
        setLayout(new BorderLayout());

        top = new JPanel();
        bottom = new JPanel();

        top.setBackground(Color.PINK);
        bottom.setBackground(Color.lightGray);

        // kutsume välja meetodid, mis all said ise loodud
        setupRadius(); // teeb ja paneb label'i
        setupHeight(); // teeb ja paneb textivälja
        setupCombobox(); // Teeb ja lisab comboboxi
        setupButton(); // Teeb ja lisab nupu
        setupTxtArea(); // Tulemuste kast

        // Lisame top ja bottomi sellele paneelile (extends)
        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);
    }
    private void setupRadius() {
        lblRadius = new JLabel("Raadius"); // teeme label'i
        txtRadius = new JTextField();
        txtRadius.setPreferredSize(new Dimension(50, 25));
        txtRadius.setHorizontalAlignment(SwingUtilities.RIGHT); // Kirjutamine kastis on paremal
        txtRadius.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtRadius.setText(""); // Teeb tekstikasti tühjaks hiire klikkides

            }
        });
        top.add(lblRadius); // lisame label'i top paneelile
        top.add(txtRadius);

    }
    private void setupHeight() {
        lblHeight = new JLabel("Kõrgus");
        txtHeight = new JTextField();
        txtHeight.setPreferredSize(new Dimension(50, 25));
        txtHeight.setHorizontalAlignment(SwingUtilities.RIGHT);
        txtHeight.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtHeight.setText("");
            }
        });

        top.add(lblHeight);
        top.add(txtHeight);

    }
    private void setupCombobox() {
        comboBoxRorD = new JComboBox<>(choices); // Combobox koos kahe valikuga
        comboBoxRorD.addItemListener(e -> {
            System.out.println(e.getItem().toString()); // testiks algne ja uus
            if(e.getStateChange() == ItemEvent.SELECTED) {
                lblRadius.setText(e.getItem().toString()); // muudab label'i texti õigeks
            }
        });
        top.add(comboBoxRorD);
      
    }
    private void setupButton() {
        // nupp
        JButton btnCalculate = new JButton("Arvuta"); // text nupul
        btnCalculate.setFont(fontNormal);
        btnCalculate.addActionListener(e -> {
            String text = txtRadius.getText();
            String txtH = txtHeight.getText();
            String what = Objects.requireNonNull(comboBoxRorD.getSelectedItem()).toString();
            boolean rOrD = true; // on raadius
            if(!what.equals("Raadius")){
                rOrD = false;
            }
            try {
                double sizeR = Double.parseDouble(text); // kasutaja sisestatud String saab Double tüübiks
                double sizeH = Double.parseDouble(txtH);
                Circle circle = new Circle(sizeR, rOrD);
                txtAreaResult.setText(""); // teeb textArea tühjaks
                txtAreaResult.append("Silindri raadius " + circle.getRadius() + "\n");
                txtAreaResult.append("Silindri diameeter " + circle.getDiameter() + "\n");
                txtAreaResult.append("Põhjapindala " + circle.getArea() * 2 + "\n");
                txtAreaResult.append("Küljepindala " + (circle.getPerimeter()) * sizeH + "\n");
                txtAreaResult.append("Täispindala "  + ((circle.getArea() * 2) + (circle.getPerimeter() * sizeH)) + "\n");
                txtAreaResult.append("Ruumala " + circle.getArea() * sizeH + "\n");

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "See pole number " + lblRadius.getText());
                JOptionPane.showMessageDialog(null, "See pole number " + lblHeight.getText());
            }
        });
        top.add(btnCalculate);

    }
    private void setupTxtArea(){
        txtAreaResult = new JTextArea();
        txtAreaResult.setPreferredSize(new Dimension(375, 315));
        txtAreaResult.setFont(fontNormal);
        bottom.add(txtAreaResult);
    }

}
