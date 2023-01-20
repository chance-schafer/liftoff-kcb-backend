package org.launchcode.liftoff_kcb_backend.dto;

import lombok.*;
import org.launchcode.liftoff_kcb_backend.model.Role;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private int id;
    private String username;
}
