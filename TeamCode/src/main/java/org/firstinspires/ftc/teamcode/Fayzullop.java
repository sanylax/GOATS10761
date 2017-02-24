/* Rushil is lit af.

Authors:
Neel <@neelrr1>
Rushil <@RushilSrivastava>
Santosh <@sanylax>

*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.RobotLog;


/**
 * Demonstrates empty OpModew88
 */
@Autonomous(name = "FayzullOp: Auto", group = "Teleop")
public class Fayzullop extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();

    //Define Wheels
    DcMotor leftMotor;
    DcMotor rightMotor;
    Servo gripperOne;

    //Define Arms
    DcMotor scissorArmRight;
    DcMotor scissorArmLeft;



    double gripPosition = 0.5;
    double gripSpeed = 0.1;

    @Override
    public void init() {

        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        scissorArmLeft = hardwareMap.dcMotor.get("left_scissor");
        scissorArmRight = hardwareMap.dcMotor.get("right_scissor");
        gripperOne = hardwareMap.servo.get("gripper");
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        telemetry.addData("Status", "Initialized");



    }


    @Override
    public void init_loop() {

    }

    /*
     * This method will be called ONCE when start is pressed
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
     */
    @Override
    public void start() {

        runtime.reset();
    }

    /*
     * This method will be called repeatedly in a loop
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
     */
    @Override
    public void loop() {

        float leftY = gamepad1.left_stick_y;
        float rightY = gamepad1.right_stick_y;
        float scissorArm = -gamepad2.left_stick_y;

        double scissorArmPower = 1/127;
        double drivepower = 1/127;

        scissorArmLeft.setPower(scissorArm * scissorArmPower);
        scissorArmRight.setPower(scissorArm * scissorArmPower);

        leftMotor.setPower(leftY * drivepower);
        rightMotor.setPower(rightY * drivepower);

        telemetry.addData("Status", "Run Time: " + runtime.toString());
    }
}
