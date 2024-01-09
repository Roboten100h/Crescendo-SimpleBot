// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class DriveTrain {
    // PWM 
    public static final int motorLeftFrontPort = 0;
    public static final int motorLeftRearPort = 1;
    public static final int motorRightFrontPort = 2;
    public static final int motorRightRearPort = 3;

    public static final double slowSpeed = 0.5; 
    public static final double regularSpeed = 0.7;
  }

  public static class Outtake {
    public static final int shooterMotorCANPort = 2;
    public static final int conveyorMotorCANPort = 3;
    
    public static final double shooterSpeed = 1;
    public static final double conveyorSpped = 1;
  }
}
