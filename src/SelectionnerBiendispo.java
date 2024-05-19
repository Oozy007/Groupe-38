import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelectionnerBiendispo extends JFrame implements ActionListener {
    private JComboBox<BienImmobilier> bienComboBox;
    private JButton selectButton;

    public SelectionnerBiendispo(List<BienImmobilier> biensDisponibles) {
        setTitle("Sélectionner un bien");
        setUndecorated(true); // Supprime les bordures de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Choisissez un bien parmi ceux disponibles :");
        label.setFont(new Font("Arial", Font.BOLD, 20)); // Définir la police et la taille du texte
        label.setHorizontalAlignment(JLabel.CENTER); // Centrer le texte
        add(label, BorderLayout.NORTH);

        bienComboBox = new JComboBox<>(biensDisponibles.toArray(new BienImmobilier[0]));
        bienComboBox.setFont(new Font("Arial", Font.PLAIN, 18)); // Définir la police et la taille du texte
        add(bienComboBox, BorderLayout.CENTER);

        selectButton = new JButton("Sélectionner");
        selectButton.setFont(new Font("Arial", Font.BOLD, 20)); // Définir la police et la taille du texte
        selectButton.addActionListener(this);
        add(selectButton, BorderLayout.SOUTH);

        setExtendedState(JFrame.MAXIMIZED_BOTH); // Définir la fenêtre en plein écran
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectButton) {
            BienImmobilier selectedBien = (BienImmobilier) bienComboBox.getSelectedItem();
            if (selectedBien != null) {
                // Récupérer le nom du responsable associé au bien sélectionné
                String responsable = selectedBien.getResponsable();
                
                // Afficher un message avec le nom du responsable
                String message = "Bien sélectionné : " + selectedBien + "\n";
                message += "Veuillez contacter le responsable : " + responsable;
                JOptionPane.showMessageDialog(this, message, "Bien sélectionné", JOptionPane.INFORMATION_MESSAGE);
            }
            this.dispose(); // Ferme la fenêtre actuelle
        }
    }
}