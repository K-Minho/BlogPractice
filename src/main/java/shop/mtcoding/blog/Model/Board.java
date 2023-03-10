package shop.mtcoding.blog.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.blog.util.DateUtil;

@Getter
@Setter
public class Board {
    private int id;
    private String title;
    private String content;
    private int userId;
    private Timestamp createdAt;

    public String getCreatedAtToString() {
        return DateUtil.format(createdAt);
    }
}
