package Seminar2.Developers;

public class FullStackProgrammer extends Developer implements BackEndProgramming, FrontEndProgramming {

    @Override
    public void writeBackEndCode() {
        System.out.println("Пишет бекэнд");

    }

    @Override
    public void writeFrontEndCode() {
        System.out.println("Пишет фронтэнд");
    }

    @Override
    void developGUI() {
        System.out.println("Пишет графический интерфейс");
    }
}
