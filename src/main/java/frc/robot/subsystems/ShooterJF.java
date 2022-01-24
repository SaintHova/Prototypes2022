// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterJF extends SubsystemBase 
{
  public CANSparkMax shooterMotor;
  ShuffleboardTab shooter2 = Shuffleboard.getTab("Shooter");

  NetworkTableEntry positionS = 
  shooter2.add("Position: ", 0)
    .withSize(2, 1)
    .withPosition(0, 0)
    .getEntry();
  NetworkTableEntry velocityS = 
  shooter2.add("Velcoity: ", 0)
    .withSize(2, 1)
    .withPosition(0, 2)
    .getEntry();
    
  /** Creates a new ShooterJF. */
  public ShooterJF() 
  {
    shooterMotor = new CANSparkMax(Constants.SHOOTER_MOTOR2, MotorType.kBrushless);


  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
  public void runShooter(double speed)
  {
    shooterMotor.set(speed);

    positionS.setDouble(shooterMotor.getEncoder().getPosition());
    velocityS.setDouble(shooterMotor.getEncoder().getVelocity());
  }
}
