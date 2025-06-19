package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class Main extends Application {
	private Stage stage;
	private Scene scene;
	private BorderPane borderPane;
	private HBox hBox;
	
	private Media media;
	private MediaPlayer mediaPlayer;
	private MediaView mediaView;
	
	private String MEDIA_URL = "https://www.youtube.com/watch?v=95ahbau-rJk.mp4";
	
	
	private Button btnPlay;
	private Button btnPause;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			stage = new Stage();
			
			stage.setTitle("MediaPlayer");
			borderPane = new BorderPane();
			
			// Create MediaPlayer
			media = new Media(MEDIA_URL);
			mediaPlayer = new MediaPlayer(media);
			
			mediaPlayer.setAutoPlay(true);
			
			mediaPlayer.setOnReady(()->stage.sizeToScene());
			mediaView = new MediaView(mediaPlayer);
			
			borderPane.setCenter(mediaView);
			
			btnPlay = new Button(">");
			btnPause = new Button("||");
			
			hBox = new HBox(18);
			hBox.getChildren().addAll(btnPlay,btnPause);
			hBox.setPadding(new Insets(10));
			
			scene = new Scene(borderPane);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
