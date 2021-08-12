package com.example.userservice.VO;

import com.example.userservice.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseTemplateVO {
    private User user;
    private Department department;
}
