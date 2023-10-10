package Messenger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Создать окно клиента чата. Окно должно содержать JtextField для ввода логина, пароля, IP-адреса сервера,
// порта подключения к серверу, область ввода сообщений, JTextArea область просмотра сообщений чата и JButton
// подключения к серверу и отправки сообщения в чат. Желательно сразу сгруппировать компоненты, относящиеся
// к серверу сгруппировать на JPanel сверху экрана, а компоненты, относящиеся к отправке сообщения – на JPanel снизу.

public class ChatWindow extends JFrame {
    private static final int WINDOW_WIDTH = 460;
    private static final int WINDOW_HEIGHT = 570;

    private LogHandler logHandler;

    private String message;
    private String login;
    private String password;
    private String IPAddress;
    private String port;
    private String sessionHistory = "";

    JPanel grid = new JPanel(new GridLayout(5, 1));

    JLabel textLabel = new JLabel("Ведите сообщение");
    JTextArea textArea = new JTextArea();

    JLabel outputTextLabel = new JLabel("История сообщений");
    JTextArea outputTextArea = new JTextArea();

    JButton sendBtn = new JButton("Отправть");

    public ChatWindow(String login, String server, LogHandler logHandler) throws IOException {
        this.login = login;
        this.IPAddress = server;
        this.logHandler = logHandler;

        outputTextArea.setText(logHandler.logRead());

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setVisible(true);
        setTitle("Чат");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        grid.add(textLabel);
        grid.add(textArea);
        grid.add(outputTextLabel);
        grid.add(outputTextArea);
        grid.add(sendBtn);

        add(grid);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    logHandler.logWrite(sessionHistory);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.exit(0);
            }
        });

        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message = textArea.getText();
                String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
                String output = dateTime + "  " + login + ":  " + message + "\n";
                outputTextArea.append(output);
                write(output);
                textArea.setText("");
            }
        });

        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    message = textArea.getText();
                    String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
                    String output = dateTime + "  " + login + ":  " + message + "\n";
                    outputTextArea.append(output);
                    write(output);
                    textArea.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        }
    private void write(String text) {
        StringBuilder sb = new StringBuilder(sessionHistory);
        sb.append(text);
        sessionHistory = sb.toString();
    }
}
