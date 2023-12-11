package controleur;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import modele.ConsommationRest;

import java.util.ArrayList;
import java.util.List;


public class AppControleurFX {

    // Variables
    @FXML
    private ListView<String> listViewAdresses;
    @FXML
    private ListView<String> listViewRoute;

    private ConsommationRest consommationRest;

    private List<String> adresseList;
    private List<String> selectionList;

    // Méthodes
    // Charge les adresses de la bd
    @FXML
    public void chargerOnClick(){
        listViewAdresses.getItems().clear();

        for (String s : adresseList) {
            listViewAdresses.getItems().add(s);
        }
    }

    @FXML
    public void ajouterAdresseOnClick(){
        ObservableList<String> selectedItems = listViewAdresses.getSelectionModel().getSelectedItems();

        for (String coordonnees: selectedItems) {
            if (!listViewRoute.getItems().contains(coordonnees)) {
                listViewRoute.getItems().add(coordonnees);
            }
        }
    }

    // Genere la route optimale en fonction des adresses selectionnées
    @FXML
    public void genererOnClick(){
        selectionList = listViewRoute.getItems();


    }

    @FXML
    public void initialize(){
        listViewAdresses.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        adresseList = new ArrayList<>();

        consommationRest = new ConsommationRest();

        adresseList = consommationRest.getAllClientsDetails();
    }
}
