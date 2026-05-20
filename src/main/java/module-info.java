module com.depo.smartwarehousegui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.depo.smartwarehousegui to javafx.fxml;
    exports com.depo.smartwarehousegui;
}