// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.XRPDrivetrain;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class  driveForward extends Command  {
  private final XRPDrivetrain drivetrain;
  private final PIDController m_pid = new PIDController(0.03,0,0);



  public driveForward (XRPDrivetrain subsystem) {
    this.drivetrain = subsystem;

    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.resetEncoders();
    m_pid.reset();
    m_pid.setTolerance(0.5);
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    drivetrain.arcadeDrive(0.7,0);
    

  }
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0, 0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_pid.atSetpoint();
    return drivetrain.getAverageDistanceInch()>=60;
  }
}
