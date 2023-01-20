package org.launchcode.liftoff_kcb_backend.dto;

import lombok.*;
import org.launchcode.liftoff_kcb_backend.model.Business;

import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessTypeDto {
    private long id;
    private String name;
}
