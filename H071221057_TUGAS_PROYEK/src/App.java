import java.util.Scanner;
import com.config.MyConfig;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int choice;

        System.out.println("--------------------------------");
        System.out.println("WELCOME TO ......");
        System.out.println("--------------------------------");
        System.out.println("1. Read Data");
        System.out.println("2. Insert Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Delete Data");
        System.out.println("--------------------------------");

        while (true) {
            System.out.print("Pilih: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    readData();
                    break;
                case 2:
                    insertData();
                    break;
                case 3:
                    editData();
                    break;
                case 4:
                    deleteData();
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
                    break;
            }
        }
    }

    public static void readData() {
        MyConfig myConfig = new MyConfig();
        myConfig.connection();
        myConfig.getDatabase();
    }

    public static void insertData() {
        MyConfig myConfig = new MyConfig();
        myConfig.insertData();
    }


    public static void editData() {
        MyConfig myConfig = new MyConfig();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan ID data yang akan diubah: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan nilai baru untuk NAMA: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan nilai baru untuk POWER: ");
        int harga = scanner.nextInt();
        
        System.out.print("Masukkan nilai baru untuk DEFENSE: ");
        int jumlah = scanner.nextInt();
        
        myConfig.editData(id, nama, harga, jumlah);
        
        scanner.close();
    }

    public static void deleteData() {
        MyConfig myConfig = new MyConfig();
        myConfig.deleteData();
    }
}