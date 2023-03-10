/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.seatunnel.connectors.seatunnel.pulsar.source.enumerator.cursor.start;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.PulsarClientException;

/** This cursor would left pulsar start consuming from a specific timestamp. */
public class TimestampStartCursor implements StartCursor {
    private static final long serialVersionUID = 5170578885838095320L;

    private final long timestamp;

    public TimestampStartCursor(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public void seekPosition(Consumer<?> consumer) throws PulsarClientException {
        consumer.seek(timestamp);
    }
}
