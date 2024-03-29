// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
// import frc.robot.commands.Autos;

import frc.robot.subsystems.DriveTrain;

import frc.robot.subsystems.Outtake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final Outtake m_outtakeSubsystem = new Outtake();
  private final DriveTrain m_driveTrain = new DriveTrain();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    m_driveTrain.setDefaultCommand(new RunCommand(() -> {
      double move = m_driverController.getLeftY();
      double turn = m_driverController.getRightX();

      m_driveTrain.driveArcade(move, turn);
    }, m_driveTrain));

    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

    m_driverController.rightBumper()
      .onTrue(Commands.runOnce(() -> m_outtakeSubsystem.startConveyor()))
      .onFalse(Commands.runOnce(() -> m_outtakeSubsystem.stopConveyor()));

    // m_driverController.a()
    //   .onTrue(Commands.run(() -> m_outtakeSubsystem.setConveyorSpeed(m_driverController.getRightTriggerAxis())))
    //   .onFalse(Commands.runOnce(() -> m_outtakeSubsystem.stopConveyor()));

    
    // Start Shooter Roller
    m_driverController.leftBumper()
      .onTrue(Commands.run(() -> m_outtakeSubsystem.setShooterSpeed(m_driverController.getLeftTriggerAxis())))
      .onFalse(Commands.runOnce(() -> m_outtakeSubsystem.stopShooter()));

    // m_driverController.rightStick().toggleOnTrue(new StartEndCommand(
    //     () -> m_driveTrain.enableSpeedLimiter(),
    //     () -> m_driveTrain.enableSpeedLimiter(), 
    //     m_driveTrain));
      
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    // return Autos.exampleAuto(m_exampleSubsystem);
    return null;
  }
}
