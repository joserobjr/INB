package io.inb.api.network.protocol.codecs.play.inbound

import com.flowpowered.network.Codec
import io.inb.api.network.protocol.message.play.ChatMessage
import io.inb.api.network.utils.ByteUtils
import io.netty.buffer.ByteBuf

class ChatCodec : Codec<ChatMessage> {
	override fun encode(buffer: ByteBuf, message: ChatMessage): ByteBuf {
		ByteUtils.writeString(buffer,message.message)
		return buffer
	}

	override fun decode(buffer: ByteBuf): ChatMessage {
		val json = ByteUtils.readStringFromBuffer(buffer,256)
		return ChatMessage(json)
	}

}
