/*
 * Copyright (c) 2018 Red Hat, Inc. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.bot.gerrit;

import com.google.gerrit.extensions.common.ChangeInfo;
import com.google.gerrit.extensions.restapi.RestApiException;
import com.urswolfer.gerrit.client.rest.GerritAuthData;
import com.urswolfer.gerrit.client.rest.GerritRestApi;
import com.urswolfer.gerrit.client.rest.GerritRestApiFactory;
import java.net.URI;
import java.util.List;

/**
 * Gerrit client.
 *
 * @author Michael Vorburger.ch
 */
public class Gerrit {

    private final GerritRestApi gerritApi;

    public Gerrit(URI gerritBaseURI) {
        GerritRestApiFactory gerritRestApiFactory = new GerritRestApiFactory();
        GerritAuthData.Basic authData = new GerritAuthData.Basic(gerritBaseURI.toString());
        // or: authData = new GerritAuthData.Basic("https://example.com/gerrit", "user", "password");
        gerritApi = gerritRestApiFactory.create(authData);
    }

    public List<ChangeInfo> allChangesOnTopic(String topicName) throws RestApiException {
        // .withOption(ListChangesOption...)
        return gerritApi.changes().query("topic:" + topicName).get();
    }

}