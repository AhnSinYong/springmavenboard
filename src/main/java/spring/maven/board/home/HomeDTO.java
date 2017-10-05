package spring.maven.board.home;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by ahnsy on 2017-10-04.
 */
public class HomeDTO implements Serializable{
    private String usr_id;
    private int usr_lv;
    private String usr_addr;
    private String usr_name;
    private String usr_tel;

    public String getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }

    public int getUsr_lv() {
        return usr_lv;
    }

    public void setUsr_lv(int usr_lv) {
        this.usr_lv = usr_lv;
    }

    public String getUsr_addr() {
        return usr_addr;
    }

    public void setUsr_addr(String usr_addr) {
        this.usr_addr = usr_addr;
    }

    public String getUsr_name() {
        return usr_name;
    }

    public void setUsr_name(String usr_name) {
        this.usr_name = usr_name;
    }

    public String getUsr_tel() {
        return usr_tel;
    }

    public void setUsr_tel(String usr_tel) {
        this.usr_tel = usr_tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HomeDTO)) return false;
        HomeDTO homeDTO = (HomeDTO) o;
        return usr_lv == homeDTO.usr_lv &&
                Objects.equals(usr_id, homeDTO.usr_id) &&
                Objects.equals(usr_addr, homeDTO.usr_addr) &&
                Objects.equals(usr_name, homeDTO.usr_name) &&
                Objects.equals(usr_tel, homeDTO.usr_tel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usr_id, usr_lv, usr_addr, usr_name, usr_tel);
    }

    @Override
    public String toString() {
        return "HomeDTO{" +
                "usr_id='" + usr_id + '\'' +
                ", usr_lv=" + usr_lv +
                ", usr_addr='" + usr_addr + '\'' +
                ", usr_name='" + usr_name + '\'' +
                ", usr_tel='" + usr_tel + '\'' +
                '}';
    }
}
