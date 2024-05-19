import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Affichebiendispo extends JFrame {

    public Affichebiendispo(List<BienImmobilier> biensAchat, String selectedType, String selectedLocalisation) {
        setTitle("Biens immobiliers disponibles");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Change the close operation to DISPOSE_ON_CLOSE
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));

        // Check if the list of properties is not null and not empty
        if (biensAchat != null && !biensAchat.isEmpty()) {
            boolean found = false; // Track if any matching properties are found

            // Iterate over the list of properties and append matching ones to the text area
            for (BienImmobilier bien : biensAchat) {
                if (bien.getTypeBien().equals(selectedType) && bien.getLocalisation().equals(selectedLocalisation)) {
                    found = true;
                    appendPropertyDetails(textArea, bien);
                    this.dispose();
            new SelectionnerBiendispo(biensAchat); // Extracted method for appending property details
                }
            }

            // If no matching properties were found, display a message
            if (!found) {
                textArea.append("Aucun bien disponible pour les critères de recherche spécifiés.");
            }
            

        } else {
            // If the list of properties is null or empty, display an appropriate message
            textArea.append("Aucun bien disponible pour les critères de recherche spécifiés.");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Extracted method for appending property details
    private void appendPropertyDetails(JTextArea textArea, BienImmobilier bien) {
        textArea.append("Type: " + bien.getTypeBien() + "\n");
        textArea.append("Surface: " + bien.getSurface() + " mètres carrés\n");
        textArea.append("Prix: " + bien.getPrix() + "\n");
        textArea.append("Localisation: " + bien.getLocalisation() + "\n\n");
        textArea.append("Description: " + bien.getDescription() + "\n\n");
    }
}