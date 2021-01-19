package jp.ac.uryukyu.ie.e205756;
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
            hot.input();
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
            ice.input();
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

    /**
     * inputメソッド
     * メニュー番号の入力でドリンクの値段を指定し、金額を入力させる
     */
    public void input(){
        try{
            System.out.println("メニュー番号を入力下さい！"); 
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            System.out.println(drinks.get(command-1).price+"円になります");
            System.out.println("金額を入力下さい！");        
            int money = scanner.nextInt(); 
            var m = new Money(money); 
            m.output(drinks.get(command-1).price , drinks.get(command-1).name);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("※そのメニュー番号はございません！");
            returnInput(); 
        }
    }

    /**
     * returnInputメソッド
     * メニュー番号で存在しない番号の入力の際に、再度入力させる
     */
    public void returnInput(){
        input();
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

    /**
     * inputメソッド
     * メニュー番号の入力でドリンクの値段を指定し、金額を入力させる
     */
    public void input(){
        try{
            System.out.println("メニュー番号を入力下さい！"); 
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            System.out.println(drinks.get(command-1).price+"円になります");
            System.out.println("金額を入力下さい！");        
            int money = scanner.nextInt(); 
            var m = new Money(money); 
            m.output(drinks.get(command-1).price , drinks.get(command-1).name);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("※そのメニュー番号はございません！");
            returnInput(); 
        }
    }

    /**
     * returnInputメソッド
     * メニュー番号で存在しない番号の入力の際に、再度入力させる
     */
    public void returnInput(){
        input();
    }
}

/**
 * Moneyクラス
 * 入力した金額で購入を完了させ、おつりまで表示させる
 */
class Money{

    private int commandInput;
    private int change;

    Money(int commandInput){
        this.commandInput = commandInput;
    }

    /**
     * outputメソッド
     * 入力した金額で購入を完了させ、おつりまで表示させる
     * @param p 指定したドリンクの値段
     * @param n 指定したドリンクの名前
     */
    public void output(int p , String n){
        if(commandInput >= p){
            change = commandInput - p;
            System.out.println(n+"を購入しました");
            System.out.println("おつりは" + change + "円");
        }
        else{
            change = p - commandInput;
            System.out.println("※" + change + "円足りません！");
            returnOutput(commandInput , p , n);
        }
    }

    /**
     * returnOutputメソッド
     * 入力した金額が足りていない際に、買える金額になるまで入力させる
     * @param co 入力した金額
     * @param pri 指定したドリンクの値段
     * @param na 指定したドリンクの名前
     */
    public void returnOutput(int co , int pri , String na){
        System.out.println("金額を加えて下さい！");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        var mo = new Money(co+command);
        mo.output(pri , na);
    }
}