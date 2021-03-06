package io.inb.api.network.protocol.codecs.status

import com.flowpowered.network.Codec
import io.inb.api.network.protocol.message.status.ServerQueryMessage
import io.netty.buffer.ByteBuf

class ServerQueryCodec : Codec<ServerQueryMessage> {
	override fun encode(buf: ByteBuf, message: ServerQueryMessage): ByteBuf {
		return buf;
	}

	override fun decode(buffer: ByteBuf): ServerQueryMessage {
		return ServerQueryMessage();
	}
}
