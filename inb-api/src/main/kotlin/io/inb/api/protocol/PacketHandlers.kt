package io.inb.api.protocol

import io.inb.api.protocol.handlers.HandshakeHandler
import io.inb.api.protocol.handlers.LoginHandler
import io.inb.api.protocol.packets.HandshakePacket
import io.inb.api.protocol.packets.LoginPacket
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

object PacketHandlers {

	private val handlers: ConcurrentMap<KClass<out Packet>, PacketHandler<*>> = ConcurrentHashMap()

	init {
		register(HandshakePacket::class, HandshakeHandler::class)
		register(LoginPacket::class, LoginHandler::class)
	}

	private fun <T : Packet> register(clazz: KClass<T>, packetHandler: KClass<out PacketHandler<T>>){
		val handler : PacketHandler<T> = packetHandler.createInstance()
		handlers[clazz] = handler
	}

	fun <T : Packet> getHandler(clazz: KClass<T>) : PacketHandler<T>? {
		return handlers[clazz] as PacketHandler<T>?
	}
}