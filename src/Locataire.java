import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Locataire extends JFrame implements ActionListener {
    private List<BienImmobilier> bienImmobilierList;
    private JComboBox<String> typeComboBox, surfaceComboBox, prixComboBox, localisationComboBox;
    private JButton submitButton, RetButton;
    private JTextArea resultTextArea;

    public Locataire(List<BienImmobilier> bienImmobilierList) {
        this.bienImmobilierList = bienImmobilierList;

        setTitle("Locataire");
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

        JLabel prixLabel = new JLabel("Prix (centime):");
        String[] prix = {"< 3 Millions", "3 Millions - 4 Millions", "> 4 Millions"};
        prixComboBox = new JComboBox<>(prix);
        panel.add(prixLabel);
        panel.add(prixComboBox);

        JLabel localisationLabel = new JLabel("Location:");
        String[] locations = {"Alger", "Oran", "Boumerdess", "Setif", "Batna", "Skikda", "Adrar"};
        localisationComboBox = new JComboBox<>(locations);
        panel.add(localisationLabel);
        panel.add(localisationComboBox);

        RetButton = new JButton("Retour");
        RetButton.setFocusable(false);
        RetButton.addActionListener(this);
        panel.add(RetButton);

        submitButton = new JButton("Confirm");
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        panel.add(submitButton);

        resultTextArea = new JTextArea(); // Initialize resultTextArea
        resultTextArea.setEditable(false);
        resultTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(resultTextArea);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER); // Add scrollPane to display resultTextArea

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == RetButton) {
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
            case "< 100 m carrés":
                return surface < 100;
            case "100 - 150 m carrés":
                return surface >= 100 && surface <= 150;
            case "> 150 m carrés":
                return surface > 150;
            default:
                return false;
        }
    }

    private boolean matchesPrix(double d, String prixFilter) {
        switch (prixFilter) {
            case "< 3 Millions":
                return d < 3000000;
            case "3 Millions - 4 Millions":
                return d >= 3000000 && d <= 4000000;
            case "> 4 Millions":
                return d > 4000000;
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