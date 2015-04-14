package com.naif.facturacion.customnodes;

import javafx.animation.RotateTransition;
import javafx.animation.RotateTransitionBuilder;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Loading status.
 */
public class LoadingProgressIndicator extends Rectangle {
	
	private RotateTransition rotateTransition;
	
	public LoadingProgressIndicator() {
		super();
		setArcWidth(15);
		setArcHeight(15);                
        setFill(Color.ORANGE);
        setStrokeWidth(2.0);
        setStroke(Color.ALICEBLUE);
        getStrokeDashArray().addAll(2d);
        rotateTransition = RotateTransitionBuilder.create()
        	.node(this)
            .duration(Duration.seconds(1.5))
            .fromAngle(0)
            .toAngle(720)
            .cycleCount(Timeline.INDEFINITE)         
            .build();
	} // end : constructor
		
	public void play() {
        rotateTransition.play();
        setVisible(true);
    } // end : play Method
	
	public void stop() {
		setVisible(false);
        rotateTransition.stop();
    } // end : stop Method
	
}