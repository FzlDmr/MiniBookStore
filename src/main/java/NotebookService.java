import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2-a-ProductService i implement et ve methodlari notebook'a uygun sekilde doldur
public class NotebookService implements ProductService{
    List<Notebook> notebookList = new ArrayList<>();

    public NotebookService(){
        Notebook notebook1 = new Notebook(1,"Kareli Defter","40 TL",40,"Mopak","120");
        Notebook notebook2 = new Notebook(2,"Cizgili Defter","35 TL",40,"Gipta","100");
        Notebook notebook3 = new Notebook(3,"Cizgisiz Defter","30 TL",40,"Mopak","150");

        this.notebookList.add(notebook1);
        this.notebookList.add(notebook2);
        this.notebookList.add(notebook3);
    }

    @Override
    public void processMenu() {
        Scanner scan = new Scanner(System.in);
        int choise=1;
        while(choise!=0){
            System.out.println("----------------------------------------------------------");
            System.out.println("1-Defterleri Listele");
            System.out.println("2-Defter Ekle");
            System.out.println("3-Defter Sil");
            System.out.println("4-Markalarina Gore Filtrele");
            System.out.println("0-Ana Menuye Geri Don");
            System.out.println("Seciminiz");
            choise=scan.nextInt();
            switch (choise){
                case 1:
                    listProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    System.out.println("Marka: ");
                    String pub=scan.next();
                    filterProduct(pub);
                    break;
                case 0:
                    System.out.println("Ana Menuye Yonlendiriliyorsunuz.");
                    break;
                default:
                    System.out.println("Hatali Giris...");
                    break;
            }
        }
    }

    @Override
    public void listProduct() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("%-2s | %-20s | %-15s | %-10s | %-12s | %-5s |\n","ID","Defter Adi","Sayfa Sayisi","Marka","Birim Fiyat","Stock");
        System.out.println("----------------------------------------------------------------------------------");
        for(Notebook notebook:this.notebookList){
            System.out.printf("%-2s | %-20s | %-15s | %-10s | %-12s | %-5s |\n",
                    notebook.getId(),notebook.getName(),notebook.getSheet(),notebook.getBrand(),notebook.getPrice(),notebook.getStock());
            System.out.println("----------------------------------------------------------------------------------");
        }

    }

    @Override
    public void addProduct() {
        Scanner scan =new Scanner(System.in);
        System.out.println("Defter Turu: ");
        String notebookType = scan.nextLine();
        System.out.println("Sayfa Sayisi: ");
        String sheet = scan.nextLine();
        System.out.println("Marka: ");
        String brand = scan.nextLine();
        System.out.println("Birim Fiyat: ");
        String price = scan.nextLine();
        System.out.println("Stok: ");
        int stock = scan.nextInt();

        Notebook newNotebook = new Notebook(this.notebookList.get(this.notebookList.size()-1).getId()+1,notebookType,sheet,stock,price,brand);
        this.notebookList.add(newNotebook);

    }

    @Override
    public void removeProduct() {
        Scanner scan = new Scanner(System.in);
        boolean isExist = true;
        System.out.println("Defter id: ");
        int id = scan.nextInt();
        for (Notebook notebook : this.notebookList) {
            if (notebook.getId() == id) {
                isExist = true;
                this.notebookList.remove(notebook);
                System.out.println("Defter Silindi.");
                break;
            } else {
                isExist = false;
            }
        }
        if (!isExist) {
            System.out.println("Defter Bulunamadi");
        }

    }

    @Override
    public void filterProduct(String filter) {
        for (Notebook notebook:this.notebookList){
            if(notebook.getBrand().equals(filter)){//Penguin
                System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-5s \n",
                        notebook.getId(),notebook.getName(),notebook.getPrice(),notebook.getBrand(),notebook.getPrice(),notebook.getStock());
            }
        }

    }
}
