/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/* FRC Team 7890 SeQuEnCe                                                     */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.kSpeedMults;
import frc.robot.Constants.kCANIds;

public class Elevator extends SubsystemBase {

  CANSparkMax elevatorMotor = new CANSparkMax(kCANIds.iElevator, MotorType.kBrushless);
  private final CANSparkMax ElevatorMotor; 
  private final CANEncoder ElevatorEncoder;

  public Elevator() {
    ElevatorMotor = new CANSparkMax(kCANIds.iLaunchAngle, MotorType.kBrushless);
    ElevatorEncoder = new CANEncoder(ElevatorMotor);
    ElevatorEncoder.setPosition(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed(double dSpeed) {
    elevatorMotor.set(kSpeedMults.dElevatorMult * dSpeed);
  }

  public double sendEncoderTicks() {
    return ElevatorEncoder.getPosition();
  }

}