package com.blog.blogapp.errorhandling;

import com.blog.blogapp.dto.ErrorReasonDto;
import com.blog.blogapp.exception.ExceptionReason;
import org.mapstruct.Mapper;

@Mapper
public interface ErrorReasonRestMapper {

    ErrorReasonDto toRest(ExceptionReason reason);

}
