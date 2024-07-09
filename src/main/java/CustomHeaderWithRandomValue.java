import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;
import burp.api.montoya.http.message.requests.HttpRequest;
import burp.api.montoya.http.sessions.ActionResult;
import burp.api.montoya.http.sessions.SessionHandlingAction;
import burp.api.montoya.http.sessions.SessionHandlingActionData;

import java.util.UUID;
import java.util.Random;


import static burp.api.montoya.http.sessions.ActionResult.actionResult;

public class CustomHeaderWithRandomValue implements BurpExtension {

    private static final String EXTENSION_NAME = "Custom Header With Random Value";
    private static final String HEADER_NAME = "Uuid"; // You can change this to customise the header name

    @Override
    public void initialize(MontoyaApi api) {
        api.extension().setName(EXTENSION_NAME);

        api.http().registerSessionHandlingAction(new SessionHandlingAction() {
            @Override
            public String name() {
                return "Custom Header Action - Random UUID Value";
            }

            @Override
            public ActionResult performAction(SessionHandlingActionData sessionHandlingActionData) {
                HttpRequest originalRequest = sessionHandlingActionData.request();
                String uuidValue = generateUUID();
                HttpRequest newRequest = originalRequest.withHeader(HEADER_NAME, uuidValue);
                return actionResult(newRequest);
            }

            private String generateUUID() {
                return UUID.randomUUID().toString();
            }
        });

        api.http().registerSessionHandlingAction(new SessionHandlingAction() {
            @Override
            public String name() {
                return "Custom Header Action - Random String Value";
            }
            
            @Override
            public ActionResult performAction(SessionHandlingActionData sessionHandlingActionData) {
                HttpRequest originalRequest = sessionHandlingActionData.request();
                String randomValue = generateRandomValue();
                HttpRequest newRequest = originalRequest.withHeader(HEADER_NAME, randomValue);
                return actionResult(newRequest);
            }

            private String generateRandomValue() {
                int length = 10;
                String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
                Random random = new Random();
                StringBuilder randomValue = new StringBuilder(length);
                for (int i = 0; i < length; i++) {
                    randomValue.append(characters.charAt(random.nextInt(characters.length())));
                }
                return randomValue.toString();
            }
        });
    }
}