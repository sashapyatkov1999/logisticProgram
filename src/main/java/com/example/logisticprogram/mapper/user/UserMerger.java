package com.example.logisticprogram.mapper.user;

import com.example.logisticprogram.dto.request.user.UserAddRequest;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMerger implements Merger<User, UserAddRequest> {
    @Override
    public User merge(User target, UserAddRequest source) {
        return target
                .setId(source.getUserId())
                .setName(source.getName())
                .setSurname(source.getSurname())
                .setEmail(source.getEMail())
                .setPhoneNumber(Long.valueOf(source.getPhoneNumber()));
    }
}
