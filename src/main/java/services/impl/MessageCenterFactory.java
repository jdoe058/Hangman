package services.impl;

import models.Language;
import services.MessageCenter;

public class MessageCenterFactory {
    private final static MessageCenter ru = new RuMessageCenter();
    private final static MessageCenter en = new EnMessageCenter();

    static public MessageCenter get(Language language) {
        return switch (language) {
            case RU -> ru;
            case EN -> en;
        };
    }
}
