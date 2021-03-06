/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Add your docs here.
 */
public class drive_subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonSRX backLeftMotor = null;
  WPI_TalonSRX frontLeftMotor = null;
  WPI_TalonSRX backRightMotor = null;
  WPI_TalonSRX frontRightMotor = null;
  DifferentialDrive difDrive = null;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new drive_command());
  }
  public drive_subsystem(){
    frontRightMotor = new WPI_TalonSRX(RobotMap.MOTOR_LEFT_1);
    frontLeftMotor = new WPI_TalonSRX(RobotMap.MOTOR_LEFT_2);
    backRightMotor = new WPI_TalonSRX(RobotMap.MOTOR_RIGHT_1);
    backLeftMotor = new WPI_TalonSRX(RobotMap.MOTOR_RIGHT_2);
    SpeedControllerGroup leftMotors = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(frontRightMotor, backRightMotor);
    difDrive = new DifferentialDrive(leftMotors, rightMotors);
  }
  public void drive(double leftSpeed, double rightSpeed){
    difDrive.tankDrive(leftSpeed, rightSpeed);

  }
}
