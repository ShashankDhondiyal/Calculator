module com.myapps {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens com.myapps to javafx.fxml;
    exports com.myapps;
}
