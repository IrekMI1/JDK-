package Seminar2.Developers;

public class Main {
    /*
    Описать команду разработчиков. В команде разработчиков могут находиться бэкендеры,
    которые в состоянии писать серверный код, фронтендеры, которые могут программировать экранные формы,
    и фуллстэк разработчики, совмещающие в себе обе компетенции.
    Реализовать класс фулстэк разработчика, создать экземпляр и последовательно вызвать
    все его методы.
    Дописать третье задание таким образом, чтобы в идентификатор типа Developer записывался объект Frontender,
    и далее вызывался метод developGUI(), не изменяя существующие интерфейсы, только код основного класса.

     */
    public static void main(String[] args) {
        Developer dev1 = new FrontEndDeveloper();
        Developer dev2 = new FullStackProgrammer();

        if (dev1 instanceof FrontEndDeveloper) {
            ((FrontEndDeveloper) dev1).developGUI();
        }

        if (dev2 instanceof FullStackProgrammer) {
            ((FullStackProgrammer) dev2).writeBackEndCode();
        }
    }
}
