@file:JsQualifier("isc")
package isc

/**
 *  The Real-Time Messaging module creates a channel for messages to be sent from the server to
 *   the client (a.k.a. "server push") in real-time (as opposed to periodically polling the
 *   server for updates).
 * 
 *   See messaging for information.
 */
open external class Messaging : Class {
    companion object {
        /**
         *  URL where the MessagingServlet has been installed. See the server-side JavaDoc for
         *   details on the MessagingServlet.
         *  @type {URL}
         *  @default "[ISOMORPHIC]/messaging"
         */
        var messagingURL: String = definedExternally
        /**
         *  URL where the WebSocket endpoint is registered. On the server, the URI of the endpoint
         *   is controled by the server.properties configuration setting
         *   messaging.websocket.URI and defaults to /isomorphic/websocket
         * 
         *   This URL must ultimately start with ws:// or wss://, but you may specify this value as
         *   starting with http:// or https:// and it will be automatically converted to ws(s)://
         *  @type {URL}
         *  @default "[ISOMORPHIC]/websocket"
         */
        var websocketURL: String = definedExternally
        /**
         *  Whether to attempt to use the WebSocket protocol for Realtime Messaging. Enabled by
         *   default. You must be running JDK 1.7+ on the server with a container that supports
         *   webSocket (most modern containers do). When enabled, the webSocket protocol is
         *   preferred and tried first, but a failure to initially connect using webSockets causes
         *   the client to fall back to standard http push.
         * 
         *   Because of this fall-back behavior, it is
         *   safe to leave this option enabled unless you know of conditions with your deployments
         *   that will prevent propert functioning of this protocol. One such situation is having
         *   your app server sit behind a reverse proxy that does not handle the webSocket (wss://)
         *   protocol. Certain older firewalls and L4 switches may also disallow it.
         * 
         *   Note that once a successful connection using the webSocket protocol is established, the
         *   protocol is marked as available and will be used until the client browser page is
         *   reloaded (at which point it will again be preferred, but backed off if the initial
         *   connection fails).
         *  @type {boolean}
         *  @default true
         */
        var useWebSocket: Boolean = definedExternally
        /**
         *  Number of milliseconds to wait when initiating a server connection before dropping the
         *   attempt and trying again.
         *  @type {Integer}
         *  @default "10000"
         */
        var websocketConnectTimeout: Number = definedExternally
        /**
         *  Number of milliseconds to wait when initiating a server connection before dropping the
         *   attempt and trying again.
         *  @type {Integer}
         *  @default "4000"
         */
        var connectTimeout: Number = definedExternally
        /**
         *  Creates a new Messaging
         * 
         *  @param typeCheckedProperties {Partial<Messaging>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Messaging} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Messaging = definedExternally
        /**
         *   Send data to one or more channels, by sending the data to the server, where it is expected to
         *   be delivered to any other browser subscribed to the same channel.
         * 
         * 
         *   Data can be any nested structure of primitive types (String, Date, Number) or compound data
         *   structure consisting of Arrays and Objects containing primitive types.
         * 
         * 
         *   The optional callback fires when the message has been successfully sent, or if an error
         *   occurs.
         * 
         * 
         * \* @param {string | Array<Partial<string>>} \* @param {any} \* @param {RPCCallback} 
         */
        fun send(channels: dynamic, data: dynamic, callback: ((response: RPCResponse, rawData: dynamic, request: RPCRequest) -> Unit)): Unit = definedExternally
        /**
         *   Returns an array of identifiers for all currently subscribed channels on this client
         * 
         * 
         */
        fun getSubscribedChannels(): Array<dynamic> = definedExternally
        /**
         *   Subscribes the client to the messaging channel identified by channel.
         * 
         *   When the server or another connected browser sends a message on this channel, the callback
         *   will be invoked with a single 'data' parameter containing the data that was just sent to the
         *   channel.
         * 
         *   Calling subscribe() again for a channel you are already subscribed to will result in the new
         *   callback replacing the old, and will cause the server connection to be re-established.
         * 
         * 
         *  @param {string} \* @param {MessagingCallback} callback fired whenever data is sent to this channel
         *  @param {Callback} callback fired when the subscription is established
         *  @param {string=} JMS selector used with Queues to filter the messages that arrive to the channel (optional).
         */
        fun subscribe(channel: String, callback: ((data: dynamic) -> Unit), subscribeCallback: dynamic, selector: String?): Unit = definedExternally
        /**
         *   Unsubscribes the client from the messaging channel identified by channel.
         * 
         *   This will cause a reconnect to the server - for this reason
         *   we defer the actual reconnect to allow for multiple unsubscribe() calls in sequence.
         * 
         * 
         * \* @param {string} 
         */
        fun unsubscribe(channel: String): Unit = definedExternally
        /**
         *   Returns whether the Messaging system currently has a connection to the server.
         * 
         *   This is not perfectly authoritative since the server may crash at any given instant. This
         *   method will return true if we have opened a connection to the server and the connection has
         *   been successfully acknowledged by the server.
         * 
         * 
         */
        fun connected(): Boolean = definedExternally
        /**
         *   Sever the connection to the server and stop receiving messages.
         * 
         */
        fun disconnect(): Unit = definedExternally
        /**
         *   Called when the messaging connection allowing the server to send messages to the client is
         *   established - whether that's the result of an initial connect() or a re-establishment after
         *   it is severed.
         * 
         */
        fun connectionUp(): Unit = definedExternally
        /**
         *   Called when the messaging connection allowing the server to send messages to the client is
         *   disconnected. This can occur either when you explicitly disconnect the connection or if a
         *   keepalive packet from the server does not arrive on time. This latter is defined as the
         *   messaging.keepaliveInterval plus the messaging.keepaliveReestablishDelay.
         *   With default settings, a maximum of 4 seconds will elapse between the connection actually
         *   going down and you receiving this callback.
         * 
         * 
         */
        fun connectionDown(): Unit = definedExternally
    }
}