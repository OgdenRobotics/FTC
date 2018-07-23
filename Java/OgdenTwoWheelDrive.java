/*Author: Oscaaa21 & Luis
* Date:7/21/18
*Task: Practice drive code 
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// teleop shows the type of mod and name= will show up on
@TeleOp (name="Ogden Driver" , group="Test")
//@Disabled
public class OgdenTwoWheelDrive extends LinearOpMode {
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
@Override
public void runOpMode () {
    //Intiialize the hardware variable
    leftDrive =hardwareMap.get(DcMotor.class, "left drive") ;
    rightDrive =hardwareMap.get(DcMotor.class, "right drive");
    
    //In order for motor for wheels to move the two motors need to be reversed
    leftDrive.setDirection (DcMotor.Direction.FORWARD);
    rightDrive.setDirection (DcMotor.Direction.REVERSE);
    //boy wait
    waitForStart ();
    
    //run till end
    while (opModeIsActive()) {
        //set ur variable
        double leftpower ;
        double rightpower ;
        
        //choose driving method
        double drive =-gamepad1.left_stick_y ;
        double turn  = gamepad1.right_stick_x ;
        //setting range for the power (of Motors)
        leftpower    = Range.clip(drive+turn, -1.0, 1.0);
        rightpower   =Range.clip (drive-turn, -1.0, 1.0);
        
        leftDrive.setPower(leftpower);
        rightDrive.setPower(rightpower);
        
    }
    

}


}

