package com.COVINOC.USER.Services.Pagination;

import com.COVINOC.USER.Models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PageUser {

    public Page<User>USER_PAGE(Pageable pageable);
}
