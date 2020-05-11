package com.nmh.online_mart.service;

import com.nmh.online_mart.mapper.ProductInformationMapper;
import com.nmh.online_mart.mapper.ProductInformationMapperExt;
import com.nmh.online_mart.model.ProductInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niminui
 * @date 2020/4/24 22:15
 */
@Service
public class ProductionService {

    @Autowired
    private ProductInformationMapper productInformationMapper;

    @Autowired
    private ProductInformationMapperExt productInformationMapperExt;

    public boolean saveProduction(ProductInformation productInformation) {
        int isSuccess = productInformationMapper.insertSelective(productInformation);
        return isSuccess == 1;
    }

    public List<ProductInformation> showProductionList() {
       return productInformationMapperExt.selectAllProduction();
    }

    public boolean updateProductInformation(ProductInformation productInformation) {
        return productInformationMapper.updateByPrimaryKeySelective(productInformation) == 1;
    }

    public List<ProductInformation> showProductionListOrderByGmtModified() {
        return productInformationMapperExt.selectAllProductionOrderByModified();
    }

    public ProductInformation selectProductionById(Long id) {
        return productInformationMapper.selectByPrimaryKey(id);
    }

    public boolean deleteProductionById(Long id) {
        return productInformationMapper.deleteByPrimaryKey(id) == 1;
    }
}
