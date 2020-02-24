package org.thingsboard.example;

import org.thingsboard.rest.client.RestClient;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.relation.EntityRelation;

public class RestClientExample {
    public static void main(String[] args) {
        // credentials for thingsboard
        String username = "tenant@thingsboard.org";
        String password = "tenant";

        // url for thingsboard
        String url = "http://localhost:8080";

        // creating new rest client and auth with credentials
        RestClient client = new RestClient(url);
        client.login(username, password);

        // creating and saving asset
        Asset asset = new Asset();
        asset.setName("building_1");
        asset.setType("building");
        asset = client.saveAsset(asset);

        // creating and saving device
        Device device = new Device();
        device.setName("thermometer_1");
        device.setType("thermometer");
        device = client.saveDevice(device);

        // creating relations from device to asset
        EntityRelation relation = new EntityRelation();
        relation.setFrom(device.getId());
        relation.setTo(asset.getId());
        relation.setType("default_relation");
        client.saveRelation(relation);
    }
}
