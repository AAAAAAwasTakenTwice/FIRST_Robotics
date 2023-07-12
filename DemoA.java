package org.firstinspires.ftc.teamcode.FIRST_Robotics;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "DemoAuto")
public class DemoA extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    DemoHardware robot = DemoHardware.getInstance();

    public void runOpMode(){
       robot.init(hardwareMap);
       telemetry.addData("Status", "Initialized");
       telemetry.update();

       waitForStart();

       //    :O
       move(69, 1);

       //Time based
       runtime.reset();
       while (runtime.seconds() < 3){
           robot.setPower(1, 1);
       }
       runtime.reset();

    }

    public void move(double distanceMoving, double speedMoving) {
        double wheelCircumference = 4 * Math.PI;
        double wheelMotor = 560;
        double ticks = (distanceMoving * (wheelMotor / wheelCircumference));

        robot.setPower(0, 0);

        robot.demoWheel1.setTargetPosition((int) Math.round(ticks));
        robot.demoWheel2.setTargetPosition((int) Math.round(ticks));

        robot.demoWheel1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.demoWheel2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.setPower(speedMoving, speedMoving);

        while (opModeIsActive() && (robot.demoWheel1.getCurrentPosition() + 10 < ticks || robot.demoWheel2.getCurrentPosition() - 10 > ticks)) {

        }
        robot.setPower(0, 0);

        robot.demoWheel1.setMode((DcMotor.RunMode.RUN_USING_ENCODER));
        robot.demoWheel2.setMode((DcMotor.RunMode.RUN_USING_ENCODER));


    }

}
