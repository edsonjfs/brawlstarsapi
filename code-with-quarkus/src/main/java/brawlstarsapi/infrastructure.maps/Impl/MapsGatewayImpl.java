package brawlstarsapi.infrastructure.maps.Impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import brawlstarsapi.infrastructure.maps.gateways.MapsGateway;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;


@Singleton
public class MapsGatewayImpl {
    private static final Logger LOG = Logger.getLogger(MapsGatewayImpl.class);

    private final MapsGateway mapGateway;

    @Inject
    public MapsGatewayImpl(@RestClient MapsGateway mapGateway) {
        this.mapGateway = mapGateway;
    }
}