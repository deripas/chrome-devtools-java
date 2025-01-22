package org.deripas.chrome.devtools.client.transport.factory;

import com.google.common.reflect.Reflection;
import org.deripas.chrome.devtools.client.transport.TransportCDP;
import org.deripas.chrome.protocol.api.Protocol;

public class Factory {

    public Protocol createProtocol(TransportCDP transport) {
        return Reflection.newProxy(
            Protocol.class,
            new ProtocolInvocationHandler(transport, this)
        );
    }

    public Object createDomain(TransportCDP transport, Class<?> domainType) {
        return Reflection.newProxy(
            domainType,
            new DomainInvocationHandler(transport, domainType.getSimpleName())
        );
    }
}
