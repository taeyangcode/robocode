package coreysrobots;
import robocode.*;
import java.util.*;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Cobot - a robot by (your name here)
 */
public class Cobot extends Robot {
	private int direction;
	
	public void run() {
	
		while(true) {
			turnToDegree();
			ahead(getRandomDistance());
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		fire(1);
	}

	public void onHitByBullet(HitByBulletEvent e) {
		
	}
	
	public void onHitWall(HitWallEvent e) {
	
	}
	
	public void turnToDegree() {
		direction = findHorOrVert();
		System.out.println(direction);
		System.out.println(findXQuadrant());
		System.out.println(findYQuadrant());
		
		if(direction == 0 && findXQuadrant() == 0) {
			turnRight(getTurnDegrees(90));
		}
		else if(direction == 0 && findXQuadrant() == 1) {
			turnRight(getTurnDegrees(270));
		}
		else if(direction == 1 && findYQuadrant() == 0) {
			turnRight(getTurnDegrees(0));
		}
		else if(direction == 1 && findYQuadrant() == 1) {
			turnRight(getTurnDegrees(180));
		}
	}
	
	/*
	 * findXQuadrant:
	 * Checks if robot is in positive (0) or negative (1) X axis
	 */
	public int findXQuadrant() {
		if(getX() >= 750) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	/*
	 * findYQuadrant:
	 * Checks if robot is in positive (0) or negative (1) Y axis
	 */
	public int findYQuadrant() {
		if(getY() >= 750) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	/*
	 * getRandomDistance:
	 * Randomly returns a distance (double)
	 */
	public double getRandomDistance() {
		Random rd = new Random();
		return rd.nextDouble() * 300 + 600;
	}
	
	/*
	 * findHorOrVert:
	 * Randomly returns 0 (horizontal) or 1 (vertical)
	 */
	public int findHorOrVert() {
		Random rd = new Random();
		return rd.nextInt(2);
	}
	
	/*
	 * getTurnDegrees:
	 * Returns amount of degrees the robot needs to turn in order to face a certain degree
	 */
	public double getTurnDegrees(double finDeg) {
		return (360 - getHeading() + finDeg) % 360;
	}
}
