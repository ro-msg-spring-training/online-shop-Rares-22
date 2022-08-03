package ro.msg.learning.shop.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exception.SupplierException;
import ro.msg.learning.shop.model.Supplier;
import ro.msg.learning.shop.repository.ISupplierRepository;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final ISupplierRepository supplierRepository;

    public Supplier findSupplierByName(String name) {
        return supplierRepository.findSupplierByName(name)
                .orElseThrow(() -> new SupplierException("There is no supplier"));
    }

    public Supplier create(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public void deleteAll(){
        supplierRepository.deleteAll();
    }
}
