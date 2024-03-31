package whitekim.mybatisblog.global.entity;

public class PageBoardList<T> {
    T data;
    int offset;
    int size;

    int totalCount;
    int totalSize;

    public PageBoardList(T data, int offset, int size) {
        this.data = data;
        this.offset = offset;
        this.size = size;
    }


}
