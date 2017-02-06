package org.usfirst.frc.team4959.robot.utill;
/**
 * Keeps speed within 2 given vales so gyro can pick up robot moment. 
 */
public class JMath {
	public static int clamp(int number, int min, int max) {
		if (number < min)
			number = min;
		else if (number > max)
			number = max;
		return number;
	}
	
	public static double clamp(double number, double min, double max) {
		if (number < min)
			number = min;
		else if (number > max)
			number = max;
		return number;
	}	public static long clamp(long number, long min, long max) {
		if (number < min)
			number = min;
		else if (number > max)
			number = max;
		return number;
	}
}
