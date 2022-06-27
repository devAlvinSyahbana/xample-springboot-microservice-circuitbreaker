package tsgitdev.com.inventoryservice.service;

import tsgitdev.com.inventoryservice.dto.InventoryResponse;
import tsgitdev.com.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows // jangan tambahkan pada environment production
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        Thread.sleep(10000); // silumasi thread untuk mengecek fungsi circuit breaker
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).toList();
    }
}