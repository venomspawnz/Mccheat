package com.mccheat.event;
import net.minecraft.network.packet.Packet;
public class EventPacket {
    public enum Direction { SEND, RECEIVE }
    public final Packet<?> packet;
    public final Direction direction;
    public boolean cancelled;
    public EventPacket(Packet<?> packet, Direction direction) {
        this.packet = packet; this.direction = direction; this.cancelled = false;
    }
}
