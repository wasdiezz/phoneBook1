public class Main {
    public static void main(String[] args) throws Exception {
//        Phone phone = new Phone("iPhone XS", PhoneClolors.Red, 15000, 25);
//
//        phone.setBalance(phone.getBalance() + 10);
//
//        System.out.println(phone.getBalance() + " телефонов на складе ");
//
//        System.out.println(phone);

        PhonesStore phonesStore = new PhonesStore();
        phonesStore.addPhone(new Phone("Iphone XS", PhoneClolors.Red, 35000, 25));
        phonesStore.addPhone(new Phone("Iphone XR", PhoneClolors.Yellow, 25000, 15));
        phonesStore.addPhone(new Phone("Iphone 13", PhoneClolors.Red, 45000, 55));

        System.out.println(phonesStore.getPhonesInTableView());

        phonesStore.savePhonesToFile();

    }
}