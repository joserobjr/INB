package io.inb.api.network.pipeline

import com.flowpowered.network.ConnectionManager
import com.flowpowered.network.session.Session
import io.inb.api.server.Server
import io.inb.api.network.NetworkSession
import io.inb.api.network.SessionRegistry
import io.inb.api.server.InbServer
import io.netty.channel.Channel

/**
 * Manages the connections within the netty channels
 */
class InbConnectionManager(
	private val sessionRegistry: SessionRegistry
) : ConnectionManager {

	override fun sessionInactivated(session: Session) {
		sessionRegistry.remove(session as NetworkSession)
	}

	override fun newSession(c: Channel): Session {
		val session = NetworkSession(c)
		sessionRegistry.add(session)
		return session
	}

	override fun shutdown() {
		sessionRegistry.clearSessions()
	}

}
