package AWS.PROJECT.demo.service;

import AWS.PROJECT.demo.entity.Login;
import AWS.PROJECT.demo.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImple implements LoginService {

    @Autowired
    private LoginRepo saveInfo;

    @Override
    public Login getAttendence(Login login) {
        return  saveInfo.save(login);
    }
}
