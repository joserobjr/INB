package io.inb.api.network.protocol.message.play

import com.flowpowered.network.Message
import io.netty.buffer.ByteBuf

data class CustomPayloadMessage(val channel: String,val data: ByteBuf) : Message
