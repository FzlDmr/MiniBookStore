import java.util.Scanner;

public class MiniBookStore {
    public static void main(String[] args) {

        enter();
    }


    //1-product(butun urunlerin ortak ozellikleri tasiyan class), book, notebook classlari olustur.
    private static void enter() {
        //10-kategori menu
        Scanner scan = new Scanner(System.in);
        System.out.println("===========MINI BOOK STORE===============");
        int select =-1;
        while(select!=0){
            System.out.println("Urun Yonetim Paneli");
            System.out.println("1-Kitaplar");
            System.out.println("2-Defterler");
            System.out.println("0-Cikis");
            System.out.println("Seciminiz: ");
            select=scan.nextInt();
            //ProductService'i referans alarak service olustur
            ProductService service = select == 1 ? new BookService() : new NotebookService();//if-else ile de yapabilirdik

            //select==1 -> BookService service = new BookService();
            //select==2 -> NotebookService service2 = new NotebookService();  yerine

            //select==1 -> ProductService service = new BookService();
            //select==2 -> ProductService service = new NotebookService();  bu sekilde kullandik

            if(select==1 || select==2){
                service.processMenu();
            } else if (select==0) {
                System.out.println("Iyi Gunler....");
            }else{
                System.out.println("Hatali Giris...");
            }
        }


    }
}
