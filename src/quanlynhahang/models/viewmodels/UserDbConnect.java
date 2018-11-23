package quanlynhahang.models.viewmodels;

public class UserDbConnect {
    private String username;
    private String password;
    private String hostName;
    private String port;
    private boolean isAdmin;

    public UserDbConnect() {
    }

    public UserDbConnect(String username, String password, String hostName, String port, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.hostName = hostName;
        this.port = port;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
