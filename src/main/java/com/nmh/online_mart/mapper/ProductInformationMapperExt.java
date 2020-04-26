package com.nmh.online_mart.mapper;

import com.nmh.online_mart.model.Administrator;
import com.nmh.online_mart.model.ProductInformation;

import java.util.List;

public interface ProductInformationMapperExt {

    List<ProductInformation> selectAllProduction();

    List<ProductInformation> selectAllProductionOrderByModified();
}