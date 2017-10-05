package spring.maven.board.board;

import lombok.*;

import java.io.Serializable;

/**
 * Created by ahnsy on 2017-10-04.
 */

@Data
public class BoardDTO implements Serializable {
    private String brd_type;
    private String brd_cd;
    private int docnum;
    private String add_usr_nm;
    private String title;
    private String contents;
    private String attach;
    private String del_conf;
    private int viewcount;
}
