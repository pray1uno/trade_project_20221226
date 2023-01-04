package com.its.trade.service;

import com.its.trade.DTO.SaleDTO;
import com.its.trade.entity.SaleEntity;
import com.its.trade.entity.SaleFileEntity;
import com.its.trade.repository.SaleFileRepository;
import com.its.trade.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
}
