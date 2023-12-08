package modele;

import java.util.Objects;

public class Adresse {

    private String coordonnees;

    public Adresse() {
    }

    public Adresse(String coordonnees) {
        this.coordonnees = coordonnees;
    }

    public String getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(String coordonnees) {
        this.coordonnees = coordonnees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresse adresse = (Adresse) o;
        return Objects.equals(coordonnees, adresse.coordonnees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordonnees);
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "coordonnees='" + coordonnees + '\'' +
                '}';
    }
}
