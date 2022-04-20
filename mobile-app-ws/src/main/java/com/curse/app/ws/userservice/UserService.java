package com.curse.app.ws.userservice;

import com.curse.app.ws.ui.model.request.UserDetailsRequestModel;
import com.curse.app.ws.ui.model.response.UserRest;

public interface UserService {
	
	UserRest createUser(UserDetailsRequestModel userDetails);

}
