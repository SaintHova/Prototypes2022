// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterJF extends SubsystemBase 
{
  public CANSparkMax shooterMotor;
  public double position, velocity;

  /** Creates a new ShooterJF. */
  public ShooterJF() 
  {
    shooterMotor = new CANSparkMax(Constants.SHOOTER_MOTOR2, MotorType.kBrushless);

    position = shooterMotor.getEncoder().getPosition();
    velocity = shooterMotor.getEncoder().getVelocity();
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
