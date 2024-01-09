// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  private final PWMTalonSRX m_motorLeftFront = new PWMTalonSRX(Constants.DriveTrain.motorLeftFrontPort);
  private final PWMTalonSRX m_motorLeftRear = new PWMTalonSRX(Constants.DriveTrain.motorLeftRearPort);
  private final PWMTalonSRX m_motorRightFront = new PWMTalonSRX(Constants.DriveTrain.motorRightFrontPort);
  private final PWMTalonSRX m_motorRightRear = new PWMTalonSRX(Constants.DriveTrain.motorRightRearPort);

  private final DifferentialDrive m_drive = new DifferentialDrive(m_motorLeftFront, m_motorRightFront);

  private double m_currentMaxSpeed = Constants.DriveTrain.regularSpeed;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    m_motorLeftFront.setInverted(true);

    m_motorLeftFront.addFollower(m_motorLeftRear);
    m_motorRightFront.addFollower(m_motorRightRear);
  }

  public Command enableSpeedLimiter() {
    return this.runOnce(() -> {
      m_currentMaxSpeed = Constants.DriveTrain.slowSpeed;
    });
  }

  public Command enableRegularSpeed() {
    return this.runOnce(() -> {
      m_currentMaxSpeed = Constants.DriveTrain.regularSpeed;
    });
  }

  public void driveArcade(double move, double rotate) {
    m_drive.arcadeDrive(m_currentMaxSpeed * move, m_currentMaxSpeed * rotate, true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
