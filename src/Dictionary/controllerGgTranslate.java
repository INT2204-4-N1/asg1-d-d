package Dictionary;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class controllerGgTranslate implements Initializable {
    @FXML
    WebView webView;
    @FXML
    WebEngine engine;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        engine = webView.getEngine();
        String url = "https://translate.google.com.vn/";
        engine.load(url);
    }
}
