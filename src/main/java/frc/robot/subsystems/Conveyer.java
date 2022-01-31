// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Conveyer extends SubsystemBase
{
  public Spark motor1, motor2;
  /** Creates a new Conveyer. */
  public Conveyer() 
  {
    motor1 = new Spark(Constants.CONVEYER_MOTOR1);
    motor2 = new Spark(Constants.CONVEYER_MOTOR2);
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
  public void set(double speed1, double speed2)
  {
    motor1.set(speed1);
    motor2.set(speed2);
  }
}
