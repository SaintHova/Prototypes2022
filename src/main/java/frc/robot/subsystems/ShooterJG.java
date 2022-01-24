// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ShooterJG extends SubsystemBase 
{
  public Spark topMotor, bottomMotor;
  ShuffleboardTab shooter = Shuffleboard.getTab("Shooter");

  NetworkTableEntry motorPowerTop = 
  shooter.add("Top Motor: ", 0)
    .withSize(2, 1)
    .withPosition(0, 0)
    .getEntry();
  NetworkTableEntry motorPowerBottom = 
  shooter.add("Bottom Motor: ", 0)
    .withSize(2, 1)
    .withPosition(0, 2)
    .getEntry();
    
  private int cnt;
  /** Creates a new Shooter. */
  public ShooterJG() 
  {
    topMotor = new Spark(Constants.SHOOTER_MOTOR);
    topMotor = new Spark(Constants.SHOOTER_MOTOR2);

    cnt = 1;
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
  public void close(double top, double bottom)
  {
    this.cnt+=1;
    if(this.cnt%2==0)
    {
      System.out.println("Cnt: " + cnt);
      topMotor.set(top);
      bottomMotor.set(bottom);
    }
    else
    {
      System.out.println("Cnt: " + cnt + " Whatever this returns: " + topMotor.toString());
      topMotor.set(0);
      bottomMotor.set(0);
    }

    motorPowerTop.setDouble(top);
    motorPowerBottom.setDouble(bottom);
  }
  public void far(double top, double bottom)
  {
    this.cnt+=1;
    if(this.cnt%2==0)
    {
      System.out.println("Cnt: " + cnt);
      topMotor.set(top);
      bottomMotor.set(bottom);
    }
    else
    {
      System.out.println("Cnt: " + cnt + " Whatever this returns: " + topMotor.toString());
      topMotor.set(0);
      bottomMotor.set(0);
    }
    
    motorPowerTop.setDouble(top);
    motorPowerBottom.setDouble(bottom);
  }
  public void shootVar(double top, double bottom)
  {
    topMotor.set(top);
    bottomMotor.set(bottom);

    motorPowerTop.setDouble(top);
    motorPowerBottom.setDouble(bottom);
  }
  public void stopAll()
  {
    topMotor.set(0);
    bottomMotor.set(0);
    
    motorPowerTop.setDouble(0);
    motorPowerBottom.setDouble(0);
  }
}
/*
ah
class VisionCalculator {
   private ShuffleboardTab tab = Shuffleboard.getTab("Vision");
   private NetworkTableEntry distanceEntry =
       tab.add("Distance to target", 0)
          .getEntry();

   public void calculate() {
     double distance = ...;
     distanceEntry.setDouble(distance);
   }
 }
*/