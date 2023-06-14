//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.8
//
// <auto-generated>
//
// Generated from file `CoffeMach.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package servicios;

public interface BrokerServicePrx extends com.zeroc.Ice.ObjectPrx
{
    default void registerServer(ServerSubscriberPrx subscriber)
    {
        registerServer(subscriber, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void registerServer(ServerSubscriberPrx subscriber, java.util.Map<String, String> context)
    {
        _iceI_registerServerAsync(subscriber, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> registerServerAsync(ServerSubscriberPrx subscriber)
    {
        return _iceI_registerServerAsync(subscriber, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> registerServerAsync(ServerSubscriberPrx subscriber, java.util.Map<String, String> context)
    {
        return _iceI_registerServerAsync(subscriber, context, false);
    }

    /**
     * @hidden
     * @param iceP_subscriber -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_registerServerAsync(ServerSubscriberPrx iceP_subscriber, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "registerServer", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeProxy(iceP_subscriber);
                 }, null);
        return f;
    }

    default void registerClient(ClientSubscriberPrx subscriber)
    {
        registerClient(subscriber, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void registerClient(ClientSubscriberPrx subscriber, java.util.Map<String, String> context)
    {
        _iceI_registerClientAsync(subscriber, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> registerClientAsync(ClientSubscriberPrx subscriber)
    {
        return _iceI_registerClientAsync(subscriber, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> registerClientAsync(ClientSubscriberPrx subscriber, java.util.Map<String, String> context)
    {
        return _iceI_registerClientAsync(subscriber, context, false);
    }

    /**
     * @hidden
     * @param iceP_subscriber -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_registerClientAsync(ClientSubscriberPrx iceP_subscriber, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "registerClient", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeProxy(iceP_subscriber);
                 }, null);
        return f;
    }

    default void receiveUpdate(ClientSubscriberPrx subscriber)
    {
        receiveUpdate(subscriber, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void receiveUpdate(ClientSubscriberPrx subscriber, java.util.Map<String, String> context)
    {
        _iceI_receiveUpdateAsync(subscriber, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> receiveUpdateAsync(ClientSubscriberPrx subscriber)
    {
        return _iceI_receiveUpdateAsync(subscriber, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> receiveUpdateAsync(ClientSubscriberPrx subscriber, java.util.Map<String, String> context)
    {
        return _iceI_receiveUpdateAsync(subscriber, context, false);
    }

    /**
     * @hidden
     * @param iceP_subscriber -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_receiveUpdateAsync(ClientSubscriberPrx iceP_subscriber, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "receiveUpdate", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeProxy(iceP_subscriber);
                 }, null);
        return f;
    }

    default void sendAlarm(AlarmaServicePrx alarmaService)
    {
        sendAlarm(alarmaService, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void sendAlarm(AlarmaServicePrx alarmaService, java.util.Map<String, String> context)
    {
        _iceI_sendAlarmAsync(alarmaService, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> sendAlarmAsync(AlarmaServicePrx alarmaService)
    {
        return _iceI_sendAlarmAsync(alarmaService, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> sendAlarmAsync(AlarmaServicePrx alarmaService, java.util.Map<String, String> context)
    {
        return _iceI_sendAlarmAsync(alarmaService, context, false);
    }

    /**
     * @hidden
     * @param iceP_alarmaService -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_sendAlarmAsync(AlarmaServicePrx iceP_alarmaService, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "sendAlarm", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeProxy(iceP_alarmaService);
                 }, null);
        return f;
    }

    default void unregisterClient(ClientSubscriberPrx subscriber)
    {
        unregisterClient(subscriber, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void unregisterClient(ClientSubscriberPrx subscriber, java.util.Map<String, String> context)
    {
        _iceI_unregisterClientAsync(subscriber, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> unregisterClientAsync(ClientSubscriberPrx subscriber)
    {
        return _iceI_unregisterClientAsync(subscriber, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> unregisterClientAsync(ClientSubscriberPrx subscriber, java.util.Map<String, String> context)
    {
        return _iceI_unregisterClientAsync(subscriber, context, false);
    }

    /**
     * @hidden
     * @param iceP_subscriber -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_unregisterClientAsync(ClientSubscriberPrx iceP_subscriber, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "unregisterClient", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeProxy(iceP_subscriber);
                 }, null);
        return f;
    }

    default void unregisterServer(ServerSubscriberPrx subscriber)
    {
        unregisterServer(subscriber, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void unregisterServer(ServerSubscriberPrx subscriber, java.util.Map<String, String> context)
    {
        _iceI_unregisterServerAsync(subscriber, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> unregisterServerAsync(ServerSubscriberPrx subscriber)
    {
        return _iceI_unregisterServerAsync(subscriber, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> unregisterServerAsync(ServerSubscriberPrx subscriber, java.util.Map<String, String> context)
    {
        return _iceI_unregisterServerAsync(subscriber, context, false);
    }

    /**
     * @hidden
     * @param iceP_subscriber -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_unregisterServerAsync(ServerSubscriberPrx iceP_subscriber, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "unregisterServer", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeProxy(iceP_subscriber);
                 }, null);
        return f;
    }

    default void _notify()
    {
        _notify(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void _notify(java.util.Map<String, String> context)
    {
        _iceI_notifyAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> notifyAsync()
    {
        return _iceI_notifyAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> notifyAsync(java.util.Map<String, String> context)
    {
        return _iceI_notifyAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_notifyAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "notify", null, sync, null);
        f.invoke(false, context, null, null, null);
        return f;
    }

    default void subscribe(ClientSubscriberPrx subscriber)
    {
        subscribe(subscriber, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void subscribe(ClientSubscriberPrx subscriber, java.util.Map<String, String> context)
    {
        _iceI_subscribeAsync(subscriber, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> subscribeAsync(ClientSubscriberPrx subscriber)
    {
        return _iceI_subscribeAsync(subscriber, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> subscribeAsync(ClientSubscriberPrx subscriber, java.util.Map<String, String> context)
    {
        return _iceI_subscribeAsync(subscriber, context, false);
    }

    /**
     * @hidden
     * @param iceP_subscriber -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_subscribeAsync(ClientSubscriberPrx iceP_subscriber, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "subscribe", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeProxy(iceP_subscriber);
                 }, null);
        return f;
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static BrokerServicePrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), BrokerServicePrx.class, _BrokerServicePrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static BrokerServicePrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), BrokerServicePrx.class, _BrokerServicePrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static BrokerServicePrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), BrokerServicePrx.class, _BrokerServicePrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static BrokerServicePrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), BrokerServicePrx.class, _BrokerServicePrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static BrokerServicePrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, BrokerServicePrx.class, _BrokerServicePrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static BrokerServicePrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, BrokerServicePrx.class, _BrokerServicePrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default BrokerServicePrx ice_context(java.util.Map<String, String> newContext)
    {
        return (BrokerServicePrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default BrokerServicePrx ice_adapterId(String newAdapterId)
    {
        return (BrokerServicePrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default BrokerServicePrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (BrokerServicePrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default BrokerServicePrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (BrokerServicePrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default BrokerServicePrx ice_invocationTimeout(int newTimeout)
    {
        return (BrokerServicePrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default BrokerServicePrx ice_connectionCached(boolean newCache)
    {
        return (BrokerServicePrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default BrokerServicePrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (BrokerServicePrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default BrokerServicePrx ice_secure(boolean b)
    {
        return (BrokerServicePrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default BrokerServicePrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (BrokerServicePrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default BrokerServicePrx ice_preferSecure(boolean b)
    {
        return (BrokerServicePrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default BrokerServicePrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (BrokerServicePrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default BrokerServicePrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (BrokerServicePrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default BrokerServicePrx ice_collocationOptimized(boolean b)
    {
        return (BrokerServicePrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default BrokerServicePrx ice_twoway()
    {
        return (BrokerServicePrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default BrokerServicePrx ice_oneway()
    {
        return (BrokerServicePrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default BrokerServicePrx ice_batchOneway()
    {
        return (BrokerServicePrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default BrokerServicePrx ice_datagram()
    {
        return (BrokerServicePrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default BrokerServicePrx ice_batchDatagram()
    {
        return (BrokerServicePrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default BrokerServicePrx ice_compress(boolean co)
    {
        return (BrokerServicePrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default BrokerServicePrx ice_timeout(int t)
    {
        return (BrokerServicePrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default BrokerServicePrx ice_connectionId(String connectionId)
    {
        return (BrokerServicePrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default BrokerServicePrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (BrokerServicePrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::servicios::BrokerService";
    }
}
