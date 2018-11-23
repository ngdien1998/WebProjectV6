package quanlynhahang.models.businessmodels;

import quanlynhahang.models.viewmodels.UserDbConnect;

public class ConnectDbService extends ConnectDatabase {
    public ConnectDbService(UserDbConnect user) {
        super(user);
    }

    public boolean tryConnectToServer() {
        try {
            openConnection();
            closeConnection();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
