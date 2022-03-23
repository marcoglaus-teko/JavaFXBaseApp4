package ch.teko.oop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    private ObservableList<Artist> artists = FXCollections.observableArrayList();
    private ChinookHandler chinookHandler;

    @FXML
    public void initialize() {
        System.out.println("init ObservableList");
        this.artistsColumn.setCellValueFactory(new PropertyValueFactory<Artist, String>("name"));
        table1.setItems(this.getArtists());

        System.out.println("init Chinook DB connection");
        chinookHandler = ChinookHandler.getChinookHandlerInstance();
    }

    public ObservableList<Artist> getArtists() {
        return this.artists;
    }

    @FXML
    private TableColumn<Artist, String> artistsColumn;

    @FXML
    private Button button1;

    @FXML
    private TableView<Artist> table1;

    @FXML
    private TextField textField2;

    @FXML
    private Button button2;

    @FXML
    void listArtists(ActionEvent event) {
        ResultSet artists = chinookHandler.getArtists();
        try {
            // iterate ResultSet
            while (artists.next()) {
                String artistsName = artists.getString("Name");
                // System.out.println(artistsName);
                this.artists.add(new Artist(artistsName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void listTracks(ActionEvent event) {
        System.out.println(this.textField2.getText());

        ResultSet resultSet = chinookHandler.getTracksFromArtists(this.textField2.getText());
        try {
            // iterate ResultSet
            while (resultSet.next()) {
                String musicName = resultSet.getString("Name");
                System.out.println(musicName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
