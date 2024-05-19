import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Acheteur extends JFrame implements ActionListener {

    private List<BienImmobilier> bienImmobilierList;
    private JComboBox<String> typeComboBox, surfaceComboBox, prixComboBox, localisationComboBox;
    private JButton submitButton, retButton;
    private JTextArea resultTextArea;

    public Acheteur(List<BienImmobilier> bienImmobilierList) {
        this.bienImmobilierList = bienImmobilierList;
        
        setTitle("Acheteur");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel typeLabel = new JLabel("Type:");
        String[] types = {"Maison", "Appartement"};
        typeComboBox = new JComboBox<>(types);
        panel.add(typeLabel);
        panel.add(typeComboBox);

        JLabel surfaceLabel = new JLabel("Surface (mètres carrés):");
        String[] surfaces = {"< 100 m²", "100 - 150 m²", "> 150 m²"};
        surfaceComboBox = new JComboBox<>(surfaces);
        panel.add(surfaceLabel);
        panel.add(surfaceComboBox);

        JLabel prixLabel = new JLabel("Prix (centime):");
        String[] prix = {"< 1.5 Milliards", "1.5 Milliards - 3 Milliards", "> 3 Milliards"};
        prixComboBox = new JComboBox<>(prix);
        panel.add(prixLabel);
        panel.add(prixComboBox);

        JLabel localisationLabel = new JLabel("Localisation:");
        String[] locations = {"Alger", "Oran", "Boumerdess", "Setif", "Batna", "Skikda", "Adrar"};
        localisationComboBox = new JComboBox<>(locations);
        panel.add(localisationLabel);
        panel.add(localisationComboBox);

        retButton = new JButton("Retour");
        retButton.setFocusable(false);
        retButton.addActionListener(this);
        panel.add(retButton);

        submitButton = new JButton("Confirm");
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        panel.add(submitButton);

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(resultTextArea);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == retButton) {
            dispose();
        } else if (e.getSource() == submitButton) {
            String selectedType = (String) typeComboBox.getSelectedItem();
            String selectedSurface = (String) surfaceComboBox.getSelectedItem();
            String selectedPrix = (String) prixComboBox.getSelectedItem();
            String selectedLocalisation = (String) localisationComboBox.getSelectedItem();

            List<BienImmobilier> filteredList = filterBienImmobilier(selectedType, selectedSurface, selectedPrix, selectedLocalisation);
            displayFilteredList(filteredList);
            new Affichebiendispo(bienImmobilierList,selectedType,selectedLocalisation);
            this.dispose();
        }
    }

    private List<BienImmobilier> filterBienImmobilier(String type, String surface, String prix, String localisation) {
        List<BienImmobilier> filteredList = new ArrayList<>();

        for (BienImmobilier bien : bienImmobilierList) {
            if (bien.getTypeBien().equals(type) &&
                matchesSurface(bien.getSurface(), surface) &&
                matchesPrix(bien.getPrix(), prix) &&
                bien.getLocalisation().equals(localisation)) {
                filteredList.add(bien);
            }
        }

        return filteredList;
    }

    private boolean matchesSurface(double surface, String surfaceFilter) {
        switch (surfaceFilter) {
            case "< 100 m²":
                return surface < 100;
            case "100 - 150 m²":
                return surface >= 100 && surface <= 150;
            case "> 150 m²":
                return surface > 150;
            default:
                return false;
        }
    }

    private boolean matchesPrix(double d, String prixFilter) {
        switch (prixFilter) {
            case "< 1.5 Milliards":
                return d < 1500000000;
            case "1.5 Milliards - 3 Milliards":
                return d >= 1500000000 && d <= 2000000000;
            case "> 3 Milliards":
                return true;
            default:
                return false;
        }
    }

    private void displayFilteredList(List<BienImmobilier> filteredList) {
        resultTextArea.setText("");

        if (filteredList.isEmpty()) {
            resultTextArea.append("Aucun résultat trouvé.");
        } else {
            for (BienImmobilier bien : filteredList) {
                resultTextArea.append(bien.toString() + "\n\n");
            }
        }
    }
}
