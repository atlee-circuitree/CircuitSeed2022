// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
  
  private DifferentialDrive drive; 
  private CANSparkMax frontLeftMotor;
  private CANSparkMax frontRightMotor;
  private CANSparkMax rearLeftMotor;
  private CANSparkMax rearRightMotor;
  private MotorControllerGroup leftMotors;
  private MotorControllerGroup rightMotors;
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {

    frontLeftMotor = new CANSparkMax(2, MotorType.kBrushless);
    frontRightMotor = new CANSparkMax(1, MotorType.kBrushless);
    rearLeftMotor = new CANSparkMax(3, MotorType.kBrushless);
    rearRightMotor = new CANSparkMax(4, MotorType.kBrushless);
    
    leftMotors = new MotorControllerGroup(frontLeftMotor, rearLeftMotor);
    rightMotors = new MotorControllerGroup(frontRightMotor, rearRightMotor);
    
    drive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void tankDrive(Double speed, Double rotation){

    drive.arcadeDrive(speed, rotation);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
