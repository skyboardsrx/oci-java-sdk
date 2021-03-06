/**
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
 */
package com.oracle.bmc;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Factory class to create new {@link Service} instances.
 * <p>
 * This serves to ensure conflicting definitions of services
 * don't get created.
 */
public class Services {

    private static final Map<String, Service> SERVICE_CACHE = new HashMap<>();

    /**
     * Create a new service definition.  If the service has already been registered
     * with different values, an IllegalArgumentException will be raised.  If the
     * service has already been registered, the existing definition will be returned.
     *
     * @param serviceName The unique service name.
     * @param serviceEndpointPrefix The endpoint prefix.
     * @return A Service instance.
     */
    public static synchronized Service create(
            final String serviceName, final String serviceEndpointPrefix) {
        if (SERVICE_CACHE.containsKey(serviceName)) {
            Service existing = SERVICE_CACHE.get(serviceName);
            if (existing.getServiceEndpointPrefix().equals(serviceEndpointPrefix)) {
                return existing;
            }
            throw new IllegalArgumentException(
                    String.format(
                            "Cannot redefine service '%s' with with new endpoint prefix '%s', already set to '%s'",
                            serviceName,
                            serviceEndpointPrefix,
                            existing.getServiceEndpointPrefix()));
        }
        Service newInstance = new BasicService(serviceName, serviceEndpointPrefix);
        SERVICE_CACHE.put(serviceName, newInstance);
        return newInstance;
    }

    @RequiredArgsConstructor
    @Getter
    @ToString
    private static final class BasicService implements Service {
        private final String serviceName;
        private final String serviceEndpointPrefix;
    }
}
