#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include "config.h"

const int LED_PIN = 2;
const int BUTTON_PIN = 4;

int buttonState;                            // the current reading from the input pin
int lastButtonState = HIGH;                 // the previous reading from the input pin
bool buttonDown = false;
bool buttonUp = false;
unsigned long lastDebounceTime = 0;         // the last time the output pin was toggled
unsigned long debounceDelay = 50;           // the debounce time

void setup() {
    Serial.begin(115200);                   // Start serial communication
    WiFi.begin(WIFI_SSID, WIFI_PASSWORD);   // Connect to Wi-Fi
    Serial.print("Connecting...");
    while (WiFi.status() != WL_CONNECTED) {
        delay(500);
        Serial.print(".");
    }
    Serial.println("\nConnected to Wi-Fi!");

    pinMode(BUTTON_PIN, INPUT_PULLUP);      // Initialize the BUTTON_PIN pin as an input
    pinMode(LED_BUILTIN, OUTPUT);           // Initialize the LED_BUILTIN pin as an output
    digitalWrite(LED_PIN, HIGH);
}

void loop() {
    buttonDebounce(BUTTON_PIN, &lastButtonState, &lastDebounceTime, &buttonState, &buttonUp, &buttonDown);
    if(buttonDown && buttonUp){
        if(buttonHandler()) {
            digitalWrite(LED_PIN, LOW);
            delay(100);
            digitalWrite(LED_PIN, HIGH);
        }
        else {
            digitalWrite(LED_PIN, LOW);
            delay(1000);
            digitalWrite(LED_PIN, HIGH);
        }
        buttonDown = false;
        buttonUp = false;
    }
}

bool buttonHandler(){
      bool buttonResponse = false;
      if (WiFi.status() == WL_CONNECTED) {
          WiFiClient client;
          HTTPClient http;
          http.begin(client, SERVER_NAME);
          int httpResponseCode = http.GET();
          if (httpResponseCode > 0) {
              Serial.print("HTTP Response code: ");
              Serial.println(httpResponseCode);
              buttonResponse = true;
          } else {
              Serial.print("Error code: ");
              Serial.println(httpResponseCode);
          }
          http.end(); // Finaliza a requisição
      }
      else {
          Serial.println("WiFi Disconnected");
      }
      return buttonResponse;
}

void buttonDebounce(int buttonPin, int *lastButtonState, unsigned long *lastDebounceTime, int *buttonState, bool *buttonUp, bool *buttonDown)
{
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
