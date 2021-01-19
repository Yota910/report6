import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    /**
     * mainメソッド
     * Solverクラスを起動させる
     * @param args
     */
    public static void main(String[] args){
        var s = new Solver();
        s.input();
    }
}

/**
 * Solverクラス
 * 「hot」か「ice」を選択し、選択したメニューをHotクラスかIceクラスに追加する
 */
class Solver {

    ArrayList<String> warmth = new ArrayList<>();

    Solver(){
        warmth.add("hot");
        warmth.add("ice");
    }

    /**
     * inputメソッド
     * 「hot」か「ice」を選択し、選択したメニューをHotクラスかIceクラスに追加する
     */
    public void input(){   
        var hot = new Hot(warmth.get(0));
        var ice = new Ice(warmth.get(1));
        System.out.printf("「%s」か「%s」で入力下さい！\n" , warmth.get(0) , warmth.get(1));
        Scanner scanner = new Scanner(System.in);
        String warmthInput = scanner.nextLine();
        if(warmthInput.equals(warmth.get(0))){
            hot.menue(new Hot(1,"ホットコーヒー",120));
            hot.menue(new Hot(2,"ホットココア",100));
            hot.menue(new Hot(3,"ホットミルク",90));
            hot.menue(new Hot(4,"ホットヨーグルト",130));
            hot.menue(new Hot(5,"お茶",90));
            hot.menue(new Hot(6,"じっくりコトコト",140));
            hot.menue(new Hot(7,"オニオンスープ",150));
            hot.menue(new Hot(8,"ホットレモン",110));
            hot.menue(new Hot(9,"みそ汁",100));
            hot.menue(new Hot(10,"おしるこ",120));
        }
        else if(warmthInput.equals(warmth.get(1))){
            ice.menue(new Ice(1,"オレンジジュース",100));
            ice.menue(new Ice(2,"コカ・コーラ",110));
            ice.menue(new Ice(3,"ミルクティー",120));
            ice.menue(new Ice(4,"麦茶",100));
            ice.menue(new Ice(5,"ポカリスエット",100));
            ice.menue(new Ice(6,"三ツ矢サイダー",120));
            ice.menue(new Ice(7,"カルピスウォーター",110));
            ice.menue(new Ice(8,"アセロラジュース",130));
            ice.menue(new Ice(9,"エナジードリンク",210));
            ice.menue(new Ice(10,"ヤクルト",90));
        }
        else{
            System.out.println("※「hot」か「ice」でお選び下さい！");
            returnInput();
        }    
    } 
    
    /**
     * returnInputメソッド
     * 選択肢で誤った入力の際に、再度入力させる
     */
    public void returnInput(){
        input();
    }
}

/**
 * Hotクラス
 * 各々のHotドリンクをメニュー番号で指定し、金額を入力させる
 */
class Hot{

    private String mainName;
    private int number;
    private String name;
    private int price;
    ArrayList<Hot> drinks = new ArrayList<>();

    Hot(String mainName){
        this.mainName=mainName;
    }

    Hot(int number , String name , int price){
        this.name = name;
        this.price = price;
        this.number = number;
        System.out.printf("%d.%s:%d円\n" , number , name , price);
    }

    /**
     * menueメソッド
     * 各々のドリンクの情報をリストに追加する
     * @param drink 各々のドリンクの情報
     */
    public void menue(Hot drink){
        drinks.add(drink);
    }
}

/**
 * Iceクラス
 * 各々のIceドリンクをメニュー番号で指定し、金額を入力させる
 */
class Ice{

    private String mainName;
    private int number;
    private String name;
    private int price;
    ArrayList<Ice> drinks = new ArrayList<>();

    Ice(String mainName){
        this.mainName = mainName;
    }

    Ice(int number , String name , int price){
        this.name = name;
        this.price = price;
        this.number = number;
        System.out.printf("%d.%s:%d円\n" , number , name , price);
    }

    /**
     * menueメソッド
     * 各々のドリンクの情報をリストに追加する
     * @param drink 各々のドリンクの情報
     */
    public void menue(Ice drink){
        drinks.add(drink);
    }
}