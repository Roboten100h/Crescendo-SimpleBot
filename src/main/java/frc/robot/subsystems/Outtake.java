// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


public class Outtake extends SubsystemBase {

  private final VictorSPX m_conveyorMotor = new VictorSPX(Constants.Outtake.conveyorMotorCANPort);
  private final VictorSPX m_shooterMotor = new VictorSPX(Constants.Outtake.shooterMotorCANPort);

  private double m_shootingSpeed = Constants.Outtake.shooterSpeed;
  private double m_conveySpeed = Constants.Outtake.conveyorSpped;


  /** Creates a new Outtake. */
  public Outtake() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void startShooter() {
    m_shooterMotor.set(VictorSPXControlMode.PercentOutput, m_shootingSpeed);
  }

  public void setShooterSpeed(double speed){
    m_shooterMotor.set(VictorSPXControlMode.PercentOutput, speed);
  }

  public void stopShooter() {
    m_shooterMotor.set(VictorSPXControlMode.PercentOutput, 0);
  }

  public void startConveyor() {
    m_conveyorMotor.set(VictorSPXControlMode.PercentOutput, -m_conveySpeed);
  }

  public void startConveyorInverted() {
    m_conveyorMotor.set(VictorSPXControlMode.PercentOutput, m_conveySpeed);
  }

  public void setConveyorSpeed(double conveySpeed) {
    m_conveyorMotor.set(VictorSPXControlMode.PercentOutput, conveySpeed);
  }

  public void stopConveyor() {
    m_conveyorMotor.set(VictorSPXControlMode.PercentOutput, 0);
  }
}
