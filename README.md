Used JavaSE-11 (jdk-11.0.4.11)

To compile you need javafx-sdk-11.0.2
All .jar files, and only .jar files need to be loaded into the libraries of the build path.

To execute you must add "--module-path "${eclipse_home}/javafx-sdk-11.0.2/lib" --add-modules
javafx.controls,javafx.fxml" to the VM Arguments in the run configuration
