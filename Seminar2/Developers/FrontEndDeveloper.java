package Seminar2.Developers;

public class FrontEndDeveloper extends Developer implements FrontEndProgramming {

    @Override
    public void writeFrontEndCode() {
        System.out.println("Пишет фронтэнд");
    }

    @Override
    void developGUI() {
        System.out.println("Пишет графическй интерфейс");
    }
}
