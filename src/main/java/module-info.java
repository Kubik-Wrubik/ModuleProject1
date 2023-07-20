module com.example.encryptprogect {
	requires javafx.controls;
	requires javafx.fxml;

	requires org.controlsfx.controls;
	requires org.kordamp.bootstrapfx.core;

	opens com.example.encryptprogect to javafx.fxml;
	exports com.example.encryptprogect;
}