package io.inb.api.network.protocol.codecs.login

import com.flowpowered.network.Codec
import com.flowpowered.network.util.ByteBufUtils
import io.inb.api.network.protocol.message.LoginStartMessage
import io.netty.buffer.ByteBuf

class LoginStartCodec : Codec<LoginStartMessage> {

	override fun decode(buffer: ByteBuf): LoginStartMessage {
		return LoginStartMessage(ByteBufUtils.readUTF8(buffer))
	}

	override fun encode(buf: ByteBuf, message: LoginStartMessage): ByteBuf {
		ByteBufUtils.writeUTF8(buf, message.username)
		return buf
	}
}
