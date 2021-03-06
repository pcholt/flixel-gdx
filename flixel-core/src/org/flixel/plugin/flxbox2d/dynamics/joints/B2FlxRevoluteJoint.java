package org.flixel.plugin.flxbox2d.dynamics.joints;

import org.flixel.plugin.flxbox2d.B2FlxB;
import org.flixel.plugin.flxbox2d.collision.shapes.B2FlxShape;
import org.flixel.plugin.flxbox2d.common.math.B2FlxMath;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;

/**
 * A revolute joint constrains two bodies to share a common point while they 
 * are free to rotate about the point. The relative rotation about the shared 
 * point is the joint angle. You can limit the relative rotation with a joint 
 * limit that specifies a lower and upper angle. You can use a motor to drive 
 * the relative rotation about the shared point. A maximum motor torque is 
 * provided so that infinite forces are not generated.
 *  
 * @author Ka Wing Chin
 */
public class B2FlxRevoluteJoint extends B2FlxJoint
{
	
	/**
	 * Creates a revolute joint.
	 * @param spriteA	The first body.
	 * @param spriteB	The second body.
	 * @param jointDef	The joint definition.
	 */
	public B2FlxRevoluteJoint(B2FlxShape spriteA, B2FlxShape spriteB, RevoluteJointDef jointDef)
	{
		super(spriteA, spriteB, jointDef);
	}
	
	/**
	 * Creates a revolute joint.
	 * @param spriteA	The first body.
	 * @param spriteB	The second body.
	 */
	public B2FlxRevoluteJoint(B2FlxShape spriteA, B2FlxShape spriteB)
	{
		super(spriteA, spriteB, null);
	}
	
	/**
	 * Creates a revolute joint.
	 * @param spriteA	The first body.
	 */
	public B2FlxRevoluteJoint(B2FlxShape spriteA)
	{
		super(spriteA, null, null);
	}

	/**
	 * Creates the jointDef.
	 */
	@Override
	protected void setupJointDef()
	{
		if(jointDef == null)
			jointDef = new RevoluteJointDef();
	}
	
	/**
	 * Set the defaults. If the bodies are null, a static body will be created.
	 */
	@Override
	protected void setDefaults()
	{
		if(bodyA == null)
			bodyA = B2FlxB.getGroundBody(bodyB.getPosition());
		if(bodyB == null)
			bodyB = B2FlxB.getGroundBody(bodyA.getPosition());
		anchorA = bodyA.getWorldCenter();
	}

	/**
	 * Creates the joint.
	 * @return	This joint. Handy for chaining stuff together.
	 */
	@Override
	public B2FlxRevoluteJoint create()
	{
		((RevoluteJointDef)jointDef).initialize(bodyA, bodyB, anchorA);
		joint = B2FlxB.world.createJoint(jointDef);
		return this;
	}
		
	public B2FlxRevoluteJoint setEnableLimit(boolean enableLimit)
	{
		((RevoluteJointDef)jointDef).enableLimit = enableLimit;
		return this;
	}
	
	public B2FlxRevoluteJoint setEnableMotor(boolean enableMotor)
	{
		((RevoluteJointDef)jointDef).enableMotor = enableMotor;
		return this;
	}
	
	public B2FlxRevoluteJoint setMotorSpeed(float motorSpeed)
	{
		((RevoluteJointDef)jointDef).motorSpeed = motorSpeed;
		return this;
	}
	
	public B2FlxRevoluteJoint setMaxMotorTorque(float maxMotorTorque)
	{
		((RevoluteJointDef)jointDef).maxMotorTorque = maxMotorTorque;
		return this;
	}
	
	public B2FlxRevoluteJoint setUpperAngle(float upperAngle)
	{
		((RevoluteJointDef)jointDef).upperAngle = upperAngle * B2FlxMath.DEGRAD;
		return this;
	}
	
	public B2FlxRevoluteJoint setLowerAngle(float lowerAngle)
	{
		((RevoluteJointDef)jointDef).lowerAngle = lowerAngle * B2FlxMath.DEGRAD;
		return this;
	}
	
	@Override
	public RevoluteJoint getJoint(){return (RevoluteJoint)joint;}	
	@Override
	public B2FlxRevoluteJoint setJointDef(JointDef jointDef){super.setJointDef(jointDef);return this;}	
	@Override
	public B2FlxRevoluteJoint setBodyA(Body bodyA){super.setBodyA(bodyA);return this;}	
	@Override
	public B2FlxRevoluteJoint setBodyB(Body bodyB){super.setBodyB(bodyB);return this;}	
	@Override
	public B2FlxRevoluteJoint setAnchorA(Vector2 anchorA){super.setAnchorA(anchorA);return this;}	
	@Override
	public B2FlxRevoluteJoint setAnchorB(Vector2 anchorB){super.setAnchorB(anchorB);return this;}	
	@Override
	public B2FlxRevoluteJoint setCollideConnected(boolean collideConnected){super.setCollideConnected(collideConnected);return this;}
	@Override
	public B2FlxRevoluteJoint setShowLine(boolean showLine){super.setShowLine(showLine);return this;}	
	@Override
	public B2FlxRevoluteJoint setLineThickness(float lineThickness){super.setLineThickness(lineThickness);return this;}	
	@Override
	public B2FlxRevoluteJoint setLineColor(int lineColor){super.setLineColor(lineColor);return this;}	
	@Override
	public B2FlxRevoluteJoint setLineAlpha(float lineAlpha){super.setLineAlpha(lineAlpha);return this;}
	@Override
	public B2FlxRevoluteJoint setSurvive(boolean survive){super.setSurvive(survive);return this;}
}
