package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.openjfx.viewController.CodedViewController;
import org.openjfx.viewController.MyViewController;
import org.openjfx.views.MyView;

import java.io.IOException;


public class DavidsApp extends Application {

    private Stage stage;


    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        this.showPrimaryScene();
    }

    @Override
    public void init() throws Exception {
        System.out.println("I am number #1");
    }

    @Override
    public void stop() throws Exception {
        System.out.println("I am number #3");
    }

    /**
     * Load a scene by its name in the fxml folder
     *
     * @param name path og
     * @throws IOException
     */
    public void loadScene(String name) throws IOException {
        this.loadScene(name, null);
    }

    /**
     * Given the path of a fxml file and a stylesheet, this method
     * First loads the scene.
     * Then applies the stylesheet towards the scene (in case it is not null)
     * <p>
     * Note: The Root Stylesheet will always be set onto the new View
     *
     * @param name
     * @param stylesheet
     * @throws IOException
     */
    public void loadScene(String name, String stylesheet) throws IOException {
        Scene scene = this.loadSceneFromFile(name);

        if (stylesheet != null) {
            String sheetPath = "fxml/css/" + stylesheet + ".css";
            scene.getStylesheets().add(DavidsApp.class.getResource(sheetPath).toExternalForm());
        }

        String rootPath = "fxml/css/root.css";
        scene.getStylesheets().add(DavidsApp.class.getResource(rootPath).toExternalForm());

        stage.setTitle(name);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Load the scene from the fxml file, and setup its viewcontroller
     *
     * @param name Path of the Scene
     * @return Scene object
     * @throws IOException
     */
    private Scene loadSceneFromFile(String name) throws IOException {
        // Load ressource
        FXMLLoader fxmlLoader = new FXMLLoader(DavidsApp.class.getResource("fxml/" + name + ".fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Set reference to main Application
        MyViewController controller = fxmlLoader.getController();
        controller.setMainApp(this);

        return scene;
    }

    /**
     * Shows the primary Scene (Selection Menu) of the program
     *
     * @throws IOException
     */
    public void showPrimaryScene() throws IOException {
        this.loadScene("primary");
    }

    /**
     * Shows the Control Scene with some controls available in FXML
     *
     * @throws IOException
     */
    public void showControlsScene() throws IOException {
        this.loadScene("controlElements");
    }

    /**
     * Shows the Scene, that will (eventually) launch a Game ( but does not)
     *
     * @throws IOException
     */
    public void showCodedScene() {
        MyView view = new MyView();
        CodedViewController controller = new CodedViewController();
        view.setController(controller);
        controller.setMainApp(this);

        Scene scene = new Scene(view);
        stage.setTitle("HardCodedView :(");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Shows the same scene as hard coded in java , just rebuild with fxml
     *
     * @throws IOException
     */
    public void showCodedSceneFXML() throws IOException {
        this.loadScene("codedViewFXML");
    }

    /**
     * Shows the same scene as hard coded in java, but with fxml and style
     *
     * @throws IOException
     */
    public void showCodedSceneWithStyle() throws IOException {
        this.loadScene("codedViewFXML", "codedViewStyle");
    }

    public static void main(String[] args) {
        launch(); // Launches the JavaFX Application
    }
}