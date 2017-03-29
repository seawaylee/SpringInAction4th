package test.service;

import org.springframework.stereotype.Service;

/**
 * @author NikoBelic
 * @create 08/03/2017 15:25
 */
@Service
public class UserServiceImpl implements UserService,BaseService
{
    @Override
    public void show() {
        System.out.println("This is UserService.show()....");
    }
}
