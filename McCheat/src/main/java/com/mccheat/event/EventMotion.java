package com.mccheat.event;
public class EventMotion {
    public double x, y, z;
    public float yaw, pitch;
    public boolean onGround;
    public boolean cancelled;
    public EventMotion(double x, double y, double z, float yaw, float pitch, boolean onGround) {
        this.x = x; this.y = y; this.z = z;
        this.yaw = yaw; this.pitch = pitch; this.onGround = onGround;
    }
}
