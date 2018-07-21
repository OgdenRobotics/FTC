
/*Author: Clifton Muhammad
* Date: 7/21/2018
* Task: Practice for motor drive transient
*/


package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@TeleOp (name="Cliff 2 Wheel Drive")
//@Disabled
public class Cliff2WheelDrive_20180721 extends LinearOpMode {

    // Declare OpMode members
    private DcMotor leftDrive=null;
    private DcMotor rightDrive = null;
    
    @Override
    public void runOpMode() {
        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        
        while (opModeIsActive()){
        
            double leftPower;
            double rightPower;
            
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            
            leftPower = Range.clip(drive + turn, -1.0, 1.0);
            rightPower = Range.clip(drive - turn, -1.0, 1.0);
            
            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);
        
        }
    }
    
}
