package TicTacGame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

// Первое задание – добавить на экран компоновщик-сетку с одним столбцом и
//добавить над существующей кнопкой следующие компоненты в заданном порядке: JLabel с
//заголовком «Выберите режим игры», сгруппированные в ButtonGroup
// переключаемые JRadioButton с указанием режимов «Человек против компьютера» и
//«Человек против человека», JLabel с заголовком «Выберите размеры
// поля», JLabel с заголовком «Установленный размер поля:», JSlider со значениями 3..10,
//JLabel с заголовком «Выберите длину для победы», JLabel с заголовком «Установленная длина:»,
//JSlider со значениями 3..10.

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    public static boolean modeValue = false;
    public static int sizeValue = 3;
    public static int winValue = 3;

    JLabel labelMode = new JLabel("Выберите режим игры: ");
    JRadioButton humanVsHuman = new JRadioButton("Человек против человека", true);
    JRadioButton humanVsCPU = new JRadioButton("Человек против машины", modeValue);

    JLabel labelSize = new JLabel(String.format("Выберите размеры поля: %d", sizeValue));
    JSlider sliderSize = new JSlider(3, 10, sizeValue);

    JLabel labelWin = new JLabel(String.format("Выберите длину для победы: %d", winValue));
    JSlider sliderWin = new JSlider(3, 10, sizeValue);

    JPanel grid = new JPanel(new GridLayout(4, 1));
    ButtonGroup topButtonGroup = new ButtonGroup();

    JPanel top = new JPanel(new GridLayout(2, 1));
    JPanel radioButtons = new JPanel(new GridLayout(2, 1));
    JPanel middle = new JPanel(new GridLayout(2, 1));
    JPanel bottom = new JPanel(new GridLayout(2, 1));

    JButton btnStart = new JButton("Начать игру");

    public SettingsWindow(GameWindow gameWindow) {
        setTitle("Окно настроек");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(gameWindow);

        topButtonGroup.add(humanVsCPU);
        topButtonGroup.add(humanVsHuman);

        radioButtons.add(humanVsHuman);
        radioButtons.add(humanVsCPU);

        top.add(labelMode);
        top.add(radioButtons);

        middle.add(labelSize);
        middle.add(sliderSize);

        bottom.add(labelWin);
        bottom.add(sliderWin);

        grid.add(top);
        grid.add(middle);
        grid.add(bottom);
        grid.add(btnStart);

        add(grid);


        sliderSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sizeValue = sliderSize.getValue();
                labelSize.setText(String.format("Выберите размеры поля: %d", sizeValue));
            }
        });

        sliderWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                winValue = sliderWin.getValue();
                if (winValue > sizeValue) {
                    labelWin.setText("Длина для победы не может быть больше размера поля!");
                } else {
                    labelWin.setText(String.format("Выберите длину для победы: %d", winValue));
                }
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeValue = humanVsHuman.isSelected();
                gameWindow.startNewGame((modeValue) ? 1 : 0, sizeValue, sizeValue, winValue);
                setVisible(false);
            }
        });
    }
}
