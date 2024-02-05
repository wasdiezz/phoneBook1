import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PhonesStore {
    private ArrayList<Phone> phones;

    private final String dbPhonesFileName = "phones.txt";
    public PhonesStore() {
        phones = new ArrayList<>();
    }

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    public Phone getPhoneByNumber(int number) throws Exception {
        int index = number - 1;

        if (index < 0 || index > phones.size() - 1) {
            throw new Exception("Ошибка. Телефона с таким номером не сущ");
        }

        return phones.get(index);

    }    public void  deletePhoneByNumber(int number) throws Exception {
        int index = number - 1;

        if (index < 0 || index > phones.size() - 1) {
            throw new Exception("Ошибка. Телефона с таким номером не сущ");
        }


    }

    public String getPhonesInTableView(){
        String output = " ";

        output = String.format("%3s%20s%15s%15s%17s\n","№","Модель","Цвет","Цена(руб.)","Кол-во на складе");

        for (int i = 0; i < phones.size(); i++) {
            Phone currentPhone = phones.get(i);
            output += String.format("%3d%20s%15s%15d%17d\n", i+1, currentPhone.getModel(), currentPhone.getColor(), currentPhone.getPrice(), currentPhone.getBalance());

            phones.remove(phones);

        }

        return output;
    }

    public void savePhonesToFile() throws Exception {
        FileWriter fileWriter = new FileWriter(dbPhonesFileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(Integer.toString(phones.size()));
        bufferedWriter.newLine();

        for (int i = 0; i < phones.size(); i++) {
            Phone currentPhone = phones.get(i);

            bufferedWriter.write(currentPhone.getModel());
            bufferedWriter.newLine();

            bufferedWriter.write(currentPhone.getColor());
            bufferedWriter.newLine();

            bufferedWriter.write(Integer.toString(currentPhone.getPrice()));
            bufferedWriter.newLine();

            bufferedWriter.write(Integer.toString(currentPhone.getBalance()));
            bufferedWriter.newLine();

            
        }

        bufferedWriter.close();
        fileWriter.close();

    }
}
