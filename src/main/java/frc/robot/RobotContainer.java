// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Conveyer;
import frc.robot.subsystems.IntakeJP;
import frc.robot.subsystems.ShooterJF;
import frc.robot.subsystems.ShooterJG;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer 
{
  // The robot's subsystems and commands are defined here...
  private final ShooterJG shooterJG = new ShooterJG();
  private final IntakeJP intakeJP = new IntakeJP();
  private final ShooterJF shooterJF = new ShooterJF();
  private final Conveyer conveyer = new Conveyer();

  public Joystick logi = new Joystick(0);
  private JoystickButton shootClose, shootFar, runIntake, runConveyer;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() 
  {
    // Configure the button bindings
    configureButtonBindings();

    // shooterJG.setDefaultCommand(
    //   new RunCommand(()-> shooterJG.shootVar(logi.getRawAxis(-1), logi.getRawAxis(-0)),
    //   shooterJG));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {
    //REMOVE SUBSYTEMS THAT ARE NOT BEING TESTED
    //X
    shootClose = new JoystickButton(logi, 1); 
    shootClose.toggleWhenPressed(new StartEndCommand(()-> shooterJG.set(.45, .7), ()-> shooterJG.set(0, 0), shooterJG));
    // shootClose.whileHeld(new StartEndCommand(()-> shooterJG.set(.45, .7), ()-> shooterJG.set(0, 0), shooterJG));

    //A
    shootFar = new JoystickButton(logi, 2); 
    shootFar.toggleWhenPressed(new StartEndCommand(()-> shooterJG.set(.65, .9), ()-> shooterJG.set(0, 0), shooterJG));
    // shootFar.whileHeld(new StartEndCommand(()-> shooterJG.set(.65, .9), ()-> shooterJG.set(0, 0), shooterJG));

    //B
    runIntake = new JoystickButton(logi, 3);
    runIntake.toggleWhenPressed(new StartEndCommand(()-> intakeJP.set(1), ()-> intakeJP.set(0), intakeJP));
    // runIntake.whenHeld(new StartEndCommand(()-> intakeJP.set(1), ()-> intakeJP.set(0), intakeJP));

    //Y
    runConveyer = new JoystickButton(logi, 4);
    runConveyer.toggleWhenPressed(new StartEndCommand(()-> conveyer.set(1, 1), ()-> conveyer.set(0, 0), conveyer));
    // runConveyer.whileHeld(new StartEndCommand(()-> conveyer.set(1, 1), ()-> conveyer.set(1, 1), conveyer));
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