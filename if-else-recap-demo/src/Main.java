public class Main {
    public static void main(String[] args) {
        int sayi1 = 20;
        int sayi2 = 9 ;
        int sayi3 = sayi1 - sayi2 ;

        System.out.println(sayi1+sayi2+sayi3);

        if(sayi1<sayi2 && sayi1<sayi3) {
            System.out.println("Sayı 1 En Küçüktür. Sayı : " +sayi1);
        } else if (sayi2<sayi1 && sayi2 < sayi3) {
            System.out.println("Sayi 2 En Küçüktür. Sayı2 = " + sayi2);

        }else {
            System.out.println("Bilemedim.");
        }


    }
}
