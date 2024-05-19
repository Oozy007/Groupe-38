import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Demandeur extends JFrame implements ActionListener{
	
    private List<BienImmobilier> biensAchat;
    private List<BienImmobilier> biensALouer;

	JButton ButtonAchat;
	JButton ButtonLouer;
	JButton RetButton; 
	
	public Demandeur(List<BienImmobilier> biensAchat, List<BienImmobilier> biensALouer) { 
        this.biensAchat = biensAchat;
        this.biensALouer = biensALouer;
		
		this.setLayout(new BorderLayout());
		
		JLabel label = new JLabel();
        label.setText("est-ce que vous vouler acheter oÃº louer");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font(null, Font.BOLD, 52)); 
        label.setForeground(Color.BLACK);
		
        ButtonAchat = new JButton("Acheteur");
        ButtonAchat.setFocusable(false);
        ButtonAchat.addActionListener(this);
        ButtonAchat.setPreferredSize(new java.awt.Dimension(400, 200));
        ButtonAchat.setFont(new Font("arial", Font.PLAIN, 32));
        
        ButtonLouer = new JButton("locataire");
        ButtonLouer.setFocusable(false);
        ButtonLouer.addActionListener(this);
        ButtonLouer.setPreferredSize(new java.awt.Dimension(400, 200)); 
        ButtonLouer.setFont(new Font("arial", Font.PLAIN, 32));
        
        RetButton = new JButton("RET");
        RetButton.setFocusable(false);
        RetButton.addActionListener(this);
        RetButton.setPreferredSize(new java.awt.Dimension(100, 50));
        RetButton.setFont(new Font("arial", Font.PLAIN, 24));

        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new GridBagLayout());
        ButtonPanel.setBackground(new Color(0xc5c6c7)); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(200, 100, 100, 100); 

        gbc.gridx = 0;
        gbc.gridy = 0;
        ButtonPanel.add(ButtonAchat, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        ButtonPanel.add(ButtonLouer, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        ButtonPanel.add(RetButton, gbc);
        
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Demandeur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0xc5c6c7));
	
        this.add(label, BorderLayout.NORTH);
        this.add(ButtonPanel, BorderLayout.CENTER);
        
        this.setVisible(true);
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ButtonAchat) {
        	new Acheteur(biensAchat);
        	this.dispose();
        }
        if (e.getSource() == ButtonLouer) {
        	new Locataire(biensALouer);
        	this.dispose();
        }
        if (e.getSource() == RetButton) {
        	new App();
        	this.dispose();
        }
    }
}