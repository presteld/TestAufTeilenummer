import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eingabe {
    private JPanel jpPanel;
    private JLabel lblEingabe;
    private JTextField txtTeilenummer;
    private JButton btnTest;
    private JTextArea taAusgabe;


    public Eingabe() {


        btnTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sTeileNr = txtTeilenummer.getText().toString();

                if (pruefeTeileNr(sTeileNr) == true){

                    taAusgabe.setText("Test der Teilenummer ");
                    taAusgabe.append("\n\n" + sTeileNr);
                    taAusgabe.append("\n\n   OK");

                }



            }
        });
    }




    public boolean pruefeTeileNr(String sTeileNr) {


        return  true;
    }




    public static void main(String[] args) {
        JFrame frame = new JFrame("Test der eingegeben Teilenummer");
        frame.setContentPane(new Eingabe().jpPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(600,400);
        frame.setVisible(true);
    }
}
