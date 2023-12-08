package controleur;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import modele.Adresse;

import java.util.ArrayList;
import java.util.List;


public class AppControleurFX {

    // Variables
    @FXML
    private ListView<String> listViewAdresses;
    @FXML
    private ListView<String> listViewRoute;

    private List<Adresse> adresseList;

    // Méthodes
    // Charge les adresses de la bd
    @FXML
    public void chargerOnClick(){
        for (Adresse adresse : adresseList) {
            listViewAdresses.getItems().add(adresse.getCoordonnees());
        }
    }

    // Genere la route optimale en fonction des adresses selectionnées
    @FXML
    public void genererOnClick(){
        ObservableList<String> selectedItems = listViewAdresses.getSelectionModel().getSelectedItems();

        for (String coordonnees: selectedItems) {
            if (!listViewRoute.getItems().contains(coordonnees)) {
                listViewRoute.getItems().add(coordonnees);
            }
        }
    }

    @FXML
    public void initialize(){
        listViewAdresses.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        adresseList = new ArrayList<>();

        Adresse adresse1 = new Adresse("123");
        Adresse adresse2 = new Adresse("345");
        Adresse adresse3 = new Adresse("567");
        Adresse adresse4 = new Adresse("789");

        adresseList.add(adresse1);
        adresseList.add(adresse2);
        adresseList.add(adresse3);
        adresseList.add(adresse4);
    }
}
