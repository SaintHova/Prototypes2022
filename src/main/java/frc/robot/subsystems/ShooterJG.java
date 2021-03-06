// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ShooterJG extends SubsystemBase 
{
  public Spark topMotor, bottomMotor;
  /** Creates a new Shooter. */
  public ShooterJG() 
  {
    topMotor = new Spark(Constants.SHOOTER_MOTOR);
    bottomMotor = new Spark(Constants.SHOOTER_MOTOR2);
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
  public void set(double top, double bottom)
  {
    topMotor.set(top);
    bottomMotor.set(bottom);
  }
}