package org.launchcode.liftoff_kcb_backend.mapper;

import org.launchcode.liftoff_kcb_backend.dto.BusinessDTO;
import org.launchcode.liftoff_kcb_backend.dto.BusinessInfo;
import org.launchcode.liftoff_kcb_backend.model.Business;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Collection;

@Mapper(componentModel = "spring",
        uses = OwnerTypeMapper.class
)
public interface BusinessMapper {

    @BeforeMapping
    // convert the likedBy list to a number count
    default void convertLikedByToCount(Business business, @MappingTarget BusinessDTO businessDTO) {
        // set the number of likes to the size of the likedBy list or zero if null
        businessDTO.setLikes(business.getLikedBy() == null ? 0 : business.getLikedBy().size());
    }

    BusinessDTO modelToDto(Business business);

    Business dtoToModel(BusinessDTO businessDTO);

    BusinessInfo modelToInfo(Business business);

    Business infoToModel(BusinessInfo businessInfo);

    Collection<BusinessDTO> modelsToDtos(Collection<Business> businesses);

    Collection<BusinessInfo> modelsToInfos(Collection<Business> businesses);
}
