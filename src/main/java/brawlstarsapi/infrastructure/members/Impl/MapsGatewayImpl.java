package brawlstarsapi.infrastructure.members.Impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import brawlstarsapi.infrastructure.members.gateways.MembersGateway;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;


@Singleton
public class MapsGatewayImpl {
    private static final Logger LOG = Logger.getLogger(MapsGatewayImpl.class);

    private final MembersGateway mapGateway;

    @Inject
    public MapsGatewayImpl(@RestClient MembersGateway mapGateway) {
        this.mapGateway = mapGateway;
    }
}