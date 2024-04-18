package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "cat_game_tg_bot"; // имя бота в ТГ
    public static final String TOKEN = "7111142324:AAGKqOsTmtx1HOPPPvhxi83vq8GLAylAqkw"; // токен бота в ТГ

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        // Реализация функционала:
        // 1. отобразим сообщение о начале игры - нужно взломать холодильник
        if (getMessageText().equals("/start")) {
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Взлом холодильника", "step_1_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Взять сосиску! +20 славы", "step_2_btn",
                            "Взять рыбку! +20 славы", "step_2_btn",
                            "Скинуть банку с огурцами! +20 славы", "step_2_btn"));
        }

        // 2. взламываем робот-пылесос
        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT, Map.of("Взлом робота-пылесоса", "step_3_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Отправить робот-пылесос за едой! +30 славы", "step_4_btn",
                            "Покататься на роботе-пылесосе! +30 славы", "step_4_btn",
                            "Убежать от робота-пылесоса! +30 славы", "step_4_btn"));
        }
        // 3. взламываем камеру GoPro
        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT, Map.of("Включить и надеть камеру GoPro", "step_5_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Бегать по крышам и снимать все подряд! +40 славы", "step_6_btn",
                            "Нападать на кошек и снимать их на видео! +40 славы", "step_6_btn",
                            "Нападать из засады на собак! +40 славы", "step_6_btn"));
        }
        // 4. взламываем компьютер
        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            addUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT, Map.of("Взлом компьютера", "step_7_btn"));
        }
        // 5. хвастаемся дворовым котам
        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            addUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT, Map.of("Выйти во двор и похвастаться котам!", "step_8_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            addUserGlory(50);
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT);
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}


//    // 1. Бот возвращает сообщение на команды
//        if (getMessageText().equals("/start")) {
//        sendTextMessageAsync("Привет, будущий программист Валера!"); // две * делают текст "жирным"; две _ делают текст "наклонным"}
//    }
//        if (getMessageText().equals("/bye")) {
//        sendTextMessageAsync("До новых встреч!");
//    }
//    // 2. Бот возвращает сообщения при вводе ключевого слова
//        if (getMessageText().contains("мороженое")) {
//        sendTextMessageAsync("Вкуснятина!!!");
//    }
//    // 3. Бот возвращает изображение при вводе ключевого слова
//        if (getMessageText().contains("картинка")) {
//        sendPhotoMessageAsync("step_8_pic");
//    }
//    // 4. Бот создает кнопки и выводит их при вводе ключевого слова
//        if (getMessageText().contains("кот")) {
//        sendTextMessageAsync("выбери номер кота: ",
//                Map.of("кот 1", "cat 1",
//                        "кот 2", "cat 2"));
//    }
//    // 5. Обрабатываем вывод информации при нажатии кнопок в боте
//        if (getCallbackQueryButtonKey().equals("cat 1")) {
//        sendPhotoMessageAsync("step_1_pic");
//    }
//        if (getCallbackQueryButtonKey().equals("cat 2")) {
//        sendPhotoMessageAsync("step_2_pic");
//    }
//        if (getMessageText().equals("smile")) {
//        var message = getLastSentMessage();
//        editTextMessageAsync(message.getMessageId(), message.getText() + " :) ");
//    }
//}