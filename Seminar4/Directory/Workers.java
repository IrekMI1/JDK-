package Seminar4.Directory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Workers {
    private List<Worker> workersList;

    protected class Worker {
        private int ID;
        private String name;
        private String phone;
        private int experience;

        Worker(int ID, String name, String phone, int experience) {
            this.ID = ID;
            this.name = name;
            this.phone = phone;
            this.experience = experience;
        }

        protected int getID() {
            return ID;
        }

        protected String getName() {
            return name;
        }

        protected String getPhone() {
            return phone;
        }

        protected int getExperience() {
            return experience;
        }

        @Override
        public String toString() {
            return "{" +
                    "ID=" + ID +
                    ", name='" + name +
                    ", phone='" + phone +
                    ", experience=" + experience + '}';
        }
    }

    public Workers() {
        workersList = new ArrayList<>();
    }

    public Workers(int ID, String name, String phone, int experience) {
        this();
        workersList.add(new Worker(ID, name, phone, experience));

    }

    public Workers(List<Worker> workers) {
        this();
        workersList.addAll(workers);
    }

    public void add(int ID, String name, String phone, int experience) {
        workersList.add(new Worker(ID, name, phone, experience));
    }

    public void add(Worker... workers) {
        workersList.addAll(Arrays.asList(workers));

    }

    public String getWorkerByExperience(int experience) {
        List<Worker> workers = new ArrayList<>();
        for (Worker worker : workersList) {
            if (worker.getExperience() == experience) {
                workers.add(worker);
            }
        }
        return workers.isEmpty() ? "Сотрудник не найден." : workers.toString();
    }

    public String getPhoneNumber(String name) {
        List<String> phones = new ArrayList<>();
        for (Worker worker : workersList) {
            if (worker.getName().equals(name)) {
                phones.add(worker.getPhone());
            }
        }
        return phones.isEmpty() ? "Номер телефона не найден." : phones.toString();
    }

    public String getByID(int ID) {
        for (Worker worker : workersList) {
            if (worker.getID() == ID) {
                return worker.toString();
            }
        }
        return "Сотрудник с табельным номером " + ID + " не найден";
    }

    public void printAll() {
        for (Worker worker : workersList) {
            System.out.println(worker.toString());
        }
    }


    public static void main(String[] args) {
        Workers workers = new Workers(14, "Ken", "456839", 5);

        workers.add(47, "Ann", "236987", 4);
        workers.add(92, "Mike", "236987", 4);
        workers.add(36, "Jakob", "987663", 12);
        workers.add(24, "Mike", "690887", 8);
        workers.add(96, "Ken", "456839", 15);
        workers.add(21, "Bill", "365789", 10);

        System.out.println(workers.getWorkerByExperience(4));
        System.out.println(workers.getPhoneNumber("Mike"));
        System.out.println(workers.getByID(2));
        System.out.println();
        workers.printAll();
    }
}
