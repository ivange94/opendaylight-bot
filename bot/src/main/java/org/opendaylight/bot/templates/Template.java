/*
 * Copyright (c) 2018 Red Hat, Inc. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.bot.templates;

import com.google.common.io.Resources;
import java.util.Map;
import org.opendaylight.bot.util.Model;

/**
 * Template with static properties.
 *
 * @author Michael Vorburger.ch
 */
public abstract class Template implements Model<Object> {

    private final String classpathResourceName;

    protected Template(String classpathResourceName) {
        Resources.getResource(classpathResourceName);
        this.classpathResourceName = classpathResourceName;
    }

    public String getResourceName() {
        return classpathResourceName;
    }

    @Override
    public abstract Map<String, Object> getProperties();

}
