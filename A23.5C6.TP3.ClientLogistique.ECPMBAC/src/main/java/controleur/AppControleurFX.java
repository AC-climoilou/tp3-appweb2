package controleur;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import modele.ConsommationRest;

import java.util.ArrayList;
import java.util.List;

/**
 * Controleur graphique de app.fxml
 */
public class AppControleurFX {

    // Variables
    @FXML
    private ListView<String> listViewAdresses;
    @FXML
    private ListView<String> listViewRoute;

    private ConsommationRest consommationRest;

    private List<String> adresseList;
    private List<String> selectionList;
    private String routeOptimale;

    // Méthodes

    /**
     * Charge les adresses des clients dans la listView de gauche
     */
    @FXML
    public void chargerOnClick(){
        listViewAdresses.getItems().clear();

        for (String s : adresseList) {
            listViewAdresses.getItems().add(s);
        }
    }

    /**
     * Ajoute les adresses selectionnees dans la listeView de droite
     */
    @FXML
    public void ajouterAdresseOnClick(){
        if (!listViewAdresses.getSelectionModel().getSelectedItems().isEmpty()){
            ObservableList<String> selectedItems = listViewAdresses.getSelectionModel().getSelectedItems();

            for (String coordonnees: selectedItems) {
                if (!listViewRoute.getItems().contains(coordonnees)) {
                    listViewRoute.getItems().add(coordonnees);
                }
            }
        }
    }

    @FXML
    public void enleverAdresseOnClick() {
        if (!listViewRoute.getSelectionModel().getSelectedItems().isEmpty()){
            ObservableList<String> selectedItems = listViewRoute.getSelectionModel().getSelectedItems();

            for (int i = selectedItems.size() - 1; i >= 0; i--) {
                listViewRoute.getItems().remove(selectedItems.get(i));
            }
        }
    }


    /**
     * Genere la route optimale en fonction des adresses dans la listView
     */
    @FXML
    public void genererOnClick(){
        if (!listViewRoute.getItems().isEmpty()){
            selectionList = listViewRoute.getItems();
            consommationRest.POST(selectionList);
            consommationRest.PUT();
        }
    }

    /**
     * Initialise des parametres au lancement de l'application
     */
    @FXML
    public void initialize(){
        listViewAdresses.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listViewRoute.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        adresseList = new ArrayList<>();

        consommationRest = new ConsommationRest();

        adresseList = consommationRest.getAllClientsDetails();
    }
}
