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
  
  
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {

    CANSparkMax leftMotor1 = new CANSparkMax(4, MotorType.kBrushless);
    CANSparkMax leftMotor2 = new CANSparkMax(3, MotorType.kBrushless);
    CANSparkMax rightMotor1 = new CANSparkMax(1, MotorType.kBrushless);
    CANSparkMax rightMotor2 = new CANSparkMax(2, MotorType.kBrushless);

    MotorControllerGroup leftMotors = new MotorControllerGroup(leftMotor1, leftMotor2);
    MotorControllerGroup rightMotors = new MotorControllerGroup(rightMotor1, rightMotor2);

    rightMotors.setInverted(true);

    drive = new DifferentialDrive(leftMotors, rightMotors);

  }

  public void tankDrive(double speed, double rotation){
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
