package com.breadeightn.panaderias;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PanaderiasApplication extends Application {
	public static ConfigurableApplicationContext context;
	public static Parent root;
	public static Stage primaryStage;
	public static void main(String[] args) {
		launch(args);
		SpringApplication.run(PanaderiasApplication.class,args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		context = SpringApplication.run(PanaderiasApplication.class);
		FXMLLoader fxmlLoader = new FXMLLoader(PanaderiasApplication.class.getResource("/views/login.fxml"));
		fxmlLoader.setControllerFactory(context::getBean);
		Scene scene = new Scene(fxmlLoader.load(),1280,720,false, SceneAntialiasing.BALANCED);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
