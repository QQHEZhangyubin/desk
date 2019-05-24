package qiqihaer.desk.www.entity;

public class ExerciseDataQuery {
    private int numid;
    private String xuehao;
    private String name;
    private String cardId;
    private String d;//刷卡具体时间

    private String isvalid;


    public int getNumid() {
        return numid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumid(int numid) {
        this.numid = numid;
    }

    public String getXuehao() {
        return xuehao;
    }

    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid;
    }

}
