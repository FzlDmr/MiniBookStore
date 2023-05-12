import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2-a-ProductService i implement et ve methodlari book'a uygun sekilde doldur
public class BookService implements ProductService{
    //3-booklari saklamak icin list olustur

    List<Book> bookList = new ArrayList<>();


    //4-baslangicta kayitli kitaplar olsun
    public BookService(){//BookService ten bir obje olusturdugumuzda icinde 3 tane kitabimiz baslangicta kayitli olacak
        Book book1 = new Book(1,"Vadideki Zambak","150 Lira",25,"Balzac","Penguin");
        Book book2 = new Book(2,"Suc ve Ceza","150 Lira",12,"Dostoyevski","Penguin");
        Book book3 = new Book(3,"Sefiller","125 Lira",15,"V.Hugo","Dream");

        this.bookList.add(book1);
        this.bookList.add(book2);
        this.bookList.add(book3);
    }

    //5-bookla ilgili islemleri gosteren menu

    @Override
    public void processMenu() {
        Scanner scan = new Scanner(System.in);
        int choise=-1;
        while(choise!=0){
            System.out.println("----------------------------------------------------------");
            System.out.println("1-Kitaplari Listele");
            System.out.println("2-Kitap Ekle");
            System.out.println("3-Kitap Sil");
            System.out.println("4-Yayinevine Gore Filtrele");
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
                    System.out.println("Yayinevi: ");
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
//6-booklari formatla yazdir
    @Override
    public void listProduct() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("%-2s | %-20s | %-15s | %-10s | %-12s | %-5s |\n","ID","Kitap Adi","Yazar Adi","Yayinevi","Birim Fiyat","Stock");
        System.out.println("---------------------------------------------------------------------------------");
        for(Book book:this.bookList){
            System.out.printf("%-2s | %-20s | %-15s | %-10s | %-12s | %-5s |\n",
                    book.getId(),book.getName(),book.getAuthorName(),book.getPublisher(),book.getPrice(),book.getStock());
            System.out.println("---------------------------------------------------------------------------------");
        }
    }
//7-kullanicidan alinan bilgilerle book olustur, listeye ekle
    @Override
    public void addProduct() {
        Scanner scan =new Scanner(System.in);
        System.out.println("Kitap Adi: ");
        String bookName = scan.nextLine();
        System.out.println("Yazar Adi: ");
        String authorName = scan.nextLine();
        System.out.println("Yayinevi: ");
        String pub = scan.nextLine();
        System.out.println("Birim Fiyat: ");
        String price = scan.nextLine();
        System.out.println("Stok: ");
        int stock = scan.nextInt();

        Book newBook = new Book(this.bookList.get(this.bookList.size()-1).getId()+1,bookName,price,stock,authorName,pub);
        this.bookList.add(newBook);
    }

//8-kullanicidan id bilgisini al, id ile booklist ten book'u bul ve listeden kaldir
    @Override
    public void removeProduct() {

        Scanner scan = new Scanner(System.in);
        boolean isExist = true;
        System.out.println("Kitap id: ");
        int id = scan.nextInt();
        for (Book book : this.bookList) {
            if (book.getId() == id) {
                isExist = true;
                this.bookList.remove(book);
                System.out.println("Kitap Silindi.");
                break;
            } else {
                isExist = false;
            }
        }
        if (!isExist) {
            System.out.println("Kitap Bulunamadi");
        }

    }
//9- listedeki tum kitaplarin yayinevine bak, filter ile ayni ise yazdir
    @Override
    public void filterProduct(String filter) {
        for (Book book:this.bookList){
            if(book.getPublisher().equals(filter)){//Penguin
                System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-5s \n",
                        book.getId(),book.getName(),book.getAuthorName(),book.getPublisher(),book.getPrice(),book.getStock());
            }
        }


    }
}
