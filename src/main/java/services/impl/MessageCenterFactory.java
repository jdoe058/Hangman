package services.impl;

import models.Language;
import services.MessageCenter;

public class MessageCenterFactory {
    static public MessageCenter get(Language language) {
        return switch (language){
            case RU, EN -> new RuMessageCenter();
        };
    }
}
