/**
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
 */
package com.oracle.bmc.core.requests;

import com.oracle.bmc.core.model.*;

@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20160918")
@lombok.Builder(builderClassName = "Builder")
@lombok.Getter
public class UpdateDrgAttachmentRequest {

    /**
     * The OCID of the DRG attachment.
     */
    private String drgAttachmentId;

    /**
     * Details object for updating a `DrgAttachment`.
     */
    private UpdateDrgAttachmentDetails updateDrgAttachmentDetails;

    /**
     * For optimistic concurrency control. In the PUT or DELETE call for a resource, set the `if-match`
     * parameter to the value of the etag from a previous GET or POST response for that resource.  The resource
     * will be updated or deleted only if the etag you provide matches the resource's current etag value.
     *
     */
    private String ifMatch;

    public static class Builder {
        /**
         * Copy method to populate the builder with values from the given instance.
         * @return this builder instance
         */
        public Builder copy(UpdateDrgAttachmentRequest o) {
            drgAttachmentId(o.getDrgAttachmentId());
            updateDrgAttachmentDetails(o.getUpdateDrgAttachmentDetails());
            ifMatch(o.getIfMatch());
            return this;
        }
    }
}
