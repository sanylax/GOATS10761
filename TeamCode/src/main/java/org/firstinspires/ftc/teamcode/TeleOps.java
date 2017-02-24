/* Rushil is cool and did most of this code. He also made it compile in the first place. :D */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Math;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Demonstrates empty OpModew88
 */
@TeleOp(name = "MullOp: Driver", group = "Teleop")
public class TeleOps extends OpMode {

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
