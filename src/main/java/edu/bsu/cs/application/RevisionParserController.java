package edu.bsu.cs.application;

import edu.bsu.cs.WikiApiFetcher;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RevisionParserController {
    @FXML
    private TextField urlField;
    @FXML
    private TextArea outputArea;

    @FXML
    private void getDetails() {
        String articleTitle = urlField.getText();
        String outputText;

        urlField.setDisable(true);

        try {
            outputText = WikiApiFetcher.checkThenFetch(articleTitle).toString();
        }
        catch (Exception e) {
            errorPopup_showError(e);
            outputText = "";
        }
        finally {
            urlField.setDisable(false);
        }

        outputArea.setText(outputText);
    }

    @FXML
    private void errorPopup_showError(Exception exception) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        String exceptionName = exception.getClass().getSimpleName();
        String exceptionDetails = exception.getMessage();

        alert.setTitle(exceptionName);
        alert.setHeaderText(exceptionName);
        alert.setContentText(exceptionDetails);
        alert.showAndWait();
    }

    @FXML
    private void clearText() {
        urlField.setText("");
        outputArea.setText("");
    }
}
