package org.firstinspires.ftc.teamcode.FIRST_Robotics;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp (name = "TeleOp")
public class DemoT extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    DemoHardware robot = DemoHardware.getInstance();

    public void runOpMode(){
        robot.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        if (robot.demoWheel1 != null ) {
            robot.demoWheel1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        }
        if(robot.demoWheel2 != null){
            robot.demoWheel2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        }
        DemoHardware.maxSpeed = 1;
        waitForStart();

        boolean pressinga = false;
        while(opModeIsActive()){
            double movement = gamepad1.left_stick_y;
            double turning = -gamepad1.right_stick_x;

            double left = movement + turning;
            double right =  movement - turning;
            double max = Math.max(Math.abs(left), Math.abs(right));
            if (max > 1.0) {
                left /= max;
                right /=  max;

            }
            robot.demoWheel1.setPower(left);
            robot.demoWheel2.setPower(right);

            if (gamepad1.a && !pressinga ){
                pressinga = true;
            } else if (!gamepad1.a) {
                pressinga = false;
            }

        }

    }

}
