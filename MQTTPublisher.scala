package com.apache.iot.mqtt

import org.eclipse.paho.client.mqttv3.{MqttClient, MqttConnectOptions, MqttException, MqttMessage}
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence


object MQTTPublisher {
  def main(args: Array[String]): Unit = {

    val topic: String = "prem240992MQTT Examples"
    val content: String = "Message from MqttPublishSample"
    val qos: Int = 2
    val broker: String = "tcp://iot.eclipse.org:1883"
    val clientId: String = "Prem2492"
    val persistence: MemoryPersistence = new MemoryPersistence

    try {
      val sampleClient: MqttClient = new MqttClient(broker, clientId, persistence)
      val connOpts: MqttConnectOptions = new MqttConnectOptions
      connOpts.setCleanSession(true)
      System.out.println("Connecting to broker: " + broker)
      sampleClient.connect(connOpts)
      System.out.println("Connected")
      System.out.println("Publishing message: " + content)
      val message: MqttMessage = new MqttMessage(content.getBytes)
      message.setQos(qos)
      sampleClient.publish(topic, message)
      System.out.println("Message published")
      sampleClient.disconnect()
      System.out.println("Disconnected")
      System.exit(0)
    } catch {
      case me: MqttException =>
        System.out.println("reason " + me.getReasonCode)
        System.out.println("msg " + me.getMessage)
        System.out.println("loc " + me.getLocalizedMessage)
        System.out.println("cause " + me.getCause)
        System.out.println("excep " + me)
        me.printStackTrace()
    }
  }
}

