/**
 * 従業員クラス
 *
 * @author sato
 * @version 1.0.0
 */
public class Employee {

    /**
     * 名前
     */
    private String name;

    /**
     * 勤続年数
     */
    private int lengthOfService;

    /**
     * コンストラクタ
     *
     * @param name            名前
     * @param lengthOfService 勤続年数
     */
    public Employee(String name, int lengthOfService) {
        this.name = name;
        this.lengthOfService = lengthOfService;
    }

    /**
     * 名前の取得
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 勤続年数の取得
     *
     * @return
     */
    public int getLengthOfService() {
        return lengthOfService;
    }
}
