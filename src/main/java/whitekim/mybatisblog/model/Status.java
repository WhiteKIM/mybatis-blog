package whitekim.mybatisblog.model;

public enum Status {
    NOTICE("공지사항"),
    POST("게시글")
    ;

    String code;
    String label;

    Status(String label) {
        this.code = name();
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
