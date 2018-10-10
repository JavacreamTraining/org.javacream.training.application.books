package org.javacream.store.decorators;

import javax.annotation.Resource;

import org.javacream.audit.api.AuditService;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AuditingStoreService implements StoreService {

	@Resource(name="storeService") private StoreService delegate;
	@Autowired protected AuditService auditService;
		
	public int getStock(String category, String item) {
		auditService.writeAudit("Auditing StoreService, called getStock: category=" + category + ", item=" + item);
		return delegate.getStock(category, item);
	}
}