package org.launchcode.liftoff_kcb_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.launchcode.liftoff_kcb_backend.models.BusinessLocation;
import org.launchcode.liftoff_kcb_backend.models.BusinessType;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BusinessDTO {
    private int id;
    private String name;
    private BusinessLocation location;
    private BusinessType type;
    private UserDTO owner;
}
