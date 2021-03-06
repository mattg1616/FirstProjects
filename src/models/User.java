package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int id;

    private String username;

    private String nickname;

    public User(ResultSet rs) throws SQLException {
        username = rs.getString("username");
        nickname = rs.getString("nickname");
        id = rs.getInt("id");
    }

    public User(int id, String username, String nickname) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", nickname='" + nickname + '\'' +
               '}';
    }
}
