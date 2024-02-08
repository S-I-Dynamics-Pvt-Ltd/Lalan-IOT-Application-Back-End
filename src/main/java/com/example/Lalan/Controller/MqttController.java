package com.example.Lalan.Controller;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Lalan.Entity.DeviceEntity;
import com.example.Lalan.Entity.IOTInputProcessEntity;
import com.example.Lalan.Repos.DeviceRepo;
import com.example.Lalan.Repos.IOTInputProcessRepo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/mqtt")
public class MqttController {

    @Value("${mqtt.broker-url}")
    private String BROKER_URL;

    @GetMapping("/publish")
    public String publishMessage() {
        try {
            String clientId = MqttClient.generateClientId();
            IMqttClient mqttClient = new MqttClient(BROKER_URL, clientId);
            mqttClient.connect();

            String mTopic = "X96HTRK23M";
            String mMessage = "{\"ipadd\":\"0\",\"deviceid\":\"0\",\"type\":\"PStopped\",\"value\":0}";

            //String mMessage = "TEMP";

            mqttClient.publish(mTopic, mMessage.getBytes(), 0, false);

            mqttClient.disconnect();

            return "Message published successfully.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to publish message: " + e.getMessage();
        }
    }

}
