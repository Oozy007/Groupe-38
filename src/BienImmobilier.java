import java.util.Objects;

public abstract class BienImmobilier {

    private int id;
    private String responsable;
    private String typeBien;
    private double surface;
    private double prix;
    private String localisation;
    private String description;

    public BienImmobilier(String typeBien, double surface, double prix, String localisation, String description,String responsable) {
        id++;
        this.typeBien = typeBien;
        this.surface = surface;
        this.prix = prix;
        this.localisation = localisation;
        this.description = description;
        this.responsable =responsable;
    }

    public int getId() {
        return id;
    }
    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }


    public String getTypeBien() {
        return typeBien;
    }

    public double getSurface() {
        return surface;
    }

    public double getPrix() {
        return prix;
    }

    public String getLocalisation() {
        return localisation;
    }

    public String getDescription() {
        return description;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    

	public void setTypeBien(String typeBien) {
		this.typeBien = typeBien;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BienImmobilier that = (BienImmobilier) o;
        return id == that.id &&
                Double.compare(surface, that.surface) == 0 &&
                Double.compare(prix, that.prix) == 0 &&
                Objects.equals(typeBien, that.typeBien) &&
                Objects.equals(localisation, that.localisation) &&
                Objects.equals(description, that.description); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeBien, surface, prix, localisation, description);
    }

    @Override
    public String toString() {
        return "BienImmobilier{" +
                "id =" + id +
                ", typeBien ='" + typeBien + '\'' +
                ", surface =" + surface +
                ", prix =" + prix +
                ", localisation ='" + localisation + '\'' +
                ", description ='" + description + '\'' +
                '}';
    }
}

class Maison extends BienImmobilier {

    private int nombreEtages;
    private Boolean piscine;

    public Maison(int id,String responsable, String typeBien, double surface, int nombreEtages, double prix, String localisation, String description, Boolean piscine) {
        super(typeBien, surface, prix, localisation, description,responsable);
        this.nombreEtages = nombreEtages;
        this.piscine = piscine;
    }

    public int getNombreEtages() {
        return nombreEtages;
    }

    @Override
    public String toString() {
        return super.toString() + ", nombre d'Etages =" + nombreEtages + ", piscine=" + piscine;
    }
}

class Appartement extends BienImmobilier {

    private int etage;

    public Appartement(int id,String responsable, String typeBien, double surface, int nombrePieces, double prix, String localisation, String description, int etage) {
        super(typeBien, surface, prix, localisation, description,responsable);
        this.etage = etage;
    }

    public int getEtage() {
        return etage;
    }

    @Override
    public String toString() {
        return super.toString() + ", etage ='" + etage + '\'' ;
    }
}