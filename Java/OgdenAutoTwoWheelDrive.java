/*Author: Oscaaa21 & Luis
* Date:7/21/18
*Task: Practice auto code with sensors and servos
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DigitalChannelImpl;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "Auto Drive By Time" , group = "Test")
//@Disabled


public class OgdenAutoTwoWheelDrive extends LinearOpMode {
    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private ElapsedTime runtime = new ElapsedTime ();
    private Servo tail;
    private ColorSensor jewel = null;
    private DigitalChannel digitalTouch;
    
    public void runOpMode (){
        //leftDrive = hardwareMap.get(DcMotor.class, "left drive");
        //rightDrive = hardwareMap.get(DcMotor.class, "right drive");

       // leftDrive.setDirection (DcMotor.Direction.FORWARD);
        //rightDrive.setDirection (DcMotor.Direction.REVERSE);
        tail= hardwareMap.get (Servo.class, "tail");
        jewel= hardwareMap.get(ColorSensor.class, "jewel");
        digitalTouch=hardwareMap.get(DigitalChannel.class,"sensor_digital");
        digitalTouch.setMode(DigitalChannel.Mode.INPUT);
        
        
        waitForStart ();
        runtime.reset ();
        

        while (opModeIsActive ()) {
            jewel.enableLed(true);
            
            double red = jewel.red();
            double blue = jewel.blue();
            double green = jewel.green();
            
            sleep (1000);
            
            if (red > 100){
             
            tail.setPosition(0.1);
            sleep (1000);
            }
            if (blue > 100){
            tail.setPosition (0.9);
            sleep (1000);
            }
            
            
            
            
            
        
 


       /* double power = 0.2;
        for (int i = 1; i<= 4; i++) {
            move (power);
            sleep (5000);
            
            move (0.0);
            sleep (500);
            
            turnLeft ();
            sleep (2000);
            
            move (0.0);
            sleep (500);
            */
        
     /*  if (runtime.seconds()  < 5.0 ){
            move(power);
        }
       else if (runtime.seconds()  < 7.0 ){
            turnLeft ();
        }
        else if (runtime.seconds () < 9.0){
             move (0);
        }
        else if (runtime.seconds () < 14.0) {
            move (power);
        }
        else if (runtime.seconds () < 16.0) {
            move (0);
        }
        else if (runtime.seconds () < 18.0) {
            turnLeft () ;
        }
        else move (0);*/
}
}
public void turnLeft() {
    leftDrive.setPower (-0.2);
    rightDrive.setPower (0.2);
}
    
public void turnRight() {
    leftDrive.setPower (0.2);
    rightDrive.setPower (-0.2);
}
    
public void move(double power) {
    leftDrive.setPower (power);
    rightDrive.setPower (power);
}
}

