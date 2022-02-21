module de.jefrickel.spielwiese.fx.spielwiesefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens de.jefrickel.spielwiese.fx.spielwiesefx to javafx.fxml;
    exports de.jefrickel.spielwiese.fx.spielwiesefx;
}