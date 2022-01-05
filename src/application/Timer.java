package application;




import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


import javafx.scene.text.Text;
import javafx.util.Duration;

public class Timer implements EventHandler<ActionEvent> {

	@FXML
	private Button start;
	@FXML
	private Button stopwatch;
	@FXML
	private Button clear;
	@FXML
	private Button stop;
	@FXML
	private Text timer;
	@FXML
	private TextArea datetime;

	Time time = new Time("00:00:00:00");

	Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.01), e -> {
		if (time.getCurrentTime().equals(datetime.getText())) {
			datetime.getText();
		}
		time.oneSecondPassed();
		timer.setText(time.getCurrentTime());
	}));

	@Override
	public void handle(ActionEvent event) {//Starta klocka		
		timer.setText(time.getCurrentTime());

		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
		clear.setOnAction(new EventHandler<ActionEvent>() {//Rensa

			@Override
			public void handle(ActionEvent event) {
				datetime.clear();
				timer.setText("00:00:00:00");
				
			}
		});
		stop.setOnAction(new EventHandler<ActionEvent>() {//Stanna klocka

			@Override
			public void handle(ActionEvent event) {
				timeline.stop();
				
			}
		});
		stopwatch.setOnAction(new EventHandler<ActionEvent>() { //Ta tid, stoppur

			@Override
			public void handle(ActionEvent event) {		
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				
				
				datetime.appendText(dateFormat.format(date)+"\t\t\t\t\t      "+time.getCurrentTime()+"\n");
				
			}
			
			
			

		});

	}
}
