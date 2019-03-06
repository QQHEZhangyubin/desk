package qiqihaer.desk.www.entitytmp;

import java.util.List;

public class CommentBean {
    private int code;
    private String message;
    private Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data{
        private int total;
        private List<CommentDetailBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<CommentDetailBean> getList() {
            return list;
        }

        public void setList(List<CommentDetailBean> list) {
            this.list = list;
        }
    }
}
