package com.its.trade.service;

import com.its.trade.DTO.SaleDTO;
import com.its.trade.entity.SaleEntity;
import com.its.trade.entity.SaleFileEntity;
import com.its.trade.repository.SaleFileRepository;
import com.its.trade.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;
    private final SaleFileRepository saleFileRepository;

    public void save(SaleDTO saleDTO) throws IOException {
        if (saleDTO.getSaleFile().get(0).isEmpty()) {
            System.out.println("saleDTO1 = " + saleDTO);
            System.out.println("파일없음");
            SaleEntity saleEntity = SaleEntity.toSaleSaveEntity(saleDTO);
            saleRepository.save(saleEntity);
        } else {
            System.out.println("saleDTO2 = " + saleDTO);
            System.out.println("파일있음");
            SaleEntity saleEntity = SaleEntity.toSaleSaveFileEntity(saleDTO);
            Long result = saleRepository.save(saleEntity).getId();

            Optional<SaleEntity> entity = saleRepository.findById(result);

            for (MultipartFile saleFile : saleDTO.getSaleFile()) {
                String originalFileName = saleFile.getOriginalFilename();
                String storedFileName = System.currentTimeMillis() + "_" + originalFileName;
                String savePath = "D:\\spring_boot_project_img\\" + storedFileName;
                saleFile.transferTo(new File(savePath));

                SaleFileEntity saleFileEntity = SaleFileEntity.toSaveSaleFileEntity(entity.get(), originalFileName, storedFileName);
                saleFileRepository.save(saleFileEntity);
            }
        }
    }

    @Transactional
    public List<SaleDTO> findAll() {
       List<SaleEntity> saleEntityList = saleRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));

       List<SaleDTO> saleDTOList = new ArrayList<>();

       for (SaleEntity saleEntity : saleEntityList) {
           saleDTOList.add(SaleDTO.toSaleDTO(saleEntity));
       }
       return saleDTOList;
    }

    @Transactional
    public void updateHits(Long id) {
        saleRepository.updateHits(id);
    }

    @Transactional
    public SaleDTO findById(Long id) {
        System.out.println("id = " + id);
        Optional<SaleEntity> optionalSaleEntity = saleRepository.findById(id);


        if (optionalSaleEntity.isPresent()) {
            return SaleDTO.toSaleDTO(optionalSaleEntity.get());
        } else {
            return null;
        }
    }


    @Transactional
    public List<SaleDTO> findByWeapon() {
        String weapon = "무기";
        List<SaleEntity> saleEntity = saleRepository.findByItemCategory(weapon,Sort.by(Sort.Direction.DESC,"id"));
        List<SaleDTO> saleDTOList = new ArrayList<>();

        for (SaleEntity sale : saleEntity) {
            saleDTOList.add(SaleDTO.toSaleDTO(sale));
        }

        return saleDTOList;

    }

    @Transactional
    public List<SaleDTO> findByArmor() {
        String armor = "방어구";
        List<SaleEntity> saleEntityList = saleRepository.findByItemCategory(armor,Sort.by(Sort.Direction.DESC, "id"));
        List<SaleDTO> saleDTOList = new ArrayList<>();

        for (SaleEntity saleEntity : saleEntityList) {
            saleDTOList.add(SaleDTO.toSaleDTO(saleEntity));
        }

        return saleDTOList;
    }

    @Transactional
    public List<SaleDTO> findByAccessory() {
        String accessory = "장신구";
        List<SaleEntity> saleEntityList = saleRepository.findByItemCategory(accessory,Sort.by(Sort.Direction.DESC, "id"));
        List<SaleDTO> saleDTOList = new ArrayList<>();

        for (SaleEntity saleEntity : saleEntityList) {
            saleDTOList.add(SaleDTO.toSaleDTO(saleEntity));
        }

        return saleDTOList;
    }
}
