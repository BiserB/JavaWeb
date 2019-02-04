package metube.services;

import metube.models.binding.UserBindingModel;

public class UserService {

    public boolean registerUser(UserBindingModel model){

        String password = model;

        String sha256hex = DigestUtils.sha256Hex(originalString);
    }
}
