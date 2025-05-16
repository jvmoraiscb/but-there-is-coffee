#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include "config.h"

const int LED_PIN = 2;
const int BUTTON_PIN = 4;
const int GREEN_LED_PIN = 12;
const int RED_LED_PIN = 14;

int buttonState;                            // the current reading from the input pin
int lastButtonState = HIGH;                 // the previous reading from the input pin
bool buttonDown = false;
bool buttonUp = false;
unsigned long lastDebounceTime = 0;         // the last time the output pin was toggled
unsigned long debounceDelay = 50;           // the debounce time

void setup() {
    pinMode(BUTTON_PIN, INPUT_PULLUP);
    pinMode(LED_BUILTIN, OUTPUT);
    pinMode(GREEN_LED_PIN, OUTPUT); 
    pinMode(RED_LED_PIN, OUTPUT); 

    digitalWrite(LED_PIN, HIGH);
    digitalWrite(GREEN_LED_PIN, LOW);
    digitalWrite(RED_LED_PIN, LOW);

    Serial.begin(115200);
    WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
    Serial.print("Connecting...");
    while (WiFi.status() != WL_CONNECTED) {
        digitalWrite(GREEN_LED_PIN , LOW);
        digitalWrite(RED_LED_PIN , HIGH);
        delay(500);
        Serial.print(".");
    }
    digitalWrite(GREEN_LED_PIN , HIGH);
    digitalWrite(RED_LED_PIN , LOW);
    Serial.print("\nConnected to Wi-Fi!\n");

}

void loop() {
    if (WiFi.status() != WL_CONNECTED){
        digitalWrite(GREEN_LED_PIN , LOW);
        digitalWrite(RED_LED_PIN , HIGH);
        Serial.print("Wi-Fi disconnected! Attempting to reconnect...");
        WiFi.disconnect();
        WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
        while (WiFi.status() != WL_CONNECTED){
            delay(500);
            Serial.print(".");
        }
        digitalWrite(GREEN_LED_PIN , HIGH);
        digitalWrite(RED_LED_PIN , LOW);
        Serial.print("\nReconnected!\n");
    }
    else {
        if(isButtonPressed()){
            bool isRequestSent = sendRequest() > 0 ? true : false;
            if(isRequestSent) {
                digitalWrite(LED_PIN, LOW);
                delay(100);
                digitalWrite(LED_PIN, HIGH);
            }
            else {
                digitalWrite(LED_PIN, LOW);
                delay(1000);
                digitalWrite(LED_PIN, HIGH);
            }
        }
    }
}

bool isButtonPressed() {
    buttonDebounce(BUTTON_PIN, &lastButtonState, &lastDebounceTime, &buttonState, &buttonUp, &buttonDown);
    if(buttonDown && buttonUp) {
        buttonDown = false;
        buttonUp = false;
        return true;
    }
    return false;
}

int sendRequest(){
      WiFiClient client;
      HTTPClient http;
      http.begin(client, SERVER_NAME);
      int httpResponseCode = http.GET();
      if (httpResponseCode > 0) {
          Serial.print("HTTP Response code: ");
          Serial.println(httpResponseCode);
      } else {
          Serial.print("Error code: ");
          Serial.println(httpResponseCode);
      }
      http.end();
      return httpResponseCode;
  }

void buttonDebounce(int buttonPin, int *lastButtonState, unsigned long *lastDebounceTime, int *buttonState, bool *buttonUp, bool *buttonDown){
    // read the state of the switch into a local variable:
    int reading = digitalRead(buttonPin);

    // check to see if you just pressed the button
    // (i.e. the input went from LOW to HIGH), and you've waited long enough
    // since the last press to ignore any noise:

    // If the switch changed, due to noise or pressing:
    if (reading != *lastButtonState)
    {
        // reset the debouncing timer
        *lastDebounceTime = millis();
    }

    if ((millis() - *lastDebounceTime) > debounceDelay)
    {
        // whatever the reading is at, it's been there for longer than the debounce
        // delay, so take it as the actual current state:

        // if the button state has changed:
        if (reading != *buttonState)
        {
            *buttonState = reading;

            // only toggle the LED if the new button state is HIGH
            if (*buttonState == HIGH)
            {
                // ledState = !ledState;
                *buttonUp = true;
            }
            if (*buttonState == LOW)
            {
                *buttonDown = true;
            }
        }
    }

    // save the reading. Next time through the loop, it'll be the lastButtonState:
    *lastButtonState = reading;
}
