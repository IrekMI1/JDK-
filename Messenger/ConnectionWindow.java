package Messenger;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ConnectionWindow extends JFrame {
    public LogHandler logHandler;
    private static final int WINDOW_WIDTH = 460;
    private static final int WINDOW_HEIGHT = 570;

    JPanel grid = new JPanel(new GridLayout(9, 1));
    JLabel loginLabel = new JLabel("Введите логин:");
    JTextField loginField = new JTextField();
    JLabel passLabel = new JLabel("Введите пароль:");
    JTextField passField = new JTextField();
    JLabel IPLabel = new JLabel("Введите IP-адрес сервера:");
    JTextField IPField = new JTextField();
    JLabel portLabel = new JLabel("Введите номер порта:");
    JTextField portField = new JTextField();

    JButton connectBtn = new JButton("Подключить");

    public ConnectionWindow(String logPath) throws IOException {
        logHandler = new LogHandler(logPath);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setVisible(true);
        setTitle("Подключение к серверу");

        grid.setBorder(new EmptyBorder(10, 10, 10, 10) {
        });

        grid.add(loginLabel);
        grid.add(loginField);
        grid.add(passLabel);
        grid.add(passField);
        grid.add(IPLabel);
        grid.add(IPField);
        grid.add(portLabel);
        grid.add(portField);
        grid.add(connectBtn);

        add(grid);

        connectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ChatWindow(loginField.getText(), IPField.getText(), logHandler);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                setVisible(false);
            }
        });
    }
}
