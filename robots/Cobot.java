package coreysrobots;
import robocode.*;
import java.util.*;

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
	
	/*
	 * turnToDegree:
	 * Method moves robot while preventing it from colliding with walls
	 */
	public void turnToDegree() {
		direction = findHorOrVert();
		
		if(direction == 0 && findXQuadrant() == 0) {
			turnFast(90);
		}
		else if(direction == 0 && findXQuadrant() == 1) {
			turnFast(270);
		}
		else if(direction == 1 && findYQuadrant() == 0) {
			turnFast(0);
		}
		else if(direction == 1 && findYQuadrant() == 1) {
			turnFast(180);
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
		return rd.nextDouble() * 300 + 450;
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
	 * turnFast:
	 * Returns amount of degrees the robot needs to turn in order to face a certain degree
	 * Credits: Seungjae Lee
	 */
	public void turnFast(double finDeg) {
        double firstFourth = (360 - getHeading() + finDeg) % 180;
        double secondThird = (360 + getHeading() - finDeg) % 180;
        if(firstFourth == 0) {
            firstFourth = 180;
        }
        if(secondThird == 0) {
            secondThird = 180;
        }
        if(getHeading() >= 0 && getHeading() < 180) {
            if(getHeading() + 180 >= finDeg && finDeg >= getHeading()) {
                turnRight(firstFourth);
            }
            else {
                turnLeft(secondThird);
			}
        }
        else if(getHeading() - 180 <= finDeg && finDeg <= getHeading()) {
            turnLeft(secondThird);
        }
        else {
            turnRight(firstFourth);
        }
    }
}
