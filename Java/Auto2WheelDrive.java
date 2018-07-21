package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="CliffAutonomous")

//@Disabled



public class Auto2WheelDrive extends LinearOpMode {
   // private Gyroscope imu;
    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private Servo tail;

  // Declare OpMode members
    private ElapsedTime runtime = new ElapsedTime();
    
    // Here are the turn time variables
    int leglength = 3000; //This sets the drive milliseconds for one side of the square
    int turnlength = 1900; //This sets the turn milleseconds for one corner of the square
    
    @Override
    public void runOpMode() {
        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        tail = hardwareMap.get(Servo.class, "tail");

        
        waitForStart();
        runtime.reset();
        
        while (opModeIsActive()) {
        
            double power = 0.2;

            tail.setPosition(0.1);
            sleep(1000);
            tail.setPosition(0.9);
            sleep(1000);
            stop();
            

            for (int i =1; i<=4; i++) {
                
                //Leg of square
                move(power);
                sleep(leglength);
                
                //Wait a half second
                move(0);
                sleep(500);
                
                //Turn of square
                turnLeft();
                sleep(turnlength);
            
                move(0);
            }
            stop();

/*

            if (runtime.seconds() < 5.0)
                move(power);
            
            else if (runtime.seconds() < 7)
                turnLeft();
                
            else if (runtime.seconds() < 12.0)
                move(power);
            
            else if (runtime.seconds() < 14.0)
                turnLeft();
            
            else if (runtime.seconds() < 19.0)
                move(power);
            
            else if (runtime.seconds() < 21.0)
                turnLeft();

            else if (runtime.seconds() < 26.0)
                move(power);
*/
        }
    
    }
    
    public void turnLeft() {
        leftDrive.setPower(-0.2);
        rightDrive.setPower(0.2);
        //sleep(1000);
        //move(0);
    }
    
    public void turnRight() {
        leftDrive.setPower(0.2);
        rightDrive.setPower(-0.2);
       // sleep(1000);
       // move(0);
    }
    
    public void move (double power) {
        leftDrive.setPower(power);
        rightDrive.setPower(power);
        //sleep(1000);
        //move(0);
    }

  }
