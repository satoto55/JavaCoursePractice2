import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 入力メニューを制御するクラス
 * @author sato
 * @version 1.0.0
 */
public class ConsoleMenu {

    /**
     * 従業員データを保持するリスト
     */
    List<Employee> employeeDataList = new ArrayList<>();

    /**
     * 従業員情報メニュー 入力：1
     */
    public static final String MENU_INPUT = "1";

    /**
     * 従業員情報メニュー 表示：2
     */
    public static final String MENU_PRINT = "2";

    /**
     * 従業員情報メニュー 終了：99
     */
    public static final String MENU_EXIT = "99";

    /**
     * メニューを初期化します
     */
    public void init(){
        String menuNumber;
        while(true){
            try{
                // 選択メニューを表示して入力させる
                menuNumber = this.selectMenu();

                if (menuNumber.equals(ConsoleMenu.MENU_EXIT)){
                    // 99:アプリケーションを終了
                    System.out.println("アプリケーションを終了します");
                    break;
                }

                // メニューを呼び出し
                callMenu(menuNumber);
            }catch(IllegalArgumentException e){

                System.out.println(e.getMessage());
                System.out.println("選択メニューに戻ります");
                System.out.println("------------------------------------------------");
                // メニュー番号が不正な場合はもう一度入力させる
                continue;
            }
        }
    }

    /**
     * 該当のメニュー番号のメニューを呼び出します
     * @param menuNumber メニュー番号
     */
    private void callMenu(String menuNumber) throws IllegalArgumentException{

        if (menuNumber.equals(ConsoleMenu.MENU_INPUT)){
            // 1:入力メニューを呼び出し
            this.inputEmployeeDate();
        }

        if (menuNumber.equals(ConsoleMenu.MENU_PRINT)){
            // 2:従業員情報を表示
            this.printEmployeeDate();
        }

        System.out.println("------------------------------------------------");
    }

    /**
     * メニュー一覧を表示します
     */
    private String selectMenu() throws IllegalArgumentException{
        // 初期メッセージを表示
        System.out.println("従業員情報を管理します");
        System.out.println("1または2を入力してください");
        System.out.println("1：従業員情報を入力");
        System.out.println("2:従業員情報を表示");
        System.out.println("99:アプリケーションを終了");
        System.out.print("メニュー番号を入力：");

        // 値を入力
        String menuNumber = new Scanner(System.in).nextLine();

        System.out.println("------------------------------------------------");

        if (!this.isValidMenuNumber(menuNumber)){
            throw new IllegalArgumentException("メニュー番号は1、2、3のいずれかの値を入力してください");
        }
        return menuNumber;
    }

    /**
     * 従業員情報入力メニューを呼び出します
     */
    private void inputEmployeeDate() throws IllegalArgumentException{
        System.out.println("従業員情報の入力を開始します");

        // 名前を入力する
        System.out.print("名前を入力：");
        String employeeName = new Scanner(System.in).nextLine();

        // 勤続年数を入力する
        System.out.print("勤続年数を入力：");
        String lengthOfService = new Scanner(System.in).nextLine();

        if (!this.isValidLengthOfService(lengthOfService)){

            // 勤続年数が2桁の半角数字ではない場合、エラー
            throw new IllegalArgumentException("勤続年数は0～99の半角数字で入力してください");
        }

        // 値が正常な場合、リストに保存する
        employeeDataList.add(new Employee(employeeName,Integer.valueOf(lengthOfService)));
    }

    /**
     * 従業員情報を表示します
     */
    private void printEmployeeDate(){
        System.out.println("従業員情報を表示します");

        if (this.employeeDataList.size() == 0){
            System.out.println("入力情報は0件です");

            // 表示する情報がないため、終了
            return;
        }

        // リストをループして、入力した情報を表示する
        for (Employee employee : this.employeeDataList){
            System.out.println("名前：" + employee.getName());
            System.out.println("勤続年数：" + employee.getLengthOfService());
        }
    }

    /**
     * 入力されたメニュー番号が妥当な値かチェックします
     * @param menuNumber 入力メニュー番号の入力値
     * @return true:妥当な値 false:不正な値
     */
    public boolean isValidMenuNumber(String menuNumber) {
        if (menuNumber.equals(MENU_INPUT)){
            return true;
        }

        if (menuNumber.equals(MENU_PRINT)){
            return true;
        }

        if (menuNumber.equals(MENU_EXIT)){
            return true;
        }

        // いずれにも当てはまらない場合は、falseを返す
        return false;
    }

    /**
     * 勤続年数が2桁の半角数字かどうかチェックする
     * @param lengthOfService 勤続年数　
     * @return true:妥当な値 false:不正な値
     */
    private boolean isValidLengthOfService(String lengthOfService) {
        return lengthOfService.matches("^[1-9][0-9]?$");
    }
}
