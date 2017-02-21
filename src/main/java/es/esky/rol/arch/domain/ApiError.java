/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package es.esky.rol.arch.domain;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.io.Serializable;

/**
 * Store an api error response.
 */
public class ApiError implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String code;
    private final String message;

    /**
     * Construct an api error.
     * @param code    Unique error identification.
     * @param message Message error.
     */
    public ApiError(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Get code error identification.
     *
     * @return Error identification.
     */
    public String getCode() {
        return code;
    }

    /**
     * Get message error.
     *
     * @return Message error.
     */
    public String getMessage() {
        return message;
    }
}
