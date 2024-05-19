import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vendeur extends JFrame implements ActionListener {

    JComboBox<String> typeComboBox, surfaceComboBox, prixComboBox, localisationComboBox;
    JButton submitButton, RetButton;
    
    String[] selectedTypes = new String[100]; 
    String[] selectedSurfaces = new String[100];
    String[] selectedPrix = new String[100];
    String[] selectedLocalisations = new String[100];
    int index = 0; 

    public Vendeur() {

        setTitle("Vendeur");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel typeLabel = new JLabel("Type:");
        String[] types = {"Maison", "Appartement"};
        typeComboBox = new JComboBox<>(types);
        panel.add(typeLabel);
        panel.add(typeComboBox);

        JLabel surfaceLabel = new JLabel("Surface (metres carrés):");
        String[] surfaces = {"< 100 m carrés", "100 - 150 m carrés", "> 150 m carrés"};
        surfaceComboBox = new JComboBox<>(surfaces);
        panel.add(surfaceLabel);
        panel.add(surfaceComboBox);

        JLabel prixLabel = new JLabel("Price (centime):");
        String[] prix = {"< 1.5 Milliards", "1.5 Milliards - 3 Milliards", "> 3 Milliards"};
        prixComboBox = new JComboBox<>(prix);
        panel.add(prixLabel);
        panel.add(prixComboBox);

        JLabel localisationLabel = new JLabel("Location:");
        String[] locations = {"Alger", "Oran", "Boumerdess", "Setif", "Batna", "Skikda", "Adrar"};
        localisationComboBox = new JComboBox<>(locations);
        panel.add(localisationLabel);
        panel.add(localisationComboBox);

        RetButton = new JButton("Retour");
        RetButton.addActionListener(this);
        panel.add(RetButton);

        submitButton = new JButton("Confirm");
        submitButton.addActionListener(this);
        panel.add(submitButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == RetButton) {
            new Fournisseur();
        }
        if (e.getSource() == submitButton) {
            
            String selectedType = (String) typeComboBox.getSelectedItem();
            String selectedSurface = (String) surfaceComboBox.getSelectedItem();
            String selectedPrixValue = (String) prixComboBox.getSelectedItem();
            String selectedLocalisation = (String) localisationComboBox.getSelectedItem();

            selectedTypes[index] = selectedType;
            selectedSurfaces[index] = selectedSurface;
            selectedPrix[index] = selectedPrixValue;
            selectedLocalisations[index] = selectedLocalisation;
            
            index++;

            afficherElements();
        }
    }
    public void afficherElements() {
        System.out.println("Affichage des éléments sélectionnés :");
        for (int i = 0; i < index; i++) {
            System.out.println("Sélection " + (i + 1) + ":");
            System.out.println("Type: " + selectedTypes[i]);
            System.out.println("Surface: " + selectedSurfaces[i]);
            System.out.println("Prix: " + selectedPrix[i]);
            System.out.println("Localisation: " + selectedLocalisations[i]);
            System.out.println("---------------------");
            
            JOptionPane.showMessageDialog(this, "votre demande a été enregistrée et sera étudiée ultérieurement");
        }
    }
}