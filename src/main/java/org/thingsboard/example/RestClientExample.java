package org.thingsboard.example;

import org.thingsboard.rest.client.RestClient;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.relation.EntityRelation;

public class RestClientExample {
    public static void main(String[] args) {
        // ThingsBoard REST API URL
        String url = "http://localhost:8080";

        // Default Tenant Administrator credentials
        String username = "tenant@thingsboard.org";
        String password = "tenant";

        // Creating new rest client and auth with credentials
        RestClient client = new RestClient(url);
        client.login(username, password);

        // Creating an Asset
        Asset asset = new Asset();
        asset.setName("Building 1");
        asset.setType("building");
        asset = client.saveAsset(asset);

        // creating a Device
        Device device = new Device();
        device.setName("Thermometer 1");
        device.setType("thermometer");
        device = client.saveDevice(device);

        // creating relations from device to asset
        EntityRelation relation = new EntityRelation();
        relation.setFrom(asset.getId());
        relation.setTo(device.getId());
        relation.setType("Contains");
        client.saveRelation(relation);
    }
}
