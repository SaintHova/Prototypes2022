// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterJF extends SubsystemBase 
{
  public Spark shooterMotor;

  /** Creates a new ShooterJF. */
  public ShooterJF() 
  {
    shooterMotor = new Spark(Constants.SHOOTER_MOTOR);
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
  public void runShooter(double speed)
  {
    shooterMotor.set(speed);
  }
}
