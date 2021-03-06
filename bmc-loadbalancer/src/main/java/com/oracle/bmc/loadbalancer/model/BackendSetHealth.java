/**
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
 */
package com.oracle.bmc.loadbalancer.model;

/**
 * The health status details for a backend set.
 * <p>
 * This object does not explicitly enumerate backend servers with a status of `OK`. However, they are included in the
 * `totalBackendCount` sum.
 *
 **/
@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20170115")
@lombok.Value
@com.fasterxml.jackson.databind.annotation.JsonDeserialize(builder = BackendSetHealth.Builder.class)
public class BackendSetHealth {
    @com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder(withPrefix = "")
    @lombok.experimental.Accessors(fluent = true)
    @lombok.Setter
    public static class Builder {
        @com.fasterxml.jackson.annotation.JsonProperty("criticalStateBackendNames")
        private java.util.List<String> criticalStateBackendNames;

        @com.fasterxml.jackson.annotation.JsonProperty("status")
        private Status status;

        @com.fasterxml.jackson.annotation.JsonProperty("totalBackendCount")
        private Integer totalBackendCount;

        @com.fasterxml.jackson.annotation.JsonProperty("unknownStateBackendNames")
        private java.util.List<String> unknownStateBackendNames;

        @com.fasterxml.jackson.annotation.JsonProperty("warningStateBackendNames")
        private java.util.List<String> warningStateBackendNames;

        public BackendSetHealth build() {
            return new BackendSetHealth(
                    criticalStateBackendNames,
                    status,
                    totalBackendCount,
                    unknownStateBackendNames,
                    warningStateBackendNames);
        }

        @com.fasterxml.jackson.annotation.JsonIgnore
        public Builder copy(BackendSetHealth o) {
            return criticalStateBackendNames(o.getCriticalStateBackendNames())
                    .status(o.getStatus())
                    .totalBackendCount(o.getTotalBackendCount())
                    .unknownStateBackendNames(o.getUnknownStateBackendNames())
                    .warningStateBackendNames(o.getWarningStateBackendNames());
        }
    }

    /**
     * Create a new builder.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * A list of backend servers that are currently in the `CRITICAL` health state. The list identifies each backend server by
     * IP address and port.
     * <p>
     * Example: `1.1.1.1:80`
     *
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("criticalStateBackendNames")
    @javax.validation.Valid
    @javax.validation.constraints.NotNull
    java.util.List<String> criticalStateBackendNames;
    /**
     * Overall health status of the backend set.
     * <p>
     *  **OK:** All backend servers in the backend set return a status of `OK`.
     * <p>
     *  **WARNING:** Half or more of the backend set's backend servers return a status of `OK` and at least one backend
     * server returns a status of `WARNING`, `CRITICAL`, or `UNKNOWN`.
     * <p>
     *  **CRITICAL:** Fewer than half of the backend set's backend servers return a status of `OK`.
     * <p>
     *  **UNKNOWN:** More than half of the backend set's backend servers return a status of `UNKNOWN`, the system was
     * unable to retrieve metrics, or the backend set does not have a listener attached.
     *
     **/
    @lombok.extern.slf4j.Slf4j
    public enum Status {
        Ok("OK"),
        Warning("WARNING"),
        Critical("CRITICAL"),
        Unknown("UNKNOWN"),

        /**
         * This value is used if a service returns a value for this enum that is not recognized by this
         * version of the SDK.
         */
        UnknownEnumValue(null);

        private final String value;
        private static java.util.Map<String, Status> map;

        static {
            map = new java.util.HashMap<>();
            for (Status v : Status.values()) {
                if (v != UnknownEnumValue) {
                    map.put(v.getValue(), v);
                }
            }
        }

        Status(String value) {
            this.value = value;
        }

        @com.fasterxml.jackson.annotation.JsonValue
        public String getValue() {
            return value;
        }

        @com.fasterxml.jackson.annotation.JsonCreator
        public static Status create(String key) {
            if (map.containsKey(key)) {
                return map.get(key);
            }
            LOG.warn(
                    "Received unknown value '{}' for enum 'Status', returning UnknownEnumValue",
                    key);
            return UnknownEnumValue;
        }
    };
    /**
     * Overall health status of the backend set.
     * <p>
     *  **OK:** All backend servers in the backend set return a status of `OK`.
     * <p>
     *  **WARNING:** Half or more of the backend set's backend servers return a status of `OK` and at least one backend
     * server returns a status of `WARNING`, `CRITICAL`, or `UNKNOWN`.
     * <p>
     *  **CRITICAL:** Fewer than half of the backend set's backend servers return a status of `OK`.
     * <p>
     *  **UNKNOWN:** More than half of the backend set's backend servers return a status of `UNKNOWN`, the system was
     * unable to retrieve metrics, or the backend set does not have a listener attached.
     *
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("status")
    @javax.validation.Valid
    @javax.validation.constraints.NotNull
    Status status;

    /**
     * The total number of backend servers in this backend set.
     * <p>
     * Example: `5`
     *
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("totalBackendCount")
    @javax.validation.Valid
    @javax.validation.constraints.NotNull
    Integer totalBackendCount;

    /**
     * A list of backend servers that are currently in the `UNKNOWN` health state. The list identifies each backend server by
     * IP address and port.
     * <p>
     * Example: `1.1.1.5:80`
     *
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("unknownStateBackendNames")
    @javax.validation.Valid
    @javax.validation.constraints.NotNull
    java.util.List<String> unknownStateBackendNames;

    /**
     * A list of backend servers that are currently in the `WARNING` health state. The list identifies each backend server by
     * IP address and port.
     * <p>
     * Example: `1.1.1.7:42`
     *
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("warningStateBackendNames")
    @javax.validation.Valid
    @javax.validation.constraints.NotNull
    java.util.List<String> warningStateBackendNames;
}
