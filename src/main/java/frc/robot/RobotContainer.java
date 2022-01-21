// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer 
{
  // The robot's subsystems and commands are defined here...
  private final Shooter shooter = new Shooter();

  public Joystick logi = new Joystick(0);
  private JoystickButton shootClose, shootFar, shootStop;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() 
  {
    // Configure the button bindings
    configureButtonBindings();

    shooter.setDefaultCommand(
      new RunCommand(()-> shooter.shootVar(logi.getRawAxis(-1), logi.getRawAxis(-0)),
      shooter));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {
    //X
    shootClose = new JoystickButton(logi, 1); 
    shootClose.whenPressed(new InstantCommand(()-> shooter.close(.5, .7)));
    //shootClose.whileHeld(new StartEndCommand(()-> shooter.close(1, 1), ()-> shooter.close(0, 0), shooter));

    //A
    shootFar = new JoystickButton(logi, 2); 
    shootFar.whenPressed(new InstantCommand(()-> shooter.far(.7, .9)));
    //shootFar.whileHeld(new StartEndCommand(()-> shooter.far(1, 1), ()-> shooter.far(0, 0), shooter));


    //B
    shootStop = new JoystickButton(logi, 3); 
    shootStop.whenPressed(new InstantCommand(()-> shooter.stopAll()));

    //Y
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() 
  {
    // An ExampleCommand will run in autonomous
    return null;
  }
}