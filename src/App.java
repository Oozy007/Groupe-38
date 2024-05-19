import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App extends JFrame implements ActionListener {

    JButton ButtonFourn;
    JButton ButtonClient;
    JButton ButtonExit;

    private List<BienImmobilier> biensAchat; 
    private List<BienImmobilier> biensALouer;
    private List<Agentimmobilier> listagent;
    
    public App() {
    	
    	biensAchat = new ArrayList<>();
        biensALouer = new ArrayList<>();
        listagent = new ArrayList<>();
        
        Agentimmobilier a1=new Agentimmobilier("zazour","hamid",100,"zazourhamid@gmail.com");
        listagent.add(a1);
        Agentimmobilier a2=new Agentimmobilier("djari","adem",101,"djariadem@gmail.com");
        listagent.add(a2);
        Agentimmobilier a3=new Agentimmobilier("tariq","noufel",102,"tariqnoufel@gmail.com");
        listagent.add(a3);
        Agentimmobilier a4=new Agentimmobilier("choufni","samy",103,"choufnisamy@gmail.com");
        listagent.add(a4);
        Agentimmobilier a5=new Agentimmobilier("lawlawa","abdou",104,"lawlawaabdou@gmail.com");
        listagent.add(a5);
        
        populateBiensAchat();
        populateBiensALouer();

        this.setLayout(new BorderLayout());

        JLabel label = new JLabel();
        label.setText("est-ce que vous etes un demandeur de logement oú un fournisseur de logement");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font(null, Font.BOLD, 48)); 
        label.setForeground(Color.BLACK);
        
        ButtonFourn = new JButton("Fournisseur");
        ButtonFourn.setFocusable(false);
        ButtonFourn.addActionListener(this);
        ButtonFourn.setPreferredSize(new java.awt.Dimension(400, 200));
        ButtonFourn.setFont(new Font("arial", Font.PLAIN, 32));
        
        ButtonClient = new JButton("Client");
        ButtonClient.setFocusable(false);
        ButtonClient.addActionListener(this);
        ButtonClient.setPreferredSize(new java.awt.Dimension(400, 200)); 
        ButtonClient.setFont(new Font("arial", Font.PLAIN, 32));
        
        ButtonExit = new JButton("EXIT");
        ButtonExit.setFocusable(false);
        ButtonExit.addActionListener(this);
        ButtonExit.setPreferredSize(new java.awt.Dimension(100, 50));
        ButtonExit.setFont(new Font("arial", Font.PLAIN, 24));

        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new GridBagLayout());
        ButtonPanel.setBackground(new Color(0xc5c6c7)); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(200, 100, 100, 100); 

        gbc.gridx = 0;
        gbc.gridy = 0;
        ButtonPanel.add(ButtonClient, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        ButtonPanel.add(ButtonFourn, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        ButtonPanel.add(ButtonExit, gbc);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Agence Immobiliere");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0xc5c6c7));

        this.add(label, BorderLayout.NORTH);
        this.add(ButtonPanel, BorderLayout.CENTER); 

        this.setVisible(true);
    }
    
    public int genererNombreAleatoire(int min, int max) {
        Random random = new Random();

        int nombreAleatoire = random.nextInt(max - min + 1) + min;

        return nombreAleatoire;
    }
    
    private void populateBiensAchat() {
        
        biensAchat.add(new Maison(1,"", "Maison", 200, 2, 1500000, "Alger", "Superbe maison avec piscine et vue sur mer (à vendre)", true));
        biensAchat.add(new Maison(2,"", "Maison", 150, 1, 1000000, "Oran", "Maison de ville moderne avec jardin (à vendre)", false));
        biensAchat.add(new Maison(1,"", "Maison", 250, 2, 1900000, "Setif", "Superbe maison avec piscine  (à vendre)", true));
        biensAchat.add(new Maison(2,"", "Maison", 150, 1, 1000000, "Batna", "Maison de ville moderne avec jardin (à vendre)", false));

        biensAchat.add(new Appartement(3,"", "Appartement", 80, 3, 800, "Skikda", "Appartement lumineux en centre-ville (à vendre)", 2));
        biensAchat.add(new Appartement(4,"", "Appartement", 70, 2, 600, "Oran", "Appartement vue mer idéal pour un pied-à-terre (à vendre)", 1));
        biensAchat.add(new Appartement(3,"", "Appartement", 90, 3, 1100, "Alger", "Appartement lumineux en centre-ville (à vendre)", 2));
        biensAchat.add(new Appartement(4,"", "Appartement", 70, 2, 600, "Adrar", "Appartement environnement trés calme (à vendre)", 1));
    }

    private void populateBiensALouer() {
        biensALouer.add(new Maison(5,"", "Maison", 120, 3, 800000, "Setif", "Maison de plain-pied dans un quartier calme (à louer)", false));
        biensALouer.add(new Maison(6,"", "Maison", 180, 2, 1200000, "Boumerdes", "Maison de style colonial avec grand terrain (à louer)", true));

        biensALouer.add(new Appartement(7,"", "Appartement", 50, 1, 500, "Oran", "Studio moderne et fonctionnel (à louer)", 1));
        biensALouer.add(new Appartement(8,"", "Appartement", 100, 4, 1000, "Batna", "Appartement familial spacieux (à louer)", 3));
    }
    
    public void populateBiensAchat1() {
        for (BienImmobilier bien : biensAchat) {
            int indexAgent = genererNombreAleatoire(0, listagent.size() - 1);
            String responsable = listagent.get(indexAgent).getNom();
            bien.setResponsable(responsable);
        }
    }
    
    public void populateBiensALouer1() {
        for (BienImmobilier bien : biensALouer) {
            int indexAgent = genererNombreAleatoire(0, listagent.size() - 1);
            String responsable = listagent.get(indexAgent).getNom();
            bien.setResponsable(responsable);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ButtonFourn) {
            this.dispose();
            new Fournisseur();
        }
        if (e.getSource() == ButtonClient) {
            this.dispose();
            new Demandeur(biensAchat,biensALouer);
        }
        if (e.getSource() == ButtonExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
