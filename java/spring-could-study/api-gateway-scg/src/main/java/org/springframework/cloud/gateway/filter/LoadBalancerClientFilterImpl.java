package org.springframework.cloud.gateway.filter;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

public class LoadBalancerClientFilterImpl extends LoadBalancerClientFilter {
    public LoadBalancerClientFilterImpl(LoadBalancerClient loadBalancer) {
        super(loadBalancer);
    }
}
