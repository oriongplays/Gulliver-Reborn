package com.camellias.gulliverreborn.network;

import com.camellias.gulliverreborn.Config;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ConfigSyncPacket implements IMessage {
    public float maxSize;
    public float healthMultiplier;
    public boolean speedModifier;
    public boolean reachModifier;
    public boolean strengthModifier;
    public boolean healthModifier;
    public boolean harvestModifier;
    public boolean jumpModifier;
    public boolean doAdjustedRender;
    public boolean pickupSmallEntities;
    public boolean rideBigEntities;
    public boolean climbSomeBlocks;
    public boolean climbWithSlime;
    public boolean glideWithPaper;
    public boolean hotBlocksGiveLift;
    public boolean rosesHurt;
    public boolean plantsSlowSmallDown;
    public boolean smallInvisible;
    public boolean giantsCrushEntities;
    public boolean scaledFallDamage;

    public ConfigSyncPacket() {}

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeFloat(Config.MAX_SIZE);
        buf.writeFloat(Config.HEALTH_MULTIPLIER);
        buf.writeBoolean(Config.SPEED_MODIFIER);
        buf.writeBoolean(Config.REACH_MODIFIER);
        buf.writeBoolean(Config.STRENGTH_MODIFIER);
        buf.writeBoolean(Config.HEALTH_MODIFIER);
        buf.writeBoolean(Config.HARVEST_MODIFIER);
        buf.writeBoolean(Config.JUMP_MODIFIER);
        buf.writeBoolean(Config.DO_ADJUSTED_RENDER);
        buf.writeBoolean(Config.PICKUP_SMALL_ENTITIES);
        buf.writeBoolean(Config.RIDE_BIG_ENTITIES);
        buf.writeBoolean(Config.CLIMB_SOME_BLOCKS);
        buf.writeBoolean(Config.CLIMB_WITH_SLIME);
        buf.writeBoolean(Config.GLIDE_WITH_PAPER);
        buf.writeBoolean(Config.HOT_BLOCKS_GIVE_LIFT);
        buf.writeBoolean(Config.ROSES_HURT);
        buf.writeBoolean(Config.PLANTS_SLOW_SMALL_DOWN);
        buf.writeBoolean(Config.SMALL_IS_INVISIBLE_TO_NONCATS_OR_NONSPIDERS);
        buf.writeBoolean(Config.GIANTS_CRUSH_ENTITIES);
        buf.writeBoolean(Config.SCALED_FALL_DAMAGE);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.maxSize = buf.readFloat();
        this.healthMultiplier = buf.readFloat();
        this.speedModifier = buf.readBoolean();
        this.reachModifier = buf.readBoolean();
        this.strengthModifier = buf.readBoolean();
        this.healthModifier = buf.readBoolean();
        this.harvestModifier = buf.readBoolean();
        this.jumpModifier = buf.readBoolean();
        this.doAdjustedRender = buf.readBoolean();
        this.pickupSmallEntities = buf.readBoolean();
        this.rideBigEntities = buf.readBoolean();
        this.climbSomeBlocks = buf.readBoolean();
        this.climbWithSlime = buf.readBoolean();
        this.glideWithPaper = buf.readBoolean();
        this.hotBlocksGiveLift = buf.readBoolean();
        this.rosesHurt = buf.readBoolean();
        this.plantsSlowSmallDown = buf.readBoolean();
        this.smallInvisible = buf.readBoolean();
        this.giantsCrushEntities = buf.readBoolean();
        this.scaledFallDamage = buf.readBoolean();
    }

    @SideOnly(Side.CLIENT)
    public static class Handler implements IMessageHandler<ConfigSyncPacket, IMessage> {
        @Override
        public IMessage onMessage(ConfigSyncPacket message, MessageContext ctx) {
            net.minecraft.client.Minecraft.getMinecraft().addScheduledTask(() -> {
                Config.MAX_SIZE = message.maxSize;
                Config.HEALTH_MULTIPLIER = message.healthMultiplier;
                Config.SPEED_MODIFIER = message.speedModifier;
                Config.REACH_MODIFIER = message.reachModifier;
                Config.STRENGTH_MODIFIER = message.strengthModifier;
                Config.HEALTH_MODIFIER = message.healthModifier;
                Config.HARVEST_MODIFIER = message.harvestModifier;
                Config.JUMP_MODIFIER = message.jumpModifier;
                Config.DO_ADJUSTED_RENDER = message.doAdjustedRender;
                Config.PICKUP_SMALL_ENTITIES = message.pickupSmallEntities;
                Config.RIDE_BIG_ENTITIES = message.rideBigEntities;
                Config.CLIMB_SOME_BLOCKS = message.climbSomeBlocks;
                Config.CLIMB_WITH_SLIME = message.climbWithSlime;
                Config.GLIDE_WITH_PAPER = message.glideWithPaper;
                Config.HOT_BLOCKS_GIVE_LIFT = message.hotBlocksGiveLift;
                Config.ROSES_HURT = message.rosesHurt;
                Config.PLANTS_SLOW_SMALL_DOWN = message.plantsSlowSmallDown;
                Config.SMALL_IS_INVISIBLE_TO_NONCATS_OR_NONSPIDERS = message.smallInvisible;
                Config.GIANTS_CRUSH_ENTITIES = message.giantsCrushEntities;
                Config.SCALED_FALL_DAMAGE = message.scaledFallDamage;
            });
            return null;
        }
    }
}
