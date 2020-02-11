package com.apache.iot.mqtt
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.{IMqttDeliveryToken, MqttCallback, MqttClient, MqttMessage}
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence

object MQTTSubscriber {
  def main(args: Array[String]): Unit = {


    try {
      val client = new MqttClient("tcp://iot.eclipse.org:1883", "Sending")
      client.connect
      client.setCallback(MqttCallback)
      client.subscribe("prem240992MQTT Examples")
      val message = new MqttMessage
      message.setPayload("A single message from my computer fff".getBytes)
      //client.publish("foo", message)
    } catch {
      case e: MqttException =>
        e.printStackTrace()
    }

  }
}
