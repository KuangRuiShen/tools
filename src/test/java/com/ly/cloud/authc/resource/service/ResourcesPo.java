package com.ly.cloud.authc.resource.service;

import java.io.Serializable;

public class ResourcesPo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String resourcesId;
    private String uri;
    private String action;
    private String status;
    private String orderNumber;
    private String serviceId;

    public String getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(String resourcesId) {
        this.resourcesId = resourcesId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "ResourcesPo{" +
                "resourcesId='" + resourcesId + '\'' +
                ", uri='" + uri + '\'' +
                ", action='" + action + '\'' +
                ", status='" + status + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", serviceId='" + serviceId + '\'' +
                '}';
    }
}
