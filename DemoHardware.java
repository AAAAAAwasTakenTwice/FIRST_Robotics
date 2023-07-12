//I have no clue what I'm supposed to do.
package org.firstinspires.ftc.teamcode.FIRST_Robotics;

//Imports motor thingy, I have not read the documentation yet.
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


//I know how to do this.
public class DemoHardware {

    //What?! I've never done this before!
    public DcMotor demoWheel1;
    //Well, it's a new experience. Let's hope it doesn't get any worse.

    //Wheels,
    public DcMotor demoWheel2;

    //Servo, alright. This is familiar
    public Servo demoServo;

    //Tf is this
    public BNO055IMU gyro;
    //Ohhh, we're getting a gyro from...Arby's? If it were so easy.

    //Low maximum speed, don't want to confuse the driver for the test.
    public static double maxSpeed = 1;

    //WHAT?!
    private static DemoHardware myInstance = null;
    public static DemoHardware getInstance(){

        //What am I doing what am I doing what am I doing
        if (myInstance == null) {
            myInstance = new DemoHardware();
        }
        //Returns something.
        return myInstance;
    }

    //I am doing an absurd amount of comments. Ain't stoppin' now!

    //I haven't a clue what I'm doing.

    //uh oh
    public void init(HardwareMap hwMap) {
        try {
            demoWheel1 = hwMap.get(DcMotor.class,"demoWheel");
            demoWheel1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            demoWheel1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            demoWheel1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            demoWheel1.setPower(0);
        }
        catch(Exception p_exception) {
            demoWheel1 = null;
        }
        //What does 99 percent of this mean???
        try {
            demoWheel2 = hwMap.get(DcMotor.class, "demoWheel");
            demoWheel2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            demoWheel2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            demoWheel2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            demoWheel2.setPower(0);
        }
        catch(Exception p_exception) {
            demoWheel2 = null;
        }
        //Wth am I doing?
        try{
            gyro = hwMap.get(BNO055IMU.class, "gyro");
            BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
            parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
            parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
            parameters.loggingEnabled = true;
            parameters.loggingTag = "gyro";
            parameters.accelerationIntegrationAlgorithm =  new JustLoggingAccelerationIntegrator();
            gyro.initialize(parameters);
            //Brain aneurysm;
        }
        catch (Exception p_exception) {
            gyro = null;
        }
        //Je ne comprends pas.
        try {
            demoServo = hwMap.get(Servo.class, "demoServo");

        } catch (Exception p_exception) {
            demoServo = null;
        }
        //Routes power to the wheels.
    }
    public void setPower(double wheelDemo, double wheelDemo2){
        if (demoWheel1 != null) {
            demoWheel1.setPower(Range.clip(wheelDemo, -maxSpeed, maxSpeed));
        }
        if(demoWheel2 != null){
            demoWheel2.setPower(Range.clip(wheelDemo2, -maxSpeed, maxSpeed));
        }
    }
    //Routes power to the servos. LIKE WE USED ANY HAHAHAHAHA jk
    public void demoServo(double servoDemo){
        if (demoServo != null){
            demoServo.setPosition(servoDemo);
            //Imagine if we used motors for our claw...
        }
    }
}
//If only Bong Water was here to share their wisdom...