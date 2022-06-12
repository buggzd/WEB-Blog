package com.junto.blog2.service;

import com.junto.blog2.po.Type;
import org.apache.juli.logging.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TypeService {
    Type saveType(Type type);

    Type getType(Long id);

    Page<Type> ListType(Pageable pageable);

    Type updateType(Long id,Type type);

    void deletType(Long id);
}
