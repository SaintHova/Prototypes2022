// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase 
{
  public CANSparkMax frontL, frontR, backL, backR;
  public DoubleSupplier leftSpeed, rightSpeed;
  public MotorControllerGroup left = new MotorControllerGroup(frontL, backL);
  public MotorControllerGroup right = new MotorControllerGroup(frontR, backR);
  public DifferentialDrive drive;
  /** Creates a new Drivetrain. */
  public Drivetrain() 
  {
    frontL = new CANSparkMax(Constants.FRONTL, MotorType.kBrushless);
    frontR = new CANSparkMax(Constants.FRONTR, MotorType.kBrushless);
    backL = new CANSparkMax(Constants.BACKL, MotorType.kBrushless);
    backR = new CANSparkMax(Constants.BACKR, MotorType.kBrushless);

    left.setInverted(true);

    drive = new DifferentialDrive(left, right);
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
  public void tankDrive(double leftSpeed, double rightSpeed)
  {
    drive.tankDrive(leftSpeed, rightSpeed);
  }
}
