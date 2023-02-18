package com.example.Library.repository;

import com.example.Library.model.user;

public interface UserRepositoryCustom {
      public boolean userexists(String email);
      public user userexists(String email,String password);
      public user getUser(String email);
}
